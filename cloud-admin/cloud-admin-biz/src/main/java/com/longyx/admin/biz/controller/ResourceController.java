package com.longyx.admin.biz.controller;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.biz.service.resource.ResourceService;
import com.longyx.common.base.constants.GlobalsConstants;
import com.longyx.common.base.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:28
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**查找所有的资源*/
    @GetMapping("/findTree")
    @PreAuthorize("hasAuthority('resource:view')")
    public List<Resource> findTree(){
        //mark为标识，0是查找导航树，1是查找全部
        int mark = 1;
        return resourceService.findResourceOnTree(null,mark);
    }

    /**新增资源权限*/
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('resource:add')")
    public String add(@RequestBody Resource resource){

        int flag = resourceService.save(resource);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**修改资源权限*/
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('resource:edit')")
    public String update(@RequestBody Resource resource){
        int flag = resourceService.update(resource);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**只获取左侧导航， 不获取按钮*/
    @GetMapping("/findNavigationTree")
    @PreAuthorize("hasAuthority('resource:view')")
    public List<Resource> findNavigationTree(){

        String userName = SecurityUtil.getUsername();
        //mark为标识，0是查找导航树，1是查找全部
        int mark = 0;
        return resourceService.findResourceOnTree(userName,mark);

    }

}

