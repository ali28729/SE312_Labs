-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2018 at 08:22 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `artifacts`
--

CREATE TABLE `artifacts` (
  `artID` int(11) NOT NULL,
  `artType` varchar(50) NOT NULL,
  `artName` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `genre` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `batchno` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purDon` varchar(50) NOT NULL,
  `available` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artifacts`
--

INSERT INTO `artifacts` (`artID`, `artType`, `artName`, `author`, `date`, `genre`, `price`, `batchno`, `quantity`, `purDon`, `available`) VALUES
(1, 'Book', 'Harry Potter', 'J.K Rowling', '2018-02-08', 'Fantasy', 120, 3, 90, 'Purchased', 'available'),
(2, 'Book', 'Inferno', 'Dan Brown', '2018-02-05', 'Mystery', 100, 1, 10, 'Donated', 'not available'),
(3, 'Journal', 'abc', 'xyz', '2018-02-01', 'Mystery', 10, 1, 10, 'Donated', 'available'),
(4, 'Book', 'Angels and Demons', 'Dan Brown', '2018-02-03', 'Fantasy', 8, 2, 40, 'Purchased', 'available');

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE `issued` (
  `issueID` int(11) NOT NULL,
  `artID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `issueDate` date NOT NULL,
  `returnDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `userEmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `userName`, `userPassword`, `userEmail`) VALUES
(1, 'bisma', 'asdf', 'bisma@gmail.com'),
(2, 'ali', 'sds', 'ali@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artifacts`
--
ALTER TABLE `artifacts`
  ADD PRIMARY KEY (`artID`);

--
-- Indexes for table `issued`
--
ALTER TABLE `issued`
  ADD PRIMARY KEY (`issueID`),
  ADD KEY `artID` (`artID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued`
--
ALTER TABLE `issued`
  ADD CONSTRAINT `issued_ibfk_1` FOREIGN KEY (`artID`) REFERENCES `artifacts` (`artID`),
  ADD CONSTRAINT `issued_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
