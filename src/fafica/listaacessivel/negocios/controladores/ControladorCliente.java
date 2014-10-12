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
	
	public void adicionarUsuario(Cliente entidade) throws SQLException{
		repositorioUsuario.adicionar(entidade);
	}
	
	public void alterarUsuario(Cliente entidade) throws SQLException{
		repositorioUsuario.alterar(entidade);
	}
	
	public void excluirUsuario(Cliente entidade) throws SQLException{
		repositorioUsuario.excluir(entidade);
	}
	
	public List <Cliente> listarUsuario() throws SQLException{
		
		return repositorioUsuario.listar();
	}
	
	public Cliente pesquisarUsuario(Cliente entidade) throws SQLException{
		return repositorioUsuario.pesquisar(entidade);
		
	}
	
	public List <Lista> getListasDoUsuario(Cliente usuario) throws ClassNotFoundException, SQLException{
		ControladorLista controladorLista = new ControladorLista();
		ArrayList <Lista> listas = new ArrayList<Lista>();
		
		for(Lista l : controladorLista.listarLista()){
			if(l.getId_usuario() == usuario.getId_usuario()){
				listas.add(l);
			}
		}
		
		return listas;
	}
}
