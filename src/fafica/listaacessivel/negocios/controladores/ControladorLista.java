package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioLista;
import fafica.listaacessivel.negocios.entidades.Lista;


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

}
