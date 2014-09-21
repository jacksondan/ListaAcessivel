<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="fafica.listaacessivel.negocios.entidades.Usuario"
	import="fafica.listaacessivel.negocios.Fachada"
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
		<div id="container">
				<div id="header-wrapper">
				<div id="header" class="container">
				
										<h1 id="logo"><a href="index.jsp"><img src="images/g4314.png" alt="Logo Lista acessível"  style="width:6.5em ;heigth:8.5em;"></a></h1>
		
					</div>
				</div>
			<div id="left"></div>
			<div id="content">
				<header class="major">		
					<h2>Editar Perfil</h2>
				</header>
			<!-- Formulário aqui! -->
			
			<%
			IFachada fachada = Fachada.getInstance();
			Usuario usuarioDaSessao = (Usuario) session.getAttribute("acessoUsuario");
			Usuario usuario = fachada.pesquisarUsuario(usuarioDaSessao);
			%>
			
			<form method="post" action="http://localhost:8080/ListaAcessivel/EditarUsuario">
			<input type="hidden" name="id_usuario" value="<%=usuario.getId_usuario()%>">
			<fieldset >
			<legend>Dados de Login</legend>
				<label for="email">E-mail:</label>
				<input type="email"  name="email" id="email" value="<%=usuario.getEmail()%>"size=60>
				
				<label for="senha">Senha:</label><br>
				<input type="password"  name="senha" id="senha" value="<%=usuario.getSenha()%>" size=15>
			</fieldset>
			<fieldset >
			<legend>Dados Pessoais</legend>
				<label for="nome">Nome Completo</label>
				<input type="text"  name="nome" id="nome" value="<%=usuario.getNome()%>" size=60>
				
				<label for="cpf">CPF:</label><br>
				<input type="text"  name="cpf" id="cpf" value="<%=usuario.getCpf()%>" size=12><br>
				</fieldset>
				
				<fieldset>
					<legend>Telefones para Contato:</legend>
					<label for="telefone1">Telefone 1:</label><br>
					<input type="text" placeholder="Digite seu telefone" name="telefone1" id="telefone1" size=20><br>
					<label for="telefone 2">Telefone 2:</label><br>
					<input type="text" placeholder="Digite seu telefone" name="telefone2" id="telefone2" size=20><br>
				</fieldset>
				
				<fieldset >
				<legend>Dados de Localização</legend>
				<p>
				<label for="lista de estados">Selecione o Estado:<br />
				<select name="estado" id="listade estados">
				<option selected="não selecionado" value="não selecionado">Escolha o Estado</option>
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
				<input type="text"  name="cep" id="cep"  value="<%=usuario.getCep()%>"size=20><br>
				
				<label for="cidade">Cidade:</label><br>
				<input type="text"  name="cidade" id="cidade"  value="<%=usuario.getCidade()%>"size=30><br>
				
				<label for="bairro">Bairro:</label><br>
				<input type="text"  name="bairro" id="bairro" value="<%=usuario.getBairro()%>" size=30><br>
				
				<label for="rua">Rua:</label><br>
				<input type="text"  name="rua" id="rua" value="<%=usuario.getRua()%>" size=60><br>
				
				<label for="numero">Número:</label><br>
				<input type="text"  name="numero" id="numero" value="<%=usuario.getNumero()%>" size=4><br>
				
				<label for="referencia">Referência:</label><br>
				<input type="text"  name="referencia" id="referencia" value="<%=usuario.getReferencia()%>"size=30><br>
			
				</fieldset>
					
									<div class="12u">
										<ul class="actions">
											<li><input type="submit" value="Salvar" /></li>
											<li><input type="reset" value="Limpar" /></li>
										</ul>
									</div>
						
					
			</form>
			
			</div>
			<div id="right"></div>
			<div id="footer">
			<div id="copyright" class="container">
					<ul class="icons">
						<li>&copy; TechBin. Todos os direitos reservados.</li><li>Design: <a href="http://facebook.com/Edwardhll">Eduardo Andrade</a></li>
					</ul>
				</div>
			</div>
						
			</div>
		
</body>
</html>