-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 16 oct. 2023 à 22:19
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cmurest`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id` int(25) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `examen_physique` varchar(250) DEFAULT NULL,
  `discussion_des_symptomes` varchar(250) DEFAULT NULL,
  `Diagnostic` varchar(250) DEFAULT NULL,
  `ordonnance` varchar(250) DEFAULT NULL,
  `taux_reduction` int(11) DEFAULT NULL,
  `code` varchar(250) DEFAULT NULL,
  `numero_CMU` varchar(250) DEFAULT NULL,
  `id_utilisateur` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consultation_numero_CMU` (`numero_CMU`),
  KEY `FK_consultation_id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id`, `date_creation`, `examen_physique`, `discussion_des_symptomes`, `Diagnostic`, `ordonnance`, `taux_reduction`, `code`, `numero_CMU`, `id_utilisateur`) VALUES
(252, '2023-10-16 22:12:52', 'qq', 'qq', 'qq', 'qq', 70, '357a9944-f47a-4544-a237-1c85ecf4a8d3', '39185127-ae04-432e-aa4f-9de6cea9f55d', '52bfd7cf-a451-4779-8b10-b47db12cdc3f');

-- --------------------------------------------------------

--
-- Structure de la table `consultation_seq`
--

DROP TABLE IF EXISTS `consultation_seq`;
CREATE TABLE IF NOT EXISTS `consultation_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `consultation_seq`
--

INSERT INTO `consultation_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Structure de la table `dossier_patient`
--

DROP TABLE IF EXISTS `dossier_patient`;
CREATE TABLE IF NOT EXISTS `dossier_patient` (
  `numero_CMU` varchar(250) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `ville` varchar(25) DEFAULT NULL,
  `antecedent_medicaux` varchar(250) DEFAULT NULL,
  `historique_de_vaccination` varchar(250) DEFAULT NULL,
  `resumes_medicaux` varchar(250) DEFAULT NULL,
  `age` int(25) DEFAULT NULL,
  `masculin` tinyint(1) DEFAULT NULL,
  `feminin` tinyint(1) DEFAULT NULL,
  `enceinte` tinyint(1) DEFAULT NULL,
  `id_utilisateur` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`numero_CMU`),
  KEY `FK_Dossier_patient_id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dossier_patient`
--

INSERT INTO `dossier_patient` (`numero_CMU`, `date_creation`, `date_modification`, `ville`, `antecedent_medicaux`, `historique_de_vaccination`, `resumes_medicaux`, `age`, `masculin`, `feminin`, `enceinte`, `id_utilisateur`) VALUES
('39185127-ae04-432e-aa4f-9de6cea9f55d', '2023-10-03 23:16:21', NULL, 'abidjan', NULL, NULL, NULL, 16, 1, 0, 0, '40d35987-1a2f-45f0-b440-a7be69a79430'),
('7941da8d-bc93-4d7b-9de6-f0c7818a2614', '2023-10-03 22:24:39', NULL, 'abidjan', NULL, NULL, NULL, 16, 1, 0, 0, '40d35987-1a2f-45f0-b440-a7be69a79430'),
('a8e2bae4-c63a-4f96-8637-9d89b64fccac', '2023-10-10 22:45:19', '2023-10-12 21:46:21', 'q', 'dd', 'ff', 'dddd', 30, 1, 0, 0, '40d35987-1a2f-45f0-b440-a7be69a79430'),
('cdd238c7-724f-4d71-82e9-3bcdf4e1a7af', '2023-10-03 22:28:47', NULL, 'abidjan', NULL, NULL, NULL, 16, 1, 0, 0, '40d35987-1a2f-45f0-b440-a7be69a79430'),
('e4455506-ce16-4ec0-89a2-ca5e1fbcc1c0', '2023-10-03 22:33:21', NULL, 'abidjan', NULL, NULL, NULL, 16, 1, 0, 0, '40d35987-1a2f-45f0-b440-a7be69a79430');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role` varchar(25) NOT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role`) VALUES
('EMPLOYER'),
('MEDECIN'),
('PATIENT');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` varchar(250) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `role` varchar(250) DEFAULT NULL,
  `numero_CMU` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utilisateur_role` (`role`),
  KEY `FK_utilisateur_numero_CMU` (`numero_CMU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `password`, `nom`, `prenom`, `role`, `numero_CMU`) VALUES
('25bfbad3-c22d-41ae-972c-2fbd4c8eee0e', '$2a$10$4fGaZmEKKxlVsfY7.ebQtOsFWD3pccN2F6ti2336M2VlNLzOkRfCC', 'damo', 'yvan', 'EMPLOYER', NULL),
('40d35987-1a2f-45f0-b440-a7be69a79430', '$2a$10$W6hYdsXbLzeW1o99wkcelOVIlX1zHBDWTuf8d6YhYMCpjPeBQKpjS', 'ekra', 'paul', 'PATIENT', NULL),
('52bfd7cf-a451-4779-8b10-b47db12cdc3f', '$2a$10$V4j20gnInHekS34VJ50vQuta1uK1RIJCOuywIPErrHWxDI1cwnpJW', 'angaman', 'cedrick', 'MEDECIN', NULL),
('5e583da0-b2a1-4a0d-b142-fd11ef3d14e4', '$2a$10$J1Bagz9BCP.sjuvsxULuPe28qEosJKSvXRrh34FE16F23ZCyfC8h.', 'ggg', 'ggg', 'EMPLOYER', NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `FK_consultation_id_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_consultation_numero_CMU` FOREIGN KEY (`numero_CMU`) REFERENCES `dossier_patient` (`numero_CMU`);

--
-- Contraintes pour la table `dossier_patient`
--
ALTER TABLE `dossier_patient`
  ADD CONSTRAINT `FK_Dossier_patient_id_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_utilisateur_numero_CMU` FOREIGN KEY (`numero_CMU`) REFERENCES `dossier_patient` (`numero_CMU`),
  ADD CONSTRAINT `FK_utilisateur_role` FOREIGN KEY (`role`) REFERENCES `role` (`role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
