package fafica.listaacessivel.negocios.util;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Lista;


public class EmailJava {
	private Email email;
	
	public EmailJava(){
		email = new SimpleEmail();
		configure();
	}
	
	private void configure(){
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setDebug(true);
		//email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setAuthentication("listaacessivel@gmail.com","grupotechbin");
		email.setSSLOnConnect(true);
		
	}
	
	private void enviarEmail(String titulo,String mensagem,String destino){
		try {	
			email.setFrom("listaacessivel@gmail.com");
			email.setSubject(titulo);
			email.setMsg(mensagem);
			email.addTo(destino);
			email.send();
			System.out.println("Email Enviado");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listaSolicitada(Lista lista){
		String destino = lista.getCliente().getEmail();
		String titulo="A Sua Lista de Compras - "+lista.getDescricao()+" foi Solicitada";
		String mensagem="Olá "+lista.getCliente().getNome()+"\n"
				+ "Sua Lista de Compras: "+lista.getDescricao()
				+", foi solicitada!\n Em breve os atendentes do estabelecimento: "+lista.getEstabelecimento().getNome_fantasia()
				+", estarão verficando sua lista para o encaminhamento dos produtos a sua residência.\n Atenciosamente: Lista Acessivel."
				+"\nDados da lista: " + "\nDescrição: " + lista.getDescricao() + "\nValor: " + lista.getValor_total() + "\n"
				+ "\nQuantidade de produtos: "+lista.getQuantidade_total()+"\nEndereço de Entrega: \n" + lista.getCliente().getEndereco().toString(); 
		
				
		
		enviarEmail(titulo, mensagem, destino);
		
	}
	
	public void listaEmAtendimento(Lista lista){
		
		String destino = lista.getCliente().getEmail();
		String titulo="O Atendimento da sua lista de compras foi iniciado!";
		String mensagemEmail="Olá "+lista.getCliente().getNome()+"\n"
				+ "Sua Lista de Compras "+lista.getDescricao()
				+" esta sendo atendida!\n Em breve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()
				+" estarão entregando suas compras em sua residência.\n Atenciosamente: Lista Acessivel."
				+"\nDados da lista: " + "\nDescrição: " + lista.getDescricao() + "\nValor: " + lista.getValor_total() + "\n"
				+ "\nQuantidade de produtos: "+lista.getQuantidade_total()+ "\nEndereço de Entrega: \n" + lista.getCliente().getEndereco().toString(); ;
		
		enviarEmail(titulo, mensagemEmail, destino);
		
	}
	
	public void listaEmTransito(Lista lista){
			
			String destino = lista.getCliente().getEmail();
			String titulo="Sua Lista de Compras está  sendo emcaminhada!";
			String mensagemEmail="Olá "+lista.getCliente().getNome()+"\n"
					+ "Sua Lista de Compras "+lista.getDescricao()
					+" esta sendo transportada para seu Endereço !\n Em breve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()
					+" estarão entregando suas compras em sua residência.\n Atenciosamente: Lista Acessivel."
					+"\nDados da lista: " + "\nDescrição: " + lista.getDescricao() + "\nValor: " + lista.getValor_total() + "\n"
					+ "\nQuantidade de produtos: "+lista.getQuantidade_total()+ "\nEndereço de Entrega: \n" + lista.getCliente().getEndereco().toString(); ;
			
			enviarEmail(titulo, mensagemEmail, destino);
			
	}
	
	public void listaAtendida(Lista lista){
		
		String destino = lista.getCliente().getEmail();
		String titulo="O Atendimento da sua lista de compras foi concluído!";
		String mensagemEmail="Olá "+lista.getCliente().getNome()+"\n"
				+ "Sua Lista de Compras "+lista.getDescricao()
				+" foi Concluída e entregre.!\n Pelo estabelecimento "+lista.getEstabelecimento().getNome_fantasia()
				+"\n Atenciosamente: Lista Acessivel."
				+"\nDados da lista: " + "\nDescrição: " + lista.getDescricao() + "\nValor: " + lista.getValor_total() + "\n"
				+ "\nQuantidade de produtos: "+lista.getQuantidade_total()+ "\nEndereço de Entrega: \n" + lista.getCliente().getEndereco().toString(); ;
		
		enviarEmail(titulo, mensagemEmail, destino);
		
	}
	
	public void recuperarSenha(Cliente cliente){
		String destino = cliente.getEmail();
		String titulo="Recuperação de senha Lista Acessível!";
		String mensagemEmail="Olá "+cliente.getNome()+"\n"
				+ "recebemos seu pedido de recuperação de senha, para prosseguir com a troca de sua senha "
				+ "clique no link abaixo e preencha as informações necessárias.\n"
				+ "Caso você não tenha solicitado a recuperação da senha, desconsidere essa mensagem ou entre em contato "
				+ "no Fale Conosco para mais informações.\n"
				+ "Obrigado.\n\n"
				+ "http://"+IpConection.IP.toString()+":8080/ListaAcessivel/RecuperarSenhaPasso2MobileServlet?id_cliente="+cliente.getId_usuario()
				+ ""
				+ "";
		
		enviarEmail(titulo, mensagemEmail, destino);
	}
}
	
