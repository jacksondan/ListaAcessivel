<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" import="fafica.listaacessivel.negocios.entidades.Produto"%>
	    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html lang="pt-br">
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<link rel="stylesheet" type="text/css" href="css/layoutabela/produtos.css">
<script type="text/javascript"  src="js/jquery.js"></script>		
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#produtos').dataTable({
        	"ordering": false,
        	"lengthMenu": [[5, 10, 30, -1], [5, 10, 30, "Todos"]],
        	 "language": {
              "sUrl" : "js/pt-br.txt"
             }    
        })});

    </script>
	</head>
	<body>
<%@include file="headerEstabelecimento.html" %>

<%@include file="sidebarEstabelecimento.html" %>

				<div id="content2">
					<header class="major">		
						<h2>Lista de Produtos</h2>
					</header>

						<table  aling="center" class="display"  id="produtos">
						<caption>Produtos</caption>
						
								<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- Agrupamento das colunas Português e Matemática à célula de cabeçalho Matérias -->
  								</colgroup>
								<thead>
								<tr>	
									<th  rowspan="2" id="descricao">Descrição</th>
									<th rowspan="2" id="preco">Preço</th>
									<th rowspan="2" id="categoria">Categoria</th>
									<th rowspan="2" id="quantidade">Quantidade</th>
									<th colspan="2" id="opcao">Opções</th>
									</tr>
									<tr>
									<th  id="editar" axis="opcao">Editar</th>
									<th  id="excluir" axis="opcao">Excluir</th>
									</tr>
								<thead>
								<tbody>
						<c:forEach items="${listaProdutos}" var="produto" varStatus="status">
									<tr>
										
										<td headers="descricao">${produto.descricao}</td>
										<td headers="preco">${produto.valor}</td>
										<td headers="categoria">${produto.categoria}</td>
										<td headers="quantidade">${produto.quantidade}</td>
										<td headers="opcao"><a href="EditarProdutoServlet?id_produto=${produto.id_produto}" class="button2">Editar</a></td>
										<td headers="opcao"><a href="ExcluirProdutoServlet?id_produto=${produto.id_produto}" class="button2">Excluir</a></td>
										
									</tr>
						</c:forEach>	
								</tbody>
						</table>
				</div>
				
		</body>
	</html></html>