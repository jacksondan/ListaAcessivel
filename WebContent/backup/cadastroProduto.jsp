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

	<!--  <%@include file="headerEstabelecimento.html"%>

	<%@include file="sidebarEstabelecimento.html"%>
	-->

	<div id="content2">
		<header class="major">
			<h2>Cadastro de Produtos</h2>
			<h4>${mensagem}</h4> 
		</header>
		<!-- Formul�rio aqui! -->
		<form method="post"
			action="http://localhost:8080/ListaAcessivel/CadastrarProdutoServlet">

			<fieldset>
				<legend>
					<strong>Dados do Produto</strong>
				</legend>
				<label for="descri��o">Descri��o:</label> <input type="text"
					name="descricao" id="descri��o" size=60><br> <label
					for="pre�o">Pre�o:</label> <input type="text" name="preco"
					id="pre�o" size=10> <label for="quantidade">Quantidade:</label>
				<input type="text" name="quantidade" id="quantidade" size=10>
				<p>
					<label for="categoria">Categoria:<br /> <select
						name="categoria" id="categoria">
							<option selected="n�o selecionado" value="n�o selecionado">Escolha
								a categoria</option>
							<option value="frios">Frios</option>
							<option value="limpeza">Limpeza</option>
							<option value="Bebidas">Bebidas</option>
							<option value="Alimentos">Alimentos</option>
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

</body>
</html>