<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Produto"
 %>
<%@page import= "fafica.listaacessivel.negocios.Fachada"%>
<%@page import= "java.util.ArrayList"%>
    
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Produtos</title>
<link rel="stylesheet" type="text/css" href="css/style.css"> 
</head>
<body>
	<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
										<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt="Logo Lista acessível"  
										style="width:6.5em ;heigth:8.5em;"></a></h1>
						
					</div>
				</div>

			</div>
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Buscar Produtos</h2>
			</header>
			<!-- Conteudo-->
			<fieldset>
			<legend><strong>Lista de Produtos</strong></legend>
			<table >
			<tr>
			<th>Descrição</th>
			<th>Estabelecimento</th>
			<th>Preço</th>
			<th>Marca</th>
			<th>Peso</th>
			<th>Validade</th>
			<th>Deseja Comprar?</th>
			</tr>
			<%
			
			
			%>
			<tr>
			<td>Teste</td><td>Teste</td><td>Teste</td>
			</tr>
			</table>
			</fieldset>
			
				<div class="nav">
										<ul class="menu">
											<li><a href="cadastroUs.jsp" class="button">Editar</a></li>
										</ul>
				</div>
							
			<!-- menu direito-->
			<div id="sidebar">
					
						<div id="nav">
										<ul class="menu">
											<li></li>
											<li><a href="perfil.jsp">Perfil</a></li>
											<li><a href="buscarprodutos.jsp" >Buscar Produto</a></li>
											<li><a href="listarUsuarios.jsp" >Minha Lista</a></li>
											<li><a href="listarEs.jsp" >Sair</a></li>
										</ul>
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