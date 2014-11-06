package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioProduto;
import fafica.listaacessivel.dados.repositorios.RepositorioProduto;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

public class ControladorProduto {

	private IRepositorioProduto repositorio_produto;
	
	public ControladorProduto() throws ClassNotFoundException, SQLException{
		this.repositorio_produto = RepositorioProduto.getInstancia();
	}
	
	public void adicionarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.adicionarProduto(produto);
	}
	
	public void alterarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.alterarProduto(produto);
	}
	
	public void excluirProduto(Produto produto) throws SQLException{
		this.repositorio_produto.excluirProduto(produto);
	}
	
	public List<Produto> listarProduto() throws SQLException{
		return this.repositorio_produto.listarProdutos();
	}
	
	public Produto pesquisarProduto(Produto produto) throws SQLException{
		return this.repositorio_produto.pesquisarProduto(produto);
	}
	
	public List<Produto> listarProdutosDoEstabelecimento(Estabelecimento estabelecimento) throws SQLException{
		return this.repositorio_produto.listarProdutosDoEstabelecimento(estabelecimento);
	}
	public List<Produto> listarProdutosDaLista(Lista lista) throws SQLException{
		return this.repositorio_produto.listarProdutosDaLista(lista);
	}
	
}
