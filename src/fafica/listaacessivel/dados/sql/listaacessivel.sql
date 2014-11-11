-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11-Nov-2014 às 19:38
-- Versão do servidor: 5.6.20
-- PHP Version: 5.5.15

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
  `cpf` varchar(20) NOT NULL,
  `ano_nascimento` varchar(20) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` char(2) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `referencia` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `cpf`, `ano_nascimento`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `referencia`) VALUES
(1, '1000000000', '1877', 'manoeu fdfdfd', '100', 'casa', 'tesss fdfdsfs', 'caruaru', 'PE', 'Teste', 'perto do beco'),
(2, '10022135356', '12/03/04', 'rua cavaco', '53', 'casa', 'centro', 'Caruaru', 'PE', '1233121', 'de frente ao teste'),
(3, '87285525', '1895', 'manoeu', '98', 'casa', 'tesss', 'caruaru', 'PE', '85774', 'perto da budega');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estabelecimento`
--

CREATE TABLE IF NOT EXISTS `estabelecimento` (
`id_estabelecimento` int(11) NOT NULL,
  `nome_fantasia` varchar(200) NOT NULL,
  `nome_juridico` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` char(2) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `referencia` varchar(70) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `estabelecimento`
--

INSERT INTO `estabelecimento` (`id_estabelecimento`, `nome_fantasia`, `nome_juridico`, `email`, `senha`, `categoria`, `cnpj`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `referencia`, `status`) VALUES
(1, 'Boticario', 'boto rosa.ltda', 'boticario@boticario', '123', 'butic', '1233321123', 'rua teste', '22', 'predio', 'centro', 'caruaru', 'PE', '13213', 'teste', 'ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `id_estabelecimento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista`
--

CREATE TABLE IF NOT EXISTS `lista` (
`id_lista` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `data_criacao` varchar(30) NOT NULL,
  `data_alteracao` varchar(30) DEFAULT NULL,
  `quantidade_total` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `lista`
--

INSERT INTO `lista` (`id_lista`, `descricao`, `data_criacao`, `data_alteracao`, `quantidade_total`, `valor_total`, `status`) VALUES
(2, 'Lista Teste', '10:59:5 - 10/11/2014', NULL, 30, 45, 'ativo'),
(3, 'Lista Teste', '11:25:35 - 10/11/2014', NULL, 30, 45, 'ativo'),
(4, 'Lista Teste', '11:29:30 - 10/11/2014', NULL, 30, 45, 'ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista_cliente_estabelecimento`
--

CREATE TABLE IF NOT EXISTS `lista_cliente_estabelecimento` (
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `id_estabelecimento` int(11) NOT NULL DEFAULT '0',
  `situacao` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `lista_cliente_estabelecimento`
--

INSERT INTO `lista_cliente_estabelecimento` (`id_lista`, `id_cliente`, `id_estabelecimento`, `situacao`) VALUES
(4, 1, 1, 'iniciada');

-- --------------------------------------------------------

--
-- Estrutura da tabela `lista_produto`
--

CREATE TABLE IF NOT EXISTS `lista_produto` (
  `id_produto` int(11) NOT NULL DEFAULT '0',
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `quantidade_produto` int(11) DEFAULT NULL,
  `valor_produto` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `lista_produto`
--

INSERT INTO `lista_produto` (`id_produto`, `id_lista`, `quantidade_produto`, `valor_produto`) VALUES
(1, 4, 30, 1.50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
`id_produto` int(11) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `peso` float(10,3) NOT NULL,
  `quantidade` int(20) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `validade` varchar(20) NOT NULL,
  `codigo_barra` varchar(50) NOT NULL,
  `disponibilidade` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `id_estabelecimento` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `descricao`, `categoria`, `peso`, `quantidade`, `valor`, `validade`, `codigo_barra`, `disponibilidade`, `marca`, `id_estabelecimento`, `status`) VALUES
(1, 'Fuba', 'Alimento', 4.250, 30, 1.50, '22/11/44', '0000000', 'DISPONIVEL', 'nutrivita', 1, 'ativo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_cliente`
--

CREATE TABLE IF NOT EXISTS `telefone_cliente` (
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `telefone` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `telefone_cliente`
--

INSERT INTO `telefone_cliente` (`id_cliente`, `telefone`) VALUES
(1, '88559966'),
(1, '99668855'),
(3, '88559966'),
(3, '99668855');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_estabelecimento`
--

CREATE TABLE IF NOT EXISTS `telefone_estabelecimento` (
  `id_estabelecimento` int(11) NOT NULL DEFAULT '0',
  `telefone` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id_usuario` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `senha`, `nome`, `status`) VALUES
(1, 'rrr@rrr', '123', 'Joaquim', 'ativo'),
(2, 'jose@jose', '123', 'jose', 'ativo'),
(3, 'teste@teste', '123', 'jackson', 'ativo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`id_cliente`), ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Indexes for table `estabelecimento`
--
ALTER TABLE `estabelecimento`
 ADD PRIMARY KEY (`id_estabelecimento`), ADD UNIQUE KEY `nome_juridico` (`nome_juridico`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `cnpj` (`cnpj`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
 ADD PRIMARY KEY (`id_funcionario`), ADD UNIQUE KEY `matricula` (`matricula`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Indexes for table `lista`
--
ALTER TABLE `lista`
 ADD PRIMARY KEY (`id_lista`);

--
-- Indexes for table `lista_cliente_estabelecimento`
--
ALTER TABLE `lista_cliente_estabelecimento`
 ADD PRIMARY KEY (`id_lista`,`id_cliente`,`id_estabelecimento`), ADD UNIQUE KEY `id_lista` (`id_lista`), ADD KEY `id_cliente` (`id_cliente`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Indexes for table `lista_produto`
--
ALTER TABLE `lista_produto`
 ADD PRIMARY KEY (`id_produto`,`id_lista`), ADD KEY `id_lista` (`id_lista`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
 ADD PRIMARY KEY (`id_produto`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Indexes for table `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
 ADD PRIMARY KEY (`id_cliente`,`telefone`);

--
-- Indexes for table `telefone_estabelecimento`
--
ALTER TABLE `telefone_estabelecimento`
 ADD PRIMARY KEY (`id_estabelecimento`,`telefone`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id_usuario`), ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `estabelecimento`
--
ALTER TABLE `estabelecimento`
MODIFY `id_estabelecimento` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `lista`
--
ALTER TABLE `lista`
MODIFY `id_lista` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE,
ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

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
-- Limitadores para a tabela `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
ADD CONSTRAINT `telefone_cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `telefone_estabelecimento`
--
ALTER TABLE `telefone_estabelecimento`
ADD CONSTRAINT `telefone_estabelecimento_ibfk_1` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
