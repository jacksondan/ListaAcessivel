package fafica.listaacessivel.negocios.entidades;

public class Cliente extends Usuario{

	private String ano_nascimento;
		
	public Cliente(String nome, String cpf, String email, String senha,
			String ano_nascimento) {
		super(nome, email, senha);
		this.ano_nascimento = ano_nascimento;
	}

	public Cliente(int id_usuario, String nome, String cpf, String email,
			String senha, String ano_nascimento) {
		super(id_usuario, nome, email, senha);
		this.ano_nascimento = ano_nascimento;
	}	
}
