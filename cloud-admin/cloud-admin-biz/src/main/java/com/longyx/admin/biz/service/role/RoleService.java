package com.longyx.admin.biz.service.role;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.role.RoleResource;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.RoleVo;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.role
 * @ClassName: RoleService
 */
public interface RoleService {


    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    Role getRoleByUserId(Long userId);

    PageResultVo findRoleByPage(RoleVo rolePage);

    String save(Role role);

    String updateRole(Role role);

    int deleteRoles(List<Long> ids);

    List<Resource> findRoleResources(Long roleId);

    Role findRoleById(Long roleId);

    String addRoleResources(List<RoleResource> resources);
}
