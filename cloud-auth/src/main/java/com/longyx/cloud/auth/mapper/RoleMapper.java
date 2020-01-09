package com.longyx.cloud.auth.mapper;

import com.longyx.admin.api.entity.role.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: cloud_manage_lyx
 * @author: Mr.Michael
 * @create: 2019-12-21 21:52
 **/
@Repository
public interface RoleMapper {
    List<Role> findRolesByUserId(Long id);
}
