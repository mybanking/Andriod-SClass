/*
 Navicat Premium Data Transfer

 Source Server         : rico_yang
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : android

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/12/2019 18:37:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for CQ
-- ----------------------------
DROP TABLE IF EXISTS `CQ`;
CREATE TABLE `CQ` (
  `courseId` varchar(20) COLLATE utf8_bin NOT NULL,
  `QuestionId` varchar(20) COLLATE utf8_bin NOT NULL,
  `eachPoint` smallint(20) DEFAULT NULL,
  PRIMARY KEY (`courseId`,`QuestionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of CQ
-- ----------------------------
BEGIN;
INSERT INTO `CQ` VALUES ('1', '1', 1);
COMMIT;

-- ----------------------------
-- Table structure for Collection
-- ----------------------------
DROP TABLE IF EXISTS `Collection`;
CREATE TABLE `Collection` (
  `courseName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `collectionId` int(20) NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stuId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Collection
-- ----------------------------
BEGIN;
INSERT INTO `Collection` VALUES ('1', 1, '1', '1', '1');
INSERT INTO `Collection` VALUES ('', 2, NULL, NULL, 's1');
COMMIT;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `courseId` varchar(20) COLLATE utf8_bin NOT NULL,
  `teacherId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `courseName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Information` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `major` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `taskNum` smallint(20) DEFAULT NULL,
  `time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `room` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Course
-- ----------------------------
BEGIN;
INSERT INTO `Course` VALUES ('c1', 't1', 'os', 'ok', '12 Jul 2018', '1', 1, '1', 'YF');
INSERT INTO `Course` VALUES ('c2', 't2', 'Java', 'ok', '11 Jul 2018', '1', 10, '2', 'Sy');
COMMIT;

-- ----------------------------
-- Table structure for Paper
-- ----------------------------
DROP TABLE IF EXISTS `Paper`;
CREATE TABLE `Paper` (
  `papaerId` varchar(20) COLLATE utf8_bin NOT NULL,
  `teacherId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `courseId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`papaerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for Question
-- ----------------------------
DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
  `QuestionId` smallint(20) NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `courseId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`QuestionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Question
-- ----------------------------
BEGIN;
INSERT INTO `Question` VALUES (1, '64365', '{\"answer\":\"C\",\"options\":\"A:3465346,B:34653465,C:346534634,D:536436436\",\"description\":\"64365\"}', '1');
COMMIT;

-- ----------------------------
-- Table structure for Sc
-- ----------------------------
DROP TABLE IF EXISTS `Sc`;
CREATE TABLE `Sc` (
  `stuId` varchar(20) COLLATE utf8_bin NOT NULL,
  `courseId` varchar(20) COLLATE utf8_bin NOT NULL,
  `currentPoint` smallint(6) DEFAULT NULL,
  `totalPoint` smallint(6) DEFAULT NULL,
  `being` smallint(6) DEFAULT NULL,
  `totalbeing` smallint(6) DEFAULT NULL,
  `myProgress` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stuId`,`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Sc
-- ----------------------------
BEGIN;
INSERT INTO `Sc` VALUES ('1', 'c1', 1, 1, 1, 1, '1');
INSERT INTO `Sc` VALUES ('1', 'c2', 20, 40, 5, 10, '2');
COMMIT;

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `stuId` varchar(20) COLLATE utf8_bin NOT NULL,
  `stuName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Student
-- ----------------------------
BEGIN;
INSERT INTO `Student` VALUES ('1', 'yang', '1', '839891341@qq.com', '18', 'm', '2000-05-13', 'china');
COMMIT;

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `teacherId` varchar(20) COLLATE utf8_bin NOT NULL,
  `teacherName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
BEGIN;
INSERT INTO `Teacher` VALUES ('1', '1', '0', '1', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for discussion
-- ----------------------------
DROP TABLE IF EXISTS `discussion`;
CREATE TABLE `discussion` (
  `stuId` varchar(20) COLLATE utf8_bin NOT NULL,
  `stuName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `question` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(20) COLLATE utf8_bin NOT NULL,
  `courseName` varchar(20) COLLATE utf8_bin NOT NULL,
  `totalgood` int(255) DEFAULT NULL,
  PRIMARY KEY (`stuId`,`courseName`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of discussion
-- ----------------------------
BEGIN;
INSERT INTO `discussion` VALUES ('1', NULL, '安卓', '2019年12月28日 20:57:44', 'Java', NULL);
INSERT INTO `discussion` VALUES ('1', NULL, '哈哈哈姐姐', '2019年12月28日 21:08:24', 'Java', NULL);
INSERT INTO `discussion` VALUES ('1', NULL, '孔德焱', '2019年12月28日 21:08:40', 'Java', NULL);
INSERT INTO `discussion` VALUES ('1', '1', '1', '1', 'os', 2);
INSERT INTO `discussion` VALUES ('1', NULL, '还堵', '2019年12月28日 21:08:54', 'os', 6);
INSERT INTO `discussion` VALUES ('17301066', '孔德焱', 'u读', '2019年12月28日 20:03:25', 'os', 6);
INSERT INTO `discussion` VALUES ('os', NULL, NULL, '1', '1', 0);
COMMIT;

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk` (
  `tsuId` varchar(20) COLLATE utf8_bin NOT NULL,
  `tsuName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `assess` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `tdate` varchar(20) COLLATE utf8_bin NOT NULL,
  `stuId` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `courseName` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`courseName`,`stuId`,`tdate`,`tsuId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of talk
-- ----------------------------
BEGIN;
INSERT INTO `talk` VALUES ('1', NULL, '刚刚', '2019年12月28日 22:06:24', '17301066', 'andrCooid.support.v7.widget.AppmpatTextView{bf47ff4 V.ED..... ........ 180,30-697,86 #7f0900f7 app:id/talk_date}', 'os');
INSERT INTO `talk` VALUES ('1', NULL, ' QQ', '2019年12月28日 22:06:36', '17301066', 'android.support.v7.widget.AppCompatTextView{737dc39 V.ED..... ........ 180,30-697,86 #7f0900f7 app:id/talk_date}', 'os');
INSERT INTO `talk` VALUES ('1', NULL, 'QQ', '2019年12月28日 22:09:06', '17301066', '2019年12月28日 20:03:25', 'os');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
