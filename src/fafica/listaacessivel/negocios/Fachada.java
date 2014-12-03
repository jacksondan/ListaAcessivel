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
	
	//Estabelecimento ***************************************
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
		
		List <Estabelecimento> listaEstabelecimentos = this.controlador_estabelecimento.listarEstabelecimento();
		if(listaEstabelecimentos != null){	
			for(Estabelecimento estabelecimento : listaEstabelecimentos){
				Administrador administrador = 
						this.pesquisarAdministrador(estabelecimento.getAdministrador());
				estabelecimento.setAdministrador(administrador);
			}
		}
		
		return listaEstabelecimentos;
	}

	@Override
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException {
		
		Estabelecimento estabelecimento = this.controlador_estabelecimento.pesquisarEstabelecimento(entidade);
		if(estabelecimento != null){
			Administrador administrador = this.pesquisarAdministrador(estabelecimento.getAdministrador());
			estabelecimento.setAdministrador(administrador);
		}
		
		return estabelecimento;
	}
	
	@Override
	public List<Estabelecimento> listarEstabelecimentoPorRegiao(
			String categoria, Cliente cliente, boolean pesquisarPorBairro)
			throws SQLException {
		List <Estabelecimento> listaEstabelecimentos = 
				this.controlador_estabelecimento.listarEstabelecimentoPorRegiao(categoria, cliente, pesquisarPorBairro);
		if(listaEstabelecimentos != null){
			for(Estabelecimento estabelecimento : listaEstabelecimentos){
				Administrador administrador = 
						this.pesquisarAdministrador(estabelecimento.getAdministrador());
				estabelecimento.setAdministrador(administrador);
			}
		}
		
		return listaEstabelecimentos;
	}
	//**********************************************************
	
	//Produto **************************************************
	
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
		List <Produto> listaProdutos = this.controlador_produto.listarProduto();
		if(listaProdutos != null){
			for(Produto produto : listaProdutos){
				Estabelecimento estabelecimento = 
						this.pesquisarEstabelecimento(produto.getEstabelecimento());
				
				produto.setEstabelecimento(estabelecimento);
			}
		}
		
		return listaProdutos;
	}
	
	@Override
	public Produto pesquisarProduto(Produto produto) throws SQLException{
		produto = this.controlador_produto.pesquisarProduto(produto);
		if(produto != null){
			Estabelecimento estabelecimento = 
					this.pesquisarEstabelecimento(produto.getEstabelecimento());
			produto.setEstabelecimento(estabelecimento);
		}
		
		return produto;
	}
	
	@Override
	public List<Produto> listarProdutosPorEstababelecimento(Estabelecimento estabelecimento, String categoria_produto, String descricao_produto) throws SQLException{
		List <Produto> listaProdutos = this.controlador_produto.listarProdutosPorEstabelecimento(estabelecimento, categoria_produto, descricao_produto);
		if(listaProdutos != null){
			for(Produto produto : listaProdutos){
				estabelecimento = 
						this.pesquisarEstabelecimento(produto.getEstabelecimento());
				
				produto.setEstabelecimento(estabelecimento);
			}
		}
		
		return listaProdutos;
	}
	
	@Override
	public List<Produto> listarProdutosPorLista(Lista lista)
			throws SQLException {
		List <Produto> listaProdutos = this.controlador_produto.listarProdutosPorLista(lista);
		if(listaProdutos != null){
			for(Produto produto : listaProdutos){
				Estabelecimento estabelecimento = 
						this.pesquisarEstabelecimento(produto.getEstabelecimento());
				
				produto.setEstabelecimento(estabelecimento);
			}
		}
		
		return listaProdutos;
	}
	//*********************************************************
	
	//Lista***************************************************
	@Override
	public int adicionarLista(Lista entidade) throws SQLException {
		return this.controlador_lista.adicionarLista(entidade);
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
		List<Lista> listaListas = this.controlador_lista.listarLista();
		if(listaListas != null){
			for(Lista lista : listaListas) {
				Cliente cliente = 
						this.pesquisarCliente(lista.getCliente());
				Estabelecimento estabelecimento =
						this.pesquisarEstabelecimento(lista.getEstabelecimento());
				List <Produto> produtos = 
						this.listarProdutosPorLista(lista);
				
				lista.setCliente(cliente);
				lista.setEstabelecimento(estabelecimento);
				lista.setProdutos(produtos);
			}
		}
		
		return listaListas;
	}

	@Override
	public Lista pesquisarLista(Lista entidade) throws SQLException {
		Lista lista = this.controlador_lista.pesquisarLista(entidade);
		if(lista != null){
			Cliente cliente = 
					this.pesquisarCliente(lista.getCliente());
			Estabelecimento estabelecimento =
					this.pesquisarEstabelecimento(lista.getEstabelecimento());
			List <Produto> produtos = 
					this.listarProdutosPorLista(lista);
			
			lista.setCliente(cliente);
			lista.setEstabelecimento(estabelecimento);
			lista.setProdutos(produtos);
		}
		
		return lista;
	}
	
	@Override
	public List<Lista> listarListaPorCliente(Cliente cliente) throws SQLException {
	List<Lista> listaListas = this.controlador_lista.listarListaPorCLiente(cliente);
		if(listaListas != null){
			for(Lista lista : listaListas) {
				cliente = 
						this.pesquisarCliente(lista.getCliente());
				Estabelecimento estabelecimento =
						this.pesquisarEstabelecimento(lista.getEstabelecimento());
				List <Produto> produtos = 
						this.listarProdutosPorLista(lista);
				
				lista.setCliente(cliente);
				lista.setEstabelecimento(estabelecimento);
				lista.setProdutos(produtos);
			}
		}
		
		return listaListas;
	}

	@Override
	public List<Lista> listarListaPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		List<Lista> listaListas = this.controlador_lista.listarListaPorEstabelecimento(estabelecimento);
		if(listaListas != null){
			for(Lista lista : listaListas) {
				Cliente cliente = 
						this.pesquisarCliente(lista.getCliente());
				estabelecimento =
						this.pesquisarEstabelecimento(lista.getEstabelecimento());
				List <Produto> produtos = 
						this.listarProdutosPorLista(lista);
				
				lista.setCliente(cliente);
				lista.setEstabelecimento(estabelecimento);
				lista.setProdutos(produtos);
			}
		}
		
		return listaListas;
	}
	//***************************************************
	
	//Cliente********************************************
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
	//******************************************************
	
	//Funcionario*******************************************
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
		List<Funcionario> listaFuncionario = this.controlador_funcionario.listarFuncionario();
		if(listaFuncionario != null){
			for(Funcionario funcionario : listaFuncionario){
				Estabelecimento estabelecimento =
						this.pesquisarEstabelecimento(funcionario.getEstabelecimento());
				
				funcionario.setEstabelecimento(estabelecimento);
			}
		}
		
		return listaFuncionario;
	}

	@Override
	public Funcionario pesquisarFuncionario(Funcionario entidade)
			throws SQLException {
		Funcionario funcionario = this.controlador_funcionario.pesquisarFuncionario(entidade);
		if(funcionario != null){
			Estabelecimento estabelecimento =
					this.pesquisarEstabelecimento(funcionario.getEstabelecimento());
			
			funcionario.setEstabelecimento(estabelecimento);
		}
		
		return funcionario;
	}

	@Override
	public List<Funcionario> listarFuncionarioPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		
		List<Funcionario> listaFuncionario = this.controlador_funcionario.listarFuncionarioPorEstabelecimento(estabelecimento);
		if(listaFuncionario != null){
			for(Funcionario funcionario : listaFuncionario){
				estabelecimento =
						this.pesquisarEstabelecimento(funcionario.getEstabelecimento());
				
				funcionario.setEstabelecimento(estabelecimento);
			}
		}
		
		return listaFuncionario;
	}
	//******************************************************
	
	//Administrador
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
