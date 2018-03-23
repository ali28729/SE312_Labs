-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2018 at 03:44 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(11) NOT NULL,
  `RegNo` int(55) NOT NULL,
  `Name` varchar(55) NOT NULL,
  `Class` varchar(55) NOT NULL,
  `Section` varchar(55) NOT NULL,
  `Contact` varchar(55) NOT NULL,
  `Address` varchar(55) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `RegNo`, `Name`, `Class`, `Section`, `Contact`, `Address`) VALUES
(1, 128469, 'Muhammad Ali', 'BESE-6', 'B', '9232144000', 'Islamabad'),
(2, 130536, 'Hammad Rashid', 'BEE-7', 'A', '9232144123', 'Ghazali'),
(3, 128564, 'hammad Hassan', 'BSCS-5', 'C', '9232144458', 'Rawalpindi'),
(5, 128752, 'Umar Khan', 'BESE-6', 'B', '9232144454', 'Askari 14'),
(4, 124691, 'Sohaib Zahid', 'BESE-5', 'B', '9232144000', 'G-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
