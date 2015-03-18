<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${acessoFuncionario.nome}- Listas Solicitadas</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutabela/clientes.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#listas').dataTable({
        	"filter":true,
        	"ordering": true,
        	"lengthMenu": [[-1,10 , 5], ["Todos", 10, 5]],
        	 "language": {
              "sUrl" : "js/pt-br.txt"
             }    
        })});
</script>  
</head>
<body>

<%@include file="headerFuncionario.html" %>
<%@include file="sidebarFuncionario.html" %>

	<div id="content2">

		<header class="major">
			<h2>Listas Solicitadas</h2>	
		</header>
			<table  id="listas" class="display" summary="Esta cont�m todas as suas Listas criadas,
				Com as seguintes colunas, Descri��o, Data de Cria��o, Valor total, Fun��es em forma de links que s�o, Detalhes da lista e Imprimir.">
					<caption>Resumo das Listas</caption>
					<colgroup>
    							<col />
    							<col />
    							<col />
   			 					<col span="3" /><!-- -->
  								</colgroup>
					<thead>
					
					<tr>

						<th rowspan="1"id="nome_cliente">Nome do Cliente</th>
						<th rowspan="1"id="situ��o">Situa��o da Lista</th>
						<th rowspan="1"id="data">Data de Cria��o</th>
						<th rowspan="1"id="total">Quantidade de Produtos da Lista</th>
						<th rowspan="1"id="total">Valor Total da Lista</th>					
						<th colspan="1"id="fun��o">Fun��es</th>
					</tr>
					
					</thead>
					
					<tbody>
				
					<c:forEach items="${listas_solicitadas}" var="listas" varStatus="status">
						<tr>
							<td headers="nome_cliente">${listas.cliente.nome}</td>
							<td headers="situa��o">${listas.situacao}</td>
							<td headers="data">${listas.data_criacao}</td>
							<td headers="data">${listas.quantidade_total}</td>
							<td headers="total">R$ ${listas.valor_total}</td>
							<td headers="detalhes"><a href="DetalhesListaServlet?id_lista=${listas.id_lista}" class="button2">Detalhes</a></td>			
						</tr>
					</c:forEach>
					</tbody>
					
				</table>


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
			
		