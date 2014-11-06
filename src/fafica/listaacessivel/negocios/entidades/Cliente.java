package fafica.listaacessivel.negocios.entidades;

public class Cliente extends Usuario{

	private String ano_nascimento;
	private String cpf;
	private Endereco endereco;
	
	public Cliente(String nome, String cpf, String email, String senha,
			String ano_nascimento,String rua, String bairro, String numero, String complemento, String referencia, String cidade, String estado, String cep) {
		super(nome, email, senha);
		this.setEndereco(new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep));
		this.cpf = cpf;
		this.ano_nascimento = ano_nascimento;
	}

	public Cliente(int id_usuario, String nome, String cpf, String email,
			String senha, String ano_nascimento) {
		super(id_usuario, nome, email, senha);
		this.cpf = cpf;
		this.ano_nascimento = ano_nascimento;
	}

	public String getAno_nascimento() {
		return ano_nascimento;
	}

	public void setAno_nascimento(String ano_nascimento) {
		this.ano_nascimento = ano_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
}
