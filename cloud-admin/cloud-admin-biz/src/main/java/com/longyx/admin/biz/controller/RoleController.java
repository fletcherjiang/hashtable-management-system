package com.longyx.admin.biz.controller;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.role.RoleResource;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.RoleVo;
import com.longyx.admin.biz.service.role.RoleService;
import com.longyx.common.base.constants.GlobalsConstants;
import com.longyx.common.base.support.ApiResponse;
import com.longyx.common.base.support.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.controller
 * @ClassName: RoleController
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据用户id获取用户角色信息")
    public ApiResponse getRoleByUserId(@PathVariable Long id) {
        return success(roleService.getRoleByUserId(id));
    }


    /**带条件分页查询角色*/
    @PostMapping("/findPage")
    @PreAuthorize("hasAuthority('role:view')")
    public PageResultVo findPage(@RequestBody RoleVo roleVo){
        return roleService.findRoleByPage(roleVo);
    }

    /**删除指定id的角色*/
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('role:delete')")
    public String deleteRole(@RequestBody List<Long> ids){
        int flag = roleService.deleteRoles(ids);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**添加角色*/
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('role:add')")
    public String save(@RequestBody Role role){
        return roleService.save(role);
    }

    /**编辑角色*/
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('role:edit')")
    public String update(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    /**查找某个角色拥有的资源和权限*/
    @GetMapping("/findRoleResources/{id}")
    @PreAuthorize("hasAuthority('role:view')")
    public List<Resource> findRoleResources(@PathVariable("id")Long roleId){
        return roleService.findRoleResources(roleId);
    }

    /**修改角色拥有的权限*/
    @PostMapping("/modify")
    @PreAuthorize("hasAuthority('role:edit')")
    public String modifyGrant(@RequestBody List<RoleResource> roleResources){
        for(RoleResource roleResource:roleResources){
            Role role = roleService.findRoleById(roleResource.getRoleId());
            if(GlobalsConstants.ADMIN.equalsIgnoreCase(role.getRoleName())){
                //如果是超级管理员，不允许修改权限
                return GlobalsConstants.ADMIN_RESOURCE_CAN_NOT_EDIT;
            }
        }
        return roleService.addRoleResources(roleResources);
    }
}
