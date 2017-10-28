-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.2.9-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para game
DROP DATABASE IF EXISTS `game`;
CREATE DATABASE IF NOT EXISTS `game` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `game`;

-- Copiando estrutura para tabela game.cenario
DROP TABLE IF EXISTS `cenario`;
CREATE TABLE IF NOT EXISTS `cenario` (
  `id_cenario` int(11) NOT NULL AUTO_INCREMENT,
  `id_fase` int(11) NOT NULL DEFAULT 0,
  `dir.trem` varchar(250) NOT NULL DEFAULT '0',
  `dir.parede` varchar(250) NOT NULL DEFAULT '0',
  `nm_guarda` int(11) NOT NULL DEFAULT 0,
  `nm_cliente` int(11) NOT NULL DEFAULT 0,
  `pos.guarda1` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda2` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda3` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda4` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda5` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda6` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda7` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda8` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda9` varchar(100) NOT NULL DEFAULT '0',
  `pos.guarda10` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente1` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente2` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente3` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente4` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente5` varchar(100) NOT NULL DEFAULT '0',
  `pos.cliente6` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_cenario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.cenario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cenario` DISABLE KEYS */;
INSERT INTO `cenario` (`id_cenario`, `id_fase`, `dir.trem`, `dir.parede`, `nm_guarda`, `nm_cliente`, `pos.guarda1`, `pos.guarda2`, `pos.guarda3`, `pos.guarda4`, `pos.guarda5`, `pos.guarda6`, `pos.guarda7`, `pos.guarda8`, `pos.guarda9`, `pos.guarda10`, `pos.cliente1`, `pos.cliente2`, `pos.cliente3`, `pos.cliente4`, `pos.cliente5`, `pos.cliente6`) VALUES
	(1, 1, 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\trem1.png', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\frente1.png', 0, 0, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
	(2, 1, 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\trem2.png', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\frente2.png', 2, 1, '350;350', '450;450', '0', '0', '0', '0', '0', '0', '0', '0', '250;350', '500;350', '0', '0', '0', '0'),
	(3, 1, 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\trem3.png', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\frente3.png', 1, 1, '350;350', '', '0', '0', '0', '0', '0', '0', '0', '0', '250;350', '', '0', '0', '0', '0'),
	(4, 1, 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\trem4.png', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\frente4.png', 1, 0, '350;350', '', '0', '0', '0', '0', '0', '0', '0', '0', '', '', '0', '0', '0', '0'),
	(5, 1, 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\trem5.png', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\cenarios\\\\fase1\\\\frente5.png', 0, 0, '', '', '0', '0', '0', '0', '0', '0', '0', '0', '', '', '0', '0', '0', '0');
/*!40000 ALTER TABLE `cenario` ENABLE KEYS */;

-- Copiando estrutura para tabela game.fase
DROP TABLE IF EXISTS `fase`;
CREATE TABLE IF NOT EXISTS `fase` (
  `id_fase` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_fase`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.fase: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` (`id_fase`, `nome`) VALUES
	(1, 'vagao da alegria');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;

-- Copiando estrutura para tabela game.param
DROP TABLE IF EXISTS `param`;
CREATE TABLE IF NOT EXISTS `param` (
  `game.janela.w` varchar(100) NOT NULL,
  `game.janela.h` varchar(100) NOT NULL,
  `game.thread.sleep.transition` varchar(100) NOT NULL,
  `game.thread.sleep` varchar(100) NOT NULL,
  `person.dir.img` varchar(100) NOT NULL,
  `person.num.frame` varchar(100) NOT NULL,
  `person.vel` varchar(100) NOT NULL,
  `person.anim.duration` varchar(100) NOT NULL,
  `person.init.x` varchar(100) NOT NULL,
  `person.init.y` varchar(100) NOT NULL,
  `guarda.dir.img` varchar(100) NOT NULL,
  `guarda.num.frame` varchar(100) NOT NULL,
  `guarda.vel` varchar(100) NOT NULL,
  `guarda.anim.duration` varchar(100) NOT NULL,
  `guarda.rayvision` varchar(100) NOT NULL,
  `guarda.init.x` varchar(100) NOT NULL,
  `guarda.init.y` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela game.param: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `param` DISABLE KEYS */;
INSERT INTO `param` (`game.janela.w`, `game.janela.h`, `game.thread.sleep.transition`, `game.thread.sleep`, `person.dir.img`, `person.num.frame`, `person.vel`, `person.anim.duration`, `person.init.x`, `person.init.y`, `guarda.dir.img`, `guarda.num.frame`, `guarda.vel`, `guarda.anim.duration`, `guarda.rayvision`, `guarda.init.x`, `guarda.init.y`) VALUES
	('1280', '720', '500', '10', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\sprites\\\\sprite_sheet_person.png', '8', '3.5', '500', '500', '330', 'C:\\\\Arquivos\\\\facul\\\\3\\\\smaug\\\\ShopTrem\\\\Game\\\\src\\\\recursos\\\\sprites\\\\sprite_sheet_person.png', '8', '2', '500', '200', '600', '330');
/*!40000 ALTER TABLE `param` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
