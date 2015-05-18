<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Editar Administrador - Início</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <script src="js/script.js"></script>
 <script src="js/jquery.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<%@include file="headerAdmin.html"%>
	<%@include file="sidebarAdmin.jsp" %>
	
		<div id="content2">
			<header class="major">
				<h2>Editar Administrador</h2>
			</header>
			<!-- Formulário  aqui! -->
			<form method="post"
				action="EditarAdministradorServlet">
				<fieldset >
					<legend>Dados de Login</legend>
					<label for="email">E-mail:</label> 
											
						<input type="email" placeholder="Digite o E-mail" name="email" id="email" value="${acessoAdministrador.email}" required="email" size=60 />
				</fieldset>
				<fieldset>
					<legend>Dados Pessoais</legend>
					<label for="nome">Nome Completo</label> <input type="text"
						placeholder="Digite seu nome completo" name="nome" id="nome"
						size=60 value="${acessoAdministrador.nome}"require="nome">
						
						<p><label for="cpf">CPF</label><br> <input type="text"
						placeholder="Digite o CPF do administrador" name="cpf" id="cpf"
						require="cpf" value="${acessoAdministrador.cpf}"size="20">
						</p>

				</fieldset>

				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Confirmar Edição" /></li>
						
					</ul>
				</div>

			</form>
		</div>
		<div id="footer2">
			<div id="copyright" class="container">
				<ul class="icons">
					<li>&copy; TechBin. Todos os direitos reservados.</li>
					<li>Design: <a href="http://facebook.com/Edwardhll">Eduardo
							Andrade</a></li>
				</ul>
			</div>
		</div>
	
</body>
</html>
