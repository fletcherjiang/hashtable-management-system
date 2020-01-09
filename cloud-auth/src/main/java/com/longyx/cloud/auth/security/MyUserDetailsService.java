package com.longyx.cloud.auth.security;

import com.longyx.admin.api.entity.user.User;
import com.longyx.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByName(username);


        if(user == null){
            throw new UsernameNotFoundException("该用户不存在");
        }

        //用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = userService.findPrivilege(user.getUsername());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new MyUserDetails(user,grantedAuthorities);

    }
}

