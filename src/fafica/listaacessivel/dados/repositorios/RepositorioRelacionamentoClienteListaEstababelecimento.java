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
import fafica.listaacessivel.negocios.entidades.RelacionamentoClienteListaEstababelecimento;

public class RepositorioRelacionamentoClienteListaEstababelecimento implements IRepositorio<RelacionamentoClienteListaEstababelecimento>{
	
	private static RepositorioRelacionamentoClienteListaEstababelecimento instancia;
	private Connection connection;
	private ResultSet result;
	private PreparedStatement stm;
	
	private RepositorioRelacionamentoClienteListaEstababelecimento() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioRelacionamentoClienteListaEstababelecimento getInstancia()throws ClassNotFoundException, SQLException {
		if(instancia == null) {
			instancia = new RepositorioRelacionamentoClienteListaEstababelecimento();
		}
		return instancia;
	}
	
	@Override
	public void adicionar(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
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
	public void alterar(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
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
	public void excluir(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RelacionamentoClienteListaEstababelecimento> listar() throws SQLException {
		
		//Falta ajustar o sql
		String sql = "select * from lista_cliente_estabelecimento where status = '" + Status.ATIVO.toString() + "'";
		List<RelacionamentoClienteListaEstababelecimento> lista_lista_cliente_estabelecimento = new ArrayList<RelacionamentoClienteListaEstababelecimento>();
		
			stm = connection.prepareStatement(sql);
			result = stm.executeQuery();
			
			while(result.next()){
				int id_lista = result.getInt("id_lista");
				int id_cliente = result.getInt("id_cliente");
				int id_estabelecimento = result.getInt("id_estabelecimento");
				String situacao = result.getString("situacao");
				
				RelacionamentoClienteListaEstababelecimento lista_cliente_estabelecimento = new RelacionamentoClienteListaEstababelecimento(id_lista, id_cliente, id_estabelecimento, situacao);
				
				lista_lista_cliente_estabelecimento.add(lista_cliente_estabelecimento);
			}
			
			stm.close();
			result.close();
		
		
		return lista_lista_cliente_estabelecimento;
	}

	@Override
	public RelacionamentoClienteListaEstababelecimento pesquisar(RelacionamentoClienteListaEstababelecimento entidade)
			throws SQLException {
		List<RelacionamentoClienteListaEstababelecimento> lista_lista_cliente_estabelecimento = new ArrayList<RelacionamentoClienteListaEstababelecimento>();
		RelacionamentoClienteListaEstababelecimento lista_pesquisa = null;
		
		lista_lista_cliente_estabelecimento = listar();
		
		for(RelacionamentoClienteListaEstababelecimento pesquisa : lista_lista_cliente_estabelecimento){
			if(entidade.getId_lista() == pesquisa.getId_lista() && entidade.getId_cliente() == pesquisa.getId_cliente() && entidade.getId_estabelecimento() == pesquisa.getId_estabelecimento()){
				lista_pesquisa = pesquisa;
			}
		}
		
		return lista_pesquisa;
	}
}
