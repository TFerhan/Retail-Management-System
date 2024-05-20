-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : database-container
-- Généré le : sam. 18 mai 2024 à 00:41
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `inventory_management_system`
--

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id`, `Name`, `PhoneNumber`, `address`, `prenom`) VALUES
(45, '', '', '', ''),
(42, 'dal', '0144', 'kkkk', 'ff'),
(32, 'gamijo7', '014521', 'fvjfvj', 'fjfivf'),
(39, 'kkk', '111', 'kk', 'kkk'),
(35, 'ffff', '1145412', 'ffvf', 'fffj4'),
(44, 'fjfkj', '1201', 'klkll', 'jhhj'),
(38, 'fgf', '1250', 'cffv', 'fbf'),
(43, 'ffb', '145', 'ghghg', 'fb'),
(41, 'hjhj', '15121', 'jhjhj', 'jjkkj'),
(36, 'jjnj', '4847', 'gjhjhj', 'njnj'),
(40, 'ujhj', '555', 'jkkk', 'hjh'),
(37, 'badr', '55555555', 'xdfdcffdd', 'bo');

--
-- Déchargement des données de la table `factures`
--

INSERT INTO `factures` (`id`, `inv_num`, `cust_id`, `price`, `quantity`, `total_amount`, `date`, `item_number`) VALUES
(42, 'FAC-1', 35, 150.00, 5, 850.00, '2024-05-16', '15'),
(43, 'FAC-1', 35, 150.00, 4, 700.00, '2024-05-16', '15'),
(44, 'FAC-1', 35, 150.00, 40, 6100.00, '2024-05-16', '15'),
(45, 'FAC-1', 35, 112.00, 7, 884.00, '2024-05-16', '15'),
(46, 'FAC-2', 36, 120.00, 5, 700.00, '2024-05-16', '15'),
(47, 'FAC-3', 37, 1555.00, 6, 9430.00, '2024-05-16', '15'),
(48, 'FAC-3', 37, 45.00, 3, 235.00, '2024-05-16', '15'),
(49, 'FAC-4', 38, 150.00, 5, 850.00, '2024-05-16', '15'),
(50, 'FAC-4', 38, 150.00, 4, 700.00, '2024-05-16', '15'),
(51, 'FAC-5', 39, 100.00, 8, 900.00, '2024-05-16', '15'),
(52, 'FAC-5', 39, 1541.00, 6, 9346.00, '2024-05-16', '15'),
(53, 'FAC-5', 40, 150.00, 5, 850.00, '2024-05-16', '15'),
(54, 'FAC-6', 41, 145.00, 3, 535.00, '2024-05-16', '15'),
(55, 'FAC-7', 42, 152.00, 5, 860.00, '2024-05-17', '15'),
(56, 'FAC-8', 43, 150.00, 3, 550.00, '2024-05-17', 'gami'),
(57, 'FAC-8', 43, 150.00, 2, 400.00, '2024-05-17', 'gami'),
(58, 'FAC-8', 43, 140.00, 4, 660.00, '2024-05-17', 'gami'),
(59, 'FAC-9', 44, 120.00, 3, 460.00, '2024-05-17', 'gami'),
(60, 'FAC-9', 44, 150.00, 7, 1150.00, '2024-05-17', '15');

--
-- Déchargement des données de la table `inv_seq`
--

INSERT INTO `inv_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(3001, 1, 99999999999999, 1, 1, 1000, 0, 0);

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`numeroliv`, `dateliv`, `num_facture`) VALUES
(2, '2024-05-18', 'FAC-5'),
(5, '2024-05-18', 'FAC-6'),
(6, '2024-05-19', 'FAC-7'),
(7, '2024-05-08', 'FAC-8'),
(8, '2024-05-19', 'FAC-9');

--
-- Déchargement des données de la table `products`
--

INSERT INTO `products` (`id`, `quantity`, `price`, `nom`) VALUES
(15, 15, 120.00, 'gami454');

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
