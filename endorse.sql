-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 10:48 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbdataendorse`
--

-- --------------------------------------------------------

--
-- Table structure for table `endorse`
--

CREATE TABLE `endorse` (
  `no_endorse` int(11) NOT NULL,
  `nama_brand` varchar(155) NOT NULL,
  `nama_barang` varchar(155) NOT NULL,
  `jenis_barang` varchar(155) NOT NULL,
  `jenis_endorse` varchar(155) NOT NULL,
  `banyak_post` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `endorse`
--

INSERT INTO `endorse` (`no_endorse`, `nama_brand`, `nama_barang`, `jenis_barang`, `jenis_endorse`, `banyak_post`, `total_harga`) VALUES
(1, 'Glad2Glow', 'Serum', 'Skincare', 'Video Story', 2, 300000),
(3, 'Kraft', 'Keju', 'Food', 'Foto Story', 2, 200000),
(4, 'Eiger', 'Tas', 'Fashion', 'Video Feed', 3, 900000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
