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
					<c:forEach items="${listaestabelecimento}" var="estabelecimento" varStatus="status">
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
									<td>${estabelecimento.id_usuario}</td>
									<td>${estabelecimento.nome_fantasia}</td>
									<td>${estabelecimento.nome_juridico}</td>
									<td>${estabelecimento.categoria}</td>
									<td>${estabelecimento.cnpj}</td>
									<td>${estabelecimento.email}</td>
									<td>${estabelecimento.cep}</td>
									<td>${estabelecimento.estado}</td>
									<td>${estabelecimento.cidade}</td>
									<td>${estabelecimento.bairro}</td>
									<td>${estabelecimento.rua}</td>
									<td>${estabelecimento.numero}</td>
									<td>${estabelecimento.referencia}</td>
									<td>
										<ul>
										<c:forEach items="${estabelecimento.telefones}" var="telefone" varStatus="status">
											<li>${telefone}</li>
										</c:forEach>
										</ul>
									</td>
								</tr>	
						</table>
					</c:forEach>	
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
