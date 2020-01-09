package com.longyx.admin.api.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色实体
 * @author Mr.Longyx
 * @date 2020年01月04日 17:49
 */
@Data
@Accessors(chain = true)
@TableName("role_organization")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleOrganization implements Serializable {
    private static final long serialVersionUID = 312580004147583753L;
    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("role_id")
    private int roleId;

    @TableField("organization_id")
    private int organizationId;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;

}
