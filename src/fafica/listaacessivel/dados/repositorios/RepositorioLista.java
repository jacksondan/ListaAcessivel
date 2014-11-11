package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

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
		int id_auto_increment = 0;
		//Inserindo na tabela Lisnta
		sql = "insert into lista (descricao, data_criacao, quantidade_total,"
			+ " valor_total, status)"
			+ " values(?,?,?,?,?)";
		
		//Esse Segundo parametro permite que o ID AUTO_INCREMENT seja coletado
		smt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		smt.setString(1, entidade.getDescricao());
		smt.setString(2, entidade.getData_criacao());
		smt.setInt(3, entidade.getQuantidade_total());
		smt.setFloat(4, entidade.getValor_total());
		smt.setString(5,Status.ATIVO.toString());
		smt.execute();
		
		//Coletando o ID AUTO INCREMENT
		rs = smt.getGeneratedKeys();
		if(rs.next()){
			id_auto_increment = rs.getInt(1);
		}
		rs.close();
		smt.close();
		
		//Inserindo na tabela lista_cliente_estabelecimento
		sql = "insert into lista_cliente_estabelecimento (id_lista, id_cliente,"
				+ " id_estabelecimento, situacao)"
				+ " values(?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1, id_auto_increment);
		smt.setInt(2, entidade.getCliente().getId_usuario());
		smt.setInt(3, entidade.getEstabelecimento().getId_estabelecimento());
		smt.setString(4, entidade.getSituacao());
		smt.execute();
		smt.close();
		
		//Inserindo na tabela lista_produto
		for(Produto produto : entidade.getProdutos()){
			sql = "insert into lista_produto"
					+ " (id_lista, id_produto,"
					+ " quantidade_produto, valor_produto)"
					+ " values(?,?,?,?)";
			
			smt = this.connection.prepareStatement(sql);
			smt.setInt(1, id_auto_increment);
			smt.setInt(2, produto.getId_produto());
			smt.setInt(3, produto.getQuantidade());
			smt.setFloat(4, produto.getValor());
			smt.execute();
			smt.close();
		}
		
		System.out.println("ID AUTO INCREMENT DE LISTA: "+id_auto_increment);
		System.out.println("ADICIONAR LISTA OK");
	}

	
	@Override
	public void alterarLista(Lista entidade) throws SQLException {
		
		sql = "update lista set"
				+ " descricao = '" +entidade.getDescricao()+ "'"
				+ ", data_alteracao = '" +entidade.getData_alteracao()+ "'"
				+ ", quantidade_total = " +entidade.getQuantidade_total()
				+ ", valor_total = " +entidade.getValor_total()
				+ " where id_lista = " +entidade.getId_lista();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		
		sql = "update lista_cliente_estabelecimento set"
				+ " situacao = '" +entidade.getSituacao()+ "'"
				+ " where id_lista = " +entidade.getId_lista();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "delete from lista_produto where id_lista "+entidade.getId_lista();
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		for(Produto produto : entidade.getProdutos()){
			sql = "insert into lista_produto"
					+ "(id_lista, id_produto, quantidade_produto, valor_produto)"
					+ "values(?,?,?,?,)";
			
			smt = this.connection.prepareStatement(sql);
			smt.setInt(1, entidade.getId_lista());
			smt.setInt(2, produto.getId_produto());
			smt.setInt(3, produto.getQuantidade());
			smt.setFloat(4, produto.getValor());
			smt.execute();
			smt.close();
		}
		
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
