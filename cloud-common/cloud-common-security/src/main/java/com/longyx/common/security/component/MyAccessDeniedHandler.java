package com.longyx.common.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longyx.common.base.enums.MyHttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.component
 * @ClassName: MyAccessDeniedHandler
 * @Description: 授权失败处理异常
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        MyHttpStatus resultEnum = MyHttpStatus.UNAUTHORIZED;
        Map map = new HashMap();
        map.put("code", resultEnum.getCode());
        map.put("msg", resultEnum.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(objectMapper.writeValueAsString(map));
    }
}