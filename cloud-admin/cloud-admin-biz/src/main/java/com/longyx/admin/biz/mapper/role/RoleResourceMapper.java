package com.longyx.admin.biz.mapper.role;

import com.tydic.admin.api.entity.role.RoleResource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:55
 */
@Mapper
@Repository
public interface RoleResourceMapper {

    int addRoleResourceBySelective(RoleResource roleResource);

    @Delete("delete from role_resource where role_id=#{roleId,jdbcType=BIGINT}")
    int deleteRoleResourceByRoleId(Long roleId);
}
