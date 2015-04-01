<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Acessível - Cadastro Estabelecimento</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
<script>
	//script da mascara
	jQuery(function($) {
		$("#cep").mask("99999-999");
	
		
		//$("#cnpj").mask("999.999.999-99");
	});
</script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<%@include file="headerAdmin.html"%>
	<%@include file="sidebarAdmin.html"%>

	<div id="content2">
		<header class="major">
			<h2>Cadastro - Estabelecimento</h2>
		</header>

		<form method="post" name="festabele"
			action="http://localhost:8080/ListaAcessivel/CadastrarEstabelecimentoServlet"
			name="form_estabelecimento">
			<p style="text-align: center; color: green;">${mensagem}</p>
			<fieldset>
				<legend>Dados de Login</legend>
				<label for="cnpj">CNPJ:</label><br> <input type="text"
					placeholder="Digite o CNPJ"  maxlength="18"  name="cnpj" id="cnpj" size=18
					required="cnpj" onblur="javascript: validarCNPJ(this.value);"
					onkeypress="javascript: mascara(this, cnpj_mask);" value="" maxlength="18"><br>
				<label for="senha">Senha:</label><br> <input type="password"
					placeholder="Digite a Senha" name="senha" id="senha" size=15
					required="senha">
			</fieldset>
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
				<label for="nome_fantasia">Nome Fantasia:</label> <input type="text"
					placeholder="Digite o nome fantasia" name="nome_fantasia"
					id="nome_fantasia" size=60 required="nome_fantasia"> <label
					for="nome_juridico">Nome Jurídico:</label> <input type="text"
					placeholder="Digite o nome Jurídico" name="nome_juridico"
					id="nome_juridico" size=60 required="nome_juridico"> <label
					for="email">E-mail:</label> <input type="email"
					placeholder="Digite o E-mail" name="email" id="email" size=60
					required="email"> <br> Categoria:<br> <select
					name="categoria" required="categoria">
					<option>Supermercado</option>
					<option>Padaria</option>
					<option>Farmácia</option>
					<option>Livraria</option>
				</select>
			</fieldset>
			<fieldset>
				<legend>Telefones para Contato</legend>
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" placeholder="Digite seu telefone" name="telefone1"
					id="telefone1" size=20 required="telefone1" maxlength="14" onblur="javascript: ValidaTelefone(festabele.telefone1);" onKeyPress="javascript: MascaraTelefone(festabele.telefone1)"><br> 
					
					<label
					for="telefone2">Telefone2:</label> <br>
				<input type="text" placeholder="Digite o segundo telefone"
					name="telefone2" id="telefone2" maxlength="14"onblur="javascript: ValidaTelefone(festabele.telefone2);" onKeyPress="javascript: MascaraTelefone(festabele.telefone2)"size=20>
			</fieldset>

			<fieldset>
				<legend>Dados de Localização</legend>

				<label for="cep">CEP:</label><br> <input type="text"
					placeholder="Digite o CEP" onblur="consultacep(this.value)"
					name="cep" id="cep" size=20 required="cep"><br> <label
					for="cidade">Cidade:</label><br> <input type="text"
					name="cidade" id="cidade" size=60><br> <label
					for="estado">Estado:</label><br> <input type="text"
					name="estado" id="estado" size=2><br> <label
					for="bairro">Bairro:</label><br> <input type="text"
					placeholder="Digite o Bairro" name="bairro" id="bairro" size=30
					required="bairro"><br> <label for="rua">Rua:</label><br>
				<input type="text" placeholder="Digite a Rua" name="rua" id="rua"
					size=60 required="rua"><br> <label for="numero">Número:</label><br>
				<input type="text" placeholder="Digite número" name="numero"
					id="numero" size=4 required="numero"><br> <label
					for="complemento">Complemento:</label><br> <input type="text"
					name="complemento" id="complemento" size=60 required="complemento"><br>


				<label for="referencia">Referência:</label><br> <input
					type="text" placeholder="Digite Referência" name="referencia"
					id="referencia" size=60 required="referencia"><br>

			</fieldset>

			<div class="14u">
				<ul class="actions">
					<li><input type="submit" class="button2"
						value="Confirmar Cadastro" /></li>
					<!-- <li><input type="reset" class="button2" value="Limpar Dados" /></li>-->
				</ul>
			</div>


		</form>
	</div>
	<div id="right"></div>
	<div id="footer2">
		<div id="copyright" class="container">
			<ul class="icons">
				<li>&copy; TechBin. Todos os direitos reservados.</li>
				<li>Design: <a href="http://facebook.com/Edwardhll">Eduardo
						Andrade</a></li>
			</ul>
		</div>
	</div>

	</div>

</body>
</html>