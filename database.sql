/*
SQLyog Community Edition- MySQL GUI v8.04 
MySQL - 5.0.37-community-nt : Database - training9
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`training9` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `training9`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(15) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`username`,`password`) values ('admin','admin');

/*Table structure for table `userdata` */

DROP TABLE IF EXISTS `userdata`;

CREATE TABLE `userdata` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) default NULL,
  `fname` varchar(15) default NULL,
  `lname` varchar(15) default NULL,
  `phone` decimal(10,0) default NULL,
  `city` varchar(15) default NULL,
  `age` decimal(3,0) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userdata` */

insert  into `userdata`(`username`,`password`,`fname`,`lname`,`phone`,`city`,`age`) values ('aman','123','aman','bhawsar','9999999999','indore','20'),('gaurav','12345','Gaurav','Gupta','1234567890','indore','21'),('john','111','john','miller','7894564500','rau','25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
