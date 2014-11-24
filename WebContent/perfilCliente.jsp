<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 	import="java.util.ArrayList"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome} - Perfil</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
				
<%@include file="headerCliente.html" %>
			
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil</h2>
			</header>
			<!-- Conteudo-->
			
			
			<fieldset>
			<legend>Dados Pessoais</legend>
				<p>
				E-mail: ${cliente.email} .<br/>
				Nome: ${cliente.nome} .<br/>
				Ano de Nascimento: ${cliente.ano_nascimento}.<br/>
				CPF: ${cliente.cpf} .<br/>
				</p>
			</fieldset>
			
			<fieldset>
			<legend>Telefones Para Contato</legend>
			
			Telefone 1: ${cliente.telefones[0]} <br/>
			Telefone 2: ${cliente.telefones[1]}
			</fieldset>
						
				<fieldset >
			
			<legend>Dados de Localização</legend>
				Estado: ${cliente.endereco.estado} <br/>
				
				CEP: ${cliente.endereco.cep} <br/>
				
				Cidade: ${cliente.endereco.cidade} <br/>
				
				Bairro: ${cliente.endereco.bairro} <br/>
				
				Rua: ${cliente.endereco.rua} <br/>
				
				Número: ${cliente.endereco.numero} <br/>
				
				Complemento: ${cliente.endereco.complemento}<br/>
				
				Referência: ${cliente.endereco.referencia} <br/>
			</fieldset>
							<div class="menu">
										<ul class="actions">
											<li><a href="EditarClienteServlet" class="button">Editar</a></li>
											<li><a href="EditarSenhaClienteServlet" class="button">Editar Senha</a></li>
											<li><a href="ExcluirClienteServlet" class="button">Excluir Perfil</a></li>
										</ul>
							</div>
			
			</div>
			
			<div id="footer2">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
						
			
</body>
</html>