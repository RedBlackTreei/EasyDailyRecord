/*
SQLyog Ultimate v9.62 
MySQL - 6.0.11-alpha-community : Database - record
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`record` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `record`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(256) DEFAULT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '简介',
  `managerId` bigint(20) DEFAULT NULL COMMENT '部门经理Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT '1',
  `email` varchar(128) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL COMMENT '所属资源组',
  `username` varchar(36) DEFAULT NULL,
  `password` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(256) DEFAULT NULL COMMENT '部门名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '简介',
  `managerId` bigint(20) DEFAULT NULL COMMENT '资源组经理Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group` */

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `submitDate` date DEFAULT NULL COMMENT '提交日期',
  `projectAbbr` varchar(128) DEFAULT NULL COMMENT '项目简称',
  `projectStage` varchar(128) DEFAULT NULL COMMENT '项目阶段',
  `planType` varchar(128) DEFAULT NULL COMMENT '计划类型',
  `taskType` varchar(128) DEFAULT NULL COMMENT '任务类型',
  `taskDesc` varchar(128) DEFAULT NULL COMMENT '任务描述',
  `beginDate` date DEFAULT NULL COMMENT '开始日期',
  `endDate` date DEFAULT NULL COMMENT '结束日期',
  `normalHours` double DEFAULT NULL COMMENT '正常工时',
  `overTimeHours` double DEFAULT NULL COMMENT '加班工时',
  `totalHours` double DEFAULT NULL COMMENT '投入工时合计',
  `isFinished` tinyint(1) DEFAULT NULL COMMENT '是否完成',
  `employeeId` bigint(20) DEFAULT NULL COMMENT '员工Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `record` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
