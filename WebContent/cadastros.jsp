
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Cliente"%>
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
				<h1 id="logo">
					<a href="index.jsp"><img src="images/g4314.png"
						alt="Logo Lista acess�vel." style="width: 6.5em; heigth: 8.5em;"></a>
				</h1>

			</div>
		</div>

		<div id="content">
			<header class="major">
				<h2>Cadastrar</h2>
			</header>

			<div id="sidebar">
				<ul class="actions">

					<li><p>
							<a href="cadastroUs.jsp" class="image"><img
								src="images/button4.png" alt=" �cone Cadastrar Cliente"
								style="width: 12em; heigth: 12em;"></a>
						</p></li>
					<li><p>
							<a href="cadastroEs.jsp" class="image"><img
								src="images/button5.png"
								alt="�cone Cadastrar Estabelecimento Com�rcial"
								style="width: 12em; heigth: 12em;"></a>
						</p></li>
			<ul class="menu">
			
					<li><a href="listarUsuarios.jsp" class="button">Listar Usuarios</a></li>
					<li><a href="listarEs.jsp" class="button">Listar Estabalecimentos</a></li>
			</ul>
				</ul>
				
			</div>

		</div>
	</div>
	<div id="right"></div>
	<%@include file="footer.html"%>