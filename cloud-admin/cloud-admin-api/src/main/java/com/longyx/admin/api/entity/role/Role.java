package com.longyx.admin.api.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.entity.role.entity
 * @ClassName: Role
 */
@Data
@NoArgsConstructor
@TableName("sys_role")
@ApiModel(value = "Role",description = "角色设置")
public class Role extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     * @author Mr.Longyx
     * @date 2020/1/4 20:02
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 组织id
     */
    private Long organizationId;

    @JsonIgnore
    private Set<Resource> resourceSet;

}
