	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Usuario"%>
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
						for(Usuario u : fachada.listarUsuario()){
					%>
						<table class="default" >
								<tr>
									<th>Id</th>
									<th>Nome</th>
									<th>CPF</th>
									<th>Email</th>
									<th>Cidade</th>
									<th>Estado</th>
									<th>Rua</th>
									<th>Bairro</th>
									<th>Numero</th>
									<th>Referencia</th>
									<th>Cep</th>
									<th>Telefones</th>
									</tr>
									
									<tr>
									<td><%= u.getId_usuario()%></td>
									
									<td><%= u.getNome()%></td>
									<td><%= u.getCpf()%></td>
									<td><%= u.getEmail()%></td>
									<td><%= u.getCidade()%></td>
									<td><%= u.getEstado()%></td>
									<td><%= u.getRua()%></td>
									<td><%= u.getBairro()%></td>
									<td><%= u.getNumero()%></td>
									<td><%= u.getReferencia()%></td>
									<td><%= u.getCep()%></td>
									<td><%
										for(String tel : u.getTelefones()){
									%>
											<%=tel+","%>
									<%
										}
									%></td>
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