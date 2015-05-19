package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioAdministrador;
import fafica.listaacessivel.dados.repositorios.RepositorioAdministrador;
import fafica.listaacessivel.negocios.entidades.Administrador;

public class ControladorAdministrador {
	
	private IRepositorioAdministrador repositorioAdministrador;
	
	public ControladorAdministrador() throws ClassNotFoundException, SQLException{
		this.repositorioAdministrador = RepositorioAdministrador.getInstancia();
	}
	
	public int adicionarAdministrador(Administrador administrador) throws SQLException{
		return this.repositorioAdministrador.adicionarAdministrador(administrador);
	}
	
	public void alterarAdministrador(Administrador administrador) throws SQLException{
		this.repositorioAdministrador.alterarAdministrador(administrador);
	}
	
	public void excluirAdministrador(Administrador administrador) throws SQLException{
		this.repositorioAdministrador.excluirAdministrador(administrador);
	}

	public List<Administrador> listarAdministrador() throws SQLException{
		return this.repositorioAdministrador.listarAdministradores();
	}
	
	public Administrador pesquisarAdministrador(Administrador administrador) throws SQLException{
		return this.repositorioAdministrador.pesquisarAdministrador(administrador);
	}
}
