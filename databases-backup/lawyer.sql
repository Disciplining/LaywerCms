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
INSERT INTO `t_agency` VALUES (1,'chongjie','http://xxxx','<p>\r\n	测试\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<img src=\"/images/rich-text-pic/a9ad923e-7005-42fe-b718-22d839c0656f.jpeg\" alt=\"\" />\r\n</p>\r\n<p>\r\n	这是一个很好的测试\r\n</p>\r\n<p>\r\n	<img src=\"/images/rich-text-pic/cb228086-f72b-4cf7-80c4-c6b5bbad7ef5.jpg\" alt=\"\" />\r\n</p>','0');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_article`
--

LOCK TABLES `t_article` WRITE;
/*!40000 ALTER TABLE `t_article` DISABLE KEYS */;
INSERT INTO `t_article` VALUES (1,1,'律师事务所入围ALB“年度中国西部律师事务所”','李凯','2019年3月25日,场森路透旗下国际法律媒体(亚洲法律杂志》(ALB )欣然宣布2019年中国法律大奖的入圈名单。永嘉信律师事务所凭借在各个专业领域的出色表现，行业口碳和市场评价,获“年度西部律师事务所大奖”提名!\r\n\r\nALB -律界奥断长\r\n\r\nALB中国法律大奖旨在表彰业界领先的律师事务所和忧秀的的企业法务团队，以及上一年度的突出交易案例， 得益于其评选过程公正透明和高效原则，设立奎 今已成为中国法律界最具影响力的奖项之- - .增称法律界的“奥斯卡”。\r\n\r\n永嘉信一致力于成为一流的推 际化律师事务所\r\n\r\n永磊信律师事务所2001年创立于西安;总投资额7600万5 ,在高新核心CBD聘4500平米的办公场所，2013年加入中世律所联盟，立足西部,辐射全国.为客户提供全方位、跨区域跨国境的综合法律服\r\n','2019年3月25日,场森路透旗下国际法律媒体(亚洲法律杂志》(ALB )欣然宣布2019年中国法律大奖的入圈名单。永嘉信律师事务所凭借在各个专业领域的出色表现，行业口碳和市场评价,获“年度西部律师事务所大奖”提名!<br />\r\n<br />\r\nALB -律界奥断长<br />\r\n<br />\r\nALB中国法律大奖旨在表彰业界领先的律师事务所和忧秀的的企业法务团队，以及上一年度的突出交易案例， 得益于其评选过程公正透明和高效原则，设立奎 今已成为中国法律界最具影响力的奖项之- - .增称法律界的“奥斯卡”。<br />\r\n<br />\r\n永嘉信一致力于成为一流的推 际化律师事务所<br />\r\n<br />\r\n永磊信律师事务所2001年创立于西安;总投资额7600万5 ,在高新核心CBD聘4500平米的办公场所，2013年加入中世律所联盟，立足西部,辐射全国.为客户提供全方位、跨区域跨国境的综合法律服<br />\r\n<br />\r\n务。律所拥有一支高学历高素质纳业经验丰富的律师队伍.经过多年的发展I永嘉他已成为西部地区规模强大.卖力雄厚的综合性律所。伴随着市场经济的下断发展,基于在各个行业的深耕细作,水嘉信律师事务所在法律服务市场中已经覆盖了经济社会的方方面面,并不断在延伸法律股务的深度和广度,寻找挖蝴新的服务点创新点.在全方位满足客户需求的基础上，探索法律服务新高地,致力法律服务再升级。<br />\r\n<br />\r\n入围即是肯定。永嘉信律师事务所始终保持深刻的觉解.将不要不亢,持之以恒地优化提升律所的人员结构，专业水平，服务能力，市场评价,使软硬实力向更高水平迈进,全力实现成为一流的国际化律师事务所的宏伟愿景，<br />\r\n<div>\r\n	<img src=\"/images/agency-detail-pic/818b370c-25ef-4d91-86f9-ab90f0c122cb.jpeg\" alt=\"\" /><br />\r\n</div>','2019-08-21 11:35:35',0,'0'),(2,2,'就这个feel倍爽','刘金鹏','哈哈哈哈','更多更符合','2019-08-21 11:35:30',0,'0'),(3,1,'测试','测试啊','cesh面啊啊','地方撒打算打发斯蒂芬','2019-08-22 20:52:05',0,'0'),(4,1,'图片测试','图片测试','图片测试','<p>\r\n	图片测试\r\n</p>\r\n<p>\r\n	1111\r\n</p>\r\n<p>\r\n	<img src=\"/images/rich-text-pic/a94d54a8-6883-4f5d-a2c4-f9870e48bba3.jpeg\" alt=\"\" />\r\n</p>','2019-08-23 10:16:19',0,'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_carousel`
--

LOCK TABLES `t_carousel` WRITE;
/*!40000 ALTER TABLE `t_carousel` DISABLE KEYS */;
INSERT INTO `t_carousel` VALUES (4,'b1','/images/banner-pic/fcdec781-bcbb-4d74-b507-f6c91ee65992.jpg','2019-08-22 14:23:40'),(5,'b2','/images/banner-pic/aaf180d7-e060-4ea7-a520-c0a1363daa56.jpg','2019-08-22 14:23:47'),(6,'b3','/images/banner-pic/7e73e3fa-9c7f-4629-9288-72d8ca161b26.jpg','2019-08-22 14:23:54'),(7,'Test','/images/banner-pic/a4a6ccc7-7335-4cba-b101-2c736d3e63c8.jpg','2019-08-22 14:51:57');
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
  `successFlag` int(11) DEFAULT NULL COMMENT '是否成功?1:0',
  `editDate` datetime DEFAULT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) NOT NULL DEFAULT '0' COMMENT '是否已删除0：未删除；1是删除',
  `picUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_case_t_charge_id_fk` (`chargeId`),
  CONSTRAINT `t_case_t_charge_id_fk` FOREIGN KEY (`chargeId`) REFERENCES `t_charge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_case`
--

LOCK TABLES `t_case` WRITE;
/*!40000 ALTER TABLE `t_case` DISABLE KEYS */;
INSERT INTO `t_case` VALUES (5,8,'车祸','版权声明：本文为博主原创文章，遵循 CC 4.0 by-sa 版权协议，转载请附上原文出处链接和本声明。\r\n本文链接：https://blog.csdn.net/qq_37131111/article/details/78393016\r\n想要实现自动聚焦到text文本框，不需要手动点击文本框进行聚焦输入. \r\n使用focus()就可以实现\r\n ———————————————— \r\n版权声明：本文为CSDN博主「王立平的博客」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/qq_37131111/article/details/78393016','阿斯顿发送到发送到发放共和国海关很好回复过分过分过分过分过分过分过分过分过分过分过分过分苟富贵','同学，祝贺你喜提彩蛋~\r\n或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；\r\n在这里大家都用无人车代步，AI音箱不仅播放还可以交互；\r\n人工智能是发展的核心技术，做自己让未来不只领先几步；\r\n在这里做自己，欢迎来到百度！','哈哈哈哈哈哈非常好啊安监局奥所多付军军军军','2019-08-21 10:41:18',1,'2019-08-21 10:41:18',0,'0','/images/case-pic/839ba7ee-0dad-445d-b01e-475897085b2c.png'),(6,7,'案发多所发所过过过过','冠福股份还加金属软管孤鸿寡鹄共和国恢复供货收到个人风格风格风格非官方股份公司股份跟人探讨','非官方个风格的广告人工人工费股份公司分公司更好地','奥德赛发所发所多付过或军军军军军军军','水电费过胡胡刚刚嘎嘎嘎嘎嘎','2019-08-21 10:42:05',1,'2019-08-21 10:42:05',0,'0','/images/case-pic/347c7b75-7ad9-418f-a438-ca70740d8c38.png'),(8,7,'；代付款龙岗街道分手快乐高科技收到反馈更多是法国个','看到回复可见拉水电费as对方答复等丰富的大是大非','的范德萨发生发士大夫撒发的','大是大非的方法呃呃呃','哈哈哈哈哈','2019-08-21 10:43:23',0,'2019-08-21 10:43:23',0,'0','/images/case-pic/69f3526c-bc21-4640-b825-342c90024669.png'),(9,5,'斤斤计较军军军军所多多付','阿斯顿发送到发送到发放共和国海关很好回复过分过分过分过分过分过分过分过分过分过分过分过分苟富贵','的点点滴滴的二多付多风热人的发送到发送到凤飞飞 ','henhaoajhhdhhhdhhaljiooiids','的辅导辅导辅导辅导辅导费色色呃呃晚辅导辅导辅导辅导费','2019-08-21 10:46:27',1,'2019-08-21 16:16:17',0,'0','/images/case-pic/3c7e4213-9d2b-4a30-b64b-26ca15ea044b.jpeg'),(10,3,'张三走私','走私罪的法律概念是指违反海关法和国家其他有关法律、法规，逃避海关监管，非法运输、携带、邮寄国家禁止进出境的物品、国家限制进出境或者依法应当缴纳关税和其他进口环节代征税的货物、物品进出境，数额较大、情节严重的行为。','办案顺利','逮捕张三','打击犯罪','2019-08-21 14:04:10',1,'2019-08-21 14:04:10',0,'0','/images/case-pic/a0a38793-1a8b-4bba-b856-fb41e2d22887.png');
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
  UNIQUE KEY `t_charge_chargeName_uindex` (`chargeName`),
  KEY `t_charge_t_chargeType_id_fk` (`chargeTypeId`),
  CONSTRAINT `t_charge_t_chargeType_id_fk` FOREIGN KEY (`chargeTypeId`) REFERENCES `t_chargeType` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_charge`
--

LOCK TABLES `t_charge` WRITE;
/*!40000 ALTER TABLE `t_charge` DISABLE KEYS */;
INSERT INTO `t_charge` VALUES (3,3,'走私、贩卖、运输、制造毒品罪','禁止走私','5年','流程简洁、顺畅','2019-08-21 09:28:38',0,'0'),(4,3,'非法持有毒品罪','禁止非法持有毒品罪','10年','流程顺利','2019-08-21 09:32:10',0,'0'),(5,4,'抢劫','不行','100年','不能辩护','2019-08-21 10:32:10',0,'0'),(6,5,'杀人','不行','不能量刑','找律师','2019-08-21 10:32:42',0,'0'),(7,5,'防火','防火烧山,牢底坐穿','10年','阿斯顿发斯蒂芬','2019-08-21 10:33:20',0,'0'),(8,4,'开车','私行','不能良心','阿斯顿发斯蒂芬','2019-08-21 10:34:03',0,'0'),(9,4,'哈哈哈','不能哈哈哈','10年','请律师啊','2019-08-21 10:35:28',0,'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chargeType`
--

LOCK TABLES `t_chargeType` WRITE;
/*!40000 ALTER TABLE `t_chargeType` DISABLE KEYS */;
INSERT INTO `t_chargeType` VALUES (3,'毒品类犯罪辩护','2019-08-21 09:13:49',0,'0'),(4,'公司企业人员犯罪预防与辩护','2019-08-21 09:14:19',0,'0'),(5,'时下热点罪名辩护','2019-08-21 09:14:31',0,'0');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='罪名分类问答表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chargeTypeQuestion`
--

LOCK TABLES `t_chargeTypeQuestion` WRITE;
/*!40000 ALTER TABLE `t_chargeTypeQuestion` DISABLE KEYS */;
INSERT INTO `t_chargeTypeQuestion` VALUES (1,3,'什么样的药物属于毒品','能够使人成瘾，并对人体产生伤害的，就是毒品。','2019-08-21 09:25:03',0,'0'),(2,5,'什么是时下热点罪名？','就是热点的罪名 。','2019-08-21 09:27:48',0,'0'),(3,4,'什么样的人员属于公司人员?','就是公司的人员.','2019-08-21 09:28:55',0,'0'),(4,3,'重量、人数如何计算','1克毒品判10年，1公斤无期徒刑','2019-08-21 09:33:06',0,'0'),(5,3,'重量、人数如何计算','1克毒品判10年，1公斤无期徒刑','2019-08-21 09:33:24',0,'0');
/*!40000 ALTER TABLE `t_chargeTypeQuestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_defenseAdvantage`
--

DROP TABLE IF EXISTS `t_defenseAdvantage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_defenseAdvantage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `title` text COMMENT '标题',
  `content` text COMMENT '内容',
  `icon` text COMMENT '刑辩图标',
  `editDate` datetime DEFAULT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='刑辩优势表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_defenseAdvantage`
--

LOCK TABLES `t_defenseAdvantage` WRITE;
/*!40000 ALTER TABLE `t_defenseAdvantage` DISABLE KEYS */;
INSERT INTO `t_defenseAdvantage` VALUES (1,'取保候审','取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审取保候审','/images/defense-advantage-pic/dcea4f38-0f41-412d-9728-d26d3407f270.png','2019-08-21 09:37:01',0,'0');
/*!40000 ALTER TABLE `t_defenseAdvantage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_defenseDesc`
--

DROP TABLE IF EXISTS `t_defenseDesc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_defenseDesc` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `desc` text COMMENT '团队优势介绍',
  `editDate` datetime DEFAULT NULL COMMENT '编辑时间',
  `count` int(10) DEFAULT NULL COMMENT '浏览次数',
  `deleteFlag` varchar(10) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='刑辨介绍表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_defenseDesc`
--

LOCK TABLES `t_defenseDesc` WRITE;
/*!40000 ALTER TABLE `t_defenseDesc` DISABLE KEYS */;
INSERT INTO `t_defenseDesc` VALUES (1,'<p>\r\n	<h4 style=\"font-family:&quot;font-weight:500;color:#4D4D4D;font-size:40px;text-align:center;background-color:#F2F2F2;\">\r\n		<span style=\"font-size:24px;\">《致当事人家属》</span>\r\n	</h4>\r\n	<h5 style=\"font-family:&quot;font-weight:500;color:#333333;font-size:20px;text-align:center;background-color:#F2F2F2;\">\r\n	</h5>\r\n	<p style=\"font-size:18px;color:#616161;font-family:&quot;background-color:#F2F2F2;\">\r\n		如果您或您的亲人朋友正身陷囹圄或遭受不白之冤，生命只有一次，请慎重的对待聘请律师的权利。他需要您的正确抉择，需要专业刑事律师来接手案件。<br />\r\n您走到这一步，我们相信您已经到了一种痛苦无助的状态。无论贫穷还是富有，我们都愿意向您伸出双手，我们特推出以下法律援助服务:<br />\r\n<span style=\"font-weight:600;\">一、免费会见当事人：</span><br />\r\n我们承诺：我们免费提供专业刑事律师会见，不仅详细了解案件情况，并且给犯罪嫌疑人有利的法律咨询和法律指导，帮助犯罪嫌疑人避免冤枉罪。<br />\r\n1.及时会见犯罪嫌疑人意义重大，一方面告知其正当权利；另一方面为其提供强大的心理支撑，最大程度还原事实真相。<br />\r\n2.如果会见后当事人不委托，我们不收取任何费用。请您放心托付！！！&nbsp;<br />\r\n<span style=\"font-weight:600;\">二、提供专业法律分析报告：</span><br />\r\n我们承诺：在首次会见后，免费出具专业法律分析报告<br />\r\n1.&nbsp;会见后两天内向当事人免费出具法律分析报告<br />\r\n2.&nbsp;法律分析报告包含基本案情、量刑规定、相关判例、辩护方向、工作安排、司法解释等。<br />\r\n崇杰刑事律师提示：刑事案件找律师要警惕不了解案情而盲目承诺的律师，不同的案情处理方式大相径庭。\r\n	</p>\r\n</p>\r\n<p>\r\n	<img src=\"/images/agency-detail-pic/e1d19ba4-0b98-4a2d-8cf6-5a408ffa2232.png\" alt=\"\" /> \r\n</p>','2019-08-22 13:46:21',144,'0');
/*!40000 ALTER TABLE `t_defenseDesc` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lawyer`
--

LOCK TABLES `t_lawyer` WRITE;
/*!40000 ALTER TABLE `t_lawyer` DISABLE KEYS */;
INSERT INTO `t_lawyer` VALUES (1,'李凯','高级合伙人 | 主任 | 高级律师','山东崇杰律师事务所民商法部主任律师，资深执业十七载，青岛市市北区劳动人事争议仲载调解委员会仲裁员,青岛市律师协会公司法委<br />\r\n员会委员，OTC场外市场专家律师，国家中级投资项目分析师，全球移民律师协会中国区会员。毕业于中国海洋大学，法学学士。<br />\r\n、法学研究业绩<br />\r\n参与骗写(成长型企业法商融通智慧系统》于2016年1月由中国经济出版社出版，该书分别从战略管理、股权控制及激励模式、合同的流<br />\r\n程化管理、人力资<br />\r\n源系统建设资本运营的管控、企业财税管控、刑事法律风险防控等方面展开论述,将法律价值融入企业的日常运营管理,力图能使法律<br />\r\n服务转化为企业的规范化价值。<br />\r\n二法律实务工作业绩<br />\r\n现担任多家企业法律顾问，为企业解决在经营中遇到的各种法律问题，引导企业依法经营和规范经营，增强企业防范法律风险的意识和能<br />\r\n力，维护企业合法权益。<br />\r\n.协助青岛英谷教育科技股份有限公司在全国中小企业股份转让系统(新三板)成功挂牌上市;<br />\r\n管为为中国银行、华夏银行、中国工商银行、中信银行等代理汽车消费贷款案件、为信达资产管理公司等提供法律服务。上述金融法律事<br />\r\n务通过诉论及其他方式为金融机构挽回经济损失900余万元;<br />\r\n管成功代理青岛和泰科技有限公司与微软公司侵犯计算机软件著作权案件，并胜诉，成为为数不多能够打败数软公司的的律师。<br />\r\n三专长领域<br />\r\n多年来持续关注研究新三板及场外市场，长期从事高新，科技企业法律顾问，股权架构，企业成长规划与投融资，股权激励与定增。新三<br />\r\n板挂牌与咨询专业法律服务、商事犯罪预防与辩护,与资本市场各中介机构广泛合作。','/images/lawyer-pic/c57fa10a-ae14-44c1-9bae-89394a90c847.jpeg','1'),(2,'刘金鹏','最高级的律师','非常好啊','/images/lawyer-pic/5ee778f9-3bfd-42c9-bd01-a5b6c9fa18bf.png','1'),(3,'李艳兴','究极律师','<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_1_0\">春江潮水连海平，</span><span id=\"body_1_1\">海上明月共潮生。</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_2_0\"><span class=\"body-zhushi-span\">滟滟</span>随波千万里，</span><span id=\"body_2_1\">何处春江无月明！</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_3_0\">江流宛转绕<span class=\"body-zhushi-span\">芳甸</span>，</span><span id=\"body_3_1\">月照花林皆似<span class=\"body-zhushi-span\">霰</span>；</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_4_0\">空里<span class=\"body-zhushi-span\">流霜</span>不觉飞，</span><span id=\"body_4_1\"><span class=\"body-zhushi-span\">汀</span>上白沙看不见。</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_5_0\">江天一色无<span class=\"body-zhushi-span\">纤尘</span>，</span><span id=\"body_5_1\">皎皎空中孤<span class=\"body-zhushi-span\">月轮</span>。</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_6_0\">江畔何人初见月？</span><span id=\"body_6_1\">江月何年初照人？</span> \r\n</p>\r\n<p class=\"poem-detail-main-text\" id=\"body_p\">\r\n	<span id=\"body_7_0\">人生代代无<span class=\"body-zhushi-span\">穷已</span>，</span><span id=\"body_7_1\"><span class=\"body-zhushi-span\">江月年年望相似</span>。</span> \r\n</p>','/images/lawyer-pic/ae05dd62-ab1d-4f71-a297-fed6428edf8b.jpg','1'),(4,'薛梅','高级合伙人|主任律师','青岛仲裁委员会仲裁员、青岛市律师协会商事委员会副主任、李沧信访听证员，现担任海尔集团公司、青岛海诚一家酒店管理股份有限公司、青岛梅蒂奇家居有限公司、青岛金星科技工程有限责任公司等多家公司的常年法律顾问。执业近二十年，对金融领域的诉讼及非诉案件有着丰富的处理经验。同时擅长公司管理、金融领域风险防范及追诉业务、知识产权、建设地产、商事谈判等领域。','/images/lawyer-pic/5c1fc143-038b-4528-ad79-ac36c1fe5ce7.png','0'),(5,'孙涛','高级合伙人|主任律师','青岛仲裁委员会仲裁员、青岛市律师协会商事委员会副主任、李沧信访听证员，现担任海尔集团公司、青岛海诚一家酒店管理股份有限公司、青岛梅蒂奇家居有限公司、青岛金星科技工程有限责任公司等多家公司的常年法律顾问。执业近二十年，对金融领域的诉讼及非诉案件有着丰富的处理经验。同时擅长公司管理、金融领域风险防范及追诉业务、知识产权、建设地产、商事谈判等领域。','/images/lawyer-pic/3fa859f2-5657-40e5-8cba-79c89930aba5.png','0'),(8,'东方故事梵蒂冈','水电费地方','大幅度发','/images/lawyer-pic/138c27ba-ccb0-4aed-861a-68feaacf9b3f.png','1'),(9,'朱建波','刑事法律服务部负责人','朱建波，山东崇杰律师事务所崇鼎刑事法律事务部主任，硕士研究生学历，曾任某市级检察院检察员、国家公诉人，多次被表彰为优秀公诉人、最佳辩手荣誉称号。朱建波律师刑事案件办案经验丰富，经办过各类重大刑事案件近几百余件，熟练掌握各类刑事案件的办理流程和司法判定标准，曾经办理的马崟抢劫杀人案被中央电视台《庭审现场》全程直播。朱建波律师办案过程中，以检察官的标准严格要求自己，对当事人认真负责，切实维护当事人权益，尤其擅长经济犯罪、暴力犯罪、毒品类犯罪、职务犯罪的辩护。','/images/lawyer-pic/cc9b7ca6-0301-46c9-b0cf-619ad5e58589.png','0');
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
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (2,'律师事务所',0,'/introduce/office'),(3,'公司法律服务',0,'/server'),(4,'刑事法律服务',0,'/penallaw'),(5,'劳动法律服务',0,'/labour/reply/1'),(6,'律师事务所',2,'/introduce/office'),(7,'团队介绍',2,'/introduce/leader'),(8,'团队文集',2,'/introduce/Collection/0'),(9,'股权设计',3,'/server/equityeightesign/1'),(10,'股权激励',3,'/server/equityincentive'),(11,'报价配置表',3,'/server/equityallocationtable'),(12,'刑事法律服务',4,'/penallaw/lawser/1'),(13,'毒品类犯罪辩护',4,'/penallaw/penaldef'),(14,'诉讼与仲裁应对',5,'/labour/reply'),(15,'劳动用工制度事先设计',5,'/labour/design'),(16,'企业文化与策略选择',5,'/labour/select'),(17,'公司法律服务',3,'/server/top'),(18,'公司企业人员犯罪预防与辨护',4,'/penallaw/crimedel'),(19,'时下热点罪名辩护',4,'/penallaw/currentdenfense'),(20,'劳动法律服务',5,'/labour/server');
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
  `readFlag` varchar(10) NOT NULL DEFAULT '0',
  `replyMsg` text,
  PRIMARY KEY (`msgId`),
  KEY `redply_fk` (`replyId`),
  CONSTRAINT `redply_fk` FOREIGN KEY (`replyId`) REFERENCES `t_lawyer` (`lawyerId`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_msgBoard`
--

LOCK TABLES `t_msgBoard` WRITE;
/*!40000 ALTER TABLE `t_msgBoard` DISABLE KEYS */;
INSERT INTO `t_msgBoard` VALUES (1,'liujinpeng','13210798444','非常好啊啊','2019-08-22 14:45:43',NULL,NULL,NULL,'0',NULL),(2,'李四','18588888','在巡视去','2019-08-22 14:52:30',NULL,NULL,NULL,'0',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (2,'d52af20fcaf39ff11dafcef333c5c7d5','chongjie',NULL,'女',NULL,NULL,NULL,'0','root_user common_user'),(3,'d52af20fcaf39ff11dafcef333c5c7d5','yinggu','英谷测试','男','17862739259','4166985472@qq.com','扫地小组长','0','common_user'),(4,'d93ae65992caf6a8751e334d0a716ad8','lixh','李晓华','男','18888888888','18888888888@126.com','律师','1','common_user');
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

-- Dump completed on 2019-08-23 15:37:17
