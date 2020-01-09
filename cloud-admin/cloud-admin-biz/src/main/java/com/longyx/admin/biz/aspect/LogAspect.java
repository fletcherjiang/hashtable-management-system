package com.longyx.admin.biz.aspect;

import com.tydic.admin.api.entity.log.Log;
import com.tydic.admin.biz.service.log.LogService;
import com.tydic.common.base.util.HttpUtils;
import com.tydic.common.base.util.SecurityUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:16
 */
@Component
@Aspect
public class LogAspect {
    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.tydic.admin.biz.controller.*.*(..))")
    public void logPointCut(){}


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = null;
        try{
            // 执行方法
            result = point.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }

        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point,long time){
        String username = SecurityUtil.getUsername();
        if(point.getTarget() instanceof LogService) {
            return ;
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log log = new Log();

        //获取请求方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className+"."+methodName+"()");

        //请求的方法参数名称
        Object[] args = point.getArgs();
        //请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = discoverer.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for(int i=0;i<args.length;i++){
                params += " "+paramNames[i]+": "+args[i];
            }
            log.setParams(params);
        }
        //获取Request
        HttpServletRequest request = HttpUtils.getHttpServletRequest();
        //获取IP地址
        log.setIp(request.getRemoteAddr());
        //设置方法名
        log.setUsername(username);
        log.setCreateTime(new Date());
        //设置日志更新时间
        log.setUpdateTime(new Date());
        //设置运行时长
        log.setTimes((int) time);

        //保存日志系统
        logService.save(log);
    }
}

