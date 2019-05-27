-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 01, 2019 at 04:42 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `pepiniere`
--

-- --------------------------------------------------------

--
-- Table structure for table `assisstance`
--

CREATE TABLE `assisstance` (
  `id_assisstance` int(11) NOT NULL,
  `id_client` varchar(20) NOT NULL,
  `id_assisstant` varchar(20) NOT NULL,
  `dateAss` date NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE `catalogue` (
  `idcatalogue` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `datedebut` date NOT NULL,
  `datefin` date NOT NULL,
  `saison` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`idcatalogue`, `nom`, `datedebut`, `datefin`, `saison`) VALUES
(24, 'warda', '2019-03-01', '2019-03-08', 'Hiver');

-- --------------------------------------------------------

--
-- Table structure for table `ligneproduit`
--

CREATE TABLE `ligneproduit` (
  `idligne` int(11) NOT NULL,
  `idpanier` int(11) NOT NULL,
  `idproduit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `livraison`
--

CREATE TABLE `livraison` (
  `ID_Livraison` int(11) NOT NULL,
  `idcommande` int(11) DEFAULT NULL,
  `Montant` float DEFAULT NULL,
  `Etat` int(1) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Longitude` double DEFAULT NULL,
  `Latitude` double DEFAULT NULL,
  `id_User` int(11) DEFAULT NULL,
  `nomClient` varchar(30) DEFAULT NULL,
  `nomLivreur` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livraison`
--

INSERT INTO `livraison` (`ID_Livraison`, `idcommande`, `Montant`, `Etat`, `Date`, `Adresse`, `Longitude`, `Latitude`, `id_User`, `nomClient`, `nomLivreur`) VALUES
(96, 1, 6, 2, '2019-03-01', 'seifouuuun', 0, 0, 5, ' ', 'slim koubaa'),
(97, 1, 6, 0, '2019-03-02', 'rue menzah', 0, 0, 5, ' ', ' '),
(98, 1, 6, 0, '2019-03-10', 'nasr 2', 0, 0, 5, ' ', ' '),
(99, 1, 6, 0, '2019-03-02', 'rue yakout', 0, 0, 5, ' ', ' '),
(100, 1, 30, 0, '2019-03-03', 'rue soukra', 0, 0, 5, ' ', ' '),
(101, 1, 30, 0, '2019-03-10', 'raed el rebai', 0, 0, 5, ' ', ' ');

-- --------------------------------------------------------

--
-- Table structure for table `livreur`
--

CREATE TABLE `livreur` (
  `id_livreur` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `cin` int(8) NOT NULL,
  `etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `livreur`
--

INSERT INTO `livreur` (`id_livreur`, `nom`, `prenom`, `cin`, `etat`) VALUES
(1, 'Abidi', 'seif', 7486762, 0);

-- --------------------------------------------------------

--
-- Table structure for table `messagerie`
--

CREATE TABLE `messagerie` (
  `idmessage` int(11) NOT NULL,
  `maildestinataire` varchar(1000) NOT NULL,
  `mailexpediteur` varchar(1000) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `etat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `panier`
--

CREATE TABLE `panier` (
  `idpanier` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `panier`
--

INSERT INTO `panier` (`idpanier`, `idutilisateur`, `etat`) VALUES
(5, 1, '1'),
(13, 5, '0'),
(14, 6, '0'),
(15, 7, '0'),
(26, 1, '0');

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `idproduit` int(11) NOT NULL,
  `nomproduit` varchar(100) NOT NULL,
  `prix` float NOT NULL,
  `quantite` int(11) NOT NULL,
  `note` float NOT NULL,
  `description` varchar(1000) NOT NULL,
  `saison` varchar(20) NOT NULL,
  `imagep` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`idproduit`, `nomproduit`, `prix`, `quantite`, `note`, `description`, `saison`, `imagep`) VALUES
(2, 'zahra', 13.325, 200, 4, 'the very best', 'Printemps', 'raed.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `idpromotion` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `datedebut` date NOT NULL,
  `datefin` date NOT NULL,
  `pourcentage` int(11) NOT NULL,
  `nomproduit` varchar(40) NOT NULL,
  `nouveauprix` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`idpromotion`, `nom`, `datedebut`, `datefin`, `pourcentage`, `nomproduit`, `nouveauprix`) VALUES
(1, 'ggg', '2019-02-28', '2019-03-10', 40, 'zahra', 6.6625);

-- --------------------------------------------------------

--
-- Table structure for table `pub`
--

CREATE TABLE `pub` (
  `idpublicite` int(11) NOT NULL,
  `nompublicite` varchar(100) NOT NULL,
  `datepub` date NOT NULL,
  `nomproduit` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `idquestion` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `contenu` varchar(1000) NOT NULL,
  `visible` int(11) NOT NULL,
  `nom` varchar(10) DEFAULT NULL,
  `contenu_reponse` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`idquestion`, `idutilisateur`, `contenu`, `visible`, `nom`, `contenu_reponse`) VALUES
(85, 1, 'comment planter', 0, NULL, NULL),
(86, 1, 'comment rosser une fleure', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `idreclamation` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `nomproduit` varchar(20) NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `etat` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`idreclamation`, `idutilisateur`, `nomproduit`, `sujet`, `contenu`, `etat`) VALUES
(185, 1, 'zahra', 'test', 'je sais pas', 1),
(186, 1, 'zahra', 'ouii', 'je sais pas', 0),
(187, 1, 'zahra', 'ouii', 'je sais pas', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rendezvous`
--

CREATE TABLE `rendezvous` (
  `idrendezvous` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `daterendezvous` date NOT NULL,
  `etat` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rendezvous`
--

INSERT INTO `rendezvous` (`idrendezvous`, `idutilisateur`, `sujet`, `lieu`, `daterendezvous`, `etat`) VALUES
(29, 1, 'planter', 'sokra', '2019-03-01', 0);

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

CREATE TABLE `reponse` (
  `idreponse` int(11) NOT NULL,
  `idquestion` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `contenu` varchar(1000) NOT NULL,
  `visible` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`idreponse`, `idquestion`, `idutilisateur`, `contenu`, `visible`, `nom`) VALUES
(664, 85, 1, 'oui je veux', 1, NULL),
(665, 86, 1, 'oui je veux', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idutilisateur` int(11) NOT NULL,
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
  `codevalidation` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idutilisateur`, `cin`, `nom`, `prenom`, `motdepasse`, `adressemail`, `telephone`, `datecreation`, `status`, `role`, `photoprofil`, `nbpoint`, `adresse`, `codevalidation`) VALUES
(1, 41356895, 'koubaa', 'slim', '3e1d9f7d43417b645e0bf9a4a9ece28850374f0d845719541bea3768a8a8be89', 'koubaaslim@hotmail.fr', 52377888, '2019-02-13', 'connecter', 'admin', 'Sanstitre17.jpg', 0, 'temchiladrisa', 'ok'),
(5, 45859685, 'fezfze', 'feffee', 'ac621ea0c4d75e5f7e07f10d5d5858ec5dd06b3aefde58d7555c0f6bd218a8c7', 'fefezfze@hotmail.fr', 52377888, '2019-02-08', 'on', 'client', 'Sanstitre17.jpg', 0, 'xx', 'ok'),
(6, 41, 'fezfez', 'fzefze', '3e1d9f7d43417b645e0bf9a4a9ece28850374f0d845719541bea3768a8a8be89', 'zeffezf', 2255, '2019-02-07', 'disponible', 'Assistant', 'user.png', 0, 'vrg', NULL),
(7, 41, 'fezfez', 'fzefze', '3e1d9f7d43417b645e0bf9a4a9ece28850374f0d845719541bea3768a8a8be89', 'zeffezf', 2255, '2019-02-07', 'disponible', 'client', 'user.png', 0, 'vrg', NULL),
(9, 41, 'fezf', 'efzfz', 'e28d512fb89e4bedbf3236528d6f143e56ce0a76d29a17f11e2282dd02121192', 'fezfz', 55555, '2019-02-07', 'disponible', 'Livreur', 'user.png', 0, 'fzezf', NULL),
(10, 77777, 'ykuyk', 'yukkku', '2d7fc7c4ff3647f8f8c48670eb7effce92866cbe7d49f7bb77bb1ef7c3278aad', 'ukyukykyk', 22222222, '2019-02-14', 'disponible', 'Livreur', 'user.png', 0, 'regegre', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

CREATE TABLE `vote` (
  `idvote` int(11) NOT NULL,
  `idutilisateur` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `nomv` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vote`
--

INSERT INTO `vote` (`idvote`, `idutilisateur`, `note`, `nomv`) VALUES
(40, 1, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `idwishlist` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` float NOT NULL,
  `cin` int(11) NOT NULL,
  `dateajout` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`idwishlist`, `nom`, `prix`, `cin`, `dateajout`) VALUES
(4, 'raed', 53.2, 14766252, '2019-02-28'),
(8, 'warda', 10.325, 14766252, '2019-02-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assisstance`
--
ALTER TABLE `assisstance`
  ADD PRIMARY KEY (`id_assisstance`);

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`idcatalogue`);

--
-- Indexes for table `ligneproduit`
--
ALTER TABLE `ligneproduit`
  ADD PRIMARY KEY (`idligne`),
  ADD KEY `idpanier` (`idpanier`),
  ADD KEY `fk_produit` (`idproduit`);

--
-- Indexes for table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`ID_Livraison`),
  ADD KEY `fk_user` (`id_User`),
  ADD KEY `fk_commande` (`idcommande`);

--
-- Indexes for table `livreur`
--
ALTER TABLE `livreur`
  ADD PRIMARY KEY (`id_livreur`);

--
-- Indexes for table `messagerie`
--
ALTER TABLE `messagerie`
  ADD PRIMARY KEY (`idmessage`);

--
-- Indexes for table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`idpanier`),
  ADD KEY `idutilisateur` (`idutilisateur`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idproduit`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`idpromotion`);

--
-- Indexes for table `pub`
--
ALTER TABLE `pub`
  ADD PRIMARY KEY (`idpublicite`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`idquestion`),
  ADD KEY `fk_utilisa` (`idutilisateur`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`idreclamation`),
  ADD KEY `fk_idu` (`idutilisateur`);

--
-- Indexes for table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD PRIMARY KEY (`idrendezvous`),
  ADD KEY `fk_utili` (`idutilisateur`);

--
-- Indexes for table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`idreponse`),
  ADD KEY `fk_utilisat` (`idutilisateur`),
  ADD KEY `idquestion` (`idquestion`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idutilisateur`);

--
-- Indexes for table `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`idvote`),
  ADD KEY `fk_users` (`idutilisateur`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`idwishlist`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assisstance`
--
ALTER TABLE `assisstance`
  MODIFY `id_assisstance` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `idcatalogue` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `ligneproduit`
--
ALTER TABLE `ligneproduit`
  MODIFY `idligne` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `livraison`
--
ALTER TABLE `livraison`
  MODIFY `ID_Livraison` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `livreur`
--
ALTER TABLE `livreur`
  MODIFY `id_livreur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `messagerie`
--
ALTER TABLE `messagerie`
  MODIFY `idmessage` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `panier`
--
ALTER TABLE `panier`
  MODIFY `idpanier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `idproduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `idpromotion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pub`
--
ALTER TABLE `pub`
  MODIFY `idpublicite` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `idquestion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `idreclamation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=188;

--
-- AUTO_INCREMENT for table `rendezvous`
--
ALTER TABLE `rendezvous`
  MODIFY `idrendezvous` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `idreponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=666;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idutilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vote`
--
ALTER TABLE `vote`
  MODIFY `idvote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `idwishlist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ligneproduit`
--
ALTER TABLE `ligneproduit`
  ADD CONSTRAINT `fk_panier` FOREIGN KEY (`idpanier`) REFERENCES `panier` (`idpanier`),
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`idproduit`) REFERENCES `produit` (`idproduit`);

--
-- Constraints for table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `fk_utilisateur` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_iduti` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk_idu` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Constraints for table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD CONSTRAINT `fk_idutlili` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Constraints for table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `fk_idq` FOREIGN KEY (`idquestion`) REFERENCES `question` (`idquestion`),
  ADD CONSTRAINT `fk_idut` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);

--
-- Constraints for table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `fk_idutilisateur` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`);
