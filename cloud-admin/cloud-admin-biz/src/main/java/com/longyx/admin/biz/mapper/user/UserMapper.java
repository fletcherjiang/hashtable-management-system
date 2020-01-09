package com.longyx.admin.biz.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.api.vo.UserVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.dao.user
 * @ClassName: UserDao
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名称查询用户
     * @param username 用户名称
     * @return User
     */
    User findByUserName(@Param(value = "username") String username);

    /**
     * 根据用户id查询用户
     * @param userId 用户id
     * @return User
     */
    User findByUserId(@Param(value = "userId") Long userId);

    /**
     * 根据用户名称查询所有相同用户名的用户
     *
     * @param username 用户名
     * @return List<UserVo>
     */
    List<UserVo> findUserVoList(String username);

    @Insert("insert into user(username,nickname,password,sex,phone,email,create_time,create_user,update_time,update_user,last_login_ip,last_login_time,is_deleted,status,head_image,organization_id,comp_id)values(#{username},#{nickname},#{password},#{sex},#{phone},#{email},#{create_time},#{create_user},#{update_time},#{update_user},#{last_login_ip},#{last_login_time},#{is_deleted},#{status},#{head_image},#{organization_id},#{comp_id}")
    int save(User user);

    @Select("select id,username,nickname,password,sex,phone,email,create_time,create_user,update_time,update_user,last_login_ip,last_login_time,is_deleted,status,head_image,organization_id,comp_id from sys_user where id=#{id}")
    User findUserById(Long id);

    @Delete("delete from sys_user where id=#{id}")
    int deleteUserById(Long id);

    @Select("select username,nickname,password,sex,phone,email,create_time,create_user,update_time,update_user,last_login_ip,last_login_time,is_deleted,status,head_image,organization_id,comp_id from user where username=#{username}")
    User findUserByName(String username);

    @Select("select count(id) from user where username=#{username} and phone=#{phone} and email=#{email} and organization_id=#{organizationId}")
    int queryForNum(UserVo userVo);

    @Select("select id,username,nickname,password,sex,phone,email,create_time,create_user,update_time,update_user,last_login_ip,last_login_time,is_deleted,status,head_image,organization_id,comp_id from sys_user where username=#{username} and phone=#{phone} and email=#{email} and organization_id=#{organizationId} limit #{start},#{pageSize}")
    List<User> queryForPage(UserVo userVo);


    int addUserSelective(User use);


    int updateUserByIdSelective(User user);
}
