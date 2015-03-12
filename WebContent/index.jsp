<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Acessível - Início</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
						<h1 id="logo2"><a href="index.jsp"><img src="images/ic_logo_web.png" alt= "Logo Lista acessível"  style="width:6.6em ;heigth:16em;"></a></h1>

					</div>
				</div>
				
			
			<div id="content">
				
				<div id="homeEsquerda">
				<header class="major">		
					
				</header>
			
				<div id=body>			
				<p align="center">A <i> Lista Acessível </i> tem como objetivo contribuir para que pessoas com 
				deficiência visual possam realizar compras através da criação de listas 
				de produtos de estabelecimentos comerciais por um serviço online.</p>
				<p align="center">O usuário terá acesso a um acervo de produtos disponibilizados pelos 
				próprios estabelecimentos, esses estabelecimentos serão selecionados de 
				acordo com a localização do usuário para melhor comodidade e disponibilidade 
				de entregas em domicílio.</p>
				
				<center><img src="images/homei.jpg" alt="imagem ilustrativa, mostrandando uma cesta de compras e um teclado no fundo" style="width:52.5%;"/></center>
				</div>
	
			
			</div>
			<div id="homeDireita">
				<header class="major">		
					<h3>Login</h3>
				</header>
				<p style="text-align:center;color:red;">${erroLogin}</p>
				<p style="text-align:center;color:green;">${mensagem}</p>

			<form method="post" action="IndexServlet">
			<fieldset >
			<legend>Dados de Login</legend>
				<p><label for="email">E-mail ou CNPJ</label>
				<input type="text" placeholder="Digite o Email ou CNPJ" name="email" id="email" size=40 required>  </p>
				
				<p><label for="senha">Senha</label><br>
				<input type="password" placeholder="Digite a Senha" name="senha" id="senha" size=40 required>  </p>
			</fieldset>
						<div class="12u">
										<ul class="actions">
											<li><input type="submit"  value="Entrar" alt="Aperte Enter Para entrar"/></li>
											<li><a href="cadastroCliente.jsp" class="button3" alt="Aperte Enter para um novo Cadastro">Cadastrar-se</a></li>
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
