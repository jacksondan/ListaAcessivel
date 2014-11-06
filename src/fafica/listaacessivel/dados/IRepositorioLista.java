package fafica.listaacessivel.dados;

import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;

public interface IRepositorioLista {
	public void adicionarLista(Lista lista);
	public void alterarLista(Lista lista);
	public void excluirLista(Lista lista);
	public List<Lista> listarListas();
	public Lista pesquisarLista(Lista lista);
	public List<Lista> listarListasDoCliente(Cliente cliente);
	public List<Lista> listarListasDoEstabelecimento(Estabelecimento estabelecimento);
}
