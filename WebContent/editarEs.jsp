<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<%@include file="headerEs.html"%>

	<%@include file="sidebarEs.html"%>
	<div id="content2">
		<header class="major">
			<h2>Editar Estabelecimento</h2>
		</header>

		


		<form method="post"
			action="http://localhost:8080/ListaAcessivel/EditarEstabelecimento">
			
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
				<label for="email">E-mail:</label>  
					<input type="email" name="email" id="email" value="${editarEstabelecimento.email}" size=60>
					
				<input type="hidden" name="id_estabelecimento" id="id" value="${editarEstabelecimento.id_usuario}">
				<label for="nome_fantasia">Nome Fantasia:</label> <input type="text"
					name="nome_fantasia" id="nome_fantasia"
					value="${editarEstabelecimento.nome_fantasia}" size=60> <label
					for="nome_juridico">Nome Jur�dico:</label> <input type="text"
					name="nome_juridico" id="nome_juridico"
					value="${editarEstabelecimento.nome_juridico}" size=60> <label
					for="cnpj">CPNPJ:</label><br> <input type="text" name="cnpj"
					id="cnpj" value="${editarEstabelecimento.cnpj}" size=12><br>

				Categoria:<br> <select name="categoria">
					<option selected="${editarEstabelecimento.categoria}"
						value="${editarEstabelecimento.categoria}">${editarEstabelecimento.categoria}</option>
					<option>Supermercado</option>
					<option>Shopping</option>
					<option>Frigor�fico</option>
					<option>Fast-Food</option>
				</select><br>
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" name="telefone1" id="telefone1"
					value="${editarEstabelecimento.telefones[0]}" size=20><br> <label
					for="telefone 2">Telefone 2:</label><br> <input type="text"
					name="telefone2" id="telefone2" value="${editarEstabelecimento.telefones[1]}"
					size=20><br>
			</fieldset>
			<fieldset>
				<legend>Dados de Localiza��o</legend>
				<p>
					<label for="cep">CEP:</label><br> <input type="text"
						name="cep" id="cep" value="${editarEstabelecimento.cep }"  onblur="consultacep(this.value)" size=20><br>
						<label for="estado">Estado:</label><br> <input type="text"
						name="estado" id="estado" value="${editarEstabelecimento.estado}" size=2><br>
					<label for="cidade">Cidade:</label><br> <input type="text"
						name="cidade" id="cidade" value="${editarEstabelecimento.cidade}"
						size=30><br> <br> <label for="bairro">Bairro:</label><br>
					<input type="text" name="bairro" id="bairro"
						value="${editarEstabelecimento.bairro}" size=30><br>

					<label for="rua">Rua:</label><br> <input type="text"
						name="rua" id="rua" value="${editarEstabelecimento.rua}" size=60><br>

					<label for="numero">N�mero:</label><br> <input type="text"
						name="numero" id="numero" value="${editarEstabelecimento.numero}"
						size=4><br> <label for="referencia">Refer�ncia:</label><br>
					<input type="text" name="referencia" id="referencia"
						value="${editarEstabelecimento.referencia}" size=30><br>
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