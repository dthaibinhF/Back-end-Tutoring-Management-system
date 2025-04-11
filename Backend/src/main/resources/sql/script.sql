-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: chemis_backup
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` varchar(15) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `account_details_id` int NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  KEY `account_details_id` (`account_details_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`account_details_id`) REFERENCES `account_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Đặng Thái Bình','dthaibinh03@gmail.com','0939464077','{noop}Dthaibinh@1234',1,'2025-02-10'),
                             (2,'Donnie Gottlieb','nhut@gmail.com','0123456780','{bcrypt}$2a$12$KBdErJidVwMvzqN/mlQQVurMueux6oaT0t1KXQkfFTn98QYDVP6Jm',2,'2025-02-20'),
                             (3,'Phan Tấn Phát','phat@gmail.com','0123456789','{bcrypt}$2a$12$aWEDx6JpvXScPRVk7cTxkeKh4e5qxQsk91wGtS.KVS2/L0/AcU.B2',3,'2025-02-20'),
                             (4,'Bùi Gia Mỹ','my@gmail.com','0987654321','{bcrypt}$2a$12$HRPpgmQ2SuIbf1HfJEMXGeSlmHQ7SgucyVTJSpZXJXYT6PMFlJJES',4,'2025-02-20'),
                             (5,'Nguyễn Hoàng Trung','trung@gmail.com','0333098311','{bcrypt}$2a$12$HRPpgmQ2SuIbf1HfJEMXGeSlmHQ7SgucyVTJSpZXJXYT6PMFlJJES',5,'2025-02-21'),
                             (6,'Beverly Breitenberg','Daisy.Stracke40@example.net','620-780-6558','{bcrypt}$2a$10$DG8BSVpeTX5lrMO3LQpWp.Z40QNzam4anwoQwF9Zht4iyklY3uvZq',6,'2025-03-17'),
                             (7,'Elbert Wisoky','Jeanette85@example.org','878-367-8628','{bcrypt}$2a$10$PnO1MwAxTfNeVc8Tq9Z4MeAZNnwjXKX4DMHv67ktD/2S6Q4JIywwW',9,'2025-03-23');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_authority`
--

DROP TABLE IF EXISTS `account_authority`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_authority` (
  `account_id` int NOT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`account_id`,`authority_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `account_authority_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `account_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_authority`
--

LOCK TABLES `account_authority` WRITE;
/*!40000 ALTER TABLE `account_authority` DISABLE KEYS */;
INSERT INTO `account_authority` VALUES (1,1),(2,1),(5,3),(7,3),(3,4),(4,4),(6,4);
/*!40000 ALTER TABLE `account_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_details`
--

DROP TABLE IF EXISTS `account_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_details`
--

LOCK TABLES `account_details` WRITE;
/*!40000 ALTER TABLE `account_details` DISABLE KEYS */;
INSERT INTO `account_details` VALUES (1,'Cần Thơ, Việt Nam'),(2,'Lake Rhoda'),(3,'Tiền Giang, Việt Nam'),(4,'Cái Bè, Việt Nam'),(5,'Hậu Giang, Việt Nam'),(6,'North Marc'),(9,'West Evelineside');
/*!40000 ALTER TABLE `account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT 'student, teacher,...',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MANAGER'),(3,'ROLE_TEACHER'),(4,'ROLE_STUDENT');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL COMMENT 'VIP NORMAL',
  `grade` int NOT NULL,
  `max_student` int NOT NULL COMMENT 'maxium number of student in class',
  PRIMARY KEY (`id`),
  KEY `grade` (`grade`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`grade`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'12N1','NORMAL',12,70),(2,'12N2','NORMAL',12,50),(3,'12N3','NORMAL',12,50),(4,'12NC1','NORMAL',12,50),(5,'12NC2','NORMAL',12,50),(6,'12V1','NORMAL',12,50),(7,'12N3','NORMAL',12,50);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `grade` int NOT NULL COMMENT '10 11 12',
  PRIMARY KEY (`id`),
  UNIQUE KEY `grade` (`grade`),
  KEY `grade_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (10,10),(11,11),(12,12);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `period_time`
--

DROP TABLE IF EXISTS `period_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `period_time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `date_of_week` varchar(10) NOT NULL COMMENT 'monday, tuesday,.... sunday',
  `start_at` time NOT NULL,
  `end_at` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='class period';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period_time`
--

LOCK TABLES `period_time` WRITE;
/*!40000 ALTER TABLE `period_time` DISABLE KEYS */;
INSERT INTO `period_time` VALUES (1,'monday-1','monday','07:20:00','09:00:00'),(2,'monday-2','monday','09:20:00','11:00:00'),(3,'monday-3','monday','13:20:00','15:00:00'),(4,'monday-4','monday','15:20:00','17:00:00'),(5,'monday-5','monday','17:20:00','19:00:00'),(6,'monday-6','monday','19:20:00','21:00:00'),(7,'tuesday-1','tuesday','07:20:00','09:00:00'),(8,'tuesday-2','tuesday','09:20:00','11:00:00'),(9,'tuesday-3','tuesday','13:20:00','15:00:00'),(10,'tuesday-4','tuesday','15:20:00','17:00:00'),(11,'tuesday-5','tuesday','17:20:00','19:00:00'),(12,'tuesday-6','tuesday','19:20:00','21:00:00'),(13,'wednesday-1','wednesday','07:20:00','09:00:00'),(14,'wednesday-2','wednesday','09:20:00','11:00:00'),(15,'wednesday-3','wednesday','13:20:00','15:00:00'),(16,'wednesday-4','wednesday','15:20:00','17:00:00'),(17,'wednesday-5','wednesday','17:20:00','19:00:00'),(18,'wednesday-6','wednesday','19:20:00','21:00:00'),(19,'thursday-1','thursday','07:20:00','09:00:00'),(20,'thursday-2','thursday','09:20:00','11:00:00'),(21,'thursday-3','thursday','13:20:00','15:00:00'),(22,'thursday-4','thursday','15:20:00','17:00:00'),(23,'thursday-5','thursday','17:20:00','19:00:00'),(24,'thursday-6','thursday','19:20:00','21:00:00'),(25,'friday-1','friday','07:20:00','09:00:00'),(26,'friday-2','friday','09:20:00','11:00:00'),(27,'friday-3','friday','13:20:00','15:00:00'),(28,'friday-4','friday','15:20:00','17:00:00'),(29,'friday-5','friday','17:20:00','19:00:00'),(30,'friday-6','friday','19:20:00','21:00:00'),(31,'saturday-1','saturday','07:20:00','09:00:00'),(32,'saturday-2','saturday','09:20:00','11:00:00'),(33,'saturday-3','saturday','13:20:00','15:00:00'),(34,'saturday-4','saturday','15:20:00','17:00:00'),(35,'saturday-5','saturday','17:20:00','19:00:00'),(36,'saturday-6','saturday','19:20:00','21:00:00'),(37,'sunday-1','sunday','07:20:00','09:00:00'),(38,'sunday-2','sunday','09:20:00','11:00:00'),(39,'sunday-3','sunday','13:20:00','15:00:00'),(40,'sunday-4','sunday','15:20:00','17:00:00'),(41,'sunday-5','sunday','17:20:00','19:00:00'),(43,'sunday-6','sunday','19:20:00','21:00:00');
/*!40000 ALTER TABLE `period_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `period_time_class`
--

DROP TABLE IF EXISTS `period_time_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `period_time_class` (
  `period_time_id` int NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`period_time_id`,`class_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `period_time_class_ibfk_1` FOREIGN KEY (`period_time_id`) REFERENCES `period_time` (`id`),
  CONSTRAINT `period_time_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period_time_class`
--

LOCK TABLES `period_time_class` WRITE;
/*!40000 ALTER TABLE `period_time_class` DISABLE KEYS */;
INSERT INTO `period_time_class` VALUES (5,1),(17,1),(29,1),(6,2),(18,2),(30,2),(12,3),(24,3),(36,3),(16,4),(28,4),(40,4),(11,5),(23,5),(35,5),(5,6),(17,6),(29,6);
/*!40000 ALTER TABLE `period_time_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roll_call`
--

DROP TABLE IF EXISTS `roll_call`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roll_call` (
  `name` varchar(50) NOT NULL,
  `student_id` int NOT NULL,
  `class_id` int NOT NULL COMMENT 'student''s main class',
  `at_date` date NOT NULL,
  `roll_call` varchar(20) NOT NULL COMMENT 'attendace - absent - make up class (hoc bu)',
  `class_attendance` varchar(10) NOT NULL COMMENT 'write the class student study at the time roll call',
  PRIMARY KEY (`student_id`,`class_id`,`at_date`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `roll_call_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `roll_call_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='luu tru diem danh';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roll_call`
--

LOCK TABLES `roll_call` WRITE;
/*!40000 ALTER TABLE `roll_call` DISABLE KEYS */;
/*!40000 ALTER TABLE `roll_call` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_pay_at` date NOT NULL,
  `salary` decimal(15,4) NOT NULL,
  `teacher_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (2,'2025-03-20',25000000.0000,1),(3,'2024-12-01',20000000.0000,1),(4,'2025-02-20',30000000.0000,1),(5,'2025-01-15',30000000.0000,1),(6,'2024-12-01',15000000.0000,2),(7,'2025-02-20',20000000.0000,2),(8,'2025-01-15',23000000.0000,2),(10,'2025-02-17',10000000.0000,1),(11,'2024-11-18',19000000.0000,1);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `id` int NOT NULL AUTO_INCREMENT,
  `school_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'Truong THPT Châu Văn Liêm'),(2,'Truong THPT Thực Hành Sư Phạm'),(3,'Truong THPT Phan Ngọc Hiển'),(4,'Truong THPT Nguyễn Việt Hồng'),(5,'Truong THPT Nguyễn Việt Dũng'),(6,'Truong THPT An Khánh'),(7,'Truong THPT Bình Minh'),(8,'Truong THPT Nguyễn Bỉnh Khiêm'),(9,'Truong THPT Tầm Vu');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_year`
--

DROP TABLE IF EXISTS `school_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school_year` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_at` date NOT NULL,
  `end_at` date NOT NULL,
  `year_start_at` year NOT NULL,
  `year_end_at` year NOT NULL,
  PRIMARY KEY (`id`),
  KEY `school_year_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_year`
--

LOCK TABLES `school_year` WRITE;
/*!40000 ALTER TABLE `school_year` DISABLE KEYS */;
INSERT INTO `school_year` VALUES (1,'2024-09-05','2025-05-31',2024,2025);
/*!40000 ALTER TABLE `school_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_year_grade`
--

DROP TABLE IF EXISTS `school_year_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school_year_grade` (
  `school_year_id` int NOT NULL,
  `grade_id` int NOT NULL,
  PRIMARY KEY (`school_year_id`,`grade_id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `school_year_grade_ibfk_1` FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id`),
  CONSTRAINT `school_year_grade_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_year_grade`
--

LOCK TABLES `school_year_grade` WRITE;
/*!40000 ALTER TABLE `school_year_grade` DISABLE KEYS */;
INSERT INTO `school_year_grade` VALUES (1,10),(1,11),(1,12);
/*!40000 ALTER TABLE `school_year_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `score` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,1,'KT xếp lớp',9.00),(2,2,'KT xếp lớp',9.50),(3,1,'Diem hoc ky',5.00);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `school_id` int NOT NULL,
  `class_id` int NOT NULL,
  `grade_id` int NOT NULL,
  `start_learning_at` date NOT NULL,
  `stop_learning_at` date NOT NULL,
  `enable` int NOT NULL COMMENT '1 - true, 0 - false',
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  KEY `class_id` (`class_id`),
  KEY `grade_id` (`grade_id`),
  KEY `student_ibfk_1_idx` (`account_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`),
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`),
  CONSTRAINT `student_ibfk_4` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,3,6,1,12,'2025-01-01','2025-04-30',1),(2,4,2,4,12,'2025-01-01','2025-04-30',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_fee`
--

DROP TABLE IF EXISTS `student_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_fee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `fee` decimal(15,4) NOT NULL COMMENT 'so tien can dong',
  `start_at` date NOT NULL COMMENT 'start term',
  `end_at` date NOT NULL COMMENT 'end term',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_fee`
--

LOCK TABLES `student_fee` WRITE;
/*!40000 ALTER TABLE `student_fee` DISABLE KEYS */;
INSERT INTO `student_fee` VALUES (1,'lớp 12 Học kỳ 2',1800000.0000,'2025-01-01','2025-04-30'),(2,'lớp 11 Học kỳ 2',2000000.0000,'2025-01-01','2025-04-30'),(3,'lớp 10 Học kỳ 2',2000000.0000,'2025-01-01','2025-04-30');
/*!40000 ALTER TABLE `student_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_pay_fee`
--

DROP TABLE IF EXISTS `student_pay_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_pay_fee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `student_fee` int NOT NULL,
  `already_pay` decimal(15,4) NOT NULL COMMENT 'so tien da dong',
  `remaining` decimal(15,4) NOT NULL COMMENT 'so tien con lai',
  `latest_pay_at` date NOT NULL COMMENT 'ngay dong hoc phi',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `student_fee` (`student_fee`),
  CONSTRAINT `student_pay_fee_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `student_pay_fee_ibfk_2` FOREIGN KEY (`student_fee`) REFERENCES `student_fee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_pay_fee`
--

LOCK TABLES `student_pay_fee` WRITE;
/*!40000 ALTER TABLE `student_pay_fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_pay_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_ibfk_1_idx` (`account_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,5),(2,7);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `at_date` date NOT NULL,
  `teacher_id` int NOT NULL,
  `student_id` int NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `timetable_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `timetable_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='thoi khoa bieu chung cho tung nhom trong tuan';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-23 20:51:07
