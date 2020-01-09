package com.longyx.cloud.auth.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 * @author Administrator
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = -9132640267188027377L;
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return this.authority;
    }
}

