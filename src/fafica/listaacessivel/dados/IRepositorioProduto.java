package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

public interface IRepositorioProduto {
	public void adicionarProduto(Produto produto) throws SQLException;
	public void alterarProduto(Produto produto) throws SQLException;
	public void excluirProduto(Produto produto) throws SQLException;
	public List<Produto> listarProdutos() throws SQLException;
	public Produto pesquisarProduto(Produto produto) throws SQLException;
	public List<Produto> listarProdutosPorEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
	public List<Produto> listarProdutosPorLista(Lista lista) throws SQLException;
}
