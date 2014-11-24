package fafica.listaacessivel.negocios.entidades;

public class Administador {
	private int id_administrador;
	private String nome;
	private String email;
	private String matricula;
	private String senha;
	
	public Administador() {
		
	}

	public Administador(String nome, String email, String matricula,
			String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.senha = senha;
	}

	public Administador(int id_administrador, String nome, String email,
			String matricula, String senha) {
		super();
		this.id_administrador = id_administrador;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
