 function consultacep(cep){
  cep = cep.replace(/\D/g,"")
      url="http://cep.correiocontrol.com.br/"+cep+".js"
      s=document.createElement('script')
      s.setAttribute('charset','utf-8')
      s.src=url
      document.querySelector('head').appendChild(s)
    }

    function correiocontrolcep(valor){
      if (valor.erro) {
        alert('CEP Inválido');        
        return;
      };

      document.getElementById('cidade').value=valor.localidade
      document.getElementById('estado').value=valor.uf
      document.getElementById("bairro").value=valor.bairro
    }
    
   
    jQuery(function($){
 	   $("#cep").mask("99999-999");

 });
    
    function validarSenha(){
    	senhaNova = document.f1.senhaNova.value
    	confirmarSenha = document.f1.confirmarSenha.value
    	
    	if(senhaNova != confirmarSenha){
    		alert("Senhas Incompatíveis!")
    		document.f1.confirmarSenha.focus()
    	}
    }