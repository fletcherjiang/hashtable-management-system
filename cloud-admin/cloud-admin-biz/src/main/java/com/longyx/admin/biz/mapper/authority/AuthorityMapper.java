package com.longyx.admin.biz.mapper.authority;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longyx.admin.api.entity.authority.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.dao.authority
 * @ClassName: AuthorityDao
 */
@Repository
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 根据用户id查询用户的权限
     *
     * @param userId 用户id
     * @return List<Authority>
     */
    List<Authority> findAuthorityByUserId(@Param(value = "userId") Long userId);
}
