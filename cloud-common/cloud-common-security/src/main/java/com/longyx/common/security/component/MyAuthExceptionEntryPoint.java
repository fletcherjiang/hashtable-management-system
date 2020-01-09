package com.longyx.common.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longyx.common.base.enums.MyHttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.component
 * @ClassName: MyAuthExceptionEntryPoint
 * @Description: 自定义Token异常信息, 用于tokan校验失败返回信息, 比如token过期/验证错误
 */
public class MyAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws ServletException {
        MyHttpStatus resultEnum = MyHttpStatus.INVALID_TOKEN;
        Map map = new HashMap();
        map.put("code", resultEnum.getCode());
        map.put("msg", resultEnum.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), map);
        } catch (Exception e) {
            throw new ServletException();
        }
    }
}