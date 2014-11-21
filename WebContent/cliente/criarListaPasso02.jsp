<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NomedoUsuario - Inicio</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

	<%@include file="headerCliente.html"%>



	<div id="content">

		<header class="major">
			<h2>Criar Lista Passo - 02</h2>
			<h3>Selecionar Estabelecimento</h3>
		</header>

		<fieldset>

			<c:forEach items="${listaestabelecimento}" var="estabelecimento"
				varStatus="status">
				<table class="default">

					<tr>

					</tr>

					<tr>
						<td><a
							href="EstabelecimentoSelecionadoServlet?id_estabelecimento=${estabelecimento.Id_estabelecimento}"
							class="button3">${estabelecimento.getNome_fantasia}</a></td>
					</tr>
				</table>
			</c:forEach>
		</fieldset>
	</div>
	<%@include file="../footer.html"%>