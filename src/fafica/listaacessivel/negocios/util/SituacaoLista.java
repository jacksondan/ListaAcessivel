package fafica.listaacessivel.negocios.util;

public enum SituacaoLista {
	
	CRIADA {
		public String toString(){
			return "criada";
		}
	},
	
	SOLICITADA {
		public String toString(){
			return "solicitada";
		}
	},
	
	ATENDIDA {
		public String toString(){
			return "atendida";
		}
	},
	
	EMTRANSITO{
		public String toString(){
			return "em transito";
		}
	},
	
	ENATENDIMENTO{
		public String toString(){
			return "em atendimento";
		}
	}
	
	
	
}
