package com.longyx.admin.api.entity.authority;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.api.entity.authority
 * @ClassName: OauthClientDetails
 */
@Data
@NoArgsConstructor
@TableName("sys_oauth_client_details")
@ApiModel(value = "OauthClientDetails",description = "Oauht2客户端详情设置")
public class OauthClientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String autoapprove;

    private String additionalInformation;

}
