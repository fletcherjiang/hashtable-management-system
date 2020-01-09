package com.longyx.admin.biz.service.authority.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tydic.admin.api.entity.authority.Authority;
import com.tydic.admin.biz.mapper.authority.AuthorityMapper;
import com.tydic.admin.biz.service.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.tydic.admin.biz.service.authority.impl
 * @ClassName: AuthorityServiceImpl
 * @Date: 2019/11/5 09:30
 */
@Service("authorityService")
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityDao;

    @Override
    public List<Authority> findAuthorityByUserId(Long id) {
        return authorityDao.findAuthorityByUserId(id);
    }
}
