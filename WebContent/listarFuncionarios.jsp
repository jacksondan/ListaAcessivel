<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
		<title>Lista de Funcion�rios</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/layoutabela/funcionarios.css">
		<script src="js/script.js"></script>
 		<script type="text/javascript"  src="js/jquery.js"></script>		
		<script type="text/javascript" src="js/jquery.dataTables.js"></script>
		<script type="text/javascript">
		    $(document).ready(function() {
		        $('#funcionarios').dataTable({
		        	"ordering": false,
		        	"lengthMenu": [[5, 10, 30, -1], [5, 10, 30, "Todos"]],
		        	 "language": {
		              "sUrl" : "js/pt-br.txt"
		             }    
		        })});
		
		    </script>
<link rel="shortcut icon" href="images/logtop.png" />
	</head>
	<body>
			<%@include  file="headerEstabelecimento.html" %>
			<%@include file="sidebarEstabelecimento.jsp"%>
		
				<div id="content3">
					<header class="major">		
						<h2>Lista de Funcion�rios</h2>
						${mensagem}
					</header>
					<p class="info">Nessa p�gina existe uma tabela onde � mostrado dados dos 
					funcionarios pressione a letra T para ir direto para  a tabela</p>
					
						<table id="funcionarios" align="center" class="display" summary="Tabela com lista de funcionarios, 
						mostrando nome fantasia">
						<caption>Lista de Funcion�rios</caption>
								<colgroup>
    							<col />
    							<col />
   			 					<col span="2"/><!-- -->
  								</colgroup>		
								<thead>
								<tr>
									<th rowspan="2" id="matricula">Matr�cula</th>
									<th rowspan="2" id="nome">Nome</th>
									<th rowspan="2" id="email">E-mail</th>				
									<th colspan="2" id="op��o">Op��es</th>
									
								</tr>
									<tr>
									<th id="editar" axis="op��o">Editar</th>
									<th id="desativar" axis="op��o">Desativar</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listafuncionarios}" var="funcionario" varStatus="status">								
								<tr>

									<td headers="matricula">${funcionario.matricula}</td>
									<td headers="nome">${funcionario.nome}</td>
									<td headers="email">${funcionario.email}</td>
									
									<td headers="op��o"><a href="PerfilFuncionarioServlet?id_funcionario=${funcionario.id_usuario}" class="button2">Detalhes</a></td>
									<td headers="op��o"><a href="ExcluirFuncionarioServlet?id_funcionario=${funcionario.id_usuario}" class="button2">Desativar</a></td>
									
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
