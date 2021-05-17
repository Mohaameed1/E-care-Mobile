-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 15 mai 2021 à 01:46
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `final3`
--

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `clinique_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `adresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `clinique_id`, `name`, `email`, `phone`, `adresse`) VALUES
(13, 5, 'maffjd', 'majd', 444, 'majd'),
(14, 4, '\"majd\"', '\"majd\"', 444, '\"majd\"'),
(15, 0, '\"majd\"', '\"majd\"', 444, '\"kef\"'),
(16, 0, 'majd', 'majd', 444, 'kef'),
(17, 54, '\"majd\"', '\"majd\"', 444, '\"kef\"'),
(18, 55, 'zzzzzz', 'zzzzzzzzz', 12345678, 'ddd'),
(19, 11, 'ssss', 'ssss', 12345678, 'dddd'),
(20, 14, 'ss', 'ss', 123, 'dd'),
(21, 14, 'dd', 'ddd', 1111, 'ddd'),
(22, 5, '\"majd\"', '\"majd\"', 444, '\"majd\"'),
(23, 4, 'sss', 's', 12345678, 'ddd'),
(24, 4, 'sss', 's', 12345678, 'ddd'),
(25, 55, 'sss', 's', 12345678, 'ssss'),
(26, 44, 'ssss', 'lllllllll', 12345678, 'ddd'),
(27, 44, 'ssss', 'lllllllll', 12345678, 'ddd'),
(28, 44, 'dfdf', 'dddd', 12345678, 'dddd'),
(29, 555, 'sss', 'ssss', 12345678, 'ddd'),
(30, 7, 'ss', 'ss', 12345678, 'ss');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
