package com.longyx.admin.api.vo;

import lombok.Data;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:07
 */
@Data
public class LogVo extends PageVo{
    private String methodName;
    private String ip;
}
