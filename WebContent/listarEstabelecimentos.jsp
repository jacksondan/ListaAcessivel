	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Estabelecimento"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/script.js"></script>
 		<script src="js/jquery.min.js" type="text/javascript"></script>

	</head>
	<body>
			<%@include  file="headerAdmin.html" %>
			<%@include  file="sidebarAdmin.html" %>
		
				<div id="content2">
					<header class="major">		
						<h2>Lista de Estabelecimentos</h2>
					</header>
					<p class="info">Nessa página existe uma tabela onde é mostrado dados dos 
					estabelecimentos pressione a letra T para ir direto para  a tabela</p>

						<table align="center" class="default" summary="Tabela com lista de estabelecimentos resumida, 
						mostrando nome fantasia, categoria, cidade, bairro e opções do administrador, 
						os dados dos estabelecimentos começão a ser exbidos na 3ª linha da tabela, 
						começando pela coluna de Nome do estabelecimento">
						<caption>Lista de Estabelecimentos</caption>
								<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- Agrupamento das colunas Português e Matemática à célula de cabeçalho Matérias -->
  								</colgroup>
								
								<thead>
								
								<tr>
									<th rowspan="2" id="nome fantasia">Nome Fantasia</th>
									<th rowspan="2" id="categoria">Categoria</th>
									<th rowspan="2" id="cidade">Cidade</th>
									<th rowspan="2" id="bairro">Bairro</th>
									<th colspan="2" id="opção">Opções</th>
									
								</tr>
									<tr>
									<th id="detalhes" axis="opção">Detalhes</th>
									<th id="desativar" axis="opção">Desativar</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listaestabelecimento}" var="estabelecimento" varStatus="status">								
								<tr>

									<td headers="nome fantasia">${estabelecimento.nome_fantasia}</td>
									<td headers="categoria">${estabelecimento.categoria}</td>
									<td headers="cidade">${estabelecimento.endereco.cidade}</td>
									<td headers="bairro">${estabelecimento.endereco.bairro}</td>
									<td headers="opção"><a href="PerfilEstabelecimentoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}" class="button2">Detalhes</a></td>
									<td headers="opção"><a href="ExcluirEstabelecimentoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}" class="button2">Desativar</a></td>
									
								</tr>
								</c:forEach>
								</tbody>	
							
						</table>

				</div>

					<div id="footer2">
				<div id="copyright" class="container">
						<ul class="icons">
							<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
						</ul>
					</div>
				</div>
		</body>
	</html>
