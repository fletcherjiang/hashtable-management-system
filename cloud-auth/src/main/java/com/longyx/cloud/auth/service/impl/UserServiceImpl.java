package com.longyx.cloud.auth.service.impl;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.user.User;
import com.longyx.cloud.auth.mapper.UserMapper;
import com.longyx.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 23:20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        User user = userMapper.findUserByName(username);
        if(user!=null){
            getUserRoles(user);
        }
        return user;
    }

    @Override
    public Set<String> findPrivilege(String name) {
        Set<String> perms = new HashSet<>();
        //获取当前用户所拥有的权限
        User user = userMapper.findUserByName(name);
        List<Role> roles = user.getRoleList();
        List<Resource> resources = new ArrayList<>();
        for(Role role:roles){
            resources.addAll(role.getResourceSet());
        }

        for(Resource resource:resources){

            if(resource.getGrant()!=null&&!"".equals(resource.getGrant())){
                perms.add(resource.getGrant());
            }
        }
        return perms;
    }

    private void getUserRoles(User user){
        //获取用户的角色
        StringBuffer sb = new StringBuffer();
        List<Role> roles = user.getRoleList();
        for(Role role:roles){
            sb.append(role.getDescription());
            sb.append(",");
        }
        user.setRoleNames(sb.toString());
    }

}

