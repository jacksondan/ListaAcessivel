<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 	import="java.util.ArrayList"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome} - Perfil</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<style rel="stylesheet" type="text/css" media="print">
   .actions{display:none}
   #nav2{display:none}
   #footer{display:none}	
</style>

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
				
				<p class="p">E-mail: 		${cliente.email} </p>
				<p class="p">Nome: 				${cliente.nome} 
				<p class="p">Ano de Nascimento:  ${cliente.ano_nascimento}<p>
				<p class="p">CPF: 				${cliente.cpf}</p>
				
			</fieldset>
			
			<fieldset>
			<legend>Telefones para Contato</legend>
			
			<p class="p">Telefone 1: ${cliente.telefones[0]}<p>
			<p class="p">Telefone 2: ${cliente.telefones[1]}<p>
			</fieldset>
						
			<fieldset >
			
				<legend>Dados de Localização</legend>
			
				<p class="p">Estado: 		${cliente.endereco.estado}</p>
				<p class="p">CEP: 			${cliente.endereco.cep}</p>
				<p class="p">Cidade: 		${cliente.endereco.cidade}</p>
				<p class="p">Bairro: 		${cliente.endereco.bairro}</p>
				<p class="p">Rua: 			${cliente.endereco.rua}</p>
				<p class="p">Número: 		${cliente.endereco.numero}</p>
				<p class="p">Complemento: 	${cliente.endereco.complemento}</p>
				<p class="p">Referência: 	${cliente.endereco.referencia}</p>
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