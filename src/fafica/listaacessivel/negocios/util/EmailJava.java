package fafica.listaacessivel.negocios.util;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
			System.out.println("Enviando email");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listaSolicitada(Lista lista){
		String destino = lista.getCliente().getEmail();
		String titulo="A Sua Lista de Compras - "+lista.getDescricao()+" foi Solicitada";
		String mensagem="Olá "+lista.getCliente().getNome()+", Sua Lista de Compras "+lista.getDescricao()+
				" Foi solicitada!\n Em breve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()+
				" estar�o encaminhado suas compras em sua residência.\n Atenciosamente: Lista Acessivel.";
		
		enviarEmail(titulo, mensagem, destino);
		
	}
	public void listaAtendida(Lista lista){
		
		String destino = lista.getCliente().getEmail();
		String titulo="O Atendimento da sua lista de compras foi confirmado!";
		String mensagemEmail="Olá "+lista.getCliente().getNome()+", Sua Lista de Compras "+lista.getDescricao()+
				" esta sendo atendida!\n Em breve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()+
				" estarão entregando suas compras em sua residência.\n Atenciosamente: Lista Acessivel.";
		
		enviarEmail(titulo, mensagemEmail, destino);
		
	}
}
	
