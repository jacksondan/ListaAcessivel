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
						<h2>Lista de Estabelecimentos</h2>
					</header>
				<div>
					
				<fieldset >
					<%
						for(Estabelecimento e : fachada.listarEstabelecimento()){
					%>
						<table class="default" >
								<tr>
									<th>Id</th>
									<th>Nome Fantasia</th>
									<th>Nome Juridico</th>
									<th>Categoria</th>
									<th>CNPJ</th>
									<th>E-mail</th>
									<th>CEP</th>
									<th>Estado</th>
									<th>Cidade</th>
									<th>Bairro</th>
									<th>Rua</th>
									<th>Número</th>
									<th>Referência</th>
									<th>Telefones</th>
									
									</tr>
									
									<tr>
									<td><%= e.getId_usuario()%></td>
									<td><%= e.getNome_fantasia()%></td>
									<td><%=  e.getNome_juridico()%></td>
									<td><%=  e.getCategoria()%></td>
									<td><%= e.getCnpj()%></td>
									<td><%= e.getEmail()%></td>
									<td><%= e.getCep() %></td>
									<td><%=  e.getEstado()%></td>
									<td><%= e.getCidade()%></td>
									<td><%= e.getBairro()%></td>
									<td><%=  e.getRua()%></td>
									<td><%=  e.getNumero()%></td>
									<td><%=  e.getReferencia()%></td>
									<td><%
										for(String tel : e.getTelefones()){
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
			
				<div id="footer2">
				<div id="copyright" class="container">
						<ul class="menu">
							<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
						</ul>
					</div>
				</div>
							
				</div>
		</body>
	</html>
