<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista Acessível - Editar Lista Passo 02</title>
<style>
/* ESCONDE TODAS AS DIVS */
.divs{display:none;
}
.divs2{
display:block;
}

.divs3{
display:show;
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
    $('.checkbox').click(function() { //quando clica  chama a função
    $('.divs').hide(); //a div é escondida
    $('.checkbox:checked').each(function() {   //o checkbox é marcado e chama a função
    $('#d'+$(this).val()).show(); // o input que recebe a classe "d" recebe o valor e mostra o campo editavel do number
    
    });
    });
    });
    
    $(document).ready(function() {
        $('.checkbox').click(function() { //quando clica  chama a função
        $('.divs2').hide(); //a div é escondida
        $('.checkbox:checked').each(function() {   //o checkbox é marcado e chama a função
        $('#d'+$(this).val()).show(); // o input que recebe a classe "d" recebe o valor e mostra o campo editavel do number
        
        });
        });
        });
    
    $(document).ready(function() {
        $('.checkbox3').click(function() { //quando clica  chama a função
        $('.divs3').hide(); //a div é escondida
        $('.checkbox3:checked').each(function() {   //o checkbox é marcado e chama a função
        $('#d'+$(this).val()).show(); // o input que recebe a classe "d" recebe o valor e mostra o campo editavel do number
        
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
			<h2>Editar Lista Passo 02</h2>	
			<h3>Selecione os Produtos </h3>
			<p style="text-align:center;color:red;">${mensagem}</p>
		</header>
		<form action="EditarListaPasso2Servlet" id="formlista"method="POST">
		
		<div id="pesquisar">
		
		
		<label for="busca">Procurar</label>:<input id="busca" type="search" name ="buscanome" placeholder="Digite o nome do produto desejado" size="30"/>
				<select name="categoria" >
					 <option value="nao selecionada"></option>
					  <option value="alimentos">Alimentos</option>
					  <option value="bebidas">Bebidas</option>
					  <option value="frios">Frios</option>
					  <option value="limpeza">Produtos de Limpeza</option>
				</select>
				
				<!--input type="submit" value="pesquisar" class="button"-->
				<button type="submit"class="button3" name="pesquisa" value="true">Pesquisar</button>
				
		</div>
				
					
				<table  id="produtos" class="display" summary="Tabela com Produtos do Estabelecimento ${listaSession.estabelecimento.nome_fantasia} disponíveis de acordo com o filtro,
				Com as seguintes colunas; Descrição do Produto composta por informações como, nome do produto, marca do produto e valor do produto, as outras colunas são funções como selecionar produto
				 e outra para informar quantidade desejada. Dica, quando estiver na coluna  selecionar marque a caixa de seleção usando a tecla espaço.">
					<caption>Produtos disponíveis do ${listaSession.estabelecimento.nome_fantasia}</caption>
					<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- -->
  								</colgroup>
					<thead>
					
					<tr>
					
						<th rowspan="1"id="descricao">Descrição</th>
						<th id="selecionar" rowspan="1">Selecionar</th>
						<th id="quantidade" rowspan="1">Quantidade</th>	
						
					</tr>
					
					</thead>

					<tbody>
					<c:forEach items="${produtosSelecionados}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}.<br> Marca: ${produto.marca}.<br> Valor: R$ ${produto.valor}. </td>
							<td headers="selecionar"><input type="checkbox" class="checkbox" checked="checked" name="selecionado" id="selecionados" value="${produto.id_produto}" /></td>
							<td headers="quantidade"><div class="divs2" id="d${produto.id_produto}" ><input type="number" accesskey="w" name="quantidade" value="${produto.quantidade}" min="1"  alt="Digite a Quantidade Desejada" /></div></td>
							<input type="hidden" name="id_produto" value="${produto.id_produto}"/> <!-- Esse hidden tem que ficar aqui -->
						</tr>
					</c:forEach>
					
					<c:forEach items="${produtosSelecionadosPesquisa}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}.<br> Marca: ${produto.marca}.<br> Valor: R$ ${produto.valor}. </td>
							<td headers="selecionar"><input type="checkbox" class="checkbox" checked="checked" name="selecionado" id="selecionados" value="${produto.id_produto}" /></td>
							<td headers="quantidade"><div class="divs2" id="d${produto.id_produto}" ><input type="number" accesskey="w" name="quantidade" value="${produto.quantidade}" min="1"  alt="Digite a Quantidade Desejada" /></div></td>
							<input type="hidden" name="id_produto" value="${produto.id_produto}"/> <!-- Esse hidden tem que ficar aqui -->
						</tr>
					</c:forEach>
				
					<c:forEach items="${listaProdutos}" var="produto" varStatus="status">
						<tr>
							<td headers="descricao">${produto.descricao}.<br> Marca: ${produto.marca}.<br> Valor: R$ ${produto.valor}. </td>
							<td headers="selecionar"><input type="checkbox" class="checkbox" name="selecionado" id="selecionados" value="${produto.id_produto}" /></td>
							<td headers="quantidade"><div class="divs" id="d${produto.id_produto}" ><input type="number" accesskey="w" name="quantidade" value="1" min="1"  alt="Digite a Quantidade Desejada" /></div></td>
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
			
		