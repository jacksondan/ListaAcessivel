<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${cliente.nome}- Inicio</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<%@include file="headerCliente.html"%>



	<div id="content2">

		<header class="major">
			<h2>Criar Lista Passo - 02</h2>
			
		</header>

			<c:forEach items="${listaEstabelecimentos}" var="estabelecimento"
				varStatus="status">
				<table class="default" summary="estabelecimentos">
					<caption>Estabelecimentos</caption>
					<tr>
						<td>
							<a
							href="EstabelecimentoSelecionadoServlet?id_estabelecimento=${estabelecimento.id_estabelecimento}"
							class="button3">${estabelecimento.nome_fantasia}
							</a>
						</td>
					</tr>
				</table>
			</c:forEach>
		
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
			
		