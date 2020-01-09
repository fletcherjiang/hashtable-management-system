package com.longyx.common.base.enums;

/**
 * 自定义状态码枚举类
 * @author Mr.Longyx
 * @date 2020年01月04日 17:28
 */
public enum HttpStatusEnum {
    /**
     * 执行成功
     */
    OK(0,"SUCCESS"),
    /**
     * 失败
     */
    FAILED(-1, "FAILED"),
    /**
     * 未知异常
     */
    UNKNOW_EXCEPTION(201, "未知异常"),
    /**
     * 参数类型不匹配
     */
    METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTIION(207, "参数类型不匹配"),
    /**
     * 缺少参数
     */
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(208, "缺少参数"),
    /**
     * 不支持的请求METHOD
     */
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(209, "不支持的method类型"),
    /**
     * 参数异常
     */
    PARAM_EXCEPTION(210, "参数异常")
    ;

    /**
     * 状态码
     */
    private final int status;
    /**
     * 描述字段
     */
    private final String message;


    HttpStatusEnum(int status, String message){
        this.status = status;
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}

