package com.longyx.admin.api.feign.fallback;

import com.longyx.admin.api.feign.client.RoleClient;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.fallback
 * @ClassName: RoleClientFallBack
 */
@Component
public class RoleClientFallBack implements RoleClient {

    private final Logger logger = LoggerFactory.getLogger(RoleClientFallBack.class);

    @Override
    public ApiResponse getRoleByUserId(Long id) {
        logger.error("调用sophia-admin服务getRoleByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN, "getRoleByUserId");
    }
}
