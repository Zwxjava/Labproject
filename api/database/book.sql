/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.22 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `book`;

/*Table structure for table `td_book` */

DROP TABLE IF EXISTS `td_book`;

CREATE TABLE `td_book` (
  `Nid` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '书名',
  `book_price` bigint(20) DEFAULT '0' COMMENT '价钱',
  `book_number` bigint(20) DEFAULT '0' COMMENT '书的数量',
  `isdelete` int(10) DEFAULT '0' COMMENT '0为未删除1为删除',
  `img` varchar(200) CHARACTER SET latin1 DEFAULT NULL COMMENT '图片路径',
  `typeid` bigint(20) DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`Nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `td_book` */

/*Table structure for table `td_payment` */

DROP TABLE IF EXISTS `td_payment`;

CREATE TABLE `td_payment` (
  `Nid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `book_name` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '书名',
  `book_price` bigint(20) DEFAULT '0' COMMENT '订单价钱',
  `book_number` bigint(20) DEFAULT '0' COMMENT '书本数',
  `ispayment` int(11) DEFAULT '0' COMMENT '0是没买，1是买',
  `issubmint` int(11) DEFAULT '0' COMMENT '0是未提交，1是提交',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`Nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `td_payment` */

/*Table structure for table `td_type` */

DROP TABLE IF EXISTS `td_type`;

CREATE TABLE `td_type` (
  `Nid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`Nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `td_type` */

/*Table structure for table `td_user` */

DROP TABLE IF EXISTS `td_user`;

CREATE TABLE `td_user` (
  `Nid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户密码',
  `userlevel` int(11) DEFAULT '0' COMMENT '用户级别',
  PRIMARY KEY (`Nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `td_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
