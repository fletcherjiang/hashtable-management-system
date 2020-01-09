package com.longyx.admin.api.entity.notice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.longyx.common.base.enums.NoticeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:14
 */
@Data
@NoArgsConstructor
@TableName("sys_notice")
@ApiModel(value = "Notice",description = "公告管理")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1777127992306946772L;
    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;

    /**是否可用 0：可用 1：不可用*/
    private Integer enable = NoticeEnum.ENABLE.getCode();

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;

}

