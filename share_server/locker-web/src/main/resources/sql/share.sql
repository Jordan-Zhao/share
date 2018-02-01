/*
 Navicat MySQL Data Transfer

 Source Server         : localhost(jordan)
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : share

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 01/02/2018 10:30:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shr_check_code
-- ----------------------------
DROP TABLE IF EXISTS `shr_check_code`;
CREATE TABLE `shr_check_code` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(128) DEFAULT NULL,
  `check_id` varchar(128) DEFAULT NULL,
  `check_code` varchar(128) DEFAULT NULL COMMENT '手机或邮箱注册时，生成的验证码',
  `expire_time` bigint(11) DEFAULT NULL COMMENT '从发送验证码开始计算，单位：秒',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_check_code
-- ----------------------------
BEGIN;
INSERT INTO `shr_check_code` VALUES (1, NULL, '18688888888', '813843', 600000, '2018-01-26 16:40:09', '2018-01-26 16:40:09', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (2, NULL, '18688888888', '559031', 600000, '2018-01-26 17:02:04', '2018-01-26 17:02:04', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (3, NULL, '18799999999', '298900', 600000, '2018-01-26 18:22:53', '2018-01-26 18:22:53', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (4, NULL, '13555555555', '777244', 600000, '2018-01-26 20:44:17', '2018-01-26 20:44:17', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (5, 'USER_REGISTER', '18688888886', '523691', 600000, '2018-01-27 14:32:45', '2018-01-27 14:32:45', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (6, 'PUT', '64', '297043', 600000, '2018-01-27 14:34:07', '2018-01-27 14:34:07', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (7, 'PUT', '65', '900409', 600000, '2018-01-27 14:39:02', '2018-01-27 14:39:02', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (8, 'PUT', '66', '187996', 600000, '2018-01-27 16:40:41', '2018-01-27 16:40:41', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (9, 'PUT', '67', '565183', 600000, '2018-01-27 16:41:59', '2018-01-27 16:41:59', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (10, 'PUT', '68', '280181', 600000, '2018-01-27 16:42:45', '2018-01-27 16:42:45', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (11, 'PUT', '69', '873224', 600000, '2018-01-27 16:44:12', '2018-01-27 16:44:12', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (12, 'PUT', '70', '848508', 600000, '2018-01-27 16:44:22', '2018-01-27 16:44:22', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (13, 'PUT', '71', '375302', 600000, '2018-01-27 16:44:44', '2018-01-27 16:44:44', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (14, 'PUT', '72', '599638', 600000, '2018-01-27 16:45:56', '2018-01-27 16:45:56', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (15, 'PUT', '73', '369790', 600000, '2018-01-27 16:49:13', '2018-01-27 16:49:13', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (16, 'PUT', '74', '341555', 600000, '2018-01-27 16:54:56', '2018-01-27 16:54:56', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (17, 'PUT', '75', '108031', 600000, '2018-01-27 17:05:42', '2018-01-27 17:05:42', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (18, 'PUT', '76', '486812', 600000, '2018-01-27 17:08:07', '2018-01-27 17:08:07', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (19, 'PUT', '77', '145405', 600000, '2018-01-27 17:12:39', '2018-01-27 17:12:39', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (20, 'PUT', '78', '460623', 600000, '2018-01-27 17:16:27', '2018-01-27 17:16:27', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (21, 'PUT', '79', '259941', 600000, '2018-01-27 17:22:18', '2018-01-27 17:22:18', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (22, 'PUT', '80', '915785', 600000, '2018-01-27 17:41:20', '2018-01-27 17:41:20', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (23, 'PUT', '81', '407670', 600001, '2018-01-27 17:42:57', '2018-01-27 17:42:57', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (24, 'USER_REGISTER', '18611111111', '690362', 600000, '2018-01-28 11:32:12', '2018-01-28 11:32:12', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (25, 'PUT', '82', '964975', 600000, '2018-01-28 11:34:31', '2018-01-28 11:34:31', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (26, 'PUT', '86', '555598', 600000, '2018-01-30 17:12:18', '2018-01-30 17:12:18', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (27, 'PUT', '87', '451347', 600000, '2018-01-30 17:13:19', '2018-01-30 17:13:19', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (28, 'PUT', '88', '779659', 600000, '2018-01-30 17:19:38', '2018-01-30 17:19:38', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (29, 'PUT', '89', '238387', 600000, '2018-01-30 17:27:05', '2018-01-30 17:27:05', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (30, 'PUT', '90', '178664', 600000, '2018-01-30 20:51:03', '2018-01-30 20:51:03', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (31, 'PUT', '91', '345892', 600000, '2018-01-31 09:28:55', '2018-01-31 09:28:55', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (32, 'PUT', '92', '470916', 600000, '2018-01-31 10:31:33', '2018-01-31 10:31:33', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (33, 'TAKE', '12', '046899', 3600000, '2018-01-31 10:41:41', '2018-01-31 10:41:41', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (34, 'PUT', '93', '676240', 600000, '2018-01-31 13:09:13', '2018-01-31 13:09:13', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (35, 'RETURN', '12', '289155', 3600000, '2018-02-01 09:42:09', '2018-02-01 09:42:09', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (36, 'TAKE', '13', '136527', 3600000, '2018-02-01 10:03:25', '2018-02-01 10:03:25', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (37, 'RETURN', '13', '443750', 3600000, '2018-02-01 10:05:26', '2018-02-01 10:05:26', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_check_code` VALUES (38, 'PUT', '94', '690735', 600000, '2018-02-01 10:22:00', '2018-02-01 10:22:00', 'EDITOR_SYSTEM', 'VALID');
COMMIT;

-- ----------------------------
-- Table structure for shr_item
-- ----------------------------
DROP TABLE IF EXISTS `shr_item`;
CREATE TABLE `shr_item` (
  `item_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `price_time_unit` varchar(32) DEFAULT NULL COMMENT '时间单位：DAY，HALF_DAY,HOUR',
  `price_time` bigint(11) DEFAULT NULL COMMENT '计价时间单元：1天，2天，3小时',
  `price` bigint(11) DEFAULT NULL COMMENT '一个时间单元的租金（单位是分）：1天5元，则取500.',
  `deposit` bigint(11) DEFAULT NULL COMMENT '单位：分',
  `locker_size_code` varchar(128) DEFAULT NULL COMMENT '柜门尺寸编码，值存在setting表',
  `locker_id` bigint(11) DEFAULT NULL COMMENT '柜门id',
  `description` varchar(512) DEFAULT NULL,
  `publish_status` varchar(128) DEFAULT NULL COMMENT '发布时设置的状态，上架或下架',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_item
-- ----------------------------
BEGIN;
INSERT INTO `shr_item` VALUES (92, 6, '适用年龄：30-34周岁', 'DAY', 2, 200, 22200, 'MIN', 1517365762306, '材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n适用年龄：30-34周岁\n\n\n\n', 'ONLINE', '2018-01-31 10:31:32', '2018-01-31 10:31:32', 'null;18799999999', 'ONLINE');
INSERT INTO `shr_item` VALUES (93, 6, '服装款式细节：立体裁剪', 'DAY', 3, 5000, 50000, 'MIN', 1517375293710, '材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n适用年龄：30-34周岁\n\n\n  \n', 'ONLINE', '2018-01-31 13:09:12', '2018-01-31 13:09:12', 'null;18799999999', 'GENERATED_PUT_QRCODE');
INSERT INTO `shr_item` VALUES (94, 7, '黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）', 'DAY', 2, 500, 15000, 'MIN', 1517451546009, '材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n材质：棉\n\n材质成分：棉70% 聚酯纤维25.1% 聚氨酯弹性纤维(氨纶)4.9%\n\n裤长：长裤\n\n销售渠道类型：纯电商(只在线上销售)\n\n货号：0 23\n\n女裤裤型：哈伦裤\n\n女裤腰高：高腰\n\n面料：棉布\n\n风格：通勤\n\n通勤：韩版\n\n颜色分类：黑色加绒（升级款） 灰色加绒（升级款） 蓝色加绒（升级款）\n\n品牌：三桔\n\n尺寸：M L XL 2XL 3XL 4XL 5XL\n\n成分含量：71%(含)-80%(含)\n\n服装款式细节：立体裁剪\n\n厚薄：加厚\n\n年份季节：2017年冬季\n\n适用年龄：30-34周岁', 'ONLINE', '2018-02-01 10:21:59', '2018-02-01 10:21:59', 'null;13555555555', 'ONLINE');
COMMIT;

-- ----------------------------
-- Table structure for shr_item_img
-- ----------------------------
DROP TABLE IF EXISTS `shr_item_img`;
CREATE TABLE `shr_item_img` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(11) DEFAULT NULL,
  `img_size_code` varchar(64) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_item_img
-- ----------------------------
BEGIN;
INSERT INTO `shr_item_img` VALUES (105, 43, 'small', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-23 23:12:06', '2018-01-23 23:12:06', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (106, 43, 'normal', 'http://192.168.2.195:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-23 23:12:06', '2018-01-23 23:12:06', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (107, 44, 'small', 'http://192.168.2.195:8080/locker/images/small/IMG_20180121_165549.jpg', '2018-01-23 23:13:21', '2018-01-23 23:13:21', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (108, 44, 'small', 'http://192.168.2.195:8080/locker/images/small/IMG_20180121_165602.jpg', '2018-01-23 23:13:21', '2018-01-23 23:13:21', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (109, 44, 'normal', 'http://192.168.2.195:8080/locker/images/normal/IMG_20180121_165549.jpg', '2018-01-23 23:13:21', '2018-01-23 23:13:21', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (110, 44, 'normal', 'http://192.168.2.195:8080/locker/images/normal/IMG_20180121_165602.jpg', '2018-01-23 23:13:21', '2018-01-23 23:13:21', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (111, 45, 'small', 'http://192.168.2.195:8080/locker/images/small/IMG_20180121_165600.jpg', '2018-01-24 12:19:12', '2018-01-24 12:19:12', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (112, 45, 'normal', 'http://192.168.2.195:8080/locker/images/normal/IMG_20180121_165600.jpg', '2018-01-24 12:19:12', '2018-01-24 12:19:12', NULL, 'valid');
INSERT INTO `shr_item_img` VALUES (113, 46, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (114, 46, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165526.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (115, 46, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165549.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (116, 46, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (117, 46, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165526.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (118, 46, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165549.jpg', '2018-01-24 20:29:50', '2018-01-24 20:29:50', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (119, 47, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165558.jpg', '2018-01-25 09:24:32', '2018-01-25 09:24:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (120, 47, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165558.jpg', '2018-01-25 09:24:32', '2018-01-25 09:24:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (121, 48, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 10:07:43', '2018-01-25 10:07:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (122, 48, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165549.jpg', '2018-01-25 10:07:43', '2018-01-25 10:07:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (123, 48, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 10:07:43', '2018-01-25 10:07:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (124, 48, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165549.jpg', '2018-01-25 10:07:43', '2018-01-25 10:07:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (125, 49, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 10:08:33', '2018-01-25 10:08:33', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (126, 49, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 10:08:33', '2018-01-25 10:08:33', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (127, 50, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 10:11:29', '2018-01-25 10:11:29', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (128, 50, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 10:11:29', '2018-01-25 10:11:29', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (129, 51, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 10:22:16', '2018-01-25 10:22:16', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (130, 51, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 10:22:16', '2018-01-25 10:22:16', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (131, 52, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 11:23:26', '2018-01-25 11:23:26', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (132, 52, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 11:23:26', '2018-01-25 11:23:26', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (133, 53, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 11:24:05', '2018-01-25 11:24:05', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (134, 53, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 11:24:05', '2018-01-25 11:24:05', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (135, 54, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165602.jpg', '2018-01-25 11:53:41', '2018-01-25 11:53:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (136, 54, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 11:53:41', '2018-01-25 11:53:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (137, 54, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165602.jpg', '2018-01-25 11:53:41', '2018-01-25 11:53:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (138, 54, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 11:53:41', '2018-01-25 11:53:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (139, 55, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165558.jpg', '2018-01-25 11:54:12', '2018-01-25 11:54:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (140, 55, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-25 11:54:12', '2018-01-25 11:54:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (141, 55, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165558.jpg', '2018-01-25 11:54:12', '2018-01-25 11:54:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (142, 55, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-25 11:54:12', '2018-01-25 11:54:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (143, 56, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165533.jpg', '2018-01-25 11:58:09', '2018-01-25 11:58:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (144, 56, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165529.jpg', '2018-01-25 11:58:09', '2018-01-25 11:58:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (145, 56, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165533.jpg', '2018-01-25 11:58:09', '2018-01-25 11:58:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (146, 56, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165529.jpg', '2018-01-25 11:58:09', '2018-01-25 11:58:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (147, 57, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-26 01:20:09', '2018-01-26 01:20:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (148, 57, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-26 01:20:09', '2018-01-26 01:20:09', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (149, 58, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165602.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (150, 58, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165549.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (151, 58, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165529.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (152, 58, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (153, 58, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165602.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (154, 58, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165549.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (155, 58, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165529.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (156, 58, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-26 01:49:54', '2018-01-26 01:49:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (157, 59, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165556.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (158, 59, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165526.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (159, 59, 'SMALL', 'http://192.168.0.104:8080/locker/images/small/IMG_20180121_165523.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (160, 59, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165556.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (161, 59, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165526.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (162, 59, 'NORMAL', 'http://192.168.0.104:8080/locker/images/normal/IMG_20180121_165523.jpg', '2018-01-26 20:41:25', '2018-01-26 20:41:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (163, 60, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516988999638_IMG_20180121_165523.jpg', '2018-01-27 01:49:59', '2018-01-27 01:49:59', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (164, 61, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516989757546_IMG_20180121_165529.jpg', '2018-01-27 02:03:25', '2018-01-27 02:03:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (165, 61, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516989803957_IMG_20180121_165523.jpg', '2018-01-27 02:03:25', '2018-01-27 02:03:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (166, 61, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516989757546_IMG_20180121_165529.jpg', '2018-01-27 02:03:25', '2018-01-27 02:03:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (167, 61, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516989803957_IMG_20180121_165523.jpg', '2018-01-27 02:03:25', '2018-01-27 02:03:25', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (168, 62, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516990439399_IMG_20180121_165526.jpg', '2018-01-27 02:14:02', '2018-01-27 02:14:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (169, 62, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516990441948_IMG_20180121_165523.jpg', '2018-01-27 02:14:02', '2018-01-27 02:14:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (170, 62, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516990439399_IMG_20180121_165526.jpg', '2018-01-27 02:14:02', '2018-01-27 02:14:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (171, 62, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516990441948_IMG_20180121_165523.jpg', '2018-01-27 02:14:02', '2018-01-27 02:14:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (172, 63, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516990682935_IMG_20180121_165529.jpg', '2018-01-27 02:18:03', '2018-01-27 02:18:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (173, 63, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1516990683087_IMG_20180121_165523.jpg', '2018-01-27 02:18:03', '2018-01-27 02:18:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (174, 63, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516990682935_IMG_20180121_165529.jpg', '2018-01-27 02:18:03', '2018-01-27 02:18:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (175, 63, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1516990683087_IMG_20180121_165523.jpg', '2018-01-27 02:18:03', '2018-01-27 02:18:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (176, 64, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517034845506_IMG_20180121_165529.jpg', '2018-01-27 14:34:07', '2018-01-27 14:34:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (177, 64, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517034847014_IMG_20180121_165526.jpg', '2018-01-27 14:34:07', '2018-01-27 14:34:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (178, 64, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517034845506_IMG_20180121_165529.jpg', '2018-01-27 14:34:07', '2018-01-27 14:34:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (179, 64, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517034847014_IMG_20180121_165526.jpg', '2018-01-27 14:34:07', '2018-01-27 14:34:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (180, 65, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517035141855_IMG_20180121_165556.jpg', '2018-01-27 14:39:02', '2018-01-27 14:39:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (181, 65, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517035141947_IMG_20180121_165526.jpg', '2018-01-27 14:39:02', '2018-01-27 14:39:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (182, 65, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517035141855_IMG_20180121_165556.jpg', '2018-01-27 14:39:02', '2018-01-27 14:39:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (183, 65, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517035141947_IMG_20180121_165526.jpg', '2018-01-27 14:39:02', '2018-01-27 14:39:02', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (184, 66, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042439675_IMG_20180121_165556.jpg', '2018-01-27 16:40:40', '2018-01-27 16:40:40', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (185, 66, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042440244_IMG_20180121_165526.jpg', '2018-01-27 16:40:40', '2018-01-27 16:40:40', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (186, 66, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042439675_IMG_20180121_165556.jpg', '2018-01-27 16:40:40', '2018-01-27 16:40:40', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (187, 66, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042440244_IMG_20180121_165526.jpg', '2018-01-27 16:40:40', '2018-01-27 16:40:40', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (188, 67, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042518393_IMG_20180121_165556.jpg', '2018-01-27 16:41:58', '2018-01-27 16:41:58', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (189, 67, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042518420_IMG_20180121_165526.jpg', '2018-01-27 16:41:58', '2018-01-27 16:41:58', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (190, 67, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042518393_IMG_20180121_165556.jpg', '2018-01-27 16:41:58', '2018-01-27 16:41:58', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (191, 67, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042518420_IMG_20180121_165526.jpg', '2018-01-27 16:41:58', '2018-01-27 16:41:58', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (192, 68, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042564448_IMG_20180121_165556.jpg', '2018-01-27 16:42:44', '2018-01-27 16:42:44', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (193, 68, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042564467_IMG_20180121_165526.jpg', '2018-01-27 16:42:44', '2018-01-27 16:42:44', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (194, 68, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042564448_IMG_20180121_165556.jpg', '2018-01-27 16:42:44', '2018-01-27 16:42:44', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (195, 68, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042564467_IMG_20180121_165526.jpg', '2018-01-27 16:42:44', '2018-01-27 16:42:44', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (196, 69, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042651429_IMG_20180121_165556.jpg', '2018-01-27 16:44:12', '2018-01-27 16:44:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (197, 69, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042651653_IMG_20180121_165526.jpg', '2018-01-27 16:44:12', '2018-01-27 16:44:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (198, 69, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042651429_IMG_20180121_165556.jpg', '2018-01-27 16:44:12', '2018-01-27 16:44:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (199, 69, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042651653_IMG_20180121_165526.jpg', '2018-01-27 16:44:12', '2018-01-27 16:44:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (200, 70, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042662093_IMG_20180121_165556.jpg', '2018-01-27 16:44:22', '2018-01-27 16:44:22', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (201, 70, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042662134_IMG_20180121_165526.jpg', '2018-01-27 16:44:22', '2018-01-27 16:44:22', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (202, 70, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042662093_IMG_20180121_165556.jpg', '2018-01-27 16:44:22', '2018-01-27 16:44:22', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (203, 70, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042662134_IMG_20180121_165526.jpg', '2018-01-27 16:44:22', '2018-01-27 16:44:22', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (204, 71, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042683051_IMG_20180121_165556.jpg', '2018-01-27 16:44:43', '2018-01-27 16:44:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (205, 71, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042683087_IMG_20180121_165526.jpg', '2018-01-27 16:44:43', '2018-01-27 16:44:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (206, 71, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042683051_IMG_20180121_165556.jpg', '2018-01-27 16:44:43', '2018-01-27 16:44:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (207, 71, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042683087_IMG_20180121_165526.jpg', '2018-01-27 16:44:43', '2018-01-27 16:44:43', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (208, 72, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042755994_IMG_20180121_165556.jpg', '2018-01-27 16:45:56', '2018-01-27 16:45:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (209, 72, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042756017_IMG_20180121_165526.jpg', '2018-01-27 16:45:56', '2018-01-27 16:45:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (210, 72, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042755994_IMG_20180121_165556.jpg', '2018-01-27 16:45:56', '2018-01-27 16:45:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (211, 72, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042756017_IMG_20180121_165526.jpg', '2018-01-27 16:45:56', '2018-01-27 16:45:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (212, 73, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042952749_IMG_20180121_165556.jpg', '2018-01-27 16:49:13', '2018-01-27 16:49:13', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (213, 73, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517042952825_IMG_20180121_165529.jpg', '2018-01-27 16:49:13', '2018-01-27 16:49:13', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (214, 73, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042952749_IMG_20180121_165556.jpg', '2018-01-27 16:49:13', '2018-01-27 16:49:13', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (215, 73, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517042952825_IMG_20180121_165529.jpg', '2018-01-27 16:49:13', '2018-01-27 16:49:13', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (216, 74, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517043295841_IMG_20180121_165556.jpg', '2018-01-27 16:54:55', '2018-01-27 16:54:55', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (217, 74, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517043295841_IMG_20180121_165556.jpg', '2018-01-27 16:54:55', '2018-01-27 16:54:55', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (218, 75, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517043940211_IMG_20180121_165556.jpg', '2018-01-27 17:05:41', '2018-01-27 17:05:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (219, 75, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517043940961_IMG_20180121_165526.jpg', '2018-01-27 17:05:41', '2018-01-27 17:05:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (220, 75, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517043940211_IMG_20180121_165556.jpg', '2018-01-27 17:05:41', '2018-01-27 17:05:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (221, 75, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517043940961_IMG_20180121_165526.jpg', '2018-01-27 17:05:41', '2018-01-27 17:05:41', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (222, 76, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044087117_IMG_20180121_165556.jpg', '2018-01-27 17:08:07', '2018-01-27 17:08:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (223, 76, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044087131_IMG_20180121_165526.jpg', '2018-01-27 17:08:07', '2018-01-27 17:08:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (224, 76, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044087117_IMG_20180121_165556.jpg', '2018-01-27 17:08:07', '2018-01-27 17:08:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (225, 76, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044087131_IMG_20180121_165526.jpg', '2018-01-27 17:08:07', '2018-01-27 17:08:07', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (226, 77, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044358462_IMG_20180121_165529.jpg', '2018-01-27 17:12:38', '2018-01-27 17:12:38', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (227, 77, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044358626_IMG_20180121_165533.jpg', '2018-01-27 17:12:38', '2018-01-27 17:12:38', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (228, 77, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044358462_IMG_20180121_165529.jpg', '2018-01-27 17:12:38', '2018-01-27 17:12:38', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (229, 77, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044358626_IMG_20180121_165533.jpg', '2018-01-27 17:12:38', '2018-01-27 17:12:38', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (230, 78, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044586405_IMG_20180121_165529.jpg', '2018-01-27 17:16:27', '2018-01-27 17:16:27', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (231, 78, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044587029_IMG_20180121_165556.jpg', '2018-01-27 17:16:27', '2018-01-27 17:16:27', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (232, 78, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044586405_IMG_20180121_165529.jpg', '2018-01-27 17:16:27', '2018-01-27 17:16:27', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (233, 78, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044587029_IMG_20180121_165556.jpg', '2018-01-27 17:16:27', '2018-01-27 17:16:27', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (234, 79, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044937496_IMG_20180121_165602.jpg', '2018-01-27 17:22:17', '2018-01-27 17:22:17', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (235, 79, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517044937578_IMG_20180121_165526.jpg', '2018-01-27 17:22:17', '2018-01-27 17:22:17', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (236, 79, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044937496_IMG_20180121_165602.jpg', '2018-01-27 17:22:17', '2018-01-27 17:22:17', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (237, 79, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517044937578_IMG_20180121_165526.jpg', '2018-01-27 17:22:17', '2018-01-27 17:22:17', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (238, 80, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517046079098_IMG_20180121_165523.jpg', '2018-01-27 17:41:20', '2018-01-27 17:41:20', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (239, 80, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517046079098_IMG_20180121_165523.jpg', '2018-01-27 17:41:20', '2018-01-27 17:41:20', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (240, 81, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517046176459_IMG_20180121_165529.jpg', '2018-01-27 17:42:56', '2018-01-27 17:42:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (241, 81, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517046176459_IMG_20180121_165529.jpg', '2018-01-27 17:42:56', '2018-01-27 17:42:56', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (242, 82, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517110469807_itemb.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (243, 82, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517110470399_iteme.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (244, 82, 'SMALL', 'http://192.168.0.104:8080/images/small/image_1517110470454_itema.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (245, 82, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517110469807_itemb.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (246, 82, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517110470399_iteme.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (247, 82, 'NORMAL', 'http://192.168.0.104:8080/images/normal/image_1517110470454_itema.jpg', '2018-01-28 11:34:30', '2018-01-28 11:34:30', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (248, 86, 'SMALL', 'http://localhost:8080/images/small/image_1517303512932_IMG_20180130_090118.jpg', '2018-01-30 17:12:18', '2018-01-30 17:12:18', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (249, 86, 'NORMAL', 'http://localhost:8080/images/normal/image_1517303512932_IMG_20180130_090118.jpg', '2018-01-30 17:12:18', '2018-01-30 17:12:18', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (250, 87, 'SMALL', 'http://localhost:8080/images/small/image_1517303598479_IMG_20180130_090127.jpg', '2018-01-30 17:13:18', '2018-01-30 17:13:18', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (251, 87, 'NORMAL', 'http://localhost:8080/images/normal/image_1517303598479_IMG_20180130_090127.jpg', '2018-01-30 17:13:18', '2018-01-30 17:13:18', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (252, 88, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517303977051_IMG_20180130_090123.jpg', '2018-01-30 17:19:37', '2018-01-30 17:19:37', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (253, 88, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517303977051_IMG_20180130_090123.jpg', '2018-01-30 17:19:37', '2018-01-30 17:19:37', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (254, 89, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517304424654_IMG_20180130_090107.jpg', '2018-01-30 17:27:04', '2018-01-30 17:27:04', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (255, 89, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517304424676_IMG_20180130_090116_1.jpg', '2018-01-30 17:27:04', '2018-01-30 17:27:04', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (256, 89, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517304424654_IMG_20180130_090107.jpg', '2018-01-30 17:27:04', '2018-01-30 17:27:04', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (257, 89, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517304424676_IMG_20180130_090116_1.jpg', '2018-01-30 17:27:04', '2018-01-30 17:27:04', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (258, 90, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517316662428_IMG_20180130_090116_1.jpg', '2018-01-30 20:51:03', '2018-01-30 20:51:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (259, 90, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517316662428_IMG_20180130_090116_1.jpg', '2018-01-30 20:51:03', '2018-01-30 20:51:03', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (260, 91, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517362133290_IMG_20180131_011107.jpg', '2018-01-31 09:28:54', '2018-01-31 09:28:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (261, 91, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517362133290_IMG_20180131_011107.jpg', '2018-01-31 09:28:54', '2018-01-31 09:28:54', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (262, 92, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517365892672_IMG_20180131_022548.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (263, 92, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517365892707_IMG_20180131_022543.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (264, 92, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517365892718_IMG_20180131_011107.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (265, 92, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517365892672_IMG_20180131_022548.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (266, 92, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517365892707_IMG_20180131_022543.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (267, 92, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517365892718_IMG_20180131_011107.jpg', '2018-01-31 10:31:32', '2018-01-31 10:31:32', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (268, 93, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517375351647_IMG_20180131_022548.jpg', '2018-01-31 13:09:12', '2018-01-31 13:09:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (269, 93, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517375352490_IMG_20180131_011107.jpg', '2018-01-31 13:09:12', '2018-01-31 13:09:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (270, 93, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517375351647_IMG_20180131_022548.jpg', '2018-01-31 13:09:12', '2018-01-31 13:09:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (271, 93, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517375352490_IMG_20180131_011107.jpg', '2018-01-31 13:09:12', '2018-01-31 13:09:12', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (272, 94, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517451718841_IMG_20180131_022548.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (273, 94, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517451719635_IMG_20180131_022543.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (274, 94, 'SMALL', 'http://192.168.0.103:8080/images/small/image_1517451719652_IMG_20180131_011107.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (275, 94, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517451718841_IMG_20180131_022548.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (276, 94, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517451719635_IMG_20180131_022543.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
INSERT INTO `shr_item_img` VALUES (277, 94, 'NORMAL', 'http://192.168.0.103:8080/images/normal/image_1517451719652_IMG_20180131_011107.jpg', '2018-02-01 10:22:00', '2018-02-01 10:22:00', NULL, 'VALID');
COMMIT;

-- ----------------------------
-- Table structure for shr_locker
-- ----------------------------
DROP TABLE IF EXISTS `shr_locker`;
CREATE TABLE `shr_locker` (
  `locker_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `machine_id` varchar(256) DEFAULT NULL COMMENT '所在的机柜id',
  `width` int(32) DEFAULT NULL COMMENT '宽度，单位mm',
  `height` int(32) DEFAULT NULL COMMENT '高度：mm',
  `length` int(32) DEFAULT NULL COMMENT '长度，单位mm',
  `location` varchar(256) DEFAULT NULL COMMENT '地址',
  `latitude` float(16,0) DEFAULT NULL COMMENT '纬度',
  `longitude` float(16,0) DEFAULT NULL COMMENT '经度',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`locker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_locker
-- ----------------------------
BEGIN;
INSERT INTO `shr_locker` VALUES (1, '1', 20, 20, 20, '杭州市紫金花路66号', 103, 201, '2018-01-24 11:34:18', '2018-01-24 11:34:21', 'Jordan', 'VALID');
INSERT INTO `shr_locker` VALUES (2, '2', 30, 30, 30, '江晖路1号', 111, 121, '2018-01-24 11:35:15', '2018-01-24 11:35:21', 'Jordan', 'VALID');
INSERT INTO `shr_locker` VALUES (3, '3', 100, 100, 100, '杭州市紫金花路66号', 105, 100, '2018-01-24 11:36:07', '2018-01-24 11:36:11', 'Jordan', 'VALID');
COMMIT;

-- ----------------------------
-- Table structure for shr_machine
-- ----------------------------
DROP TABLE IF EXISTS `shr_machine`;
CREATE TABLE `shr_machine` (
  `machine_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`machine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_machine
-- ----------------------------
BEGIN;
INSERT INTO `shr_machine` VALUES (1, '浙大东门1号柜', '杭州市紫金花路66号', '2018-01-24 11:38:24', '2018-01-24 11:38:26', 'Jordan', 'VALID');
INSERT INTO `shr_machine` VALUES (2, '江晖路16号柜', '江晖路1号', '2018-01-24 11:39:08', '2018-01-24 11:39:11', 'Jordan', 'VALID');
INSERT INTO `shr_machine` VALUES (3, '浙大西门3号柜', '杭州市紫金花路66号', '2018-01-24 11:39:36', '2018-01-24 11:39:40', 'Jordan', 'VALID');
COMMIT;

-- ----------------------------
-- Table structure for shr_operation_config
-- ----------------------------
DROP TABLE IF EXISTS `shr_operation_config`;
CREATE TABLE `shr_operation_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `config_code` varchar(128) DEFAULT NULL,
  `content` varchar(512) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_operation_config
-- ----------------------------
BEGIN;
INSERT INTO `shr_operation_config` VALUES (1, 'OPERATION_BANNER', '[{\"imgUrl\":\"http://192.168.0.104:8080/locker/banner1.png\",\"itemId\":46},{\"imgUrl\":\"http://192.168.0.104:8080/locker/banner2.png\",\"itemId\":46},{\"imgUrl\":\"http://192.168.0.104:8080/locker/banner3.png\",\"itemId\":46}]', '2018-01-18 11:28:58', '2018-01-18 11:29:02', 'Jordan', '1');
INSERT INTO `shr_operation_config` VALUES (2, 'OPERATION_CENTER', '{\"leftImgUrl\":\"http://192.168.0.104:8080/locker/home_item4.png\",\"leftTxt\":\"带妹子去兜风吧\",\"leftItemId\":46,\"rightImgUrl1\":\"http://192.168.0.104:8080/locker/home_item2.png\",\"rightTitle1\":\"里面有什么？\",\"rightTxt1\":\"我也不知道，租回去看看就晓得了。\",\"rightItemId1\":46,\"rightImgUrl2\":\"http://192.168.0.104:8080/locker/home_item3.png\",\"rightTitle2\":\"狼人杀全套，快抢吧！\",\"rightTxt2\":\"才用了几次，九层新。\",\"rightItemId2\":46}', '2018-01-18 11:35:23', '2018-01-18 11:35:25', 'Jordan', '1');
COMMIT;

-- ----------------------------
-- Table structure for shr_order
-- ----------------------------
DROP TABLE IF EXISTS `shr_order`;
CREATE TABLE `shr_order` (
  `order_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(11) DEFAULT NULL,
  `owner_id` bigint(11) DEFAULT NULL COMMENT '货主user id',
  `renter_id` bigint(11) DEFAULT NULL COMMENT '租客user id',
  `deposit` bigint(11) DEFAULT NULL COMMENT '押金，单位：分',
  `title` varchar(256) DEFAULT NULL,
  `take_time` datetime DEFAULT NULL COMMENT '取件时间',
  `fee` bigint(11) DEFAULT NULL COMMENT '金额（租金）',
  `return_locker_id` bigint(11) DEFAULT NULL COMMENT '归还到的locker id',
  `return_time` datetime DEFAULT NULL COMMENT '归还时间',
  `check_time` datetime DEFAULT NULL COMMENT '归还后，管理员check宝贝的时间',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL COMMENT '未支付；\r\n已支付押金；\r\n待取件\r\n租用前申请退押金；\r\n取消；\r\n租用中；\r\n还件中；\r\n待支付租金；\r\n租金支付成功；\r\n已还件；\r\n租用后退押金中；\r\n押金已退还；\r\n人工介入；\r\n无效',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_order
-- ----------------------------
BEGIN;
INSERT INTO `shr_order` VALUES (12, 92, 6, 7, 22200, '适用年龄：30-34周岁', NULL, NULL, NULL, NULL, NULL, '2018-01-27 10:39:36', '2018-01-31 10:39:36', '摘花骑士144754', 'REFUNDED_DEPOSIT');
INSERT INTO `shr_order` VALUES (13, 92, 6, 7, 22200, '适用年龄：30-34周岁', NULL, NULL, NULL, NULL, NULL, '2018-01-30 10:03:19', '2018-02-01 10:03:19', '摘花骑士144754', 'REFUNDED_DEPOSIT');
COMMIT;

-- ----------------------------
-- Table structure for shr_qrcode
-- ----------------------------
DROP TABLE IF EXISTS `shr_qrcode`;
CREATE TABLE `shr_qrcode` (
  `qrcode_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(11) DEFAULT NULL,
  `order_id` bigint(11) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL COMMENT '类型：存件；取件；还件',
  `expire_time` bigint(64) DEFAULT NULL COMMENT ' 过期时间：单位秒',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`qrcode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_register_code
-- ----------------------------
DROP TABLE IF EXISTS `shr_register_code`;
CREATE TABLE `shr_register_code` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `register_id` varchar(128) DEFAULT NULL,
  `register_code` varchar(128) DEFAULT NULL COMMENT '手机或邮箱注册时，生成的验证码',
  `expire_time` bigint(11) DEFAULT NULL COMMENT '从发送验证码开始计算，单位：秒',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_register_code
-- ----------------------------
BEGIN;
INSERT INTO `shr_register_code` VALUES (1, '18688888888', '813843', 600000, '2018-01-26 16:40:09', '2018-01-26 16:40:09', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_register_code` VALUES (2, '18688888888', '559031', 600000, '2018-01-26 17:02:04', '2018-01-26 17:02:04', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_register_code` VALUES (3, '18799999999', '298900', 600000, '2018-01-26 18:22:53', '2018-01-26 18:22:53', 'EDITOR_SYSTEM', 'VALID');
INSERT INTO `shr_register_code` VALUES (4, '13555555555', '777244', 600000, '2018-01-26 20:44:17', '2018-01-26 20:44:17', 'EDITOR_SYSTEM', 'VALID');
COMMIT;

-- ----------------------------
-- Table structure for shr_setting
-- ----------------------------
DROP TABLE IF EXISTS `shr_setting`;
CREATE TABLE `shr_setting` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(128) DEFAULT NULL COMMENT '类别',
  `key` varchar(128) DEFAULT NULL,
  `value` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shr_trade
-- ----------------------------
DROP TABLE IF EXISTS `shr_trade`;
CREATE TABLE `shr_trade` (
  `trade_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(50) DEFAULT NULL,
  `trade_type` varchar(128) DEFAULT NULL COMMENT '交易类型：租用前付押金，支付租金、租用后退押金',
  `item_id` bigint(11) DEFAULT NULL,
  `owner_id` bigint(11) DEFAULT NULL,
  `renter_id` bigint(11) DEFAULT NULL,
  `fee` bigint(11) DEFAULT NULL COMMENT '交易金额，单位：分',
  `finish_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `payment_type` varchar(64) DEFAULT NULL COMMENT '支付方式：支付宝、微信',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_trade
-- ----------------------------
BEGIN;
INSERT INTO `shr_trade` VALUES (2, 12, 'PAY_DEPOSIT', 92, 6, 7, 22200, '2018-01-31 10:41:41', 'ALIPAY', NULL, '2018-01-31 10:41:41', '2018-01-31 10:41:41', '摘花骑士144754', 'SUCCESS');
INSERT INTO `shr_trade` VALUES (3, 12, 'PAY_RENT_FEE', 92, 6, 7, 500, '2018-02-01 09:42:09', 'ALIPAY', NULL, '2018-02-01 09:42:08', '2018-02-01 09:42:08', '摘花骑士144754', 'SUCCESS');
INSERT INTO `shr_trade` VALUES (4, 12, 'PAY_RENT_FEE', 92, 6, 7, 22200, '2018-02-01 10:00:34', NULL, '退还押金', '2018-02-01 10:00:34', '2018-02-01 10:00:34', '摘花骑士144754', 'SUCCESS');
INSERT INTO `shr_trade` VALUES (5, 13, 'PAY_DEPOSIT', 92, 6, 7, 22200, '2018-02-01 10:03:25', 'ALIPAY', NULL, '2018-02-01 10:03:24', '2018-02-01 10:03:24', '摘花骑士144754', 'SUCCESS');
INSERT INTO `shr_trade` VALUES (6, 13, 'PAY_RENT_FEE', 92, 6, 7, 200, '2018-02-01 10:05:25', 'ALIPAY', NULL, '2018-02-01 10:05:25', '2018-02-01 10:05:25', '摘花骑士144754', 'SUCCESS');
INSERT INTO `shr_trade` VALUES (7, 13, 'PAY_RENT_FEE', 92, 6, 7, 22200, '2018-02-01 10:05:48', NULL, '退还押金', '2018-02-01 10:05:48', '2018-02-01 10:05:48', '摘花骑士144754', 'SUCCESS');
COMMIT;

-- ----------------------------
-- Table structure for shr_user
-- ----------------------------
DROP TABLE IF EXISTS `shr_user`;
CREATE TABLE `shr_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `phone_country` int(11) DEFAULT NULL COMMENT '电话号码的国家区号',
  `phone_number` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(256) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL COMMENT '密码，MD5保存',
  `wechat_id` varchar(256) DEFAULT NULL COMMENT '微信id',
  `nick` varchar(128) DEFAULT NULL COMMENT '昵称',
  `alipay_id` varchar(256) DEFAULT NULL COMMENT '支付宝id',
  `min_icon_url` varchar(256) DEFAULT NULL COMMENT '小头像',
  `mid_icon_url` varchar(256) DEFAULT NULL COMMENT '中等头像',
  `max_icon_url` varchar(256) DEFAULT NULL COMMENT '大头像',
  `create_time` datetime DEFAULT NULL,
  `edit_time` datetime DEFAULT NULL,
  `editor` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shr_user
-- ----------------------------
BEGIN;
INSERT INTO `shr_user` VALUES (5, 86, '18688888888', NULL, '123456', NULL, '孤独求败1001', NULL, 'http://192.168.0.104:8080/locker/icon1.png', NULL, NULL, '2018-01-26 17:02:06', '2018-01-26 17:02:06', NULL, 'VALID');
INSERT INTO `shr_user` VALUES (6, 86, '18799999999', NULL, '123456', NULL, '村里小芳566781', NULL, 'http://192.168.0.104:8080/locker/icon1.png', NULL, NULL, '2018-01-26 18:22:54', '2018-01-26 18:22:54', NULL, 'VALID');
INSERT INTO `shr_user` VALUES (7, 86, '13555555555', NULL, '123456', NULL, '摘花骑士144754', NULL, 'http://192.168.0.104:8080/locker/icon1.png', NULL, NULL, '2018-01-26 20:44:25', '2018-01-26 20:44:25', NULL, 'VALID');
INSERT INTO `shr_user` VALUES (8, 86, '18688888886', NULL, '123456', NULL, '摘花骑士320591', NULL, 'http://192.168.0.104:8080/locker/icon1.png', NULL, NULL, '2018-01-27 14:32:46', '2018-01-27 14:32:46', NULL, 'VALID');
INSERT INTO `shr_user` VALUES (9, 86, '18611111111', NULL, '123456', NULL, '村里小芳188411', NULL, 'http://192.168.0.104:8080/locker/icon1.png', NULL, NULL, '2018-01-28 11:32:21', '2018-01-28 11:32:21', NULL, 'VALID');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
