package com.longyx.admin.biz.service.authority;

import com.longyx.admin.api.entity.authority.OauthClientDetails;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.authority
 * @ClassName: oauthClientDetailsService
 */
public interface OauthClientDetailsService{

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails findOauthClientDetailsByClientId(String clientId);

}
