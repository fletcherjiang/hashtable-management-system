package com.longyx.admin.api.entity.resource;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.longyx.common.base.enums.IsDeletedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:45
 */
@Data
@ToString
@Accessors(chain = true)
@TableName("sys_resource")
@AllArgsConstructor
@NoArgsConstructor
public class Resource implements Serializable {
    private static final long serialVersionUID = -1038471200873911610L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("organization_id")
    private Long organizationId;

    private String name;

    @TableField("parent_id")
    private Long parentId;

    private String grant;

    private String type;

    private Integer level;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;

    private List<Resource> children;

    /**
     * 是否已删除 -1删除 0正常
     * @author Mr.Longyx
     * @date 2020/1/4 17:46
     */
    private Integer isDeleted = IsDeletedEnum.NORMAL.getCode();
}

