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
-- Structure de la table `clinique`
--

CREATE TABLE `clinique` (
  `id` int(11) NOT NULL,
  `nomcl` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adressecl` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numerocl` int(11) NOT NULL,
  `desccl` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `clinique`
--

INSERT INTO `clinique` (`id`, `nomcl`, `adressecl`, `numerocl`, `desccl`) VALUES
(36, '7854455', 'aaaa', 7854455, 'aaa'),
(37, '77777777', 'aaaa', 77777777, 'aaa'),
(39, 'ddd', 'ssss', 12345678, 'dd');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `clinique`
--
ALTER TABLE `clinique`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `clinique`
--
ALTER TABLE `clinique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
