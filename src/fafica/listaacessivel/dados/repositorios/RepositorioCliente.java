package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorio;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Cliente;

public class RepositorioCliente implements IRepositorio<Cliente> {
	private static RepositorioCliente instancia;
	private PreparedStatement smt;
	private Connection connection;
	private ResultSet result;
	private String sql;
	
	private RepositorioCliente() throws ClassNotFoundException, SQLException{
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioCliente getInstancia() throws ClassNotFoundException, SQLException{
		if(instancia==null)	instancia = new RepositorioCliente();
		
		return instancia;
	}
	@Override
	public void adicionar(Cliente entidade) throws SQLException {
		
		sql = "insert into usuario (email,senha,rua,numero,bairro,cidade,estado,cep,referencia,status) values"
				+ "(?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setString(1,entidade.getEmail());
		smt.setString(2,entidade.getSenha());
		smt.setString(3,entidade.getRua());
		smt.setString(4,entidade.getNumero());
		smt.setString(5,entidade.getBairro());
		smt.setString(6,entidade.getCidade());
		smt.setString(7,entidade.getEstado());
		smt.setString(8,entidade.getCep());
		smt.setString(9,entidade.getReferencia());
		smt.setString(10,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		Cliente cliente = new Cliente();
		sql = "select id_usuario from usuario where email = '"+entidade.getEmail()+"'";
		smt = this.connection.prepareStatement(sql);
		result = smt.executeQuery();
			while (result.next()){
				cliente.setId_usuario(result.getInt("id_usuario"));
			}
			result.close();
			smt.close();
		
		
		sql = "insert into cliente (id_cliente, nome_cliente, cpf) values"
				+ "(?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1,cliente.getId_usuario());
		smt.setString(2,entidade.getNome());
		smt.setString(3,entidade.getCpf());
		smt.execute();
		smt.close();
		
		for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_usuario"
		 			+"(id_usuario,telefone) values (?,?)");
		 			smt.setInt(1,cliente.getId_usuario());
				 	smt.setString(2,tel);
				 	smt.execute();
				 	smt.close();
		}
		
		System.out.println("CADASTRA USUARIO OK");
		System.out.println(""); //LINHA TEMPORARIA
	}

	@Override
	public void alterar(Cliente entidade) throws SQLException {
		sql = "UPDATE usuario SET "
				+ "nome_usuario = '"+entidade.getNome()+"'"
				+ ", cpf = '"+entidade.getCpf()+"'"
				+ ", email = '"+entidade.getEmail()+"'"
				+ ", senha = '"+entidade.getSenha()+"'"
				+ ", rua = '"+entidade.getRua()+"'"
				+ ", numero = '"+entidade.getNumero()+"'"
				+ ", bairro = '"+entidade.getBairro()+"'"
				+ ", cidade = '"+entidade.getCidade()+"'"
				+ ", estado = '"+entidade.getEstado()+"'"
				+ ", cep = '"+entidade.getCep()+"'"
				+ ", referencia = '"+entidade.getReferencia()+"'"
				+ "where id_usuario = "+entidade.getId_usuario();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//Deletando os Telefones Anteriores
				sql = "delete from telefone_usuario where id_usuario = "+entidade.getId_usuario();
				smt = connection.prepareStatement(sql);
				smt.execute();
				smt.close();
		
			//Inserindo os novos telefones
			for(String tel : entidade.getTelefones()){	 	
			 	smt = this.connection.prepareStatement("insert into telefone_usuario"
			 			+"(id_usuario,telefone) values (?,?)");
			 			smt.setInt(1,entidade.getId_usuario());
			 			smt.setString(2, tel);
					 	smt.execute();
					 	smt.close();
			}
		
		System.out.println("ALTETANDO USUARIO OK"); //LINHA TEMPORARIA
	}

	@Override
	public void excluir(Cliente entidade) throws SQLException {
		sql = "UPDATE usuario SET status ='" + Status.INATIVO.toString() + "' where id_usuario = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUINDO USUARIO (VIA STATUS) OK"); //LINHA TEMPORARIA
	}

	@Override
	public List <Cliente> listar()throws SQLException  {
		
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND u.id_usuario = c.id_cliente";
			
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			List <Cliente> clientes = new ArrayList<Cliente>();
			while(result.next()){
				Cliente cliente= new Cliente();
				cliente.setId_usuario(result.getInt("c.id_cliente"));
				cliente.setNome(result.getString("c.nome_cliente"));
				cliente.setCpf(result.getString("c.cpf"));
				cliente.setEmail(result.getString("u.email"));
				cliente.setSenha(result.getString("u.senha"));
				cliente.setRua(result.getString("u.rua"));
				cliente.setNumero(result.getString("u.numero"));
				cliente.setBairro(result.getString("u.bairro"));
				cliente.setCidade(result.getString("u.cidade"));
				cliente.setEstado(result.getString("u.estado"));
				cliente.setCep(result.getString("u.cep"));
				cliente.setReferencia(result.getString("u.referencia"));
				clientes.add(cliente);
			}
			result.close();
			smt.close();
			
			for (Cliente u : clientes){
				smt = this.connection.prepareStatement("select * from telefone_usuario where id_usuario = " + u.getId_usuario());
				result = smt.executeQuery();
				ArrayList<String> tel = new ArrayList<String>();
					while (result.next()){
						tel.add(result.getString("telefone"));
					}
					result.close();
					smt.close();
				u.setTelefones(tel);
			}
		System.out.println("LISTAR USUARIO OK"); //LINHA TEMPORARIA
		return clientes;
	}

	@Override
	public Cliente pesquisar(Cliente entidade) throws SQLException {
		if(entidade.getId_usuario() > 0){
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = "+entidade.getId_usuario()
					+ " AND c.id_cliente = "+entidade.getId_usuario();
		}else{
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = '"+entidade.getCpf()+"'"
					+ " AND c.cpf = '"+entidade.getCpf()+"'";
		}
		
		
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Cliente cliente = new Cliente();
			while (result.next()){
				cliente.setId_usuario(result.getInt("c.id_cliente"));
				cliente.setNome(result.getString("c.nome_cliente"));
				cliente.setCpf(result.getString("c.cpf"));
				cliente.setEmail(result.getString("u.email"));
				cliente.setSenha(result.getString("u.senha"));
				cliente.setRua(result.getString("u.rua"));
				cliente.setNumero(result.getString("u.numero"));
				cliente.setBairro(result.getString("u.bairro"));
				cliente.setCidade(result.getString("u.cidade"));
				cliente.setEstado(result.getString("u.estado"));
				cliente.setCep(result.getString("u.cep"));
				cliente.setReferencia(result.getString("u.referencia"));
			}
			result.close();
			smt.close();
			
			sql = "select * from telefone_usuario where id_usuario = " + cliente.getId_usuario();
			
			smt = this.connection.prepareStatement(sql);
			result = smt.executeQuery();
			ArrayList<String> tel = new ArrayList<String>();
				while (result.next()){
					tel.add(result.getString("telefone"));
				}
				result.close();
				smt.close();
			cliente.setTelefones(tel);
			
			System.out.println("PESQUISAR USUARIO OK"); //LINHA TEMPORARIA
		return cliente;
	}
	
	private int getIdCliente(String cpd){
		return 0;
	}

}
