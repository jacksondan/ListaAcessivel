<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="row">
	<section class="6u">
		<form action="http://localhost:8080/TechBin/ContatoServlet"
			method="post">
			<div class="row half">
				<div class="6u">
					<input name="nome" placeholder="Nome" type="text" />
				</div>
				<div class="6u">
					<input name="email" placeholder="Email" type="text" />
				</div>
			</div>
			<div class="row half">
				<div class="12u">
					<textarea name="mensagem" placeholder="Messagem"></textarea>
				</div>
			</div>
			<div class="row half">
				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Enviar" /></li>
						<li><input type="reset" value="Limpar" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
</div>
