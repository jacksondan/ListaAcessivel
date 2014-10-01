<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Produto"%>
	<%@page import= "fafica.listaacessivel.negocios.Fachada"%>
	<%@page import= "fafica.listaacessivel.negocios.IFachada"%>
	<%@page import= "fafica.listaacessivel.negocios.entidades.Estabelecimento"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	<%
		IFachada fachada = Fachada.getInstance(); 
	%>
<%@include file="headerEs.html" %>

<%@include file="sidebarEs.html" %>
	
		
			
				<div id="content">
					<header class="major">		
						<h2>Lista de Produtos</h2>
					</header>
				<div>
					
					<fieldset >
					<legend>Produtos</legend>
					<%
						Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
						for(Produto p : fachada.listarProdutosDoEstabelecimento(estabelecimento)){
					%>
						<table class="default" >
								<tr>
									<th>Id:</th>
									<th>Descrição:</th>
									<th>ID_Estabelecimento:</th>
									<th>Preço:</th>
									<th>Categoria:</th>
									<th>Editar</th>
									<th>Excluir</th>
									</tr>
								
							
									<tr>
									<td><%= p.getId_produto()%></td>
									<td><%= p.getDescricao_produto()%></td>
									<td><%= p.getId_estabelecimento()%></td>
									<td><%= p.getPreco_produto()%></td>
									<td><%= p.getCategoria()%></td>
									<td><a href="EditarProduto?id_produto=<%=p.getId_produto()%>" class="button2">Editar</a></td>
									<td><a href="ExcluirProduto?id_produto=<%=p.getId_produto()%>" class="button2">Excluir</a></td>
									
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