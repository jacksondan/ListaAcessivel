<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Acessível - Detalhes da Lista</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>
<style rel="stylesheet" type="text/css" media="print">
   .actions{display:none}
   #nav2{display:none}
   #content{}
   #footer{display:none}
   #filtro2{display:none}	
</style>	
</head>
<body>

	<%@include file="headerFuncionario.html" %>
	
	<div id="content">

		<header class="major">
			<h3>Detalhes da Lista</h3>	
		</header>
				
				<div id="infolista">
				<fieldset><legend>Informações da Lista</legend>	
				<p class="p">Nome do Cliente: ${lista.cliente.nome}</p>
				<p class="p">Situação da Lista: ${lista.situacao}</p>
				<p class="p">Data de Criação:  ${lista.data_criacao}</p>	
				<p class="p">Endereço do Cliente:</p>
				<p class="p">Rua: ${lista.cliente.endereco.rua}</p>				
				<p class="p">Bairro: ${lista.cliente.endereco.bairro}</p>
				<p class="p">Número: ${lista.cliente.endereco.numero}</p>
				<p class="p">Complemento: ${lista.cliente.endereco.complemento}</p>
				<p class="p">Referência: ${lista.cliente.endereco.referencia}</p>				
				<p class="p">Telefone 1: ${lista.cliente.telefones[0]}</p>
				<p class="p">Telefone 2: ${lista.cliente.telefones[1]}</p>
				</fieldset>
				</div>
		
				<table align="center"class="default" summary="Tabela com Produtos do Estabelecimento ${estabelecimento.nome_fantasia} disponíveis de acordo com o filtro,
				Com as seguintes colunas, Descrição, Marca, Valor, Validade, Peso e funções  que são, Selecionar usando um combo box e Digitar quantidade.">
					<caption>Produtos da Lista</caption>
			
					<thead>

						<tr>
							<th rowspan="2"id="codigo_barra">Código de Barra</th>				
							<th rowspan="2"id="marca">Marca</th>
							<th rowspan="2"id="validade">Validade</th>
							<th rowspan="2"id="peso">Peso</th>
							<th rowspan="2"id="quantidade">Quantidade Solicitada</th>
							<th rowspan="2"id="valor">Preço Unitário</th>
						</tr>
					
					</thead>
										
					<tbody>
				
					<c:forEach items="${lista.produtos}" var="produto" varStatus="status">
						<tr>
							<td headers="codigo_barra">${produto.codigo_barra}</td>
							<td headers="marca">${produto.marca}</td>							
							<td headers="validade">${produto.validade}</td>
							<td headers="peso">${produto.peso}</td>
							<td headers="quantidade">${produto.quantidade}</td>
							<td headers="valor">R$ ${produto.valor}</td>
							
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
				<div id="filtro2" >
					<button align="center" class="button3" onclick="javascript:DoPrinting()" >Imprimir</button>
					<c:if test="${lista.situacao == 'solicitada'}">
						<button class="button3"  onclick="window.location.href='ConfirmarEntregaListaServlet?id_lista=${lista.id_lista}'" >Confirmar Atendimento</button>
					</c:if>
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
		