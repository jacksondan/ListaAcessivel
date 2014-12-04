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
			<h2>Criar Lista Passo 04</h2>	
		</header>
				
				<div id="infolista">
				<fieldset><legend>Informações da Lista</legend>				
				<p>Cliente: ${lista.cliente.nome}</p>			
				<p>Estabelecimento: ${estabelecimento.nome_fantasia}</p>	
				<p>Bairro do Estabelecimento: ${$estabelecimento.endereco.bairro }</p>
				<p>Rua  do Estabelecimento: ${$estabelecimento.endereco.rua }</p>
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
							<th rowspan="2"id="valor">Preço Unitário</th>
						</tr>
					
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${lista}" var="lista" varStatus="status">
						<tr>
							<td headers="descricao">${lista.produto.descricao}</td>
							<td headers="marca">${lista.produto.marca}</td>							
							<td headers="validade">${lista.produto.validade}</td>
							<td headers="peso">${lista.produto.peso}</td>
							<td headers="valor">R$${lista.produto.valor}</td>
							
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>	
					<tr>
					<th>Quantidade total de produtos:${lista.quantidade_total}</th>
					<th id="quantidadeProdutos">Valor total da lista:${lista.valor_total}</th>
					</tr>
					</tfoot>
				</table>
				<div id="filtro2">
					
					
					<button class="button3" >Adicionar Produtos</button>
					<button class="button3" >Imprimir</button>
					<button class="button3" >Solicitar Compra</button>
				</div>
				
				<div id="finalizar">
				
				<!--
					<button type="submit" onclick="window.location.href='CriarListaPasso3Servlet?selecionado=selecionado&quantidade=quantidade&id_estabelecimento=${estabelecimento.id_estabelecimento}'"class="button3" >Finalizar Lista</button>
				-->
				
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
			
		