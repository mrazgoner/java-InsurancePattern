-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: insurance
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `birthDate` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `customersId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Tomer','Cohen','1987-03-01','Hanasi 28, Haifa','0528563221','tomerc@gmail.com','305332147'),(2,'yosi','yosi','2018-02-02','jojo 56, tel aviv','0523652214','yosi@gmail.com','123456789'),(3,'ofir','ofir','2018-02-06','hahotrim 23, hadera','0532141222','ofir@gmail.com','123645213'),(4,'ofra','hako','2011-02-04','td 23, rishon','05231452','ofra@mail.com','123'),(5,'roni','mana','2018-02-01','gdsfds 21, haifa','0523479101','fdsfds@mail','123145654'),(6,'ron','ben','2018-02-06','jodas 12, karmiel','0521342133','dsa@mail.com','123012445');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_claim`
--

DROP TABLE IF EXISTS `client_claim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_claim` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customersId` varchar(45) DEFAULT NULL,
  `insuranceType` varchar(45) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_claim`
--

LOCK TABLES `client_claim` WRITE;
/*!40000 ALTER TABLE `client_claim` DISABLE KEYS */;
INSERT INTO `client_claim` VALUES (1,'305332147','Car Insurance','yesterday i had an accident.');
/*!40000 ALTER TABLE `client_claim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_insurance`
--

DROP TABLE IF EXISTS `client_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_insurance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customersId` varchar(45) DEFAULT NULL,
  `insuranceType` varchar(45) DEFAULT NULL,
  `info` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_insurance`
--

LOCK TABLES `client_insurance` WRITE;
/*!40000 ALTER TABLE `client_insurance` DISABLE KEYS */;
INSERT INTO `client_insurance` VALUES (1,'305332147','Car Insurance','2003'),(3,'305332147','Life Insurance','1987-03-01'),(5,'123645213','House Insurance','78'),(6,'123','Car Insurance','1923');
/*!40000 ALTER TABLE `client_insurance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-17 17:16:38
