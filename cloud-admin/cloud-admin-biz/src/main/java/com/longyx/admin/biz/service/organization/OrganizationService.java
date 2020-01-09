package com.longyx.admin.biz.service.organization;

import com.tydic.admin.api.entity.organization.SysOrganization;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:58
 */
public interface OrganizationService {
    int save(SysOrganization sysOrganization);

    int updateOrganization(SysOrganization sysOrganization);

    int deleteOrganizations(List<Long> ids);

    List<SysOrganization> findOrganizationOnTree();
}
