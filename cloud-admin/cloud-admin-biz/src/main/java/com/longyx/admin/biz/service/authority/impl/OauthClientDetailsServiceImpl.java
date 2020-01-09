package com.longyx.admin.biz.service.authority.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longyx.admin.api.entity.authority.OauthClientDetails;
import com.longyx.admin.biz.mapper.authority.OauthClientDetailsMapper;
import com.longyx.admin.biz.service.authority.OauthClientDetailsService;
import com.longyx.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.authority.impl
 * @ClassName: OauthClientDetailsServiceImpl
 * @Date: 2019/11/5 09:34
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements OauthClientDetailsService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsDao;

    @Override
    @Cacheable(value= GlobalsConstants.REDIS_CLIENT_CACHE,unless = "#result == null", key="T(com.scaffolding.sophia.common.base.constants.GlobalsConstants).CLIENT_DETAILS_KEY.concat(T(String).valueOf(#clientId))")
    public OauthClientDetails findOauthClientDetailsByClientId(String clientId) {
        return oauthClientDetailsDao.getOauthClientDetailsByClientId(clientId);
    }
}