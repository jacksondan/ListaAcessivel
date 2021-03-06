package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioLista;
import fafica.listaacessivel.dados.repositorios.RepositorioLista;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.negocios.util.EmailJava;
import fafica.listaacessivel.negocios.util.SituacaoLista;


public class ControladorLista {
	
	private IRepositorioLista repositorioLista;
	private SimpleDateFormat dmy = new SimpleDateFormat("d/M/y");
	
	public ControladorLista() throws ClassNotFoundException, SQLException {
		this.repositorioLista = RepositorioLista.getInstancia();
	}

	public int adicionarLista(Lista entidade) throws SQLException {
		String data_criacao = dmy.format(new Date());
		entidade.setData_criacao(data_criacao);
		entidade = calcularValoresTotal(entidade);
		return this.repositorioLista.adicionarLista(entidade);
		
	}

	public void alterarLista(Lista entidade) throws SQLException {
		String data_alteracao = dmy.format(new Date());
		entidade.setData_alteracao(data_alteracao);
		entidade = calcularValoresTotal(entidade);
		
		Lista listaPesquisa = repositorioLista.pesquisarLista(entidade);
		
		if(entidade.getSituacao().equals(SituacaoLista.SOLICITADA.toString())){
			if(!listaPesquisa.getSituacao().equals(SituacaoLista.SOLICITADA.toString())){
				EmailJava email = new EmailJava();
				email.listaSolicitada(entidade);
			}
		}
		if(entidade.getSituacao().equals(SituacaoLista.EMATENDIMENTO.toString())){
			if(!listaPesquisa.getSituacao().equals(SituacaoLista.EMATENDIMENTO.toString())){
				EmailJava email = new EmailJava();
				email.listaEmAtendimento(entidade);
			}
		}
		
		if(entidade.getSituacao().equals(SituacaoLista.EMTRANSITO.toString())){
			if(!listaPesquisa.getSituacao().equals(SituacaoLista.EMTRANSITO.toString())){
				EmailJava email = new EmailJava();
				email.listaEmTransito(entidade);
			}
		}
		if(entidade.getSituacao().equals(SituacaoLista.ATENDIDA.toString())){
			if(!listaPesquisa.getSituacao().equals(SituacaoLista.ATENDIDA.toString())){
				EmailJava email = new EmailJava();
				email.listaAtendida(entidade);
			}
		}
		
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
	
	private Lista calcularValoresTotal(Lista lista){
		int quantidade_total = 0;
		float valor_total = 0.0f;
		
		for(Produto produto : lista.getProdutos()){
			quantidade_total += produto.getQuantidade();
			valor_total += (produto.getQuantidade() * produto.getValor());
		}
		
		lista.setQuantidade_total(quantidade_total);
		lista.setValor_total(valor_total);
		
		return lista;
	}
}
