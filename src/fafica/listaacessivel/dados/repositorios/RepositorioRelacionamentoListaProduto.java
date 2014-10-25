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
import fafica.listaacessivel.negocios.entidades.RelacionamentoListaProduto;

public class RepositorioRelacionamentoListaProduto implements IRepositorio<RelacionamentoListaProduto>{
	
	private static RepositorioRelacionamentoListaProduto instancia;
	private Connection connection;
	private ResultSet result;
	private PreparedStatement stm;
	
	private RepositorioRelacionamentoListaProduto() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioRelacionamentoListaProduto getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia == null) instancia = new RepositorioRelacionamentoListaProduto();
		return instancia;
	}

	@Override
	public void adicionar(RelacionamentoListaProduto entidade) throws SQLException {
		String sql = "INSERT INTO lista_produto(id_produto, id_lista, quantidade, status) VALUES (?,?,?,?)";
		
			stm = connection.prepareStatement(sql);
			
			stm.setInt(1, entidade.getId_produto());
			stm.setInt(2, entidade.getId_lista());
			stm.setInt(3, entidade.getQuantidade());
			stm.setString(4, Status.ATIVO.toString());
			
			stm.execute();
			stm.close();
		
	}

	@Override
	public void alterar(RelacionamentoListaProduto entidade) throws SQLException {
		//ProdutosLista produto_lista = pesquisar(entidade);
		
		String sql = "UPDATE lista_produto SET id_produto= " 
		+ entidade.getId_produto() + ", id_lista= " 
		+ entidade.getId_lista() + ", quantidade= " 
		+ entidade.getQuantidade() 
		+ ",status='" + Status.ATIVO.toString() + "' WHERE id_lista = " + entidade.getId_lista() + "AND id_produto = " + entidade.getId_produto();
		
			stm = connection.prepareStatement(sql);
			stm.execute();
			stm.close();
	}

	@Override
	public void excluir(RelacionamentoListaProduto entidade) throws SQLException {
		
		//ProdutosLista produto_lista = pesquisar(entidade);
		
		String sql = "UPDATE FROM lista_produto SET status = '" + Status.INATIVO.toString() + "' WHERE id_lista = " + entidade.getId_lista() + "AND id_produto = " + entidade.getId_produto();
		
		try{
			stm = connection.prepareStatement(sql);
			stm.execute();
		} catch(Exception e){
			
		} finally{
			stm.close();
		}
		
	}

	@Override
	public List<RelacionamentoListaProduto> listar() throws SQLException {
		String sql = "select * from lista_produto where status = '" + Status.ATIVO.toString() + "'";
		List<RelacionamentoListaProduto> lista_produtos_lista = new ArrayList<RelacionamentoListaProduto>();
		
			stm = connection.prepareStatement(sql);
			result = stm.executeQuery();
			
			while(result.next()){
				int id_lista = result.getInt("id_lista");
				int id_produto = result.getInt("id_produto");
				int quantidade = result.getInt("quantidade");
				
				RelacionamentoListaProduto produtos_lista = new RelacionamentoListaProduto(id_lista, id_produto, quantidade);
				
				lista_produtos_lista.add(produtos_lista);
			}
			
			stm.close();
			result.close();
		
		
		return lista_produtos_lista;
	}

	@Override
	public RelacionamentoListaProduto pesquisar(RelacionamentoListaProduto entidade) throws SQLException {
		List<RelacionamentoListaProduto> lista_produtos_lista = new ArrayList<RelacionamentoListaProduto>();
		RelacionamentoListaProduto produtos_lista_pesquisa = null;
		
		lista_produtos_lista = listar();
		
		for(RelacionamentoListaProduto produtos_pesquisa : lista_produtos_lista){
			if(entidade.getId_lista() == produtos_pesquisa.getId_lista() && entidade.getId_produto() == produtos_pesquisa.getId_produto()){
				produtos_lista_pesquisa = produtos_pesquisa;
			}
		}
		
		return produtos_lista_pesquisa;
	}
	
//	public List <Produto> listarProdutosDaLista(Lista l) throws SQLException, ClassNotFoundException{
//		String sql = "select id_produto from lista_produto where id_lista ="+l.getId_lista();
//		stm = connection.prepareStatement(sql);
//		result = stm.executeQuery();
//		
//		ArrayList<Produto> produtos = new ArrayList<Produto>();
//		ControladorProduto controladorProduto = new ControladorProduto();
//		while(result.next()){
//			Produto p = new Produto();
//			p.setId_produto(result.getInt("id_produto"));
//			produtos.add(controladorProduto.pesquisarProduto(p));
//		}
//		return produtos;
//	}
	
}
