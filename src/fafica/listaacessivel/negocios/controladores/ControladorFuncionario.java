package fafica.listaacessivel.negocios.controladores;

import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioFuncionario;
import fafica.listaacessivel.dados.repositorios.RepositorioFuncionario;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

public class ControladorFuncionario {
	
	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() throws ClassNotFoundException, SQLException {
		this.repositorioFuncionario = RepositorioFuncionario.getInstancia();
	}
	
	public int adicionarFuncionario(Funcionario funcionario) throws SQLException{
		String senhaEncriptada = CriptografiaSenha.encriptar(funcionario.getSenha());
		funcionario.setSenha(senhaEncriptada);
		return repositorioFuncionario.adicionarFuncionario(funcionario);
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

	public Funcionario pesquisarFuncionario(Funcionario funcionario) throws SQLException{
		return repositorioFuncionario.pesquisarFuncionario(funcionario);
	}

	public List <Funcionario> listarFuncionarioPorEstabelecimento(Estabelecimento estabelecimento) throws SQLException{
		return repositorioFuncionario.listarFuncionariosPorEstabelecimento(estabelecimento);
	}

}
