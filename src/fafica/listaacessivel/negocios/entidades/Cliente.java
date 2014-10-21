package fafica.listaacessivel.negocios.entidades;

public class Cliente extends Usuario{

	private String nome;
	private String cpf;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, String email, String senha,
			String cidade, String estado, String rua, String bairro,
			String numero, String referencia, String cep) {
		
		super(email, senha, cidade, estado, rua, bairro, numero, referencia,
				cep);
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(int id_usuario, String nome, String cpf, String email,
			String senha, String cidade, String estado, String rua,
			String bairro, String numero, String referencia, String cep) {
		super(id_usuario, email, senha, cidade, estado, rua, bairro, numero,
				referencia, cep);
		this.nome = nome;
		this.cpf = cpf;
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
	
	
	
}
