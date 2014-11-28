package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioAdministrador;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.negocios.entidades.Administrador;

public class RepositorioAdministrador implements IRepositorioAdministrador {

	private static RepositorioAdministrador instancia ;
	private PreparedStatement smt;
	private Connection connection;
	private ResultSet result;
	private String sql;
	
	private RepositorioAdministrador() throws ClassNotFoundException, SQLException{
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioAdministrador getInstancia() throws ClassNotFoundException, SQLException{
		if(instancia==null){
			synchronized (RepositorioAdministrador.class) {
				if(instancia == null){
					instancia = new RepositorioAdministrador();
				}
			}
		}
		
		return instancia;
	}
		
	@Override
	public void adicionarAdministrador(Administrador administrador)
			throws SQLException {
	

	}

	@Override
	public void alterarAdministrador(Administrador administrador)
			throws SQLException {
		

	}

	@Override
	public void excluirAdministrador(Administrador administrador)
			throws SQLException {
		

	}

	@Override
	public List<Administrador> listarAdministradores() throws SQLException {
		
		return null;
	}

	@Override
	public Administrador pesquisarAdministrador(Administrador administrador)
			throws SQLException {
		
		return null;
	}

}
