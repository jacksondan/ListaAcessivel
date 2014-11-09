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
	public void adicionarProduto(Produto entidade) throws SQLException {
		sql = "INSERT INTO produto (descricao, "
				+ "categoria, peso, "
				+ "quantidade, valor, "
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
		
		String disponibilidade;
		if(entidade.getQuantidade() >= 1){
			disponibilidade = Disponibilidade.DISPONIVEL.toString();
		}else{
			disponibilidade = Disponibilidade.INDISPONIVEL.toString();
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
	}

	@Override
	public void excluirProduto(Produto entidade) throws SQLException {
		
		//Produto produto = pesquisar(entidade);

		sql = "update produto set status = '" + Status.INATIVO.toString() + "' where id_produto = " + entidade.getId_produto();

		stm = connection.prepareStatement(sql);
		stm.execute();
		stm.close();
			
	}

	@Override
	public List<Produto> listarProdutos() throws SQLException {
		
		sql = "select * from produto where status = '" + Status.ATIVO.toString() + "'";
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
			
			int id = result.getInt("id");
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
		
		return lista_produtos;
	}

	@Override
	public Produto pesquisarProduto(Produto entidade) throws SQLException {
		
			sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' and id_produto = "+ entidade.getId_produto();
			stm = connection.prepareStatement(sql);
			result = stm.executeQuery();
			
			Produto produto = null;
			Estabelecimento estabelecimento = null;
			
			while(result.next()){
				estabelecimento = new Estabelecimento();
				
				int id = result.getInt("id");
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
		
		return produto;
	}

	@Override
	public List<Produto> listarProdutosPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException {
		sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' AND id_estabelecimento = " + estabelecimento.getId_estabelecimento();
		stm = connection.prepareStatement(sql);
		result = stm.executeQuery();
		
		List<Produto> lista_produtos = null;
		Produto produto;
		
		while(result.next()){
			if(lista_produtos == null) {
				lista_produtos = new ArrayList<Produto>();
			}
			
			int id = result.getInt("id");
			String descricao = result.getString("descricao");
			String categoria = result.getString("categoria"); 
			Float peso = result.getFloat("peso");
			int quantidade = result.getInt("quantidade");
			float valor = result.getFloat("valor");
			String validade = result.getString("validade");
			String marca = result.getString("marca");
			String codigo_barra = result.getString("codigo_barra");
			String disponibilidade = result.getString("disponibilidade");
			/*Verificar a necessidade de criar varios objetos de estabelecimento. da maneira que esta, 
			todos os produtos apontam para apenas um objeto do estabelecimento, mais
			se alguem quizer alterar o ID desse unico objeto via linha de comando, todos os outros produtos
			podem dar problema. isso é algo para ser debatido.
			O metodos listaProdutos cria variso estabelecimentos, porque não sabe qual o ID que ira receber 
			*/
			
			produto = new Produto(id, descricao, categoria, peso,
					quantidade, valor, validade, marca, codigo_barra,
					disponibilidade, estabelecimento);
			
			lista_produtos.add(produto);
		}
		stm.close();
		result.close();
		
		return lista_produtos;
	}

	@Override
	public List<Produto> listarProdutosPorLista(Lista lista) throws SQLException {
		
		//Primeiro verificamos se a relação entre os produtos e a lista (Tabela lista_produto)
		sql = "select * from lista_produto where status = '" + Status.ATIVO.toString() + "' AND id_lista = " + lista.getId_lista();
		stm = connection.prepareStatement(sql);	
		result = stm.executeQuery();
		
		List<Produto> listaProdutosUtil = null;
		List<Produto> lista_produtos = null;
		Produto produto;
		Estabelecimento estabelecimento;
		
		while(result.next()){
			if(listaProdutosUtil == null){
				listaProdutosUtil = new ArrayList<Produto>();
			}
			int id_produto = result.getInt("id_produto");
			int quantidade = result.getInt("quantidade_produto"); // Atributo importante na relação
			float valor = result.getFloat("valor_produto"); // Atributo importante na relação
					
			Produto produtoUtil = new Produto(id_produto, null, null, 0.0f, quantidade, valor, null, null, null, null, null);
			
			listaProdutosUtil.add(produtoUtil);
		}
		stm.close();
		result.close();
		
		
		if(listaProdutosUtil != null){ //Linha que verifica se a produtos na relação com lista
			lista_produtos = new ArrayList<Produto>(); //Iniciando o lista que ira ser retornada
			estabelecimento = lista.getEstabelecimento();
			
			for(Produto produtoUtil : listaProdutosUtil){
				sql = "select * from produto where status = '" + Status.ATIVO.toString() + "' and id_produto = "+ produtoUtil.getId_produto();
				stm = connection.prepareStatement(sql);
				result = stm.executeQuery(); 	
				
				while(result.next()){
					int id = result.getInt("id");
					String descricao = result.getString("descricao");
					String categoria = result.getString("categoria"); 
					Float peso = result.getFloat("peso");
					int quantidade = produtoUtil.getQuantidade();
					float valor = produtoUtil.getValor();
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
			}

		}
		
		return lista_produtos;
	}
}
