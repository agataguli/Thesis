-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Gru 2017, 00:13
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `empty`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admins`
--

CREATE TABLE `admins` (
  `adminId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `permissionStatus` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `phoneNumber` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `favorites`
--

CREATE TABLE `favorites` (
  `favoriteId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `userId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `productId` varchar(64) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orderitems`
--

CREATE TABLE `orderitems` (
  `orderItemId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `productId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `itemGrossValue` double NOT NULL,
  `orderId` varchar(64) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orders`
--

CREATE TABLE `orders` (
  `orderId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `userId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `orderGrossValue` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `status` varchar(16) COLLATE utf8_polish_ci NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `products`
--

CREATE TABLE `products` (
  `productId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `category` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `brand` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `grossValue` double NOT NULL,
  `netValue` double NOT NULL,
  `description` varchar(256) COLLATE utf8_polish_ci NOT NULL,
  `quantity` int(255) NOT NULL,
  `imageLink` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `userId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `phoneNumber` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `country` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `postCode` varchar(8) COLLATE utf8_polish_ci NOT NULL,
  `city` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `street` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `addressDetails` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

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
-- Indexes for table `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`favoriteId`),
  ADD KEY `FK_fav_prod` (`productId`),
  ADD KEY `FK_fav_user` (`userId`);

--
-- Indexes for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD PRIMARY KEY (`orderItemId`),
  ADD KEY `FK_oi_order` (`orderId`),
  ADD KEY `FK_oi_prod` (`productId`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderId`),
  ADD KEY `FK_order_user` (`userId`);

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

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `FK_fav_prod` FOREIGN KEY (`productId`) REFERENCES `products` (`productId`),
  ADD CONSTRAINT `FK_fav_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`);

--
-- Ograniczenia dla tabeli `orderitems`
--
ALTER TABLE `orderitems`
  ADD CONSTRAINT `FK_oi_order` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  ADD CONSTRAINT `FK_oi_prod` FOREIGN KEY (`productId`) REFERENCES `products` (`productId`);

--
-- Ograniczenia dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_order_user` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
