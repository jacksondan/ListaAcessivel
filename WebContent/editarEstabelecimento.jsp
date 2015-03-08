<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
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

</head>
<body>
	<%@include file="headerEstabelecimento.html"%>

	<%@include file="sidebarEstabelecimento.html"%>
	<div id="content2">
		<header class="major">
			<h2>Editar Estabelecimento</h2>
		</header>

		


		<form method="post"
			action="http://localhost:8080/ListaAcessivel/EditarEstabelecimentoServlet">
			
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
				<label for="email">E-mail:</label>  
					<input type="email" name="email" id="email" value="${editarEstabelecimento.email}" size=60 required="email">
				<label for="nome_fantasia">Nome Fantasia:</label> <input type="text"
					name="nome_fantasia" id="nome_fantasia"
					value="${editarEstabelecimento.nome_fantasia}" size=60 required="nome_fantasia"> <label
					for="nome_juridico">Nome Jurídico:</label> <input type="text"
					name="nome_juridico" id="nome_juridico"
					value="${editarEstabelecimento.nome_juridico}" size=60 required="nome_juridico"> <label
					for="cnpj">CPNPJ:</label><br> <input type="text" name="cnpj"
					id="cnpj" value="${editarEstabelecimento.cnpj}" size=12  required="cnpj"><br>

				Categoria:<br> <select name="categoria">
					<option selected="${editarEstabelecimento.categoria}"
						value="${editarEstabelecimento.categoria}">${editarEstabelecimento.categoria}</option>
					<option>Supermercado</option>
					<option>Padaria</option>
					<option>Farmácia</option>
					<option>Livraria</option>
					
					
				</select><br>
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" name="telefone1" id="telefone1"
					value="${editarEstabelecimento.telefones[0]}" size=20 required="telefone1"><br> <label
					for="telefone 2">Telefone 2:</label><br> <input type="text"
					name="telefone2" id="telefone2" value="${editarEstabelecimento.telefones[1]}"
					size=20><br>
			</fieldset>
			<fieldset>
				<legend>Dados de Localização</legend>
				<p>
					<label for="cep">CEP:</label><br> <input type="text"
						name="cep" id="cep" value="${editarEstabelecimento.endereco.cep }"  onblur="consultacep(this.value)" size=20 required="cep"><br>
						<label for="estado">Estado:</label><br> <input type="text"
						name="estado" id="estado" value="${editarEstabelecimento.endereco.estado}" size=2><br>
					<label for="cidade">Cidade:</label><br> <input type="text"
						name="cidade" id="cidade" value="${editarEstabelecimento.endereco.cidade}"
						size=30><br> <br> <label for="bairro">Bairro:</label><br>
					<input type="text" name="bairro" id="bairro"
						value="${editarEstabelecimento.endereco.bairro}" size=30 required="bairro"><br>

					<label for="rua">Rua:</label><br> <input type="text"
						name="rua" id="rua" value="${editarEstabelecimento.endereco.rua}" size=60 required="rua"><br>

					<label for="numero">Número:</label><br> <input type="text"
						name="numero" id="numero" value="${editarEstabelecimento.endereco.numero}"
						size=4 required="numero"><br>
						
						<label
					for="complemento">Complemento:</label><br> 
					<input type="text"
					name="complemento" id="complemento" value="${editarEstabelecimento.endereco.complemento}" size=60 required="complemento"><br>
						
						 <label for="referencia">Referência:</label><br>
					<input type="text" name="referencia" id="referencia"
						value="${editarEstabelecimento.endereco.referencia}" size=60 required="referencia"><br>
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