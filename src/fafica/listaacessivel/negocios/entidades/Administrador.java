package fafica.listaacessivel.negocios.entidades;

public class Administrador extends Usuario{
	private int id_administrador;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
		
	public Administrador() {
		
	}

	public Administrador(String nome, String email, String cpf,
			String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Administrador(int id_administrador, String nome, String email,
			String cpf, String senha) {
		super();
		this.id_administrador = id_administrador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
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
}
