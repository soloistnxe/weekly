/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : weekly

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-02-17 14:14:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studentNumber` varchar(20) DEFAULT NULL,
  `studentName` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '5180026', '屈玉轩', '123', '2');
INSERT INTO `student` VALUES ('2', '5180024', '王麻子', '123456', '2');
INSERT INTO `student` VALUES ('3', '123456', '老师', '123', '1');
INSERT INTO `student` VALUES ('4', '5180025', '李二狗', '123456', '2');

-- ----------------------------
-- Table structure for weekly
-- ----------------------------
DROP TABLE IF EXISTS `weekly`;
CREATE TABLE `weekly` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentNumber` varchar(10) NOT NULL,
  `weeklyId` varchar(50) DEFAULT NULL,
  `learnProgress` text,
  `dailyProgress` text,
  `hour` int(5) DEFAULT NULL,
  `timeShare` text,
  `expression` text,
  `date` datetime DEFAULT NULL,
  `reviewComments` text,
  `filename` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weekly
-- ----------------------------
INSERT INTO `weekly` VALUES ('14', '5180026', '2020-01-30|2020-02-11', '23', '234', '1', '234', '124', '2020-02-15 16:22:01', null, null);
INSERT INTO `weekly` VALUES ('15', '5180026', '2020-02-28|2020-03-01', '13', '324', '1', '345', '35', '2020-02-15 16:00:00', null, null);
INSERT INTO `weekly` VALUES ('16', '5180026', '2020-02-05|2020-02-24', 'qwe', 'ew', '1', 'we', 'E', '2020-02-16 06:57:26', null, null);
INSERT INTO `weekly` VALUES ('17', '5180026', '1234-01-01|4525-01-01', '3425', '3245', '1', '325', '345', '2020-02-16 07:01:22', null, null);
INSERT INTO `weekly` VALUES ('18', '5180026', '2020-02-05|2020-02-15', '13', '2143214', '1', '153454325', '43262', '2020-02-16 07:04:11', null, null);
INSERT INTO `weekly` VALUES ('19', '5180026', '2020-02-28|2020-03-02', 'few', ' 4qt ', '1', 'ertert ', 'ret ert', '2020-02-16 07:06:39', null, null);
INSERT INTO `weekly` VALUES ('20', '5180026', '2020-02-13|2020-02-28', '325432', '652657', '1', '3466', '43636', '2020-02-16 15:10:49', null, null);
INSERT INTO `weekly` VALUES ('21', '5180024', '2020-02-05|2020-02-14', '1232', '123434', '1', '2314', '231414', '2020-02-16 17:00:26', null, null);
INSERT INTO `weekly` VALUES ('22', '5180024', '2020-02-11|2020-02-15', '4324', '23142134', '1', '2314', '2342134', '2020-02-16 17:00:46', null, null);
INSERT INTO `weekly` VALUES ('23', '5180025', '2020-02-13|2020-02-15', '12', '1234', '1', '1234', '2134', '2020-02-16 17:02:07', null, null);
INSERT INTO `weekly` VALUES ('24', '5180025', '2020-02-11|2020-02-15', '2314', '1234', '1', '124323', '42134', '2020-02-16 17:02:16', null, null);
INSERT INTO `weekly` VALUES ('25', '5180026', '2020-02-13|2020-03-03', 't\'r', '预热', '1', ' 二二幺', ' 而已', '2020-02-16 18:46:26', null, null);
