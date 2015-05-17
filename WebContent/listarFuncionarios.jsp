	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8" import="fafica.listaacessivel.negocios.entidades.Estabelecimento"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html lang="pt-br">
		<head>
		<meta charset="UTF-8">
		<title>Lista de Funcionários</title>
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
						<h2>Lista de Funcionários</h2>
						${mensagem}
					</header>
					<p class="info">Nessa página existe uma tabela onde é mostrado dados dos 
					funcionarios pressione a letra T para ir direto para  a tabela</p>
					
						<table id="funcionarios" align="center" class="display" summary="Tabela com lista de funcionarios, 
						mostrando nome fantasia">
						<caption>Lista de Funcionários</caption>
								<colgroup>
    							<col />
    							<col />
   			 					<col span="2"/><!-- -->
  								</colgroup>		
								<thead>
								<tr>
									<th rowspan="2" id="matricula">Matrícula</th>
									<th rowspan="2" id="nome">Nome</th>
									<th rowspan="2" id="email">E-mail</th>				
									<th colspan="2" id="opção">Opções</th>
									
								</tr>
									<tr>
									<th id="editar" axis="opção">Editar</th>
									<th id="desativar" axis="opção">Desativar</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listafuncionarios}" var="funcionario" varStatus="status">								
								<tr>

									<td headers="matricula">${funcionario.matricula}</td>
									<td headers="nome">${funcionario.nome}</td>
									<td headers="email">${funcionario.email}</td>
									
									<td headers="opção"><a href="PerfilFuncionarioServlet?id_funcionario=${funcionario.id_usuario}" class="button2">Detalhes</a></td>
									<td headers="opção"><a href="ExcluirFuncionarioServlet?id_funcionario=${funcionario.id_usuario}" class="button2">Desativar</a></td>
									
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
