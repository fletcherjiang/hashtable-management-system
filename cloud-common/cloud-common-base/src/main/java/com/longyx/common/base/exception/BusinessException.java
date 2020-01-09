package com.longyx.common.base.exception;

import com.longyx.common.base.enums.MyHttpStatus;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Longyx
 * @Package: com.longyx.common.base.exception
 * @ClassName: BusinessException
 * @Description: 业务异常
 */
@Slf4j
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    protected int code;

    private static final long serialVersionUID = 3160241586346324994L;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(MyHttpStatus codeEnum, Object... args) {
        super(String.format(codeEnum.getMessage(), args));
        this.code = codeEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
