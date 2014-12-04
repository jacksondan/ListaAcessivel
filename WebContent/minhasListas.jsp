<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome}- Inicio</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutabela/criarlistapasso3.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#listas').dataTable({
        	"filter":false,
        	"ordering": false,
        	"lengthMenu": [[-1,10 , 5], ["Todos", 10, 5]],
        	 "language": {
              "sUrl" : "js/pt-br.txt"
             }    
        })});
</script>  
</head>
<body>

	<%@include file="headerCliente.html"%>
	<div id="content">

		<header class="major">
			<h2>Minhas Lista</h2>	
		</header>
		
				
				<table  id="listas" class="display" summary="Esta contém todas as suas Listas criadas,
				Com as seguintes colunas, Descrição, Data de Criação, Valor total, Funções   em forma de links que são, Detalhes da lista, Editar  e Excluir.">
					<caption>Minhas Listas</caption>
					<colgroup>
    							<col />
    							<col />
    							<col />
   			 					<col span="3" /><!-- -->
  								</colgroup>
					<thead>
					
					<tr>

						<th rowspan="2"id="descrição">Descrição</th>
						<th rowspan="2"id="situção">Descrição</th>
						<th rowspan="2"id="data">Data de Criação</th>
						<th rowspan="2"id="total">Valor Total</th>					
						<th colspan="3"id="função">Funções</th>
					</tr>
					<tr>
						<th id="detalhes" axis="função">Detalhes</th>
						<th id="editar" axis="função">Editar</th>
						<th id="exlcuir" axis="função">Excluir</th>
							
					</tr>
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${listas}" var="listas" varStatus="status">
						<tr>
							<td headers="descricao">${listas.descricao}</td>
							<td headers="situação">${listas.situacao}</td>
							<td headers="data">${listas.data_criacao}</td>
							<td headers="total">R$ ${listas.valor_total}</td>
							<td headers="detalhes"><a href="DetalhesListaServlet?id_lista=${listas.id_lista}" class="button2">Detalhes</a></td>
							<td headers="editar"><a href="EditarListaServlet?id_lista=${listas.id_lista}" class="button2">Editar</a></td>
							<td headers="excluir"><a href="ExluirListaServlet?id_lista=${listas.id_lista}" class="button2">Excluir</a></td>
							
						</tr>
					</c:forEach>
					</tbody>
					
				</table>

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
			
		