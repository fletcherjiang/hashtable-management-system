package com.longyx.common.base.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:00
 */
public class SecurityUtil {
    /**获取用户登录信息*/
    public static Authentication getAuthentication() {
        if(SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("authentication=======>"+authentication);
        return authentication;
    }

    /**获取登录用户名*/
    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal != null) {
                username = principal.toString();
            }
        }
        return username;
    }


}
