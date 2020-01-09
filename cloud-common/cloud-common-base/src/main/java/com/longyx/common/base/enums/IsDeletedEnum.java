package com.longyx.common.base.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:20
 */
@Getter
public enum  IsDeletedEnum implements Serializable {
    NORMAL(0,"正常"),
    DELETED(-1, "已删除")
    ;

    private final Integer code;
    private final String message;

    IsDeletedEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
