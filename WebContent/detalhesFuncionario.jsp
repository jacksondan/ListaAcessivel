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
				
<%@include file="headerEstabelecimento.html" %>
<%@include file="sidebarEstabelecimento.html"%>	
	
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Detalhes do Funcionário</h2>
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
				Nome: ${funcionario.nome} <br/>
				
				Matrícula: ${funcionario.matricula} <br/>
			</fieldset>
							<div class="menu">
										<ul class="actions">
											
											<li><a href="EditarFuncionarioServlet?id_funcionario=${funcionario.id_usuario}" class="button">Editar Perfil</a></li>
											<li><a href="#" class="button">Zerar Senha</a></li>
											
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