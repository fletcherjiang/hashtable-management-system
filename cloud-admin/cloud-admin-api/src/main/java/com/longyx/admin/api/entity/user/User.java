package com.longyx.admin.api.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.entity.user.entity
 * @ClassName: User
 */
@Data
@NoArgsConstructor
@TableName("sys_user")
@ApiModel(value = "User",description = "用户设置")
public class User extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 是否删除 (0 是  1否)
     */
    private Integer isDeleted;

    /**
     * 状态 0无效 1有效
     */
    private Integer status;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 组织id 一个用户只有 一个部门
     */
    private Long organizationId;

    /**
     * 公司id
     */
    private Long compId;

    @JsonIgnore
    private List<Role> roleList;

    @JsonIgnore
    private String roleNames;

    @JsonIgnore
    private List<Long> roleIds;

}
