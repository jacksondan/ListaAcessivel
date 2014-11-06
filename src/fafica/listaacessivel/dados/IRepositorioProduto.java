package fafica.listaacessivel.dados;

import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

public interface IRepositorioProduto {
	public void adicionarProduto(Produto produto);
	public void alterarProduto(Produto produto);
	public void excluirProduto(Produto produto);
	public List<Produto> listarProdutos();
	public Produto pesquisarProduto(Produto produto);
	public List<Produto> listarProdutosDoEstabelecimento(Estabelecimento estabelecimento);
	public List<Produto> listarProdutos(Lista lista);
}
