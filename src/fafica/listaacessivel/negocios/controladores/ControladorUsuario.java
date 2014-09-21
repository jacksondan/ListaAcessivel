package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioUsuario;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Usuario;

public class ControladorUsuario {
	private IRepositorio<Usuario> repositorioUsuario;
	
	public ControladorUsuario() throws ClassNotFoundException, SQLException{
		repositorioUsuario = RepositorioUsuario.getInstancia();
	}
	
	public void adicionarUsuario(Usuario entidade) throws SQLException{
		repositorioUsuario.adicionar(entidade);
	}
	
	public void alterarUsuario(Usuario entidade) throws SQLException{
		repositorioUsuario.alterar(entidade);
	}
	
	public void excluirUsuario(Usuario entidade) throws SQLException{
		repositorioUsuario.excluir(entidade);
	}
	
	public List <Usuario> listarUsuario() throws SQLException{
		
		return repositorioUsuario.listar();
	}
	
	public Usuario pesquisarUsuario(Usuario entidade) throws SQLException{
		return repositorioUsuario.pesquisar(entidade);
		
	}
	
	public List <Lista> getListasDoUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
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
