package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioEstabelecimento;
import fafica.listaacessivel.dados.repositorios.RepositorioEstabelecimento;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public class ControladorEstabelecimento {
	
	private IRepositorioEstabelecimento repositorioEstabelecimento;
	
	public ControladorEstabelecimento() throws ClassNotFoundException, SQLException{
		repositorioEstabelecimento = RepositorioEstabelecimento.getInstancia();
	}
	
	public void adicionarEstabelecimento(Estabelecimento estabelecimento) throws SQLException {
		repositorioEstabelecimento.adicionarEstabelecimento(estabelecimento);	
	}

	public void alterarEstabelecimento(Estabelecimento estabelecimento) throws SQLException {
		repositorioEstabelecimento.alterarEstabelecimento(estabelecimento);
		
	}

	public void excluirEstabelecimento(Estabelecimento estabelecimento) throws SQLException {
		repositorioEstabelecimento.excluirEstabelecimento(estabelecimento);
		
	}

	public List<Estabelecimento> listarEstabelecimento() throws SQLException {
		
		return repositorioEstabelecimento.listarEstabelecimentos();
	}

	public Estabelecimento pesquisarEstabelecimento(Estabelecimento estabelecimento) throws SQLException {
		
		return repositorioEstabelecimento.pesquisarEstabelecimento(estabelecimento);
	}
}
