package com.longyx.admin.biz.service.resource;

import com.tydic.admin.api.entity.resource.Resource;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:48
 */
public interface ResourceService {
    int save(Resource resource);

    int update(Resource resource);

    int deleteResource(List<Long> ids);

    List<Resource> findResourceOnTree(String username, int mark);
}
