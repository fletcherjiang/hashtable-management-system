package com.longyx.common.base.enums;

import lombok.Getter;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 17:19
 */
@Getter
public enum  NoticeEnum implements CodeEnum{
    ENABLE(0,"该公告有效"),
    DISABLED(1, "该公告无效")
    ;

    private final Integer code;
    private final String message;

    NoticeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
