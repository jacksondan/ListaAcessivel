<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="fafica.listaacessivel.negocios.entidades.Administrador"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>${acessoAdministrador.nome} - Início</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
	<%@include file="headerAdmin.html"%>
	<%@include file="sidebarAdmin.jsp" %>
	<div id="content2">
		<header class="major">
			<h2>Editar Senha</h2>
		</header>

		<form method="post" name="f1"
			action="http://localhost:8080/ListaAcessivel/EditarSenhaAdministradorServlet">
			<p style="text-align:center;color:green;">${mensagem}</p>
			<fieldset>
				<legend>Edição de Senha</legend>
						
				<p>
					<label for="senhaAtual">Senha Atual</label><br><input type="password"
						placeholder="Digite a Senha Atual" name="senhaAtual" id="senhaAtual" size=30 required="senhaAtual">
				</p>

				<p>
					<label for="senhaNova">Nova Senha</label><br> <input type="password"
						placeholder="Digite a nova Senha" name="senhaNova" id="senhaNova" size=30 required="senhaNova">
				</p>
				<p>
					<label for="confirmarSenha">Confirmar Senha</label><br> <input type="password"
						placeholder="Digite a nova Senha Novamente" name="confirmarSenha" id="confirmarSenha" size=30 required="confirmarSenha" onblur="validarSenha()">
				</p>
				
			</fieldset>
			<div class="12u">
				<ul class="actions">
					<li><input type="submit"  class="button3" value="Salvar Nova Senha" onblur="validarSenha()" onClick="validarSenha()"/></li>

				</ul>
			</div>
		</form>
	</div>

</body>
</html>