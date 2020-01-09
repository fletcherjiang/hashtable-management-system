package com.longyx.admin.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.vo
 * @ClassName: UserVo
 */
@Data
@NoArgsConstructor
public class UserVo extends PageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
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
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 状态
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


    private String accessToken;
}
