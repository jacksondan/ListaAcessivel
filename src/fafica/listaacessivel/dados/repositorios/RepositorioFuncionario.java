package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fafica.listaacessivel.dados.IRepositorioFuncionario;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	
	private static RepositorioFuncionario instancia;
	private Connection connection;
	private PreparedStatement smt;
	private ResultSet result;
	private String sql;
	
	
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
	public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
		int id_auto_increment = 0; //Variavel para recuperar ID auto increment de Usuario
		
		sql = "insert into usuario (nome,email,senha,status)"
				+ " values (?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		smt.setString(1,funcionario.getNome());
		smt.setString(2,funcionario.getEmail());
		smt.setString(3,funcionario.getSenha());
		smt.setString(4,Status.ATIVO.toString());
		smt.execute();

		result = smt.getGeneratedKeys();
		if(result.next()){
			id_auto_increment = result.getInt(1);
		}
		result.close();
		smt.close();
		
		sql = "insert into funcionario (id_funcionario, matricula, id_estabelecimento)"
				+ " values (?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1, id_auto_increment);
		smt.setString(2,funcionario.getMatricula());
		smt.setInt(3,funcionario.getEstabelecimento().getId_estabelecimento());
		smt.execute();
		smt.close();
		
		System.out.println("ADICIONAR FUNCIONARIO OK");
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) throws SQLException {
		sql = "UPDATE usuario SET"
				+ " nome = '" + funcionario.getNome() + "'"
				+ ", email = '"+ funcionario.getEmail()+"'"
				+ ", senha = '"+ funcionario.getSenha()+"'"
				+ " where id_usuario = "+ funcionario.getId_usuario() + " AND status = '" +Status.ATIVO.toString()+ "'";
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "UPDATE funcionario SET"
				+ " matricula = '" + funcionario.getMatricula() + "'"
				+ " where id_funcionario = " + funcionario.getId_usuario();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("ALTERAR FUNCIONARIO OK");
	}

	@Override
	public void excluirFuncionario(Funcionario funcionario) throws SQLException {
		sql = "UPDATE usuario SET status ='" + Status.INATIVO.toString() + "' where id_usuario = "+ funcionario.getId_usuario();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
	}

	@Override
	public List<Funcionario> listarFuncionarios() throws SQLException {
		sql = "select u.*,f.* from usuario u, funcionario f where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND u.id_usuario = f.id_funcionario";
			
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			List <Funcionario> funcionarios = null;
			Estabelecimento estabelecimento = null;
			while(result.next()){
				if(funcionarios == null){
					funcionarios = new ArrayList<Funcionario>();
				}
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("u.nome");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
				estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(result.getInt("f.id_estabelecimento"));
								
				Funcionario funcionario = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento);
				funcionarios.add(funcionario);
			}
			result.close();
			smt.close();
			System.out.println("LISTAR FUNCIONARIOS OK");
		return funcionarios;
	}

	@Override
	public Funcionario pesquisarFuncionario(Funcionario funcionario) throws SQLException{
		if(funcionario.getId_usuario() > 0){
			sql = "select u.*,f.* from usuario u, funcionario f where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = "+ funcionario.getId_usuario()
					+ " AND f.id_funcionario = "+ funcionario.getId_usuario();
		}else{
			sql = "select u.*,f.* from usuario u, funcionario f where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = (select id_funcionario from funcionario where matricula = '" + funcionario.getMatricula() +"')"
					+ " AND f.matricula = '" + funcionario.getMatricula()+"'";
		}
			
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Funcionario funcionarioRetorno = null;
			
			if (result.next()){
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("u.nome");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(result.getInt("f.id_estabelecimento"));
				funcionarioRetorno = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento);				
			}
			
						
			result.close();
			smt.close();
			
			System.out.println("PESQUISAR FUNCIONARIO OK"); //LINHA TEMPORARIA
		return funcionarioRetorno;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException{
		sql = "select u.*,f.* from usuario u, funcionario f where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND f.id_estabelecimento = " + estabelecimento.getId_estabelecimento() + " AND u.id_usuario = f.id_funcionario";
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			
			List <Funcionario> funcionarios = null;
			while(result.next()){
				if(funcionarios == null){
					funcionarios = new ArrayList<Funcionario>();
				}
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("u.nome");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
								
				Funcionario funcionario = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento);
				funcionarios.add(funcionario);
			}
			result.close();
			smt.close();
			System.out.println("LISTAR FUNCIONARIO POR ESTABELECIMENTO OK");
		return funcionarios;
	}

}
