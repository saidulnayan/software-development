-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2022 at 12:15 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `model`
--

-- --------------------------------------------------------

--
-- Table structure for table `incometable`
--

CREATE TABLE `incometable` (
  `order_id` int(11) NOT NULL,
  `received_amount` float NOT NULL,
  `change_amount` float NOT NULL,
  `total_amount` float NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `incometable`
--

INSERT INTO `incometable` (`order_id`, `received_amount`, `change_amount`, `total_amount`, `order_date`) VALUES
(1, 50, 5, 45, '2022-01-02 17:09:21'),
(2, 30, 0, 30, '2022-01-02 17:09:21'),
(3, 30, 0, 30, '2022-01-03 10:50:49'),
(4, 20, 5, 15, '2022-01-03 10:59:52'),
(5, 50, 5, 45, '2022-01-03 13:25:37'),
(6, 60, 0, 60, '2022-01-03 14:09:46'),
(7, 60, 0, 60, '2022-01-03 14:15:59'),
(8, 20, 5, 15, '2022-01-03 14:17:00'),
(9, 20, 5, 15, '2022-01-03 14:17:27'),
(10, 100, 25, 75, '2022-01-03 14:18:14'),
(11, 20, 5, 15, '2022-01-03 14:37:10'),
(12, 123, 3, 120, '2022-01-03 14:37:45'),
(13, 50, 5, 45, '2022-01-03 15:00:22'),
(14, 30, 0, 30, '2022-01-03 15:02:45'),
(15, 20, 5, 15, '2022-01-03 15:18:01'),
(16, 120, 15, 105, '2022-01-03 15:32:15'),
(17, 200, 5, 195, '2022-01-09 11:15:00'),
(18, 500, 380, 120, '2022-01-09 11:16:58');

-- --------------------------------------------------------

--
-- Table structure for table `logintable`
--

CREATE TABLE `logintable` (
  `id` int(18) NOT NULL,
  `username` text NOT NULL,
  `password` int(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logintable`
--

INSERT INTO `logintable` (`id`, `username`, `password`) VALUES
(1, 'nayan', 123);

-- --------------------------------------------------------

--
-- Table structure for table `producttable`
--

CREATE TABLE `producttable` (
  `product_id` int(15) NOT NULL,
  `product_img` varchar(255) NOT NULL,
  `product_name` varchar(122) NOT NULL,
  `about` varchar(122) NOT NULL,
  `unit_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producttable`
--

INSERT INTO `producttable` (`product_id`, `product_img`, `product_name`, `about`, `unit_price`) VALUES
(11, '', 'CocaCola', 'Drinks', 25),
(12, '', 'Pepsi', 'Drinks', 20),
(13, '', 'lolipop', 'Sweets', 5),
(14, '', 'Polar Cone ', 'Ice Cream', 35),
(15, '', 'Fruit Cake', 'Snacks', 50),
(16, '', 'Pops Biscute', 'Snacks', 10),
(17, '', 'Vegetable Roll', 'Fast Food', 25),
(18, '', 'Somusa', 'Fast Food', 6),
(19, '', 'Chicken Burger', 'Fast Food', 40);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `incometable`
--
ALTER TABLE `incometable`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `logintable`
--
ALTER TABLE `logintable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `producttable`
--
ALTER TABLE `producttable`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `incometable`
--
ALTER TABLE `incometable`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `logintable`
--
ALTER TABLE `logintable`
  MODIFY `id` int(18) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `producttable`
--
ALTER TABLE `producttable`
  MODIFY `product_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
