package com.longyx.admin.biz.mapper.resource;

import com.longyx.admin.api.entity.resource.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:33
 */
@Mapper
@Repository
public interface ResourceMapper {
    List<Resource> findResourcesByRoleId(Long id);

    int updateResourceBySelective(Resource resource);

    int deleteResourceById(Long id);

    int addResourceBySelective(Resource resource);

    List<Resource> findAll();
}