package fafica.listaacessivel.negocios.entidades;

public class Funcionario extends Usuario{
	
	private String matricula;
	private Estabelecimento estabelecimento;
	
	public Funcionario(String nome, String cpf, String email, String senha, String matricula, Estabelecimento estabelecimento) {
		
		super(nome, email, senha);
		this.matricula = matricula;
		this.estabelecimento = estabelecimento; 
	}
	
	public Funcionario(int id_usuario, String nome, String cpf, String email,
			String senha, String matricula, Estabelecimento estabelecimento) {
		super(id_usuario, nome, email, senha);
		this.matricula = matricula;
		this.estabelecimento = estabelecimento; 
	}	
}
