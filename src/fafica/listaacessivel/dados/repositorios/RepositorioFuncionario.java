package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		sql = "insert into usuario (nome,email,senha,status) values"
				+ "(?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setString(1,funcionario.getNome());
		smt.setString(2,funcionario.getEmail());
		smt.setString(3,funcionario.getSenha());
		smt.setString(4,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		sql = "insert into funcionario (id_funcionario, matricula, id_estabelecimento) values"
				+ "(?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1,funcionario.getId_usuario());
		smt.setString(2,funcionario.getMatricula());
		smt.setInt(3,funcionario.getEstabelecimento().getId_estabelecimento());
		smt.execute();
		smt.close();
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) throws SQLException {
		sql = "UPDATE usuario SET"
				+ "nome = '" + funcionario.getNome() + "'"
				+ ", email = '"+ funcionario.getEmail()+"'"
				+ ", senha = '"+ funcionario.getSenha()+"'"
				+ " where id_usuario = "+ funcionario.getId_usuario() + " AND " + " status = " + Status.ATIVO.toString();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "UPDATE funcionario SET"
				+ " nome_cliente = '" + funcionario.getNome() + "'"
				+ ", matricula = '" + funcionario.getMatricula() + "'"
				+ ", id_estabelecimento = '" + funcionario.getEstabelecimento().getId_estabelecimento() + "'"
				+ " where id_cliente = " + funcionario.getId_usuario()  + " AND " + " status = " + Status.ATIVO.toString();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
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
			List <Funcionario> funcionarios = new ArrayList<Funcionario>();
			Estabelecimento estabelecimento = new Estabelecimento();
			while(result.next()){
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("f.nome_funcionario");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
				estabelecimento.setId_estabelecimento(result.getInt("f.id_estabelecimento"));
								
				Funcionario funcionario2 = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento);
				funcionarios.add(funcionario2);
			}
			result.close();
			smt.close();
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
		
			Estabelecimento estabelecimento = new Estabelecimento();
			Funcionario funcionario2 = new Funcionario();
			
			while (result.next()){
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("f.nome_funcionario");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
				estabelecimento.setId_estabelecimento(result.getInt("f.id_estabelecimento"));
				funcionario2 = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento);				
			}
			
						
			result.close();
			smt.close();
			
			System.out.println("PESQUISAR FUNCIONARIO OK"); //LINHA TEMPORARIA
		return funcionario2;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorEstabelecimento(
			Estabelecimento estabelecimento) throws SQLException{
		sql = "select u.*,f.* from usuario u, funcionario f where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND u.id_usuario = f.id_funcionario AND id_estabelecimento = " + estabelecimento.getId_estabelecimento();
			
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			List <Funcionario> funcionarios = new ArrayList<Funcionario>();
			Estabelecimento estabelecimento2 = new Estabelecimento();
			while(result.next()){
				int id_funcionario = result.getInt("f.id_funcionario");
				String nome = result.getString("f.nome_funcionario");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String matricula = result.getString("f.matricula");
				estabelecimento2.setId_estabelecimento(result.getInt("f.id_estabelecimento"));
								
				Funcionario funcionario2 = new Funcionario(id_funcionario,nome,email,senha,matricula,estabelecimento2);
				funcionarios.add(funcionario2);
			}
			result.close();
			smt.close();
		return funcionarios;
	}

}
