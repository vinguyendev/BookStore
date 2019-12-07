/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100408
 Source Host           : localhost:3306
 Source Schema         : bookstore3

 Target Server Type    : MySQL
 Target Server Version : 100408
 File Encoding         : 65001

 Date: 08/12/2019 04:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, 'b133', 'Test', 'test', 'Test', 'Test', 123, 'book01.png', 1);
INSERT INTO `books` VALUES (2, 'Test 2', 'Test 2', 'Test 2', 'Test 2', 'Test 2', 123, 'book02.png', 2);
INSERT INTO `books` VALUES (3, 'TX12HT', 'Test 3', 'Test 3', 'Test 3', 'Test 3', 123, 'book02.png', 3);
INSERT INTO `books` VALUES (4, 'BSO01', 'The 7 Habits Of Highly Effective People: Powerful Lessons In Personal Change ', 'The 7 Habits Of Highly Effective People: Powerful Lessons In Personal Change\r\n\r\nOne of the most inspiring and impactful books ever written, The 7 Habits of Highly Effective People has captivated readers for 25 years. It has transformed the lives of Presidents and CEOs, educators and parents- in short, millions of people of all ages and occupations.', 'Simon and Schuster', 'Stephen R. Covey', 279000, 'book03.png', 4);
INSERT INTO `books` VALUES (5, 'TX12HT', 'Welcom to Book', 'The 7 Habits Of Highly Effective People: Powerful Lessons In Personal Change\r\n\r\nOne of the most inspiring and impactful books ever written, The 7 Habits of Highly Effective People has captivated readers for 25 years. It has transformed the lives of Presidents and CEOs, educators and parents- in short, millions of people of all ages and occupations.', 'Test', 'Test', 123, 'book02.png', 2);
INSERT INTO `books` VALUES (6, 'BSO02', 'Grit : Why Passion And Resilience Are The Secrets To Success', 'Penguin Random House', 'Penguin Random House', 'Angela Duckworth', 163200, 'Book04.png', 5);

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, 'Information Technology');
INSERT INTO `categories` VALUES (2, 'Marketing');
INSERT INTO `categories` VALUES (3, 'Accouting');
INSERT INTO `categories` VALUES (4, 'Bussiness');
INSERT INTO `categories` VALUES (5, 'Develop Person');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fullName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'client', '123', '012345', 'N V A', 'HN', 1);
INSERT INTO `users` VALUES (3, 'admin', '123', '012345', 'admin', 'HN', 2);

SET FOREIGN_KEY_CHECKS = 1;
