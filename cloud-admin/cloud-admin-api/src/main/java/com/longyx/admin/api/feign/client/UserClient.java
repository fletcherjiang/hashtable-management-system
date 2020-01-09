package com.longyx.admin.api.feign.client;

import com.longyx.admin.api.feign.fallback.UserClientFallBack;
import com.longyx.common.base.constants.ServiceNameConstants;
import com.longyx.common.base.support.ApiResponse;
import com.longyx.common.feign.FeignRequestInterceptorConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.feign.client
 * @ClassName: UserClient
 */
@FeignClient(contextId = "userClient", name = ServiceNameConstants.CLOUD_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/user/api")
    ApiResponse getUserByUserName(@RequestParam String username);

    @GetMapping("/user/info/{id}")
    ApiResponse getUserByUserId(@PathVariable Long id);
}
