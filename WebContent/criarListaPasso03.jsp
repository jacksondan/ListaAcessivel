<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome}- Inicio</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<%@include file="headerCliente.html"%>
	<div id="content3">

		<header class="major2">
			<h2>Criar Lista Passo - 03</h2>	
		</header>
		<div id="filtro2">
		<form action="Servlet" method="get">
		
		<label for="busca">Procurar</label>:<input id="busca" type="search" name ="buscanome" placeholder="Digite o nome do produto desejado" size="30">
				<select name="categoria" > 
					  <option value="bebidas">Bebidas</option>
					  <option value="frios">Frios</option>
					  <option value="limpeza">Produtos de Limpeza</option>
				</select>
				<button type="submit" value="pesquisar" class="button2">Pesquisar</button>
				</form>
		</div>
		
				<table class="default" summary="Tabela com Produtos categoria ${categoria} disponíveis de acordo com o filtro.">
					<caption>Produtos diponíveis da categoria ${categoria}s filtrados por ${filtragem}</caption>
					<thead>
					<tr>
						<th rowspan="1" id="nome">Nome do Estabelecimento</th>
						<th rowspan="1"id="bairro">Bairro</th>
						
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${listaProdutos}" var="produto" varStatus="status">
					<tr>
						
						<td headers="nome">
							<a
							href="EstabelecimentoSelecionadoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}"
							class="button3">${estabelecimento.nome_fantasia}
							</a>
						</td>
						<td headers="bairro">${estabelecimento.endereco.bairro}</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
				
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
			
		