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
<script>
//script da mascara


</script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#produtos').dataTable({
        	"filter":false,
        	"ordering": false,
        	"lengthMenu": [[5, 10, 30, -1], [5, 10, 30, "Todos"]],
        	 "language": {
              "sUrl" : "js/pt-br.txt"
             }    
        })});
   
    jQuery(function($){
    	$("#quantidade").mask("99999");
    });

    </script>
</head>
<body>

	<%@include file="headerCliente.html"%>
	<div id="content">

		<header class="major">
			<h2>Criar Lista Passo - 03</h2>	
		</header>
		<div id="filtro2">
		<form action="Servlet" method="GET">
		
		<label for="busca">Procurar</label>:<input id="busca" type="search" name ="buscanome" placeholder="Digite o nome do produto desejado" size="30">
				<select name="categoria" >
					 
					  <option value="alimentos">Alimentos</option>
					  <option value="bebidas">Bebidas</option>
					  <option value="frios">Frios</option>
					  <option value="limpeza">Produtos de Limpeza</option>
				</select>
				<button type="submit" value="pesquisar" class="button2">Pesquisar</button>
				</form>
		</div>
				<form>
				<table  id="produtos" class="display" summary="Tabela com Produtos do Estabelecimento ${estabelecimento.nome_fantasia} disponíveis de acordo com o filtro.">
					<caption>Produtos disponíveis da categoria ${categoria}s filtrados por ${filtragem}</caption>
					<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- -->
  								</colgroup>
					<thead>
					
					<tr>
					
						<th rowspan="2"id="descricao">Descrição</th>
						<th rowspan="2"id="marca">Marca</th>
						<th rowspan="2"id="valor">Valor</th>
						<th rowspan="2"id="validade">Validade</th>
						<th rowspan="2"id="peso">Peso</th>
						<th colspan="2"id="funcoes">Funcões</th>
						
					</tr>
					<tr>
						<th id="selecionar" axis="funcoes">Selecionar</th>
						<th id="quantidade" axis="funcoes">Quantidade</th>	
					</tr>
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${listaprodutos}" var="produto" varStatus="status">
					
					<tr>
						<td headers="descricao">${produto.descricao}</td>
						<td headers="marca">${produto.marca}</td>
						<td headers="valor">R$ ${produto.valor}</td>
						<td headers="validade">${produto.validade}</td>
						<td headers="peso">${produto.peso}</td>
						<td headers="selecionar"><input type="checkbox"  name="selecionado" id="${produto.id_produto}"></td>
						<td headers="selecionar"><input type="number" name="quantidade" id="quantidade"  alt="Digite a Quantidade Desejada"></td>
					</tr>
					
					</c:forEach>
				
					</tbody>
				</table>
				</form>
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
			
		