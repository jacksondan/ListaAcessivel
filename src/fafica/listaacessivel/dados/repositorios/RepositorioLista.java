package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.dados.IRepositorioLista;


public class RepositorioLista implements IRepositorioLista {
	
	private static RepositorioLista instancia;
	private Connection connection;
	private PreparedStatement smt;
	private ResultSet rs;
	private String sql;
	
	private RepositorioLista() throws ClassNotFoundException, SQLException {
		connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioLista getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia == null) instancia = new RepositorioLista();
		return instancia;
	}
	
	@Override
	public void adicionarLista(Lista entidade) throws SQLException {
		sql = "insert into lista (data_criacao,"
			+"quantidade_total,"
			+ "valor_total,status)"
			+ "VALUE(?,?,?,?)";
		
		smt = connection.prepareStatement(sql);
		
		smt.setString(1, entidade.getData_criacao_lista());
		smt.setInt(2, entidade.getQuantidade_total_lista());
		smt.setFloat(3, entidade.getValor_total_lista());
		smt.setString(4,Status.ATIVO.toString());
		
		smt.execute();
		smt.close();
		
	}

	@Override
	public void alterarLista(Lista entidade) throws SQLException {
		sql= "UPDATE lista SET "
				+ "data_modificacao = '"+entidade.getData_modificacao_lista()+"'"
				+ "quantidade_total = "+entidade.getQuantidade_total_lista()
				+ "valor_total = "+entidade.getValor_total_lista();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
	}

	@Override
	public void excluirLista(Lista entidade) throws SQLException {
		sql = "UPDATE lista SET status = '" + Status.INATIVO.toString() + "' WHERE id_lista = "+entidade.getId_lista();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();	
	}

	@Override
	public List<Lista> listarListas() throws SQLException {
		sql = "select * from lista where status = '" + Status.ATIVO.toString() + "'";
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		
		List<Lista> lista = new ArrayList<Lista>();
		while (rs.next()){
			Lista l = new Lista();
			l.setId_lista(rs.getInt("id_lista"));
			l.setData_criacao_lista(rs.getString("data_criacao"));
			l.setData_modificacao_lista(rs.getString("data_modificacao"));
			l.setQuantidade_total_lista(rs.getInt("quantidade_total"));
			l.setValor_total_lista(rs.getFloat("valor_total"));
			
			lista.add(l);
		}
		rs.close();
		smt.close();
		return lista;
	}

	@Override
	public Lista pesquisarLista(Lista entidade) throws SQLException {
		sql = "select * from lista where status = '" + Status.ATIVO.toString() + "' AND id_lista = "+entidade.getId_lista();
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		
		Lista l = new Lista();
		
		while(rs.next()){
			l.setId_lista(rs.getInt("id_lista"));
			l.setData_criacao_lista(rs.getString("data_criacao"));
			l.setData_modificacao_lista(rs.getString("data_modificacao"));
			l.setQuantidade_total_lista(rs.getInt("quantidade_total"));
			l.setValor_total_lista(rs.getFloat("valor_total"));
		}
	
		smt.close();
		rs.close();
		
		return l;
	}

	@Override
	public List<Lista> listarListasDoCliente(Cliente cliente)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lista> listarListasDoEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
