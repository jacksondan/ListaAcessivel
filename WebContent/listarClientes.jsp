	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE HTML>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<%@include file="headerAdmin.html" %>
		<%@include file="sidebarAdmin.html" %>
			
			
			<div id="content2">
					<header class="major">		
						<h2>Lista de Clientes</h2>
					</header>
					<p class="info">Nessa página existe uma tabela onde é mostrado dados dos 
					Clientes pressione a letra T para ir direto para  a tabela</p>

						<table align="center" class="default" summary="Tabela com lista de clientes resumida, 
						mostrando nome, cpf, cidade, bairro, telefones e opções do administrador, 
						os dados dos estabelecimentos começão a ser exbidos na 3ª linha da tabela, 
						começando pela coluna de Nome do cliente">
						<caption>Tabela de Clientes</caption>

								<colgroup>
    							<col />
    							<col />
   			 					<col span="2" /><!-- Agrupamento das colunas Português e Matemática à célula de cabeçalho Matérias -->
  								</colgroup>
								<thead>
								
								<tr>
									<th rowspan="2" id="nome">Nome</th>
									<th rowspan="2" id="cpf">CPF</th>
									<th rowspan="2" id="email">Email</th>
									<th rowspan="2" id="cidade">Cidade</th>
									<th rowspan="2" id="bairro">Bairro</th>
									<th colspan="2" id="telefones">Telefones</th>
									<th colspan="2" id="opção">Opções</th>
									
								</tr>
									<tr>
									<th id="telefone 1" axis="telefones">Telefone 1</th>
									<th id="telefone 2" axis="telefones">Telefone 2</th>
									<th id="detalhes" axis="opção">Detalhes</th>
									<th id="desativar" axis="opção">Desativar</th>
									</tr>
									<tr>
									
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
									<td headers="opção"><a href="PerfilClienteServlet?id_cliente=${cliente.id_usuario}" class="button2">Detalhes</a></td>
									<td headers="opção"><a href="ExcluirClienteServletServlet?id_cliente=${cliente.id_usuario}" class="button2">Desativar</a></td>
									
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