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
			<p style="text-align:center;color:green;">${mensagem}</p>
			<fieldset>
				<legend>Dados do Estabelecimento</legend>
					E-mail: 	   ${acessoEstabelecimento.email}<br/>
					Nome Fantasia: ${acessoEstabelecimento.nome_fantasia}<br/>
					Nome Jurídico: ${acessoEstabelecimento.nome_juridico}<br/>
					CNPJ:		   ${acessoEstabelecimento.cnpj}<br/>
					Categoria: 	   ${acessoEstabelecimento.categoria}
			</fieldset>

			<fieldset>
				<legend>Telefones para Contato</legend>
				
					Telefone 1:    ${acessoEstabelecimento.telefones[0]}<br/>
					Telefone 2:    ${acessoEstabelecimento.telefones[1]}
				
			</fieldset>
			
			<fieldset>
				<legend>Dados de Localização</legend>
				
					CEP: 		   ${acessoEstabelecimento.endereco.cep }<br/>
					Estado:        ${acessoEstabelecimento.endereco.estado}<br/>
					Cidade:        ${acessoEstabelecimento.endereco.cidade}<br/>
					Bairro:        ${acessoEstabelecimento.endereco.bairro}<br/>
					Rua:           ${acessoEstabelecimento.endereco.rua}<br/>
					Número:		   ${acessoEstabelecimento.endereco.numero}<br/>
					Complemento:   ${acessoEstabelecimento.endereco.complemento}<br/>
					Referência:	   ${acessoEstabelecimento.endereco.referencia}<br/>

					</fieldset>

			<div class="nav">
										<ul class="actions">
											<li><a href="EditarEstabelecimentoServlet" class="button2">Editar Perfil</a></li>
											<li><a href="EditarSenhaEstabelecimentoServlet" class="button2">Editar Senha</a></li>
										</ul>
							</div>


		
	</div>

</body>
</html>