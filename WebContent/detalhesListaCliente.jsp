<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>${acessoCliente.nome} - Detalhes da lista</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>
<style rel="stylesheet" type="text/css" media="print">
   .actions{display:none}
   #nav2{display:none}
   #content{}
   #footer{display:none}
   #filtro2{display:none}
   #finalizar2{display:none}	
   
</style>
<link rel="shortcut icon" href="images/logtop.png" />	
</head>
<body>

	<%@include file="headerCliente.html"%>
	
	<div id="content">

		<header class="major">
			<h3>Detalhes da Lista</h3>	
		</header>
				
				<div id="infolista">
				<fieldset><legend>Informa��es da Lista</legend>
				
				<p class="p">Descri��o: ${lista.descricao}</p>
				<p class="p">Situa��o da Lista: ${lista.situacao}</p>
				<p class="p">Data de Cria��o:  ${lista.data_criacao}</p>					
				<p class="p">Estabelecimento:  ${lista.estabelecimento.nome_fantasia}</p>
				<p class="p">Bairro do Estabelecimento:${lista.estabelecimento.endereco.bairro}</p>
				<p class="p">Rua  do Estabelecimento: ${lista.estabelecimento.endereco.rua}</p>
				<p class="p">Telefone 1: ${lista.estabelecimento.telefones[0]}</p>
				<p class="p">Telefone 2: ${lista.estabelecimento.telefones[1]}</p>
				
				</fieldset>
				</div>
		
				<table align="center"class="default" summary="Tabela com Produtos do Estabelecimento ${estabelecimento.nome_fantasia} dispon�veis de acordo com o filtro,
				Com as seguintes colunas, Descri��o, Marca, Valor, Validade, Peso e fun��es  que s�o, Selecionar usando um combo box e Digitar quantidade.">
					<caption>Produtos da Lista</caption>
			
					<thead>

						<tr>				
							<th rowspan="2"id="descricao">Descri��o</th>
							<th rowspan="2"id="marca">Marca</th>
							<th rowspan="2"id="validade">Validade</th>
							<th rowspan="2"id="peso">Peso</th>
							<th rowspan="2"id="quantidade">Quantidade Solicitada</th>
							<th rowspan="2"id="valor">Pre�o Unit�rio</th>
						</tr>
					
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${lista.produtos}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}</td>
							<td headers="marca">${produto.marca}</td>							
							<td headers="validade">${produto.validade}</td>
							<td headers="peso">${produto.peso}</td>
							<td headers="quantidade">${produto.quantidade}</td>
							<td headers="valor">R$${produto.valor}</td>
							
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>	
					<tr>
					<th colspan="4">Quantidade total de produtos: ${lista.quantidade_total}</th>
					<th colspan="2"id="quantidadeProdutos">Valor total da lista: R$ ${lista.valor_total}</th>
					</tr>
					</tfoot>
				</table>
				<div id="finalizar2">
					<ul class="menu2">
					<li><button class="button3" onclick="javascript:DoPrinting()" >Imprimir</button></li>
					<c:if test="${lista.situacao == 'criada' || lista.situacao == 'atendida'}">
						<li><button class="button3" onclick="window.location.href='EditarListaPasso1Servlet?id_lista=${lista.id_lista}'" >Editar Lista</button></li>
					</c:if>
					<c:if test="${lista.situacao == 'criada'}">
						<li><button class="button3"  onclick="window.location.href='SolicitarEntregaServlet?id_lista=${lista.id_lista}'" >Solicitar Entrega</button></li>
					</c:if>
					<c:if test="${lista.situacao == 'atendida'}">
						<li><button class="button3"  onclick="window.location.href='SolicitarEntregaServlet?id_lista=${lista.id_lista}'" >Solicitar Nova Entrega</button></li>
						<%-- <li><a href="mailto:${acessoCliente.email}?subject=Lista%20Solicitada&cc=ListaAcessiivel Team&body=Ola%20Sua%20Lista%20Foi%20Solicitada"><button class="button3"  onclick="window.location.href='SolicitarEntregaServlet?id_lista=${lista.id_lista}'" >Solicitar Nova Entrega</button></a></li> --%>
			
					</c:if>
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
			
		