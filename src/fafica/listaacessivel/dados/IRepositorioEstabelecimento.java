package fafica.listaacessivel.dados;

import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public interface IRepositorioEstabelecimento {
	public void adicionarEstabelecimento(Estabelecimento estabelecimento);
	public void alterarEstabelecimento(Estabelecimento estabelecimento);
	public void excluirEstabelecimento(Estabelecimento estabelecimento);
	public List<Estabelecimento> listarEstabelecimentos();
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento estabelecimento);
}
