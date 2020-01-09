package com.longyx.common.security.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.properties
 * @ClassName: OAuth2ClientProperties
 */
@Getter
@Setter
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    // private String resourceIds;

    private int accessTokenValidatySeconds;

    private int refreshTokenValiditySeconds;

}
