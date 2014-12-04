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

	<%@include file="headerEstabelecimento.html"%>

	<%@include file="sidebarEstabelecimento.html"%>


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
				<p>
					<label for="descrição">Descrição:</label> <input type="text"
						name="descricao" id="descrição" size=60>
				</p>
				<p>
					<label for="marca">Marca:</label> <input type="text" name="marca"
						id="marca" size=55>
				</p>

				<p>
					<label for="valor">Preço:</label> <input type="text" name="valor"
						id="valor" size=10> <label for="quantidade">Código
						de Barra:</label> <input type="text" name="codigo_de_barra"
						id="codigo_de_barra" size=20>
				</p>
				<label for="quantidade">Quantidade:</label> <input type="text"
					name="quantidade" id="quantidade" size=10> <label
					for="peso">Peso:</label> <input type="text" name="peso" id="peso"
					size=10>
				<p>
					<label for="categoria">Categoria:<select name="categoria"
						id="categoria">
							<option selected="não selecionado" value="não selecionado">Escolha
								a categoria</option>
							<option value="frios">Frios</option>
							<option value="limpeza">Limpeza</option>
							<option value="Bebidas">Bebidas</option>
							<option value="Alimentos">Alimentos</option>
					</select>
					</label> <label for="validade">Validade:</label> <input type="date"
						name="validade" id="validade" size=10>
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