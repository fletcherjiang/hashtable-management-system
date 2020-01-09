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
 * @author Mr.Longyx
 * @date 2020年01月04日 17:53
 */
@ToString
@Data
@Accessors(chain = true)
@TableName("role_resource")
@AllArgsConstructor
@NoArgsConstructor
public class RoleResource implements Serializable {
    private static final long serialVersionUID = -5452631711340553526L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("role_id")
    private Long roleId;

    @TableField("resource_id")
    private Long resourceId;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
