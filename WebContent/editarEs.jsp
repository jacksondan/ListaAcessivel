<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		import="fafica.listaacessivel.negocios.entidades.Estabelecimento"
		import="fafica.listaacessivel.negocios.Fachada"
		import="java.util.ArrayList"
		import="fafica.listaacessivel.negocios.IFachada"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
		<%@include file="headerEs.html" %>

		<%@include file="sidebarEs.html" %>
			<div id="content">
				<header class="major">		
					<h2>Editar Estabelecimento</h2>
				</header>
			<%
				IFachada fachada = Fachada.getInstance();
				Estabelecimento estabelciomentoDaSessao = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
				Estabelecimento estabelecimento = fachada.pesquisarEstabelecimento(estabelciomentoDaSessao);
				ArrayList <String> telefones = new ArrayList<String>();
				telefones= estabelecimento.getTelefones();
				
				
			%>
			<form method="post" action="http://localhost:8080/ListaAcessivel/EditarEstabelecimento">
			<fieldset >
			<legend>Dados de Login</legend>
				<label for="email">E-mail:</label>
				<input type="hidden"  name="id_estabelecimento" id="email" value="<%=estabelecimento.getId_estabelecimento()%>">
				<input type="email"  name="email" id="email" value="<%=estabelecimento.getEmail()%>" size=60>
				
				<label for="senha">Senha:</label><br>
				<input type="password"  name="senha" id="senha" value="<%=estabelecimento.getSenha()%>"  size=15>
			</fieldset>
			
			<fieldset >
			<legend>Dados do Estabelecimento</legend>
				
				<label for="nome_fantasia">Nome Fantasia:</label>
				<input type="text"  name="nome_fantasia" id="nome_fantasia" value="<%=estabelecimento.getNome_fantasia()%>" size=60>

				
				<label for="nome_juridico">Nome Jurídico:</label>
				<input type="text"  name="nome_juridico" id="nome_juridico"value="<%=estabelecimento.getNome_juridico()%>"  size=60>
				
				<label for="cnpj">CPNPJ:</label><br>
				<input type="text"  name="cnpj" id="cnpj" value="<%=estabelecimento.getCNPJ()%>" size=12><br>
				
				Categoria:<br>
				<select name="categoria">
				<option selected="<%=estabelecimento.getCategoria()%>" value="<%=estabelecimento.getCategoria()%>"><%=estabelecimento.getCategoria()%></option>
				<option>Supermercado</option>
				<option>Shopping</option>
				<option>Frigorífico</option>
				<option>Fast-Food</option>
				</select><br>
				</fieldset>
				
				<fieldset>
				<legend>Telefones para Contato</legend>
					<label for="telefone1">Telefone 1:</label><br>
					<input type="text"  name="telefone1" id="telefone1" value="<%=telefones.get(0)%>" size=20><br>
					<label for="telefone 2">Telefone 2:</label><br>
					<input type="text"  name="telefone2" id="telefone2" value="<%=telefones.get(1)%>" size=20><br>
				</fieldset>
				<fieldset >
			<legend>Dados de Localização</legend>
				<p>
				<label for="lista de estados">Selecione o Estado:<br />
				<select name="estado" id="listade estados">
				<option selected="<%=estabelecimento.getEstado()%>" value="<%=estabelecimento.getEstado()%>"><%=estabelecimento.getEstado()%></option>
				<option value="AC">Acre</option>
				<option value="AL">Alagoas</option>
				<option value="AP">Amapá</option>
				<option value="AM">Amazonas</option>
				<option value="BA">Bahia</option>
				<option value="CE">Ceará</option>
				<option value="DF">Distrito Federal</option>
				<option value="ES">Espírito Santo</option>
				<option value="GO">Goiás</option>
				<option value="MA">Maranhão</option>
				<option value="MT">Mato Grosso</option>
				<option value="MS">Mato Grosso do Sul</option>
				<option value="MG">Minas Gerais</option>
				<option value="PA">Pará</option>
				<option value="PB">Paraíba</option>
				<option value="PR">Paraná</option>
				<option value="PE">Pernambuco</option>
				<option value="PI">Piauí</option>
				<option value="RJ">Rio de Janeiro</option>
				<option value="RN">Rio Grande do Norte</option>
				<option value="RS">Rio Grande do Sul</option>
				<option value="RO">Rondônia</option>
				<option value="RR">Roraima</option>
				<option value="SC">Santa Catarina</option>
				<option value="SP">São Paulo</option>
				<option value="SE">Sergipe</option>
				<option value="TO">Tocantins</option>
				</select>
				</label>
				</p>
				
				<label for="cep">CEP:</label><br>
				<input type="text"  name="cep" id="cep"  value="<%=estabelecimento.getCep() %>" size=20><br>
				
				<label for="cidade">Cidade:</label><br>
				<input type="text" name="cidade" id="cidade"  value="<%=estabelecimento.getCidade() %>"  size=30><br>
				
				<label for="bairro">Bairro:</label><br>
				<input type="text" name="bairro" id="bairro"  value="<%=estabelecimento.getBairro() %>"  size=30><br>
				
				<label for="rua">Rua:</label><br>
				<input type="text" name="rua" id="rua"  value="<%=estabelecimento.getRua() %>"  size=60><br>
				
				<label for="numero">Número:</label><br>
				<input type="text"  name="numero" id="numero"  value="<%=estabelecimento.getNumero() %>"  size=4><br>
				
				<label for="referencia">Referência:</label><br>
				<input type="text"  name="referencia" id="referencia"  value="<%=estabelecimento.getReferencia() %>" size=30><br>
			
			</fieldset>
					
									<div class="12u">
										<ul class="actions">
											<li><input type="submit" value="Salvar" /></li>
											
										</ul>
									</div>
						
					
			</form>
			</div>
			
		
</body>
</html>