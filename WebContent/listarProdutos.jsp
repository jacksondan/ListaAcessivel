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
			<div id="container">
					<div id="header-wrapper">
					<div id="header" class="container">
							<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt="Logo Lista acessível"  style="width:6.5em ;heigth:8.5em;"></a></h1>
	
						</div>
					</div>
				<div id="left"></div>
				<div id="content">
					<header class="major">		
						<h2>Lista de Produtos</h2>
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
									<th>Editar</th>
									<th>Excluir</th>
									</tr>
								
							
									<tr>
									<td><%= p.getId_produto()%></td>
									<td><%= p.getDescricao_produto()%></td>
									<td><%= p.getId_estabelecimento()%></td>
									<td><%= p.getPreco_produto()%></td>
									<td><%= p.getCategoria()%></td>
									<td><a href="EditarProduto?codigo=<%= p.getId_produto()%>" class="button2">Editar</a></td>
									<td><a href="ExcluirProduto?codigo=<%= p.getId_produto()%>" class="button2">Excluir</a></td>
									
									</tr>
									</table>
					<% 
						}
					%>	
						
					</fieldset>
							
					
				</div>
				</div>
				<div id="right"></div>
				<div id="footer">
				<div id="copyright" class="container">
						<ul class="icons">
							<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
						</ul>
					</div>
				</div>
							
				</div>
		</body>
	</html>