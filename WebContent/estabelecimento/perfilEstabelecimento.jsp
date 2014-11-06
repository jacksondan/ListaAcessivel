<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>

</head>
<body>
	<%@include file="headerEstabelecimento.html"%>

	<%@include file="sidebarEstabelecimento.html"%>
	<div id="content2">
		<header class="major">
			<h2>Perfil Estabelecimento</h2>
		</header>
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
					E-mail: 	   ${estabelecimento.email}<br/>
					Nome Fantasia: ${estabelecimento.nome_fantasia}<br/>
					Nome Jurídico: ${estabelecimento.nome_juridico}<br/>
					CPNPJ:		   ${estabelecimento.cnpj}<br/>
					Categoria: 	   ${estabelecimento.categoria}
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
					Telefone 1:    ${estabelecimento.telefones[0]}<br/>
					Telefone 2:    ${estabelecimento.telefones[1]}
				
			</fieldset>
			
			<fieldset>
				<legend>Dados de Localização</legend>
				
					CEP: 		   ${estabelecimento.cep }<br/>
					Estado:        ${estabelecimento.estado}<br/>
					Cidade:        ${estabelecimento.cidade}<br/>
					Bairro:        ${estabelecimento.bairro}<br/>
					Rua:           ${estabelecimento.rua}<br/>
					Número:		   ${estabelecimento.numero}<br/>
					Complemento:   ${estabelecimento.complemento}<br/>
					Referência:	   ${estabelecimento.referencia}<br/>

					</fieldset>

			<div class="nav">
										<ul class="actions">
											<li><a href="EditarEstabelecimentoServlet" class="button3">Editar Perfil</a></li>
											<li><a href="EditarSenhaEstabelecimentoServlet" class="button3">Editar Senha</a></li>
											
										</ul>
							</div>


		
	</div>

</body>
</html>