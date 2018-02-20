-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2018 at 08:33 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
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
(1, 'Book', 'Harry Potter', 'J.K Rowling', '2018-02-08', 'Fantasy', 120, 3, 90, 'Purchased', 'not available'),
(2, 'Book', 'Inferno', 'Dan Brown', '2018-02-05', 'Mystery', 100, 1, 10, 'Donated', 'not available'),
(3, 'Journal', 'abc', 'xyz', '2018-02-01', 'Science', 10, 1, 10, 'Donated', 'not available'),
(4, 'Book', 'Angels and Demons', 'Dan Brown', '2018-02-03', 'Fantasy', 8, 2, 40, 'Purchased', 'not available'),
(5, 'Book', 'Mocking Bird', 'Bird', '2018-02-03', 'Mystery', 90, 5, 50, 'Donated', 'not available'),
(6, 'Journal', 'TOCS', 'ACM', '1998-02-03', 'Computing', 900, 15, 5, 'Purchased', 'not available'),
(7, 'Journal', 'Blob', 'IEEE', '1999-02-03', 'Computing', 500, 5, 10, 'Purchased', 'not available'),
(8, 'Book', 'The Great Game', 'blob', '2013-02-01', 'History', 200, 3, 24, 'Purchased', 'not available'),
(9, 'Book', 'Justice', 'blob', '2018-02-01', 'History', 139, 2, 10, 'Purchased', 'not available'),
(10, 'Book', 'The Alchemist', 'Paulo Coelho', '1988-01-01', 'Fantasy', 196, 7, 37, 'Donated', 'not available');

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE `issued` (
  `issueID` int(11) UNSIGNED NOT NULL,
  `artID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `issueDate` date NOT NULL,
  `returnDate` date NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issued`
--

INSERT INTO `issued` (`issueID`, `artID`, `userID`, `issueDate`, `returnDate`, `fine`) VALUES
(7, 1, 2, '2018-02-21', '2018-03-21', 0),
(8, 4, 2, '2018-02-21', '2018-03-21', 0),
(9, 3, 2, '2018-02-21', '2018-03-08', 0),
(10, 2, 2, '2018-02-21', '2018-03-21', 0),
(11, 6, 2, '2018-02-21', '2018-03-08', 0),
(12, 7, 2, '2018-02-21', '2018-03-08', 0),
(13, 5, 2, '2018-02-21', '2018-03-21', 0),
(14, 8, 1, '2018-02-21', '2018-03-21', 0),
(15, 9, 1, '2018-02-21', '2018-03-21', 0),
(16, 10, 1, '2018-02-21', '2018-03-21', 0);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issued`
--
ALTER TABLE `issued`
  MODIFY `issueID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `issued`
--
ALTER TABLE `issued`
  ADD CONSTRAINT `issued_ibfk_1` FOREIGN KEY (`artID`) REFERENCES `artifacts` (`artID`),
  ADD CONSTRAINT `issued_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
