<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Produto"%>
	    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body>
<%@include file="headerEstabelecimento.html" %>

<%@include file="sidebarEstabelecimento.html" %>

			
				<div id="content2">
					<header class="major">		
						<h2>Lista de Produtos</h2>
					</header>
				<div>
					
					<fieldset >
					<legend>Produtos</legend>
					
					<c:forEach items="${listaProdutos}" var="produto" varStatus="status">
					
						<table class="default" >
								<tr>
									<th>Id:</th>
									<th>Descrição:</th>
									<th>ID_Estabelecimento:</th>
									<th>Preço:</th>
									<th>Categoria:</th>
									<th>Quantidade</th>
									<th>Editar</th>
									<th>Excluir</th>
									</tr>
								
									<tr>
									<td>${produto.id_produto}</td>
									<td>${produto.descricao_produto}</td>
									<td>${produto.id_estabelecimento}</td>
									<td>${produto.preco_produto}</td>
									<td>${produto.categoria}</td>
									<td>${produto.quantidade_produto}</td>
									<td><a href="EditarProdutoServlet?id_produto=${produto.id_produto}" class="button2">Editar</a></td>
									<td><a href="ExcluirProdutoServlet?id_produto=${produto.id_produto}" class="button2">Excluir</a></td>
									
									</tr>
									</table>
				</c:forEach>
						
					</fieldset>
							
					
				</div>
				</div>
				
		</body>
	</html>