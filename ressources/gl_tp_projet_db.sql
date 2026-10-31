-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 06, 2025 at 09:46 PM
-- Server version: 9.1.0
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gl_tp_projet_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(100) NOT NULL,
  `passWord` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `adminName`, `passWord`) VALUES
(4, 'mehdi', 'hello'),
(6, 'mehdi', 'rtyuijmkl'),
(8, 'mehdi', 'im tired'),
(10, 'mehdi', 'im tired3'),
(11, 'mehdi', 'im tired3ergrt'),
(13, 'mehdi', 'cherif'),
(14, 'mehdi', 'cher'),
(15, 'mehdi', 'cherif');

-- --------------------------------------------------------

--
-- Table structure for table `animaux`
--

DROP TABLE IF EXISTS `animaux`;
CREATE TABLE IF NOT EXISTS `animaux` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `espece` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `poids_kg` double DEFAULT NULL,
  `proprietaireId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_proprietaire` (`proprietaireId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animaux`
--

INSERT INTO `animaux` (`id`, `nom`, `espece`, `age`, `poids_kg`, `proprietaireId`) VALUES
(1, 'Mimi', 'Chat', 3, 4.2, 1),
(2, 'Rex', 'Chien', 5, 22.8, 1),
(3, 'Bella', 'Chien', 2, 12.5, 2),
(4, 'Kiko', 'Perroquet', 4, 0.9, 2),
(5, 'Flash', 'Cheval', 7, 380, 3),
(6, 'Simo', 'Lapin', 1, 1.1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
CREATE TABLE IF NOT EXISTS `crew` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `motdepasse` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `docteur`
--

DROP TABLE IF EXISTS `docteur`;
CREATE TABLE IF NOT EXISTS `docteur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `motdepasse` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  `prix` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `quantite`, `prix`) VALUES
(4, 'D', 50, 150),
(5, 'E', 300, 120),
(6, 'F', 50, 90);

-- --------------------------------------------------------

--
-- Table structure for table `produitutiliser`
--

DROP TABLE IF EXISTS `produitutiliser`;
CREATE TABLE IF NOT EXISTS `produitutiliser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  `prix` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `proprietaires`
--

DROP TABLE IF EXISTS `proprietaires`;
CREATE TABLE IF NOT EXISTS `proprietaires` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `proprietaires`
--

INSERT INTO `proprietaires` (`id`, `nom`, `telephone`, `adresse`) VALUES
(1, 'Karim Bensalah', '0551234567', 'Rue des Frères Saadi, Béjaïa'),
(2, 'Amina Touati', '0778451230', 'Cité Targa Ouzemmour, Béjaïa'),
(3, 'Hocine Merabet', '0569021144', 'Village Tizi, El Kseur');

-- --------------------------------------------------------

--
-- Table structure for table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_rdv` date NOT NULL,
  `heure_rdv` time NOT NULL,
  `tache` varchar(255) DEFAULT NULL,
  `animalId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_animal_rdv` (`animalId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rendezvous`
--

INSERT INTO `rendezvous` (`id`, `date_rdv`, `heure_rdv`, `tache`, `animalId`) VALUES
(1, '2025-12-05', '10:30:00', '1 - vaccin\r\n2 - consultaion\r\n', 1),
(2, '2025-12-05', '15:00:00', '1 - vaccination\r\n2 - contrôle général\r\n', 2),
(3, '2025-12-06', '09:15:00', '1 - vermifugation\r\n2 - nettoyage des oreilles\r\n3 - coupe des griffes\r\n', 3),
(4, '2025-12-06', '13:45:00', '1 - consultation\r\n2 - analyse de sang\r\n', 4),
(5, '2025-12-07', '11:00:00', '1 - rappel de vaccin\r\n2 - pesée\r\n3 - test parasitaire\r\n', 5),
(6, '2025-12-07', '16:20:00', '1 - contrôle post-opératoire\r\n2 - changement de pansement\r\n', 6);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `adresse` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `sexe`, `adresse`, `email`, `telephone`, `motDePasse`, `type`) VALUES
(1, 'mehdiLKM', 'mehdi', 'Male', 'KJNLN', '@gmail.com', '12345678', 'cherif', ''),
(2, 'mehdi', 'mehdi', 'Male', 'akmwslka', 'oijwo', '0', 'cherif', ''),
(3, 'mehdi', 'mehdi', 'Male', 'asnkj', 'kjks', '0', 'cherif', ''),
(4, 'mehdi', 'mehdi', 'Male', '00000000000000000', 'askjj', '0', 'cherif', ''),
(5, 'mehdi', 'mehdi', 'Female', '0000000', 'akssss', '0', 'cherif', ''),
(12, 'mehdi', 'mehdi', 'Female', 'k.nj;', 'knjk', '0', 'cherif', 'crew'),
(15, 'mehdi', 'mehdi', 'Female', '0000000000', '.,.......', '0', 'cherif', 'docteur'),
(17, 'jhqwik', 'mehdi', 'Male', 'oiwqjoq', 'qwjoqiwj', '0', 'cherif', 'crew');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `animaux`
--
ALTER TABLE `animaux`
  ADD CONSTRAINT `fk_proprietaire` FOREIGN KEY (`proprietaireId`) REFERENCES `proprietaires` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD CONSTRAINT `fk_animal_rdv` FOREIGN KEY (`animalId`) REFERENCES `animaux` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
