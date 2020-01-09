package com.longyx.admin.biz.service.resource.impl;

import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.biz.mapper.resource.ResourceMapper;
import com.longyx.admin.biz.mapper.user.UserMapper;
import com.longyx.admin.biz.service.resource.ResourceService;
import com.longyx.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:48
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int save(Resource resource) {
        return resourceMapper.addResourceBySelective(resource);
    }

    @Override
    public int update(Resource resource) {
        return resourceMapper.updateResourceBySelective(resource);
    }

    @Override
    public int deleteResource(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            if(id != null){
                resourceMapper.deleteResourceById(id);
            }
        }
        return 1;
    }

    @Override
    public List<Resource> findResourceOnTree(String username, int mark) {
        List<Resource> resources = new ArrayList<>();
        List<Resource> resourceList = new ArrayList<>();
        User user = userMapper.findUserByName(username);
        List<Role> roles;
        if(user !=null){
            roles = user.getRoleList();
            for(Role role:roles){
                resourceList.addAll(role.getResourceSet());
            }
        }else {
            resourceList = resourceMapper.findAll();
        }
        for(Resource resource:resourceList){
            if(resource.getParentId() == null || resource.getParentId() == 0){
                resource.setLevel(0);
                resources.add(resource);
            }
        }
        findChildren(resources,resourceList,mark);
        return resources;
    }

    public void findChildren(List<Resource> resources,List<Resource> resourceList,int mark){
        for(Resource resource:resources){
            List<Resource> children = new ArrayList<>();
            for(Resource resource1:resourceList){

                //当是查找导航树且类型是按钮就进入下一次循环，不加入孩子
                if(mark == 0 && resource1.getType().equalsIgnoreCase(GlobalsConstants.BUTTON)){
                    continue;
                }
                if(resource.getId()!=null && resource.getId().equals(resource1.getParentId())){
                    resource1.setLevel(resource.getLevel()+1);
                    children.add(resource1);
                }
            }

            resource.setChildren(children);
            findChildren(children, resourceList,mark);
        }

    }
}
