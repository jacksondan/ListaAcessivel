package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioEstabelecimento;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Produto;

public class ControladorEstabelecimento {
	
	private IRepositorio<Estabelecimento> repositorioEstabelecimento;
	
	public ControladorEstabelecimento() throws ClassNotFoundException, SQLException{
		repositorioEstabelecimento = RepositorioEstabelecimento.getInstancia();
	}
	
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException {
		repositorioEstabelecimento.adicionar(entidade);	
	}

	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException {
		repositorioEstabelecimento.alterar(entidade);
		
	}

	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException {
		repositorioEstabelecimento.excluir(entidade);
		
	}

	public List<Estabelecimento> listarEstabelecimento() throws SQLException {
		
		return repositorioEstabelecimento.listar();
	}

	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException {
		
		return repositorioEstabelecimento.pesquisar(entidade);
	}
	
	public List<Produto> listarProdutosDoEstababelecimento(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException{
		ControladorProduto controladorProduto = new ControladorProduto();
		
		List<Produto> lista_produtos = new ArrayList<Produto>();
		List<Produto> lista_produtos_estabelecimento = new ArrayList<Produto>();
		lista_produtos = controladorProduto.listarProduto();
		
		for(Produto produto : lista_produtos){
			if(produto.getId_estabelecimento() == estabelecimento.getId_estabelecimento()){
				lista_produtos_estabelecimento.add(produto);
			}
		}
		return lista_produtos_estabelecimento;
	}
}
