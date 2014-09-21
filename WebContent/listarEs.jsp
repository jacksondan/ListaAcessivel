	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Estabelecimento"%>
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
						<h2>Cadastros</h2>
					</header>
				<div>
					
					<fieldset >
					<%
						for(Estabelecimento e : fachada.listarEstabelecimento()){
					%>
						<table class="default">
								<tr>
									<th>Id</th><td><%= e.getId_estabelecimento()%></td>
								</tr>
								<tr>
									<th>Nome Fantasia</th><td><%= e.getNome_fantasia()%></td>
								</tr>
								<tr>
									<th>Nome Jurídico</th><td><%= e.getNome_juridico()%></td>
								</tr>
								<tr>
									<th>Categoria</th><td><%= e.getCategoria()%></td>
								</tr>
								<tr>	
									<th>CNPJ</th><td><%= e.getCNPJ()%></td>
								</tr>
								<tr>	
									<th>E-mail</th><td><%= e.getEmail()%></td>
								</tr>
								<tr>	
									<th>Rua</th><td><%= e.getRua()%></td>
								</tr>
								<tr>	
									<th>Número</th><td><%= e.getNumero()%></td>
								</tr>
								<tr>	
									<th>Bairro</th><td><%= e.getBairro()%></td>
								</tr>
								<tr>	
									<th>Cidade</th><td><%= e.getCidade()%></td>
								</tr>
								<tr>	
									<th>Estado</th><td><%= e.getEstado()%></td>
								</tr>
								<tr>	
									<th>CEP</th><td><%= e.getCep()%></td>
								</tr>
								<tr>	
									<th>Referência</th><td><%= e.getReferencia()%></td>
								</tr>
								<tr>
								<th>Telefones</th><td>
									<%
										for(String tel : e.getTelefones()){
									%>
											<%=tel+"   "%>
									<%
										}
									%>
									</td>
								</tr>
								</br> </br>
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
						<ul class="menu">
							<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
						</ul>
					</div>
				</div>
							
				</div>
		</body>
	</html>
