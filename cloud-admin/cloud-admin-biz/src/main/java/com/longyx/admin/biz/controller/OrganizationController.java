package com.longyx.admin.biz.controller;

import com.tydic.admin.api.entity.organization.SysOrganization;
import com.tydic.admin.biz.service.organization.OrganizationService;
import com.tydic.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:20
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /**查询组织*/
    @GetMapping("/findOnTree")
    @PreAuthorize("hasAuthority('organization:view')")
    public List<SysOrganization> findOnTree(){
        return organizationService.findOrganizationOnTree();
    }

    /**新增组织*/
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('organization:add')")
    public String save(@RequestBody SysOrganization organization){

        int flag = organizationService.save(organization);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**更新组织信息*/
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('organization:edit')")
    public String update(@RequestBody SysOrganization organization){
        int flag = organizationService.updateOrganization(organization);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }


    /**删除该组织*/
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('organization:delete')")
    public String delete(@RequestBody List<Long> ids){

        int flag = organizationService.deleteOrganizations(ids);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

}

