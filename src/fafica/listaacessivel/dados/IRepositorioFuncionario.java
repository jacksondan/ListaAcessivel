package fafica.listaacessivel.dados;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

public interface IRepositorioFuncionario {
	public void adicionarFuncionario(Funcionario funcionario) throws SQLException;
	public void alterarFuncionario(Funcionario funcionario) throws SQLException;
	public void excluirFuncionario(Funcionario funcionario) throws SQLException;
	public List<Funcionario> listarFuncionarios() throws SQLException;
	public Funcionario pesquisarFuncionario(Funcionario funcionario) throws SQLException;
	public List<Funcionario> listarFuncionariosPorEstabelecimento(Estabelecimento estabelecimento) throws SQLException;

}
