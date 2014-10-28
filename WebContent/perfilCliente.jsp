<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 	import="java.util.ArrayList"
    import= "fafica.listaacessivel.negocios.Fachada"
    import= "fafica.listaacessivel.negocios.IFachada"
    import= "fafica.listaacessivel.negocios.entidades.Cliente"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 <jsp:useBean id="cliente" class="fafica.listaacessivel.ui.PerfilClienteServlet" />
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

			<%-- <%
			IFachada fachada = Fachada.getInstance();
			Cliente usuarioDaSessao = (Cliente) session.getAttribute("acessoUsuario");
			Cliente usuario = fachada.pesquisarCliente(usuarioDaSessao);
			ArrayList <String> telefones = new ArrayList<String>();
			telefones= usuario.getTelefones();
			%> --%>
				
<%@include file="headerUs.html" %>

			
			
			<div id="content">
			<!-- titulo do conteudo-->
			<header class="major">		
					<h2>Perfil</h2>
			</header>
			<!-- Conteudo-->
			
			
			<fieldset >
			<legend>Dados Pessoais</legend>
				E-mail: ${usuario.email}<br>
				
				Nome: ${usuario.nome}<br>
				
				CPF: ${usuario.cpf}<br>
				
			</fieldset>
			
			<fieldset>
			<legend>Telefones Para Contato</legend>
			
			<c:forEach items="${listacliente}" var="cliente" varStatus="status">
			Telefone 1: Teste<br>
			Telefone 2: Teste
			</fieldset>
			</c:forEach>	
			
				<fieldset >
			
			<legend>Dados de Localização</legend>
				Estado: ${cliente.estado}<br>
				
				CEP: ${cliente.cep}<br>
				
				Cidade: ${cliente.cidade}<br>
				
				Bairro: ${cliente.bairro}<br>
				
				Rua: ${cliente.rua}<br>
				
				
				Número: ${cliente.numero}<br>
				
				Referência: ${cliente.referencia}<br>
			</fieldset>
							<div class="nav">
										<ul class="menu">
											<li><a href="editarUsuario.jsp" class="button">Editar</a></li>
										</ul>
							</div>
			<!-- menu direito-->
			
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