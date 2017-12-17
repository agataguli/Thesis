-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 17 Gru 2017, 14:59
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `test3`
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

--
-- Zrzut danych tabeli `admins`
--

INSERT INTO `admins` (`adminId`, `login`, `password`, `permissionStatus`, `name`, `surname`, `email`, `phoneNumber`, `active`) VALUES
('adminagata', 'adminagata', '[B@74a14482', 'admin', 'Agata', 'Kołtun', 'agataguli@gmail.com', '737409946', 1),
('adminewelina', 'adminewelina', '[B@74a14482', 'admin', 'Ewelina', 'Mysiak', 'ewelinamysiak@jakasdomena.com', '123123123', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `favorites`
--

CREATE TABLE `favorites` (
  `favoriteId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `userId` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `productId` varchar(64) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `favorites`
--

INSERT INTO `favorites` (`favoriteId`, `userId`, `productId`) VALUES
('1', '9a5face3-69f9-4f76-b4bf-fbadca5babea', '90010137715');

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

--
-- Zrzut danych tabeli `products`
--

INSERT INTO `products` (`productId`, `name`, `category`, `brand`, `grossValue`, `netValue`, `description`, `quantity`, `imageLink`, `available`) VALUES
('90010137715', 'Podświetlane lustro wizażysty, 90x90cm', 'WYPOSAŻENIE', 'IKEA', 256.5, 200, 'Lustro z 12 żarówkami LED. Zapewnia wysoki komfort pracy każdemu wizażyście. ', 40, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 0),
('90010173119', 'Jeffree Stare Mirror Check', 'ATTRIBUTES', 'JSTARR', 139.99, 100, 'Oficjalne pozłacane 24K złotem lusterko podręczne z kolekcji Better than Sex w wykonaniu Jeffre Starr, gwiazdy amerykańskiego youtube makijażowego! ', 12, 'http://static5.perfumesco.pl/img/388/44021.jpg', 0),
('90010174011', 'MAXINECZKA FOUNDATION BRUSH M01X', 'BRUSHES', 'MAXINECZKA', 99.99, 76.99, 'Pędzel promowany przez najsłynniejszą polską makijażystkę, gwiazdę Youtube\'a Maxineczkę. Pędzel przeznaczony jest do aplikacji podkładu. Jest wykonany z naturalnego włosia - włosia czesanego z japońskiej kozy.', 9, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1);

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
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`userId`, `login`, `password`, `name`, `surname`, `email`, `phoneNumber`, `country`, `postCode`, `city`, `street`, `addressDetails`, `active`) VALUES
('8b00fc65-0ec3-47f8-9d30-e4d68f8cedb9', 'agatauser', '337UUpo9A890NgAhjzBFCvAsu8k=', 'Agata', 'Kołtun', 'agataguli@gmail.com', '123978456', 'Polska', '22-300 ', 'Krasnystaw ', 'Nijaka', '123', 1),
('9a5face3-69f9-4f76-b4bf-fbadca5babea', 'testuser', '337UUpo9A890NgAhjzBFCvAsu8k=', 'Test', 'Test', 'tests@gmaill.com', '123456789', 'Polska', '22-300 ', 'Krasnystaw ', 'Testowa', '123', 1);

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
