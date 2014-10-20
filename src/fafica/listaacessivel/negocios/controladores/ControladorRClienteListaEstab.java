package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioRClienteListaEstab;
import fafica.listaacessivel.negocios.entidades.RClienteListaEstab;

public class ControladorRClienteListaEstab {

	private IRepositorio<RClienteListaEstab> repositorioRClienteListaEstab;
	
	public ControladorRClienteListaEstab() throws ClassNotFoundException, SQLException {
		this.repositorioRClienteListaEstab = RepositorioRClienteListaEstab.getInstancia();
	}
	
	public void adicionarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException {
		this.repositorioRClienteListaEstab.adicionar(entidade);
	}

	public void alterarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException {
		this.repositorioRClienteListaEstab.alterar(entidade);
	}

	public void excluirListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException {
		this.repositorioRClienteListaEstab.excluir(entidade);
	}

	public List<RClienteListaEstab> listar_lista_cliente_estabelecimento() throws SQLException {
		return this.repositorioRClienteListaEstab.listar();
	}

	public RClienteListaEstab pesquisarListaClienteEstabelecimento(RClienteListaEstab entidade) throws SQLException {
		return this.repositorioRClienteListaEstab.pesquisar(entidade);
	}
	
	
}
