/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : weekly

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-02-20 12:38:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `informationTitle` varchar(50) DEFAULT NULL,
  `information` text,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', null, '【1】北京林业大学信息\r\n   【2】研究生周报系统说明\r\n   【3】软件著作权申请说明\r\n   【4】毕设理念\r\n   \r\n   【1】 《北京林业大学信息》\r\n   单位名称：北京林业大学\r\n   法定代表人：安黎哲\r\n   统一社会信用代码/税号：12100000400006719W\r\n   地址：北京市海淀区清华东路35号\r\n   电话：010-62338301\r\n   开户行及账号：工商银行北京市东升路支行：0200006209026400903\r\n   //////////////////////////////////////////////////\r\n   \r\n   \r\n   【2】《研究生周报系统说明》\r\n   （一）概述\r\n   研究生周报是研究生和导师之间沟通的重要手段，需要真正重视，严肃对待。学习、科研、开发、日常事务进展、以及偶尔的信息收集都通过周报实现。\r\n   （二）时间和时段\r\n   从研究生入学第一周开始到毕业，周报都不间断。每周周一至周天作为一个周报周期，从周二到下周周一是周报填报时间，可以持续记录，多次提交，但每次提交都会覆盖前一次的提交。在可提交的时段内，临时信息对导师不可见。\r\n   导师从下周周二至下下周的周一对上周周报进行评阅和反馈。\r\n   （三）提交和查看周报\r\n   提交周报的后，周报将被长时间保存，可以随时查看历史周报，直至毕业。\r\n   （四）周报的重要性。\r\n   周报与技术学习、科学研究、毕业设计、研究生津贴发放等都息息相关，每一位研究生要务必写好每周的周报。\r\n   //////////////////////////////////////////////////\r\n   \r\n   【3】2019-09-27 因系统调整，中国版权保护中心（软著申请）学校的登录密码已经更改，请需要申请软著的同学登录后，勿随意更改密码。\r\n   网址：http://apply.ccopyright.com.cn/user/loginsucc.do\r\n   用户：北京林业大学\r\n   密码：68cgeQ\r\n   //////////////////////////////////////////////////\r\n   \r\n   【4】毕设理念\r\n   关于毕设，我强调一个理念：工科的论文不是写出来的，而是做出来的。有的研究生平时不写程序，不做实验，到了最后半年狂写论文，还是过不了，觉得很冤：我明明尽了最大努力写论文，为什么外审不给过？其实，这些同学的努力只是在最后半年，而且基本上是无用功。从一入学开始就要积极地写程序，用标准的方式写各种实验程序，处理各种数据，写文档记录结果，最后在论文里才有的可写，才敢写，评审时才不会被一眼看出没做系统而干些论文。\r\n   //////////////////////////////////////////////////', null);
INSERT INTO `information` VALUES ('2', '春节放假', '春节放假时间是1月25日', '2020-02-19 16:48:05');
INSERT INTO `information` VALUES ('3', '寒假', '寒假开始是1月15日', '2020-02-19 16:53:37');
INSERT INTO `information` VALUES ('4', '考试', '明天考试', '2020-02-19 16:57:24');
INSERT INTO `information` VALUES ('42', '春节放假', '春节放假', '2020-02-20 12:26:04');

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
INSERT INTO `student` VALUES ('1', '5180026', '屈玉轩', '123456', '2');
INSERT INTO `student` VALUES ('2', '5180024', '王麻子', '123456', '2');
INSERT INTO `student` VALUES ('3', '123456', '王老师', '123456', '1');
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
  `checkStatus` varchar(10) DEFAULT NULL,
  `filename` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weekly
-- ----------------------------
INSERT INTO `weekly` VALUES ('43', '5180026', '2020-02-04|2020-02-28', '1421234', '31241234', '5', '21341234', '213421341243', '2020-02-19 19:41:32', null, '未审阅', null);
INSERT INTO `weekly` VALUES ('44', '5180026', '2020-01-30|2020-02-14', '34124', '21342134', '1', '21342134', '21342134', '2020-02-19 19:46:01', '嗯嗯', '已审阅', null);
INSERT INTO `weekly` VALUES ('45', '5180024', '2020-02-04|2020-02-14', '32414', '123453214', '8', '31251234', '123421434', '2020-02-20 11:36:23', null, '未审阅', 'd:\\upload\\111.png');
INSERT INTO `weekly` VALUES ('46', '5180025', '2020-02-04|2020-02-11', '1·23214234', '344556546', '10', '456456', '5754656', '2020-02-20 12:25:18', null, '未审阅', null);
