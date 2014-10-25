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
    }
    
   
    jQuery(function($){
 	   $("#cep").mask("99999-999");

 });