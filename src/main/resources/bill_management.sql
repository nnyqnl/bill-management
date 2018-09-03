/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : bill_management

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-03 10:55:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_deal_record
-- ----------------------------
DROP TABLE IF EXISTS `m_deal_record`;
CREATE TABLE `m_deal_record` (
  `deal_record_id` varchar(32) NOT NULL COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `deal_money` decimal(8,0) NOT NULL COMMENT '交易金额',
  `deal_type` tinyint(4) NOT NULL COMMENT '交易类型，1收入 2支出',
  `deal_classify` tinyint(4) NOT NULL COMMENT '交易分类',
  `consume_time` datetime NOT NULL COMMENT '消费时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`deal_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_deal_record
-- ----------------------------

-- ----------------------------
-- Table structure for m_dic
-- ----------------------------
DROP TABLE IF EXISTS `m_dic`;
CREATE TABLE `m_dic` (
  `class_id` tinyint(6) NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `item_id` tinyint(6) NOT NULL,
  `item_name` varchar(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`class_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_dic
-- ----------------------------
INSERT INTO `m_dic` VALUES ('1', '是否区分', '1', '是', null, null, null, null);
INSERT INTO `m_dic` VALUES ('1', '是否区分', '2', '否', null, null, null, null);
INSERT INTO `m_dic` VALUES ('2', '有无区分', '1', '有', null, null, null, null);
INSERT INTO `m_dic` VALUES ('2', '有无区分', '2', '无', null, null, null, null);
INSERT INTO `m_dic` VALUES ('3', '交易类型', '-1', '支出', null, null, null, null);
INSERT INTO `m_dic` VALUES ('3', '交易类型', '1', '收入', null, null, null, null);
INSERT INTO `m_dic` VALUES ('4', '交易分类', '1', '工资', null, null, null, null);
INSERT INTO `m_dic` VALUES ('4', '交易分类', '2', '兼职', null, null, null, null);
INSERT INTO `m_dic` VALUES ('4', '交易分类', '3', '红包', null, null, null, null);
INSERT INTO `m_dic` VALUES ('5', '交易分类', '11', '餐饮', null, null, null, null);
INSERT INTO `m_dic` VALUES ('5', '交易分类', '12', '交通', null, null, null, null);
INSERT INTO `m_dic` VALUES ('5', '交易分类', '13', '服装', null, null, null, null);
INSERT INTO `m_dic` VALUES ('5', '交易分类', '14', '零食', null, null, null, null);
INSERT INTO `m_dic` VALUES ('6', '交易分类', '15', '生活用品', null, null, null, null);
INSERT INTO `m_dic` VALUES ('6', '交易分类', '16', '礼品', null, null, null, null);
INSERT INTO `m_dic` VALUES ('6', '交易分类', '17', '红包', null, null, null, null);
INSERT INTO `m_dic` VALUES ('6', '交易分类', '18', '娱乐', null, null, null, null);
INSERT INTO `m_dic` VALUES ('6', '交易分类', '19', '旅行', null, null, null, null);

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `user_id` varchar(32) NOT NULL,
  `login_name` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', '15538103935', '15538103935', '123456', '2018-08-29 23:10:22', '2018-08-29 23:10:03', '1', '1');
