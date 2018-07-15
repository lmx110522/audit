/*
Navicat MySQL Data Transfer

Source Server         : centos7.3
Source Server Version : 50717
Source Host           : 192.168.41.140:3306
Source Database       : aduilt

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-15 19:09:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` varchar(255) NOT NULL,
  `aname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sorter` int(100) DEFAULT NULL,
  `is_ok` int(10) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `private_parent` (`parent_id`),
  CONSTRAINT `authority_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '审核记录', null, '1', '1', null);
INSERT INTO `authority` VALUES ('10', '个人信息', null, '11', '1', null);
INSERT INTO `authority` VALUES ('11', '审核人管理', null, '12', '1', '4');
INSERT INTO `authority` VALUES ('12', '教研室管理', null, '13', '1', '4');
INSERT INTO `authority` VALUES ('13', '系院管理', null, '14', '1', '4');
INSERT INTO `authority` VALUES ('14', '待我审核', null, '15', '1', '9');
INSERT INTO `authority` VALUES ('15', '审核记录', null, '16', '1', '9');
INSERT INTO `authority` VALUES ('16', '排行榜', null, '8', '1', null);
INSERT INTO `authority` VALUES ('2', '项目工程', null, '2', '1', null);
INSERT INTO `authority` VALUES ('3', '教研室预览', null, '3', '1', null);
INSERT INTO `authority` VALUES ('4', '账号管理', null, '4', '1', null);
INSERT INTO `authority` VALUES ('5', '教研室查看', null, '5', '1', null);
INSERT INTO `authority` VALUES ('6', '审核人分配(文)', null, '6', '1', null);
INSERT INTO `authority` VALUES ('7', '审核人分配(理)', null, '7', '1', null);
INSERT INTO `authority` VALUES ('8', '教研室预览', null, '9', '1', null);
INSERT INTO `authority` VALUES ('9', '教研室审核', null, '10', '1', null);

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` varchar(255) NOT NULL,
  `dname` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `grouping` int(10) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_ok` int(10) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `user_id` (`uid`),
  KEY `size_id` (`mid`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` varchar(255) NOT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_uid` (`uid`),
  CONSTRAINT `module_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `id` int(11) NOT NULL,
  `role` int(10) DEFAULT NULL COMMENT '职能',
  `aid` varchar(255) DEFAULT NULL,
  `is_ok` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authority_id` (`aid`),
  CONSTRAINT `role_authority_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `authority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES ('1', '4', '1', '1');
INSERT INTO `role_authority` VALUES ('2', '4', '2', '1');
INSERT INTO `role_authority` VALUES ('3', '2', '3', '1');
INSERT INTO `role_authority` VALUES ('4', '1', '4', '1');
INSERT INTO `role_authority` VALUES ('5', '1', '5', '1');
INSERT INTO `role_authority` VALUES ('6', '1', '6', '1');
INSERT INTO `role_authority` VALUES ('7', '1', '7', '1');
INSERT INTO `role_authority` VALUES ('8', '2', '8', '1');
INSERT INTO `role_authority` VALUES ('9', '3', '9', '1');
INSERT INTO `role_authority` VALUES ('10', '1', '10', '1');
INSERT INTO `role_authority` VALUES ('11', '2', '10', '1');
INSERT INTO `role_authority` VALUES ('12', '3', '10', '1');
INSERT INTO `role_authority` VALUES ('13', '4', '10', '1');
INSERT INTO `role_authority` VALUES ('14', '1', '11', '1');
INSERT INTO `role_authority` VALUES ('15', '1', '12', '1');
INSERT INTO `role_authority` VALUES ('16', '1', '13', '1');
INSERT INTO `role_authority` VALUES ('17', '3', '14', '1');
INSERT INTO `role_authority` VALUES ('18', '3', '15', '1');
INSERT INTO `role_authority` VALUES ('19', '1', '16', '1');
INSERT INTO `role_authority` VALUES ('20', '2', '16', '1');
INSERT INTO `role_authority` VALUES ('21', '4', '16', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(10) DEFAULT NULL COMMENT '0为超级管理员，1为教务处室主任，2为系院，3为审核员，4为教研室',
  `grouping` int(10) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_ok` int(10) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL COMMENT '所属教研室',
  `usernumber` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `parentid` (`parent_id`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_user_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_module
-- ----------------------------
DROP TABLE IF EXISTS `user_module`;
CREATE TABLE `user_module` (
  `id` varchar(255) NOT NULL,
  `uid` varchar(255) NOT NULL,
  `mid` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `is_ok` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `persion_id` (`uid`),
  KEY `model_id` (`mid`),
  CONSTRAINT `user_module_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_module_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_module
-- ----------------------------
