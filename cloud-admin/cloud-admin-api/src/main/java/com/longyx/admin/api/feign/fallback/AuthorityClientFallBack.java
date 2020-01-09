package com.longyx.admin.api.feign.fallback;

import com.longyx.admin.api.feign.client.AuthorityClient;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.fallback
 * @ClassName: AuthorityClientFallBack
 */
@Component
public class AuthorityClientFallBack implements AuthorityClient {

    private final Logger logger = LoggerFactory.getLogger(AuthorityClientFallBack.class);

    @Override
    public ApiResponse getAuthorityByUserId(Long id) {
        logger.error("调用sophia-admin服务getAuthorityByUserId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN, "getAuthorityByUserId");
    }

    @Override
    public ApiResponse getOauthClientDetailsByClientId(String clientId) {
        logger.error("调用sophia-admin服务getOauthClientDetailsByClientId方法失败!");
        return ApiResponse.hystrixError(ServiceNameConstants.CLOUD_ADMIN, "getOauthClientDetailsByClientId");
    }
}
