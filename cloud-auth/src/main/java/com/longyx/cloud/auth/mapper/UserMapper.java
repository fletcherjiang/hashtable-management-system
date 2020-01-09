package com.longyx.cloud.auth.mapper;

import com.longyx.admin.api.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * @program: cloud_manage_lyx
 * @author: Mr.Michael
 * @create: 2019-12-21 21:50
 **/
@Repository
public interface UserMapper {
    User findUserByName(String username);
}
