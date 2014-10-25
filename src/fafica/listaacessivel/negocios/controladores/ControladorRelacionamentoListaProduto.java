package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioRelacionamentoListaProduto;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.entidades.RelacionamentoListaProduto;

public class ControladorRelacionamentoListaProduto {
	
	private IRepositorio<RelacionamentoListaProduto> repositorioRelacionamentoListaProduto;
	
	public ControladorRelacionamentoListaProduto() throws ClassNotFoundException, SQLException {
		this.repositorioRelacionamentoListaProduto = RepositorioRelacionamentoListaProduto.getInstancia();
	}
	
	public void adicionarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException {
		this.repositorioRelacionamentoListaProduto.adicionar(entidade);
		
	}

	public void alterarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException {
		this.repositorioRelacionamentoListaProduto.alterar(entidade);
		
	}

	public void excluirRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException {
		this.repositorioRelacionamentoListaProduto.excluir(entidade);
		
	}

	public List<RelacionamentoListaProduto> listarRelacionamentoListaProduto() throws SQLException {
		return this.repositorioRelacionamentoListaProduto.listar();
	}

	public RelacionamentoListaProduto pesquisarRelacionamentoListaProduto(RelacionamentoListaProduto entidade) throws SQLException {
		return this.repositorioRelacionamentoListaProduto.pesquisar(entidade);
	}
	
	public List <Produto> listarProdutosDaLista(Lista lista) throws ClassNotFoundException, SQLException{
		ControladorRelacionamentoListaProduto controladorProdutosLista = new ControladorRelacionamentoListaProduto();
		ControladorProduto controladorProduto = new ControladorProduto();
		ArrayList <RelacionamentoListaProduto> codigosProdutos = new ArrayList<RelacionamentoListaProduto>();
		ArrayList <Produto> produtos = new ArrayList<Produto>();
		
		
		for(RelacionamentoListaProduto pl : controladorProdutosLista.listarRelacionamentoListaProduto()){
			if(pl.getId_lista() == lista.getId_lista()){
				codigosProdutos.add(pl);
			}
		}
		for(RelacionamentoListaProduto cp : codigosProdutos){
			for(Produto p : controladorProduto.listarProduto()){
				if(cp.getId_produto() == p.getId_produto()){
					produtos.add(p);
				}
			}
		}
		return produtos;
	}

}
