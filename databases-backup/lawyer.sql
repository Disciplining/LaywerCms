-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: lawyer
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.19.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_agency`
--

DROP TABLE IF EXISTS `t_agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agency` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `agencyName` varchar(100) DEFAULT NULL,
  `agencyImg` varchar(255) NOT NULL,
  `agencyDetail` int(11) NOT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_article`
--

DROP TABLE IF EXISTS `t_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_article` (
  `articleId` int(10) NOT NULL AUTO_INCREMENT,
  `tpye` int(10) NOT NULL,
  `articleTitle` varchar(255) NOT NULL,
  `author` varchar(50) NOT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `content` text NOT NULL,
  `editDate` datetime NOT NULL,
  `count` int(10) NOT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_carousel`
--

DROP TABLE IF EXISTS `t_carousel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_carousel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(100) NOT NULL,
  `imgPath` varchar(255) NOT NULL,
  `editDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lawyer`
--

DROP TABLE IF EXISTS `t_lawyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lawyer` (
  `lawyerId` int(10) NOT NULL AUTO_INCREMENT,
  `lawyerName` varchar(100) NOT NULL,
  `lawyerLevel` varchar(100) NOT NULL,
  `introduction` varchar(2000) DEFAULT NULL,
  `lawyerImg` int(11) DEFAULT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`lawyerId`),
  UNIQUE KEY `t_lawyer_lawyerName_uindex` (`lawyerName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `menuId` int(10) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(100) NOT NULL,
  `parentId` int(10) NOT NULL,
  `router` varchar(100) NOT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_msgBoard`
--

DROP TABLE IF EXISTS `t_msgBoard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_msgBoard` (
  `msgId` int(10) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(100) DEFAULT NULL,
  `customerTel` varchar(100) NOT NULL,
  `caseDetail` text NOT NULL,
  `createDate` datetime NOT NULL,
  `replyId` int(10) DEFAULT NULL,
  `replyName` varchar(100) DEFAULT NULL,
  `replyDate` datetime DEFAULT NULL,
  `readFlag` tinyint(1) NOT NULL,
  PRIMARY KEY (`msgId`),
  KEY `fk_msgBoard` (`replyId`),
  KEY `fk_msgBoard_repN` (`replyName`),
  CONSTRAINT `fk_msgBoard` FOREIGN KEY (`replyId`) REFERENCES `t_lawyer` (`lawyerId`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_msgBoard_repN` FOREIGN KEY (`replyName`) REFERENCES `t_lawyer` (`lawyerName`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `loginName` varchar(100) NOT NULL,
  `realName` varchar(100) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `userTel` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-09  9:45:54
