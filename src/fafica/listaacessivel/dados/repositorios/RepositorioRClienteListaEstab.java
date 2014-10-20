package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.negocios.entidades.RClienteListaEstab;

public class RepositorioRClienteListaEstab implements IRepositorio<RClienteListaEstab>{
	
	private static RepositorioRClienteListaEstab instancia;
	private Connection connection;
	private ResultSet result;
	private PreparedStatement stm;
	
	private RepositorioRClienteListaEstab() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioRClienteListaEstab getInstance()throws ClassNotFoundException, SQLException {
		if(instancia == null) instancia = new RepositorioRClienteListaEstab();
		return instancia;
	}
	
	@Override
	public void adicionar(RClienteListaEstab entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(RClienteListaEstab entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(RClienteListaEstab entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RClienteListaEstab> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RClienteListaEstab pesquisar(RClienteListaEstab entidade)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
