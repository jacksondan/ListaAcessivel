package fafica.listaacessivel.negocios.entidades;

import java.util.List;

public class Estabelecimento{
	
	private String nome_fantasia;
	private String nome_juridico;
	private String categoria;
	private String cnpj;
	private Endereco endereco;
	private List<String> telefones;
		
	public Estabelecimento(String nome_fantasia, String nome_juridico,
			String categoria, String cnpj, String email, String senha,
			Endereco endereco, List<String> telefones) {
		this.endereco = endereco;
		this.telefones = telefones;
		this.nome_fantasia = nome_fantasia;
		this.nome_juridico = nome_juridico;
		this.categoria = categoria;
		this.cnpj = cnpj;
	}

	public Estabelecimento(int id_usuario, String nome_fantasia,
			String nome_juridico, String categoria, String cnpj, String email,
			String senha, Endereco endereco, List<String> telefones) {
		this.endereco = endereco;
		this.telefones = telefones;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
}
