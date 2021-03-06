package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioProduto;
import fafica.listaacessivel.dados.repositorios.RepositorioProduto;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.util.Acentuacao;

public class ControladorProduto {

	private IRepositorioProduto repositorio_produto;
	
	public ControladorProduto() throws ClassNotFoundException, SQLException{
		this.repositorio_produto = RepositorioProduto.getInstancia();
	}
	
	public int adicionarProduto(Produto produto) throws SQLException{
		return this.repositorio_produto.adicionarProduto(produto);
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
		
		String categoria = "";
		String descricao = "";
		
		if(descricao_produto != null){
			descricao_produto = Acentuacao.limparAcentuacao(descricao_produto);
			System.err.println("TESTE DE DESCRICAO_PRODUTO "+descricao_produto);
		}
		if(categoria_produto != null){
			categoria_produto = Acentuacao.limparAcentuacao(categoria_produto);
			System.err.println("TESTE DE CATEGORIA_PRODUTO "+categoria_produto);
		}
		
		if(lista_produtos != null){
			if(categoria_produto != null && descricao_produto == null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					categoria = Acentuacao.limparAcentuacao(p.getCategoria());
					
					System.err.println("RESULTADO DA CATEGORIA! " + categoria);
					
					if(categoria.equals(categoria_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if(categoria_produto == null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					//descricao_produto = descricao_produto.toLowerCase();
					descricao = Acentuacao.limparAcentuacao(p.getDescricao());
					
					System.err.println("RESULTADO DA DESCRICAO! " + descricao);
					
					if(descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if(categoria_produto != null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					
					categoria = Acentuacao.limparAcentuacao(p.getCategoria());
					descricao = Acentuacao.limparAcentuacao(p.getDescricao());
					
					System.err.println("RESULTADO DA DESCRICAO! " + descricao);
					System.err.println("RESULTADO DA CATEGORIA! " + categoria);
					
					if(categoria.equals(categoria_produto) && descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if (categoria_produto == null && descricao_produto == null){
				return lista_produtos;
			}
		}
		return lista_produtos;
	}
	
	public List<Produto> listarProdutosPorLista(Lista lista) throws SQLException{
		return this.repositorio_produto.listarProdutosPorLista(lista);
	}
	
	public List<Produto> listarProdutosNaoSelecionado(Lista lista, String categoria_produto, String descricao_produto) throws SQLException{
		List<Produto> lista_produtos = this.repositorio_produto.listarProdutosPorEstabelecimento(lista.getEstabelecimento());
		
		String categoria = "";
		String descricao = "";
		
		if(descricao_produto != null){
			descricao_produto = Acentuacao.limparAcentuacao(descricao_produto);
			System.err.println("TESTE DE DESCRICAO_PRODUTO "+descricao_produto);
		}
		if(categoria_produto != null){
			categoria_produto = Acentuacao.limparAcentuacao(categoria_produto);
			System.err.println("TESTE DE CATEGORIA_PRODUTO "+categoria_produto);
		}
		
		List<Produto> auxRemocao = new ArrayList<Produto>();
		for(Produto produto : lista_produtos){
			for(Produto auxiliar : lista.getProdutos()){
				if(produto.getId_produto() == auxiliar.getId_produto()){
					auxRemocao.add(produto);
				}
			}
		}
		lista_produtos.removeAll(auxRemocao);
		
		List<Produto> pesquisa = null;
		if(lista_produtos != null){
			if(categoria_produto != null && descricao_produto == null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					
					categoria = Acentuacao.limparAcentuacao(p.getCategoria());
					
					if(categoria.equals(categoria_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if(categoria_produto == null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					
					descricao = Acentuacao.limparAcentuacao(p.getDescricao());
					
					if(descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if(categoria_produto != null && descricao_produto != null){
				pesquisa = new ArrayList<Produto>();
				for(Produto p : lista_produtos){
					
					descricao = Acentuacao.limparAcentuacao(p.getDescricao());
					categoria = Acentuacao.limparAcentuacao(p.getCategoria());
					
					if(categoria.equals(categoria_produto) && descricao.contains(descricao_produto)){
						pesquisa.add(p);
					}
				}
				if(pesquisa.size() != 0)
					lista_produtos = pesquisa;
				else
					lista_produtos = null;
			}else if (categoria_produto == null && descricao_produto == null){
				return lista_produtos;
			}
		}
		return lista_produtos;
	}
	
}
