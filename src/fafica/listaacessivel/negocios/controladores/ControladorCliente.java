package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioCliente;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Cliente;

public class ControladorCliente {
	private IRepositorio<Cliente> repositorioUsuario;
	
	public ControladorCliente() throws ClassNotFoundException, SQLException{
		repositorioUsuario = RepositorioCliente.getInstancia();
	}
	
	public void adicionarCliente(Cliente entidade) throws SQLException{
		repositorioUsuario.adicionar(entidade);
	}
	
	public void alterarCliente(Cliente entidade) throws SQLException{
		repositorioUsuario.alterar(entidade);
	}
	
	public void excluirCliente(Cliente entidade) throws SQLException{
		repositorioUsuario.excluir(entidade);
	}
	
	public List <Cliente> listarCliente() throws SQLException{
		
		return repositorioUsuario.listar();
	}
	
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException{
		return repositorioUsuario.pesquisar(entidade);
		
	}
}
