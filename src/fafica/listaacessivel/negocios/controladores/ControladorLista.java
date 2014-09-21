package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioLista;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.ProdutosLista;


public class ControladorLista {
	
	private IRepositorio<Lista> repositorioLista;
	
	public ControladorLista() throws ClassNotFoundException, SQLException {
		this.repositorioLista = RepositorioLista.getInstancia();
	}

	public void adicionarLista(Lista entidade) throws SQLException {
		this.repositorioLista.adicionar(entidade);
		
	}

	public void alterarLista(Lista entidade) throws SQLException {
		this.repositorioLista.alterar(entidade);
		
	}

	public void excluirLista(Lista entidade) throws SQLException {
		this.repositorioLista.excluir(entidade);
		
	}

	public List<Lista> listarLista() throws SQLException {
		return this.repositorioLista.listar();
	}

	public Lista pesquisarLista(Lista entidade) throws SQLException {
		return this.repositorioLista.pesquisar(entidade);
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
