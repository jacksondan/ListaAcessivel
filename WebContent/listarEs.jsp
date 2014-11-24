	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Estabelecimento"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
			<%@include  file="headerAdmin.html" %>
			<%@include  file="sidebarAdmin.html" %>
		
				<div id="content2">
					<header class="major">		
						<h2>Lista de Estabelecimentos</h2>
					</header>
			
					
				<fieldset >
					<c:forEach items="${listaestabelecimento}" var="estabelecimento" varStatus="status">
						<table class="default" >
								<tr>
									<th>Nome Fantasia</th>
									<th>Categoria</th>
									<th>Cidade</th>
									<th>Bairro</th>
									<th>Telefones</th>
								</tr>
																	
								<tr>
									
									<td>${estabelecimento.nome_fantasia}</td>
									<td>${estabelecimento.nome_juridico}</td>
									<td>${estabelecimento.categoria}</td>
									<td>${estabelecimento.endereco.cidade}</td>
									<td>${estabelecimento.endereco.bairro}</td>
									<td><a href="EditarEstabelecimentoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}" class="button2">Editar</a></td>
									<td><a href="ExcluirEstabelecimentoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}" class="button2">Excluir</a></td>
									<td>
										<ol>
										<c:forEach items="${estabelecimento.telefones}" var="telefone" varStatus="status">
											<li>${telefone}</li>
										</c:forEach>
										</ol>
									</td>
								</tr>	
						</table>
					</c:forEach>	
					</fieldset>
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
