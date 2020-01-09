SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `NUM` int(11) NULL DEFAULT NULL COMMENT '排序',
  `PID` bigint(11) NULL DEFAULT NULL COMMENT '父组织id',
  `PIDS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级ids',
  `SIMPLE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简称',
  `FULL_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '全称',
  `TIPS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提示',
  `ADDRESS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `ORGANIZATION_TYPE` int(11) NULL DEFAULT NULL COMMENT '组织类型(0 公司1部门)',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT '组织管理';

-- ----------------------------
-- Table structure for sys_api_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_api_log`;
CREATE TABLE `sys_api_log`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `URI` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'url',
  `METHOD_NAME` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `PARAMS` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `CLASS_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类名',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '访问时间',
  `TIMES` int(11) NULL DEFAULT NULL COMMENT '耗时',
  `USER_ID` int(11) NULL DEFAULT NULL COMMENT '访问用户',
  `IP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问ip',
  `METHOD` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT='系统日志';


-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `AUTH_NAME` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限名称',
  `AUTH_CODE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编号',
  `AUTH_URL` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'AUTH_URL',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES (1, '系统管理', 'system', '/system', NULL, NULL, NULL, NULL);


-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `organization_id` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `name` varchar(50) DEFAULT NULL COMMENT '授权名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '授权人Id',
  `grant` varchar(500) DEFAULT NULL COMMENT '授权',
  `type` int(8) DEFAULT NULL COMMENT '授权类型',
  `level` int(11) DEFAULT NULL COMMENT '权限级别',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源管理';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '2', '系统管理', '0', 'sys', '0','0', null, null, '张三', null, '0');
INSERT INTO `sys_resource` VALUES ('2', '3', '账户管理', '1', 'account', '1', '1', null, null, '李四', null, '0');
INSERT INTO `sys_resource` VALUES ('3', '3', '组织管理', '1', 'organization', '1', '2', null, null, '王五', null, '0');
INSERT INTO `sys_resource` VALUES ('4', '3', '角色管理', '1', 'view', '1', '3', null, null, '赵六', null, '0');
INSERT INTO `sys_resource` VALUES ('6', '3', '权限管理', '1', 'grant', '1', '4', null, null, '233', null, '0');
INSERT INTO `sys_resource` VALUES ('7', '3', '公告管理', '1', 'notice', '1', '5', null, null, '王八', null, '0');
INSERT INTO `sys_resource` VALUES ('8', '3', '系统日志', '1', 'log:view', '1',  '6', 'admin', '2019-12-8 19:29:12', '小四', '2019-12-9 19:32:28','0');
INSERT INTO `sys_resource` VALUES ('9', '4', '查看', '2', 'user:view', '2',  null, null, null, '孙丽', null, '0');
INSERT INTO `sys_resource` VALUES ('10', '4', '新增', '2', 'user:add', '2', null, null, null, '孙丽', null, '0');
INSERT INTO `sys_resource` VALUES ('11', '4', '修改', '2', 'user:edit', '2',  null, null, null, '孙丽', null, '0');
INSERT INTO `sys_resource` VALUES ('12', '4', '删除', '2', 'user:delete', '2',  null, null, null, '孙丽', null, '0');
INSERT INTO `sys_resource` VALUES ('13', '5', '查看', '3', 'organization:view','2',  null, null, null, '中二', null, '0');
INSERT INTO `sys_resource` VALUES ('14', '5', '新增', '3', 'organization:add','2',  null, null, null, '中二', null, '0');
INSERT INTO `sys_resource` VALUES ('15', '5', '修改', '3', 'organization:edit', '2',  null, null, null, '中二', null, '0');
INSERT INTO `sys_resource` VALUES ('16', '5', '删除', '3', 'organization:delete','2', null, null, null, '中二', null, '0');
INSERT INTO `sys_resource` VALUES ('17', '6', '查看', '4', 'role:view', '2',  null, null, null, '三儿', null, '0');
INSERT INTO `sys_resource` VALUES ('18', '6', '新增', '4', 'role:add', '2',  null, null, null, '三儿', null, '0');
INSERT INTO `sys_resource` VALUES ('19', '6', '修改', '4', 'role:edit', '2',  null, null, null, '三儿', null, '0');
INSERT INTO `sys_resource` VALUES ('20', '6', '删除', '4', 'role:delete','2',  null, null, null, '三儿', null, '0');
INSERT INTO `sys_resource` VALUES ('21', '7', '查看', '5', 'resource:view','2',  null, null, null, '狗蛋', null, '0');
INSERT INTO `sys_resource` VALUES ('22', '7', '新增', '5','resource:add','2',  null, null, null, '狗蛋', null, '0');
INSERT INTO `sys_resource` VALUES ('23', '7', '修改', '5', 'resource:edit','2',  null, null, null, '狗蛋', null, '0');
INSERT INTO `sys_resource` VALUES ('24', '7', '删除', '5','resource:delete','2',  null, null, null, '狗蛋', null, '0');
INSERT INTO `sys_resource` VALUES ('25', '8', '查看', '6', 'grant:view','2', null, null, null, '阿虎', null, '0');
INSERT INTO `sys_resource` VALUES ('26', '8', '新增', '6', 'grant:add','2',  null, null, null, '阿虎', null,  '0');
INSERT INTO `sys_resource` VALUES ('27', '8', '修改', '6', 'grant:edit','2',  null, null, null, '阿虎', null, '0');
INSERT INTO `sys_resource` VALUES ('28', '8', '删除', '6', 'grant:delete', '2',  null, null, null,'阿虎',  null, '0');
INSERT INTO `sys_resource` VALUES ('29', '9', '查看', '7', 'notice:view', '2',  null, null, null, 'mike', null,  '0');
INSERT INTO `sys_resource` VALUES ('30', '9', '新增', '7', 'notice:add', '2',  null, null, null, 'mike', null,  '0');
INSERT INTO `sys_resource` VALUES ('31', '9', '修改', '7', 'notice:edit', '2',  null, null, null, 'mike', null,  '0');
INSERT INTO `sys_resource` VALUES ('32', '9', '删除', '7', 'notice:delete', '2',  null, null, null, 'mike', null, '0');



-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `VALUE` int(11) NULL DEFAULT NULL COMMENT '字典值',
  `PID` bigint(11) NULL DEFAULT NULL COMMENT '上级ID',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典名称',
  `TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典类型',
  `IS_DELETED` int(1) NULL DEFAULT NULL COMMENT '是否删除 (0 是  1否)',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `PID` bigint(11) NULL DEFAULT NULL COMMENT '父级菜单主键',
  `MENU_NAME` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `MENU_PATH` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `MENU_CODE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单编号',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (0, NULL, '顶级菜单', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '/system', 'system', NULL, NULL, NULL, NULL);




-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `autoapprove` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'false',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('amor-admin', NULL, 'amor-admin-secret', 'all,read,write', 'password,refresh_token', NULL, NULL, 21600, 28800, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('sophia-admin', NULL, 'sophia-admin-secret', 'all,read,write', 'password,refresh_token,authorization_code,client_credentials', NULL, NULL, 21600, 28800, NULL, 'true');


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(11) NOT NULL COMMENT '角色Id',
  `ROLE_NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名称',
  `ROLE_CODE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `ORGANIZATION_ID` bigint(20) NULL DEFAULT NULL COMMENT '组织id',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` VARCHAR(30) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` VARCHAR(30) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic comment '组织管理';


-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 1, '系统管理员', 'admin', '超级管理员', NULL, '2019-09-27 16:10:23', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(11) NULL DEFAULT NULL COMMENT '角色id',
  `AUTH_ID` bigint(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES (1, 1, 1);



-- ----------------------------
-- Table structure for role_organization
-- ----------------------------
DROP TABLE IF EXISTS `role_organization`;
CREATE TABLE `role_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `organization_id` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色组织';

-- ----------------------------
-- Records of role_organization
-- ----------------------------

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源';

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('224', '4', '1', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('225', '4', '2', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('226', '4', '9', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('227', '4', '3', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('228', '4', '13', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('229', '4', '4', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('230', '4', '17', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('231', '4', '5', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('232', '4', '21', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('233', '4', '6', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('234', '4', '7', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('235', '4', '31', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('236', '4', '8', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('237', '4', '25', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('238', '4', '26', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('239', '4', '27', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('240', '4', '28', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('241', '4', '29', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('242', '4', '30', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('243', '4', '35', 'admin', '2019-11-30 16:22:41', 'admin', null);
INSERT INTO `role_resource` VALUES ('388', '2', '1', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('389', '2', '2', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('390', '2', '9', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('391', '2', '3', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('392', '2', '13', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('393', '2', '17', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('394', '2', '5', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('395', '2', '21', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('396', '2', '7', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('397', '2', '31', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('398', '2', '8', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('399', '2', '6', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('400', '2', '35', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('401', '2', '28', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('402', '2', '29', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('403', '2', '30', 'admin', '2019-11-30 19:51:53', 'admin', null);
INSERT INTO `role_resource` VALUES ('404', '3', '1', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('405', '3', '2', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('406', '3', '9', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('407', '3', '3', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('408', '3', '13', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('409', '3', '8', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('410', '3', '6', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('411', '3', '28', 'admin', '2019-11-30 19:51:55','admin', null);
INSERT INTO `role_resource` VALUES ('412', '3', '29', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('413', '3', '30', 'admin', '2019-11-30 19:51:55', 'admin', null);
INSERT INTO `role_resource` VALUES ('431', '8', '1', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('432', '8', '2', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('433', '8', '9', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('434', '8', '3', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('435', '8', '13', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('436', '8', '4', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('437', '8', '17', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('438', '8', '5', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('439', '8', '21', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('440', '8', '7', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('441', '8', '31', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('442', '8', '8', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('443', '8', '6', 'admin', '2019-11-30 19:55:08', 'admin', null);
INSERT INTO `role_resource` VALUES ('444', '8', '35', 'admin', '2019-11-30 19:55:08', 'admin', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `NICKNAME` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `PASSWORD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `SEX` int(11) NULL DEFAULT NULL COMMENT '性别',
  `PHONE` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `CREATE_USER` varchar(20) NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `UPDATE_USER` varchar(20) NULL DEFAULT NULL COMMENT '修改人',
  `LAST_LOGIN_IP` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `LAST_LOGIN_TIME` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登陆时间',
  `IS_DELETED` int(1) NULL DEFAULT NULL COMMENT '是否删除 (0 是  1否)',
  `STATUS` int(1) NULL DEFAULT NULL COMMENT '状态 0无效 1有效',
  `HEAD_IMAGE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `ORGANIZATION_ID` bigint(11) NULL DEFAULT NULL COMMENT '部门id 一个用户只有 一个部门',
  `COMP_ID` bigint(11) NULL DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '系统管理员', '$2a$10$ts07XkBaX7OwC5xA449gh.MO1Sa3KfyJlcx./lZKkMEgP8XDSoR9e', 1, '13269630365', '1234@qq.com', '2019-09-27 15:04:26', NULL, '2019-09-27 15:04:26', NULL, '0:0:0:0:0:0:0:1', '2019-09-27 15:04:26', 0, 0, '1/2/ts_Penguins.jpg', 20009, NULL);


-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(11) NULL DEFAULT NULL COMMENT '角色id',
  `USER_ID` bigint(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`(
		`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
		`title` varchar(50) DEFAULT NULL COMMENT '公告标题',
		`content` varchar(50) DEFAULT NULL COMMENT '公告内容',
		`enable` tinyint(4) DEFAULT NULL COMMENT '公告的有效性 0：有效 1：无效',
		`create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
		`create_time` datetime DEFAULT NULL COMMENT '创建时间',
		`update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
		`update_time` datetime DEFAULT NULL COMMENT '更新时间',
		PRIMARY KEY (`id`)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告管理';

INSERT INTO `sys_notice` VALUES ('1', '注意事项', '233333333333', '0', 'admin', '2019-12-27 11:08:41', 'admin', null);
INSERT INTO `sys_notice` VALUES ('2', '奖励办法', '按绩效奖励', '0',  null, '2019-11-30 17:11:17', 'admin', null);
INSERT INTO `sys_notice` VALUES ('3', '考勤', '迟到三次以上将工资', '0',  null, '2019-11-30 17:10:36', 'admin', null);
INSERT INTO `sys_notice` VALUES ('4', '管理办法', '不能迟到和早退', '0', null, '2019-11-04 09:42:49', 'admin', null);


create table `user_like`(
	`id` int not null auto_increment,
	`liked_user_id` varchar(32) not null comment '被点赞的用户id',
	`liked_post_id` varchar(32) not null comment '点赞的用户id',
	`status` tinyint(1) default '1' comment '点赞状态，0取消，1点赞',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`id`),
	INDEX `liked_user_id`(`liked_user_id`),
	INDEX `liked_post_id`(`liked_post_id`)
) comment '用户点赞表';


drop table if exists `comments_info`;
create table `comments_info`(
	`id` varchar(32) not null comment '评论主键id',
	`pid` varchar(32) default '' comment '父评论id',
	`owner_id` varchar(32) not null comment '被评论的资源id，可以是人、项目、资源',
	`type` tinyint(1) not null comment '评论类型：对人评论，对项目评论，对资源评论',
	`from_id` varchar(32) not null comment '评论者id',
	`from_name` varchar(32) not null comment '评论者名字',
	`to_id` varchar(32) default '' comment '被评论者id',
	`to_name` varchar(32) default '' comment '被评论者名字',
	`like_num` int default '0' comment '点赞的数量',
	`content` varchar(512) comment '评论内容',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`id`)
) comment '评论主表';

SET FOREIGN_KEY_CHECKS = 1;
