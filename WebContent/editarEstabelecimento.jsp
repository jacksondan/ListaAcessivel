<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Editar Estabelecimento</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
<script>
	//script da mascara
	jQuery(function($) {
		$("#cep").mask("99999-999");
		$("#telefone1").mask("(99)9999-9999");
		$("#telefone2").mask("(99)9999-9999");
		$("#cnpj").mask("999.999.999-99");
	});
</script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<%@include file="headerEstabelecimento.html"%>
	<%@include file="sidebarEstabelecimento.jsp"%>
	<div id="content2">
		<header class="major">
			<h2>Editar Estabelecimento</h2>
		</header>

		


		<form method="post"
			action="http://localhost:8080/ListaAcessivel/EditarEstabelecimentoServlet">
			
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
				<label for="email">E-mail:</label>  
					<input type="email" name="email" id="email" value="${acessoEstabelecimento.email}" size=60 required="email">
				
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" name="telefone1" id="telefone1"
					value="${acessoEstabelecimento.telefones[0]}" size=20 required="telefone1"><br> <label
					for="telefone 2">Telefone 2:</label><br> <input type="text"
					name="telefone2" id="telefone2" value="${acessoEstabelecimento.telefones[1]}"
					size=20><br>
			</fieldset>
			

			<div class="12u">
				<ul class="actions">
					<li><input type="submit" value="Salvar" /></li>

				</ul>
			</div>


		</form>
	</div>


</body>
</html>