<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
										<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt="Logo Lista acess�vel"  style="width:6.5em ;heigth:8.5em;"></a></h1>
				
						
					</div>
				</div>
			<div id="left"></div>
			<div id="content">
				<header class="major">		
					<h2>Cadastro de Produtos</h2>
				</header>
			<!-- Formul�rio aqui! -->
			<form method="post" action="http://localhost:8080/ListaAcessivel/CadastraPr">
			
				
				<fieldset >
				<legend><strong>Dados do Produto</strong></legend>
				<label for="descri��o">Descri��o:</label>
				<input type="text"  name="descricao" id="descri��o" size=60>
				
			
				
				<label for="pre�o">Pre�o:</label>
				<input type="text"  name="preco" id="pre�o" size=10>
					<p>
						<label for="categoria">Categoria:<br />
						<select name="estado" id="categoria">
						<option selected="n�o selecionado" value="n�o selecionado">Escolha a categoria</option>
						<option value="frios">Frios</option>
						<option value="limpeza">Limpeza</option>
						<option value="Bebidas">Bebidas</option>
						</select>
						</label>
						</p>
				</fieldset>
					
						<div class="12u">
							<ul class="actions">
								<li><input type="submit" value="Confirmar Cadastro" /></li>
								<li><input type="reset" value="Limpar" /></li>
							</ul>
						</div>
						
					
			</form>
			</div>
			<div id="right"></div>
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