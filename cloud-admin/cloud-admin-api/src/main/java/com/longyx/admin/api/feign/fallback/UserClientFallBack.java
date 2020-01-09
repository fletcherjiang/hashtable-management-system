package com.longyx.admin.api.feign.fallback;

import com.longyx.admin.api.feign.client.UserClient;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.fallback
 * @ClassName: UserClientFallBack
 */
@Component
public class UserClientFallBack implements UserClient {

    private final Logger logger = LoggerFactory.getLogger(UserClientFallBack.class);

    @Override
    public ApiResponse getUserByUserName(String username) {
        logger.error("调用cloud-admin服务getUserByUserName方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN, "getUserByUserName");
    }

    @Override
    public ApiResponse getUserByUserId(Long id) {
        logger.error("调用cloud-admin服务getUserByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN, "getUserByUserId");
    }
}
