<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>${acessoCliente.nome} - Perfil</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
 <script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
<script>
//script da mascara
jQuery(function($){
	$("#cep").mask("99999-999");
	$("#telefone1").mask("(99)9999-9999");
	$("#telefone2").mask("(99)9999-9999");
	$("#cpf").mask("999.999.999-99");
	$("#ano_nascimento").mask("9999");
	
});

</script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>

<body>

	<%@include file="headerCliente.html"%>

	<div id="content">
		<header class="major">
			<h2>Editar Perfil</h2>
		</header>


		<!-- Formulário aqui! -->
		<form method="post"
			action="EditarClienteServlet">
			
			<fieldset>
				<legend>Dados Pessoais</legend>
				
				<label for="email">E-mail:</label>
				<input type="email" name="email" id="email"
					value="${acessoCliente.email}" size=60 required="email"><br>
				<label for="nome">Nome Completo</label> <input type="text"
					name="nome" id="nome" value="${acessoCliente.nome}" size=60 required="nome">
				
				<p><label for="ano_nascimento">Ano de Nascimento</label><br> <input type="text"
						 name="ano_nascimento" id="ano_nascimento"
						require="ano_nascimento" value="${acessoCliente.ano_nascimento}" size="4"></p>
						
				<label for="cpf">CPF:</label><br> <input type="text" name="cpf"
					id="cpf" value="${acessoCliente.cpf}" size=12 required="cpf"><br>
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato:</legend>
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" name="telefone1" id="telefone1"
					value="${acessoCliente.telefones[0]}" size=20 required="telefone1"><br> <label
					for="telefone2">Telefone 2:</label><br> <input type="text"
					name="telefone2" id="telefone2" value="${acessoCliente.telefones[1]}"
					size=20><br>
			</fieldset>

			<fieldset>
				<legend>Dados de Localização</legend>
				
					

				<label for="cep">CEP:</label><br> <input type="text" name="cep"
					id="cep" value="${acessoCliente.endereco.cep}" onblur="consultacep(this.value)" size=20 required="cep"><br> 
					<label for="estado">Estado:</label><br> <input type="text"
						name="estado" id="estado" value="${acessoCliente.endereco.estado}" size=2><br>
					
					<label
					for="cidade">Cidade:</label><br> <input type="text"
					name="cidade" id="cidade" value="${acessoCliente.endereco.cidade}" size=30><br>
			
				<label for="bairro">Bairro:</label><br> <input type="text"
					name="bairro" id="bairro" value="${acessoCliente.endereco.bairro}" size=30 required="bairro" ><br>

				<label for="rua">Rua:</label><br> <input type="text" name="rua"
					id="rua" value="${acessoCliente.endereco.rua}" size=60 required="rua"> <br> <label
					for="numero">Número:</label><br> <input type="text"
					name="numero" id="numero" value="${acessoCliente.endereco.numero}" size=4 required="numero"><br>
					
					<label
					for="complemento">Complemento:</label><br> <input type="text"
					name="complemento" id="complemento" value="${acessoCliente.endereco.complemento}" size=60 required="complemento"><br>

				<label for="referencia">Referência:</label><br> <input
					type="text" name="referencia" id="referencia"
					value="${acessoCliente.endereco.referencia}" size=60 required="referencia"><br>

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