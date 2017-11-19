-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Lis 2017, 23:31
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `makemeup`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admins`
--

CREATE TABLE `admins` (
  `adminId` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `permissionStatus` varchar(24) NOT NULL,
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(64) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `admins`
--

INSERT INTO `admins` (`adminId`, `login`, `password`, `permissionStatus`, `name`, `surname`, `email`, `phoneNumber`, `active`) VALUES
('adminagata', 'adminagata', '[B@74a14482', 'admin', 'Agata', 'Kołtun', 'agataguli@gmail.com', '737409946', 1),
('adminewelina', 'adminewelina', '[B@74a14482', 'admin', 'Ewelina', 'Mysiak', 'ewelinamysiak@jakasdomena.com', '123123123', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cartitems`
--

CREATE TABLE `cartitems` (
  `cartItemId` varchar(24) NOT NULL,
  `totalMultipliedItemGrossValue` double NOT NULL,
  `productId` varchar(24) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `carts`
--

CREATE TABLE `carts` (
  `cartId` varchar(24) NOT NULL,
  `totalCartItemsGrossValue` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `products`
--

CREATE TABLE `products` (
  `productId` varchar(24) NOT NULL,
  `name` varchar(64) NOT NULL,
  `category` varchar(64) NOT NULL,
  `brand` varchar(64) NOT NULL,
  `grossValue` double NOT NULL,
  `netValue` double NOT NULL,
  `description` varchar(256) NOT NULL,
  `quantity` int(255) NOT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `products`
--

INSERT INTO `products` (`productId`, `name`, `category`, `brand`, `grossValue`, `netValue`, `description`, `quantity`, `available`) VALUES
('90010174011', 'MAXINECZKA FOUNDATION BRUSH M01X', 'BRUSHES', 'MAXINECZKA', 99.99, 76.99, 'Innovative product made in Japan. The hair comes from a goat kept on a free run. Hair brushed, not clotted. Brush base is gold-plated.', 100, 0),
('90010173119', 'M Brush by Maxineczka make-up brush 17', 'BRUSHES', 'MAXINECZKA', 79.99, 50, 'Natural goat hair with Italian synthetic blend.\r\nGold plated 24K gold plated.\r\n\r\nPrecise pointed brush for applying and grinding shadows on the eyelid. Ideally made to concentrate in a specific place.', 200, 1),
('90010137715', 'LED light bulb in dimensions of 90 cm x 90cm', 'FURNISHINGS', 'IKEA', 256.5, 200, 'Mirror with 12 energy-saving LED bulbs for make-up artists. Included is a preparation for cleaning and spare bulb.', 20, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `userId` varchar(24) NOT NULL,
  `login` varchar(24) NOT NULL,
  `password` varchar(256) NOT NULL,
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(24) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `country` varchar(24) NOT NULL,
  `postCode` varchar(24) NOT NULL,
  `city` varchar(64) NOT NULL,
  `street` varchar(64) NOT NULL,
  `addressDetails` varchar(256) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`adminId`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Indexes for table `cartitems`
--
ALTER TABLE `cartitems`
  ADD PRIMARY KEY (`cartItemId`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`cartId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
