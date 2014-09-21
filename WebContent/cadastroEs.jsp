<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
					<h2>Cadastro - Estabelecimento</h2>
				</header>
			
			<form method="post" action="http://localhost:8080/ListaAcessivel/cadastroEs">
			<fieldset >
			<legend>Dados de Login</legend>
				<label for="email">E-mail:</label>
				<input type="email" placeholder="Digite o E-mail" name="email" id="email" size=60>
				
				<label for="senha">Senha:</label><br>
				<input type="password" placeholder="Digite a Senha" name="senha" id="senha" size=15>
			</fieldset>
			<fieldset >
			<legend>Dados do Estabelecimento</legend>
				<label for="nome_fantasia">Nome Fantasia:</label>
				<input type="text" placeholder="Digite o nome fantasia" name="nome_fantasia" id="nome_fantasia" size=60>
				
				<label for="nome_juridico">Nome Jurídico:</label>
				<input type="text" placeholder="Digite o nome Jurídico" name="nome_juridico" id="nome_juridico" size=60>
				
				<label for="cnpj">CPNPJ:</label><br>
				<input type="text" placeholder="Digite o CNPJ" name="cnpj" id="cnpj" size=12><br>
				
				Categoria:<br>
				<select name="categoria">
				<option>Supermercado</option>
				<option>Shopping</option>
				<option>Frigorífico</option>
				<option>Fast-Food</option>
				</select><br>
				
				<p>Telefones para Contato:</p>
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
				<input type="text" placeholder="Digite o CEP" name="cep" id="cep" size=20><br>
				
				<label for="cidade">Cidade:</label><br>
				<input type="text" placeholder="Digite a Cidade" name="cidade" id="cidade" size=30><br>
				
				<label for="bairro">Bairro:</label><br>
				<input type="text" placeholder="Digite o Bairro" name="bairro" id="bairro" size=30><br>
				
				<label for="rua">Rua:</label><br>
				<input type="text" placeholder="Digite a Rua" name="rua" id="rua" size=60><br>
				
				<label for="numero">Número:</label><br>
				<input type="text" placeholder="Digite número" name="numero" id="numero" size=4><br>
				
				<label for="referencia">Referência:</label><br>
				<input type="text" placeholder="Digite Referência" name="referencia" id="referencia" size=30><br>
			
			</fieldset>
					
									<div class="12u">
										<ul class="actions">
											<li><input type="submit" value="Confirmar Cadastro" /></li>
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