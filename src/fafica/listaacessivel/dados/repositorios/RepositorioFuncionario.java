package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioFuncionario;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	
	private static RepositorioFuncionario instancia;
	private Connection connection;
	
	private RepositorioFuncionario() throws ClassNotFoundException, SQLException {
		connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioFuncionario getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia==null){
			synchronized (RepositorioFuncionario.class) {
				if(instancia == null){
					instancia = new RepositorioFuncionario();
				}
			}
		}
		return instancia;
	}
	
	@Override
	public void adicionarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pesquisarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionario> listarFuncionariosDoEstabelecimento(
			Estabelecimento estabelecimento) {
		// TODO Auto-generated method stub
		return null;
	}

}
