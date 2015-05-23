CREATE DATABASE  IF NOT EXISTS `gda` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gda`;
-- MySQL dump 10.13  Distrib 5.6.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: gda
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` varchar(50) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('abhi','123456',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ambulance_master`
--

DROP TABLE IF EXISTS `ambulance_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ambulance_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ambulance_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ambulance_master`
--

LOCK TABLES `ambulance_master` WRITE;
/*!40000 ALTER TABLE `ambulance_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `ambulance_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcr_vans_master`
--

DROP TABLE IF EXISTS `pcr_vans_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pcr_vans_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `van_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcr_vans_master`
--

LOCK TABLES `pcr_vans_master` WRITE;
/*!40000 ALTER TABLE `pcr_vans_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcr_vans_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imei` varchar(500) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `address` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (17,'1231323213','1231321433','123.1232','12313.1223312','adsffsd fs3  dfjshkfdfadf'),(33,'1231323213','1231321433','123.1232','12313.1223312','adsffsd fs3  dfjshkfdfadf'),(34,'1231323213','1231321433','123.1232','12313.1223312','adsffsd fs3  dfjshkfdfadf'),(37,'1231323213','1231321433','123.1232','12313.1223312','adsffsd fs3  dfjshkfdfadf');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `contact_number` varchar(15) NOT NULL,
  `parent_contact_number` varchar(15) NOT NULL,
  `address` varchar(500) NOT NULL,
  `voter_id` varchar(50) NOT NULL,
  `imei` varchar(500) NOT NULL,
  `email` varchar(250) NOT NULL,
  `postal_code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES (9,'Aditya','8115048687','7565973232','bdsZg','yydf','865317021158565','aditya.1210010@kiet.edu','209625'),(10,'Aditya','15555215554','9044384624','Kanpur','Cl123 ','000000000000000','null','12345'),(11,'Adi','','7565973232','farrukhabad','cs12345','358870059272207','prakharmittal95@gmail.com','209625'),(12,'Absihek Sharma','1234567890','9784512365','ghaziabad','ca12345','865317021158565','aditya.1210010@kiet.edu','206954'),(13,'Aditya','9044384625','8115048687','delhi','cl122','359462046860614','amalyadav@gmail.com','209625');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-24 21:57:54
