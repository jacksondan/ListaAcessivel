package fafica.listaacessivel.ui.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class CriptografiaSenha {
	
	public static String encriptar(String senha) {     
        try {     
             MessageDigest digest = MessageDigest.getInstance("MD5");      
             digest.update(senha.getBytes());      
             BASE64Encoder encoder = new BASE64Encoder ();      
             return encoder.encode (digest.digest ());      
        } catch (NoSuchAlgorithmException ns) {     
             ns.printStackTrace ();      
             return senha;      
        }      
   }
		
}
