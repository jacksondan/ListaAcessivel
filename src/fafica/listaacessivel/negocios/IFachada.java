package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.RelacionamentoListaProduto;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.RelacionamentoClienteListaEstababelecimento;

public interface IFachada {
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Estabelecimento> listarEstabelecimento() throws SQLException;
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Produto> listarProdutosDoEstababelecimento(Estabelecimento estabelecimento) throws ClassNotFoundException, SQLException;
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
	public List<Produto> listarProdutosDaLista(Lista lista) throws ClassNotFoundException, SQLException;
	public void adicionarCliente(Cliente entidade) throws SQLException;
	public void alterarCliente(Cliente entidade) throws SQLException;
	public void excluirCliente(Cliente entidade) throws SQLException;
	public List <Cliente> listarCliente() throws SQLException;
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException;
	public void adicionarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException;
	public void alterarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException;
	public void excluirRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException;
	public List<RelacionamentoListaProduto>  listarRelacionamentoListaProduto() throws SQLException;
	public RelacionamentoListaProduto pesquisarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException;
	public void adicionarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException;
	public void alterarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException;
	public void excluirRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException;
	public List<RelacionamentoClienteListaEstababelecimento> listarRelacionamentoClienteListaEstababelecimento() throws SQLException;
	public RelacionamentoClienteListaEstababelecimento pesquisarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException;
	public List <Lista> listarListasDoCliente(Cliente entidade) throws ClassNotFoundException, SQLException;
	public List <Lista> listarListasDoEstabelecimento(Estabelecimento entidade) throws ClassNotFoundException, SQLException;
	public Cliente listarClienteDaLista(Lista entidade) throws ClassNotFoundException, SQLException;
	public Estabelecimento listarEstabelecimentoDaLista(Lista entidade) throws ClassNotFoundException, SQLException;
	
}
