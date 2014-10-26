-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 26-Out-2014 às 18:13
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `listaacessivel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(200) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estabelecimento`
--

CREATE TABLE IF NOT EXISTS `estabelecimento` (
  `id_estabelecimento` int(11) NOT NULL,
  `nome_fantasia` varchar(200) NOT NULL,
  `nome_juridico` varchar(200) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  PRIMARY KEY (`id_estabelecimento`),
  UNIQUE KEY `nome_juridico` (`nome_juridico`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista`
--

CREATE TABLE IF NOT EXISTS `lista` (
  `id_lista` int(11) NOT NULL AUTO_INCREMENT,
  `data_criacao` varchar(20) NOT NULL,
  `data_modificacao` varchar(20) DEFAULT NULL,
  `quantidade_total` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_lista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista_cliente_estabelecimento`
--

CREATE TABLE IF NOT EXISTS `lista_cliente_estabelecimento` (
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `id_estabelecimento` int(11) NOT NULL DEFAULT '0',
  `situacao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_lista`,`id_cliente`,`id_estabelecimento`),
  UNIQUE KEY `id_lista` (`id_lista`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_estabelecimento` (`id_estabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista_produto`
--

CREATE TABLE IF NOT EXISTS `lista_produto` (
  `id_produto` int(11) NOT NULL DEFAULT '0',
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`,`id_lista`),
  KEY `id_lista` (`id_lista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_produto` varchar(200) NOT NULL,
  `categoria_produto` varchar(50) NOT NULL,
  `peso_produto` varchar(10) NOT NULL,
  `quantidade_produto` int(20) NOT NULL,
  `preco_produto` float(10,2) NOT NULL,
  `validade_produto` varchar(20) NOT NULL,
  `codigo_barra` varchar(50) NOT NULL,
  `disponibilidade` varchar(20) NOT NULL,
  `marca_produto` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_estabelecimento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `id_estabelecimento` (`id_estabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_usuario`
--

CREATE TABLE IF NOT EXISTS `telefone_usuario` (
  `id_usuario` int(11) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  PRIMARY KEY (`id_usuario`,`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` char(2) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `referencia` varchar(70) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  ADD CONSTRAINT `estabelecimento_ibfk_1` FOREIGN KEY (`id_estabelecimento`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `lista_cliente_estabelecimento`
--
ALTER TABLE `lista_cliente_estabelecimento`
  ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_1` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_lista`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_3` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `lista_produto`
--
ALTER TABLE `lista_produto`
  ADD CONSTRAINT `lista_produto_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_produto_ibfk_2` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_lista`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `telefone_usuario`
--
ALTER TABLE `telefone_usuario`
  ADD CONSTRAINT `telefone_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
