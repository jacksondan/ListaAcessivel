package fafica.listaacessivel.negocios.entidades;

import java.util.ArrayList;

public class Estabelecimento {
	private int id_estabelecimento;
	private String nome_fantasia;
	private String nome_juridico; //Atriburo Unico no BD
	private String categoria;
	private String CNPJ;
	private String email;
	private String senha;
	private ArrayList<String> telefones;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String referencia;
	private String status;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String categoria, String cNPJ, String email, String senha,
			String rua, String numero, String bairro, String cidade,
			String estado, String cep, String referencia) {
		super();
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		CNPJ = cNPJ;
		this.email = email;
		this.senha = senha;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.referencia = referencia;
	}
	
	public Estabelecimento(int id_estabelecimento, String nome_fantasia,
			String nome_juridico, String categoria, String cNPJ, String email,
			String senha, String rua, String numero, String bairro,
			String cidade, String estado, String cep, String referencia) {
		super();
		this.id_estabelecimento = id_estabelecimento;
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		CNPJ = cNPJ;
		this.email = email;
		this.senha = senha;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.referencia = referencia;
	}

	public int getId_estabelecimento() {
		return id_estabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getNome_juridico() {
		return nome_juridico;
	}

	public void setNome_juridico(String nome_juridico) {
		this.nome_juridico = nome_juridico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
