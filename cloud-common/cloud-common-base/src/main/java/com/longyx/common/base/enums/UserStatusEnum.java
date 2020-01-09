package com.longyx.common.base.enums;

import lombok.Getter;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:26
 */
@Getter
public enum UserStatusEnum implements CodeEnum {
    BANNED(0,"该账号已禁用"),
    NORMAL(1,"该账号可正常使用")
    ;
    private Integer code;
    private String msg;

    UserStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
