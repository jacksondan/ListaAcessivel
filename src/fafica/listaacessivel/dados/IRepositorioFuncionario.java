package fafica.listaacessivel.dados;

import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

public interface IRepositorioFuncionario {
	public void adicionarFuncionario(Funcionario funcionario);
	public void alterarFuncionario(Funcionario funcionario);
	public void excluirFuncionario(Funcionario funcionario);
	public List<Funcionario> listarFuncionarios();
	public void pesquisarFuncionario(Funcionario funcionario);
	public List<Funcionario> listarFuncionariosDoEstabelecimento(Estabelecimento estabelecimento);

}
