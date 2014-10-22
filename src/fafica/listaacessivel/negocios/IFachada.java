package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.RClienteListaEstab;

public interface IFachada {
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Estabelecimento> listarEstabelecimento() throws SQLException;
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException;
	public List<Produto> getProdutosDoEstababelecimento(Estabelecimento estabelecimento) throws ClassNotFoundException, SQLException;
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
	public void adicionarCliente(Cliente entidade) throws SQLException;
	public void alterarCliente(Cliente entidade) throws SQLException;
	public void excluirCliente(Cliente entidade) throws SQLException;
	public List <Cliente> listarCliente() throws SQLException;
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException;
	public void adicionarProdutosLista(ProdutosLista entidade) throws SQLException;
	public void alterarProdutosLista(ProdutosLista entidade) throws SQLException;
	public void excluirProdutosLista(ProdutosLista entidade) throws SQLException;
	public List<ProdutosLista> listarProdutosLista() throws SQLException;
	public ProdutosLista pesquisarProdutosLista(ProdutosLista entidade) throws SQLException;
	public void adicionarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException;
	public void alterarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException;
	public void excluirListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException;
	public List<RClienteListaEstab> listar_lista_cliente_estabelecimento() throws SQLException;
	public RClienteListaEstab pesquisarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException;
	public List <Lista> getListasDoCliente(Cliente entidade) throws ClassNotFoundException, SQLException;
	public List <Lista> getListasDoEstabelecimento(Estabelecimento entidade) throws ClassNotFoundException, SQLException;
	public Cliente getClienteDaLista(Lista entidade) throws ClassNotFoundException, SQLException;
	public Estabelecimento getEstabelecimentoDaLista(Lista entidade) throws ClassNotFoundException, SQLException;
	
}
