package fafica.listaacessivel.negocios.entidades;


public class Estabelecimento extends Usuario{
	private String nome_fantasia;
	private String nome_juridico; //Atriburo Unico no BD
	private String categoria;
	private String cnpj;
	
	public Estabelecimento() {
		super();
	}
	
	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String categoria, String cnpj, String email, String senha,
			String rua, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, String referencia) {
		super(email, senha, cidade, estado, rua, bairro, numero, complemento, referencia,
				cep);
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		this.cnpj = cnpj;
	}

	public Estabelecimento(int id_usuario, String nome_fantasia,
			String nome_juridico, String categoria, String cnpj, String email,
			String senha, String rua, String numero, String complemento, String bairro,
			String cidade, String estado, String cep, String referencia) {
		super(id_usuario, email, senha, cidade, estado, rua, bairro, numero, complemento,
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
