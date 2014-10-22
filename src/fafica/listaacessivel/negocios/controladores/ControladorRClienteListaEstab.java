package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioRClienteListaEstab;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
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
	
	public List <Lista> getListasDoCliente(Cliente entidade) throws ClassNotFoundException, SQLException {
		ControladorLista controladorLista = new ControladorLista();
		
		List<RClienteListaEstab> relacoes = new ArrayList<>();
		List<Lista> listas = new ArrayList<>();
		
		for(RClienteListaEstab r : this.listar_lista_cliente_estabelecimento()){
			if(entidade.getId_usuario()==r.getId_cliente()){
				relacoes.add(r);
			}
		}
		
		for(RClienteListaEstab r : relacoes){
			for(Lista l : controladorLista.listarLista()){
				if(l.getId_lista() == r.getId_lista()){
					listas.add(l);
				}
			}
		}
		
		return listas;
	}
	
	public List <Lista> getListasDoEstabelecimento(Estabelecimento entidade) throws ClassNotFoundException, SQLException {
		ControladorLista controladorLista = new ControladorLista();
		
		List<RClienteListaEstab> relacoes = new ArrayList<>();
		List<Lista> listas = new ArrayList<>();
		
		for(RClienteListaEstab r : this.listar_lista_cliente_estabelecimento()){
			if(entidade.getId_usuario()==r.getId_estabelecimento()){
				relacoes.add(r);
			}
		}
		
		for(RClienteListaEstab r : relacoes){
			for(Lista l : controladorLista.listarLista()){
				if(l.getId_lista() == r.getId_lista()){
					listas.add(l);
				}
			}
		}
		
		return listas;
	}
	
	public Cliente getClienteDaLista(Lista entidade) throws ClassNotFoundException, SQLException {
		ControladorCliente controladorCliente = new ControladorCliente();
		RClienteListaEstab relacao = null;
		Cliente cliente = new Cliente();
		
		for(RClienteListaEstab r : this.listar_lista_cliente_estabelecimento()){
			if(r.getId_lista() == entidade.getId_lista()){
				relacao = r;
				break;
			}
		}
		if(relacao != null){
			cliente.setId_usuario(relacao.getId_cliente());
			cliente = controladorCliente.pesquisarCliente(cliente);
		}
		
		return cliente;
	}
	
	public Estabelecimento getEstabelecimentoDaLista(Lista entidade) throws ClassNotFoundException, SQLException {
		ControladorEstabelecimento controladorEstabelecimento = new ControladorEstabelecimento();
		RClienteListaEstab relacao = null;
		Estabelecimento estabelecimento = new Estabelecimento();
		
		for(RClienteListaEstab r : this.listar_lista_cliente_estabelecimento()){
			if(r.getId_lista() == entidade.getId_lista()){
				relacao = r;
				break;
			}
		}
		if(relacao != null){
			estabelecimento.setId_usuario(relacao.getId_estabelecimento());
			estabelecimento = controladorEstabelecimento.pesquisarEstabelecimento(estabelecimento);
		}
		
		
		return estabelecimento;
	}
	
}
