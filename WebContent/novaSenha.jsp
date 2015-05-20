<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Lista Acessível -Nova Senha</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<div id="header-wrapper">
				<div id="header" class="container">
						<h1 id="logo2"><a href="index.jsp"><img src="images/ic_logo_web.png" alt= "Logo Lista acessível"  style="width:6.6em ;heigth:16em;"></a></h1>

					</div>
				</div>
				


	<div id="content">
		<header class="major">
			<h2>Definição de Nova senha</h2>
		</header>

		<form method="post" name="f1"
			action="#">
			<p style="text-align: center; color: green;">${mensagem}</p>
			<fieldset>
				<legend>Digite a Nova Senha</legend>

				<p>
					<label for="senhaNova">Nova Senha</label><br> <input type="password"
						placeholder="Digite a nova Senha" name="senhaNova" id="senhaNova" size=30 required="senhaNova">
				</p>
				<p>
					<label for="confirmarSenha">Confirmar Senha</label><br> <input type="password"
						placeholder="Digite a nova Senha Novamente" name="confirmarSenha" id="confirmarSenha" size=30 required="confirmarSenha" onblur="validarSenha()">
				</p>
				

			</fieldset>
			<div class="12u">
				<ul class="actions">
					<li><input type="submit" class="button3" value="Salvar Nova Senha" onblur="validarSenha()"  onClick="validarSenha()"/></li>
					<!-- <li><input type="reset" class="button3" value="Limpar" ></li> -->

				</ul>
			</div>
		</form>
	</div>
	<div id="footer">
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