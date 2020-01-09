package com.longyx.admin.biz.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longyx.admin.api.entity.organization.SysOrganization;
import com.longyx.admin.api.entity.resource.Resource;
import com.longyx.admin.api.entity.role.Role;
import com.longyx.admin.api.entity.user.User;
import com.longyx.admin.api.entity.user.UserRole;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.api.vo.UserVo;
import com.longyx.admin.biz.mapper.organization.OrganizationMapper;
import com.longyx.admin.biz.mapper.user.UserMapper;
import com.longyx.admin.biz.mapper.user.UserRoleMapper;
import com.longyx.admin.biz.service.user.UserService;
import com.longyx.common.base.constants.GlobalsConstants;
import com.longyx.common.base.exception.CommonException;
import com.longyx.common.security.properties.SecurityOAuth2ClientProperties;
import com.longyx.common.util.HttpCallOtherInterfaceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: Longyx
 * @Package: com.longyx.admin.biz.service.user.impl
 * @ClassName: UserServiceImpl
 * @Date: 2019/11/5 09:19
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Value("${gateway.url}")
    private String url;

    @Autowired
    private SecurityOAuth2ClientProperties securityOAuth2ClientProperties;

    @Override
    public User loadUserByUserName(String username){
        return userMapper.findByUserName(username);
    }

    @Override
    @Cacheable(value= GlobalsConstants.REDIS_USER_CACHE,unless = "#result == null", key="T(com.scaffolding.sophia.common.base.constants.GlobalsConstants).USER_KEY_PREFIX.concat(T(String).valueOf(#userId))")
    public User loadUserByUserId(Long userId){
        return userMapper.findByUserId(userId);
    }


    @Override
    public List<UserVo> findUserVoList(String username) {
        return userMapper.findUserVoList(username);
    }


    @Override
    public UserVo loginByPassword(String userName, String password) {
        BaseMapper baseMapper = null;
        User user = (User) baseMapper.selectOne(new QueryWrapper<User>().eq("username",userName));
        if (null == user) {
            return null;
        }
        String s;
        //数据库密码是加密了的
        if (passwordEncoder.matches(password, user.getPassword())) {
            s = "?client_id=" + securityOAuth2ClientProperties.getClientId() + "&client_secret=" + securityOAuth2ClientProperties.getClientSecret() + "&grant_type=password&scope=all&username=" + userName + "&password=" + password;
            String sr = HttpCallOtherInterfaceUtils.callOtherInterface(url, "/api/auth/oauth/token" + s);
            Map srmap = JSON.parseObject(sr);
            if (null == srmap ) {
                throw new CommonException("认证失败");
            }
            String access_token;
            if(StringUtils.isEmpty((String) srmap.get("access_token"))){
                access_token = (String) srmap.get("value");
            }else {
                access_token = (String) srmap.get("access_token");
            }
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(user,vo);
            vo.setAccessToken(access_token);
            return vo;
        }
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public Set<String> findPrivilege(String name) {
        Set<String> perms = new HashSet<>();
        //获取当前用户所拥有的权限
        User user = userMapper.findUserByName(name);
        List<Role> roles = user.getRoleList();
        List<Resource> resources = new ArrayList<>();
        for(Role role:roles){
            resources.addAll(role.getResourceSet());
        }

        System.err.println("####"+resources);

        for(Resource resource:resources){

            if(resource.getGrant()!=null&&!"".equals(resource.getGrant())){
                perms.add(resource.getGrant());
            }
        }
        System.err.println(perms);
        return perms;
    }

    @Override
    public User findUserByName(String username) {
        User user = userMapper.findUserByName(username);
        if(user != null){
            getUserRolesAndUserGroup(user);
        }
        return user;
    }

    private void getUserRolesAndUserGroup(User user) {
        //获取用户所在部门
        Long organizationId = user.getOrganizationId();
        SysOrganization organization = organizationMapper.findOrganizationById(organizationId);
        user.setUsername(organization.getFullName());

        //获取用户的角色
        StringBuffer sb = new StringBuffer();
        List<Role> roles = user.getRoleList();
        for(Role role:roles){
            sb.append(role.getDescription());
            sb.append(",");
        }
        user.setRoleNames(sb.toString());

    }

    @Override
    public PageResultVo findUserByPage(UserVo userVo) {
        int count = userMapper.queryForNum(userVo);

        PageResultVo pageResultVo = null;

        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据，没有则返回空的数据集
        if(count>0){
            List<User> users = userMapper.queryForPage(userVo);
            for(User user:users){
                getUserRolesAndUserGroup(user);
            }
            pageResultVo = new PageResultVo(
                    users,
                    count,
                    userVo.getCurrentPage(),
                    userVo.getPageSize());

        }else {
            pageResultVo = PageResultVo.blank(userVo.getPageSize());
        }
        return pageResultVo;
    }

    @Override
    public int deleteUser(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while (iterator.hasNext()){
            Long id = iterator.next();
            if(id != null){
                userMapper.deleteUserById(id);
                userRoleMapper.deleteUserRoleById(id);
            }
        }
        return 1;
    }

    @Override
    public int save(User user) {
        //前台传来ID，如果为null表示新增用户，如果有值，表示修改用户
        Long userId = null;
        if(user.getId() == 0){
            //新增用户
            //设置了主键回调，插入后会将主键回传
            userMapper.addUserSelective(user);
            if(user.getRoleIds().size()!=0){
                //为用户添加角色
                for(Long RoleId:user.getRoleIds()){
                    userRoleMapper.addUserRoleBySelective(user.getId(),RoleId);
                }
            }
            return 1;

        }else {
            //更新用户信息
            userMapper.updateUserByIdSelective(user);
        }


        userId = user.getId();

        //更新用户角色
        if(userId != 0){
            //如果用户的角色对应的ID为0，则删除用户所拥有的角色
            if(user.getRoleIds().size() == 0){
                userRoleMapper.deleteUserRoleById(user.getId());
                return 1;
            }
            //否则更改用户的角色
            List<UserRole> userRoles = userRoleMapper.findUserRoleByUserId(userId);
            if(userRoles==null){
                for(Long roleId:user.getRoleIds()){
                    userRoleMapper.addUserRoleBySelective(userId,roleId);
                }
                return 1;
            }else {
                //先删除原有的角色
                userRoleMapper.deleteUserRoleById(user.getId());

                for(Long roleId:user.getRoleIds()){
                    //删除后再插入，放置多个角色覆盖
                    userRoleMapper.addUserRoleBySelective(userId,roleId);
                }
            }
        }
        return 1;
    }
}