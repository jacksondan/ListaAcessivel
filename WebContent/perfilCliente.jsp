<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 	import="java.util.ArrayList"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
				
<%@include file="headerUs.html" %>	
			
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil</h2>
			</header>
			<!-- Conteudo-->
			
			
			<fieldset >
			<legend>Dados Pessoais</legend>
				E-mail: ${cliente.email} <br/>
				
				Nome: ${cliente.nome} <br/>
				
				CPF: ${cliente.cpf} <br/>
				
			</fieldset>
			
			<fieldset>
			<legend>Telefones Para Contato</legend>
			
			Telefone 1: ${cliente.telefones[0]} <br/>
			Telefone 2: ${cliente.telefones[1]}
			</fieldset>
						
				<fieldset >
			
			<legend>Dados de Localização</legend>
				Estado: ${cliente.estado} <br/>
				
				CEP: ${cliente.cep} <br/>
				
				Cidade: ${cliente.cidade} <br/>
				
				Bairro: ${cliente.bairro} <br/>
				
				Rua: ${cliente.rua} <br/>
				
				
				Número: ${cliente.numero} <br/>
				
				Referência: ${cliente.referencia} <br/>
			</fieldset>
							<div class="nav">
										<ul class="actions">
											<li><a href="EditarClienteServlet" class="button">Editar</a></li>
											<li><a href="EditarSenhaClienteServlet" class="button">Editar Senha</a></li>
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