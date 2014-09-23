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
import fafica.listaacessivel.negocios.entidades.Lista;

public class RepositorioLista implements IRepositorio<Lista>{
	
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
	public void adicionar(Lista entidade) throws SQLException {
		sql = "INSERT INTO lista (data_criacao,"
			+"data_modificacao,quantidade_total,"
			+ "valor_total,status,id_usuario)"
			+ "VALUE(?,?,?,?,?,?)";
		
		smt = connection.prepareStatement(sql);
		
		smt.setString(1, entidade.getData_criacao_lista());
		smt.setString(2, entidade.getData_modificacao_lista());
		smt.setInt(3, entidade.getQuantidade_total_lista());
		smt.setFloat(4, entidade.getValor_total_lista());
		smt.setString(5,Status.ATIVO.toString());
		smt.setInt(6,entidade.getId_usuario());
		
		smt.execute();
		smt.close();
		
	}

	@Override
	public void alterar(Lista entidade) throws SQLException {
		sql= "UPDATE lista SET "
				+ "data_modificacao Date = '"+entidade.getData_modificacao_lista()+"'"
				+ "quantidade_total = "+entidade.getQuantidade_total_lista()
				+ "valor_total = "+entidade.getValor_total_lista();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
	}

	@Override
	public void excluir(Lista entidade) throws SQLException {
		sql = "UPDATE lista SET status = '" + Status.INATIVO.toString() + "' WHERE id_lista = "+entidade.getId_lista();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
	}

	@Override
	public List<Lista> listar() throws SQLException {
		sql = "SELECT * FROM lista WHERE status = '" + Status.ATIVO.toString() + "'";
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
	public Lista pesquisar(Lista entidade) throws SQLException {
		sql = "SELECT * FROM lista WHERE status = '" + Status.ATIVO.toString() + "' AND id_lista = "+entidade.getId_lista();
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		
		Lista l = new Lista();
		
		while(rs.next()){
			l.setId_usuario(rs.getInt("id_usuario"));
			l.setId_lista(rs.getInt("id_lista"));
			l.setData_criacao_lista(rs.getString("data_criacao"));
			l.setData_modificacao_lista(rs.getString("data_modificacao"));
			l.setQuantidade_total_lista(rs.getInt("quantidade_total"));
			l.setValor_total_lista(rs.getFloat("valor_total"));
		}
	
		smt.close();
		rs.close();
		
		return l;
		
//		List<Lista> lista_lista = new ArrayList<Lista>();
//		Lista lista_pesquisa = null;
//		
//		
//		lista_lista = listar();
//		
//		for(Lista lista : lista_lista){
//			if(entidade.getId_lista() == lista.getId_lista()){
//				lista_pesquisa = lista;
//			}
//		}
//		
//		return lista_pesquisa;
	}

}
