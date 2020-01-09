package com.longyx.admin.biz.service.role.impl;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.role.RoleResource;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.RoleVo;
import com.longyx.admin.biz.mapper.role.RoleMapper;
import com.longyx.admin.biz.mapper.role.RoleResourceMapper;
import com.longyx.admin.biz.service.role.RoleService;
import com.longyx.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.role.impl
 * @ClassName: RoleServiceImpl
 * @Date: 2019/11/5 09:28
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private  RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public Role getRoleByUserId(Long userId) {
        return roleMapper.getRoleByUserId(userId);
    }

    @Override
    public PageResultVo findRoleByPage(RoleVo roleVo) {
        int count = roleMapper.queryForNum(roleVo);

        PageResultVo pageResultVo;

        if (count > 0) {

            List<Role> roles = roleMapper.queryForPage(roleVo);

            pageResultVo = new PageResultVo(
                    roles,
                    count,
                    roleVo.getCurrentPage(),
                    roleVo.getPageSize());

        } else {
            pageResultVo = PageResultVo.blank(roleVo.getPageSize());
        }


        return pageResultVo;
    }

    @Override
    public String save(Role role) {
        //表示有要插入的角色
        if (roleMapper.findRoleByRoleName(role.getRoleName()) != null) {
            return GlobalsConstants.ROLE_ALREADY_EXIST;
        } else {
            int flag = roleMapper.addRoleBySelective(role);
            if (flag == 1) {
                return GlobalsConstants.SUCCESS;
            }
        }
        return GlobalsConstants.FAIL;
    }

    @Override
    public String updateRole(Role role) {
        Role role1 = roleMapper.findRoleById(role.getId());
        if (role1 != null) {
            if (GlobalsConstants.ADMIN.equalsIgnoreCase(role1.getRoleName())) {
                return GlobalsConstants.ADMIN_CAN_NOT_EDIT;
            } else {
                int flag = roleMapper.updateRoleBySelective(role);
                if (flag == 1) {
                    return GlobalsConstants.SUCCESS;
                }
            }
        }
        return GlobalsConstants.FAIL;
    }

    @Override
    public int deleteRoles(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            if(id != null){
                roleMapper.deleteRoleById(id);
            }
        }
        return 1;
    }

    @Override
    public List<Resource> findRoleResources(Long roleId) {
        Role role = roleMapper.findRoleById(roleId);

        return (List<Resource>) role.getResourceSet();

    }

    @Override
    public Role findRoleById(Long roleId) {
        return  roleMapper.findRoleByRoleId(roleId);
    }

    @Override
    public String addRoleResources(List<RoleResource> resources) {
        //获取当前角色的ID
        Long roleId = resources.get(0).getRoleId();
        //首先删除原来角色所拥有的资源权限
        roleResourceMapper.deleteRoleResourceByRoleId(roleId);
        for (RoleResource roleResource : resources) {
            //重新插入新的角色权限
            roleResourceMapper.addRoleResourceBySelective(roleResource);
        }
        return GlobalsConstants.SUCCESS;
    }
}
