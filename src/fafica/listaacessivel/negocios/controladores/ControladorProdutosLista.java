package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioProdutosLista;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;

public class ControladorProdutosLista {
	
	private IRepositorio<ProdutosLista> repositorioProdutosLista;
	
	public ControladorProdutosLista() throws ClassNotFoundException, SQLException {
		this.repositorioProdutosLista = RepositorioProdutosLista.getInstancia();
	}
	
	public void adicionarProdutosLista(ProdutosLista entidade) throws SQLException {
		this.repositorioProdutosLista.adicionar(entidade);
		
	}

	public void alterarProdutosLista(ProdutosLista entidade) throws SQLException {
		this.repositorioProdutosLista.alterar(entidade);
		
	}

	public void excluirProdutosLista(ProdutosLista entidade) throws SQLException {
		this.repositorioProdutosLista.excluir(entidade);
		
	}

	public List<ProdutosLista> listarProdutosLista() throws SQLException {
		return this.repositorioProdutosLista.listar();
	}

	public ProdutosLista pesquisarProdutosLista(ProdutosLista entidade) throws SQLException {
		return this.repositorioProdutosLista.pesquisar(entidade);
	}
	
	public List <Produto> getProdutosDaList(Lista lista) throws ClassNotFoundException, SQLException{
		ControladorProdutosLista controladorProdutosLista = new ControladorProdutosLista();
		ControladorProduto controladorProduto = new ControladorProduto();
		ArrayList <ProdutosLista> codigosProdutos = new ArrayList<ProdutosLista>();
		ArrayList <Produto> produtos = new ArrayList<Produto>();
		
		
		for(ProdutosLista pl : controladorProdutosLista.listarProdutosLista()){
			if(pl.getId_lista() == lista.getId_lista()){
				codigosProdutos.add(pl);
			}
		}
		for(ProdutosLista cp : codigosProdutos){
			for(Produto p : controladorProduto.listarProduto()){
				if(cp.getId_produto() == p.getId_produto()){
					produtos.add(p);
				}
			}
		}
		return produtos;
	}

}
