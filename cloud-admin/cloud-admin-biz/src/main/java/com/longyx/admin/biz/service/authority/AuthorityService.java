package com.longyx.admin.biz.service.authority;

import com.tydic.admin.api.entity.authority.Authority;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.tydic.admin.biz.service.authority
 * @ClassName: AuthorityService
 */
public interface AuthorityService {

    /**
     * 根据用户id查询用户的权限
     *
     * @param id 用户id
     * @return List<Authority>
     */
    List<Authority> findAuthorityByUserId(Long id);
}
