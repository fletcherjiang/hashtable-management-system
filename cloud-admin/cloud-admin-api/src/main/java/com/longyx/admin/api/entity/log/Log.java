package com.longyx.admin.api.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.longyx.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:36
 */
@Data
@NoArgsConstructor
@TableName("sys_api_log")
@ApiModel(value = "Log",description = "日志管理")
public class Log extends BaseBo implements Serializable {

    private static final long serialVersionUID = -2200207635463385713L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 登入用户名
     * @author Mr.Longyx
     * @date 2020/1/4 20:34
     */
    private String username;
    /**
     * 请求url
     */
    private String uri;

    /**
     * 请求方法名
     */
    @TableField("method_name")
    private String methodName;

    /**
     * 请求参数
     * @author Mr.Longyx
     * @date 2020/1/4 20:38
     */
    private String params;
    /**
     * 请求类名
     */
    private String className;

    /**
     * 访问时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 执行方法耗时
     * @author Mr.Longyx
     * @date 2020/1/4 17:42
     */
    private Integer times;

    /**
     * 访问用户ID
     * @author Mr.Longyx
     * @date 2020/1/4 17:43
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 访问ip
     * @author Mr.Longyx
     * @date 2020/1/4 17:44
     */
    private String ip;

    /**
     * 请求方式
     * @author Mr.Longyx
     * @date 2020/1/4 17:44
     */
    private String method;
}

