<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NomeCliente - Inicio</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@include file="headerUs.html"%>


	<div id="content">
		<header class="major">
			<h2>Editar Senha</h2>
		</header>

		<form method="post"
			action="http://localhost:8080/ListaAcessivel/EditarSenhaClienteServlet">
			<p style="text-align: center; color: green;">${mensagem}</p>
			<fieldset>
				<legend>Edição de Senha</legend>



				<p>
					<label for="senhaAtual">Senha Atual</label><br>
					<input type="password" placeholder="Digite a Senha Atual"
						name="senhaAtual" id="senhaAtual" size=30>
				</p>

				<p>
					<label for="senhaNova">Nova Senha</label><br> <input
						type="password" placeholder="Digite a Senha" name="senhaNova"
						id="senhaNova" size=30>
				</p>
				<p>
					<label for="confirmarSenha">Confirmar Senha</label><br> <input
						type="password" placeholder="Digite a Senha Novamente"
						name="confirmarSenha" id="confirmarSenha" size=30>
				</p>

			</fieldset>
			<div class="12u">
				<ul class="actions">
					<li><input type="submit" class="button3"
						value="Salvar Nova Senha" /></li>

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