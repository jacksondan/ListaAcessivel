package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public interface IRepositorioEstabelecimento {
	public int adicionarEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
	public void alterarEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
	public void excluirEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
	public List<Estabelecimento> listarEstabelecimentos() throws SQLException;
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento estabelecimento) throws SQLException;
	public List<Estabelecimento> listarEstabelecimentoPorRegiao(String categoria, Cliente cliente, boolean pesquisarPorBairro) throws SQLException;
}
