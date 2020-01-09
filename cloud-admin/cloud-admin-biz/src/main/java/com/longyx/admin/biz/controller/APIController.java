package com.longyx.admin.biz.controller;

import com.longyx.admin.api.dto.UserDto;
import com.longyx.admin.api.entity.authority.Authority;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.api.vo.UserVo;
import com.longyx.admin.biz.service.authority.AuthorityService;
import com.longyx.admin.biz.service.role.RoleService;
import com.longyx.admin.biz.service.user.UserService;
import com.longyx.common.base.support.ApiResponse;
import com.longyx.common.base.support.BaseController;
import com.longyx.common.security.model.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.controller
 * @ClassName: APIController
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户登录")
public class APIController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/principal")
    @ApiOperation(value = "获取用户信息")
    public ApiResponse getUserInfo() {
        UserDto userDto = new UserDto();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.loadUserByUserId(loginUser.getId());
        UserVo userVo = new UserVo();
        Role role = roleService.getRoleByUserId(loginUser.getId());
        List<Authority> authList = authorityService.findAuthorityByUserId(loginUser.getId());
        List<String> authCodeList = new ArrayList<>();
        List<String> roleCodeList = new ArrayList<>();
        List<String> menuCodeList = new ArrayList<>();
        for (Authority authority : authList) {
            authCodeList.add(authority.getAuthCode());
            menuCodeList.add(authority.getAuthCode());
        }
        roleCodeList.add(role.getRoleCode());
        BeanUtils.copyProperties(user, userVo);
        userDto.setSysUser(userVo);
        userDto.setPermissions(authCodeList);
        userDto.setRoles(roleCodeList);
        userDto.setMenus(menuCodeList);
        return success(userDto);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "登录接口")
    public ApiResponse webLogin(@RequestParam String userName, @RequestParam String password){
        UserVo result = userService.loginByPassword(userName, password);
        if(null != result){
            return success(result);
        }
        return fail("登陆失败");
    }


}
