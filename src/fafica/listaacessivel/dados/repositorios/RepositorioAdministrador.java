package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fafica.listaacessivel.dados.IRepositorioAdministrador;
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.util.ConnectionMysql;
import fafica.listaacessivel.negocios.util.StatusLista;

public class RepositorioAdministrador implements IRepositorioAdministrador {

	private static RepositorioAdministrador instancia ;
	private PreparedStatement smt;
	private Connection connection;
	private ResultSet result;
	private String sql;
	
	private RepositorioAdministrador() throws ClassNotFoundException, SQLException{
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioAdministrador getInstancia() throws ClassNotFoundException, SQLException{
		if(instancia==null){
			synchronized (RepositorioAdministrador.class) {
				if(instancia == null){
					instancia = new RepositorioAdministrador();
				}
			}
		}
		return instancia;
	}
		
	@Override
	public int adicionarAdministrador(Administrador administrador)
			throws SQLException {
		int id_auto_increment = 0;
		
		sql = "insert into usuario (email, senha, nome, status) values"
				+ "(?,?,?,?)";
		smt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		smt.setString(1, administrador.getEmail());
		smt.setString(2, administrador.getSenha());
		smt.setString(3, administrador.getNome());
		smt.setString(4, StatusLista.ATIVO.toString());
		smt.execute();
		
		result = smt.getGeneratedKeys();
		if(result.next()){
			id_auto_increment = result.getInt(1);
		}
		result.close();
		smt.close();
		
		sql = "insert into administrador (id_administrador, cpf)"
				+ " values (?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1, id_auto_increment);
		smt.setString(2, administrador.getCpf());
		smt.execute();
		smt.close();

		System.out.println("CADASTRO ADMINISTRADOR OK");
		
		return id_auto_increment;
	}

	@Override
	public void alterarAdministrador(Administrador administrador)
			throws SQLException {
		sql = "update usuario set"
				+ " email = '" + administrador.getEmail()+ "'"
				+ ", senha = '" + administrador.getSenha()+ "'"
				+ ", nome = '" + administrador.getNome()+ "'"
				+ " where id_usuario = " + administrador.getId_usuario()+ " and status = '" +StatusLista.ATIVO.toString()+ "'";
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "update administrador set"
				+ " cpf = '" + administrador.getCpf()+ "'"
				+ " where id_administrador = " + administrador.getId_usuario();
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();

		System.out.println("ALTERAÇÃO DE ADMINISTRADOR OK");
	}

	@Override
	public void excluirAdministrador(Administrador administrador)
			throws SQLException {
		sql = "UPDATE usuario SET status ='" + StatusLista.INATIVO.toString() + "' where id_usuario = " + administrador.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUINDO ADMINISTRADOR (VIA STATUS) OK");

	}

	@Override
	public List<Administrador> listarAdministradores() throws SQLException {
		
		sql = "select u.*,a.* from usuario u, administrador a where u.status = '" + StatusLista.ATIVO.toString() + "'"
				+ " AND u.id_usuario = a.id_administrador";
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			
			List <Administrador> administradores = null;
			while(result.next()){
				if(administradores == null){
					administradores = new ArrayList<Administrador>();
				}
				
				int id_administrador = result.getInt("a.id_administrador");
				String nome = result.getString("u.nome");
				String cpf = result.getString("a.cpf");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				Administrador administrador = new Administrador(id_administrador, nome, email, cpf, senha);
				administradores.add(administrador);
			}
			result.close();
			smt.close();
			
		System.out.println("LISTAR ADMINISTRADORES OK"); 
		return administradores;
	}

	@Override
	public Administrador pesquisarAdministrador(Administrador administrador)
			throws SQLException {
		if(administrador.getId_usuario() > 0){
			sql = "select u.*,a.* from usuario u, administrador a where u.status = '" + StatusLista.ATIVO.toString() + "'"
					+ " AND u.id_usuario = " + administrador.getId_usuario()
					+ " AND a.id_administrador = " + administrador.getId_usuario();
		}else{
			sql = "select u.*,a.* from usuario u, administrador a where u.status = '" + StatusLista.ATIVO.toString() + "'"
					+ " AND u.id_usuario = (select id_administrador from administrador where cpf = '"+ administrador.getCpf()+"')"
					+ " AND a.cpf = '" + administrador.getCpf()+"'";
		}
			
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Administrador pesquisa = null;
			
			if (result.next()){
				int id_administrador = result.getInt("a.id_administrador");
				String nome = result.getString("u.nome");
				String cpf = result.getString("a.cpf");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				pesquisa = new Administrador(id_administrador, nome, email, cpf, senha);
			}
						
			result.close();
			smt.close();
							
			System.out.println("PESQUISAR ADMINISTRADOR OK");
		return pesquisa;
	}

}
