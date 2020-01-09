package com.longyx.admin.api.feign.client;

import com.longyx.admin.api.feign.fallback.ApiClientFallBack;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import com.longyx.common.feign.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.client
 * @ClassName: ApiClient
 */
@FeignClient(contextId = "apiClient", name = ServiceNameConstants.CLOUD_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = ApiClientFallBack.class)
public interface ApiClient {

    @GetMapping("/api/principal")
    ApiResponse getUserInfo();

}
