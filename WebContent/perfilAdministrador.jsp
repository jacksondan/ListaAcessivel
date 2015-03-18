<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 	import="java.util.ArrayList"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador - Perfil</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>
				
<%@include file="headerAdmin.html" %>
<%@include file="sidebarAdmin.html" %>		
			<div id="content2">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil Administrador</h2>
					<p style="text-align:center;color:green;">${mensagem}</p>
			</header>
			<!-- Conteudo-->
			
			
			<fieldset>
			<legend>Dados de Login</legend>
				<p>
					E-mail: ${acessoAdministrador.email} <br/>
				</p>
			</fieldset>
			
			<fieldset>		
			<legend>Dados Pessoais</legend>
				Nome: ${acessoAdministrador.nome} <br/>
				
				CPF: ${acessoAdministrador.cpf} <br/>

			</fieldset>
							<div class="menu">
										<ul class="actions">
											
											<li><a href="EditarAdministradorServlet" class="button">Editar Dados</a></li>
											<li><a href="EditarSenhaAdministradorServlet" class="button">Editar Senha</a></li>
											
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