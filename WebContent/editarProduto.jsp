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
<%@include file="headerEs.html" %>

<%@include file="sidebarEs.html" %>
			
			<div id="content2">
				<header class="major">		
					<h2>Editar  Produto</h2>
				</header>
			<!-- Formulário aqui! -->
			<form method="post" action="EditarProdutoServlet">
				
				<!--Enviando os id necessarios pelo formulario para montar o objeto no servlet-->
				<input type="hidden"  name="id_produto" value="${editarProduto.id_produto}">
				<input type="hidden"  name="id_estabelecimento" value="${editarProduto.id_estabelecimento}">
				
				<fieldset >
				<legend><strong>Dados do Produto</strong></legend>
				<label for="descrição">Descrição:</label>
				<input type="text"  name="descricao" id="descrição" value="${editarProduto.descricao_produto}"size=60>
				
				<label for="preço">Preço:</label>
				<input type="text"  name="preco" id="preço" value="${editarProduto.preco_produto}" size=10>
				<label for="quantidade">Quantidade:</label>
				<input type="text"  name="quantidade" id="quantidade" value="${editarProduto.quantidade_produto}" size=10>
					<p>
						<label for="categoria">Categoria:<br />
						<select name="categoria" id="categoria">
						<option selected="${editarProduto.categoria}" value="${editarProduto.categoria}">${editarProduto.categoria}</option>
						<option value="frios">Frios</option>
						<option value="limpeza">Limpeza</option>
						<option value="Bebidas">Bebidas</option>
						</select>
						</label>
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