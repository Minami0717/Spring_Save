-- MariaDB dump 10.19  Distrib 10.11.2-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: not_todo
-- ------------------------------------------------------
-- Server version	10.11.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_member`
--

DROP TABLE IF EXISTS `t_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) NOT NULL,
  `memo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `t_member_pk` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member`
--

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES
(1,'test','string'),
(2,'nick',NULL);
/*!40000 ALTER TABLE `t_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_not_todo`
--

DROP TABLE IF EXISTS `t_member_not_todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_not_todo` (
  `member_not_todo_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `not_todo_id` int(11) NOT NULL,
  PRIMARY KEY (`member_not_todo_id`),
  KEY `t_member_not_todo_t_member_member_id_fk` (`member_id`),
  KEY `t_member_not_todo_t_not_todo_not_todo_id_fk` (`not_todo_id`),
  CONSTRAINT `t_member_not_todo_t_member_member_id_fk` FOREIGN KEY (`member_id`) REFERENCES `t_member` (`member_id`),
  CONSTRAINT `t_member_not_todo_t_not_todo_not_todo_id_fk` FOREIGN KEY (`not_todo_id`) REFERENCES `t_not_todo` (`not_todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_not_todo`
--

LOCK TABLES `t_member_not_todo` WRITE;
/*!40000 ALTER TABLE `t_member_not_todo` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_member_not_todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_monthly_goal`
--

DROP TABLE IF EXISTS `t_monthly_goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_monthly_goal` (
  `goal_id` int(11) NOT NULL AUTO_INCREMENT,
  `not_todo_id` int(11) NOT NULL,
  `cost_category` int(11) NOT NULL,
  `goal_cost` int(11) NOT NULL,
  `month_year` char(7) NOT NULL,
  `save_cost` int(11) NOT NULL,
  PRIMARY KEY (`goal_id`),
  KEY `not_todo_id` (`not_todo_id`),
  CONSTRAINT `t_monthly_goal_ibfk_1` FOREIGN KEY (`not_todo_id`) REFERENCES `t_not_todo` (`not_todo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_monthly_goal`
--

LOCK TABLES `t_monthly_goal` WRITE;
/*!40000 ALTER TABLE `t_monthly_goal` DISABLE KEYS */;
INSERT INTO `t_monthly_goal` VALUES
(2,2,1,300000,'2023-06',295000),
(3,3,1,100000,'2023-06',98000),
(10,15,2,50,'2023-06',50),
(11,16,1,10000,'2023-07',5000),
(12,1,2,50,'2023-07',50),
(13,2,2,60,'2023-07',60),
(14,1,2,60,'2023-08',60),
(15,3,1,50000,'2023-07',48000),
(16,15,2,60,'2023-07',60),
(17,6,1,30000,'2023-07',30000),
(18,17,1,20000,'2023-07',20000),
(19,2,1,100000,'2023-02',100000),
(20,2,1,100000,'2023-06',100000),
(21,2,1,100000,'2023-02',100000),
(22,18,1,0,'string',0);
/*!40000 ALTER TABLE `t_monthly_goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_not_todo`
--

DROP TABLE IF EXISTS `t_not_todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_not_todo` (
  `not_todo_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`not_todo_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_not_todo`
--

LOCK TABLES `t_not_todo` WRITE;
/*!40000 ALTER TABLE `t_not_todo` DISABLE KEYS */;
INSERT INTO `t_not_todo` VALUES
(18,'string'),
(1,'게임'),
(17,'과자'),
(2,'담배'),
(13,'도박'),
(16,'라면'),
(3,'술'),
(15,'유튜브'),
(6,'커피'),
(12,'탄산');
/*!40000 ALTER TABLE `t_not_todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_use_list`
--

DROP TABLE IF EXISTS `t_use_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_use_list` (
  `use_list_id` int(11) NOT NULL AUTO_INCREMENT,
  `goal_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `use_cost` int(11) DEFAULT 0,
  `use_yn` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`use_list_id`),
  KEY `goal_id` (`goal_id`),
  CONSTRAINT `t_use_list_ibfk_2` FOREIGN KEY (`goal_id`) REFERENCES `t_monthly_goal` (`goal_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_use_list`
--

LOCK TABLES `t_use_list` WRITE;
/*!40000 ALTER TABLE `t_use_list` DISABLE KEYS */;
INSERT INTO `t_use_list` VALUES
(2,2,'2023-06-30',5000,1),
(4,3,'2023-06-30',2000,1),
(12,10,'2023-06-30',0,0),
(13,11,'2023-07-01',5000,1),
(14,11,'2023-07-02',0,0),
(15,11,'2023-07-03',0,0),
(16,11,'2023-07-04',0,0),
(17,11,'2023-07-05',0,0),
(18,11,'2023-07-06',0,0),
(19,11,'2023-07-07',0,0),
(20,11,'2023-07-08',0,0),
(21,11,'2023-07-09',0,0),
(22,11,'2023-07-10',0,0),
(23,11,'2023-07-11',0,0),
(24,11,'2023-07-12',0,0),
(25,11,'2023-07-13',0,0),
(26,11,'2023-07-14',0,0),
(27,11,'2023-07-15',0,0),
(28,11,'2023-07-16',0,0),
(29,11,'2023-07-17',0,0),
(30,11,'2023-07-18',0,0),
(31,11,'2023-07-19',0,0),
(32,11,'2023-07-20',0,0),
(33,11,'2023-07-21',0,0),
(34,11,'2023-07-22',0,0),
(35,11,'2023-07-23',0,0),
(36,11,'2023-07-24',0,0),
(37,11,'2023-07-25',0,0),
(38,11,'2023-07-26',0,0),
(39,11,'2023-07-27',0,0),
(40,11,'2023-07-28',0,0),
(41,11,'2023-07-29',0,0),
(42,11,'2023-07-30',0,0),
(43,11,'2023-07-31',0,0),
(44,12,'2023-07-01',0,0),
(45,12,'2023-07-02',0,0),
(46,12,'2023-07-03',0,0),
(47,12,'2023-07-04',0,0),
(48,12,'2023-07-05',0,0),
(49,12,'2023-07-06',0,0),
(50,12,'2023-07-07',0,0),
(51,12,'2023-07-08',0,0),
(52,12,'2023-07-09',0,0),
(53,12,'2023-07-10',0,0),
(54,12,'2023-07-11',0,0),
(55,12,'2023-07-12',0,0),
(56,12,'2023-07-13',0,0),
(57,12,'2023-07-14',0,0),
(58,12,'2023-07-15',0,0),
(59,12,'2023-07-16',0,0),
(60,12,'2023-07-17',0,0),
(61,12,'2023-07-18',0,0),
(62,12,'2023-07-19',0,0),
(63,12,'2023-07-20',0,0),
(64,12,'2023-07-21',0,0),
(65,12,'2023-07-22',0,0),
(66,12,'2023-07-23',0,0),
(67,12,'2023-07-24',0,0),
(68,12,'2023-07-25',0,0),
(69,12,'2023-07-26',0,0),
(70,12,'2023-07-27',0,0),
(71,12,'2023-07-28',0,0),
(72,12,'2023-07-29',0,0),
(73,12,'2023-07-30',0,0),
(74,12,'2023-07-31',0,0),
(75,13,'2023-07-01',0,0),
(76,13,'2023-07-02',0,0),
(77,13,'2023-07-03',0,0),
(78,13,'2023-07-04',0,0),
(79,13,'2023-07-05',0,0),
(80,13,'2023-07-06',0,0),
(81,13,'2023-07-07',0,0),
(82,13,'2023-07-08',0,0),
(83,13,'2023-07-09',0,0),
(84,13,'2023-07-10',0,0),
(85,13,'2023-07-11',0,0),
(86,13,'2023-07-12',0,0),
(87,13,'2023-07-13',0,0),
(88,13,'2023-07-14',0,0),
(89,13,'2023-07-15',0,0),
(90,13,'2023-07-16',0,0),
(91,13,'2023-07-17',0,0),
(92,13,'2023-07-18',0,0),
(93,13,'2023-07-19',0,0),
(94,13,'2023-07-20',0,0),
(95,13,'2023-07-21',0,0),
(96,13,'2023-07-22',0,0),
(97,13,'2023-07-23',0,0),
(98,13,'2023-07-24',0,0),
(99,13,'2023-07-25',0,0),
(100,13,'2023-07-26',0,0),
(101,13,'2023-07-27',0,0),
(102,13,'2023-07-28',0,0),
(103,13,'2023-07-29',0,0),
(104,13,'2023-07-30',0,0),
(105,13,'2023-07-31',0,0),
(106,14,'2023-08-01',0,0),
(107,14,'2023-08-02',0,0),
(108,14,'2023-08-03',0,0),
(109,14,'2023-08-04',0,0),
(110,14,'2023-08-05',0,0),
(111,14,'2023-08-06',0,0),
(112,14,'2023-08-07',0,0),
(113,14,'2023-08-08',0,0),
(114,14,'2023-08-09',0,0),
(115,14,'2023-08-10',0,0),
(116,14,'2023-08-11',0,0),
(117,14,'2023-08-12',0,0),
(118,14,'2023-08-13',0,0),
(119,14,'2023-08-14',0,0),
(120,14,'2023-08-15',0,0),
(121,14,'2023-08-16',0,0),
(122,14,'2023-08-17',0,0),
(123,14,'2023-08-18',0,0),
(124,14,'2023-08-19',0,0),
(125,14,'2023-08-20',0,0),
(126,14,'2023-08-21',0,0),
(127,14,'2023-08-22',0,0),
(128,14,'2023-08-23',0,0),
(129,14,'2023-08-24',0,0),
(130,14,'2023-08-25',0,0),
(131,14,'2023-08-26',0,0),
(132,14,'2023-08-27',0,0),
(133,14,'2023-08-28',0,0),
(134,14,'2023-08-29',0,0),
(135,14,'2023-08-30',0,0),
(136,14,'2023-08-31',0,0),
(137,15,'2023-07-01',2000,1),
(138,15,'2023-07-02',0,0),
(139,15,'2023-07-03',0,0),
(140,15,'2023-07-04',0,0),
(141,15,'2023-07-05',0,0),
(142,15,'2023-07-06',0,0),
(143,15,'2023-07-07',0,0),
(144,15,'2023-07-08',0,0),
(145,15,'2023-07-09',0,0),
(146,15,'2023-07-10',0,0),
(147,15,'2023-07-11',0,0),
(148,15,'2023-07-12',0,0),
(149,15,'2023-07-13',0,0),
(150,15,'2023-07-14',0,0),
(151,15,'2023-07-15',0,0),
(152,15,'2023-07-16',0,0),
(153,15,'2023-07-17',0,0),
(154,15,'2023-07-18',0,0),
(155,15,'2023-07-19',0,0),
(156,15,'2023-07-20',0,0),
(157,15,'2023-07-21',0,0),
(158,15,'2023-07-22',0,0),
(159,15,'2023-07-23',0,0),
(160,15,'2023-07-24',0,0),
(161,15,'2023-07-25',0,0),
(162,15,'2023-07-26',0,0),
(163,15,'2023-07-27',0,0),
(164,15,'2023-07-28',0,0),
(165,15,'2023-07-29',0,0),
(166,15,'2023-07-30',0,0),
(167,15,'2023-07-31',0,0),
(168,16,'2023-07-15',0,0),
(169,16,'2023-07-16',0,0),
(170,16,'2023-07-17',0,0),
(171,16,'2023-07-18',0,0),
(172,16,'2023-07-19',0,0),
(173,16,'2023-07-20',0,0),
(174,16,'2023-07-21',0,0),
(175,16,'2023-07-22',0,0),
(176,16,'2023-07-23',0,0),
(177,16,'2023-07-24',0,0),
(178,16,'2023-07-25',0,0),
(179,16,'2023-07-26',0,0),
(180,16,'2023-07-27',0,0),
(181,16,'2023-07-28',0,0),
(182,16,'2023-07-29',0,0),
(183,16,'2023-07-30',0,0),
(184,16,'2023-07-31',0,0),
(185,17,'2023-07-03',0,0),
(186,17,'2023-07-04',0,0),
(187,17,'2023-07-05',0,0),
(188,17,'2023-07-06',0,0),
(189,17,'2023-07-07',0,0),
(190,17,'2023-07-08',0,0),
(191,17,'2023-07-09',0,0),
(192,17,'2023-07-10',0,0),
(193,17,'2023-07-11',0,0),
(194,17,'2023-07-12',0,0),
(195,17,'2023-07-13',0,0),
(196,17,'2023-07-14',0,0),
(197,17,'2023-07-15',0,0),
(198,17,'2023-07-16',0,0),
(199,17,'2023-07-17',0,0),
(200,17,'2023-07-18',0,0),
(201,17,'2023-07-19',0,0),
(202,17,'2023-07-20',0,0),
(203,17,'2023-07-21',0,0),
(204,17,'2023-07-22',0,0),
(205,17,'2023-07-23',0,0),
(206,17,'2023-07-24',0,0),
(207,17,'2023-07-25',0,0),
(208,17,'2023-07-26',0,0),
(209,17,'2023-07-27',0,0),
(210,17,'2023-07-28',0,0),
(211,17,'2023-07-29',0,0),
(212,17,'2023-07-30',0,0),
(213,17,'2023-07-31',0,0),
(214,18,'2023-07-03',0,0),
(215,18,'2023-07-04',0,0),
(216,18,'2023-07-05',0,0),
(217,18,'2023-07-06',0,0),
(218,18,'2023-07-07',0,0),
(219,18,'2023-07-08',0,0),
(220,18,'2023-07-09',0,0),
(221,18,'2023-07-10',0,0),
(222,18,'2023-07-11',0,0),
(223,18,'2023-07-12',0,0),
(224,18,'2023-07-13',0,0),
(225,18,'2023-07-14',0,0),
(226,18,'2023-07-15',0,0),
(227,18,'2023-07-16',0,0),
(228,18,'2023-07-17',0,0),
(229,18,'2023-07-18',0,0),
(230,18,'2023-07-19',0,0),
(231,18,'2023-07-20',0,0),
(232,18,'2023-07-21',0,0),
(233,18,'2023-07-22',0,0),
(234,18,'2023-07-23',0,0),
(235,18,'2023-07-24',0,0),
(236,18,'2023-07-25',0,0),
(237,18,'2023-07-26',0,0),
(238,18,'2023-07-27',0,0),
(239,18,'2023-07-28',0,0),
(240,18,'2023-07-29',0,0),
(241,18,'2023-07-30',0,0),
(242,18,'2023-07-31',0,0),
(305,21,'2023-02-01',0,0),
(306,21,'2023-02-02',0,0),
(307,21,'2023-02-03',0,0),
(308,21,'2023-02-04',0,0),
(309,21,'2023-02-05',0,0),
(310,21,'2023-02-06',0,0),
(311,21,'2023-02-07',0,0),
(312,21,'2023-02-08',0,0),
(313,21,'2023-02-09',0,0),
(314,21,'2023-02-10',0,0),
(315,21,'2023-02-11',0,0),
(316,21,'2023-02-12',0,0),
(317,21,'2023-02-13',0,0),
(318,21,'2023-02-14',0,0),
(319,21,'2023-02-15',0,0),
(320,21,'2023-02-16',0,0),
(321,21,'2023-02-17',0,0),
(322,21,'2023-02-18',0,0),
(323,21,'2023-02-19',0,0),
(324,21,'2023-02-20',0,0),
(325,21,'2023-02-21',0,0),
(326,21,'2023-02-22',0,0),
(327,21,'2023-02-23',0,0),
(328,21,'2023-02-24',0,0),
(329,21,'2023-02-25',0,0),
(330,21,'2023-02-26',0,0),
(331,21,'2023-02-27',0,0),
(332,21,'2023-02-28',0,0);
/*!40000 ALTER TABLE `t_use_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-05 18:17:19
