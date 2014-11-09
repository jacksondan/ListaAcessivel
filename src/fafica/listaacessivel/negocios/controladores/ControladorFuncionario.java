package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioFuncionario;
import fafica.listaacessivel.dados.repositorios.RepositorioFuncionario;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

public class ControladorFuncionario {
	
	IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() throws ClassNotFoundException, SQLException {
		this.repositorioFuncionario = RepositorioFuncionario.getInstancia();
	}
	
	public void adicionarFuncionario(Funcionario funcionario) throws SQLException{
		repositorioFuncionario.adicionarFuncionario(funcionario);
	}
	
	public void alterarFuncionario(Funcionario funcionario) throws SQLException{
		repositorioFuncionario.alterarFuncionario(funcionario);
	}
	
	public void excluirFuncionario(Funcionario funcionario) throws SQLException{
		repositorioFuncionario.excluirFuncionario(funcionario);
	}
	
	public List <Funcionario> listarFuncionario() throws SQLException{
		
		return repositorioFuncionario.listarFuncionarios();
	}

	public List <Funcionario> listarFuncionarioDoEstabelecimento(Estabelecimento estabelecimento) throws SQLException{
		return repositorioFuncionario.listarFuncionariosDoEstabelecimento(estabelecimento);
	}
	
	public Funcionario pesquisarFuncionario(Funcionario funcionario) throws SQLException{
		return repositorioFuncionario.pesquisarFuncionario(funcionario);
	}
}
