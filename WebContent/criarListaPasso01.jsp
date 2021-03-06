<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<head>
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista Acess�vel - Criar Lista Passo 01</title>
	<link rel="stylesheet" type="text/css" href="css/style.css"> 
	<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<!-- Verificando se a sess�o esta v�lida -->
	<!-- <c:if test="${empty acessoCliente}">
		<h1>Testando DIRECIONAMENTO NA PAGINA</h1> 
		<%--
			String mensagem = "Sess�o encerrada ou expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		--%>
	</c:if> -->
   
<%@include file="headerCliente.html" %>

		<div id="content">
					<header class="major">		
						<h2>Criar Lista Passo - 01  </h2>
						<h3>Selecione a Categoria do Estabelecimento</h3>
					</header>
					
<div id="sidebar">

<ul class="actions2">							
	<li><p><a href="CriarListaPasso2Servlet?categoria=supermercado" class="image"><img src="images/ic_mercado.png" alt="Categoria Super Mercado, clicando aqui voce vai para a Categoria de"style="width:12em ;heigth:12em;">Supermercado</a></p></li>
	<li><p><a href="CriarListaPasso2Servlet?categoria=padaria" class="image"><img src="images/ic_padaria.png" alt="Categoria Padaria, clicando aqui voce vai para a Categoria de"style="width:12em ;heigth:12em;">Padaria</a></p></li>
	<li><p><a href="CriarListaPasso2Servlet?categoria=farmacia" class="image"><img src="images/ic_farmacia.png" alt="Categoria Farm�cia, clicando aqui voce vai para a Categoria de "style="width:12em ;heigth:12em;">Farm�cia</a></p></li>
		<li><p><a href="CriarListaPasso2Servlet?categoria=livraria" class="image"><img src="images/ic_livraria.png" alt="Categoria Livraria, clicando aqui voce vai para a Categoria de "style="width:12em ;heigth:12em;">Livraria</a></p></li>
</ul>
		</div>			
</div>

<%@include file="footer.html" %>
