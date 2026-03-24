-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: ian. 07, 2026 la 02:53 PM
-- Versiune server: 10.4.32-MariaDB
-- Versiune PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `bancadb`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `bank`
--

CREATE TABLE `bank` (
  `id_bank` bigint(20) NOT NULL,
  `cui_bank` varchar(255) NOT NULL,
  `name_bank` varchar(255) NOT NULL,
  `swift_code_bank` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `bank`
--

INSERT INTO `bank` (`id_bank`, `cui_bank`, `name_bank`, `swift_code_bank`) VALUES
(2, 'RO361579', 'BCR', 'RNCBROBU571'),
(3, 'RO123456', 'Banca Transilvania', 'BTRLRO22'),
(4, 'RO654321', 'BCR', 'RNCBROBU'),
(5, 'RO987654', 'BRD', 'BRDEROBU'),
(6, 'RO112233', 'ING Bank', 'INGBROBU'),
(7, 'RO445566', 'Raiffeisen Bank', 'RZBRROBU'),
(8, 'RO778899', 'CEC Bank', 'CECO ROBU'),
(9, 'RO223344', 'UniCredit Bank', 'BACXROBU'),
(10, 'RO556677', 'Alpha Bank', 'ALBZROBU'),
(11, 'RO889900', 'Libra Internet Bank', 'BRELROBU'),
(12, 'RO001122', 'Garanti BBVA', 'GBBAROBU');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `branches`
--

CREATE TABLE `branches` (
  `id_branch` bigint(20) NOT NULL,
  `address_branch` varchar(255) NOT NULL,
  `city_branch` varchar(255) NOT NULL,
  `name_branch` varchar(255) NOT NULL,
  `phone_branch` varchar(255) NOT NULL,
  `bank_branch` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `branches`
--

INSERT INTO `branches` (`id_branch`, `address_branch`, `city_branch`, `name_branch`, `phone_branch`, `bank_branch`) VALUES
(2, 'Str.Zorelelor 1', 'Magurele', 'Baza centrala', '0721071633', 2),
(4, 'Bd. Regina Elisabeta 5', 'Bucuresti', 'BCR Universitate', '0722222222', 2),
(5, 'Piata Victoriei 1', 'Timisoara', 'BRD Tower', '0722333333', 3),
(6, 'Str. Sfatului 10', 'Brasov', 'ING Office Center', '0722444444', 4),
(7, 'Bd. Unirii 20', 'Iasi', 'Raiffeisen Copou', '0722555555', 5),
(8, 'Calea Victoriei 150', 'Bucuresti', 'CEC Agentia Victoria', '0722666666', 6),
(9, 'Str. Republicii 4', 'Constanta', 'UniCredit Port', '0722777777', 7),
(10, 'Bd. Decebal 8', 'Oradea', 'Alpha Bank Centru', '0722888888', 8),
(11, 'Str. Lunga 30', 'Sibiu', 'Libra Sibiu', '0722999999', 9);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `employees`
--

CREATE TABLE `employees` (
  `id_employee` bigint(20) NOT NULL,
  `cnp_employee` varchar(255) NOT NULL,
  `employment_date` date NOT NULL,
  `fname_employee` varchar(255) NOT NULL,
  `lname_employee` varchar(255) NOT NULL,
  `position_employee` varchar(255) NOT NULL,
  `salary_employee` decimal(15,2) NOT NULL,
  `bank_employee` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `employees`
--

INSERT INTO `employees` (`id_employee`, `cnp_employee`, `employment_date`, `fname_employee`, `lname_employee`, `position_employee`, `salary_employee`, `bank_employee`) VALUES
(4, '2900505654321', '2021-06-20', 'Maria', 'Ionescu', 'Ofiter Credite', 4500.00, 2),
(5, '1950808112233', '2019-11-01', 'George', 'Dumitru', 'Casier', 3200.00, 3),
(6, '2881212445566', '2022-01-10', 'Elena', 'Stoica', 'Consultant Clienti', 4100.00, 4),
(7, '1920404778899', '2018-09-05', 'Ionut', 'Radu', 'Analist Financiar', 6000.00, 5),
(8, '2930707990011', '2023-02-14', 'Ana', 'Mihai', 'Manager Relatii', 5200.00, 6),
(9, '1851010223344', '2021-11-30', 'Alexandru', 'Stan', 'IT Support', 4800.00, 7),
(10, '2960303556677', '2020-08-22', 'Cristina', 'Gheorghe', 'Casier', 3300.00, 8),
(11, '1910606889900', '2019-04-12', 'Mihai', 'Dobre', 'Ofiter Credite', 4600.00, 9);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id_bank`);

--
-- Indexuri pentru tabele `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`id_branch`),
  ADD KEY `FKm2iallkhb827jojtjyh5y067g` (`bank_branch`);

--
-- Indexuri pentru tabele `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id_employee`),
  ADD KEY `FK3c8j7e25sdq5gcdsafk6q6y7d` (`bank_employee`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `bank`
--
ALTER TABLE `bank`
  MODIFY `id_bank` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pentru tabele `branches`
--
ALTER TABLE `branches`
  MODIFY `id_branch` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pentru tabele `employees`
--
ALTER TABLE `employees`
  MODIFY `id_employee` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `branches`
--
ALTER TABLE `branches`
  ADD CONSTRAINT `FKm2iallkhb827jojtjyh5y067g` FOREIGN KEY (`bank_branch`) REFERENCES `bank` (`id_bank`);

--
-- Constrângeri pentru tabele `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `FK3c8j7e25sdq5gcdsafk6q6y7d` FOREIGN KEY (`bank_employee`) REFERENCES `bank` (`id_bank`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
