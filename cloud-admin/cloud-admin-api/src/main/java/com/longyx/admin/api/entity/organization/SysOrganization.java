package com.longyx.admin.api.entity.organization;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.longyx.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.entity.organization
 * @ClassName: Organization
 * @Date: 2019/11/5 10:00
 */
@Data
@NoArgsConstructor
@TableName("sys_dept")
@ApiModel(value = "Organization",description = "部门设置")
public class SysOrganization extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 排序
     */
    private Integer num;

    /**
     * 父部门id
     */
    private Long pid;

    /**
     * 父级ids
     */
    private String pids;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 提示
     */
    private String tips;

    /**
     * 地址
     */
    private String address;

    /**
     * 组织类型(0 公司1部门)
     */
    private Integer organizationType;

    @JsonIgnore
    private List<SysOrganization> children;

}
