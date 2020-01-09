package com.longyx.admin.biz.service.organization.impl;

import com.tydic.admin.api.entity.organization.SysOrganization;
import com.tydic.admin.biz.mapper.organization.OrganizationMapper;
import com.tydic.admin.biz.service.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:59
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public int save(SysOrganization sysOrganization) {
        return organizationMapper.addOrganizationBySelective(sysOrganization);
    }

    @Override
    public int updateOrganization(SysOrganization sysOrganization) {
        return organizationMapper.updateOrganizationBySelective(sysOrganization);
    }

    @Override
    public int deleteOrganizations(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            if(id != null){
                organizationMapper.deleteOrganizationById(id);
            }
        }
        return 1;
    }

    @Override
    public List<SysOrganization> findOrganizationOnTree() {
        List<SysOrganization> organizations = new ArrayList<>();
        List<SysOrganization> organizationList = organizationMapper.findAll();
        for(SysOrganization organization : organizationList){
            if(null == organization.getPid() || organization.getPid() == 0){
                organization.setNum(0);
                organizationList.add(organization);
            }
        }
        findChildren(organizations,organizationList);
        return organizations;
    }

    private void findChildren(List<SysOrganization> organizations, List<SysOrganization> organizationList) {
        for(SysOrganization organization :organizations){

            List<SysOrganization> children = new ArrayList<>();
            for(SysOrganization organization1:organizationList){
                if (organization.getId() != null && organization.getId().equals(organization.getPid())) {
                    organization1.setNum(organization.getNum()+1);
                    children.add(organization1);
                }
            }
            organization.setChildren(children);
            findChildren(children, organizationList);
        }

    }
}

