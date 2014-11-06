	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Produto"%>
	<%@page import= "fafica.listaacessivel.negocios.Fachada"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	<%
		Fachada fachada = Fachada.getInstance(); 
	%>
				
	
				<div id="content">
					<header class="major">		
						<h2>Criar Lista</h2>
					</header>
				<div>
					
					<fieldset >
					<legend>Produtos</legend>
					<%
						for(Produto p : fachada.listarProduto()){
					%>
						<table class="default" >
								<tr>
									<th>Id:</th>
									<th>Descrição:</th>
									<th>ID_Estabelecimento:</th>
									<th>Preço:</th>
									<th>Categoria:</th>
									<th>Ação</th>
								
									</tr>
				
									<tr>
									<td><%= p.getId_produto()%></td>
									<td><%= p.getDescricao_produto()%></td>
									<td><%= p.getEstabelecimento().getId_estabelecimento()%></td>
									<td><%= p.getPreco_produto()%></td>
									<td><%= p.getCategoria()%></td>
									<td><a href="CadastrarLista?codigo=<%= p.getId_produto()%>" class="button2">Incluir</a></td>

									</tr>
									</table>
					<% 
						}
					%>					
					</fieldset>
	
				</div>
				</div>
				
		</body>
	</html>