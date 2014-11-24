<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="../js/script.js"></script>

</head>
<body>
	<%@include file="headerAdmin.html"%>

	<%@include file="sidebarAdmin.html"%>
	<div id="content2">
		<header class="major">
			<h2>Detalhes do Estabelecimento</h2>
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
				
					CEP: 		   ${estabelecimento.endereco.cep }<br/>
					Estado:        ${estabelecimento.endereco.estado}<br/>
					Cidade:        ${estabelecimento.endereco.cidade}<br/>
					Bairro:        ${estabelecimento.endereco.bairro}<br/>
					Rua:           ${estabelecimento.endereco.rua}<br/>
					Número:		   ${estabelecimento.endereco.numero}<br/>
					Complemento:   ${estabelecimento.endereco.complemento}<br/>
					Referência:	   ${estabelecimento.endereco.referencia}<br/>

					</fieldset>
	</div>

</body>
</html>