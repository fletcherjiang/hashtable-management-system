package com.longyx.common.base.support;

import com.longyx.common.base.enums.MyHttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Longyx
 * @Package: com.longyx.common.base.support
 * @ClassName: ApiResponse
 * @Description: 公共的返回值
 */
@Data
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResponse(MyHttpStatus sophiaHttpStatus) {
        this.code = sophiaHttpStatus.getCode();
        this.message = sophiaHttpStatus.getMessage();
    }


    /**
     * 调用服务的错误
     * @param serviceName 服务名
     * @param methodName 方法名
     * @return 结果视图
     */
    public static ApiResponse hystrixError(String serviceName, String methodName) {
        String msg = MyHttpStatus.HYSTRIX_ERROR.getMessage().replace("xxx", serviceName).replace("{}", methodName);
        return new ApiResponse(MyHttpStatus.HYSTRIX_ERROR.getCode(), msg);
    }
}
