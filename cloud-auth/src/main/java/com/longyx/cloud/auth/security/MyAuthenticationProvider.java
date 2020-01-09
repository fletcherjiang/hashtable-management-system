package com.longyx.cloud.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Mr.Longyx
 * @date 2019/12/31 15:18
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    /**
     * 注入我们自己定义的用户信息获取对象
     * @author Mr.Longyx
     * @date 2019/12/31 15:19
     */
    @Autowired
    private MyUserDetailsService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 这个获取表单输入中返回的用户名;
        String userName = authentication.getName();
        // 这个是表单中输入的密码；
        String password = (String) authentication.getCredentials();
        // 这里构建来判断用户是否存在和密码是否正确
        MyUserDetails myUserDetails = (MyUserDetails) userDetailService.loadUserByUsername(userName);
        if (myUserDetails == null) {
            throw new BadCredentialsException("用户名不存在");
        }

        if (!myUserDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = myUserDetails.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(myUserDetails, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // return true;表示是支持这个执行
        return true;
    }
}


