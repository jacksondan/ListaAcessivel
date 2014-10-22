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
	
	public List<Produto> getProdutosDoEstababelecimento(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException{
		ControladorProduto controladorProduto = new ControladorProduto();
		List<Produto> lista_produtos = new ArrayList<Produto>();
		
		for(Produto p : controladorProduto.listarProduto()){
			if(p.getId_estabelecimento() == estabelecimento.getId_usuario()){
				lista_produtos.add(p);
			}
		}
		
		return lista_produtos;
	}
}
