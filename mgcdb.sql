-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: mgc
-- ------------------------------------------------------
-- Server version	5.5.42

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
-- Table structure for table `ceny_walut`
--

DROP TABLE IF EXISTS `ceny_walut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceny_walut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_notowania` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eur` double DEFAULT NULL,
  `numer_tabeli` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usd` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceny_walut`
--

LOCK TABLES `ceny_walut` WRITE;
/*!40000 ALTER TABLE `ceny_walut` DISABLE KEYS */;
INSERT INTO `ceny_walut` VALUES (1,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(2,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(3,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(4,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(5,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(6,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(7,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(8,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(9,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(10,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(11,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(12,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(13,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(14,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(15,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(16,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(17,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(18,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(19,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(20,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(21,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(22,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(23,'2016-05-23',4.4663,'098/C/NBP/2016',3.9801),(24,'2016-05-24',4.4829,'099/C/NBP/2016',4.0062),(25,'2016-05-24',4.4829,'099/C/NBP/2016',4.0062),(26,'2016-05-24',4.4829,'099/C/NBP/2016',4.0062),(27,'2016-05-24',4.4829,'099/C/NBP/2016',4.0062),(28,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(29,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(30,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(31,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(32,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(33,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(34,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(35,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(36,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(37,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(38,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(39,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(40,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(41,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(42,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(43,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(44,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(45,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(46,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(47,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(48,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(49,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(50,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(51,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(52,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(53,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(54,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(55,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(56,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(57,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(58,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(59,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(60,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(61,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(62,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(63,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(64,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(65,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(66,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(67,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(68,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(69,'2016-05-25',4.4855,'100/C/NBP/2016',4.0219),(70,'2016-05-27',4.4576,'101/C/NBP/2016',3.9975);
/*!40000 ALTER TABLE `ceny_walut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marki`
--

DROP TABLE IF EXISTS `marki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marki` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marki`
--

LOCK TABLES `marki` WRITE;
/*!40000 ALTER TABLE `marki` DISABLE KEYS */;
INSERT INTO `marki` VALUES (1,'Acura'),(2,'Alfa Romeo'),(3,'Aro'),(4,'Aston Martin'),(5,'Audi'),(6,'Austin'),(7,'Barkas'),(8,'Bedford'),(9,'Bentley'),(10,'BMW'),(11,'Bugatti'),(12,'Buick'),(13,'Cadillac'),(14,'Chevrolet'),(15,'Chrysler'),(16,'Citroen'),(17,'Dacia'),(18,'Daewoo'),(19,'Daf'),(20,'Daihatsu'),(21,'Dodge'),(22,'Eagle'),(23,'Ferrari'),(24,'Fiat'),(25,'Ford'),(26,'FSO'),(27,'Gaz'),(28,'Geo'),(29,'GMC'),(30,'HDPIC'),(31,'Honda'),(32,'Hummer'),(33,'Hyundai'),(34,'IFA'),(35,'Infiniti'),(36,'Innocenti'),(37,'Isuzu'),(38,'Iveco'),(39,'Jaguar'),(40,'Jeep'),(41,'Kia'),(42,'Koenigsegg'),(43,'Lamborghini'),(44,'Lancia'),(45,'Land Rover'),(46,'LDV'),(47,'Lexus'),(48,'Lincoln'),(49,'Lublin'),(50,'Łada'),(51,'Maruti'),(52,'Maserati'),(53,'Maybach'),(54,'Mazda'),(55,'Melex'),(56,'Mercedes'),(57,'Mercury'),(58,'MG'),(59,'Mikrus'),(60,'Mini'),(61,'Mitsubishi'),(62,'Moskwicz'),(63,'Nissan'),(64,'NSU'),(65,'Nysa'),(66,'Oldsmobile'),(67,'Oltcit'),(68,'Opel'),(69,'Peugeot'),(70,'Plymouth'),(71,'Polonez'),(72,'Pontiac'),(73,'Porsche'),(74,'Proton'),(75,'Renault'),(76,'Rolls-Royce'),(77,'Rover'),(78,'Saab'),(79,'Saleen'),(80,'Sam'),(81,'Saturn'),(82,'Seat'),(83,'Skoda'),(84,'Smart'),(85,'Ssang Yong'),(86,'Subaru'),(87,'Suzuki'),(88,'Syrena'),(89,'Talbot'),(90,'Tarpan'),(91,'Tatra'),(92,'Tavria'),(93,'Toyota'),(94,'Trabant'),(95,'TVR'),(96,'Uaz'),(97,'Volkswagen'),(98,'Volvo'),(99,'Warszawa'),(100,'Wartburg'),(101,'Wołga'),(102,'Yugo'),(103,'Zaporożec'),(104,'Zastawa'),(105,'Żuk');
/*!40000 ALTER TABLE `marki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `samochody`
--

DROP TABLE IF EXISTS `samochody`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `samochody` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cena` double DEFAULT NULL,
  `faktura` bit(1) DEFAULT NULL,
  `moc` int(11) DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pojemnosc_skokowa` int(11) DEFAULT NULL,
  `przebieg` int(11) DEFAULT NULL,
  `rok_produkcji` int(11) DEFAULT NULL,
  `tytul` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marka` int(11) DEFAULT NULL,
  `cena_eur` double DEFAULT NULL,
  `cena_usd` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i5fl9e59igbgpar6h6si0n1l6` (`marka`),
  CONSTRAINT `FK_i5fl9e59igbgpar6h6si0n1l6` FOREIGN KEY (`marka`) REFERENCES `marki` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `samochody`
--

LOCK TABLES `samochody` WRITE;
/*!40000 ALTER TABLE `samochody` DISABLE KEYS */;
INSERT INTO `samochody` VALUES (1,37500,NULL,140,'A3',NULL,1968,188150,2012,'Audi A3 2.0 TDI 140PS SPORTBACK ATTRACTION',5,8412.598707824838,9380.863039399625),(2,42500,NULL,105,'A3',NULL,1598,143264,2013,'Audi A3 SPORTBACK PISEMNA GWARANCJA BEZKOLIZYJNOŚCI I PRZEBIEGU AUTA 2x Koła MODEL 2013',5,9534.278535534817,10631.644777986241),(3,72700,NULL,115,'316d',NULL,1995,117497,2014,'BMW 316 D NAJTAŃSZA NOWA 3 W POLSCE!! - GWARANCJA NA PIŚMIE,Bezwypadkowa i Nieskręcona,2x Koła',10,16309.224694903087,18186.366479049404),(4,1,NULL,NULL,'',NULL,NULL,NULL,NULL,'ĄŚĘZŻłóżę',1,0.22433596554199567,0.2501563477173233),(5,2,NULL,NULL,'',NULL,NULL,NULL,NULL,'BMW 316 D NAJTA?SZA NOWA 3 W POLSCE!! - GWARANCJA NA PI?MIE,Bezwypadkowa i Nieskr?cona,2x Ko?a',1,0.44867193108399134,0.5003126954346466),(6,5,NULL,NULL,'',NULL,NULL,NULL,NULL,'BMW 316 D NAJTA?SZA NOWA 3 W POLSCE!! - GWARANCJA NA PI?MIE,Bezwypadkowa i Nieskr?cona,2x Ko?a',10,1.1216798277099784,1.2507817385866167),(8,8,NULL,NULL,'',NULL,NULL,NULL,NULL,'?',1,1.7946877243359654,2.0012507817385865),(9,8900,NULL,90,'abc',NULL,2400,190000,1999,'Testowe ogłoszenie bez zdjęć!',1,1996.5900933237615,2226.3914946841774),(10,19000,NULL,190,'m',NULL,1999,190000,1999,'Testowe ogloszenie 2 ',1,4262.383345297918,4752.970606629143),(11,29,NULL,NULL,'',NULL,NULL,NULL,NULL,'sss',1,6.5057430007178745,7.254534083802376),(12,90,NULL,NULL,'',NULL,NULL,NULL,NULL,'ssss',1,20.190236898779613,22.5140712945591),(13,190000,NULL,NULL,'',NULL,NULL,NULL,NULL,'jkhjfdkjshf',1,42623.83345297918,47529.70606629143);
/*!40000 ALTER TABLE `samochody` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `samochody_lista_wyposazenia`
--

DROP TABLE IF EXISTS `samochody_lista_wyposazenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `samochody_lista_wyposazenia` (
  `samochody` int(11) NOT NULL,
  `lista_wyposazenia` int(11) NOT NULL,
  KEY `FK_55uvj1idu5hvh0bpc8pvn4a9x` (`lista_wyposazenia`),
  KEY `FK_1v0sun1q48we7ybvxyvrvbcyu` (`samochody`),
  CONSTRAINT `FK_1v0sun1q48we7ybvxyvrvbcyu` FOREIGN KEY (`samochody`) REFERENCES `samochody` (`id`),
  CONSTRAINT `FK_55uvj1idu5hvh0bpc8pvn4a9x` FOREIGN KEY (`lista_wyposazenia`) REFERENCES `wyposazenie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `samochody_lista_wyposazenia`
--

LOCK TABLES `samochody_lista_wyposazenia` WRITE;
/*!40000 ALTER TABLE `samochody_lista_wyposazenia` DISABLE KEYS */;
INSERT INTO `samochody_lista_wyposazenia` VALUES (1,1),(1,2),(1,3),(2,1),(3,1),(3,2),(3,3),(9,1),(9,26),(9,30),(9,34),(10,3),(11,14),(12,14),(12,18),(13,1),(13,2),(13,3),(13,4),(13,5),(13,6),(13,7),(13,8);
/*!40000 ALTER TABLE `samochody_lista_wyposazenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `samochody_zdjecia`
--

DROP TABLE IF EXISTS `samochody_zdjecia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `samochody_zdjecia` (
  `samochody` int(11) NOT NULL,
  `zdjecia` int(11) NOT NULL,
  KEY `FK_s9gr5yev0n74m9urjlg23ytbt` (`zdjecia`),
  KEY `FK_4lkmr306t32o1jg0pnbljjtso` (`samochody`),
  CONSTRAINT `FK_4lkmr306t32o1jg0pnbljjtso` FOREIGN KEY (`samochody`) REFERENCES `samochody` (`id`),
  CONSTRAINT `FK_s9gr5yev0n74m9urjlg23ytbt` FOREIGN KEY (`zdjecia`) REFERENCES `zdjecia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `samochody_zdjecia`
--

LOCK TABLES `samochody_zdjecia` WRITE;
/*!40000 ALTER TABLE `samochody_zdjecia` DISABLE KEYS */;
INSERT INTO `samochody_zdjecia` VALUES (1,1),(5,10),(6,11),(8,14),(2,16),(3,17),(4,18),(9,19),(10,20),(11,21);
/*!40000 ALTER TABLE `samochody_zdjecia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wyposazenie`
--

DROP TABLE IF EXISTS `wyposazenie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wyposazenie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wyposazenie`
--

LOCK TABLES `wyposazenie` WRITE;
/*!40000 ALTER TABLE `wyposazenie` DISABLE KEYS */;
INSERT INTO `wyposazenie` VALUES (1,'ABS'),(2,'CD'),(3,'Centralny zamek'),(4,'Elektryczne szyby przednie'),(5,'Elektrycznie ustawiane lusterka'),(6,'Immobilizer'),(7,'Poduszka powietrzna kierowcy'),(8,'Poduszka powietrzna pasażera'),(9,'Radio fabryczne'),(10,'Wspomaganie kierownicy'),(11,'Alarm'),(12,'Alufelgi'),(13,'ASR (kontrola trakcji)'),(14,'Asystent parkowania'),(15,'Asystent pasa ruchu'),(16,'Bluetooth'),(17,'Czujnik deszczu'),(18,'Czujnik martwego pola'),(19,'Czujnik zmierzchu'),(20,'Czujniki parkowania przednie'),(21,'Czujniki parkowania tylne'),(22,'Dach panoramiczny'),(23,'Elektrochromatyczne lusterka boczne'),(24,'Elektrochromatyczne lusterko wsteczne'),(25,'Elektryczne szyby tylne'),(26,'Elektrycznie ustawiane fotele'),(27,'ESP (stabilizacja toru jazdy)'),(28,'Gniazdo AUX'),(29,'Gniazdo SD'),(30,'Gniazdo USB'),(31,'Hak'),(32,'HUD (wyświetlacz przezierny)'),(33,'Isofix'),(34,'Kamera cofania'),(35,'Klimatyzacja automatyczna'),(36,'Klimatyzacja czterostrefowa'),(37,'Klimatyzacja dwustrefowa'),(38,'Klimatyzacja manualna'),(39,'Komputer pokładowy'),(40,'Kurtyny powietrzne'),(41,'Łopatki zmiany biegów'),(42,'MP3'),(43,'Nawigacja GPS'),(44,'Odtwarzacz DVD'),(45,'Ogranicznik prędkości'),(46,'Ogrzewanie postojowe'),(47,'Podgrzewana przednia szyba'),(48,'Podgrzewane lusterka boczne'),(49,'Podgrzewane przednie siedzenia'),(50,'Podgrzewane tylne siedzenia'),(51,'Poduszka powietrzna chroniąca kolana'),(52,'Poduszki boczne przednie'),(53,'Poduszki boczne tylne'),(54,'Przyciemniane szyby'),(55,'Radio niefabryczne'),(56,'Regulowane zawieszenie'),(57,'Relingi dachowe'),(58,'System Start-Stop'),(59,'Szyberdach'),(60,'Światła do jazdy dziennej'),(61,'Światła LED'),(62,'Światła przeciwmgielne'),(63,'Światła Xenonowe'),(64,'Tapicerka skórzana'),(65,'Tapicerka welurowa'),(66,'Tempomat'),(67,'Tempomat aktywny'),(68,'Tuner TV'),(69,'Wielofunkcyjna kierownica'),(70,'Zmieniarka CD');
/*!40000 ALTER TABLE `wyposazenie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zdjecia`
--

DROP TABLE IF EXISTS `zdjecia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zdjecia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sciezka` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zdjecia`
--

LOCK TABLES `zdjecia` WRITE;
/*!40000 ALTER TABLE `zdjecia` DISABLE KEYS */;
INSERT INTO `zdjecia` VALUES (1,''),(2,''),(3,''),(4,''),(5,''),(6,''),(7,''),(8,''),(9,''),(10,''),(11,''),(13,''),(14,''),(15,''),(16,''),(17,''),(18,''),(19,''),(20,''),(21,'');
/*!40000 ALTER TABLE `zdjecia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mgc'
--

--
-- Dumping routines for database 'mgc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-28 14:06:04
