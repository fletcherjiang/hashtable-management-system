package com.longyx.admin.biz.mapper.authority;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longyx.admin.api.entity.authority.OauthClientDetails;
import org.springframework.stereotype.Repository;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.dao.authority
 * @ClassName: OauthClientDetailsDao
 */
@Repository
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails getOauthClientDetailsByClientId(String clientId);

    /**
     * 根据clientId查询resourceIds
     *
     * @param clientId clientId
     * @return String
     */
    String getResourceIdsByClientId(String clientId);

}
