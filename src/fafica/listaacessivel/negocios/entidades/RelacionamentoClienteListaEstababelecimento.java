package fafica.listaacessivel.negocios.entidades;

public class RelacionamentoClienteListaEstababelecimento {
	
	private String situacao;
	private int id_lista;
	private int id_cliente;
	private int id_estabelecimento;
	
	public RelacionamentoClienteListaEstababelecimento(){
		
	}
	
	public RelacionamentoClienteListaEstababelecimento(int id_lista, int id_cliente, int id_estabelecimento, String situacao){
		this.id_cliente = id_cliente;
		this.id_estabelecimento = id_estabelecimento;
		this.id_lista = id_lista;
		this.situacao = situacao;				
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getId_lista() {
		return id_lista;
	}

	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_estabelecimento() {
		return id_estabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}
	
}
