package com.longyx.admin.biz.aspect;

import com.longyx.common.base.util.SecurityUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:18
 */
@Component
@Aspect
public class MapperAspect {

    private final static String CREATEBY = "createBy";

    private final static String CREATETIME = "createTime";

    private final static String UPDATEBY = "updateBy";

    private final static String UPDATETIME = "updateTime";


    @Pointcut("execution(* com.longyx.admin.biz.mapper.*.update*(..))")
    public void update() { }

    @Pointcut("execution(* com.longyx.admin.biz.mapper.*.insert*(..))")
    public void insert() { }


    @Around("update()")
    public Object doAroundUpdate(ProceedingJoinPoint point) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes == null) {
            return point.proceed();
        }

        String username = SecurityUtil.getUsername();
        if (username != null) {
            Object[] objects = point.getArgs();
            if (objects != null && objects.length > 0) {
                for (Object arg : objects) {

                    BeanUtils.setProperty(arg, UPDATEBY, username);
                    BeanUtils.setProperty(arg, UPDATETIME, System.currentTimeMillis());
                }
            }
        }
        return point.proceed();

    }

    @Around("insert()")
    public Object doAroundInsert(ProceedingJoinPoint point) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return point.proceed();
        }
        Object[] objects = point.getArgs();
        if (objects != null && objects.length > 0) {
            for (Object object : objects) {
                String username = SecurityUtil.getUsername();

                if (username != null) {
                    BeanUtils.setProperty(object, CREATEBY, username);
                    BeanUtils.setProperty(object, CREATETIME, System.currentTimeMillis());
                }
            }
        }
        return point.proceed();
    }

}


