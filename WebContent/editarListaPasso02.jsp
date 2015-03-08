<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome}- Inicio</title>
<style>
/* ESCONDE TODAS AS DIVS */
.divs{display:none;
}
</style>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutabela/criarlistapasso3.css">
<script src="js/script.js"></script>
<script type="text/javascript"  src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#produtos').dataTable({
        	"filter":false,
        	"ordering": false,
        	"lengthMenu": [[-1,10 , 5], ["Todos", 10, 5]],
        	 "language": {
              "sUrl" : "js/pt-br.txt"
             }    
        })});
    //lógica  dos checkbox
    $(document).ready(function() {
    $('.checkbox').click(function() {
    $('.divs').hide();
    $('.checkbox:checked').each(function() { 
    $('#d'+$(this).val()).show(); 
    });
    });
    });
    </script>
</head>
<body>

	<%@include file="headerCliente.html"%>
	<div id="content">

		<header class="major">
			<h2>Adicionar novos produtos</h2>	
		</header>
		<div id="filtro2">
		<form action="EditarListaPasso2Servlet" method="GET">
		<input type="hidden" name="id_lista"  value="${lista.id_lista}" />
		
		<label for="busca">Procurar</label>:<input id="busca" type="search" name ="buscanome" placeholder="Digite o nome do produto desejado" size="30"/>
				<select name="categoria" >
					 <option value="não selecionada"></option>
					  <option value="alimentos">Alimentos</option>
					  <option value="bebidas">Bebidas</option>
					  <option value="frios">Frios</option>
					  <option value="limpeza">Produtos de Limpeza</option>
				</select>
				
				<input type="submit" value="pesquisar" class="button">
				</form>
		</div>
				<form action="EditarListaPasso2Servlet" id="formlista"method="POST">
				
				<input type="hidden" name="id_lista"  value="${lista.id_lista}" />
				<input type="hidden" name="descricao"  value="${lista.descricao}" />
				<input type="hidden" name="id_estabelecimento" value="${lista.estabelecimento.id_estabelecimento}" />
					
				<table  id="produtos" class="display" summary="Tabela com Produtos do Estabelecimento ${lista.estabelecimento.nome_fantasia} disponíveis de acordo com o filtro,
				Com as seguintes colunas, Descrição, Marca, Valor, Validade, Peso e funções  que são, Selecionar usando um combo box e Digitar quantidade.">
					<caption>Produtos disponíveis da categoria ${categoria}s filtrados por ${filtragem}</caption>
					<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- -->
  								</colgroup>
				<thead>
					
					<tr>
					
						<th rowspan="1"id="descricao">Descrição</th>
						<th rowspan="1"id="marca">Marca</th>
						<th rowspan="1"id="valor">Valor</th>
						<th rowspan="1"id="validade">Validade</th>
						<th rowspan="1"id="peso">Peso</th>
						<th id="selecionar" rowspan="1">Selecionar</th>
						<th id="quantidade" rowspan="1">Quantidade</th>	
						
					</tr>
					
					</thead>
					
					
					<tbody>
				
					<c:forEach items="${produtosnaopossui}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}</td>
							<td headers="marca">${produto.marca}</td>
							<td headers="valor">R$ ${produto.valor}</td>
							<td headers="validade">${produto.validade}</td>
							<td headers="peso">${produto.peso}</td>
							<td headers="selecionar"><input type="checkbox" class="checkbox" name="selecionado" id="selecionados" value="${produto.id_produto}"/></td>
							<td headers="quantidade"><div class="divs" id="d${produto.id_produto}"><input type="number"  name="quantidade" value="1" min="1"  alt="Digite a Quantidade Desejada" /></div></td>
							<input type="hidden" name="id_produto" value="${produto.id_produto}"/> <!-- Esse hidden tem que ficar aqui -->
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>	
					</tfoot>
				</table>
				
					<div id="finalizar">
					
						<button type="submit" class="button3" >Finalizar Lista</button>
					</div>
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
			
		