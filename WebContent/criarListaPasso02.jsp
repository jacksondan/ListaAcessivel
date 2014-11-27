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
			<h2>Criar Lista Passo - 02</h2>	
		</header>
		<div id="filtro">
			<button   onclick="window.location.href='CriarListaPasso1Servlet?filtragem=${filtroContrario}&categoria=${categoria}'" class="button" >Filtrar por ${filtroContrario}</button>

		</div>
				<table class="default" summary="Tabela com estabelecimentos da categoria ${categoria} disponíveis de acordo com o filtro.">
					<caption>Tabela de ${categoria}s filtrados por ${filtragem}</caption>
					<thead>
					<tr>
						<th rowspan="1" id="nome">Nome do Estabelecimento</th>
						<th rowspan="1"id="bairro">Bairro</th>
						
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${listaEstabelecimentos}" var="estabelecimento"
				varStatus="status">
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
			
		