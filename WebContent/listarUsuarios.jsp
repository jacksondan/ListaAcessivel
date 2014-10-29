	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	
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
					<c:forEach items="${listacliente}" var="listacliente" varStatus="status">
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
									<td>${listacliente.id_usuario}</td>
									
									<td>${listacliente.nome}</td>
									<td>${listacliente.cpf}</td>
									<td>${listacliente.email}</td>
									<td>${listacliente.cidade}</td>
									<td>${listacliente.estado}</td>
									<td>${listacliente.rua}</td>
									<td>${listacliente.bairro}</td>
									<td>${listacliente.numero}</td>
									<td>${listacliente.referencia}</td>
									<td>${listacliente.cep}</td>
									<td>
										<ol>
										<c:forEach items="${listacliente.telefones}" var="telefone" varStatus="status">
											<li>${telefone}</li>
										</c:forEach>
										</ol>
									</td>
								</tr>	
						</table>
					</c:forEach>	
						
					</fieldset>
	
				</div>
				</div>			
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