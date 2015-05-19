package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.util.ConnectionMysql;
import fafica.listaacessivel.negocios.util.DisponibilidadeProduto;
import fafica.listaacessivel.negocios.util.StatusLista;
import fafica.listaacessivel.dados.IRepositorioProduto;

public class RepositorioProduto implements IRepositorioProduto {

	private static RepositorioProduto instancia;
	private Connection connection;
	private PreparedStatement stm;
	private ResultSet result;
	private String sql; // SQL PARA COMANDOS NO BD**************

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
	public int adicionarProduto(Produto entidade) throws SQLException {
		int id_auto_increment = 0;
		
		sql = "INSERT INTO produto (descricao, "
				+ "categoria, peso, "
				+ "quantidade, valor, "
				+ "validade, codigo_barra, "
				+ "marca, status, disponibilidade,"
				+ "id_estabelecimento) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		String disponibilidade;
			
		if(entidade.getQuantidade() >= 1){
			disponibilidade = DisponibilidadeProduto.DISPONIVEL.toString();
		}else{
			disponibilidade = DisponibilidadeProduto.INDISPONIVEL.toString();
		}
			
			stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
			stm.setString(1, entidade.getDescricao());
			stm.setString(2, entidade.getCategoria());
			stm.setFloat(3, entidade.getPeso());
			stm.setInt(4, entidade.getQuantidade());
			stm.setFloat(5, entidade.getValor());
			stm.setString(6, entidade.getValidade());
			stm.setString(7, entidade.getCodigo_barra());
			stm.setString(8, entidade.getMarca());
			stm.setString(9,StatusLista.ATIVO.toString());
			stm.setString(10, disponibilidade);
			stm.setInt(11, entidade.getEstabelecimento().getId_estabelecimento());
			stm.execute();
			
			result = stm.getGeneratedKeys();
			if(result.next()){
				id_auto_increment = result.getInt(1);
			}
			result.close();
			stm.close();
			
			System.out.println("ADICIONAR PRODUTO OK");
			
			return id_auto_increment;
	}

	@Override
	public void alterarProduto(Produto entidade) throws SQLException {
		
		String disponibilidade;
		if(entidade.getQuantidade() >= 1){
			disponibilidade = DisponibilidadeProduto.DISPONIVEL.toString();
		}else{
			disponibilidade = DisponibilidadeProduto.INDISPONIVEL.toString();
		}
		
		sql = "UPDATE produto SET "+
				"descricao = '" + entidade.getDescricao()+"'" 
				+", categoria = '" + entidade.getCategoria()+"'" 
				+", peso = " + entidade.getPeso()
				+", quantidade = " + entidade.getQuantidade() 
				+", valor = " + entidade.getValor() 
				+", validade = '" + entidade.getValidade()+"'" 
				+", codigo_barra = '" + entidade.getCodigo_barra()+"'"
				+", marca = '" + entidade.getMarca() +"'"
				+", disponibilidade = '" + disponibilidade +"'"
				+" WHERE id_produto = " + entidade.getId_produto();
		
			stm = connection.prepareStatement(sql);
			stm.execute();
			stm.close();
			
			System.out.println("ALTERAR PRODUTO OK");
	}

	@Override
	public void excluirProduto(Produto entidade) throws SQLException {
		
		//Produto produto = pesquisar(entidade);

		sql = "update produto set status = '" + StatusLista.INATIVO.toString() + "' where id_produto = " + entidade.getId_produto();

		stm = connection.prepareStatement(sql);
		stm.execute();
		stm.close();
		
		System.out.println("EXCLUIR PRODUTO OK");
	}

	@Override
	public List<Produto> listarProdutos() throws SQLException {
		
		sql = "select * from produto where status = '" + StatusLista.ATIVO.toString() + "'";
		stm = connection.prepareStatement(sql);
		result = stm.executeQuery();
		
		List<Produto> lista_produtos = null;
		Estabelecimento estabelecimento;
		Produto produto;
		
		while(result.next()){
			if(lista_produtos == null) {
				lista_produtos = new ArrayList<Produto>();
			}
			estabelecimento = new Estabelecimento();
			
			int id = result.getInt("id_produto");
			String descricao = result.getString("descricao");
			String categoria = result.getString("categoria"); 
			Float peso = result.getFloat("peso");
			int quantidade = result.getInt("quantidade");
			float valor = result.getFloat("valor");
			String validade = result.getString("validade");
			String marca = result.getString("marca");
			String codigo_barra = result.getString("codigo_barra");
			String disponibilidade = result.getString("disponibilidade");
			estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
			
			produto = new Produto(id, descricao, categoria, peso,
					quantidade, valor, validade, marca, codigo_barra,
					disponibilidade, estabelecimento);
			
			lista_produtos.add(produto);
		}
		stm.close();
		result.close();
		
		System.out.println("LISTAR PRODUTOS OK");
		return lista_produtos;
	}

	@Override
	public Produto pesquisarProduto(Produto entidade) throws SQLException {
		
			sql = "select * from produto where status = '" + StatusLista.ATIVO.toString() + "' and id_produto = "+ entidade.getId_produto();
			stm = connection.prepareStatement(sql);
			result = stm.executeQuery();
			
			Produto produto = null;
			Estabelecimento estabelecimento = null;
			
			if (result.next()){
				estabelecimento = new Estabelecimento();
				
				int id = result.getInt("id_produto");
				String descricao = result.getString("descricao");
				String categoria = result.getString("categoria"); 
				Float peso = result.getFloat("peso");
				int quantidade = result.getInt("quantidade");
				float valor = result.getFloat("valor");
				String validade = result.getString("validade");
				String marca = result.getString("marca");
				String codigo_barra = result.getString("codigo_barra");
				String disponibilidade = result.getString("disponibilidade");
				estabelecimento.setId_estabelecimento(result.getInt("id_estabelecimento"));
				
				produto = new Produto(id, descricao, categoria, peso,
						quantidade, valor, validade, marca, codigo_barra,
						disponibilidade, estabelecimento);
			}
			stm.close();
			result.close();
		
		System.out.println("PESQUISAR PRODUTO OK");
		return produto;
	}

	@Override
	public List<Produto> listarProdutosPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		sql = "select * from produto where status = '" + StatusLista.ATIVO.toString() + "' AND id_estabelecimento = " + estabelecimento.getId_estabelecimento();
		stm = connection.prepareStatement(sql);
		result = stm.executeQuery();
		
		List<Produto> lista_produtos = null;
		Produto produto;
		
		while(result.next()){
			if(lista_produtos == null) {
				lista_produtos = new ArrayList<Produto>();
			}
			
			int id = result.getInt("id_produto");
			String descricao = result.getString("descricao");
			String categoria = result.getString("categoria"); 
			Float peso = result.getFloat("peso");
			int quantidade = result.getInt("quantidade");
			float valor = result.getFloat("valor");
			String validade = result.getString("validade");
			String marca = result.getString("marca");
			String codigo_barra = result.getString("codigo_barra");
			String disponibilidade = result.getString("disponibilidade");
			
			produto = new Produto(id, descricao, categoria, peso,
					quantidade, valor, validade, marca, codigo_barra,
					disponibilidade, estabelecimento);
			
			lista_produtos.add(produto);
		}
		stm.close();
		result.close();
		
		System.out.println("LISTAR PRODUTOS POR ESTABELECIMENTO OK");
		return lista_produtos;
	}

	@Override
	public List<Produto> listarProdutosPorLista(Lista lista) throws SQLException {
		
		sql = "select lp.*, p.*, lce.* from lista_produto lp, lista_cliente_estabelecimento lce, produto p where"
				+ " lp.id_lista = " +lista.getId_lista()+ " and lce.id_lista = " +lista.getId_lista()
				+ " and lp.id_produto = p.id_produto and p.status = '" +StatusLista.ATIVO.toString()+ "'";
		
		stm = connection.prepareStatement(sql);	
		result = stm.executeQuery();
		
		List<Produto> lista_produtos = null;
		Estabelecimento estabelecimento = null;
		
		while(result.next()){
			if(lista_produtos == null){
				lista_produtos = new ArrayList<Produto>();
				estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(result.getInt("lce.id_estabelecimento"));
			}
			
			int id_produto = result.getInt("p.id_produto");;
			String descricao = result.getString("p.descricao");
			String categoria = result.getString("p.categoria");
			float peso = result.getFloat("p.peso");
			int quantidade = result.getInt("lp.quantidade_produto");
			float valor = result.getFloat("lp.valor_produto");;
			String validade = result.getString("p.validade");
			String marca = result.getString("p.marca");
			String codigo_barra = result.getString("p.codigo_barra");
			String disponibilidade = result.getString("p.disponibilidade");
			
			
			Produto produto = new Produto (id_produto, descricao, categoria, 
					peso, quantidade, valor, validade, marca, 
					codigo_barra, disponibilidade, estabelecimento);
			lista_produtos.add(produto);
		}
		stm.close();
		result.close();
		
		System.out.println("LISTAR PRODUTOS POR LISTA OK");
		return lista_produtos;
	}
}
