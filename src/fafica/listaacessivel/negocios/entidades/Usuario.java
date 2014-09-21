package fafica.listaacessivel.negocios.entidades;

import java.util.ArrayList;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String cidade;
	private String estado;
	private String rua;
	private ArrayList<String> telefones;
	private String bairro;
	private String numero;
	private String referencia;
	private String cep;
	private String status; 
	
	public Usuario() {
		
	}

	public Usuario(String nome, String cpf, String email, String senha,
			String cidade, String estado, String rua, String bairro,
			String numero, String referencia, String cep) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.referencia = referencia;
		this.cep = cep;
	}

	public Usuario(int id_usuario, String nome, String cpf, String email,
			String senha, String cidade, String estado, String rua,
			String bairro, String numero, String referencia, String cep) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.referencia = referencia;
		this.cep = cep;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public ArrayList<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
