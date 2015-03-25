package fafica.listaacessivel.ui.util;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EmailJava {
	Email email;
	
	public EmailJava(){
		email = new SimpleEmail();
		configure();
	}
	
	public void configure(){
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setDebug(true);
		//email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setAuthentication("listaacessivel@gmail.com","grupotechbin");
		email.setSSLOnConnect(true);
		
	}
	
	public void enviarEmail(String titulo,String mensagem,String destino){
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
}
	
