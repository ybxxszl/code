/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50560
Source Host           : 127.0.0.1:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-08-25 13:32:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6e100bfb-9f08-4643-b328-cf0bc7078e54', 'admin', '1234', '王军岩', '男', '1995-10-16', '18743102774', '1062837400@qq.com', 'logo.jpg', '1');
INSERT INTO `user` VALUES ('c5337055-7ae7-4227-b4f7-d65e94b45575', 'test', '0000', '王军岩', '男', '1950-01-01', '18743102774', '1062837400@qq.com', 'logo.jpg', '1');
