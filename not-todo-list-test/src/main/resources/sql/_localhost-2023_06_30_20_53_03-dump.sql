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
-- Table structure for table `t_memo`
--

DROP TABLE IF EXISTS `t_memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_memo` (
  `memo_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`memo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_memo`
--

LOCK TABLES `t_memo` WRITE;
/*!40000 ALTER TABLE `t_memo` DISABLE KEYS */;
INSERT INTO `t_memo` VALUES
(1,'don\'t stress');
/*!40000 ALTER TABLE `t_memo` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_monthly_goal`
--

LOCK TABLES `t_monthly_goal` WRITE;
/*!40000 ALTER TABLE `t_monthly_goal` DISABLE KEYS */;
INSERT INTO `t_monthly_goal` VALUES
(1,1,2,30,'2023-06',30),
(2,2,1,300000,'2023-06',300000),
(3,3,1,100000,'2023-06',150000),
(4,12,1,10000,'2023-07',240000),
(5,6,1,20000,'2023-07',220000),
(6,6,2,60,'2023-07',60),
(8,15,2,1500,'2023-06',1500),
(9,15,2,50,'2023-06',50),
(10,15,2,50,'2023-06',50);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_not_todo`
--

LOCK TABLES `t_not_todo` WRITE;
/*!40000 ALTER TABLE `t_not_todo` DISABLE KEYS */;
INSERT INTO `t_not_todo` VALUES
(1,'게임'),
(2,'담배'),
(13,'도박'),
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
  `cost` int(11) DEFAULT 0,
  `use_yn` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`use_list_id`),
  KEY `monthly_goal_id` (`goal_id`),
  CONSTRAINT `t_use_list_ibfk_1` FOREIGN KEY (`goal_id`) REFERENCES `t_monthly_goal` (`goal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_use_list`
--

LOCK TABLES `t_use_list` WRITE;
/*!40000 ALTER TABLE `t_use_list` DISABLE KEYS */;
INSERT INTO `t_use_list` VALUES
(1,1,'2023-06-29',2,0),
(2,2,'2023-06-30',5000,0),
(3,1,'2023-06-30',3,0),
(4,3,'2023-06-30',2000,0),
(5,4,'2023-06-30',3000,0),
(6,5,'2023-06-30',4000,0),
(7,6,'2023-06-30',1,0),
(12,10,'2023-06-30',0,0);
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

-- Dump completed on 2023-06-30 20:53:03
