package fafica.listaacessivel.negocios.entidades;

import java.util.List;

public class Estabelecimento{
	
	
	private int id_estabelecimento;
	private String nome_fantasia;
	private String nome_juridico;
	private String email;
	private String senha;
	private String categoria;
	private String cnpj;
	private Endereco endereco;
	private List <String> telefones;
	private Administrador administrador;
	
	public Estabelecimento(){
		
	}
	
	
	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String email, String categoria, String cnpj, Endereco endereco,
			String senha, List<String> telefones, Administrador administrador) {
		super();
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.email = email;
		this.categoria = categoria;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.senha = senha;
		this.telefones = telefones;
		this.administrador = administrador;
	}
	
	
	public Estabelecimento(int id_estabelecimento, String nome_fantasia,
			String nome_juridico, String email, String categoria, String cnpj,
			Endereco endereco, String senha, List<String> telefones, Administrador administrador) {
		super();
		this.id_estabelecimento = id_estabelecimento;
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.email = email;
		this.categoria = categoria;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.senha = senha;
		this.telefones = telefones;
		this.administrador = administrador;
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	
}
