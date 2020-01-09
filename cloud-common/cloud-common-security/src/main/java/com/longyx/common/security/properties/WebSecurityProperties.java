package com.longyx.common.security.properties;

import com.longyx.common.base.constants.GlobalsConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.properties
 * @ClassName: SophiaSecurityProperties
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = GlobalsConstants.CLOUD_OAUTH_PREFIX)
public class WebSecurityProperties {

    WebProperties web = new WebProperties();

    OAuth2Properties oauth2 = new OAuth2Properties();

}
