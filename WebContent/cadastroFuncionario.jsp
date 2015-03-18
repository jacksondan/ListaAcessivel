<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista Acessível - Cadastro Funcionário</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <script src="js/script.js"></script>
 <script src="js/jquery.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<%@include file="headerEstabelecimento.html"%>

	<%@include file="sidebarEstabelecimento.html"%>
	
		<div id="content2">
			<header class="major">
				<h2>Cadastrar Funcionário</h2>
			</header>
			<!-- Formulário  aqui! -->
			<form method="post"
				action="CadastrarFuncionarioServlet">
				<fieldset >
					<legend>Dados de Login</legend>
					<label for="email">E-mail:</label> <input type="email"
						placeholder="Digite o E-mail" name="email" id="email"  required="email" size=60>

					<label for="senha">Senha:</label><br> <input type="password"
						placeholder="Digite a Senha" name="senha" id="senha" size=15 required="senha">
				</fieldset>
				<fieldset>
					<legend>Dados Pessoais</legend>
					<label for="nome">Nome Completo</label> <input type="text"
						placeholder="Digite seu nome completo" name="nome" id="nome"
						size=60 require="nome">
						
						<p><label for="matricula">Matrícula</label><br> <input type="text"
						placeholder="Digite a matricula do funcionario" name="matricula" id="matricula"
						require="matricula" size="20">
						</p>

				</fieldset>

				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Adicionar Funcionário" /></li>
						<!-- <li><input type="reset" value="Limpar" /></li>-->
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
