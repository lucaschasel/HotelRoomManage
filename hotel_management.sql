/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : hotel_management

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2024-10-20 09:57:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('1', '海景酒店', '大连西部海岸123号', '0411-12345678');
INSERT INTO `hotel` VALUES ('2', '阳光酒店', '大连东部市中心456号', '0411-87654321');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` int NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `info` varchar(100) DEFAULT NULL,
  `hotelId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotelId` (`hotelId`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '1', '300.00', '标准间，带有海景', '1');
INSERT INTO `room` VALUES ('2', '2', '500.00', '豪华间，包含免费早餐', '1');
INSERT INTO `room` VALUES ('3', '3', '1000.00', '总统套间，带有独立泳池', '1');
INSERT INTO `room` VALUES ('4', '1', '250.00', '标准间，交通便利', '2');
INSERT INTO `room` VALUES ('5', '2', '450.00', '豪华间，靠近购物中心', '2');
