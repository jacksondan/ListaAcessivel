package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioLista;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;


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
		if(instancia==null){
			synchronized (RepositorioLista.class) {
				if(instancia == null){
					instancia = new RepositorioLista();
				}
			}
		}
		return instancia;
	}
	
	@Override
	public void adicionarLista(Lista entidade) throws SQLException {
		sql = "insert into lista (descricao, data_criacao,situacao,"
			+"quantidade_total,"
			+ "valor_total,id_cliente,id_estabelecimento,status)"
			+ "VALUE(?,?,?,?,?,?,?)";
		
		smt = connection.prepareStatement(sql);
		
		smt.setString(1, entidade.getDescricao());
		smt.setString(2, entidade.getData_criacao());
		smt.setString(3, entidade.getSituacao());
		smt.setInt(4, entidade.getQuantidade_total());
		smt.setFloat(5, entidade.getValor_total());
		smt.setInt(6, entidade.getCliente().getId_usuario());
		smt.setInt(7, entidade.getEstabelecimento().getId_estabelecimento());
		smt.setString(8,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		Lista lista = new Lista();
		sql = "select id_lista from lista where data_criacao = '" + entidade.getData_criacao() + "'";
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		while(rs.next()){
			lista.setId_lista(rs.getInt("id_lista"));
		}
		rs.close();
		smt.close();
		
		String sql2 = "insert into lista_produto (id_lista, id_produto) values (?,?)";
		for(Produto produto : entidade.getProdutos()){
			smt = this.connection.prepareStatement(sql2);
			smt.setInt(1, entidade.getId_lista());
			smt.setInt(2, produto.getId_produto());
			smt.execute();
			smt.close();
		}
		
		String sql3 = "insert into lista_cliente_estabelecimento (id_lista, id_cliente, id_estabelecmimento) values (?,?,?)";
		smt = this.connection.prepareStatement(sql3);
		smt.setInt(1, entidade.getId_lista());
		smt.setInt(2, entidade.getCliente().getId_usuario());
		smt.setInt(3, entidade.getEstabelecimento().getId_estabelecimento());
		smt.execute();
		smt.close();		
	}

	@Override
	public void alterarLista(Lista entidade) throws SQLException {
		sql= "UPDATE lista SET "
				+ "descricao = '" + entidade.getDescricao() + "'"
				+ "situacao = '" + entidade.getSituacao() + "'"
				+ "data_modificacao = '"+entidade.getData_alteracao()+"'"
				+ "quantidade_total = "+entidade.getQuantidade_total()
				+ "valor_total = "+entidade.getValor_total();
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
			l.setData_criacao(rs.getString("data_criacao"));
			l.setData_alteracao(rs.getString("data_modificacao"));
			l.setQuantidade_total(rs.getInt("quantidade_total"));
			l.setValor_total(rs.getFloat("valor_total"));
			
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
			l.setData_criacao(rs.getString("data_criacao"));
			l.setData_alteracao(rs.getString("data_modificacao"));
			l.setQuantidade_total(rs.getInt("quantidade_total"));
			l.setValor_total(rs.getFloat("valor_total"));
		}
	
		smt.close();
		rs.close();
		
		return l;
	}

	@Override
	public List<Lista> listarListasPorCliente(Cliente cliente)
			throws SQLException {
		sql = "select * from lista where status = '" + Status.ATIVO.toString() + "' AND id_cliente = " + cliente.getId_usuario();
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		
		Estabelecimento estabelecimento = new Estabelecimento();
		
		//Criando lista de produtos
		List<Produto> produtos = new ArrayList<Produto>();
		while(rs.next()){
			Produto produto = new Produto();
			produto.setId_produto(rs.getInt("id_produto"));
			produtos.add(produto);
		}
				
		List<Lista> lista = new ArrayList<Lista>();
		while (rs.next()){
		
			int id_lista = rs.getInt("id_lista");
			String data_criacao = rs.getString("data_criacao");
			String data_alteracao = rs.getString("data_modificacao");
			String descricao = rs.getString("descricao");
			String situacao = rs.getString("situacao");
			int quantidade_total = rs.getInt("quantidade_total");
			float valor_total = rs.getFloat("valor_total");
			estabelecimento.setId_estabelecimento(rs.getInt("id_estabelecimento"));
			cliente.setId_usuario(rs.getInt("id_cliente"));
					
			Lista l = new Lista(id_lista, descricao, situacao, data_criacao, data_alteracao, quantidade_total, valor_total, cliente, estabelecimento, produtos);
			
			lista.add(l);
		}
		rs.close();
		smt.close();
		return lista;
	}

	@Override
	public List<Lista> listarListasPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		sql = "select * from lista where status = '" + Status.ATIVO.toString() + "' AND id_estabelecimento = " + estabelecimento.getId_estabelecimento();
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		
		Cliente cliente = new Cliente();
		
		//Criando lista de produtos
		List<Produto> produtos = new ArrayList<Produto>();
		while(rs.next()){
			Produto produto = new Produto();
			produto.setId_produto(rs.getInt("id_produto"));
			produtos.add(produto);
		}
				
		List<Lista> lista = new ArrayList<Lista>();
		while (rs.next()){
		
			int id_lista = rs.getInt("id_lista");
			String data_criacao = rs.getString("data_criacao");
			String data_alteracao = rs.getString("data_modificacao");
			String descricao = rs.getString("descricao");
			String situacao = rs.getString("situacao");
			int quantidade_total = rs.getInt("quantidade_total");
			float valor_total = rs.getFloat("valor_total");
			estabelecimento.setId_estabelecimento(rs.getInt("id_estabelecimento"));
			cliente.setId_usuario(rs.getInt("id_cliente"));
								
			Lista l = new Lista(id_lista, descricao, situacao, data_criacao, data_alteracao, quantidade_total, valor_total, cliente, estabelecimento, produtos);
			
			lista.add(l);
		}
		rs.close();
		smt.close();
		return lista;
	}
	
	

}
