package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioCliente;
import fafica.listaacessivel.dados.repositorios.RepositorioCliente;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

public class ControladorCliente {
	
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException, SQLException{
		repositorioCliente = RepositorioCliente.getInstancia();
	}
	
	public void adicionarCliente(Cliente cliente) throws SQLException{
		String senhaEncriptada = CriptografiaSenha.encriptar(cliente.getSenha());
		cliente.setSenha(senhaEncriptada);
		repositorioCliente.adicionarCliente(cliente);
	}
	
	public void alterarCliente(Cliente cliente) throws SQLException{
		repositorioCliente.alterarCliente(cliente);
	}
	
	public void excluirCliente(Cliente cliente) throws SQLException{
		repositorioCliente.excluirCliente(cliente);
	}
	
	public List <Cliente> listarCliente() throws SQLException{
		
		return repositorioCliente.listarClientes();
	}
	
	public Cliente pesquisarCliente(Cliente cliente) throws SQLException{
		return repositorioCliente.pesquisarCliente(cliente);
		
	}
}
