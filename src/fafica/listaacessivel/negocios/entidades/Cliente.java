package fafica.listaacessivel.negocios.entidades;

public class Cliente extends Usuario{
	/*private int id_usuario;
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
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String email, String senha,
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

	public Cliente(int id_usuario, String nome, String cpf, String email,
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
*/
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
