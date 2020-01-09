package com.longyx.admin.biz.mapper.organization;

import com.longyx.admin.api.entity.organization.SysOrganization;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:33
 */
@Mapper
@Repository
public interface OrganizationMapper {
    @Select("select id,num,pid,pids,simple_name,full_name,tips,address,organization_type,create_time,create_user,update_time,update_user from sys_organization where id=#{id}")
    SysOrganization findOrganizationById(Long organizationId);

    @Select("select id,num,pid,pids,simple_name,full_name,tips,address,organization_type,create_time,create_user,update_time,update_user from sys_organization")
    List<SysOrganization> findAll();

    int addOrganizationBySelective(SysOrganization group);

    int updateOrganizationBySelective(SysOrganization group);

    @Delete("delete from sys_organization where id=#{id} or pid =#{id}")
    int deleteOrganizationById(Long id);
}