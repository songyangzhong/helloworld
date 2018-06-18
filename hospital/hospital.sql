/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-12 22:07:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doctor_patient
-- ----------------------------
DROP TABLE IF EXISTS `doctor_patient`;
CREATE TABLE `doctor_patient` (
  `doctorId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  PRIMARY KEY (`patientId`,`doctorId`),
  KEY `FK84v9kb5ab4m0jo3kchkell8ft` (`doctorId`),
  CONSTRAINT `FK84v9kb5ab4m0jo3kchkell8ft` FOREIGN KEY (`doctorId`) REFERENCES `t_doctor` (`DoctorId`),
  CONSTRAINT `FKhq6cbtwkx4cplx82pmijfdtfx` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`PatientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor_patient
-- ----------------------------
INSERT INTO `doctor_patient` VALUES ('1', '1');
INSERT INTO `doctor_patient` VALUES ('2', '3');
INSERT INTO `doctor_patient` VALUES ('3', '2');
INSERT INTO `doctor_patient` VALUES ('4', '5');
INSERT INTO `doctor_patient` VALUES ('5', '4');
INSERT INTO `doctor_patient` VALUES ('6', '4');
INSERT INTO `doctor_patient` VALUES ('7', '7');
INSERT INTO `doctor_patient` VALUES ('8', '6');
INSERT INTO `doctor_patient` VALUES ('9', '8');

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
  CONSTRAINT `FKdjnebuscxu6lho975fb6jxtqm` FOREIGN KEY (`inspectId`) REFERENCES `t_inspect` (`InspectId`),
  CONSTRAINT `FKr4oo8xvevuqisqpnpl5pyomui` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`PatientId`),
  CONSTRAINT `patient_inspect_ibfk_1` FOREIGN KEY (`inspectId`) REFERENCES `t_inspect` (`InspectId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_inspect_ibfk_2` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient_inspect
-- ----------------------------
INSERT INTO `patient_inspect` VALUES ('1', '3', 'B超结果正常');
INSERT INTO `patient_inspect` VALUES ('2', '3', '血小板低于正常水平');
INSERT INTO `patient_inspect` VALUES ('2', '4', '查血结果正常');
INSERT INTO `patient_inspect` VALUES ('3', '5', '心率不齐');
INSERT INTO `patient_inspect` VALUES ('3', '6', '心电图结果正常');
INSERT INTO `patient_inspect` VALUES ('2', '7', '红细胞低于正常水平');

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
  CONSTRAINT `FKripjt9yee2oo8evc8ebu57s8s` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`),
  CONSTRAINT `FKsj0ropwhw70hdxu68mfc4tuvt` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`),
  CONSTRAINT `t_case_ibfk_1` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_case_ibfk_2` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_case
-- ----------------------------
INSERT INTO `t_case` VALUES ('1', '4', '5', '发烧', '2018-06-12 22:05:32');
INSERT INTO `t_case` VALUES ('2', '2', '2', '感冒', '2018-06-12 22:05:25');
INSERT INTO `t_case` VALUES ('3', '3', '1', '喉咙痛', '2018-06-12 22:05:59');
INSERT INTO `t_case` VALUES ('4', '5', '4', '流鼻涕', '2018-06-12 22:06:14');
INSERT INTO `t_case` VALUES ('5', '6', '3', '拉肚子', '2018-06-12 22:06:32');
INSERT INTO `t_case` VALUES ('6', '7', '8', '头痛', '2018-06-12 22:06:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '内科', '24.00', '2', '2018-06-12 20:11:08');
INSERT INTO `t_department` VALUES ('2', '外科', '12.00', '1', '2018-05-18 20:18:21');
INSERT INTO `t_department` VALUES ('3', '儿科', '12.00', '1', '2018-05-18 20:18:21');
INSERT INTO `t_department` VALUES ('4', '中医科', '20.00', '3', '2018-06-12 20:12:09');
INSERT INTO `t_department` VALUES ('5', '口腔科', '16.00', '4', '2018-06-12 20:12:39');

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
  CONSTRAINT `FK5ccuyto6x5jilwpqjok6o6qts` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`),
  CONSTRAINT `t_doctor_ibfk_1` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('1', '5', '李四', '042AE032D823078978704DB38E0E71AE', '48', '女', '45', '14796345696', '2018-06-12 20:18:32');
INSERT INTO `t_doctor` VALUES ('2', '3', '王五', '2F322BFCD2C2E11D63C08B38ECE8C9FE', '03', '男', '36', '13936945214', '2018-06-12 20:18:35');
INSERT INTO `t_doctor` VALUES ('3', '3', '赵六', '76C72D09D2C407D71898C32C2D89A087', '12', '男', '32', '15698725312', '2018-06-12 20:18:38');
INSERT INTO `t_doctor` VALUES ('4', '3', '孙七', '3B8F52CEBEDF4C9BA7213D1D712AC531', '66', '男', '37', '16795123452', '2018-06-12 20:18:41');
INSERT INTO `t_doctor` VALUES ('5', '3', 'a', '57C98783377C2FFE8F993BE770162BFA', '52', '男', '45', '123', '2018-06-12 14:38:42');
INSERT INTO `t_doctor` VALUES ('6', '2', 'b', '770BFA31D02E5A2387D02D91F0C15ABB', '3A', '女', '32', '123', '2018-06-12 20:16:21');
INSERT INTO `t_doctor` VALUES ('7', '2', 'aaa', '44810068D7AFDA03B0EC6021F7598B76', '35', '女', '23', '123456', '2018-06-12 20:16:25');
INSERT INTO `t_doctor` VALUES ('8', '3', 'c', '97263DD2AD9C9B738C78FB773516837C', '5B', '女', '36', '123', '2018-06-12 15:59:28');
INSERT INTO `t_doctor` VALUES ('9', '4', '张三', '2CE388FA48518D6A89162C4B278BBBC5', '58', '男', '36', '178963123112', '2018-06-12 20:14:20');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inspect
-- ----------------------------
INSERT INTO `t_inspect` VALUES ('1', 'B超', null, '45', '2018-06-12 20:23:26');
INSERT INTO `t_inspect` VALUES ('2', '查血', null, '60', '2018-06-12 20:23:15');
INSERT INTO `t_inspect` VALUES ('3', '心电图', null, '60', '2018-06-12 20:24:07');

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
INSERT INTO `t_medicine` VALUES ('2', '999感冒灵颗粒', '盒', null, '2018-05-28 20:21:40', '36.00');
INSERT INTO `t_medicine` VALUES ('3', '肠胃宁', '盒', null, '2018-05-28 20:21:40', '64.00');
INSERT INTO `t_medicine` VALUES ('4', '阿莫西林胶囊', '盒', null, '2018-05-28 20:21:40', '46.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES ('1', '王五', 'D9B5A8027E4D041BAB84D218405C7F80', '6C', null, '25', '男', null, null, '16547893652', '2018-06-12 20:34:54');
INSERT INTO `t_patient` VALUES ('2', '赵六', '17DEE7291D5D205E8845E4B0D3E98292', '1F', null, '32', '女', null, null, '15896321475', '2018-06-12 20:34:12');
INSERT INTO `t_patient` VALUES ('3', '孙七', '9F8851E874F83749A669933DFA06ACC1', '56', null, '24', '女', null, null, '15698562432', '2018-06-12 20:34:15');
INSERT INTO `t_patient` VALUES ('4', 'q', 'FDEBF63A10AF90E441953534E8B06916', '43', null, '12', '男', '', '', '123', '2018-06-01 23:02:51');
INSERT INTO `t_patient` VALUES ('5', 'b', '28EC7098BA29EE707AE609E87EA857F0', '64', null, '45', '男', null, null, '456', '2018-06-01 23:04:29');
INSERT INTO `t_patient` VALUES ('6', 'aa', '403FA9032A616C7DD47590E548B7FE17', '33', null, '17', '男', '', '', '123', '2018-06-11 21:32:14');
INSERT INTO `t_patient` VALUES ('7', '张三', '1468C29CF9036B86C9AD6F8F22EEBD7C', '15', null, '25', '男', null, null, '14796345623', '2018-06-12 20:26:16');
INSERT INTO `t_patient` VALUES ('8', '李四', 'AD88EE87A6AA183452F55884D5AE7C2D', '1A', null, '53', '男', null, null, '16934578523', '2018-06-12 20:27:16');

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
  CONSTRAINT `FKgmsd2c8vwlni2i0e5oyera6ff` FOREIGN KEY (`DoctorId`) REFERENCES `t_doctor` (`DoctorId`),
  CONSTRAINT `FKjy2iuxsj0xk6p3drxxd6xfr2e` FOREIGN KEY (`DepartmentId`) REFERENCES `t_department` (`DepartmentId`),
  CONSTRAINT `FKrc7ivewxp7ddchvurnfce4a9s` FOREIGN KEY (`PatientId`) REFERENCES `t_patient` (`PatientId`),
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ward
-- ----------------------------
INSERT INTO `t_ward` VALUES ('1', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('2', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('3', '2018-05-15 20:20:47', '0');
INSERT INTO `t_ward` VALUES ('4', '2018-05-15 20:20:47', '0');
