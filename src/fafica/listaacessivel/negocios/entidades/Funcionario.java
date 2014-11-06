package fafica.listaacessivel.negocios.entidades;

public class Funcionario extends Usuario{
	
	private String matricula;
	private Estabelecimento estabelecimento;
		
	public Funcionario(){
		
	}
	
	public Funcionario(String nome, String email, String senha, String matricula, Estabelecimento estabelecimento) {
		super(nome, email, senha);
		this.matricula = matricula;
		this.estabelecimento = estabelecimento; 
	}
	
	public Funcionario(int id_usuario, String nome, String email,
			String senha, String matricula, Estabelecimento estabelecimento) {
		super(id_usuario, nome, email, senha);
		this.matricula = matricula;
		this.estabelecimento = estabelecimento; 
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}	
}
