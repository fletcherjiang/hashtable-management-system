package com.longyx.admin.biz.controller;

import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.UserVo;
import com.longyx.admin.biz.service.user.UserService;
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
 * @ClassName: UserController
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据用户id获取用户信息")
    public ApiResponse getUserByUserId(@PathVariable Long id) {
        return success(userService.loadUserByUserId(id));
    }

    @GetMapping("/api")
    @ApiOperation(value = "根据用户名获取用户信息")
    public ApiResponse getUserByUserName(@RequestParam String username) {
        return success(userService.loadUserByUserName(username));
    }

    /**分页查询用户信息*/
    @PostMapping("/findPage")
    @PreAuthorize("hasAuthority('user:view')")
    public PageResultVo findPage(@RequestBody UserVo userVo){
        return userService.findUserByPage(userVo);
    }

    /**新增用户*/
    @PreAuthorize("hasAuthority('user:add') AND hasAuthority('user:edit')")
    @PostMapping(value="/save")
    public String save(@RequestBody User user){
        //首先判断是不是超级管理员，如果是超级管理员，不允许修改
        User user1 = userService.findUserById(user.getId());
        if(user != null && GlobalsConstants.ADMIN.equalsIgnoreCase(user.getUsername())){
            return GlobalsConstants.ADMIN_CAN_NOT_DELETE;
        }
        if(user == null){
            //判断新增的用户名是否已经存在
            if(userService.findUserByName(user.getUsername())!=null){
                return GlobalsConstants.USERNAME_ALREADY_EXIST;
            }
        }
        int flag = userService.save(user);
        if(flag == 0){
            return GlobalsConstants.FAIL;
        }
        return GlobalsConstants.SUCCESS;
    }

    /**删除用户信息*/
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:delete')")
    public String delete(@RequestBody List<Long> ids){
        for(Long id:ids){
            User user = userService.findUserById(id);
            if(user != null && GlobalsConstants.ADMIN.equalsIgnoreCase(user.getUsername())){
                return GlobalsConstants.ADMIN_CAN_NOT_DELETE;
            }
        }
        int flag = userService.deleteUser(ids);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }


    /**查询用户信息*/
    @GetMapping("username/{name}")
    @PreAuthorize("hasAuthority('user:view')")
    public User findByUsername(@PathVariable("name") String name){
        User user = userService.findUserByName(name);
        if(user != null){
            return user;
        }
        return null;
    }
}
