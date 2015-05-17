<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${acessoCliente.nome} - Perfil</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<style rel="stylesheet" type="text/css" media="print">
   .actions{display:none}
   #nav2{display:none}
   #footer{display:none}	
</style>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
				
<%@include file="headerCliente.html" %>
			
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil</h2>
					<p style="text-align: center; color: green;">${mensagem}</p>
			</header>
			<fieldset>
			<legend>Dados Pessoais</legend>
				
				<p class="p">E-mail: 		${acessoCliente.email} </p>
				<p class="p">Nome: 				${acessoCliente.nome} 
				<p class="p">Ano de Nascimento:  ${acessoCliente.ano_nascimento}<p>
				<p class="p">CPF: 				${acessoCliente.cpf}</p>
				
			</fieldset>
			
			<fieldset>
			<legend>Telefones para Contato</legend>
			
			<p class="p">Telefone 1: ${acessoCliente.telefones[0]}<p>
			<p class="p">Telefone 2: ${acessoCliente.telefones[1]}<p>
			</fieldset>
						
			<fieldset >
			
				<legend>Dados de Localização</legend>
			
				<p class="p">Estado: 		${acessoCliente.endereco.estado}</p>
				<p class="p">CEP: 			${acessoCliente.endereco.cep}</p>
				<p class="p">Cidade: 		${acessoCliente.endereco.cidade}</p>
				<p class="p">Bairro: 		${acessoCliente.endereco.bairro}</p>
				<p class="p">Rua: 			${acessoCliente.endereco.rua}</p>
				<p class="p">Número: 		${acessoCliente.endereco.numero}</p>
				<p class="p">Complemento: 	${acessoCliente.endereco.complemento}</p>
				<p class="p">Referência: 	${acessoCliente.endereco.referencia}</p>
			</fieldset>
							<div class="menu">
										<ul class="actions">
											<li><a href="EditarClienteServlet" class="button">Editar Perfil</a></li>
											<li><a href="EditarSenhaClienteServlet" class="button">Editar Senha</a></li>
											<li><a href="ExcluirClienteServlet" class="button">Excluir Perfil</a></li>
											
										</ul>
							</div>
			
			</div>
			
			<div id="footer">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
						
			
</body>
</html>