package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;

public interface IRepositorioCliente {
	public void adicionarCliente(Cliente cliente) throws SQLException;
	public void alterarCliente(Cliente cliente) throws SQLException;
	public void excluirCliente(Cliente cliente) throws SQLException;
	public List<Cliente> listarClientes() throws SQLException;
	public Cliente pesquisarCliente(Cliente cliente) throws SQLException;
}
