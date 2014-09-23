<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Produto"
	import="fafica.listaacessivel.negocios.IFachada"
	import="fafica.listaacessivel.negocios.Fachada"
	
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
										<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt="Logo Lista acessível"  style="width:6.5em ;heigth:8.5em;"></a></h1>
	
						
					</div>
				</div>
			<div id="left"></div>
			<div id="content">
				<header class="major">		
					<h2>Editar  Produto</h2>
				</header>
			<!-- Formulário aqui! -->
			<form method="post" action="EditarProduto">
				<%
					Produto p = (Produto) request.getAttribute("produto");
		
				%>
				<!--Enviando os id necessarios pelo formulario para montar o objeto no servlet-->
				<input type="hidden"  name="id_produto" value="<%=p.getId_produto()%>">
				<input type="hidden"  name="id_estabelecimento" value="<%=p.getId_estabelecimento()%>">
				
				<fieldset >
				<legend><strong>Dados do Produto</strong></legend>
				<label for="descrição">Descrição:</label>
				<input type="text"  name="descricao" id="descrição" value="<%=p.getDescricao_produto()%>"size=60>
				
				<label for="preço">Preço:</label>
				<input type="text"  name="preco" id="preço" value="<%=p.getPreco_produto()%>" size=10>
				<label for="quantidade">Quantidade:</label>
				<input type="text"  name="quantidade" id="quantidade" value="<%=p.getQuantidade_produto()%>" size=10>
					<p>
						<label for="categoria">Categoria:<br />
						<select name="categoria" id="categoria">
						<option selected="<%=p.getCategoria()%>" value="<%=p.getCategoria()%>"><%=p.getCategoria()%></option>
						<option value="frios">Frios</option>
						<option value="limpeza">Limpeza</option>
						<option value="Bebidas">Bebidas</option>
						</select>
						</label>
						</p>
				</fieldset>
					
						<div class="12u">
							<ul class="actions">
								<li><input type="submit" value="Salvar" /></li>
								<li><input type="reset" value="Limpar" /></li>
							</ul>
						</div>
						
					
			</form>
			</div>
			<div id="right"></div>
			<div id="footer">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
						
			</div>
		
</body>
</html>