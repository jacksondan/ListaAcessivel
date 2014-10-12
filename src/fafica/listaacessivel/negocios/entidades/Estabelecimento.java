package fafica.listaacessivel.negocios.entidades;


public class Estabelecimento extends Usuario{
/*	private int id_estabelecimento;
	private String nome_fantasia;
	private String nome_juridico; //Atriburo Unico no BD
	private String categoria;
	private String cnpj;
	private String email;
	private String senha;
	private ArrayList<String> telefones;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String referencia;
	private String status;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String categoria, String cnpj, String email, String senha,
			String rua, String numero, String bairro, String cidade,
			String estado, String cep, String referencia) {
		super();
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.referencia = referencia;
	}
	
	public Estabelecimento(int id_estabelecimento, String nome_fantasia,
			String nome_juridico, String categoria, String cnpj, String email,
			String senha, String rua, String numero, String bairro,
			String cidade, String estado, String cep, String referencia) {
		super();
		this.id_estabelecimento = id_estabelecimento;
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		cnpj = cnpj;
		this.email = email;
		this.senha = senha;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.referencia = referencia;
	}
*/
	private String nome_fantasia;
	private String nome_juridico; //Atriburo Unico no BD
	private String categoria;
	private String cnpj;
	
	public Estabelecimento() {
		super();
	}
	
	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String categoria, String cnpj, String email, String senha,
			String rua, String numero, String bairro, String cidade,
			String estado, String cep, String referencia) {
		super(email, senha, cidade, estado, rua, bairro, numero, referencia,
				cep);
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		this.cnpj = cnpj;
	}

	public Estabelecimento(int id_usuario, String nome_fantasia,
			String nome_juridico, String categoria, String cnpj, String email,
			String senha, String rua, String numero, String bairro,
			String cidade, String estado, String cep, String referencia) {
		super(id_usuario, email, senha, cidade, estado, rua, bairro, numero,
				referencia, cep);
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		this.cnpj = cnpj;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getNome_juridico() {
		return nome_juridico;
	}
	public void setNome_juridico(String nome_juridico) {
		this.nome_juridico = nome_juridico;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
