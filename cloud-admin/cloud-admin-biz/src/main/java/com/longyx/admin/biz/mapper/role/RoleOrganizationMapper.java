package com.longyx.admin.biz.mapper.role;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:34
 */
@Mapper
@Repository
public interface RoleOrganizationMapper {
    int deleteRoleGroupById(Long id);
}
