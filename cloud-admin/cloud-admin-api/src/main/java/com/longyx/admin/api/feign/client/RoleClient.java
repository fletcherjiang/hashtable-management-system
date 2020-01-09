package com.longyx.admin.api.feign.client;

import com.longyx.admin.api.feign.fallback.RoleClientFallBack;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import com.longyx.common.feign.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.client
 * @ClassName: RoleClient
 */
@FeignClient(contextId = "roleClient", name = ServiceNameConstants.CLOUD_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = RoleClientFallBack.class)
public interface RoleClient {

    @GetMapping("/role/info/{id}")
    ApiResponse getRoleByUserId(@PathVariable Long id);
}
