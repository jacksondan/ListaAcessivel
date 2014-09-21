package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioProduto;
import fafica.listaacessivel.negocios.entidades.Produto;

public class ControladorProduto {

	private IRepositorio<Produto> repositorio_produto;
	
	public ControladorProduto() throws ClassNotFoundException, SQLException{
		this.repositorio_produto = RepositorioProduto.getInstancia();
	}
	
	public void adicionarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.adicionar(produto);
	}
	
	public void alterarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.alterar(produto);
	}
	
	public void excluirProduto(Produto produto) throws SQLException{
		this.repositorio_produto.excluir(produto);
	}
	
	public List<Produto> listarProduto() throws SQLException{
		return this.repositorio_produto.listar();
	}
	
	public Produto pesquisarProduto(Produto produto) throws SQLException{
		return this.repositorio_produto.pesquisar(produto);
	}
	
}
