/*
 Navicat Premium Data Transfer

 Source Server         : www.yiyezq162.xyz
 Source Server Type    : MySQL
 Source Server Version : 100332
 Source Host           : www.yiyezq162.xyz:30336
 Source Schema         : HR

 Target Server Type    : MySQL
 Target Server Version : 100332
 File Encoding         : 65001

 Date: 21/12/2022 16:57:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dep
-- ----------------------------
DROP TABLE IF EXISTS `dep`;
CREATE TABLE `dep`  (
  `dep_id` int NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dep
-- ----------------------------
INSERT INTO `dep` VALUES (1, '销售部');
INSERT INTO `dep` VALUES (2, '研发部');
INSERT INTO `dep` VALUES (3, '仓库部');
INSERT INTO `dep` VALUES (4, '财务部');
INSERT INTO `dep` VALUES (5, '商务部');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `sf_id` int NOT NULL AUTO_INCREMENT,
  `sf_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sf_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sf_age` int NULL DEFAULT NULL,
  `sf_on_time` datetime NULL DEFAULT NULL,
  `sf_dep` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sf_check` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sf_lazy` int NULL DEFAULT NULL,
  `sf_salary` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`sf_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1216176137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 'Admin', '123456', 18, '2022-12-13 17:26:48', '1', '1', '1', 17, 1.00);
INSERT INTO `staff` VALUES (3, '李四', '123', 18, '2022-12-13 17:26:48', '3', '0', '1', 10, 1.00);
INSERT INTO `staff` VALUES (13, '王五', '123456', 18, '2022-12-13 17:26:48', '4', '0', '1', 5, 10000.00);
INSERT INTO `staff` VALUES (19, '赵六', '123', 17, '2022-12-13 17:26:48', '5', '0', '1', 7, 1.00);
INSERT INTO `staff` VALUES (20, '黎锦斌', '123', 18, '2022-12-13 17:26:48', '1', '0', '0', 3, 1.00);
INSERT INTO `staff` VALUES (21, '唐静', '123', 18, '2022-12-13 17:26:48', '2', '1', '0', 16, 1.00);
INSERT INTO `staff` VALUES (22, '与雨果', '123456', 181, '2022-12-13 17:26:48', '3', '0', '0', 4, 1.00);
INSERT INTO `staff` VALUES (23, '余玉国', '123', 16, '2022-12-13 17:26:48', '4', '0', '0', 15, 1.00);
INSERT INTO `staff` VALUES (1216176129, '宋浩', '123456', 18, '2022-12-13 17:26:48', '5', '0', '0', 5, 1.00);
INSERT INTO `staff` VALUES (1216176131, '黄普格', '123456', 18, '2022-12-13 17:26:48', '1', '0', '0', 15, 1.00);
INSERT INTO `staff` VALUES (1216176135, '梁尾鱼', '123456', 18, '2022-12-13 17:26:48', '2', '0', '0', 6, 1.00);

SET FOREIGN_KEY_CHECKS = 1;
