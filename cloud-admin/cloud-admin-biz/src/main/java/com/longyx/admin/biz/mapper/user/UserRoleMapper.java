package com.longyx.admin.biz.mapper.user;

import com.longyx.admin.api.entity.user.UserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 20:45
 */
@Mapper
@Repository
public interface UserRoleMapper {
    @Delete("delete from sys_user_role where user_id=#{id}")
    int deleteUserRoleById(Long id);

    int addUserRoleBySelective(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Select("select id,role_id,user_id from sys_user_role where user_id=#{userId,jdbcType=BIGINT}")
    List<UserRole> findUserRoleByUserId(Long userId);

    @Update("update sys_user_role set user_id=#{userId,jdbcType=BIGINT},role_id=#{roleId,jdbcType=BIGINT} where user_id=#{userId,jdbcType=BIGINT}}}")
    int updateUserRoleByUserId(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
