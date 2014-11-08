package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Disponibilidade;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.dados.IRepositorioProduto;

public class RepositorioProduto implements IRepositorioProduto {

	private static RepositorioProduto instancia;
	private Connection connection;
	private PreparedStatement stm;
	private ResultSet result;
	private String sql;

	private RepositorioProduto() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}

	public static RepositorioProduto getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia==null){
			synchronized (RepositorioProduto.class) {
				if(instancia == null){
					instancia = new RepositorioProduto();
				}
			}
		}
		
		return instancia;
	}

	@Override
	public void adicionarProduto(Produto entidade) throws SQLException {
		String sql = "INSERT INTO produto (descricao, "
				+ "categoria, peso, "
				+ "quantidade, preco, "
				+ "validade, codigo_barra, "
				+ "marca, status, disponibilidade,"
				+ "id_estabelecimento) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		String disponibilidade;
			
		if(entidade.getQuantidade() >= 1){
			disponibilidade = Disponibilidade.DISPONIVEL.toString();
		}else{
			disponibilidade = Disponibilidade.INDISPONIVEL.toString();
		}
			
			stm = connection.prepareStatement(sql);
	
			stm.setString(1, entidade.getDescricao());
			stm.setString(2, entidade.getCategoria());
			stm.setFloat(3, entidade.getPeso());
			stm.setInt(4, entidade.getQuantidade());
			stm.setFloat(5, entidade.getValor());
			stm.setString(6, entidade.getValidade());
			stm.setString(7, entidade.getCodigo_barra());
			stm.setString(8, entidade.getMarca());
			stm.setString(9,Status.ATIVO.toString());
			stm.setString(10, disponibilidade);
			stm.setInt(11, entidade.getEstabelecimento().getId_estabelecimento());
			
			stm.execute();
			stm.close();
	}

	@Override
	public void alterarProduto(Produto entidade) throws SQLException {
		//Produto produto = pesquisar(entidade);
		String sql2;
		
		String sql = "UPDATE produto SET "+
				"descricao = '" + entidade.getDescricao()+"'" 
				+", categoria = '" + entidade.getCategoria()+"'" 
				+", peso = '" + entidade.getPeso()+"'"
				+", quantidade = " + entidade.getQuantidade() 
				+", preco = " + entidade.getValor() 
				+", validade = '" + entidade.getValidade()+"'" 
				+", codigo_barra = '" + entidade.getCodigo_barra()+"'"
				+", marca ='" + entidade.getMarca() +"'" 
				+" WHERE id_produto = " + entidade.getId_produto();
		
		if(entidade.getQuantidade() >= 1){
			sql2 = "UPDATE produto SET disponibilidade = '" + Disponibilidade.DISPONIVEL.toString() + "'";
		}else{
			sql2 = "UPDATE produto SET disponibilidade = '" + Disponibilidade.INDISPONIVEL.toString() + "'";
		}
		
			stm = connection.prepareStatement(sql);
			stm.execute();
			stm.close();
		
			
			stm = connection.prepareStatement(sql2);
			stm.execute();
			stm.close();
		
	}

	@Override
	public void excluirProduto(Produto entidade) throws SQLException {
		
		//Produto produto = pesquisar(entidade);

		String sql = "update produto set status = '" + Status.INATIVO.toString() + "' where id_produto = " + entidade.getId_produto();

		stm = connection.prepareStatement(sql);
		stm.execute();
		stm.close();
			
	}

	@Override
	public List<Produto> listarProdutos() throws SQLException {
		
		String sql = "select * from produto where status = '" + Status.ATIVO.toString() + "'";
		List<Produto> lista = new ArrayList<Produto>();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			Estabelecimento estabelecimento = new Estabelecimento();
			
			while(result.next()){
				
				int id = result.getInt("id");
				String descricao = result.getString("descricao");
				String categoria = result.getString("categoria"); 
				Float peso = result.getFloat("peso");
				int quantidade = result.getInt("quantidade");
				float preco = result.getFloat("preco");
				String validade = result.getString("validade");
				String marca = result.getString("marca");
				String codigo_de_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
				
				Produto produto = new Produto(id, descricao, categoria, peso,
						quantidade, preco, validade, marca, codigo_de_barra,
						disponibilidade, estabelecimento);
				
				lista.add(produto);
			}
			stm.close();
			result.close();
		
		return lista;
	}

	@Override
	public Produto pesquisarProduto(Produto entidade) throws SQLException {
		
			sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' and id_produto = "+ entidade.getId_produto();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			
			Produto produto = new Produto();
			Estabelecimento estabelecimento = new Estabelecimento();
			
			while(result.next()){
				int id = result.getInt("id");
				String descricao = result.getString("descricao");
				String categoria = result.getString("categoria"); 
				Float peso = result.getFloat("peso");
				int quantidade = result.getInt("quantidade");
				float preco = result.getFloat("preco");
				String validade = result.getString("validade");
				String marca = result.getString("marca");
				String codigo_de_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
				
				produto = new Produto(id, descricao, categoria, peso,
						quantidade, preco, validade, marca, codigo_de_barra,
						disponibilidade, estabelecimento);
			}
			stm.close();
			result.close();
		
		return produto;
	}

	@Override
	public List<Produto> listarProdutosDoEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		String sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' AND id_estabelecimento = " + estabelecimento.getId_estabelecimento();
		List<Produto> lista = new ArrayList<Produto>();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			
			while(result.next()){
				
				int id = result.getInt("id");
				String descricao = result.getString("descricao");
				String categoria = result.getString("categoria"); 
				Float peso = result.getFloat("peso");
				int quantidade = result.getInt("quantidade");
				float preco = result.getFloat("preco");
				String validade = result.getString("validade");
				String marca = result.getString("marca");
				String codigo_de_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
								
				Produto produto = new Produto(id, descricao, categoria, peso,
						quantidade, preco, validade, marca, codigo_de_barra,
						disponibilidade, estabelecimento);
				
				lista.add(produto);
			}
			stm.close();
			result.close();
		
		return lista;
	}

	@Override
	public List<Produto> listarProdutosDaLista(Lista lista) throws SQLException {
		String sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' AND id_lista = " + lista.getId_lista();
		List<Produto> lista_produto = new ArrayList<Produto>();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			Estabelecimento estabelecimento = new Estabelecimento();
			
			while(result.next()){
				
				int id_produto = result.getInt("id_produto");
				String descricao = result.getString("descricao");
				String categoria = result.getString("categoria"); 
				Float peso = result.getFloat("peso");
				int quantidade = result.getInt("quantidade");
				float preco = result.getFloat("preco");
				String validade = result.getString("validade");
				String marca = result.getString("marca");
				String codigo_de_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
				
				Produto produto = new Produto(id_produto, descricao, categoria, peso,
						quantidade, preco, validade, marca, codigo_de_barra,
						disponibilidade, estabelecimento);
				
				lista_produto.add(produto);
			}
			stm.close();
			result.close();
		
		return lista_produto;
	}
	
	
}
