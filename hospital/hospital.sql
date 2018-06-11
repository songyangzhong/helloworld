/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-11 20:46:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for patient_inspect
-- ----------------------------
DROP TABLE IF EXISTS `patient_inspect`;
CREATE TABLE `patient_inspect` (
  `inspectId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `result` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patientId`,`inspectId`),
  KEY `FKdjnebuscxu6lho975fb6jxtqm` (`inspectId`),
  CONSTRAINT `patient_inspect_ibfk_1` FOREIGN KEY (`inspectId`) REFERENCES `t_inspect` (`InspectId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_inspect_ibfk_2` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient_inspect
-- ----------------------------
INSERT INTO `patient_inspect` VALUES ('2', '1', 'zheng');
INSERT INTO `patient_inspect` VALUES ('1', '2', 'zhengchang');
INSERT INTO `patient_inspect` VALUES ('3', '3', 'B超结果正常');

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES ('1', 'test-name', 'test-gender');
INSERT INTO `test_user` VALUES ('2', 'test-name', 'test-gender');
INSERT INTO `test_user` VALUES ('3', 'test-name', 'test-gender');

-- ----------------------------
-- Table structure for t_case
-- ----------------------------
DROP TABLE IF EXISTS `t_case`;
CREATE TABLE `t_case` (
  `CaseId` int(11) NOT NULL AUTO_INCREMENT COMMENT '病例编号,主键自增',
  `PatientId` int(11) NOT NULL COMMENT '病人编号,外键',
  `DoctorId` int(11) NOT NULL COMMENT '医生编号,外键',
  `Condition` varchar(255) NOT NULL COMMENT '病情描述',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`CaseId`),
  KEY `PatientId` (`PatientId`),
  KEY `DoctorId` (`DoctorId`),
  CONSTRAINT `t_case_ibfk_1` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_case_ibfk_2` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_case
-- ----------------------------
INSERT INTO `t_case` VALUES ('1', '2', '2', '感冒', '2018-05-18 20:22:07');
INSERT INTO `t_case` VALUES ('2', '3', '3', '感冒感冒感冒', '2018-05-24 23:07:02');
INSERT INTO `t_case` VALUES ('3', '3', '1', '3感冒', '2018-05-18 20:22:07');
INSERT INTO `t_case` VALUES ('4', '2', '1', '感冒', '2018-05-18 20:22:07');
INSERT INTO `t_case` VALUES ('5', '2', '2', '感冒', '2018-05-18 20:22:07');
INSERT INTO `t_case` VALUES ('6', '3', '3', '感冒感冒感冒', '2018-05-24 23:07:02');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `DepartmentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室编号,主键自增',
  `DepartmentName` varchar(255) NOT NULL COMMENT '科室名称,唯一约束',
  `RegisterCost` double(10,2) NOT NULL COMMENT '挂号费',
  `DoctorId` int(11) NOT NULL COMMENT '科室主任编号,外键',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`DepartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '内科', '12.00', '1', '2018-05-18 20:18:21');
INSERT INTO `t_department` VALUES ('2', '外科', '12.00', '1', '2018-05-18 20:18:21');
INSERT INTO `t_department` VALUES ('3', '儿科', '12.00', '1', '2018-05-18 20:18:21');
INSERT INTO `t_department` VALUES ('4', 'er科', '12.00', '1', '2018-05-18 20:18:21');

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `DoctorId` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生编号,主键自增',
  `DepartmentId` int(11) NOT NULL COMMENT '科室编号,外键',
  `DoctorName` varchar(255) NOT NULL COMMENT '姓名',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Salt` varchar(255) NOT NULL COMMENT '盐',
  `Gender` varchar(255) NOT NULL COMMENT '性别',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `PhoneNumber` varchar(255) NOT NULL COMMENT '联系方式',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`DoctorId`),
  KEY `DepartmentId` (`DepartmentId`),
  CONSTRAINT `t_doctor_ibfk_1` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('1', '1', '张三', 'F190CE9AC8445D249747CAB7BE43F7D5', '41', '男', '33', '123456', '2018-06-01 22:42:23');
INSERT INTO `t_doctor` VALUES ('2', '2', 'q', '310BFB600FA637F92AFCAC694E343CE1', '18', '男', '36', '123', '2018-06-03 15:27:12');
INSERT INTO `t_doctor` VALUES ('3', '3', 'a', '0AFE20E005F0E94AB6323371144C54EC', '1B', '男', '41', '456', '2018-06-03 15:28:17');

-- ----------------------------
-- Table structure for t_inspect
-- ----------------------------
DROP TABLE IF EXISTS `t_inspect`;
CREATE TABLE `t_inspect` (
  `InspectId` int(11) NOT NULL AUTO_INCREMENT COMMENT '检查编号,主键自增',
  `InspectName` varchar(255) NOT NULL COMMENT '检查项目名称',
  `Description` varchar(255) DEFAULT NULL COMMENT '描述',
  `Cost` double NOT NULL COMMENT '费用',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`InspectId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inspect
-- ----------------------------
INSERT INTO `t_inspect` VALUES ('1', 'B超', null, '45', '2018-05-28 20:35:03');
INSERT INTO `t_inspect` VALUES ('2', '查血aabb', null, '60', '2018-06-11 20:44:13');
INSERT INTO `t_inspect` VALUES ('3', 'B超aa', null, '45', '2018-05-28 20:35:03');
INSERT INTO `t_inspect` VALUES ('4', '查血aa', null, '60', '2018-05-28 20:05:08');
INSERT INTO `t_inspect` VALUES ('5', 'B超aabb', null, '45', '2018-05-28 20:35:03');

-- ----------------------------
-- Table structure for t_medicine
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE `t_medicine` (
  `MedicineId` int(11) NOT NULL AUTO_INCREMENT COMMENT '药物编号,主键自增',
  `MedicineName` varchar(255) NOT NULL COMMENT '药物名称',
  `Metering` varchar(255) NOT NULL COMMENT '常用计量',
  `Description` varchar(255) DEFAULT NULL COMMENT '描述',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  `Cost` decimal(10,2) NOT NULL COMMENT '花费金额',
  PRIMARY KEY (`MedicineId`),
  KEY `MedicineName` (`MedicineName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine
-- ----------------------------
INSERT INTO `t_medicine` VALUES ('1', '复方感冒灵片', '盒', null, '2018-05-28 20:21:40', '32.00');
INSERT INTO `t_medicine` VALUES ('2', '复方感冒灵片2', '盒', null, '2018-05-28 20:21:40', '32.00');
INSERT INTO `t_medicine` VALUES ('3', '复方感冒灵片3', '盒', null, '2018-05-28 20:21:40', '32.00');
INSERT INTO `t_medicine` VALUES ('4', '复方感冒灵片4', '盒', null, '2018-05-28 20:21:40', '32.00');

-- ----------------------------
-- Table structure for t_patient
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient` (
  `PatientId` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人编号,主键自增',
  `PatientName` varchar(255) NOT NULL COMMENT '姓名',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Salt` varchar(255) NOT NULL COMMENT '盐',
  `WardId` int(11) DEFAULT NULL COMMENT '病房编号,外键',
  `Age` int(11) NOT NULL COMMENT '年龄',
  `Gender` varchar(255) NOT NULL COMMENT '性别',
  `DietAdvice` varchar(255) DEFAULT NULL COMMENT '饮食建议',
  `MedicineHistory` varchar(255) DEFAULT NULL COMMENT '药物历史',
  `PhoneNumber` varchar(255) NOT NULL COMMENT '联系方式',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`PatientId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES ('1', 'aaa', 'aaa', '132', null, '123', '男', null, null, '456', '2018-05-23 16:18:25');
INSERT INTO `t_patient` VALUES ('2', 'a', 'a', '132', null, '1', '男', null, null, '1', '2018-05-23 16:22:32');
INSERT INTO `t_patient` VALUES ('3', 'aa', 'aa', '132', null, '12', '男', null, null, '456', '2018-05-23 16:37:56');
INSERT INTO `t_patient` VALUES ('4', 'q', 'FDEBF63A10AF90E441953534E8B06916', '43', null, '12', '男', '', '', '123', '2018-06-01 23:02:51');
INSERT INTO `t_patient` VALUES ('5', 'b', '28EC7098BA29EE707AE609E87EA857F0', '64', null, '45', '男', null, null, '456', '2018-06-01 23:04:29');

-- ----------------------------
-- Table structure for t_register
-- ----------------------------
DROP TABLE IF EXISTS `t_register`;
CREATE TABLE `t_register` (
  `RegisterId` int(11) NOT NULL AUTO_INCREMENT COMMENT '挂号编号,主键自增',
  `PatientId` int(11) NOT NULL COMMENT '病人编号,外键',
  `DepartmentId` int(11) NOT NULL COMMENT '科室编号,外键',
  `DoctorId` int(11) NOT NULL COMMENT '医生编号,外键',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `State` int(11) NOT NULL COMMENT '就诊状态,0刚挂号未分诊，1已分诊等待就诊，2就诊中，3挂起，4就诊完毕',
  PRIMARY KEY (`RegisterId`,`State`),
  KEY `PatientId` (`PatientId`),
  KEY `DepartmentId` (`DepartmentId`),
  KEY `DoctorId` (`DoctorId`),
  CONSTRAINT `t_register_ibfk_1` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_register_ibfk_2` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_register_ibfk_3` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_register
-- ----------------------------

-- ----------------------------
-- Table structure for t_ward
-- ----------------------------
DROP TABLE IF EXISTS `t_ward`;
CREATE TABLE `t_ward` (
  `WardId` int(11) NOT NULL AUTO_INCREMENT COMMENT '病床编号,主键自增',
  `CreateTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `Status` int(11) NOT NULL COMMENT '病床状态，1：有人住，0：没人住',
  PRIMARY KEY (`WardId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ward
-- ----------------------------
INSERT INTO `t_ward` VALUES ('1', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('2', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('3', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('4', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('5', '2018-05-15 20:20:47', '0');
