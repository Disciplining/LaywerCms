-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: lawyer
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.16.04.1

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
  `agencyDetail` mediumtext NOT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agency`
--

LOCK TABLES `t_agency` WRITE;
/*!40000 ALTER TABLE `t_agency` DISABLE KEYS */;
INSERT INTO `t_agency` VALUES (1,'chongjie','http://xxxx','部署测试<img src=\"/images/agency-detail-pic/9ebd5961-f7ec-416e-81ad-6a9e36988725.jpeg\" alt=\"\" />就是这家决胜','0');
/*!40000 ALTER TABLE `t_agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_article`
--

DROP TABLE IF EXISTS `t_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_article` (
  `articleId` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(10) NOT NULL,
  `articleTitle` varchar(255) NOT NULL,
  `author` varchar(50) NOT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  `editDate` datetime NOT NULL,
  `count` int(10) NOT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_article`
--

LOCK TABLES `t_article` WRITE;
/*!40000 ALTER TABLE `t_article` DISABLE KEYS */;
INSERT INTO `t_article` VALUES (64,1,'死刑的判定','李艳兴111','斤斤计较军军军军军军军军军军军军','这个死刑该怎么判','2019-08-12 00:00:00',0,'1'),(65,1,'title------88888888','提提拖拖拖','哒哒哒哒哒哒多多多','哈哈哈哈哈哈哈哈哈哈哈','2019-08-15 11:19:32',0,'1'),(66,3,'题目','张伟','这是简介','这是内容','2019-08-11 00:00:00',0,'1'),(67,3,'文章名字','作者名字','简介','内容','2019-08-11 00:00:00',0,'0'),(68,1,'aaa6666666','bbb','不不不不不不不不','asdasd','2019-08-16 08:49:00',0,'0'),(69,1,'aaa','bbb','ccc','<p>\r\n	asdasd\r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/01572428-4973-4ddc-a963-ca3c07fdf136.jpeg\" alt=\"\" />\r\n</p>','2019-08-15 11:19:21',0,'0'),(70,1,'666','子','顶戴','要','1970-01-01 00:00:00',0,'0'),(71,2,'2019','111','666','666','2019-08-12 00:00:00',0,'1'),(72,1,'这是一个文章的名字','123-a','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(73,3,'这是一个文章的名字-1','123-b','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(74,3,'这是一个文章的名字-2','123-c','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(75,3,'这是一个文章的名字-3','123-d','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(76,3,'这是一个文章的名字-31','123-e','11111','aaasdasd','2019-08-14 08:33:33',0,'1'),(77,3,'这是一个文章的名字-32','123-f','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(78,3,'这是一个文章的名字-33','123-g','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(79,3,'这是一个文章的名字-34','123-h','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(80,3,'这是一个文章的名字-35','123-i','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(81,3,'这是一个文章的名字-36','123-j','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(82,1,'这是一个文章的名字-37','123-k','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(83,1,'这是一个文章的名字-38','123-l','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(84,1,'这是一个文章的名字-39','123-m','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(85,1,'这是一个文章的名字-30','123-n','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(86,1,'这是一个文章的名字-311','123-o','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(87,1,'这是一个文章的名字-312','123-p','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(88,1,'这是一个文章的名字-313','123-q','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(89,1,'这是一个文章的名字-314','123-r','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(90,1,'这是一个文章的名字-315','123-s','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(91,1,'这是一个文章的名字-316','123-t','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(92,2,'哈哈哈哈哈哈','李艳兴-a-1','这个好啊末aaa','<p>\r\n	<img src=\"http://127.0.0.1/layuiadmin/kindeditor/plugins/emoticons/images/20.gif\" alt=\"\" border=\"0\" /> \r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/32d82ae2-e395-4cdb-8d30-e98e5ab5a2fc.jpeg\" alt=\"\" /> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	adsf\r\n</p>\r\n<p>\r\n	<img src=\"http://127.0.0.1/layuiadmin/kindeditor/plugins/emoticons/images/20.gif\" alt=\"\" border=\"0\" /> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>','2019-08-16 08:49:14',0,'0');
/*!40000 ALTER TABLE `t_article` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_carousel`
--

LOCK TABLES `t_carousel` WRITE;
/*!40000 ALTER TABLE `t_carousel` DISABLE KEYS */;
INSERT INTO `t_carousel` VALUES (1,'banner1','/images/banner-pic/04.jpg','2019-01-01 00:00:00'),(2,'banner2','/images/banner-pic/02.jpg','2018-08-09 08:05:41'),(3,'banner3','/images/banner-pic/04.jpg','2019-08-09 08:06:09'),(4,'vannerName-666','/images/banner-pic/02.jpg','2019-08-07 00:00:00'),(5,'图片1','/images/banner-pic/04.jpg','2019-08-13 00:00:00'),(6,'图片2','/images/banner-pic/02.jpg','2019-08-13 00:00:00');
/*!40000 ALTER TABLE `t_carousel` ENABLE KEYS */;
UNLOCK TABLES;

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
  `lawyerImg` varchar(255) DEFAULT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  PRIMARY KEY (`lawyerId`),
  UNIQUE KEY `t_lawyer_lawyerName_uindex` (`lawyerName`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lawyer`
--

LOCK TABLES `t_lawyer` WRITE;
/*!40000 ALTER TABLE `t_lawyer` DISABLE KEYS */;
INSERT INTO `t_lawyer` VALUES (1,'于九莲','高级律师111','这个律经验丰富','/images/lawyer-pic/lawer.png','1'),(2,'王重阳','高级律师','100多年律师从业经验','/images/lawyer-pic/lawer.png','1'),(3,'龙云凤','中级律师','这个律师好啊','/images/lawyer-pic/2aa4a0b2-f32a-44be-8c29-c4acda8e44e3.jpg','0'),(4,'aaa','vvvv','cccc','/images/lawyer-pic/lawer.png','0'),(5,'vvvv111','asd','jjjasdjfhkjasdfs','/images/lawyer-pic/lawer.png','0'),(6,'5555sssd','555544aaa','55566aa','/images/lawyer-pic/lawer.png','0'),(7,'反反复复','饿肚肚多','的点点滴滴','/images/lawyer-pic/lawer.png','0'),(19,'高律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(21,'钱律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(22,'李律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(23,'增律师','究极律师','北京大学毕业','/images/lawyer-pic/12e9b116-7b19-4dc3-b1f4-c1cca0d4cc99.jpeg','0'),(25,'增律师-1','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(26,'增律师-2','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(27,'增律师-3','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(28,'增律师-4','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(29,'增律师-5','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(30,'增律师-6','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(31,'增律师-7','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(32,'增律师-8-888811','究极律师1','北京大学毕业','/images/lawyer-pic/8b1840c6-7a31-48a5-99d1-25e2022ce180.jpg','0'),(33,'增律师-9','究极律师','北京大学毕业','/images/lawyer-pic/7103947d-0c76-43df-9f83-60564c88958a.jpg','0'),(34,'增律师-10','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(35,'增律师-11','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','1');
/*!40000 ALTER TABLE `t_lawyer` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`menuId`),
  UNIQUE KEY `t_menu_menuName_uindex` (`menuName`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'首页',0,'/'),(2,'律师事务所',0,'/introduce/office'),(3,'公司法律服务',0,'/server'),(4,'刑事法律服务',0,'/penallaw'),(5,'劳动法律服务',0,'/labour/reply/1'),(6,'律师事务所介绍',2,'/introduce/office'),(7,'团队介绍',2,'/introduce/leader'),(8,'团队文集',2,'/introduce/Collection/0'),(9,'股权设计',3,'/server/equityeightesign/1'),(10,'股权激励',3,'/server/equityincentive'),(11,'报价配置表',3,'/server/equityallocationtable'),(12,'刑事服务',4,'/penallaw/lawser/1'),(13,'刑事辩护',4,'/penallaw/penaldef'),(14,'诉讼与仲裁应对',5,'/labour/reply/1'),(15,'劳动用工制度事先设计',5,'/labour/design'),(16,'企业文化与策略选择',5,'/labour/select');
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

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
  `caseDetail` mediumtext NOT NULL,
  `createDate` datetime NOT NULL,
  `replyId` int(10) DEFAULT NULL,
  `replyName` varchar(100) DEFAULT NULL,
  `replyDate` datetime DEFAULT NULL,
  `readFlag` varchar(10) NOT NULL,
  `replyMsg` text,
  PRIMARY KEY (`msgId`),
  KEY `redply_fk` (`replyId`),
  CONSTRAINT `redply_fk` FOREIGN KEY (`replyId`) REFERENCES `t_lawyer` (`lawyerId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_msgBoard`
--

LOCK TABLES `t_msgBoard` WRITE;
/*!40000 ALTER TABLE `t_msgBoard` DISABLE KEYS */;
INSERT INTO `t_msgBoard` VALUES (12,'user-1','13888888888','他杀1人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(15,'user-4','13888888888','他杀4人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(16,'user-1','13888888888','他杀5人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(17,'user-6','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(18,'user-7','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(19,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(20,'user-9','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(21,'user-10','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(22,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(23,'user-12','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(24,'user-13','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(25,'user-111','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(26,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(27,'user-1213','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(28,'user-177','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(29,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(30,'user-188','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(31,'user-122','13888888888','他杀6人被起诉','2014-09-12 18:51:09',25,'增律师-1','2019-08-15 17:34:27','1','这是一个更新的回复'),(32,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着');
/*!40000 ALTER TABLE `t_msgBoard` ENABLE KEYS */;
UNLOCK TABLES;

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
  `gender` varchar(10) DEFAULT NULL,
  `userTel` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `deleteFlag` varchar(10) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_loginName_uindex` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (2,'d52af20fcaf39ff11dafcef333c5c7d5','amy',NULL,'女',NULL,NULL,NULL,'0','root_user common_user'),(4,'d52af20fcaf39ff11dafcef333c5c7d5','hyg',NULL,'男',NULL,NULL,NULL,'0','common_user'),(5,'d52af20fcaf39ff11dafcef333c5c7d5','横推八百无对手','李艳兴','男','13999999999','123@163.com','CEO','0','common_user'),(6,'d52af20fcaf39ff11dafcef333c5c7d5','草上','盖飞侠','女','13666666666','11111@qq.com','扫地小组长','0','common_user'),(7,'d52af20fcaf39ff11dafcef333c5c7d5','海外野叟','王猿','男','13999999999','abc@qq.com','总经理助理','0','common_user'),(8,'f937748fe21e9a1a70a4cc0a2bbd66f2','liujinpeng','555','男','1321079','1638786338@qq.com',NULL,'0','common_user'),(9,'d52af20fcaf39ff11dafcef333c5c7d5','aaaa','jhon','男','123456','123@qq.com',NULL,'0','common_user'),(10,'bb232666cd0aeea80029c27e3c01582f','zjz','张静泽','女','11111','ddadsf@aa.com','adsfadsf','0','common_user'),(11,'d52af20fcaf39ff11dafcef333c5c7d5','aa','欧阳普钟','女','15875984125','1458@qq.com','扫地僧','0','common_user'),(12,'d52af20fcaf39ff11dafcef333c5c7d5','一a人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(13,'d52af20fcaf39ff11dafcef333c5c7d5','一b人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(14,'d52af20fcaf39ff11dafcef333c5c7d5','一c人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(15,'d52af20fcaf39ff11dafcef333c5c7d5','一d人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(16,'d52af20fcaf39ff11dafcef333c5c7d5','一e人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(18,'8b8154f03b75f58a6c702235bf643629','ddd','','女','','','','0','common_user'),(21,'b8f8d24ea3e7ebd0e5e8064f31da5bea','g','d','女','d','d@qq.com','d','0','common_user'),(23,'6a1af7eed1de4ef7614961dfd7d7f1e4','刘金盆啊啊啊啊','诉讼时','男','1321079','123123123@qq.com','d','0','common_user'),(25,'bb232666cd0aeea80029c27e3c01582f','ddda','123','男','1321079','12232323@qq.com','对对对','0','common_user'),(26,'936c0c8c0c47a224a658ee03cfac8eb9','的点点滴滴','打发大水','男','1111','1234567@qq.com','顶顶顶顶','0','common_user');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-16  9:36:45
