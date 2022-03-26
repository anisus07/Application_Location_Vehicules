-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 21 Octobre 2020 à 00:31
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `location`
--

-- --------------------------------------------------------

--
-- Structure de la table `archive`
--

CREATE TABLE IF NOT EXISTS `archive` (
  `personne` int(10) NOT NULL,
  `voiture` varchar(13) NOT NULL,
  `datedeb` varchar(15) NOT NULL,
  `datefin` varchar(15) NOT NULL,
  `versement` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `archive`
--

INSERT INTO `archive` (`personne`, `voiture`, `datedeb`, `datefin`, `versement`) VALUES
(14789657, '15478-116-06', '16-10-2020', '17-10-2020', '3500'),
(14789657, '15478-116-06', '14-11-2020', '14-12-2020', '3500');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `numpermis` int(15) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `datenaiss` varchar(15) NOT NULL,
  `adresse` varchar(25) NOT NULL,
  `numtel` int(12) NOT NULL,
  PRIMARY KEY (`numpermis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`numpermis`, `nom`, `prenom`, `datenaiss`, `adresse`, `numtel`) VALUES
(14789657, 'Mehidi', 'Anis', '15-08-1998', 'Amizour', 655118678);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `personne` int(15) NOT NULL,
  `voiture` varchar(13) NOT NULL,
  `datedeb` varchar(15) NOT NULL,
  `datefin` varchar(15) NOT NULL,
  `versement` varchar(4) NOT NULL,
  KEY `personne` (`personne`),
  KEY `voiture` (`voiture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_user`, `user`, `password`) VALUES
(1, 'anis', 'anisus'),
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `matricule` varchar(13) NOT NULL,
  `marque` varchar(15) NOT NULL,
  `modele` varchar(15) NOT NULL,
  `couleur` varchar(15) NOT NULL,
  `prix` varchar(4) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`matricule`, `marque`, `modele`, `couleur`, `prix`) VALUES
('15478-116-06', 'Renault', 'Symbole', 'Blanche', '3500'),
('15479-116-06', 'Renault', 'Symbole', 'Grise', '3500'),
('17895-119-06', 'Dacia', 'Logan', 'Blanche', '3500');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`personne`) REFERENCES `client` (`numpermis`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`voiture`) REFERENCES `vehicule` (`matricule`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
