package com.longyx.admin.api.feign.fallback;

import com.longyx.admin.api.feign.client.ApiClient;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.fallback
 * @ClassName: ApiClientFallBack
 */
@Component
public class ApiClientFallBack implements ApiClient {

    private final Logger logger = LoggerFactory.getLogger(ApiClientFallBack.class);

    @Override
    public ApiResponse getUserInfo() {
        logger.error("调用sophia-admin服务getUserInfo方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN , "getUserInfo");
    }

}
