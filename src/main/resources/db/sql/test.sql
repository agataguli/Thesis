-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Gru 2017, 01:39
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `test`
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
('testadmin1', 'testadmin1login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin2', 'testadmin2login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin3', 'testadmin3login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin4', 'testadmin4login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin5', 'testadmin5login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin6', 'testadmin6login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin7', 'testadmin7login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1),
('testadmin8', 'testadmin8login', '[B@74a14482', 'admin', 'testImie', 'testNazwisko', 'test@gmail.com', '000111222', 1);

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
('0', '0', '13'),
('1', '1', '25'),
('10', '0', '9'),
('11', '1', '17'),
('12', '2', '15'),
('13', '3', '13'),
('14', '4', '27'),
('15', '5', '13'),
('16', '6', '20'),
('17', '7', '2'),
('18', '8', '12'),
('19', '9', '16'),
('2', '2', '22'),
('20', '10', '7'),
('21', '11', '22'),
('22', '12', '23'),
('23', '13', '24'),
('24', '14', '12'),
('25', '15', '16'),
('26', '16', '1'),
('27', '17', '19'),
('28', '18', '1'),
('29', '19', '5'),
('3', '3', '12'),
('30', '20', '26'),
('31', '21', '13'),
('32', '22', '15'),
('33', '23', '15'),
('34', '24', '16'),
('35', '25', '17'),
('36', '26', '7'),
('37', '27', '24'),
('38', '28', '19'),
('39', '29', '16'),
('4', '4', '19'),
('40', '30', '22'),
('41', '31', '15'),
('42', '32', '1'),
('43', '33', '10'),
('44', '34', '6'),
('45', '35', '27'),
('46', '36', '8'),
('47', '37', '27'),
('48', '38', '9'),
('49', '39', '15'),
('5', '5', '5'),
('6', '6', '25'),
('7', '7', '17'),
('8', '8', '27'),
('9', '9', '18');

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

--
-- Zrzut danych tabeli `orderitems`
--

INSERT INTO `orderitems` (`orderItemId`, `productId`, `itemGrossValue`, `orderId`) VALUES
('0', '17', 150, '0'),
('1', '18', 150, '1'),
('10', '23', 150, '10'),
('100', '11', 150, '40'),
('101', '10', 150, '41'),
('102', '23', 150, '42'),
('103', '14', 150, '43'),
('104', '5', 150, '44'),
('105', '15', 150, '45'),
('106', '6', 150, '46'),
('107', '4', 150, '47'),
('108', '27', 150, '48'),
('109', '5', 150, '49'),
('11', '26', 150, '11'),
('110', '22', 150, '50'),
('111', '24', 150, '51'),
('112', '8', 150, '52'),
('113', '16', 150, '53'),
('114', '12', 150, '54'),
('115', '13', 150, '55'),
('116', '21', 150, '56'),
('117', '2', 150, '57'),
('118', '15', 150, '58'),
('119', '11', 150, '59'),
('12', '24', 150, '12'),
('120', '22', 150, '60'),
('121', '26', 150, '61'),
('122', '24', 150, '62'),
('123', '2', 150, '63'),
('124', '12', 150, '64'),
('125', '13', 150, '65'),
('126', '18', 150, '66'),
('127', '20', 150, '67'),
('128', '14', 150, '68'),
('129', '7', 150, '69'),
('13', '25', 150, '13'),
('130', '27', 150, '70'),
('131', '27', 150, '71'),
('132', '6', 150, '72'),
('133', '21', 150, '73'),
('134', '20', 150, '74'),
('135', '3', 150, '75'),
('136', '3', 150, '76'),
('137', '9', 150, '77'),
('138', '17', 150, '78'),
('139', '7', 150, '79'),
('14', '11', 150, '14'),
('140', '2', 150, '80'),
('141', '20', 150, '81'),
('142', '17', 150, '82'),
('143', '15', 150, '83'),
('144', '1', 150, '84'),
('145', '5', 150, '85'),
('146', '7', 150, '86'),
('147', '4', 150, '87'),
('148', '15', 150, '88'),
('149', '2', 150, '89'),
('15', '26', 150, '15'),
('150', '24', 150, '90'),
('151', '11', 150, '91'),
('152', '8', 150, '92'),
('153', '16', 150, '93'),
('154', '1', 150, '94'),
('155', '6', 150, '95'),
('156', '21', 150, '96'),
('157', '10', 150, '97'),
('158', '16', 150, '98'),
('159', '1', 150, '99'),
('16', '7', 150, '16'),
('160', '19', 150, '100'),
('161', '6', 150, '101'),
('162', '15', 150, '102'),
('163', '4', 150, '103'),
('164', '16', 150, '104'),
('165', '7', 150, '105'),
('166', '9', 150, '106'),
('167', '14', 150, '107'),
('168', '13', 150, '108'),
('169', '27', 150, '109'),
('17', '15', 150, '17'),
('170', '5', 150, '110'),
('171', '15', 150, '111'),
('172', '23', 150, '112'),
('173', '15', 150, '113'),
('174', '13', 150, '114'),
('175', '4', 150, '115'),
('176', '10', 150, '116'),
('177', '2', 150, '117'),
('178', '9', 150, '118'),
('179', '26', 150, '119'),
('18', '27', 150, '18'),
('180', '12', 150, '60'),
('181', '24', 150, '61'),
('182', '2', 150, '62'),
('183', '5', 150, '63'),
('184', '10', 150, '64'),
('185', '22', 150, '65'),
('186', '5', 150, '66'),
('187', '4', 150, '67'),
('188', '20', 150, '68'),
('189', '13', 150, '69'),
('19', '19', 150, '19'),
('190', '27', 150, '70'),
('191', '19', 150, '71'),
('192', '21', 150, '72'),
('193', '2', 150, '73'),
('194', '21', 150, '74'),
('195', '7', 150, '75'),
('196', '18', 150, '76'),
('197', '18', 150, '77'),
('198', '13', 150, '78'),
('199', '23', 150, '79'),
('2', '27', 150, '2'),
('20', '18', 150, '20'),
('200', '5', 150, '80'),
('201', '3', 150, '81'),
('202', '11', 150, '82'),
('203', '11', 150, '83'),
('204', '24', 150, '84'),
('205', '13', 150, '85'),
('206', '1', 150, '86'),
('207', '25', 150, '87'),
('208', '25', 150, '88'),
('209', '7', 150, '89'),
('21', '5', 150, '21'),
('210', '11', 150, '90'),
('211', '4', 150, '91'),
('212', '1', 150, '92'),
('213', '23', 150, '93'),
('214', '25', 150, '94'),
('215', '3', 150, '95'),
('216', '7', 150, '96'),
('217', '9', 150, '97'),
('218', '12', 150, '98'),
('219', '26', 150, '99'),
('22', '26', 150, '22'),
('220', '2', 150, '100'),
('221', '9', 150, '101'),
('222', '5', 150, '102'),
('223', '1', 150, '103'),
('224', '8', 150, '104'),
('225', '9', 150, '105'),
('226', '20', 150, '106'),
('227', '3', 150, '107'),
('228', '1', 150, '108'),
('229', '10', 150, '109'),
('23', '13', 150, '23'),
('230', '6', 150, '110'),
('231', '18', 150, '111'),
('232', '2', 150, '112'),
('233', '15', 150, '113'),
('234', '23', 150, '114'),
('235', '6', 150, '115'),
('236', '5', 150, '116'),
('237', '26', 150, '117'),
('238', '4', 150, '118'),
('239', '1', 150, '119'),
('24', '27', 150, '24'),
('25', '9', 150, '25'),
('26', '8', 150, '26'),
('27', '19', 150, '27'),
('28', '3', 150, '28'),
('29', '9', 150, '29'),
('3', '21', 150, '3'),
('30', '13', 150, '30'),
('31', '16', 150, '31'),
('32', '27', 150, '32'),
('33', '18', 150, '33'),
('34', '8', 150, '34'),
('35', '19', 150, '35'),
('36', '17', 150, '36'),
('37', '6', 150, '37'),
('38', '12', 150, '38'),
('39', '25', 150, '39'),
('4', '19', 150, '4'),
('40', '12', 150, '40'),
('41', '15', 150, '41'),
('42', '1', 150, '42'),
('43', '22', 150, '43'),
('44', '22', 150, '44'),
('45', '9', 150, '45'),
('46', '11', 150, '46'),
('47', '27', 150, '47'),
('48', '23', 150, '48'),
('49', '24', 150, '49'),
('5', '1', 150, '5'),
('50', '16', 150, '50'),
('51', '14', 150, '51'),
('52', '2', 150, '52'),
('53', '10', 150, '53'),
('54', '3', 150, '54'),
('55', '25', 150, '55'),
('56', '23', 150, '56'),
('57', '2', 150, '57'),
('58', '22', 150, '58'),
('59', '8', 150, '59'),
('6', '4', 150, '6'),
('60', '23', 150, '0'),
('61', '15', 150, '1'),
('62', '4', 150, '2'),
('63', '13', 150, '3'),
('64', '17', 150, '4'),
('65', '20', 150, '5'),
('66', '21', 150, '6'),
('67', '9', 150, '7'),
('68', '11', 150, '8'),
('69', '8', 150, '9'),
('7', '3', 150, '7'),
('70', '12', 150, '10'),
('71', '11', 150, '11'),
('72', '7', 150, '12'),
('73', '10', 150, '13'),
('74', '3', 150, '14'),
('75', '13', 150, '15'),
('76', '15', 150, '16'),
('77', '24', 150, '17'),
('78', '1', 150, '18'),
('79', '24', 150, '19'),
('8', '24', 150, '8'),
('80', '15', 150, '20'),
('81', '3', 150, '21'),
('82', '5', 150, '22'),
('83', '25', 150, '23'),
('84', '14', 150, '24'),
('85', '5', 150, '25'),
('86', '26', 150, '26'),
('87', '15', 150, '27'),
('88', '12', 150, '28'),
('89', '27', 150, '29'),
('9', '8', 150, '9'),
('90', '2', 150, '30'),
('91', '27', 150, '31'),
('92', '15', 150, '32'),
('93', '26', 150, '33'),
('94', '20', 150, '34'),
('95', '13', 150, '35'),
('96', '19', 150, '36'),
('97', '12', 150, '37'),
('98', '17', 150, '38'),
('99', '1', 150, '39');

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

--
-- Zrzut danych tabeli `orders`
--

INSERT INTO `orders` (`orderId`, `userId`, `orderGrossValue`, `status`, `date`) VALUES
('0', '0', '300', 'DONE', '2000-12-24'),
('1', '1', '300', 'DONE', '2000-12-24'),
('10', '10', '300', 'DONE', '2000-12-24'),
('100', '40', '300', 'DONE', '2000-12-24'),
('101', '41', '300', 'DONE', '2000-12-24'),
('102', '42', '300', 'DONE', '2000-12-24'),
('103', '43', '300', 'DONE', '2000-12-24'),
('104', '44', '300', 'DONE', '2000-12-24'),
('105', '45', '300', 'DONE', '2000-12-24'),
('106', '46', '300', 'DONE', '2000-12-24'),
('107', '47', '300', 'DONE', '2000-12-24'),
('108', '48', '300', 'DONE', '2000-12-24'),
('109', '49', '300', 'DONE', '2000-12-24'),
('11', '11', '300', 'DONE', '2000-12-24'),
('110', '50', '300', 'DONE', '2000-12-24'),
('111', '51', '300', 'DONE', '2000-12-24'),
('112', '52', '300', 'DONE', '2000-12-24'),
('113', '53', '300', 'DONE', '2000-12-24'),
('114', '54', '300', 'DONE', '2000-12-24'),
('115', '55', '300', 'DONE', '2000-12-24'),
('116', '56', '300', 'DONE', '2000-12-24'),
('117', '57', '300', 'DONE', '2000-12-24'),
('118', '58', '300', 'DONE', '2000-12-24'),
('119', '59', '300', 'DONE', '2000-12-24'),
('12', '12', '300', 'DONE', '2000-12-24'),
('13', '13', '300', 'DONE', '2000-12-24'),
('14', '14', '300', 'DONE', '2000-12-24'),
('15', '15', '300', 'DONE', '2000-12-24'),
('16', '16', '300', 'DONE', '2000-12-24'),
('17', '17', '300', 'DONE', '2000-12-24'),
('18', '18', '300', 'DONE', '2000-12-24'),
('19', '19', '300', 'DONE', '2000-12-24'),
('2', '2', '300', 'DONE', '2000-12-24'),
('20', '20', '300', 'DONE', '2000-12-24'),
('21', '21', '300', 'DONE', '2000-12-24'),
('22', '22', '300', 'DONE', '2000-12-24'),
('23', '23', '300', 'DONE', '2000-12-24'),
('24', '24', '300', 'DONE', '2000-12-24'),
('25', '25', '300', 'DONE', '2000-12-24'),
('26', '26', '300', 'DONE', '2000-12-24'),
('27', '27', '300', 'DONE', '2000-12-24'),
('28', '28', '300', 'DONE', '2000-12-24'),
('29', '29', '300', 'DONE', '2000-12-24'),
('3', '3', '300', 'DONE', '2000-12-24'),
('30', '30', '300', 'DONE', '2000-12-24'),
('31', '31', '300', 'DONE', '2000-12-24'),
('32', '32', '300', 'DONE', '2000-12-24'),
('33', '33', '300', 'DONE', '2000-12-24'),
('34', '34', '300', 'DONE', '2000-12-24'),
('35', '35', '300', 'DONE', '2000-12-24'),
('36', '36', '300', 'DONE', '2000-12-24'),
('37', '37', '300', 'DONE', '2000-12-24'),
('38', '38', '300', 'DONE', '2000-12-24'),
('39', '39', '300', 'DONE', '2000-12-24'),
('4', '4', '300', 'DONE', '2000-12-24'),
('40', '40', '300', 'DONE', '2000-12-24'),
('41', '41', '300', 'DONE', '2000-12-24'),
('42', '42', '300', 'DONE', '2000-12-24'),
('43', '43', '300', 'DONE', '2000-12-24'),
('44', '44', '300', 'DONE', '2000-12-24'),
('45', '45', '300', 'DONE', '2000-12-24'),
('46', '46', '300', 'DONE', '2000-12-24'),
('47', '47', '300', 'DONE', '2000-12-24'),
('48', '48', '300', 'DONE', '2000-12-24'),
('49', '49', '300', 'DONE', '2000-12-24'),
('5', '5', '300', 'DONE', '2000-12-24'),
('50', '50', '300', 'DONE', '2000-12-24'),
('51', '51', '300', 'DONE', '2000-12-24'),
('52', '52', '300', 'DONE', '2000-12-24'),
('53', '53', '300', 'DONE', '2000-12-24'),
('54', '54', '300', 'DONE', '2000-12-24'),
('55', '55', '300', 'DONE', '2000-12-24'),
('56', '56', '300', 'DONE', '2000-12-24'),
('57', '57', '300', 'DONE', '2000-12-24'),
('58', '58', '300', 'DONE', '2000-12-24'),
('59', '59', '300', 'DONE', '2000-12-24'),
('6', '6', '300', 'DONE', '2000-12-24'),
('60', '0', '300', 'DONE', '2000-12-24'),
('61', '1', '300', 'DONE', '2000-12-24'),
('62', '2', '300', 'DONE', '2000-12-24'),
('63', '3', '300', 'DONE', '2000-12-24'),
('64', '4', '300', 'DONE', '2000-12-24'),
('65', '5', '300', 'DONE', '2000-12-24'),
('66', '6', '300', 'DONE', '2000-12-24'),
('67', '7', '300', 'DONE', '2000-12-24'),
('68', '8', '300', 'DONE', '2000-12-24'),
('69', '9', '300', 'DONE', '2000-12-24'),
('7', '7', '300', 'DONE', '2000-12-24'),
('70', '10', '300', 'DONE', '2000-12-24'),
('71', '11', '300', 'DONE', '2000-12-24'),
('72', '12', '300', 'DONE', '2000-12-24'),
('73', '13', '300', 'DONE', '2000-12-24'),
('74', '14', '300', 'DONE', '2000-12-24'),
('75', '15', '300', 'DONE', '2000-12-24'),
('76', '16', '300', 'DONE', '2000-12-24'),
('77', '17', '300', 'DONE', '2000-12-24'),
('78', '18', '300', 'DONE', '2000-12-24'),
('79', '19', '300', 'DONE', '2000-12-24'),
('8', '8', '300', 'DONE', '2000-12-24'),
('80', '20', '300', 'DONE', '2000-12-24'),
('81', '21', '300', 'DONE', '2000-12-24'),
('82', '22', '300', 'DONE', '2000-12-24'),
('83', '23', '300', 'DONE', '2000-12-24'),
('84', '24', '300', 'DONE', '2000-12-24'),
('85', '25', '300', 'DONE', '2000-12-24'),
('86', '26', '300', 'DONE', '2000-12-24'),
('87', '27', '300', 'DONE', '2000-12-24'),
('88', '28', '300', 'DONE', '2000-12-24'),
('89', '29', '300', 'DONE', '2000-12-24'),
('9', '9', '300', 'DONE', '2000-12-24'),
('90', '30', '300', 'DONE', '2000-12-24'),
('91', '31', '300', 'DONE', '2000-12-24'),
('92', '32', '300', 'DONE', '2000-12-24'),
('93', '33', '300', 'DONE', '2000-12-24'),
('94', '34', '300', 'DONE', '2000-12-24'),
('95', '35', '300', 'DONE', '2000-12-24'),
('96', '36', '300', 'DONE', '2000-12-24'),
('97', '37', '300', 'DONE', '2000-12-24'),
('98', '38', '300', 'DONE', '2000-12-24'),
('99', '39', '300', 'DONE', '2000-12-24');

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
('0', 'Pędzel testowy 0', 'PĘDZLE', 'MARKA4', 99, 110, 'Test 0 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('1', 'Pędzel testowy 1', 'PĘDZLE', 'MARKA2', 144, 160, 'Test 1 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('10', 'Akcesorie testowe 10', 'AKCESORIA', 'MARKA3', 549, 610, 'Test 10 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('11', 'Akcesorie testowe 11', 'AKCESORIA', 'MARKA4', 342, 380, 'Test 11 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('12', 'Akcesorie testowe 12', 'AKCESORIA', 'MARKA1', 378, 420, 'Test 12 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('13', 'Akcesorie testowe 13', 'AKCESORIA', 'MARKA4', 423, 470, 'Test 13 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('14', 'Akcesorie testowe 14', 'AKCESORIA', 'MARKA2', 207, 230, 'Test 14 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('15', 'Akcesorie testowe 15', 'AKCESORIA', 'MARKA3', 459, 510, 'Test 15 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('16', 'Akcesorie testowe 16', 'AKCESORIA', 'MARKA5', 639, 710, 'Test 16 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('17', 'Akcesorie testowe 17', 'AKCESORIA', 'MARKA6', 225, 250, 'Test 17 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('18', 'Akcesorie testowe 18', 'AKCESORIA', 'MARKA4', 639, 710, 'Test 18 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('19', 'Akcesorie testowe 19', 'AKCESORIA', 'MARKA1', 216, 240, 'Test 19 opis AKCESORIUM, ten opis powstał w celach testowych.', 200, 'http://static5.perfumesco.pl/img/388/44021.jpg', 1),
('2', 'Pędzel testowy 2', 'PĘDZLE', 'MARKA4', 396, 440, 'Test 2 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('20', 'Wyposażenie testowe 20', 'WYPOSAŻENIE', 'MARKA5', 585, 650, 'Test 20 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('21', 'Wyposażenie testowe 21', 'WYPOSAŻENIE', 'MARKA4', 495, 550, 'Test 21 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('22', 'Wyposażenie testowe 22', 'WYPOSAŻENIE', 'MARKA5', 747, 830, 'Test 22 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('23', 'Wyposażenie testowe 23', 'WYPOSAŻENIE', 'MARKA1', 801, 890, 'Test 23 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('24', 'Wyposażenie testowe 24', 'WYPOSAŻENIE', 'MARKA1', 396, 440, 'Test 24 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('25', 'Wyposażenie testowe 25', 'WYPOSAŻENIE', 'MARKA5', 1008, 1120, 'Test 25 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('26', 'Wyposażenie testowe 26', 'WYPOSAŻENIE', 'MARKA6', 657, 730, 'Test 26 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('27', 'Wyposażenie testowe 27', 'WYPOSAŻENIE', 'MARKA6', 792, 880, 'Test 27 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('28', 'Wyposażenie testowe 28', 'WYPOSAŻENIE', 'MARKA1', 576, 640, 'Test 28 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('29', 'Wyposażenie testowe 29', 'WYPOSAŻENIE', 'MARKA5', 1017, 1130, 'Test 29 opis WYPOSAŻENIA, ten opis powstał w celach testowych.', 200, 'https://c.allegroimg.com/s512/01844c/bf69dc3e4c109d000911d0d2f08c', 1),
('3', 'Pędzel testowy 3', 'PĘDZLE', 'MARKA5', 405, 450, 'Test 3 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('4', 'Pędzel testowy 4', 'PĘDZLE', 'MARKA5', 234, 260, 'Test 4 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('5', 'Pędzel testowy 5', 'PĘDZLE', 'MARKA3', 450, 500, 'Test 5 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('6', 'Pędzel testowy 6', 'PĘDZLE', 'MARKA1', 288, 320, 'Test 6 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('7', 'Pędzel testowy 7', 'PĘDZLE', 'MARKA4', 126, 140, 'Test 7 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('8', 'Pędzel testowy 8', 'PĘDZLE', 'MARKA5', 279, 310, 'Test 8 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1),
('9', 'Pędzel testowy 9', 'PĘDZLE', 'MARKA3', 468, 520, 'Test 9 opis PĘDZLA, ten opis powstał w celach testowych.', 200, 'https://static2.mintishop.pl/pol_pm_M-Brush-by-Maxineczka-zestaw-7-pedzli-ORIGINAL-10903_3.jpg', 1);

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
('0', 'testuser0', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test0@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('1', 'testuser1', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test1@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('10', 'testuser10', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test10@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('11', 'testuser11', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test11@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('12', 'testuser12', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test12@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('13', 'testuser13', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test13@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('14', 'testuser14', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test14@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('15', 'testuser15', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test15@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('16', 'testuser16', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test16@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('17', 'testuser17', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test17@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('18', 'testuser18', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test18@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('19', 'testuser19', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test19@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('2', 'testuser2', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test2@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('20', 'testuser20', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test20@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('21', 'testuser21', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test21@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('22', 'testuser22', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test22@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('23', 'testuser23', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test23@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('24', 'testuser24', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test24@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('25', 'testuser25', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test25@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('26', 'testuser26', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test26@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('27', 'testuser27', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test27@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('28', 'testuser28', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test28@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('29', 'testuser29', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test29@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('3', 'testuser3', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test3@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('30', 'testuser30', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test30@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('31', 'testuser31', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test31@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('32', 'testuser32', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test32@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('33', 'testuser33', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test33@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('34', 'testuser34', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test34@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('35', 'testuser35', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test35@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('36', 'testuser36', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test36@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('37', 'testuser37', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test37@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('38', 'testuser38', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test38@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('39', 'testuser39', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test39@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('4', 'testuser4', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test4@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('40', 'testuser40', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test40@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('41', 'testuser41', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test41@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('42', 'testuser42', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test42@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('43', 'testuser43', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test43@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('44', 'testuser44', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test44@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('45', 'testuser45', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test45@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('46', 'testuser46', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test46@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('47', 'testuser47', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test47@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('48', 'testuser48', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test48@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('49', 'testuser49', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test49@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('5', 'testuser5', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test5@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('50', 'testuser50', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test50@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('51', 'testuser51', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test51@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('52', 'testuser52', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test52@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('53', 'testuser53', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test53@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('54', 'testuser54', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test54@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('55', 'testuser55', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test55@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('56', 'testuser56', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test56@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('57', 'testuser57', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test57@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('58', 'testuser58', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test58@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('59', 'testuser59', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test59@gmail.com', '123978456', 'Polska', '22-300', 'Nibylandia ', 'Nijaka', '123', 1),
('6', 'testuser6', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test6@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('7', 'testuser7', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test7@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('8', 'testuser8', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test8@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1),
('9', 'testuser9', '337UUpo9A890NgAhjzBFCvAsu8k=', 'TestImie', 'TestNazwisko', 'test9@gmail.com', '123978456', 'Polska', '22-300 ', 'Nibylandia ', 'Nijaka', '123', 1);

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
