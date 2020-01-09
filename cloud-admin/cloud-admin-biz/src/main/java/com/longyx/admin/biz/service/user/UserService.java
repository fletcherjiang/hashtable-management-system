package com.longyx.admin.biz.service.user;

import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.UserVo;

import java.util.List;
import java.util.Set;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.user
 * @ClassName: UserService
 */
public interface UserService {

    /**
     * 根据用户名称查询用户
     *
     * @param username 用户名
     * @return User
     */
    User loadUserByUserName(String username);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return User
     */
    User loadUserByUserId(Long userId);

    /**
     * 根据用户名称查询所有相同用户名的用户
     *
     * @param username 用户名
     * @return List<UserVo>
     */
    List<UserVo> findUserVoList(String username);
    /**
     * 用户 用户名和密码登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return UserVo
     * */
    UserVo loginByPassword(String userName, String password);


    User findUserById(Long id);

    Set<String> findPrivilege(String name);

    User findUserByName(String username);

    PageResultVo findUserByPage(UserVo userVo);

    int deleteUser(List<Long> ids);

    int save(User user);
}
