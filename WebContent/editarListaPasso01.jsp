<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Acessível - Editar Lista Passo 1</title>
<style>
/* ESCONDE TODAS AS DIVS */
.divs{display:block;
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
    <link rel="shortcut icon" href="images/logtop.png" />
</head>
<body>

	<%@include file="headerCliente.html"%>
	<div id="content">

		<header class="major">
			<p style="text-align:center;color:red;">${mensagem}</p>
			<h2>Editar Lista Passo 01</h2>	
		</header>
	
		
				<form action="EditarListaPasso1Servlet" id="formlista" method="POST">
				
					
				<table  id="produtos" class="display" summary="Tabela de Edição de lista com Produtos do Estabelecimento ${lista.estabelecimento.nome_fantasia}, da lista ${lista.descricao}
				Com as seguintes colunas, Descrição, Marca, Valor, Validade, Peso e funções  que são, Selecionar usando um combo box e Digitar quantidade, nesta tela.">
					<caption>Produtos da Lista ${lista.descricao} </caption>
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
				
					<c:forEach items="${lista.produtos}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}</td>
							<td headers="marca">${produto.marca}</td>
							<td headers="valor">R$ ${produto.valor}</td>
							<td headers="validade">${produto.validade}</td>
							<td headers="peso">${produto.peso}</td>
							<td headers="selecionar"><input type="checkbox" class="checkbox"  CHECKED name="selecionado" id="selecionados" value="${produto.id_produto}" /></td>
							<td headers="quantidade"><div class="divs" id="d${produto.id_produto}" ><input type="number"  name="quantidade" value="${produto.quantidade}" min="1"  alt="Digite a Quantidade Desejada" /></div></td>
							<input type="hidden" name="id_produto" value="${produto.id_produto}"/> <!-- Esse hidden tem que ficar aqui -->
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>	
					</tfoot>
				</table>
				
				<div id="descri">
				<label for="desc">Descrição da Lista</label><br>
				<textarea name="descricaolista" id="desc" wrap="hard" placeholder="Digite a Descrição da Lista..." form="formlista"  rows="5" cols="40">${lista.descricao}</textarea>
				
				</div>
				
					<div id="finalizar2">
					<ul class="menu2">
						<li>
							<button type="submit"class="button3" name="adicionarProduto" value="true">Adicionar Produtos </button>
						</li>
						<li>
							<button type="submit" class="button3" >Finalizar Edição</button>
						</li>
					</ul>
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
			
		