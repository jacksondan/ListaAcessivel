package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Disponibilidade;
import fafica.listaacessivel.dados.util.Status;

public class RepositorioProduto implements IRepositorio<Produto> {

	private static RepositorioProduto instancia;
	private Connection connection;
	private PreparedStatement stm;
	private ResultSet result;
	private String sql;

	private RepositorioProduto() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}

	public static RepositorioProduto getInstancia() throws ClassNotFoundException, SQLException {
		if (instancia == null) {
			instancia = new RepositorioProduto();
		}
		return instancia;
	}

	@Override
	public void adicionar(Produto entidade) throws SQLException {
		String sql = "INSERT INTO produto (descricao_produto, "
				+ "categoria_produto, peso_produto, "
				+ "quantidade_produto, preco_produto, "
				+ "validade_produto, codigo_barra, "
				+ "marca_produto, status, disponibilidade,"
				+ "id_estabelecimento) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		String disponibilidade;
		if(entidade.getQuantidade_produto() >= 1){
			disponibilidade = Disponibilidade.DISPONIVEL.toString();
		}else{
			disponibilidade = Disponibilidade.INDISPONIVEL.toString();
		}
			
			stm = connection.prepareStatement(sql);
	
			stm.setString(1, entidade.getDescricao_produto());
			stm.setString(2, entidade.getCategoria());
			stm.setString(3, entidade.getPeso_produto());
			stm.setInt(4, entidade.getQuantidade_produto());
			stm.setFloat(5, entidade.getPreco_produto());
			stm.setString(6, entidade.getValidade_produto());
			stm.setString(7, entidade.getCodigo_de_barra());
			stm.setString(8, entidade.getMarca_produto());
			stm.setString(9,Status.ATIVO.toString());
			stm.setString(10, disponibilidade);
			stm.setInt(11, entidade.getId_estabelecimento());
			
			stm.execute();
			stm.close();
	}

	@Override
	public void alterar(Produto entidade) throws SQLException {
		//Produto produto = pesquisar(entidade);
		String sql2;
		
		String sql = "UPDATE produto SET descricao_produto= " + entidade.getDescricao_produto() + 
				", categoria_produto = '" + entidade.getCategoria() + 
				"', peso_produto = " + entidade.getPeso_produto() + 
				", quantidade_produto = " + entidade.getQuantidade_produto() + 
				", preco_produto = " + entidade.getPreco_produto() + 
				", validade_produto = '" + entidade.getValidade_produto() + 
				"', codigo_barra = '" + entidade.getCodigo_de_barra() +
				"', marca_produto ='" + entidade.getMarca_produto() + 
				"' WHERE id_produto = " + entidade.getId_produto();
		
		if(entidade.getQuantidade_produto() >= 1){
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
	public void excluir(Produto entidade) throws SQLException {
		
		//Produto produto = pesquisar(entidade);

		String sql = "update produto set status = '" + Status.INATIVO.toString() + "' where id_produto = " + entidade.getId_produto();

		stm = connection.prepareStatement(sql);
		stm.execute();
		stm.close();
			
	}

	@Override
	public List<Produto> listar() throws SQLException {
		
		String sql = "select * from produto where status = '" + Status.ATIVO.toString() + "'";
		List<Produto> lista_produto = new ArrayList<Produto>();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			
			while(result.next()){
				
				int id_produto = result.getInt("id_produto");
				String descricao_produto = result.getString("descricao_produto");
				String categoria = result.getString("descricao_produto"); 
				String peso_produto = result.getString("peso_produto");
				int quantidade_produto = result.getInt("quantidade_produto");
				float preco_produto = result.getFloat("preco_produto");
				String validade_produto = result.getString("validade_produto");
				String marca_produto = result.getString("marca_produto");
				String codigo_de_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				int id_estabelecimento = result.getInt("id_estabelecimento");
				
				Produto produto = new Produto(id_produto, descricao_produto, categoria, peso_produto,
						quantidade_produto, preco_produto, validade_produto, marca_produto, codigo_de_barra,
						disponibilidade, id_estabelecimento);
				
				lista_produto.add(produto);
			}
			stm.close();
			result.close();
		
		return lista_produto;
	}

	@Override
	public Produto pesquisar(Produto entidade) throws SQLException {
		
			sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' and id_produto = "+entidade.getId_produto();
		
			stm = connection.prepareStatement(sql);
			
			result = stm.executeQuery();
			
			Produto produto = new Produto();
			
			while(result.next()){
				produto.setId_produto(result.getInt("id_produto"));
				produto.setDescricao_produto(result.getString("descricao_produto"));
				produto.setCategoria(result.getString("descricao_produto"));
				produto.setPeso_produto(result.getString("peso_produto"));
				produto.setQuantidade_produto(result.getInt("quantidade_produto"));
				produto.setPreco_produto(result.getFloat("preco_produto"));
				produto.setValidade_produto(result.getString("validade_produto"));
				produto.setMarca_produto(result.getString("marca_produto"));
				produto.setCodigo_de_barra(result.getString("codigo_barra"));
				produto.setDisponibilidade(result.getString("disponibilidade"));
				produto.setId_estabelecimento(result.getInt("id_estabelecimento"));
			}
			stm.close();
			result.close();
		
		return produto;
		
		
		
		
		
		/*List<Produto> lista_produto = new ArrayList<Produto>();
		Produto produto_pesquisa = null;
		
		
		lista_produto = listar();
		
		for(Produto produto : lista_produto){
			if(entidade.getId_produto() == produto.getId_produto()){
				produto_pesquisa = produto;
			}
		}
		
		return produto_pesquisa;*/
	}

}
