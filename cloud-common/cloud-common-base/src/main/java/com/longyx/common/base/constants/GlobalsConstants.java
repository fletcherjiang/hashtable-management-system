package com.longyx.common.base.constants;

/**
 * @author: Longyx
 * @Package: com.longyx.common.base.constants
 * @ClassName: GlobalsConstants
 * @Description: 系统常量
 */
public class GlobalsConstants {

    /**
     * jwt对称加密
     *
     **/
    public static final String OAUTH_SIGNING_KEY = "cloud_oauth_key";

    public static final String OAUTH_AUTH_FORM_URI = "/authentication/form";

    public static final String OAUTH_AUTH_REQUIRE_URI = "/authentication/require";

    /**
     * 登录页面
     */
    public static final String LOGIN_PAGE_URI = "/index.html";


    /**
     * Redis Cache
     */
    public static final String REDIS_USER_CACHE = "RedisUserCache";

    /**
     * Redis Cache
     */
    public static final String REDIS_CLIENT_CACHE = "RedisClientCache";

    /**
     * 缓存中user的key
     */
    public static final String USER_KEY_PREFIX = "CloudUser_";

    /**
     * oauth 客户端信息
     */
    public static final String CLIENT_DETAILS_KEY =  "CloudClient_";

    /**
     * Redis默认过期时长，单位：秒  5分钟
     */
    public static final long DEFAULT_EXPIRE = 60 * 5;

    /**
     * Redis 不设置过期时长
     */
    public static final long NOT_EXPIRE = -1;

    /**
     * Redis set 前缀
     */
    public static final String KEY_SET_PREFIX = "_set:";

    /**
     * Redis list 前缀
     */
    public static final String KEY_LIST_PREFIX = "_list:";

    /**
     * ip
     */
    public static final String UNKNOWN = "unknown";

    /**
     * druid配置
     */
    public static final String DB_PREFIX = "spring.datasource";

    /**
     *  Cloud security配置
     */
    public static final String CLOUD_OAUTH_PREFIX = "cloud.security";
    /**
     * oauth security配置
     */
    public static final String OAUTH_SECURITY_PREFIX = "security.oauth2.client";

    /**
     * security  过滤url 配置
     */
    public static final String FILTER_IGNORE = "ignore";

    /**
     * security  过滤url 配置
     */
    public static final String CLOUD_RESOURCE_IDS = "cloud.resource";

    /**
     * 成功标记
     */
    public static final String SUCCESS = "SUCCESS";
    /**
     * 失败标记
     */
    public static final String FAIL = "FAIL";

    /**
     * 前缀
     */
    public static final String PROJECT_PREFIX = "cloud_";

    /**
     * oauth 相关前缀
     */
    public static final String OAUTH_PREFIX = "oauth:";

    public static final String CURRENT = "current";

    public static final String SIZE = "size";

    /**
     * 系统常量
     * @author Mr.Longyx
     * @date 2020/1/4 17:57
     */
    public final static String ADMIN = "admin";

    public final static String ADMIN_CAN_NOT_DELETE = "超级管理员不能删除";

    public static final String USERNAME_ALREADY_EXIST = "用户名已经存在";
    public static final String ROLE_ALREADY_EXIST = "角色已经存在";
    public static final String ADMIN_CAN_NOT_EDIT = "超级管理员不能修改" ;
    public static final String ADMIN_RESOURCE_CAN_NOT_EDIT = "超级管理员权限不允许被修改";

    public static final String DIRECTORY = "directory";

    public static final String MENU = "menu";

    public static final String BUTTON = "button";

    public static final String ANONYMOUS_USER = "anonymoususer";


}
