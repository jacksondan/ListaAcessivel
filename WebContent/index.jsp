<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaAcessivel - Página deLogin</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
						<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt= "Logo Lista acessível"  style="width:6.5em ;heigth:8.5em;"></a></h1>

					</div>
				</div>
				
			<div id="left"></div>
			<div id="content">
				<header class="major">		
					<h2>Login</h2>
				</header>
			<div>
				<p style="text-align:center;color:red;">${erroLogin}</p>
				<p style="text-align:center;color:green;">${mensagem}</p>

			<form method="post" action="http://localhost:8080/ListaAcessivel/Index">
			<fieldset >
			<legend>Dados de Login</legend>
				<p><label for="email">E-mail ou CNPJ</label>
				<input type="email" placeholder="Digite o Email ou CNPJ" name="email" id="email" size=50></p>
				
				<p><label for="senha">Senha</label><br>
				<input type="password" placeholder="Digite a Senha" name="senha" id="senha" size=15></p>
			</fieldset>
						<div class="12u">
										<ul class="actions">
											<li><input type="submit"  value="Entrar" alt="Aperte Enter Para entrar"/></li>
											<li><a href="cadastroCliente.jsp" class="button3" alt="Aperte Enter para um novo Cadastro">Cadastrar</a></li>
										</ul>
						</div>
			</form>
			</div>
			</div>
			<div id="footer">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
						
			</div>
		
</body>
</html>
