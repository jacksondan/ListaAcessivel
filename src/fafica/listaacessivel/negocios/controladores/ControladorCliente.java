package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioCliente;
import fafica.listaacessivel.negocios.entidades.Cliente;

public class ControladorCliente {
	private IRepositorio<Cliente> repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException, SQLException{
		repositorioCliente = RepositorioCliente.getInstancia();
	}
	
	public void adicionarCliente(Cliente entidade) throws SQLException{
		repositorioCliente.adicionar(entidade);
	}
	
	public void alterarCliente(Cliente entidade) throws SQLException{
		repositorioCliente.alterar(entidade);
	}
	
	public void excluirCliente(Cliente entidade) throws SQLException{
		repositorioCliente.excluir(entidade);
	}
	
	public List <Cliente> listarCliente() throws SQLException{
		
		return repositorioCliente.listar();
	}
	
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException{
		return repositorioCliente.pesquisar(entidade);
		
	}
}
