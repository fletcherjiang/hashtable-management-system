package com.longyx.common.base.exception;

import com.longyx.common.base.enums.MyHttpStatus;

/**
 * @author: Longyx
 * @Package: com.longyx.common.base.exception
 * @ClassName: CommonException
 * @Description: 自定义公共运行时异常
 */
public class CommonException extends RuntimeException {

    public Integer code;

    public String msg;

    public CommonException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String msg) {
        super(msg);
        this.code = MyHttpStatus.COMMON_FAIL.getCode();
        this.msg = msg;
    }

    public CommonException() {
        super(MyHttpStatus.COMMON_FAIL.getMessage());
        this.code = MyHttpStatus.COMMON_FAIL.getCode();
        this.msg = MyHttpStatus.COMMON_FAIL.getMessage();
    }
    public CommonException(MyHttpStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public CommonException(Throwable cause) {
        super(cause);
    }


}
