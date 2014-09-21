package fafica.listaacessivel.negocios.entidades;

public class Produto {

	private int id_produto;
	private String descricao_produto;
	private String categoria;
	private String peso_produto;
	private int quantidade_produto;
	private float preco_produto;
	private String validade_produto;
	private String marca_produto;
	private String codigo_de_barra;
	private String disponibilidade;
	private int id_estabelecimento;
	private String status;
		
	public Produto() {
		
	}

	public Produto(String descricao_produto, String categoria,
			String peso_produto, int quantidade_produto, float preco_produto,
			String validade_produto, String marca_produto,
			String codigo_de_barra, int id_estabelecimento) {
		super();
		this.descricao_produto = descricao_produto;
		this.categoria = categoria;
		this.peso_produto = peso_produto;
		this.quantidade_produto = quantidade_produto;
		this.preco_produto = preco_produto;
		this.validade_produto = validade_produto;
		this.marca_produto = marca_produto;
		this.codigo_de_barra = codigo_de_barra;
		this.id_estabelecimento = id_estabelecimento;
	}

	public Produto(int id_produto, String descricao_produto, String categoria,
			String peso_produto, int quantidade_produto, float preco_produto,
			String validade_produto, String marca_produto,
			String codigo_de_barra, String disponibilidade,
			int id_estabelecimento) {
		super();
		this.id_produto = id_produto;
		this.descricao_produto = descricao_produto;
		this.categoria = categoria;
		this.peso_produto = peso_produto;
		this.quantidade_produto = quantidade_produto;
		this.preco_produto = preco_produto;
		this.validade_produto = validade_produto;
		this.marca_produto = marca_produto;
		this.codigo_de_barra = codigo_de_barra;
		this.disponibilidade = disponibilidade;
		this.id_estabelecimento = id_estabelecimento;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getDescricao_produto() {
		return descricao_produto;
	}

	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPeso_produto() {
		return peso_produto;
	}

	public void setPeso_produto(String peso_produto) {
		this.peso_produto = peso_produto;
	}

	public int getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public float getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(float preco_produto) {
		this.preco_produto = preco_produto;
	}

	public String getValidade_produto() {
		return validade_produto;
	}

	public void setValidade_produto(String validade_produto) {
		this.validade_produto = validade_produto;
	}

	public String getMarca_produto() {
		return marca_produto;
	}

	public void setMarca_produto(String marca_produto) {
		this.marca_produto = marca_produto;
	}

	public String getCodigo_de_barra() {
		return codigo_de_barra;
	}

	public void setCodigo_de_barra(String codigo_de_barra) {
		this.codigo_de_barra = codigo_de_barra;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int getId_estabelecimento() {
		return id_estabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
