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
INSERT INTO `t_agency` VALUES (1,'chongjie','http://xxxx','<p>\r\n	部署测试就是这家决胜\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	北国风光\r\n</p>\r\n<p>\r\n	111\r\n</p>','0');
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
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_article`
--

LOCK TABLES `t_article` WRITE;
/*!40000 ALTER TABLE `t_article` DISABLE KEYS */;
INSERT INTO `t_article` VALUES (64,1,'律师事务所入围ALB \"年度中国西部事务所\" 大奖','李艳兴111','法律咨询服务有限公司是岛城一家专业法律咨询服务机构，主要提供：经济纠纷、刑事纠纷、劳动、离婚、合同、房地产纠纷、商业纠纷、建筑工程纠纷、交通事故、医疗等法律咨询法律咨询服务有限公司是岛城一家专业法律咨询服务机构，主要提供：经济纠纷、刑事纠纷、劳动、离婚、合同、房地产纠纷、商业纠纷、建筑工程纠纷、交通事故、医疗等法律咨询','这个死刑该怎么判','2019-08-12 00:00:00',0,'0'),(65,1,'title------88888888','提提拖拖拖','法律咨询服务有限公司是岛城一家专业法律咨询服务机构，主要提供：经济纠纷、刑事纠纷、劳动、离婚、合同、房地产纠纷、商业纠纷、建筑工程纠纷、交通事故、医疗等法律咨询法律咨询服务有限公司是岛城一家专业法律咨询服务机构，主要提供：经济纠纷、刑事纠纷、劳动、离婚、合同、房地产纠纷、商业纠纷、建筑工程纠纷、交通事故、医疗等法律咨询','哈哈哈哈哈哈哈哈哈哈哈','2019-08-15 11:19:32',0,'0'),(66,1,'题目','张伟','这是简介','这是内容','2019-08-11 00:00:00',0,'1'),(67,1,'文章名字','作者名字','简介','内容','2019-08-11 00:00:00',0,'1'),(68,1,'aaa6666666','bbb','不不不不不不不不','<p>\r\n	asdasd\r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/52118344-e5de-4abb-92b0-07e3eb3b4da8.jpeg\" alt=\"\" />\r\n</p>','2019-08-16 14:18:48',0,'1'),(69,1,'aaa','bbb','ccc','<p>\r\n	asdasd\r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/01572428-4973-4ddc-a963-ca3c07fdf136.jpeg\" alt=\"\" />\r\n</p>','2019-08-15 11:19:21',0,'1'),(70,1,'666','子','顶戴','要','1970-01-01 00:00:00',0,'1'),(71,1,'2019','111','666','666','2019-08-12 00:00:00',0,'0'),(72,1,'这是一个文章的名字','123-a','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(73,1,'这是一个文章的名字-1','123-b','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(74,2,'这是一个文章的名字-2','123-c','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(75,2,'这是一个文章的名字-3','123-d','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(76,2,'这是一个文章的名字-31','123-e','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(77,2,'这是一个文章的名字-32','123-f','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(78,2,'这是一个文章的名字-33','123-g','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(79,2,'这是一个文章的名字-34','123-h','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(80,2,'这是一个文章的名字-35','123-i','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(81,2,'这是一个文章的名字-36','123-j','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(82,2,'这是一个文章的名字-37','123-k','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(83,2,'这是一个文章的名字-38','123-l','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(84,2,'这是一个文章的名字-39','123-m','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(85,2,'这是一个文章的名字-30','123-n','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(86,2,'这是一个文章的名字-311','123-o','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(87,3,'这是一个文章的名字-312','123-p','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(88,3,'这是一个文章的名字-313','123-q','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(89,3,'这是一个文章的名字-314','123-r','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(90,3,'这是一个文章的名字-315','123-s','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(91,3,'这是一个文章的名字-316','123-t','11111','aaasdasd','2019-08-14 08:33:33',0,'0'),(92,3,'哈哈哈哈哈哈','李艳兴-a-1','这个好啊末aaa','<p>\r\n	<img src=\"http://127.0.0.1/layuiadmin/kindeditor/plugins/emoticons/images/20.gif\" alt=\"\" border=\"0\" /> \r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/32d82ae2-e395-4cdb-8d30-e98e5ab5a2fc.jpeg\" alt=\"\" /> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	adsf\r\n</p>\r\n<p>\r\n	<img src=\"http://127.0.0.1/layuiadmin/kindeditor/plugins/emoticons/images/20.gif\" alt=\"\" border=\"0\" /> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>','2019-08-16 08:49:14',0,'0'),(93,3,'safd111111','asdf','sadf','这是测试内容<br />','2019-08-16 10:00:03',0,'0'),(94,3,'刘金鹏啊啊啊啊啊啊啊啊啊啊啊啊啊','对对对','顶顶顶顶','的点点滴滴','2019-08-16 10:36:20',0,'0'),(95,3,'ssssq-=qq','sss=','aaa=','<p>\r\n	====\r\n</p>\r\n<p>\r\n	这是内容<img src=\"/images/agency-detail-pic/f345e091-3ce4-4b17-b1a9-ffeb327527e6.jpg\" alt=\"\" />\r\n</p>','2019-08-16 14:19:10',0,'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_carousel`
--

LOCK TABLES `t_carousel` WRITE;
/*!40000 ALTER TABLE `t_carousel` DISABLE KEYS */;
INSERT INTO `t_carousel` VALUES (2,'banner2','/images/banner-pic/02.jpg','2018-08-09 08:05:41'),(3,'banner3','/images/banner-pic/04.jpg','2019-08-09 08:06:09'),(4,'vannerName-666','/images/banner-pic/02.jpg','2019-08-07 00:00:00'),(5,'图片1','/images/banner-pic/04.jpg','2019-08-13 00:00:00'),(6,'图片2','/images/banner-pic/02.jpg','2019-08-13 00:00:00'),(14,'test','/images/banner-pic/446dac0e-fabc-46ac-bed7-5e5ba4ddb4eb.jpeg','2019-08-16 11:06:09'),(17,'liujinpemng','/images/banner-pic/7de28ef6-c145-49a2-a2e2-cefaf8fb5113','2019-08-16 11:38:54'),(18,'banner-test','/images/banner-pic/a59a6485-0388-4da2-9eff-6726715d0f56.jpeg','2019-08-16 14:01:51'),(19,'asdfasdfasdf','/images/banner-pic/f10b7fe1-0017-4996-9b10-684b302b1266.jpeg','2019-08-16 14:12:32'),(20,'asdfasdfasdf','/images/banner-pic/c311216f-14b8-4f44-aad9-58ba443e56fd.jpg','2019-08-16 14:13:29'),(21,'asdfasdf','/images/banner-pic/803fad97-4b37-4d49-9d1d-3c25071e54e4.jpeg','2019-08-16 14:14:23'),(22,' 轮播-s','/images/banner-pic/389e1127-fd81-48e2-8cb1-a9c3cc4cc009.png','2019-08-16 14:45:49');
/*!40000 ALTER TABLE `t_carousel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_case`
--

DROP TABLE IF EXISTS `t_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_case` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `chargeId` int(10) DEFAULT NULL COMMENT '罪名表ID',
  `title` varchar(255) NOT NULL COMMENT '案例标题',
  `desc` text COMMENT '案例介绍',
  `process` text COMMENT '办案过程',
  `result` text COMMENT '案件结果',
  `lessions` text COMMENT '经验心得',
  `publishDate` datetime DEFAULT NULL COMMENT '发布日期',
  `isSuccess` int(11) DEFAULT NULL COMMENT '是否成功?1:0',
  `editDate` datetime DEFAULT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) NOT NULL DEFAULT '0' COMMENT '是否已删除0：未删除；1是删除',
  PRIMARY KEY (`id`),
  KEY `t_case_t_charge_id_fk` (`chargeId`),
  CONSTRAINT `t_case_t_charge_id_fk` FOREIGN KEY (`chargeId`) REFERENCES `t_charge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_case`
--

LOCK TABLES `t_case` WRITE;
/*!40000 ALTER TABLE `t_case` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_charge`
--

DROP TABLE IF EXISTS `t_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_charge` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `chargeTypeId` int(10) NOT NULL COMMENT '罪名分类表ID',
  `chargeName` varchar(255) NOT NULL COMMENT '罪名表',
  `lawContent` text COMMENT '法律规定内容',
  `sentenceRange` text COMMENT '量刑范围内容',
  `defense` text COMMENT '辩护流程与方案',
  `editDate` datetime NOT NULL COMMENT '编辑时间',
  `count` int(10) NOT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `t_charge_t_chargeType_id_fk` (`chargeTypeId`),
  CONSTRAINT `t_charge_t_chargeType_id_fk` FOREIGN KEY (`chargeTypeId`) REFERENCES `t_chargeType` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_charge`
--

LOCK TABLES `t_charge` WRITE;
/*!40000 ALTER TABLE `t_charge` DISABLE KEYS */;
INSERT INTO `t_charge` VALUES (23,1,'顶顶顶','滴滴答答是否','阿斯顿发射点','阿迪斯发士大夫','2019-08-17 14:57:51',0,'0'),(24,1,'阿迪斯发士大夫','阿斯顿发射点法大师傅a','a撒撒旦发射点发','啊手动阀手动阀','2019-08-17 14:58:08',0,'0'),(25,1,'爱的色放','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(26,1,'爱的色放-1','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'1'),(27,1,'爱的色放-2','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(28,1,'爱的色放-3','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(29,1,'爱的色放-4','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(30,3,'爱的色放-5','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(31,3,'爱的色放-6','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(32,3,'爱的色放-7','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(33,3,'爱的色放-8','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(34,3,'爱的色放-11','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(35,3,'爱的色放-12','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(36,3,'爱的色放-13','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(37,5,'爱的色放-14','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(38,5,'爱的色放-15','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(39,5,'爱的色放-16','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(40,5,'爱的色放-17','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(41,5,'爱的色放-18','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(42,5,'爱的色放-19','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0'),(43,5,'爱的色放-18','阿斯蒂芬','纷纷大幅答复','顶顶顶顶顶啊','2019-08-17 15:09:54',0,'0');
/*!40000 ALTER TABLE `t_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chargeType`
--

DROP TABLE IF EXISTS `t_chargeType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chargeType` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `chargeTypeName` varchar(255) NOT NULL COMMENT '罪名分类名字',
  `editDate` datetime NOT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) NOT NULL DEFAULT '0' COMMENT '是否已删除；0是未删除，1是删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_chargeType_chargeTypeName_uindex` (`chargeTypeName`),
  UNIQUE KEY `t_chargeType_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chargeType`
--

LOCK TABLES `t_chargeType` WRITE;
/*!40000 ALTER TABLE `t_chargeType` DISABLE KEYS */;
INSERT INTO `t_chargeType` VALUES (1,'人事罪','2019-08-16 17:51:27',0,'0'),(3,'刺杀国家总理','2019-08-16 17:52:18',0,'0'),(5,'偷渡','2019-08-16 17:52:50',0,'0'),(10,'剌杀国家主席','2019-08-16 17:54:14',0,'0'),(12,'危害国家安全罪','2019-08-16 18:03:48',0,'0'),(13,'分裂国家安全罪','2019-08-16 18:03:59',0,'0'),(14,'暴乱罪','2019-08-16 18:04:16',0,'0'),(15,'暴乱罪-1','2019-08-16 18:04:16',0,'0'),(16,'暴乱罪-2','2019-08-16 18:04:16',0,'0'),(17,'暴乱罪-3','2019-08-16 18:04:16',0,'0'),(18,'暴乱罪-11','2019-08-16 18:53:08',0,'0'),(19,'暴乱罪-12','2019-08-16 18:53:27',0,'0'),(21,'最棒的仔','2019-08-16 20:23:24',0,'0'),(22,'哈哈哈哈哈哈','2019-08-16 20:23:38',0,'0'),(23,'最好爱的色放','2019-08-16 20:32:28',0,'0'),(24,'啊打发手动阀的','2019-08-16 20:35:15',0,'0'),(25,'煽动人民情绪罪','2019-08-16 20:48:07',0,'0');
/*!40000 ALTER TABLE `t_chargeType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chargeTypeQuestion`
--

DROP TABLE IF EXISTS `t_chargeTypeQuestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chargeTypeQuestion` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `chargeTypeId` int(10) NOT NULL COMMENT '罪名分类表ID',
  `question` text COMMENT '问题',
  `answer` text COMMENT '回答',
  `editDate` datetime DEFAULT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL,
  `deleteFlag` varchar(10) DEFAULT NULL COMMENT '是否删除？1：删除；0：删除',
  PRIMARY KEY (`id`),
  KEY `t_chargeTypeQuestion_t_chargeType_id_fk` (`chargeTypeId`),
  CONSTRAINT `t_chargeTypeQuestion_t_chargeType_id_fk` FOREIGN KEY (`chargeTypeId`) REFERENCES `t_chargeType` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='罪名分类问答表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chargeTypeQuestion`
--

LOCK TABLES `t_chargeTypeQuestion` WRITE;
/*!40000 ALTER TABLE `t_chargeTypeQuestion` DISABLE KEYS */;
INSERT INTO `t_chargeTypeQuestion` VALUES (1,10,'你难么','我好难啊','2019-08-17 16:11:09',0,'1'),(2,15,'你喜欢什么人-`','美女','2019-08-17 19:36:05',0,'0'),(3,15,'你喜欢什么-1','美女','2019-08-17 16:17:27',0,'0'),(4,15,'你有什么娱乐活动','呤诗作对','2019-08-17 18:45:27',0,'0'),(5,15,'你喜欢什么-3','美女','2019-08-17 16:17:27',0,'0'),(6,15,'你喜欢什么-33','美女','2019-08-17 16:17:27',0,'0'),(7,15,'你喜欢什么-4','美女','2019-08-17 16:17:27',0,'0'),(8,15,'你喜欢什么-5','美女','2019-08-17 16:17:27',0,'0'),(9,15,'你喜欢什么-6','美女','2019-08-17 16:17:27',0,'0'),(10,15,'你喜欢什么-7','美女','2019-08-17 16:17:27',0,'1'),(11,15,'你喜欢什么-8','美女','2019-08-17 16:17:27',0,'1'),(12,15,'你喜欢什么-9','美女','2019-08-17 16:17:27',0,'0'),(13,15,'你喜欢什么-11','美女','2019-08-17 16:17:27',0,'0'),(14,15,'你喜欢什么-12','美女','2019-08-17 16:17:27',0,'0'),(15,3,'这是什么罪啊刺杀国家总理','可以完全没问题','2019-08-17 18:47:49',0,'0'),(16,1,'1的敢死队风格','啊但是发射点发射点发射点发射点发生','2019-08-17 18:49:47',0,'0'),(17,13,'你会什么？','hello world','2019-08-17 19:35:48',0,'0');
/*!40000 ALTER TABLE `t_chargeTypeQuestion` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lawyer`
--

LOCK TABLES `t_lawyer` WRITE;
/*!40000 ALTER TABLE `t_lawyer` DISABLE KEYS */;
INSERT INTO `t_lawyer` VALUES (1,'于九莲','高级律师111','这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富这个律经验丰富','/images/lawyer-pic/lawer.png','0'),(2,'王重阳','高级律师','100多年律师从业经验','/images/lawyer-pic/lawer.png','0'),(3,'龙云凤','中级律师','这个律师好啊','/images/lawyer-pic/2aa4a0b2-f32a-44be-8c29-c4acda8e44e3.jpg','0'),(4,'aaa','vvvv','cccc','/images/lawyer-pic/lawer.png','0'),(5,'vvvv111','asd','jjjasdjfhkjasdfs','/images/lawyer-pic/lawer.png','0'),(6,'5555sssd','555544aaa','55566aa','/images/lawyer-pic/lawer.png','0'),(7,'反反复复','饿肚肚多','的点点滴滴','/images/lawyer-pic/lawer.png','0'),(19,'高律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(21,'钱律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(22,'李律师','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(23,'增律师','究极律师','北京大学毕业','/images/lawyer-pic/12e9b116-7b19-4dc3-b1f4-c1cca0d4cc99.jpeg','0'),(25,'增律师-1','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(26,'增律师-2','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(27,'增律师-3','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(28,'增律师-4','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(29,'增律师-5','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(30,'增律师-6','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(31,'增律师-7','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(32,'增律师-8-888811','究极律师1','北京大学毕业','/images/lawyer-pic/8b1840c6-7a31-48a5-99d1-25e2022ce180.jpg','0'),(33,'增律师-9','究极律师','北京大学毕业','/images/lawyer-pic/7103947d-0c76-43df-9f83-60564c88958a.jpg','0'),(34,'增律师-10','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','0'),(35,'增律师-11','究极律师','北京大学毕业','/images/lawyer-pic/0c1f4286-b6ed-4e71-8b05-b160c3275619.jpeg','1'),(37,'sdfgsdfg','asdfasdf','asdfasdfasdf','/images/lawyer-pic/43d41a6c-b4a3-46de-80b7-c0fae30019ab.png','0');
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
INSERT INTO `t_msgBoard` VALUES (12,'user-1','13888888888','他杀1人被起诉','2014-09-12 18:51:09',1,'于九莲','2019-08-16 14:42:37','1','这是新的回复<br />'),(15,'user-4','13888888888','他杀4人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(17,'user-6','13888888888','他杀6人被起诉','2014-09-12 18:51:09',2,'王重阳','2019-08-16 14:44:01','1','这是来自王重阳的回复'),(18,'user-7','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着'),(19,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(20,'user-9','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(21,'user-10','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(22,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(23,'user-12','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(24,'user-13','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(25,'user-111','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(26,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(27,'user-1213','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(28,'user-177','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(29,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(30,'user-188','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','1','等着'),(31,'user-122','13888888888','他杀6人被起诉','2014-09-12 18:51:09',25,'增律师-1','2019-08-15 17:34:27','1','这是一个更新的回复'),(32,'user-1','13888888888','他杀6人被起诉','2014-09-12 18:51:09',NULL,'vvvv111','2019-08-12 18:52:04','0','等着');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (2,'d52af20fcaf39ff11dafcef333c5c7d5','amy',NULL,'女',NULL,NULL,NULL,'0','root_user common_user'),(4,'d52af20fcaf39ff11dafcef333c5c7d5','hyg',NULL,'男',NULL,NULL,NULL,'0','common_user'),(5,'d52af20fcaf39ff11dafcef333c5c7d5','横推八百无对手','李艳兴','男','13999999999','123@163.com','CEO','0','common_user'),(6,'d52af20fcaf39ff11dafcef333c5c7d5','草上','盖飞侠','女','13666666666','11111@qq.com','扫地小组长','0','common_user'),(7,'d52af20fcaf39ff11dafcef333c5c7d5','海外野叟','王猿','男','13999999999','abc@qq.com','总经理助理','0','common_user'),(8,'f937748fe21e9a1a70a4cc0a2bbd66f2','liujinpeng','555','男','1321079','1638786338@qq.com',NULL,'0','common_user'),(9,'d52af20fcaf39ff11dafcef333c5c7d5','aaaa','jhon','男','123456','123@qq.com',NULL,'0','common_user'),(10,'bb232666cd0aeea80029c27e3c01582f','zjz','张静泽','女','11111','ddadsf@aa.com','adsfadsf','0','common_user'),(11,'d52af20fcaf39ff11dafcef333c5c7d5','aa','欧阳普钟','女','15875984125','1458@qq.com','扫地僧','0','common_user'),(12,'d52af20fcaf39ff11dafcef333c5c7d5','一a人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(13,'d52af20fcaf39ff11dafcef333c5c7d5','一b人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(14,'d52af20fcaf39ff11dafcef333c5c7d5','一c人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(15,'d52af20fcaf39ff11dafcef333c5c7d5','一d人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(16,'d52af20fcaf39ff11dafcef333c5c7d5','一e人','李三','女','15874652222','123@qq.com','ss','0','common_user'),(18,'8b8154f03b75f58a6c702235bf643629','ddd','','女','','','','0','common_user'),(21,'b8f8d24ea3e7ebd0e5e8064f31da5bea','g','d','女','d','d@qq.com','d','0','common_user'),(23,'6a1af7eed1de4ef7614961dfd7d7f1e4','刘金盆啊啊啊啊','诉讼时','男','1321079','123123123@qq.com','d','0','common_user'),(25,'bb232666cd0aeea80029c27e3c01582f','ddda','123','男','1321079','12232323@qq.com','对对对','0','common_user'),(26,'936c0c8c0c47a224a658ee03cfac8eb9','的点点滴滴','打发大水','男','1111','1234567@qq.com','顶顶顶顶','0','common_user'),(28,'f937748fe21e9a1a70a4cc0a2bbd66f2','zjza','张静泽','男','1112221111','12222222@qq.com','ceo','1','common_user'),(29,'fef10cd1325185dfed20645c3c035211','sdfasdf','11111','男','1111','11112@qq.com','中国总理','0','common_user');
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

-- Dump completed on 2019-08-18 16:12:27
