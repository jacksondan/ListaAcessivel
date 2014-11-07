package fafica.listaacessivel.negocios.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Lista {
	
	private int id_lista;
	private String descricao;
	private String situacao;
	private String data_criacao_lista;
	private String data_alteracao_lista;
	private int quantidade_total_lista;
	private float valor_total_lista;
	private Cliente cliente;
	private Estabelecimento estabelecimento;
	private List<Produto> produtos;
		
	private SimpleDateFormat dmy;
	
	public Lista(){
		
	}
	
	public Lista(String descricao, String situacao, int quantidade_total_lista,
			float valor_total_lista, Cliente cliente, Estabelecimento estabelecimento, List<Produto> produtos) {
		this.descricao = descricao;
		this.situacao = situacao;
		this.quantidade_total_lista = quantidade_total_lista;
		this.valor_total_lista = valor_total_lista;
		this.cliente = cliente;
		this.estabelecimento = estabelecimento;
		this.produtos = produtos;
		dmy = new SimpleDateFormat("hh:mm - dd/MM/yyyy");
		this.data_criacao_lista = dmy.format(new Date());
		this.data_alteracao_lista = dmy.format(new Date());		
	}
	
	public Lista(int id_lista, String descricao, String situacao, int quantidade_total_lista,
			float valor_total_lista, Cliente cliente, Estabelecimento estabelecimento, List<Produto> produtos) {
		this.id_lista = id_lista;
		this.descricao = descricao;
		this.situacao = situacao;
		this.quantidade_total_lista = quantidade_total_lista;
		this.valor_total_lista = valor_total_lista;
		this.cliente = cliente;
		this.estabelecimento = estabelecimento;
		this.produtos = produtos;
		dmy = new SimpleDateFormat("hh:mm - dd/MM/yyyy");
		this.data_criacao_lista = dmy.format(new Date());
		this.data_alteracao_lista = dmy.format(new Date());
	}

	public int getId_lista() {
		return id_lista;
	}

	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getData_criacao_lista() {
		return data_criacao_lista;
	}

	public void setData_criacao_lista(String data_criacao_lista) {
		this.data_criacao_lista = data_criacao_lista;
	}

	public String getData_alteracao_lista() {
		return data_alteracao_lista;
	}

	public void setData_alteracao_lista(String data_alteracao_lista) {
		this.data_alteracao_lista = data_alteracao_lista;
	}

	public int getQuantidade_total_lista() {
		return quantidade_total_lista;
	}

	public void setQuantidade_total_lista(int quantidade_total_lista) {
		this.quantidade_total_lista = quantidade_total_lista;
	}

	public float getValor_total_lista() {
		return valor_total_lista;
	}

	public void setValor_total_lista(float valor_total_lista) {
		this.valor_total_lista = valor_total_lista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
