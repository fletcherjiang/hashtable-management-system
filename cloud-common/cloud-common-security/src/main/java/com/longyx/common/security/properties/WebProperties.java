package com.longyx.common.security.properties;

import com.longyx.common.base.enums.LoginType;
import lombok.Getter;
import lombok.Setter;


/**
 * @author: Longyx
 * @Package: com.longyx.common.security.properties
 * @ClassName: WebProperties
 */
@Getter
@Setter
public class WebProperties {

    private String loginPage;
    // private String loginPage = GlobalsConstants.LOGIN_PAGE_URI;

    private LoginType loginType = LoginType.JSON;

    private String[] unInterceptUris = {};
}
