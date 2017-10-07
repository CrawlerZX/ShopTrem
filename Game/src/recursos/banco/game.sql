-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.2.8-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para game
CREATE DATABASE IF NOT EXISTS `game` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `game`;

-- Copiando estrutura para tabela game.config
CREATE TABLE IF NOT EXISTS `config` (
  `id_config` int(11) NOT NULL,
  `resolucao_altura` int(11) NOT NULL,
  `resolucao_largura` int(11) NOT NULL,
  `volume` double NOT NULL,
  `dir_som_vendas` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_config`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.config: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;

-- Copiando estrutura para tabela game.fase
CREATE TABLE IF NOT EXISTS `fase` (
  `id_fase` int(11) NOT NULL,
  `ordem` int(11) NOT NULL COMMENT 'Ordem da fase se é a primeira, segunda e etc',
  `dir_cenario` varchar(200) NOT NULL COMMENT 'caminho dos elementos do cenario separados por ;',
  `guarda_qtd` int(11) NOT NULL,
  `cliente_qtd` int(11) NOT NULL,
  `objetivo` double NOT NULL COMMENT 'objetivo da fase (meta)',
  `dir_musica` double NOT NULL COMMENT 'caminho da musica da fase',
  PRIMARY KEY (`id_fase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.fase: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;

-- Copiando estrutura para tabela game.ranking
CREATE TABLE IF NOT EXISTS `ranking` (
  `id_ranking` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`id_ranking`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela game.ranking: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` (`id_ranking`, `id_user`, `score`) VALUES
	(1, 1, 9999);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;

-- Copiando estrutura para tabela game.sprite
CREATE TABLE IF NOT EXISTS `sprite` (
  `id_sprite` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `caminho_sprite` varchar(200) NOT NULL,
  `num_frames` int(11) NOT NULL,
  `velocidade` double NOT NULL DEFAULT 1,
  `dir_som_andando` varchar(200) DEFAULT NULL,
  `dir_som_correndo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_sprite`),
  KEY `id_sprite` (`id_sprite`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.sprite: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `sprite` DISABLE KEYS */;
INSERT INTO `sprite` (`id_sprite`, `nome`, `caminho_sprite`, `num_frames`, `velocidade`, `dir_som_andando`, `dir_som_correndo`) VALUES
	(1, 'person', 'C:\\Arquivos\\Smaug\\ShopTrain\\Game\\src\\recursos\\sprites\\personagem_full.png', 64, 1.5, '', ''),
	(2, 'guarda', 'C:\\Arquivos\\Smaug\\ShopTrain\\Game\\src\\recursos\\sprites\\guardal.png', 64, 1, '', '');
/*!40000 ALTER TABLE `sprite` ENABLE KEYS */;

-- Copiando estrutura para tabela game.user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(150) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `birthday` datetime NOT NULL,
  `date_sign` datetime NOT NULL,
  `date_last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id_user`,`email`,`nickname`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela game.user: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `name`, `surname`, `nickname`, `email`, `password`, `birthday`, `date_sign`, `date_last_login`) VALUES
	(1, 'Christian', 'Nascimento', 'Hawk', 'crisbr745@gmail.com', 'teste', '1994-06-25 23:17:34', '2017-08-25 23:17:34', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
