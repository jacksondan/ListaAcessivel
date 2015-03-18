<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Acessível - Detalhes do Cliente</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
		<%@include file="headerAdmin.html"%>
		<%@include file="sidebarAdmin.html"%>
	<div id="content2">
		<header class="major">
			<h2>Detalhes do Cliente</h2>
		</header>
			<fieldset>
				<legend>Dados do Cliente</legend>
				E-mail: 			${cliente.email} <br/>
				Nome: 				${cliente.nome} <br/>
				Ano de Nascimento:  ${cliente.ano_nascimento}<br/>
				CPF: 				${cliente.cpf}
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
					Telefone 1: ${cliente.telefones[0]} <br/>
					Telefone 2: ${cliente.telefones[1]}
				
			</fieldset>
			<fieldset>
				<legend>Dados de Localização</legend>
				
				Estado: 		${cliente.endereco.estado} <br/>
				CEP: 			${cliente.endereco.cep} <br/>
				Cidade: 		${cliente.endereco.cidade} <br/>
				Bairro: 		${cliente.endereco.bairro} <br/>
				Rua: 			${cliente.endereco.rua} <br/>
				Número: 		${cliente.endereco.numero} <br/>
				Complemento: 	${cliente.endereco.complemento}<br/>
				Referência: 	${cliente.endereco.referencia} <br/>
					</fieldset>
			<div class="nav">
										<ul class="actions">
											<!--  <li><a href="EditarClienteServlet" class="button2">Editar Dados</a></li> -->
											<li><a href="#" class="button2">Zerar Senha</a></li>
										</ul>
							</div>


		
	</div>

</body>
</html>