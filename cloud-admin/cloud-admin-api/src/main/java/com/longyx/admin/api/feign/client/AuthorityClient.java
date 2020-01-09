package com.longyx.admin.api.feign.client;

import com.longyx.admin.api.feign.fallback.AuthorityClientFallBack;
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
 * @ClassName: AuthorityClient
 */
@FeignClient(contextId = "authorityClient", name = ServiceNameConstants.CLOUD_ADMIN, configuration = FeignRequestInterceptorConfig.class, fallback = AuthorityClientFallBack.class)
public interface AuthorityClient {

    @GetMapping("/authority/api/{id}")
    ApiResponse getAuthorityByUserId(@PathVariable Long id);

    @GetMapping("/authority/api/info")
    ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId);
}
