
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Cliente"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">a
</head>
<body>
	<div id="container">
		<div id="header-wrapper">
			<div id="header" class="container">
				<h1 id="logo">
					<a href="index.jsp"><img src="../images/g4314.png"
						alt="Logo Lista acess�vel, clicando aqui retornara para o menu inicial." style="width: 6.5em; heigth: 8.5em;"></a>
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
							<a href="cliente/cadastroCliente.jsp" class="image"><img
								src="../images/button4.png" alt=" �cone Cadastrar Cliente"
								style="width: 12em; heigth: 12em;"></a>
						</p></li>
					<li><p>
							<a href="estabelecimento/cadastroEstabelecimento.jsp" class="image"><img
								src="../images/button5.png"
								alt="�cone Cadastrar Estabelecimento Com�rcial"
								style="width: 12em; heigth: 12em;"></a>
						</p></li>
						
			<ul class="actions">
			<br>
					<li><a href="ListarClienteServlet" class="button3">Listar Usuarios</a></li>
					<li><a href="ListarEstabelecimentoServlet" class="button3">Listar Estabalecimentos</a></li>
			</ul>
				</ul>
				
			</div>

		</div>
	</div>
	<div><br></div>
	<%@include file="../footer.html"%>