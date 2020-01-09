package com.longyx.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求不包含authorization，直接拦截不再路由
 * @author Administrator
 */
public class PreSendForwardFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(PreSendForwardFilter.class);

    /**
     * 过滤类型，表示请求在路由之前被过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return 返回的值越大表示优先级越低，越后执行
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 过滤器是否会被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤逻辑
     * @return 过滤结果
     */
    @Override
    public Object run(){

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String host = request.getRemoteHost();
        String method = request.getMethod();
//        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();

        logger.info("send{} request to {}",request.getMethod(),uri);
        if("http://localhost:8976/auth/oauth/authorize".equals(uri)){
            return null;
        }

        Object accessToken = request.getHeader("Authorization");
        if(accessToken == null){
            logger.warn("access token is empty");
            //令zuul过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //设置返回的状态码
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("Authorization token is empty");
            return null;
        }

        logger.info("请求URI：{}，HTTP Method：{}，请求IP：{}", uri, method, host);
        return null;
    }
}



