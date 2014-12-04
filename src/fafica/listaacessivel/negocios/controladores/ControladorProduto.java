package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.DESCipher;

import fafica.listaacessivel.dados.IRepositorioProduto;
import fafica.listaacessivel.dados.repositorios.RepositorioProduto;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

public class ControladorProduto {

	private IRepositorioProduto repositorio_produto;
	
	public ControladorProduto() throws ClassNotFoundException, SQLException{
		this.repositorio_produto = RepositorioProduto.getInstancia();
	}
	
	public void adicionarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.adicionarProduto(produto);
	}
	
	public void alterarProduto(Produto produto) throws SQLException{
		this.repositorio_produto.alterarProduto(produto);
	}
	
	public void excluirProduto(Produto produto) throws SQLException{
		this.repositorio_produto.excluirProduto(produto);
	}
	
	public List<Produto> listarProduto() throws SQLException{
		return this.repositorio_produto.listarProdutos();
	}
	
	public Produto pesquisarProduto(Produto produto) throws SQLException{
		return this.repositorio_produto.pesquisarProduto(produto);
	}
	
	public List<Produto> listarProdutosPorEstabelecimento(Estabelecimento estabelecimento, String categoria_produto, String descricao_produto) throws SQLException{
		List<Produto> lista_produtos = this.repositorio_produto.listarProdutosPorEstabelecimento(estabelecimento);
		List<Produto> pesquisa = null;
		if(lista_produtos != null){
			if(categoria_produto != null && descricao_produto == null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					categoria_produto = categoria_produto.toLowerCase();
					String categoria = p.getCategoria().toLowerCase();
					if(categoria.equals(categoria_produto)){
						pesquisa.add(p);
					}
				}
				lista_produtos = pesquisa;
			}else if(categoria_produto == null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					descricao_produto = descricao_produto.toLowerCase();
					String descricao = p.getDescricao().toLowerCase();
					if(descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				lista_produtos = pesquisa;
			}else if(categoria_produto != null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					categoria_produto = categoria_produto.toLowerCase();
					descricao_produto = descricao_produto.toLowerCase();
					String descricao = p.getDescricao().toLowerCase();
					String categoria = p.getCategoria().toLowerCase();
					if(categoria.equals(categoria_produto) && descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				lista_produtos = pesquisa;
			}
		}
		return lista_produtos;
	}
	public List<Produto> listarProdutosPorLista(Lista lista) throws SQLException{
		return this.repositorio_produto.listarProdutosPorLista(lista);
	}
	
}
