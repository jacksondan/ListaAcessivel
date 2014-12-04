<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>Editar Produto</h2>
		</header>
		<!-- Formulário aqui! -->
		<form method="post" action="EditarProdutoServlet">

			<!--Enviando os id necessarios pelo formulario para montar o objeto no servlet-->
			<input type="hidden" name="id_produto"
				value="${editarProduto.id_produto}"> <input type="hidden"
				name="id_estabelecimento"
				value="${editarProduto.estabelecimento.id_estabelecimento}">

			<fieldset>
				<legend>
					<strong>Dados do Produto</strong>
				</legend>

				<p>
					<label for="descrição">Descrição:</label> <input type="text"
						name="descricao" id="descrição" value="${editarProduto.descricao}"
						size=60>
				</p>
				<p>
					<label for="marca">Marca:</label> <input type="text" name="marca"
						value="${editarProduto.marca}" id="marca" size=55>
				</p>

				<p>
					<label for="valor">Preço:</label> <input type="text" name="valor"
						id="valor" value="${editarProduto.valor}" size=10> <label
						for="quantidade">Código de Barra:</label> <input type="text"
						name="codigo_de_barra" id="codigo_de_barra"
						value="${editarProduto.codigo_barra}" size=20>
				</p>
				<p>
					<label for="quantidade">Quantidade:</label> <input type="text"
						name="quantidade" id="quantidade"
						value="${editarProduto.quantidade}" size=10> <label
						for="quantidade">Peso:</label> <input type="text" name="peso"
						id="peso" value="${editarProduto.peso}" size=10>
				</p>
				<p>
					<label for="categoria">Categoria: <select name="categoria"
						id="categoria">
							<option selected="${editarProduto.categoria}"
								value="${editarProduto.categoria}">${editarProduto.categoria}</option>
							<option value="frios">Frios</option>
							<option value="limpeza">Limpeza</option>
							<option value="Bebidas">Bebidas</option>
					</select>
					</label> <label for="validade">Validade:</label> <input type="date"
						name="validade" id="validade" value="${editarProduto.validade}"
						size=10>
				</p>
			</fieldset>

			<div class="12u">
				<ul class="actions">
					<li><input type="submit" value="Salvar" /></li>
					<li><input type="reset" value="Limpar" /></li>
				</ul>
			</div>


		</form>
	</div>


</body>
</html>