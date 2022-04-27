/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : springboot_db

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 20/01/2022 11:50:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book` VALUES (1, '三体', '科幻', '大刘的巅峰之作，将中国科幻推向世界舞台。总共分为三部曲：《地球往事》、《黑暗森林》、《死神永生》。');
INSERT INTO `tbl_book` VALUES (2, '格林童话', '童话', '睡前故事。');
INSERT INTO `tbl_book` VALUES (3, 'Spring 5设计模式', '计算机理论', '深入Spring源码剖析Spring源码中蕴含的10大设计模式');
INSERT INTO `tbl_book` VALUES (4, 'Spring MVC+ MyBatis开发从入门到项目实战', '计算机理论', '全方位解析面向Web应用的轻量级框架,带你成为Spring MVC开发高手');
INSERT INTO `tbl_book` VALUES (5, '轻量级Java Web企业应用实战', '计算机理论', '源码级剖析Spring框架,适合已掌握Java基础的读者');
INSERT INTO `tbl_book` VALUES (6, 'Java核心技术卷|基础知识(原书第11版)', '计算机理论', 'Core Java第11版，Jolt大奖获奖作品，针对Java SE9、10、 11全面更新');
INSERT INTO `tbl_book` VALUES (7, '深入理解Java虚拟机', '计算机理论', '5个维度全面剖析JVM,面试知识点全覆盖');
INSERT INTO `tbl_book` VALUES (8, 'Java编程思想(第4版)', '计算机理论', 'Java学习必读经典殿堂级著作!赢得了全球程序员的广泛赞誉');
INSERT INTO `tbl_book` VALUES (9, '零基础学Java (全彩版)', '计算机理论', '零基础自学编程的入门]图书，由浅入深，详解Java语言的编程思想和核心技术');
INSERT INTO `tbl_book` VALUES (10, '直播就该这么做:主播高效沟通实战指南', '市场营销', '李子柒、李佳琦、薇娅成长为网红的秘密都在书中');
INSERT INTO `tbl_book` VALUES (11, '直播销讲实战一本通', '市场营销', '和秋叶一起学系列网络营销书籍');
INSERT INTO `tbl_book` VALUES (12, '直播带货:淘宝、天猫直播从新手到高手', '市场营销', '一本教你如何玩转直播的书， 10堂课轻松实现带货月入3W+');
INSERT INTO `tbl_book` VALUES (13, 'Spring实战第5版', '计算机理论', 'Spring入门经典教程,深入理解Spring原理技术内幕');
INSERT INTO `tbl_book` VALUES (14, 'Spring 5核心原理与30个类手写实战', '计算机理论', '十年沉淀之作，写Spring精华思想');

SET FOREIGN_KEY_CHECKS = 1;
