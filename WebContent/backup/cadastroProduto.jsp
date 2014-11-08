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
		<!-- Formulário aqui! -->
		<form method="post"
			action="http://localhost:8080/ListaAcessivel/CadastrarProdutoServlet">

			<fieldset>
				<legend>
					<strong>Dados do Produto</strong>
				</legend>
				<label for="descrição">Descrição:</label> <input type="text"
					name="descricao" id="descrição" size=60><br> <label
					for="preço">Preço:</label> <input type="text" name="preco"
					id="preço" size=10> <label for="quantidade">Quantidade:</label>
				<input type="text" name="quantidade" id="quantidade" size=10>
				<p>
					<label for="categoria">Categoria:<br /> <select
						name="categoria" id="categoria">
							<option selected="não selecionado" value="não selecionado">Escolha
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