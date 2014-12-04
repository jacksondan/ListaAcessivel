<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome}- Inicio</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>	
</head>
<body>

	<%@include file="headerCliente.html"%>
	
	<div id="content">

		<header class="major">
			<h2>Detalhes da Lista</h2>	
		</header>
				
				<div id="infolista">
				<fieldset><legend>Informações da Lista</legend>	
				<p>Descrição: ${lista.descricao}</p>
				<p>Data de Criação:  ${lista.data_criacao}</p>					
				<p>Nome Estabelecimento: ${lista.estabelecimento.nome_fantasia}</p>
				<p>Bairro do Estabelecimento: ${$lista.estabelecimento.endereco.bairro}</p>
				<p>Rua  do Estabelecimento: ${$lista.estabelecimento.endereco.rua}</p>
				<p>Telefone 1:${lista.estabelecimento.telefones[0]}</p>
				<p>Telefone 2:${lista.estabelecimento.telefones[1]}</p>
				</fieldset>
				</div>
		
				<table align="center"class="default" summary="Tabela com Produtos do Estabelecimento ${estabelecimento.nome_fantasia} disponíveis de acordo com o filtro,
				Com as seguintes colunas, Descrição, Marca, Valor, Validade, Peso e funções  que são, Selecionar usando um combo box e Digitar quantidade.">
					<caption>Produtos da Lista</caption>
			
					<thead>

						<tr>				
							<th rowspan="2"id="descricao">Descrição</th>
							<th rowspan="2"id="marca">Marca</th>
							<th rowspan="2"id="validade">Validade</th>
							<th rowspan="2"id="peso">Peso</th>
							<th rowspan="2"id="quantidade">Quantidade Solicitada</th>
							<th rowspan="2"id="valor">Preço Unitário</th>
						</tr>
					
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${lista.produtos}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}</td>
							<td headers="marca">${produto.marca}</td>							
							<td headers="validade">${produto.validade}</td>
							<td headers="peso">${produto.peso}</td>
							<td headers="quantidade">${produto.quantidade}</td>
							<td headers="valor">R$${produto.valor}</td>
							
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>	
					<tr>
					<th colspan="4">Quantidade total de produtos: ${lista.quantidade_total}</th>
					<th colspan="2"id="quantidadeProdutos">Valor total da lista: R$${lista.valor_total}</th>
					</tr>
					</tfoot>
				</table>
				<div id="filtro2">
					<button class="button3" onclick="window.location.href='CriarListaPassoServlet?id+lista=${lista.id_lista}'" >Editar Produtos</button>
					<button class="button3" >Imprimir</button>
					<button class="button3" >Solicitar Compra</button>
				</div>
				
	</div>
	<div id="footer">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
			</body>
			</html>
			
		