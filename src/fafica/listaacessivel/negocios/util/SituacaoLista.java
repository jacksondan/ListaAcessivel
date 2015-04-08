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
	
	EMATENDIMENTO{
		public String toString(){
			return "em atendimento";
		}
	},
	
	EMTRANSITO{
		public String toString(){
			return "em transporte";
		}
	},
	
	ATENDIDA {
		public String toString(){
			return "atendida";
		}
	}
	
	
	
}
