package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;
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
		String sql = "INSERT INTO lista_cliente_estabelecimento(id_lista, id_cliente, id_estabelecimento, situacao) VALUES (?,?,?,?)";
		
		stm = connection.prepareStatement(sql);
		
		stm.setInt(1, entidade.getId_lista());
		stm.setInt(2, entidade.getId_cliente());
		stm.setInt(3, entidade.getId_estabelecimento());
		stm.setString(4, entidade.getSituacao());
		
		stm.execute();
		stm.close();
	
	}

	@Override
	public void alterar(RClienteListaEstab entidade) throws SQLException {
		String sql = "UPDATE lista_cliente_estabelecimento SET id_lista= " 
				+ entidade.getId_lista() + ", id_cliente= " 
				+ entidade.getId_cliente() + ", id_estabelecimento= " 
				+ entidade.getId_estabelecimento() 
				+ ",situacao='" + entidade.getSituacao() + "' WHERE id_lista = " 
				+ entidade.getId_lista() + "AND id_cliente = " + entidade.getId_cliente() 
				+ "AND id_estabelecimento = " + entidade.getId_estabelecimento();
				
					stm = connection.prepareStatement(sql);
					stm.execute();
					stm.close();
	}

	@Override
	public void excluir(RClienteListaEstab entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RClienteListaEstab> listar() throws SQLException {
		
		//Falta ajustar o sql
		String sql = "select * from lista_cliente_estabelecimento where status = '" + Status.ATIVO.toString() + "'";
		List<RClienteListaEstab> lista_lista_cliente_estabelecimento = new ArrayList<RClienteListaEstab>();
		
			stm = connection.prepareStatement(sql);
			result = stm.executeQuery();
			
			while(result.next()){
				int id_lista = result.getInt("id_lista");
				int id_cliente = result.getInt("id_cliente");
				int id_estabelecimento = result.getInt("id_estabelecimento");
				String situacao = result.getString("situacao");
				
				RClienteListaEstab lista_cliente_estabelecimento = new RClienteListaEstab(id_lista, id_cliente, id_estabelecimento, situacao);
				
				lista_lista_cliente_estabelecimento.add(lista_cliente_estabelecimento);
			}
			
			stm.close();
			result.close();
		
		
		return lista_lista_cliente_estabelecimento;
	}

	@Override
	public RClienteListaEstab pesquisar(RClienteListaEstab entidade)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
