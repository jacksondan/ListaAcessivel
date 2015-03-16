package fafica.listaacessivel.negocios.entidades;

public class Administrador extends Usuario{
	
	private String cpf;
		
	public Administrador() {
		
	}

	public Administrador(String nome, String email, String cpf,
			String senha) {
		super(nome, email, senha);
		this.cpf = cpf;
	}

	public Administrador(int id_usuario, String nome, String email,
			String cpf, String senha) {
		super(id_usuario, nome, email, senha);
		this.cpf = cpf;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
