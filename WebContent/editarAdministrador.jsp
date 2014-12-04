<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Editar Administrador - In�cio</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <script src="js/script.js"></script>
 <script src="js/jquery.min.js" type="text/javascript"></script>

</head>
<body>
	<%@include file="headerAdmin.html"%>
	<%@include file="sidebarAdmin.html"%>
	
		<div id="content2">
			<header class="major">
				<h2>Editar Administrador</h2>
			</header>
			<!-- Formul�rio  aqui! -->
			<form method="post"
				action="EditarAdministradorServlet">
				<fieldset >
					<legend>Dados de Login</legend>
					<label for="email">E-mail:</label> 
						<input type = "hidden" name="id_administrador" id="email" value="${editarAdministrador.id_usuario}" />
						<input type = "hidden" name="senha" id="email" value="${editarAdministrador.senha}" />
						
						<input type="email" placeholder="Digite o E-mail" name="email" id="email" value="${editarAdministrador.email}" required="email" size=60 />
				</fieldset>
				<fieldset>
					<legend>Dados Pessoais</legend>
					<label for="nome">Nome Completo</label> <input type="text"
						placeholder="Digite seu nome completo" name="nome" id="nome"
						size=60 value="${editarAdministrador.nome}"require="nome">
						
						<p><label for="cpf">CPF</label><br> <input type="text"
						placeholder="Digite o CPF do administrador" name="cpf" id="cpf"
						require="cpf" value="${editarAdministrador.cpf}"size="20">
						</p>

				</fieldset>

				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Confirmar Edi��o" /></li>
						<li><input type="reset" value="Limpar" /></li>
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
	</div>
</body>
</html>
