/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-05-14 17:07:14
*/

SET FOREIGN_KEY_CHECKS=0;

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
  KEY ```` (`PatientId`),
  KEY `DoctorId` (`DoctorId`),
  CONSTRAINT ```` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_case_ibfk_1` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_case
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------

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
  PRIMARY KEY (`InspectId`),
  KEY `InspectName` (`InspectName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inspect
-- ----------------------------

-- ----------------------------
-- Table structure for t_medicine
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE `t_medicine` (
  `MedicineId` int(11) NOT NULL AUTO_INCREMENT COMMENT '药物编号,主键自增',
  `MedicineName` varchar(255) NOT NULL COMMENT '药物名称',
  `Metering` varchar(255) NOT NULL COMMENT '常用计量',
  `Description` varchar(255) NOT NULL COMMENT '描述',
  `CreateTime` varchar(255) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`MedicineId`),
  KEY `MedicineName` (`MedicineName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine
-- ----------------------------

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
  PRIMARY KEY (`PatientId`),
  KEY `WardId` (`WardId`) USING BTREE,
  KEY `InpatientName` (`PatientName`) USING BTREE,
  CONSTRAINT `t_patient_ibfk_1` FOREIGN KEY (`WardId`) REFERENCES `t_ward` (`WardId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_patient
-- ----------------------------

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
  `State` int(11) NOT NULL COMMENT '就诊状态',
  PRIMARY KEY (`RegisterId`),
  KEY `PatientId` (`PatientId`),
  KEY `DepartmentId` (`DepartmentId`),
  KEY `DoctorId` (`DoctorId`),
  CONSTRAINT `t_register_ibfk_2` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_register_ibfk_3` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_register_ibfk_4` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE
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
  PRIMARY KEY (`WardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ward
-- ----------------------------
