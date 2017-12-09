-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Gru 2017, 01:24
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
  `permissionStatus` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `phoneNumber` varchar(12) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `admins`
--

INSERT INTO `admins` (`adminId`, `login`, `password`, `permissionStatus`, `name`, `surname`, `email`, `phoneNumber`, `active`) VALUES
('adminagata', 'adminagata', '[B@74a14482', 'admin', 'Agata', 'Kołtun', 'agataguli@gmail.com', '737409946', 1),
('adminewelina', 'adminewelina', '[B@74a14482', 'admin', 'Ewelina', 'Mysiak', 'ewelinamysiak@jakasdomena.com', '123123123', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `products`
--

CREATE TABLE `products` (
  `productId` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `category` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `brand` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `grossValue` double NOT NULL,
  `netValue` double NOT NULL,
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `quantity` int(255) NOT NULL,
  `imageLink` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `products`
--

INSERT INTO `products` (`productId`, `name`, `category`, `brand`, `grossValue`, `netValue`, `description`, `quantity`, `imageLink`, `available`) VALUES
('90010174011', 'MAXINECZKA FOUNDATION BRUSH M01X', 'BRUSHES', 'MAXINECZKA', 99.99, 76.99, 'Pędzel promowany przez najsłynniejszą polską makijażystkę, gwiazdę Youtube\'a Maxineczkę. Pędzel przeznaczony jest do aplikacji podkładu. Jest wykonany z naturalnego włosia - włosia czesanego z japońskiej kozy.', 9, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('90010173119', 'Jeffree Stare Mirror Check', 'ATTRIBUTES', 'JSTARR', 139.99, 100, 'Oficjalne pozłacane 24K złotem lusterko podręczne z kolekcji Better than Sex w wykonaniu Jeffre Starr, gwiazdy amerykańskiego youtube makijażowego! ', 12, 'http://static5.perfumesco.pl/img/388/44021.jpg', 0),
('90010137715', 'Podświetlane lustro wizażysty, 90x90cm', 'WYPOSAŻENIE', 'IKEA', 256.5, 200, 'Lustro z 12 żarówkami LED. Zapewnia wysoki komfort pracy każdemu wizażyście. ', 40, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `userId` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(32) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `phoneNumber` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `country` varchar(32) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `postCode` varchar(8) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `street` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `addressDetails` varchar(24) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`userId`, `login`, `password`, `name`, `surname`, `email`, `phoneNumber`, `country`, `postCode`, `city`, `street`, `addressDetails`, `active`) VALUES
('12345678910', 'Testuser', '337UUpo9A890NgAhjzBFCvAsu8k=', 'Testuser', 'Testuser', 'test@gmail.com', '123456789', 'Polska', '22-300 ', 'Test', 'Test', '23', 1);

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
