package com.longyx.cloud.auth.mapper;

import com.longyx.admin.api.entity.resource.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: cloud_manage_lyx
 * @author: Mr.Michael
 * @create: 2019-12-21 21:53
 **/
@Repository
public interface ResourceMapper {
    List<Resource> findResourcesByRoleId(Long id);
}
