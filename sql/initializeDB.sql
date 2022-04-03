-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `charity`
--

DROP TABLE IF EXISTS `charity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `charity` (
  `charity_id` int NOT NULL,
  `charity_name` varchar(50) NOT NULL,
  `charity_location` int NOT NULL,
  PRIMARY KEY (`charity_id`),
  KEY `charity_location` (`charity_location`),
  CONSTRAINT `charity_ibfk_1` FOREIGN KEY (`charity_location`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charity`
--

LOCK TABLES `charity` WRITE;
/*!40000 ALTER TABLE `charity` DISABLE KEYS */;
INSERT INTO `charity` VALUES (1,'The Good Place',1),(2,'Happy Feathers',2),(3,'The Goat\'s Gift',3),(4,'Ending Hunger',4),(5,'Our Scraps',5);
/*!40000 ALTER TABLE `charity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation_items`
--

DROP TABLE IF EXISTS `donation_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donation_items` (
  `donation_store` int NOT NULL,
  `donation_sku` int NOT NULL,
  `donation_amount` int NOT NULL,
  `donation_date` datetime NOT NULL,
  `donation_charity` int NOT NULL,
  PRIMARY KEY (`donation_store`),
  KEY `donation_sku` (`donation_sku`),
  KEY `donation_charity` (`donation_charity`),
  CONSTRAINT `donation_items_ibfk_2` FOREIGN KEY (`donation_store`) REFERENCES `store` (`store_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `donation_items_ibfk_3` FOREIGN KEY (`donation_charity`) REFERENCES `charity` (`charity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation_items`
--

LOCK TABLES `donation_items` WRITE;
/*!40000 ALTER TABLE `donation_items` DISABLE KEYS */;
INSERT INTO `donation_items` VALUES (1,77287899,60,'2022-03-10 00:00:00',2),(2,10222989,13,'2022-03-16 00:00:00',3),(3,50736632,40,'2022-03-12 00:00:00',4),(4,10222789,135,'2022-03-09 00:00:00',1),(5,18992801,237,'2022-03-30 00:00:00',5);
/*!40000 ALTER TABLE `donation_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `inventory_id` smallint NOT NULL AUTO_INCREMENT,
  `item_sku` int NOT NULL,
  `item_expiration_date` datetime NOT NULL,
  `item_amount` int DEFAULT NULL,
  PRIMARY KEY (`inventory_id`),
  UNIQUE KEY `item_sku` (`item_sku`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,77287899,'2022-03-23 00:00:00',24),(2,10222789,'2022-03-16 00:00:00',5),(3,22076567,'2022-03-08 00:00:00',33),(4,10222989,'2022-11-02 00:00:00',25),(5,50736632,'2022-03-18 00:00:00',12);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL,
  `location_city` varchar(50) NOT NULL,
  `location_state` char(2) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Chicago','IL'),(2,'Los Angeles','CA'),(3,'Boulder','CO'),(4,'Oakland','CA'),(5,'New York','NY');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `store_number` int NOT NULL,
  `store_inventory` smallint NOT NULL,
  `store_donation_date` datetime NOT NULL,
  `store_location` int NOT NULL,
  PRIMARY KEY (`store_number`),
  UNIQUE KEY `store_number` (`store_number`),
  KEY `store_location` (`store_location`),
  KEY `store_inventory` (`store_inventory`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`store_inventory`) REFERENCES `inventory` (`inventory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `store_ibfk_2` FOREIGN KEY (`store_location`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,5,'2022-03-17 00:00:00',2),(2,4,'2022-03-05 00:00:00',4),(3,2,'2022-03-31 00:00:00',1),(4,3,'2022-03-10 00:00:00',2),(5,1,'2022-03-22 00:00:00',2);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-02 23:18:26
