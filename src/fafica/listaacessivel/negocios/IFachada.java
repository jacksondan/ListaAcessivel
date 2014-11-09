package fafica.listaacessivel.negocios;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

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
	public void adicionarCliente(Cliente entidade) throws SQLException;
	public void alterarCliente(Cliente entidade) throws SQLException;
	public void excluirCliente(Cliente entidade) throws SQLException;
	public List <Cliente> listarCliente() throws SQLException;
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException;
	public void adicionarFuncionario(Funcionario entidade) throws SQLException;
	public void alterarFuncionario(Funcionario entidade) throws SQLException;
	public void excluirFuncionario(Funcionario entidade) throws SQLException;
	public List <Funcionario> listarFuncionario() throws SQLException;
	public Funcionario pesquisarFuncionario(Funcionario entidade) throws SQLException;
	public List<Funcionario> listarFuncionarioPorEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
}
