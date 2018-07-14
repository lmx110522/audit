/*
Navicat MySQL Data Transfer

Source Server         : centos7.3
Source Server Version : 50717
Source Host           : 192.168.41.140:3306
Source Database       : aduilt

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-14 18:22:28
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
