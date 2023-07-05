-- MariaDB dump 10.19-11.0.2-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: not_todo_test
-- ------------------------------------------------------
-- Server version	11.0.2-MariaDB

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member`
--

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES
(7,'minami','string'),
(9,'minami1',NULL),
(12,'minami2',NULL);
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

-- Dump completed on 2023-07-06  1:15:27
