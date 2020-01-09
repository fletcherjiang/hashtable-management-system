package com.longyx.admin.biz.mapper.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tydic.admin.api.entity.role.Role;
import com.tydic.admin.api.vo.RoleVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.tydic.admin.biz.dao.role
 * @ClassName: RoleDao
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    Role getRoleByUserId(@Param(value = "userId") Long userId);

    @Delete("delete from sys_role where id=#{id}")
    int deleteRoleById(Long id);

    @Select("select id,role_id,role_name,role_code,description,organization_id,create_time,create_user,update_time,update_user from sys_role where id=#{id,jdbcType=BIGINT}")
    Role findRoleById(Long id);

    int updateRoleBySelective(Role role);

    int addRoleBySelective(Role role);

    @Select("select id,role_id,role_name,role_code,description,organization_id,create_time,create_user,update_time,update_user from sys_role where id=#{roleId,jdbcType=BIGINT}")
    Role findRoleByRoleId(Long roleId);

    @Select("select id,role_id,role_name,role_code,description,organization_id,create_time,create_user,update_time,update_user from sys_role where name=#{roleName,jdbcType=BIGINT}")
    List<Role> queryForPage(RoleVo roleVo);

    @Select("select count(id) from sys_role where name=#{roleName}")
    int queryForNum(RoleVo roleVo);

    @Select("select id,role_id,role_name,role_code,description,organization_id,create_time,create_user,update_time,update_user from sys_role where name=#{roleName,jdbcType=VARCHAR}")
    Role findRoleByRoleName(String name);

    @Select("select r.id,r.role_id,r.role_name,r.role_code,r.description,r.organization_id,r.create_time,r.create_user,r.update_time, r.update_user from sys_role r, user_role ur where r.id=ur.role_id and ur.user_id=#{id}")
    List<Role> findRolesByUserId(Long id);
}
