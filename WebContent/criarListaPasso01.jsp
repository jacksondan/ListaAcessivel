<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome} - Criar Lista</title>
<link rel="stylesheet" type="text/css" href="css/style.css"> 
</head>
<body>
   
<%@include file="headerCliente.html" %>

		<div id="content">
					<header class="major">		
						<h2>Criar Lista Passo - 01  </h2>
						<h3>Selecione a Categoria do Estabelecimento</h3>
					</header>
					
<div id="sidebar">

<ul class="actions">							
	<li><p><a href="CategoriaEstabelecimentoServlet?categoria=supermercado" class="image"><img src="images/catMercado.png" alt="Categoria Super Mercado, clicando aqui voce vai para a Categoria de"style="width:12em ;heigth:12em;">Supermercado</a></p></li>
	<li><p><a href="CategoriaEstabelecimentoServlet?categoria=padaria" class="image"><img src="images/catPadaria.png" alt="Categoria Padaria, clicando aqui voce vai para a Categoria de"style="width:12em ;heigth:12em;">Padaria</a></p></li>
	<li><p><a href="CategoriaEstabelecimentoServlet?categoria=farmacia" class="image"><img src="images/catFarmacia.png" alt="Categoria Farmácia, clicando aqui voce vai para a Categoria de "style="width:12em ;heigth:12em;">Farmácia</a></p></li>
		<li><p><a href="CategoriaEstabelecimentoServlet?categoria=livraria" class="image"><img src="images/catLivraria.png" alt="Categoria Livraria, clicando aqui voce vai para a Categoria de "style="width:12em ;heigth:12em;">Livraria</a></p></li>
</ul>
		</div>			
</div>

<%@include file="footer.html" %>
