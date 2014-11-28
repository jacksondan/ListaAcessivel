package fafica.listaacessivel.negocios.entidades;

import java.util.List;

public class Administrador extends Usuario{
	private int id_administrador;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private List<String> telefones;
	
	public Administrador() {
		
	}

	public Administrador(String nome, String email, String cpf,
			String senha, List<String> telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.telefones = telefones;
	}

	public Administrador(int id_administrador, String nome, String email,
			String cpf, String senha, List<String> telefones) {
		super();
		this.id_administrador = id_administrador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.telefones = telefones;
	}

	public int getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(int id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
		
}
