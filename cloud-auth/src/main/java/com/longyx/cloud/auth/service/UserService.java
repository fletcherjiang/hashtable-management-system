package com.longyx.cloud.auth.service;

import com.longyx.admin.api.entity.user.User;

import java.util.Set;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 23:19
 */
public interface UserService {
    User findUserByName(String username);

    Set<String> findPrivilege(String name);
}
