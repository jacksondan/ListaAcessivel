package fafica.listaacessivel.negocios.util;

import java.text.Normalizer;

public class Acentuacao {

	public static String limparAcentuacao(String palavra)     {  
		//palavra = palavra.replaceAll(" ","_");  
		palavra = Normalizer.normalize(palavra, Normalizer.Form.NFD);  
		palavra = palavra.replaceAll("[^\\p{ASCII}]", ""); 
		palavra = palavra.toLowerCase();
		return palavra;  
	}  
	
}
