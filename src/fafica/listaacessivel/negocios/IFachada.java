package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;
import fafica.listaacessivel.negocios.entidades.Cliente;

public interface IFachada {
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Estabelecimento> listarEstabelecimento() throws SQLException;
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Produto> listarProdutosDoEstabelecimento(Estabelecimento estabelecimento) throws ClassNotFoundException, SQLException;
	public void adicionarProduto(Produto produto) throws SQLException;
	public void alterarProduto(Produto produto) throws SQLException;
	public void excluirProduto(Produto produto) throws SQLException;
	public List<Produto> listarProduto() throws SQLException;
	public Produto pesquisarProduto(Produto produto) throws SQLException;
	public void adicionarLista(Lista entidade) throws SQLException;
	public void alterarLista(Lista entidade) throws SQLException;
	public void excluirLista(Lista entidade) throws SQLException;
	public List<Lista> listarLista() throws SQLException;
	public Lista pesquisarLista(Lista entidade) throws SQLException;
	public List<Produto> getProdutosDaLista(Lista lista) throws ClassNotFoundException, SQLException;
	public void adicionarUsuario(Cliente entidade) throws SQLException;
	public void alterarUsuario(Cliente entidade) throws SQLException;
	public void excluirUsuario(Cliente entidade) throws SQLException;
	public List <Cliente> listarUsuario() throws SQLException;
	public Cliente pesquisarUsuario(Cliente entidade) throws SQLException;
	public void adicionarProdutosLista(ProdutosLista entidade) throws SQLException;
	public void alterarProdutosLista(ProdutosLista entidade) throws SQLException;
	public void excluirProdutosLista(ProdutosLista entidade) throws SQLException;
	public List<ProdutosLista> listarProdutosLista() throws SQLException;
	public ProdutosLista pesquisarProdutosLista(ProdutosLista entidade) throws SQLException;
	
}
