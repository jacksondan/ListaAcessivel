package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.controladores.ControladorAdministrador;
import fafica.listaacessivel.negocios.controladores.ControladorCliente;
import fafica.listaacessivel.negocios.controladores.ControladorEstabelecimento;
import fafica.listaacessivel.negocios.controladores.ControladorFuncionario;
import fafica.listaacessivel.negocios.controladores.ControladorLista;
import fafica.listaacessivel.negocios.controladores.ControladorProduto;
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

public class Fachada implements IFachada {

	private volatile static Fachada instance;
	private ControladorEstabelecimento controlador_estabelecimento;
	private ControladorProduto controlador_produto;
	private ControladorLista controlador_lista;
	private ControladorCliente controlador_usuario;
	private ControladorFuncionario controlador_funcionario;
	private ControladorAdministrador controlador_administrador;
	
	private Fachada() throws ClassNotFoundException, SQLException{
		controlador_estabelecimento = new ControladorEstabelecimento();
		controlador_produto = new ControladorProduto();
		controlador_lista = new ControladorLista();
		controlador_usuario = new ControladorCliente();
		controlador_funcionario = new ControladorFuncionario();
		controlador_administrador = new ControladorAdministrador();
	}
	
	public static Fachada getInstance() throws ClassNotFoundException, SQLException{
		if(instance == null){
			synchronized (Fachada.class) {
				if(instance == null){
					instance = new Fachada();
				}
			}
		}
		return instance;
	}
	
	@Override
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException {
		this.controlador_estabelecimento.adicionarEstabelecimento(entidade);	
	}

	@Override
	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException {
		this.controlador_estabelecimento.alterarEstabelecimento(entidade);
	}

	@Override
	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException {
		this.controlador_estabelecimento.excluirEstabelecimento(entidade);
	}

	@Override
	public List<Estabelecimento> listarEstabelecimento() throws SQLException {
		return this.controlador_estabelecimento.listarEstabelecimento();
	}

	@Override
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException {
		return this.controlador_estabelecimento.pesquisarEstabelecimento(entidade);
	}
	
	@Override
	public List<Estabelecimento> listarEstabelecimentoPorRegiao(
			String categoria, Cliente cliente, boolean pesquisarPorBairro)
			throws SQLException {
		return this.controlador_estabelecimento.listarEstabelecimentoPorRegiao(categoria, cliente, pesquisarPorBairro);
	}
	
	@Override
	public List<Produto> listarProdutosDoEstababelecimento(Estabelecimento estabelecimento) throws SQLException{
		return this.controlador_produto.listarProdutosDoEstabelecimento(estabelecimento);
	}
	
	@Override
	public void adicionarProduto(Produto produto) throws SQLException{
		this.controlador_produto.adicionarProduto(produto);
	}
	
	@Override
	public void alterarProduto(Produto produto) throws SQLException{
		this.controlador_produto.alterarProduto(produto);
	}
	
	@Override
	public void excluirProduto(Produto produto) throws SQLException{
		this.controlador_produto.excluirProduto(produto);
	}
	
	@Override
	public List<Produto> listarProduto() throws SQLException{
		return this.controlador_produto.listarProduto();
	}
	
	@Override
	public Produto pesquisarProduto(Produto produto) throws SQLException{
		return this.controlador_produto.pesquisarProduto(produto);
	}
	
	@Override
	public void adicionarLista(Lista entidade) throws SQLException {
		this.controlador_lista.adicionarLista(entidade);
	}

	@Override
	public void alterarLista(Lista entidade) throws SQLException {
		this.controlador_lista.alterarLista(entidade);
	}

	@Override
	public void excluirLista(Lista entidade) throws SQLException {
		this.controlador_lista.excluirLista(entidade);
	}

	@Override
	public List<Lista> listarLista() throws SQLException {
		return this.controlador_lista.listarLista();
	}

	@Override
	public Lista pesquisarLista(Lista entidade) throws SQLException {
		return this.controlador_lista.pesquisarLista(entidade);
	}
	

	
	@Override
	public void adicionarCliente(Cliente entidade) throws SQLException{
		this.controlador_usuario.adicionarCliente(entidade);
	}
	
	@Override
	public void alterarCliente(Cliente entidade) throws SQLException{
		this.controlador_usuario.alterarCliente(entidade);
	}
	
	@Override
	public void excluirCliente(Cliente entidade) throws SQLException{
		this.controlador_usuario.excluirCliente(entidade);
	}
	
	@Override
	public List <Cliente> listarCliente() throws SQLException{
		return this.controlador_usuario.listarCliente();
	}
	
	@Override
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException{
		return this.controlador_usuario.pesquisarCliente(entidade);
	}

	@Override
	public void adicionarFuncionario(Funcionario entidade) throws SQLException {
		this.controlador_funcionario.adicionarFuncionario(entidade);
	}

	@Override
	public void alterarFuncionario(Funcionario entidade) throws SQLException {
		this.controlador_funcionario.alterarFuncionario(entidade);		
	}

	@Override
	public void excluirFuncionario(Funcionario entidade) throws SQLException {
		this.controlador_funcionario.excluirFuncionario(entidade);
	}

	@Override
	public List<Funcionario> listarFuncionario() throws SQLException {
		return this.controlador_funcionario.listarFuncionario();
	}

	@Override
	public Funcionario pesquisarFuncionario(Funcionario entidade)
			throws SQLException {
		return this.controlador_funcionario.pesquisarFuncionario(entidade);
	}

	@Override
	public List<Funcionario> listarFuncionarioPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		return this.controlador_funcionario.listarFuncionarioPorEstabelecimento(estabelecimento);
	}

	@Override
	public List<Lista> listarListaPorCliente(Cliente cliente) throws SQLException {
		return this.controlador_lista.listarListaPorCLiente(cliente);
	}

	@Override
	public List<Lista> listarListaPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		return this.controlador_lista.listarListaPorEstabelecimento(estabelecimento);
	}

	@Override
	public void adicionarAdministrador(Administrador administrador)
			throws SQLException {
		this.controlador_administrador.adicionarAdministrador(administrador);
		
	}

	@Override
	public void alterarAdministrador(Administrador administrador)
			throws SQLException {
		this.controlador_administrador.alterarAdministrador(administrador);
		
	}

	@Override
	public void excluirAdministrador(Administrador administrador)
			throws SQLException {
		this.controlador_administrador.excluirAdministrador(administrador);
		
	}

	@Override
	public List<Administrador> listarAdministrador() throws SQLException {
		return this.controlador_administrador.listarAdministrador();
	}

	@Override
	public Administrador pesquisarAdministrador(Administrador administrador)
			throws SQLException {
		return this.controlador_administrador.pesquisarAdministrador(administrador);
	}	
}
