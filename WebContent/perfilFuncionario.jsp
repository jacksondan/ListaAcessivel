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
				
<%@include file="headerFuncionario.html" %>
<%@include file="sidebarFuncionario.html" %>		
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil</h2>
			</header>
			<!-- Conteudo-->
			
			
			<fieldset>
			<legend>Dados de Login</legend>
				<p>
					E-mail: ${funcionario.email} <br/>
				</p>
			</fieldset>
			
			<fieldset>		
			<legend>Dados Pessoais</legend>
				<p class="p">Nome: ${funcionario.nome} </p>
				
				<p class="p">Estabelecimento: ${funcionario.estabelecimento.nome_fantasia}</p>
				
				<p class="p">Matr�cula: ${funcionario.matricula}</p>

			</fieldset>
							<div class="menu">
										<ul class="actions">
											
											<li><a href="EditarSenhaFuncionarioServlet" class="button">Editar Senha</a></li>
											
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