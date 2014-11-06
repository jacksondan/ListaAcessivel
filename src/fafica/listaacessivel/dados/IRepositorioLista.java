package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;

public interface IRepositorioLista {
	public void adicionarLista(Lista lista) throws SQLException;
	public void alterarLista(Lista lista) throws SQLException;
	public void excluirLista(Lista lista) throws SQLException;
	public List<Lista> listarListas() throws SQLException;
	public Lista pesquisarLista(Lista lista) throws SQLException;
	public List<Lista> listarListasDoCliente(Cliente cliente) throws SQLException;
	public List<Lista> listarListasDoEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
}