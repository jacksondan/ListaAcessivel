<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Lista Acessível- Recuperar Senha</title>
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
			<h2>Recuperação de Senha</h2>
		</header>

		<form method="post" name="f1"
			action="#">
			<p style="text-align: center; color: green;">${mensagem}</p>
			<div id=info><p class="info2">Informe seu email para enviarmos um link para definir uma nova senha.</p></div>
			<fieldset>
				<legend>Recuperar  Senha</legend>
				
				<p class="info2">
					<label for="email">Email</label><br><input type="email"
						placeholder="Digite seu  Email" name="email" id="email" size=30 required="email">
				</p>

			
				

			</fieldset>
			<div class="12u">
				<ul class="actions">
					<li><input type="submit" class="button3" value="Enviar"/></li>
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