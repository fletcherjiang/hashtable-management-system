package com.longyx.admin.api.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.entity.role.entity
 * @ClassName: RoleAuth
 */
@Data
@NoArgsConstructor
@TableName("sys_role_auth")
@ApiModel(value = "RoleAuth",description = "角色权限设置")
public class  RoleAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long authId;


}
