	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Clientes</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/layoutabela/clientes.css">
		<script type="text/javascript"  src="js/jquery.js"></script>		
		<script type="text/javascript" src="js/jquery.dataTables.js"></script>
		<script type="text/javascript">
		    $(document).ready(function() {
		        $('#clientes').dataTable({
		        	"ordering": false,
		        	"lengthMenu": [[5, 10, 30, -1], [5, 10, 30, "Todos"]],
		        	 "language": {
		              "sUrl" : "js/pt-br.txt"
		             }    
		        })});
		
		    </script>
	</head>
	<body>
		<%@include file="headerAdmin.html" %>
		<%@include file="sidebarAdmin.html" %>
			
			
			<div id="content3">
					<header class="major">		
						<h2>Lista de Clientes</h2>
						${mensagem}
					</header>
					<p class="info">Nessa p�gina existe uma tabela onde � mostrado dados dos 
					Clientes pressione a letra T para ir direto para  a tabela</p>

						<table  id="clientes" align="center" class="display" summary="Tabela com lista de clientes resumida, 
						mostrando nome, cpf, cidade, bairro, telefones e op��es do administrador, 
						os dados dos clientes come��o a ser exbidos na 3� linha da tabela, 
						come�ando pela coluna de Nome do cliente">
						<caption>Tabela de Clientes</caption>

								<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!--  -->
  								</colgroup>
								<thead>
								
								<tr>
									<th rowspan="2" id="nome">Nome</th>
									<th rowspan="2" id="cpf">CPF</th>
									<th rowspan="2" id="email">Email</th>
									<th rowspan="2" id="cidade">Cidade</th>
									<th rowspan="2" id="bairro">Bairro</th>
									<th colspan="2" id="telefones">Telefones</th>
									<th colspan="2" id="op��o">Op��es</th>
									
								</tr>
									<tr>
									<th id="telefone 1" axis="telefones">Telefone 1</th>
									<th id="telefone 2" axis="telefones">Telefone 2</th>
									<th id="detalhes" axis="op��o">Detalhes</th>
									<th id="desativar" axis="op��o">Desativar</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listacliente}" var="cliente" varStatus="status">								
								<tr>
									<td headers="nome">${cliente.nome}</td>
									<td headers="cpf">${cliente.cpf}</td>
									<td headers="email">${cliente.email}</td>
									<td headers="cidade">${cliente.endereco.cidade}</td>
									<td headers="bairro">${cliente.endereco.bairro}</td>
									<td headers="telefone 1">${cliente.telefones[0]}</td>
									<td headers="telefone 2">${cliente.telefones[1]}</td>
									<td headers="op��o"><a href="PerfilClienteServlet?id_cliente=${cliente.id_usuario}" class="button2">Detalhes</a></td>
									<td headers="op��o"><a href="ExcluirClienteServlet?id_cliente=${cliente.id_usuario}" class="button2">Desativar</a></td>
									
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
