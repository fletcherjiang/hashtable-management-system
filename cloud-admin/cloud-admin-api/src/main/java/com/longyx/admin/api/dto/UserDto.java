package com.longyx.admin.api.dto;

import com.longyx.admin.api.vo.UserVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.dto
 * @ClassName: UserDto
 */
@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户
     * */
    private UserVo sysUser;
    /**
     * 权限
     * */
    private List<String> permissions;
    /**
     * 角色
     * */
    private List<String> roles;
    /**
     * 菜单
     * */
    private List<String> menus;
}
