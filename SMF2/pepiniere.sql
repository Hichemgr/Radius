-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 27 mars 2019 à 17:30
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pepiniere`
--

-- --------------------------------------------------------

--
-- Structure de la table `assisstance`
--

DROP TABLE IF EXISTS `assisstance`;
CREATE TABLE IF NOT EXISTS `assisstance` (
  `id_assisstance` int(11) NOT NULL,
  `id_client` varchar(20) NOT NULL,
  `id_assisstant` varchar(20) NOT NULL,
  `dateAss` date NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `assisstance`
--

INSERT INTO `assisstance` (`id_assisstance`, `id_client`, `id_assisstant`, `dateAss`, `type`) VALUES
(2, 'hichem gri', 'anas abdelkefi', '2019-03-22', 'Autre');

-- --------------------------------------------------------

--
-- Structure de la table `assisstant`
--

DROP TABLE IF EXISTS `assisstant`;
CREATE TABLE IF NOT EXISTS `assisstant` (
  `id_assisstant` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cin` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL,
  PRIMARY KEY (`id_assisstant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE IF NOT EXISTS `catalogue` (
  `idcatalogue` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `datedebut` date NOT NULL,
  `datefin` date NOT NULL,
  `saison` varchar(50) NOT NULL,
  PRIMARY KEY (`idcatalogue`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`idcatalogue`, `nom`, `datedebut`, `datefin`, `saison`) VALUES
(24, 'warda', '2019-03-01', '2019-03-08', 'Hiver');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `id_produit` int(11) NOT NULL,
  `montant` float NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `id_produit`, `montant`, `quantite`) VALUES
(1, 1234, 900, 2),
(2, 4321, 4, 3);

-- --------------------------------------------------------

--
-- Structure de la table `ligneproduit`
--

DROP TABLE IF EXISTS `ligneproduit`;
CREATE TABLE IF NOT EXISTS `ligneproduit` (
  `idligne` int(11) NOT NULL AUTO_INCREMENT,
  `idpanier` int(11) NOT NULL,
  `idproduit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`idligne`),
  KEY `idpanier` (`idpanier`),
  KEY `fk_produit` (`idproduit`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ligneproduit`
--

INSERT INTO `ligneproduit` (`idligne`, `idpanier`, `idproduit`, `quantite`) VALUES
(172, 26, 4, 10),
(174, 27, 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `ID_Livraison` int(11) NOT NULL AUTO_INCREMENT,
  `idcommande` int(11) DEFAULT NULL,
  `Montant` float DEFAULT NULL,
  `Etat` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Longitude` double DEFAULT NULL,
  `Latitude` double DEFAULT NULL,
  `id_User` int(11) DEFAULT NULL,
  `nomClient` varchar(30) DEFAULT NULL,
  `nomLivreur` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_Livraison`),
  KEY `fk_user` (`id_User`),
  KEY `fk_commande` (`idcommande`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`ID_Livraison`, `idcommande`, `Montant`, `Etat`, `Date`, `Adresse`, `Longitude`, `Latitude`, `id_User`, `nomClient`, `nomLivreur`) VALUES
(2, 1, 6, 2, '2019-03-01', 'temchiladrisa', 0, 0, 5, ' ', ' ');

-- --------------------------------------------------------

--
-- Structure de la table `messagerie`
--

DROP TABLE IF EXISTS `messagerie`;
CREATE TABLE IF NOT EXISTS `messagerie` (
  `idmessage` int(11) NOT NULL AUTO_INCREMENT,
  `maildestinataire` varchar(1000) NOT NULL,
  `mailexpediteur` varchar(1000) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `etat` varchar(50) NOT NULL,
  PRIMARY KEY (`idmessage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `idpanier` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL,
  PRIMARY KEY (`idpanier`),
  KEY `idutilisateur` (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`idpanier`, `idutilisateur`, `etat`) VALUES
(5, 1, '1'),
(13, 5, '0'),
(14, 6, '0'),
(15, 7, '0'),
(26, 1, '1'),
(27, 1, '0');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `idproduit` int(11) NOT NULL AUTO_INCREMENT,
  `nomproduit` varchar(100) NOT NULL,
  `prix` float NOT NULL,
  `quantite` int(11) NOT NULL,
  `note` float NOT NULL,
  `description` varchar(1000) NOT NULL,
  `saison` varchar(20) NOT NULL,
  `imagep` varchar(200) NOT NULL,
  PRIMARY KEY (`idproduit`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idproduit`, `nomproduit`, `prix`, `quantite`, `note`, `description`, `saison`, `imagep`) VALUES
(2, 'zahra', 13.325, 200, 4, 'the very best', 'Printemps', 'raed.jpg'),
(3, 'fleur', 4.5, 35, 3, 'Classic fleur with the ancient scent.', 'Ete', 'fleur.png'),
(4, 'marguerite', 7.95, 24, 4, 'Exotic fleur especially imported for a change of smell.', 'Printemps', 'marguerite.png'),
(5, 'palnteverte', 5.5, 40, 3, 'A small pot plant for decoration that requiers your attention and care.', 'Ete', 'palnteverte.png'),
(6, 'hibiscus', 10.12, 30, 4, 'A pot plant that grows beatiful flowers for the best colorful decoration.', 'Automne', 'hibiscus.png');

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `idpromotion` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `datedebut` date NOT NULL,
  `datefin` date NOT NULL,
  `pourcentage` int(11) NOT NULL,
  `nomproduit` varchar(40) NOT NULL,
  `nouveauprix` float DEFAULT NULL,
  PRIMARY KEY (`idpromotion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`idpromotion`, `nom`, `datedebut`, `datefin`, `pourcentage`, `nomproduit`, `nouveauprix`) VALUES
(1, 'ggg', '2019-02-28', '2019-03-10', 40, 'zahra', 6.6625);

-- --------------------------------------------------------

--
-- Structure de la table `pub`
--

DROP TABLE IF EXISTS `pub`;
CREATE TABLE IF NOT EXISTS `pub` (
  `idpublicite` int(11) NOT NULL AUTO_INCREMENT,
  `nompublicite` varchar(100) NOT NULL,
  `datepub` date NOT NULL,
  `nomproduit` varchar(40) NOT NULL,
  PRIMARY KEY (`idpublicite`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `idquestion` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(11) NOT NULL,
  `contenu` varchar(1000) NOT NULL,
  `visible` int(11) NOT NULL,
  `nom` varchar(10) DEFAULT NULL,
  `contenu_reponse` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idquestion`),
  KEY `fk_utilisa` (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`idquestion`, `idutilisateur`, `contenu`, `visible`, `nom`, `contenu_reponse`) VALUES
(85, 1, 'comment plant', 0, NULL, NULL),
(86, 1, 'comment rosser une fleure', 0, NULL, NULL),
(87, 1, 'jjhkll', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `idreclamation` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(11) NOT NULL,
  `nomproduit` varchar(20) NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `etat` int(1) NOT NULL,
  PRIMARY KEY (`idreclamation`),
  KEY `fk_idu` (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`idreclamation`, `idutilisateur`, `nomproduit`, `sujet`, `contenu`, `etat`) VALUES
(185, 1, 'zahra', 'test', 'je sais pas', 1),
(186, 1, 'zahra', 'ouii', 'je sais pas', 0),
(187, 1, 'zahra', 'ouii', 'je sais pas', 0),
(188, 1, 'zahra', 'fg', 'ghu', 0);

-- --------------------------------------------------------

--
-- Structure de la table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `idrendezvous` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(11) NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `daterendezvous` date NOT NULL,
  `etat` int(1) NOT NULL,
  PRIMARY KEY (`idrendezvous`),
  KEY `fk_utili` (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rendezvous`
--

INSERT INTO `rendezvous` (`idrendezvous`, `idutilisateur`, `sujet`, `lieu`, `daterendezvous`, `etat`) VALUES
(29, 1, 'planter', 'sokra', '2019-03-01', 0),
(30, 1, 'ggh', 'gygg', '2019-03-02', 0);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `idreponse` int(11) NOT NULL AUTO_INCREMENT,
  `idquestion` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `contenu` varchar(1000) NOT NULL,
  `visible` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idreponse`),
  KEY `fk_utilisat` (`idutilisateur`),
  KEY `idquestion` (`idquestion`)
) ENGINE=InnoDB AUTO_INCREMENT=666 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`idreponse`, `idquestion`, `idutilisateur`, `contenu`, `visible`, `nom`) VALUES
(664, 85, 1, 'oui je veux', 1, NULL),
(665, 86, 1, 'oui je veux', 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idutilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `cin` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `motdepasse` varchar(150) NOT NULL,
  `adressemail` varchar(50) NOT NULL,
  `telephone` int(11) NOT NULL,
  `datecreation` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `photoprofil` varchar(50) NOT NULL,
  `nbpoint` int(11) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `codevalidation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idutilisateur`, `cin`, `nom`, `prenom`, `motdepasse`, `adressemail`, `telephone`, `datecreation`, `status`, `role`, `photoprofil`, `nbpoint`, `adresse`, `codevalidation`) VALUES
(1, 41356895, 'koubaa', 'slim', '56f39bbf7f625a69932822f7c28ad679f726879ee049ab2652c6c953b74a6ddb', 'koubaaslim@hotmail.fr', 52377888, '2019-02-13', 'connecter', 'admin', 'Sanstitre17.jpg', 0, 'temchiladrisa', 'ok'),
(5, 45859685, 'hichem', 'gri', 'ac621ea0c4d75e5f7e07f10d5d5858ec5dd06b3aefde58d7555c0f6bd218a8c7', 'fefezfze@hotmail.fr', 52377888, '2019-02-08', 'on', 'client', 'Sanstitre17.jpg', 0, 'xx', 'ok'),
(6, 41689598, 'anas', 'abdelkefi', '56f39bbf7f625a69932822f7c28ad679f726879ee049ab2652c6c953b74a6ddb', 'zeffezf@gmail.com', 22388555, '2019-02-07', 'disponible', 'Assisstant', 'user.png', 0, 'vrg', NULL),
(7, 74125858, 'raed', 'rebei', '56f39bbf7f625a69932822f7c28ad679f726879ee049ab2652c6c953b74a6ddb', 'zeffezf@yahoo.fr', 98444777, '2019-02-07', 'disponible', 'client', 'user.png', 0, 'vrg', NULL),
(9, 63256895, 'khadija', 'abid', 'e28d512fb89e4bedbf3236528d6f143e56ce0a76d29a17f11e2282dd02121192', 'fezfz@hotmail.com', 52387999, '2019-02-07', 'disponible', 'Livreur', 'user.png', 0, 'fzezf', NULL),
(15, 41859867, 'test', 'test', '56f39bbf7f625a69932822f7c28ad679f726879ee049ab2652c6c953b74a6ddb', 'kof@hotmail.fr', 51688777, '2012-03-01', 'on', 'client', 'Sanstitre17.jpg', 0, 'grggr', 'ok');

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `idvote` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `nomv` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idvote`),
  KEY `fk_users` (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vote`
--

INSERT INTO `vote` (`idvote`, `idutilisateur`, `note`, `nomv`) VALUES
(40, 1, 2, NULL),
(41, 1, 2, NULL),
(42, 1, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE IF NOT EXISTS `wishlist` (
  `idwishlist` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prix` float NOT NULL,
  `cin` int(11) NOT NULL,
  `dateajout` date NOT NULL,
  PRIMARY KEY (`idwishlist`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `wishlist`
--

INSERT INTO `wishlist` (`idwishlist`, `nom`, `prix`, `cin`, `dateajout`) VALUES
(4, 'raed', 53.2, 14766252, '2019-02-28'),
(8, 'warda', 10.325, 14766252, '2019-02-28');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ligneproduit`
--
ALTER TABLE `ligneproduit`
  ADD CONSTRAINT `fk_panier` FOREIGN KEY (`idpanier`) REFERENCES `panier` (`idpanier`),
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`idproduit`) REFERENCES `produit` (`idproduit`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `fk_commande` FOREIGN KEY (`idcommande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_User`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `fk_utilisateur` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_iduti` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk_idu` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD CONSTRAINT `fk_idutlili` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `fk_idq` FOREIGN KEY (`idquestion`) REFERENCES `question` (`idquestion`),
  ADD CONSTRAINT `fk_idut` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `fk_idutilisateur` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
