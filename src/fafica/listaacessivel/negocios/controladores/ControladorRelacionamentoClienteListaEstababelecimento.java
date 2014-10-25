package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.repositorios.RepositorioRelacionamentoClienteListaEstababelecimento;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.RelacionamentoClienteListaEstababelecimento;

public class ControladorRelacionamentoClienteListaEstababelecimento {

	private IRepositorio<RelacionamentoClienteListaEstababelecimento> repositorioRelacionamentoClienteListaEstababelecimento;
	
	public ControladorRelacionamentoClienteListaEstababelecimento() throws ClassNotFoundException, SQLException {
		this.repositorioRelacionamentoClienteListaEstababelecimento = RepositorioRelacionamentoClienteListaEstababelecimento.getInstancia();
	}
	
	public void adicionarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
		this.repositorioRelacionamentoClienteListaEstababelecimento.adicionar(entidade);
	}

	public void alterarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
		this.repositorioRelacionamentoClienteListaEstababelecimento.alterar(entidade);
	}

	public void excluirRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
		this.repositorioRelacionamentoClienteListaEstababelecimento.excluir(entidade);
	}

	public List<RelacionamentoClienteListaEstababelecimento> listarRelacionamentoClienteListaEstababelecimento() throws SQLException {
		return this.repositorioRelacionamentoClienteListaEstababelecimento.listar();
	}

	public RelacionamentoClienteListaEstababelecimento pesquisarRelacionamentoClienteListaEstababelecimento(RelacionamentoClienteListaEstababelecimento entidade) throws SQLException {
		return this.repositorioRelacionamentoClienteListaEstababelecimento.pesquisar(entidade);
	}
	
	public List <Lista> listarListasDoCliente(Cliente entidade) throws ClassNotFoundException, SQLException {
		ControladorLista controladorLista = new ControladorLista();
		
		List<RelacionamentoClienteListaEstababelecimento> relacoes = new ArrayList<>();
		List<Lista> listas = new ArrayList<>();
		
		for(RelacionamentoClienteListaEstababelecimento r : this.listarRelacionamentoClienteListaEstababelecimento()){
			if(entidade.getId_usuario()==r.getId_cliente()){
				relacoes.add(r);
			}
		}
		
		for(RelacionamentoClienteListaEstababelecimento r : relacoes){
			for(Lista l : controladorLista.listarLista()){
				if(l.getId_lista() == r.getId_lista()){
					listas.add(l);
				}
			}
		}
		
		return listas;
	}
	
	public List <Lista> listarListasDoEstabelecimento(Estabelecimento entidade) throws ClassNotFoundException, SQLException {
		ControladorLista controladorLista = new ControladorLista();
		
		List<RelacionamentoClienteListaEstababelecimento> relacoes = new ArrayList<>();
		List<Lista> listas = new ArrayList<>();
		
		for(RelacionamentoClienteListaEstababelecimento r : this.listarRelacionamentoClienteListaEstababelecimento()){
			if(entidade.getId_usuario()==r.getId_estabelecimento()){
				relacoes.add(r);
			}
		}
		
		for(RelacionamentoClienteListaEstababelecimento r : relacoes){
			for(Lista l : controladorLista.listarLista()){
				if(l.getId_lista() == r.getId_lista()){
					listas.add(l);
				}
			}
		}
		
		return listas;
	}
	
	public Cliente listarClienteDaLista(Lista entidade) throws ClassNotFoundException, SQLException {
		ControladorCliente controladorCliente = new ControladorCliente();
		RelacionamentoClienteListaEstababelecimento relacao = null;
		Cliente cliente = new Cliente();
		
		for(RelacionamentoClienteListaEstababelecimento r : this.listarRelacionamentoClienteListaEstababelecimento()){
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
	
	public Estabelecimento listarEstabelecimentoDaLista(Lista entidade) throws ClassNotFoundException, SQLException {
		ControladorEstabelecimento controladorEstabelecimento = new ControladorEstabelecimento();
		RelacionamentoClienteListaEstababelecimento relacao = null;
		Estabelecimento estabelecimento = new Estabelecimento();
		
		for(RelacionamentoClienteListaEstababelecimento r : this.listarRelacionamentoClienteListaEstababelecimento()){
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
