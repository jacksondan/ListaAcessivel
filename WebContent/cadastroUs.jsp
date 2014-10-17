<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <script src="js/script.js"></script>

</head>
<body>
	<div id="container">
		<div id="header-wrapper">
			<div id="header" class="container">
				<h1 id="logo">
					<a href="index.jsp"><img src="images/g4314.png"
						alt="Logo Lista acessível" style="width: 6.5em; heigth: 8.5em;"></a>
				</h1>

			</div>
		</div>
		<div id="left"></div>
		<div id="content">
			<header class="major">
				<h2>Cadastre-se</h2>
			</header>
			<!-- Formulário aqui! -->
			<form method="post"
				action="http://localhost:8080/ListaAcessivel/CadastraUs">
				<fieldset>
					<legend>Dados de Login</legend>
					<label for="email">E-mail:</label> <input type="email"
						placeholder="Digite o E-mail" name="email" id="email" size=60>

					<label for="senha">Senha:</label><br> <input type="password"
						placeholder="Digite a Senha" name="senha" id="senha" size=15>
				</fieldset>
				<fieldset>
					<legend>Dados Pessoais</legend>
					<label for="nome">Nome Completo</label> <input type="text"
						placeholder="Digite seu nome completo" name="nome" id="nome"
						size=60> <label for="cpf">CPF:</label><br> <input
						type="text" placeholder="Digite o CPF" name="cpf" id="cpf" size=12><br>
				</fieldset>
				<fieldset>
					<legend>Telefones para Contato</legend>
					<label for="telefone1">Telefone 1:</label><br> <input
						type="text" placeholder="Digite seu telefone" name="telefone1"
						id="telefone1" size=20><br> <label for="telefone 2">Telefone
						2:</label><br> <input type="text" placeholder="Digite seu telefone"
						name="telefone2" id="telefone2" size=20><br>
				</fieldset>

				<fieldset>
					<legend>Dados de Localização</legend>

					<label for="cep">CEP:</label><br> <input type="text"
						placeholder="Digite o CEP" onblur="consultacep(this.value)" name="cep" id="cep" size=20><br>

					<label for="cidade">Cidade:</label><br> <input type="text"
					 name="cidade" id="cidade" size=30><br>
						
					<label for="estado">Estado:</label><br> <input type="text"
					name="estado" id="estado" size=2><br>
						

					<label for="bairro">Bairro:</label><br> <input type="text"
						placeholder="Digite o Bairro" name="bairro" id="bairro" size=30><br>

					<label for="rua">Rua:</label><br> <input type="text"
						placeholder="Digite a Rua" name="rua" id="rua" size=60><br>

					<label for="numero">Número:</label><br> <input type="text"
						placeholder="Digite número" name="numero" id="numero" size=4><br>

					<label for="referencia">Referência:</label><br> <input
						type="text" placeholder="Digite Referência" name="referencia"
						id="referencia" size=30><br>

				</fieldset>

				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Confirmar Cadastro" /></li>
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
