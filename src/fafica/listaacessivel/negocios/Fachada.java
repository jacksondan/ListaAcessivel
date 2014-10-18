package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.controladores.ControladorEstabelecimento;
import fafica.listaacessivel.negocios.controladores.ControladorLista;
import fafica.listaacessivel.negocios.controladores.ControladorProduto;
import fafica.listaacessivel.negocios.controladores.ControladorProdutosLista;
import fafica.listaacessivel.negocios.controladores.ControladorCliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;
import fafica.listaacessivel.negocios.entidades.Cliente;

public class Fachada implements IFachada {

	private volatile static Fachada instance;
	private ControladorEstabelecimento controlador_estabelecimento;
	private ControladorProduto controlador_produto;
	private ControladorLista controlador_lista;
	private ControladorCliente controlador_usuario;
	private ControladorProdutosLista controlador_produtos_lista;
	
	private Fachada() throws ClassNotFoundException, SQLException{
		controlador_estabelecimento = new ControladorEstabelecimento();
		controlador_produto = new ControladorProduto();
		controlador_lista = new ControladorLista();
		controlador_usuario = new ControladorCliente();
		controlador_produtos_lista = new ControladorProdutosLista();
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
	public List<Produto> listarProdutosDoEstabelecimento(Estabelecimento estabelecimento) throws ClassNotFoundException, SQLException{
		return this.controlador_estabelecimento.listarProdutosDoEstababelecimento(estabelecimento);
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
	public List<Produto> getProdutosDaLista(Lista lista) throws ClassNotFoundException, SQLException{
		return this.controlador_lista.getProdutosDaList(lista);
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
	public void adicionarProdutosLista(ProdutosLista entidade) throws SQLException {
		this.controlador_produtos_lista.adicionarProdutosLista(entidade);
	}

	@Override
	public void alterarProdutosLista(ProdutosLista entidade) throws SQLException {
		this.controlador_produtos_lista.alterarProdutosLista(entidade);
	}

	@Override
	public void excluirProdutosLista(ProdutosLista entidade) throws SQLException {
		this.controlador_produtos_lista.excluirProdutosLista(entidade);
	}

	@Override
	public List<ProdutosLista> listarProdutosLista() throws SQLException {
		return this.controlador_produtos_lista.listarProdutosLista();
	}

	@Override
	public ProdutosLista pesquisarProdutosLista(ProdutosLista entidade) throws SQLException {
		return this.controlador_produtos_lista.pesquisarProdutosLista(entidade);
	}

}
