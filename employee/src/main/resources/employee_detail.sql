-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 27, 2020 at 07:42 AM
-- Server version: 5.7.28
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee_detail`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'IT'),
(2, 'SECURITY');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact_number` int(10) NOT NULL,
  `family_details` varchar(100) NOT NULL,
  `department_id` int(5) NOT NULL,
  `supervisor_id` int(5) NOT NULL,
  `salary_scale_id` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `address`, `contact_number`, `family_details`, `department_id`, `supervisor_id`, `salary_scale_id`) VALUES
(1, 'Saman Kumar', 'saman.k@123.com', 'No.123,Baththaramulla,Colombo', 714455432, 'Have two children. Mother and father are both teachers.', 2, 2, 1),
(2, 'Supun Jayathilake', 'supun.k@123.com', 'No.54,Kollupitiya,Colombo', 713344512, 'Have one child. Mother is a teacher and father is a politician.', 2, 2, 1),
(3, 'NimalKumar', 'nimal.k@123.com', 'No.1253,Baththaramulla,Colombo', 716655432, 'Have three children. Mother and father are both farmers.', 1, 2, 1),
(4, 'NihalKumar', 'nihal.k@123.com', 'No.123,Pannipitiya,Colombo', 714455432, 'Have no married. Mother and father are both doctors.', 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `salary_scale`
--

DROP TABLE IF EXISTS `salary_scale`;
CREATE TABLE IF NOT EXISTS `salary_scale` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `scale_type` varchar(50) NOT NULL,
  `scale_range` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_scale`
--

INSERT INTO `salary_scale` (`id`, `scale_type`, `scale_range`) VALUES
(1, 'Cleaning', '15,000-20,000'),
(2, 'Repairing', '25,000-35,000'),
(3, 'Administration-first', '55,000-70,000'),
(4, 'Receptionist', '25,000-30,000'),
(5, 'Security', '35,000-45,000'),
(6, 'Store Keeping', '35,000-40,000'),
(7, 'Administration-second', '45,000-60,000');

-- --------------------------------------------------------

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE IF NOT EXISTS `supervisor` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `contact_number` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supervisor`
--

INSERT INTO `supervisor` (`id`, `name`, `email`, `contact_number`) VALUES
(1, 'Sunil Kumar', 'sunil@123.com', 718811934),
(2, 'Bimal Dhanushka', 'bimal@123.com', 716677543),
(5, 'Sunil Perera', 'sunilP@123.com', 751234322);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
