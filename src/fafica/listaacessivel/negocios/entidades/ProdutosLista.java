package fafica.listaacessivel.negocios.entidades;

public class ProdutosLista {
	private int id_lista;
	private int id_produto;
	private int quantidade;
	private String status;
	
	public ProdutosLista() {
		
	}

	public ProdutosLista(int id_lista, int id_produto, int quantidade) {
		super();
		this.id_lista = id_lista;
		this.id_produto = id_produto;
		this.quantidade = quantidade;
	}



	public int getId_lista() {
		return id_lista;
	}

	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
