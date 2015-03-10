-- phpMyAdmin SQL Dump
-- version 4.3.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 10/03/2015 às 16:35
-- Versão do servidor: 10.0.16-MariaDB-log
-- Versão do PHP: 5.6.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `listaacessivel`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `id_administrador` int(11) NOT NULL,
  `cpf` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `cpf`) VALUES
(1, '000.000.000.00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
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
  `cep` varchar(12) NOT NULL,
  `referencia` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `cpf`, `ano_nascimento`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `referencia`) VALUES
(6, '053.086.814-81', '1985', 'Imperial', '185', 'Casa', 'Agamenom Magalhães', 'Caruaru', 'PE', '55002-010', 'Orelhão');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estabelecimento`
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
  `id_administrador` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `estabelecimento`
--

INSERT INTO `estabelecimento` (`id_estabelecimento`, `nome_fantasia`, `nome_juridico`, `email`, `senha`, `categoria`, `cnpj`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `referencia`, `id_administrador`, `status`) VALUES
(16, 'Supermercado Baratão de Alimentos', 'Baratão de Alimentos', 'barataoalimentos@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Supermercado', '121.212.121-21', 'Rua Doutor José Mariano', '14', 'Comércio', 'Nossa Senhora das Dores', 'Caruaru', 'PE', '55002-000', 'Praça Nossa Senhora das Dores', 1, 'inativo'),
(17, 'Supermercado Bom Preço', 'Bom Preço', 'bompreco@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Supermercado', '212.121.212-13', 'Rua Manoel Maria', '38', 'Comércio', 'Nossa Senhora das Dores', 'Caruaru', 'PE', '55002-060', 'Praça Nossa Senhora das Dores', 1, 'ativo'),
(18, 'Padraria Nossa Senhora do Carmo', 'Padaria Nossa Senhora do Carmo', 'padarianossasenhoradocarmo@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Padaria', '323.232.323-23', 'Rua Tenente Antônio Florêncio do Nascimento', '476', 'Comércio', 'Morro do Bom Jesus', 'Caruaru', 'PE', '55008-120', 'Morro do Bom Jesus', 1, 'ativo'),
(19, 'Livraria Passo Certo', 'Passo Certo', 'livrariapassocerto@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Livraria', '232.323.232-31', 'Rua Josefa Pereira', '159', 'Comércio', 'São Francisco', 'Caruaru', 'PE', '55006-057', 'Próximo a Secretaria de Saúde', 1, 'ativo'),
(20, 'Farmácia Menor Preço', 'Farmácia Menor Preço', 'farmaciamenorpreco@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Farmácia', '432.323.243-43', '2ª Travessa Santos Dumont', '237', 'Comércio', 'São Francisco', 'Caruaru', 'PE', '55006-132', 'Próximo a praça', 1, 'ativo'),
(21, 'Supermercado Compre Bem', 'Compre Bem', 'comprebem@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Supermercado', '434.343.434-34', 'Rua Bahia', '678', 'Comércio', 'Divinópolis', 'Caruaru', 'PE', '55010-350', 'Ao lado do North Shopping', 1, 'ativo');

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `id_estabelecimento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `matricula`, `id_estabelecimento`) VALUES
(7, '123', 16),
(8, '1234567890', 17);

-- --------------------------------------------------------

--
-- Estrutura para tabela `lista`
--

CREATE TABLE IF NOT EXISTS `lista` (
  `id_lista` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `data_criacao` varchar(30) NOT NULL,
  `data_alteracao` varchar(30) DEFAULT NULL,
  `quantidade_total` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `lista`
--

INSERT INTO `lista` (`id_lista`, `descricao`, `data_criacao`, `data_alteracao`, `quantidade_total`, `valor_total`, `status`) VALUES
(8, 'Lista de fim de semana  2', '4/12/2014', '4/3/2015', 17, 69.65, 'ativo'),
(9, 'Lista comum de produtos', '4/12/2014', '4/12/2014', 37, 102.7, 'ativo');

-- --------------------------------------------------------

--
-- Estrutura para tabela `lista_cliente_estabelecimento`
--

CREATE TABLE IF NOT EXISTS `lista_cliente_estabelecimento` (
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `id_estabelecimento` int(11) NOT NULL DEFAULT '0',
  `situacao` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `lista_cliente_estabelecimento`
--

INSERT INTO `lista_cliente_estabelecimento` (`id_lista`, `id_cliente`, `id_estabelecimento`, `situacao`) VALUES
(8, 6, 16, 'atendida'),
(9, 6, 16, 'solicitada');

-- --------------------------------------------------------

--
-- Estrutura para tabela `lista_produto`
--

CREATE TABLE IF NOT EXISTS `lista_produto` (
  `id_lista` int(11) NOT NULL DEFAULT '0',
  `id_produto` int(11) NOT NULL DEFAULT '0',
  `quantidade_produto` int(11) DEFAULT NULL,
  `valor_produto` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `lista_produto`
--

INSERT INTO `lista_produto` (`id_lista`, `id_produto`, `quantidade_produto`, `valor_produto`) VALUES
(8, 6, 5, 2.75),
(8, 7, 3, 4.80),
(9, 7, 4, 4.80),
(9, 8, 10, 1.97),
(8, 9, 2, 2.70),
(9, 9, 4, 2.70),
(8, 10, 2, 1.80),
(9, 10, 15, 1.80),
(8, 11, 5, 6.50),
(9, 11, 4, 6.50);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id_produto` int(11) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `peso` float(10,3) NOT NULL,
  `quantidade` int(20) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `validade` varchar(30) NOT NULL,
  `codigo_barra` varchar(50) NOT NULL,
  `disponibilidade` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `id_estabelecimento` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `descricao`, `categoria`, `peso`, `quantidade`, `valor`, `validade`, `codigo_barra`, `disponibilidade`, `marca`, `id_estabelecimento`, `status`) VALUES
(6, 'Arroz Branco', 'Alimentos', 1.000, 300, 2.75, '2016-05-18', '90192910291122', 'disponível', 'Tio João', 16, 'ativo'),
(7, 'Feijão Carioca', 'Alimentos', 1.000, 300, 4.80, '2015-11-20', '5664646451111222', 'disponível', 'Tio João', 16, 'ativo'),
(8, 'Macarrão Fino', 'Alimentos', 0.300, 300, 1.97, '2016-03-23', '546655111112232', 'disponível', 'Vitarella', 16, 'ativo'),
(9, 'Coca Cola Light', 'Bebidas', 2.000, 300, 2.70, '2016-09-30', '657676711111143', 'disponível', 'Coca Cola', 16, 'ativo'),
(10, 'Sabão em Pó', 'limpeza', 1.000, 300, 1.80, '2017-05-25', '6556352311222111', 'disponível', 'Brilhante', 16, 'ativo'),
(11, 'Sabonete líquido', 'limpeza', 0.700, 300, 6.50, '2018-02-22', '434534511111154', 'disponível', 'Lux', 16, 'ativo'),
(12, 'Arroz Branco', 'Alimentos', 1.000, 300, 3.10, '2016-09-14', 'null', 'disponível', 'Rampinelli', 17, 'ativo'),
(13, 'Feijão Carioca', 'Alimentos', 1.000, 300, 3.20, '2016-04-30', '56456456456211111', 'disponível', 'Camil', 17, 'ativo'),
(14, 'Macarrão Fino', 'Alimentos', 0.700, 300, 2.10, '2016-05-14', '543534511111123', 'disponível', 'Barilla', 17, 'ativo'),
(15, 'Achocolatado', 'Bebidas', 0.900, 300, 4.70, '2016-03-28', '7567567567111111', 'disponível', 'Nescau', 17, 'ativo'),
(16, 'Água sanitária', 'limpeza', 1.000, 300, 1.50, '2017-08-30', '77776666112221211', 'disponível', 'Dragão', 17, 'ativo'),
(17, 'Arroz Integral', 'Alimentos', 1.000, 300, 4.80, '2016-11-24', '4545541111222111', 'disponível', 'Rampinelli', 17, 'ativo'),
(18, 'Bolacha Champagne', 'Alimentos', 0.500, 100, 2.60, '2015-09-29', '4564564561111112', 'disponível', 'Balduco', 18, 'ativo'),
(19, 'Bolo de Chocolate', 'Alimentos', 0.800, 50, 3.40, '2016-03-26', '666655552123111', 'disponível', 'Dona Benta', 18, 'ativo'),
(20, 'Pão Frances', 'Alimentos', 1.000, 500, 3.50, '2015-01-13', '23423242112111', 'disponível', 'Regional', 18, 'ativo'),
(21, 'Arroz Integral', 'Alimentos', 1.000, 300, 6.30, '2016-04-28', '55555431311111', 'disponível', 'Tio João', 21, 'ativo'),
(22, 'Feijão Macassa', 'Alimentos', 1.000, 300, 3.40, '2015-10-27', '3443434341111121', 'disponível', 'Rampinelli', 21, 'ativo'),
(23, 'Leite Condensado', 'Alimentos', 0.300, 100, 5.40, '2016-01-04', '323232321111111', 'disponível', 'Moça', 21, 'ativo'),
(24, 'Macarrão Médio', 'Alimentos', 0.400, 300, 2.30, '2016-04-26', '4444443332211111', 'disponível', 'Vitarella', 21, 'ativo'),
(25, 'Detergente Neutro', 'limpeza', 0.500, 100, 1.80, '2017-08-12', '312231231321111', 'disponível', 'Limpol', 21, 'ativo'),
(26, 'Creme Dental', 'limpeza', 0.200, 100, 2.30, '2016-01-07', '1231231231231111', 'disponível', 'Sorriso', 21, 'ativo');

-- --------------------------------------------------------

--
-- Estrutura para tabela `telefone_cliente`
--

CREATE TABLE IF NOT EXISTS `telefone_cliente` (
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `telefone` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `telefone_cliente`
--

INSERT INTO `telefone_cliente` (`id_cliente`, `telefone`) VALUES
(6, '(81)9218-2556'),
(6, '(81)9718-3843');

-- --------------------------------------------------------

--
-- Estrutura para tabela `telefone_estabelecimento`
--

CREATE TABLE IF NOT EXISTS `telefone_estabelecimento` (
  `id_estabelecimento` int(11) NOT NULL DEFAULT '0',
  `telefone` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `telefone_estabelecimento`
--

INSERT INTO `telefone_estabelecimento` (`id_estabelecimento`, `telefone`) VALUES
(16, '(81)8888-8888'),
(16, '(81)9999-9999'),
(17, '(81)8989-8989'),
(17, '(81)9898-9898'),
(18, '(81)7979-7979'),
(18, '(81)9797-9797'),
(19, '(81)5656-5656'),
(19, '(81)6060-6060'),
(20, '(81)4455-5544'),
(20, '(81)5555-4555'),
(21, '(81)3535-4343'),
(21, '(81)5656-5654');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `senha`, `nome`, `status`) VALUES
(1, 'admin@admin', 'ICy5YqxZB1uWSwcVLSNLcA==', 'TechBin Admin', 'ativo'),
(6, 'ivanvalentimsantos@gmail.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Ivan Valentim Santos', 'ativo'),
(7, 'ivan@email.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Ivan Valentim', 'ativo'),
(8, 'jose@email.com', 'ICy5YqxZB1uWSwcVLSNLcA==', 'Jose da silva', 'ativo');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`), ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`), ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  ADD PRIMARY KEY (`id_estabelecimento`), ADD UNIQUE KEY `nome_juridico` (`nome_juridico`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `cnpj` (`cnpj`), ADD KEY `id_administrador` (`id_administrador`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`), ADD UNIQUE KEY `matricula` (`matricula`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Índices de tabela `lista`
--
ALTER TABLE `lista`
  ADD PRIMARY KEY (`id_lista`);

--
-- Índices de tabela `lista_cliente_estabelecimento`
--
ALTER TABLE `lista_cliente_estabelecimento`
  ADD PRIMARY KEY (`id_lista`,`id_cliente`,`id_estabelecimento`), ADD UNIQUE KEY `id_lista` (`id_lista`), ADD KEY `id_cliente` (`id_cliente`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Índices de tabela `lista_produto`
--
ALTER TABLE `lista_produto`
  ADD PRIMARY KEY (`id_produto`,`id_lista`), ADD KEY `id_lista` (`id_lista`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`), ADD KEY `id_estabelecimento` (`id_estabelecimento`);

--
-- Índices de tabela `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
  ADD PRIMARY KEY (`id_cliente`,`telefone`);

--
-- Índices de tabela `telefone_estabelecimento`
--
ALTER TABLE `telefone_estabelecimento`
  ADD PRIMARY KEY (`id_estabelecimento`,`telefone`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`), ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  MODIFY `id_estabelecimento` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de tabela `lista`
--
ALTER TABLE `lista`
  MODIFY `id_lista` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `administrador`
--
ALTER TABLE `administrador`
ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Restrições para tabelas `cliente`
--
ALTER TABLE `cliente`
ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Restrições para tabelas `estabelecimento`
--
ALTER TABLE `estabelecimento`
ADD CONSTRAINT `estabelecimento_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id_administrador`);

--
-- Restrições para tabelas `funcionario`
--
ALTER TABLE `funcionario`
ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE,
ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

--
-- Restrições para tabelas `lista_cliente_estabelecimento`
--
ALTER TABLE `lista_cliente_estabelecimento`
ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_1` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_lista`) ON DELETE CASCADE,
ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE,
ADD CONSTRAINT `lista_cliente_estabelecimento_ibfk_3` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

--
-- Restrições para tabelas `lista_produto`
--
ALTER TABLE `lista_produto`
ADD CONSTRAINT `lista_produto_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`) ON DELETE CASCADE,
ADD CONSTRAINT `lista_produto_ibfk_2` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id_lista`) ON DELETE CASCADE;

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

--
-- Restrições para tabelas `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
ADD CONSTRAINT `telefone_cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE;

--
-- Restrições para tabelas `telefone_estabelecimento`
--
ALTER TABLE `telefone_estabelecimento`
ADD CONSTRAINT `telefone_estabelecimento_ibfk_1` FOREIGN KEY (`id_estabelecimento`) REFERENCES `estabelecimento` (`id_estabelecimento`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
