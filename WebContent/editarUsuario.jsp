<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Cliente"
	import="fafica.listaacessivel.negocios.Fachada"
	import="fafica.listaacessivel.negocios.IFachada"
	import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
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
jQuery(function($){
	$("#cep").mask("99999-999");
	$("#telefone1").mask("(99)9999-9999");
	$("#telefone2").mask("(99)9999-9999");
	$("#cpf").mask("999.999.999-99");
});

</script>
</head>
<body>
	<%@include file="headerUs.html"%>




	<div id="content">
		<header class="major">
			<h2>Editar Perfil</h2>
		</header>


		<%
			IFachada fachada = Fachada.getInstance();
			Cliente usuarioDaSessao = (Cliente) session
					.getAttribute("acessoUsuario");
			Cliente usuario = fachada.pesquisarCliente(usuarioDaSessao);
			ArrayList<String> telefones = new ArrayList<String>();
			telefones = usuario.getTelefones();
		%>
		<!-- Formulário aqui! -->
		<form method="post"
			action="http://localhost:8080/ListaAcessivel/EditarUsuario">
			<fieldset>
				<legend>Dados de Login</legend>
				<label for="email">E-mail:</label> <input type="hidden"
					name="id_usuario" id="email" value="<%=usuario.getId_usuario()%>">
				<input type="email" name="email" id="email"
					value="<%=usuario.getEmail()%>" size=60> <label for="senha">Senha:</label><br>
				<input type="password" name="senha" id="senha"
					value="<%=usuario.getSenha()%>" size=15>
			</fieldset>
			<fieldset>
				<legend>Dados Pessoais</legend>
				<label for="nome">Nome Completo</label> <input type="text"
					name="nome" id="nome" value="<%=usuario.getNome()%>" size=60>

				<label for="cpf">CPF:</label><br> <input type="text" name="cpf"
					id="cpf" value="<%=usuario.getCpf()%>" size=12><br>
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato:</legend>
				<label for="telefone1">Telefone 1:</label><br> <input
					type="text" name="telefone1" id="telefone1"
					value="<%=telefones.get(0)%>" size=20><br> <label
					for="telefone2">Telefone 2:</label><br> <input type="text"
					name="telefone2" id="telefone2" value="<%=telefones.get(1)%>"
					size=20><br>
			</fieldset>

			<fieldset>
				<legend>Dados de Localização</legend>
				
					

				<label for="cep">CEP:</label><br> <input type="text" name="cep"
					id="cep" value="<%=usuario.getCep()%>" size=20><br> <label
					for="cidade">Cidade:</label><br> <input type="text"
					name="cidade" id="cidade" value="<%=usuario.getCidade()%>" size=30><br>

				<label for="bairro">Bairro:</label><br> <input type="text"
					name="bairro" id="bairro" value="<%=usuario.getBairro()%>" size=30><br>

				<label for="rua">Rua:</label><br> <input type="text" name="rua"
					id="rua" value="<%=usuario.getRua()%>" size=60><br> <label
					for="numero">Número:</label><br> <input type="text"
					name="numero" id="numero" value="<%=usuario.getNumero()%>" size=4><br>

				<label for="referencia">Referência:</label><br> <input
					type="text" name="referencia" id="referencia"
					value="<%=usuario.getReferencia()%>" size=30><br>

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