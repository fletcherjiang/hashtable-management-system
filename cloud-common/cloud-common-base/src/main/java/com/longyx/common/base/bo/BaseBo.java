package com.longyx.common.base.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Longyx
 * @Package: com.longyx.common.base.bo
 * @ClassName: BaseBo
 * @Date: 2019/11/5 10:27
 */
@Data
public class BaseBo implements Serializable {

    private static final long serialVersionUID = 5357482282446155798L;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateUser;
}
