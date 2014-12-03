package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioLista;
import fafica.listaacessivel.dados.repositorios.RepositorioLista;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;


public class ControladorLista {
	
	private IRepositorioLista repositorioLista;
	
	public ControladorLista() throws ClassNotFoundException, SQLException {
		this.repositorioLista = RepositorioLista.getInstancia();
	}

	public int adicionarLista(Lista entidade) throws SQLException {
		return this.repositorioLista.adicionarLista(entidade);
		
	}

	public void alterarLista(Lista entidade) throws SQLException {
		this.repositorioLista.alterarLista(entidade);
		
	}

	public void excluirLista(Lista entidade) throws SQLException {
		this.repositorioLista.excluirLista(entidade);
		
	}

	public List<Lista> listarLista() throws SQLException {
		return this.repositorioLista.listarListas();
	}

	public Lista pesquisarLista(Lista entidade) throws SQLException {
		return this.repositorioLista.pesquisarLista(entidade);
	}

	public List<Lista> listarListaPorCLiente(Cliente cliente) throws SQLException{
		return this.repositorioLista.listarListasPorCliente(cliente);
	}
	
	public List<Lista> listarListaPorEstabelecimento(Estabelecimento estabelecimento) throws SQLException{
		return this.repositorioLista.listarListasPorEstabelecimento(estabelecimento);
	}
}
