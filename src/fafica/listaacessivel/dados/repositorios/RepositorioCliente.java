package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fafica.listaacessivel.dados.IRepositorioCliente;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.util.ConnectionMysql;
import fafica.listaacessivel.negocios.util.StatusLista;

public class RepositorioCliente implements IRepositorioCliente {
	private static RepositorioCliente instancia ;
	private PreparedStatement smt;
	private Connection connection;
	private ResultSet result;
	private String sql;
	
	private RepositorioCliente() throws ClassNotFoundException, SQLException{
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioCliente getInstancia() throws ClassNotFoundException, SQLException{
		if(instancia==null){
			synchronized (RepositorioCliente.class) {
				if(instancia == null){
					instancia = new RepositorioCliente();
				}
			}
		}
		
		return instancia;
	}
	@Override
	public int adicionarCliente(Cliente cliente) throws SQLException {
		int id_auto_increment = 0; //Variavel para recuperar ID auto increment de Usuario
		
		//Inserindo na tabela de Usuario
		sql = "insert into usuario (email, senha, nome, status) values"
				+ "(?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		smt.setString(1, cliente.getEmail());
		smt.setString(2, cliente.getSenha());
		smt.setString(3, cliente.getNome());
		smt.setString(4, StatusLista.ATIVO.toString());
		smt.execute();
		
		result = smt.getGeneratedKeys();
		if(result.next()){
			id_auto_increment = result.getInt(1);
		}
		result.close();
		smt.close();
		
		//Inserindo na tabela de Cliente
		sql = "insert into cliente (id_cliente, cpf, ano_nascimento, rua,"
				+ " numero, complemento, bairro, cidade, estado, cep, referencia)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1, id_auto_increment);
		smt.setString(2, cliente.getCpf());
		smt.setString(3, cliente.getAno_nascimento());
		smt.setString(4, cliente.getEndereco().getRua());
		smt.setString(5, cliente.getEndereco().getNumero());
		smt.setString(6, cliente.getEndereco().getComplemento());
		smt.setString(7, cliente.getEndereco().getBairro());
		smt.setString(8, cliente.getEndereco().getCidade());
		smt.setString(9, cliente.getEndereco().getEstado());
		smt.setString(10, cliente.getEndereco().getCep());
		smt.setString(11, cliente.getEndereco().getReferencia());
		smt.execute();
		smt.close();
		
		//Inserindo os Telefones do cliente
		for(String telefone : cliente.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_cliente"
		 			+" (id_cliente, telefone) values (?,?)");
		 			smt.setInt(1, id_auto_increment);
				 	smt.setString(2, telefone);
				 	smt.execute();
				 	smt.close();
		}
		
		System.out.println("CADASTRA CLIENTE OK");
		return id_auto_increment;
	}

	@Override
	public void alterarCliente(Cliente cliente) throws SQLException {
		
		//ALTERANDO NA TABELA DE USUARIO 
		sql = "update usuario set"
				+ " email = '" +cliente.getEmail()+ "'"
				+ ", senha = '" +cliente.getSenha()+ "'"
				+ ", nome = '" +cliente.getNome()+ "'"
				+ " where id_usuario = " +cliente.getId_usuario()+ " and status = '" +StatusLista.ATIVO.toString()+ "'";
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//ALTERANDO NA TABELA DE CLINTE
		sql = "update cliente set"
				+ " cpf = '" +cliente.getCpf()+ "'"
				+ ", ano_nascimento = '" +cliente.getAno_nascimento()+ "'"
				+ ", rua = '" +cliente.getEndereco().getRua()+ "'"
				+ ", numero = '" +cliente.getEndereco().getNumero()+ "'"
				+ ", complemento = '" +cliente.getEndereco().getComplemento()+ "'"
				+ ", bairro = '" +cliente.getEndereco().getBairro()+ "'"
				+ ", cidade = '" +cliente.getEndereco().getCidade()+ "'"
				+ ", estado = '" +cliente.getEndereco().getEstado()+ "'"
				+ ", cep = '" +cliente.getEndereco().getCep()+ "'"
				+ ", referencia = '" +cliente.getEndereco().getReferencia()+ "'"
				+ " where id_cliente = " +cliente.getId_usuario();
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//EXCLUINDO TELEFONES ANTERIORES
		sql = "delete from telefone_cliente where id_cliente = "+cliente.getId_usuario();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//INSERINDO NOVOS TELEFONES
		for(String telefone : cliente.getTelefones()){
		 	smt = this.connection.prepareStatement("insert into telefone_cliente"
			 	+" (id_cliente, telefone) values (?,?)");
			 	smt.setInt(1,cliente.getId_usuario());
			 	smt.setString(2, telefone);
				smt.execute();
				smt.close();
		}
		
		System.out.println("ALTETANDO CLIENTE OK"); //LINHA TEMPORARIA
	}

	@Override
	public void excluirCliente(Cliente entidade) throws SQLException {
		sql = "UPDATE usuario SET status ='" + StatusLista.INATIVO.toString() + "' where id_usuario = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUINDO CLIENTE (VIA STATUS) OK");
	}

	@Override
	public List<Cliente> listarClientes() throws SQLException  {
		
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + StatusLista.ATIVO.toString() + "'"
				+ " AND u.id_usuario = c.id_cliente";
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			
			List <Cliente> clientes = null;
			while(result.next()){
				if(clientes == null){
					clientes = new ArrayList<Cliente>();
				}
				
				int id_cliente = result.getInt("c.id_cliente");
				String nome = result.getString("u.nome");
				String cpf = result.getString("c.cpf");
				String ano_nascimento = result.getString("c.ano_nascimento");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String rua = result.getString("c.rua");
				String numero = result.getString("c.numero");
				String complemento = result.getString("c.complemento");
				String bairro = result.getString("c.bairro");
				String cidade = result.getString("c.cidade");
				String estado = result.getString("c.estado");
				String cep = result.getString("c.cep");
				String referencia = result.getString("c.referencia");
				
				Endereco endereco = new Endereco(rua,bairro,numero,complemento,referencia,cidade,estado,cep);
				Cliente cliente = new Cliente(id_cliente,nome,cpf,email,senha,ano_nascimento,endereco,null);
				clientes.add(cliente);
			}
			result.close();
			smt.close();
			
			if(clientes != null){
				for (Cliente u : clientes){
					smt = this.connection.prepareStatement("select * from telefone_cliente where id_cliente = " + u.getId_usuario());
					result = smt.executeQuery();
					ArrayList<String> telefones = null;
						while (result.next()){
							if(telefones == null){
								telefones = new ArrayList<String>();
							}
							telefones.add(result.getString("telefone"));
						}
						result.close();
						smt.close();
					u.setTelefones(telefones);
				}
			}
		System.out.println("LISTAR CLIENTE OK"); //LINHA TEMPORARIA
		return clientes;
	}

	@Override
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException {
		if(entidade.getId_usuario() > 0){
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + StatusLista.ATIVO.toString() + "'"
					+ " AND u.id_usuario = "+entidade.getId_usuario()
					+ " AND c.id_cliente = "+entidade.getId_usuario();
		}else{
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + StatusLista.ATIVO.toString() + "'"
					+ " AND u.id_usuario = (select id_cliente from cliente where cpf = '"+entidade.getCpf()+"')"
					+ " AND c.cpf = '"+entidade.getCpf()+"'";
		}
			
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Cliente cliente = null;
			
			if (result.next()){
				int id_cliente = result.getInt("c.id_cliente");
				String nome = result.getString("u.nome");
				String cpf = result.getString("c.cpf");
				String ano_nascimento = result.getString("c.ano_nascimento");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String rua = result.getString("c.rua");
				String numero = result.getString("c.numero");
				String complemento = result.getString("c.complemento");
				String bairro = result.getString("c.bairro");
				String cidade = result.getString("c.cidade");
				String estado = result.getString("c.estado");
				String cep = result.getString("c.cep");
				String referencia = result.getString("c.referencia");
				Endereco endereco = new Endereco(rua,bairro,numero,complemento,referencia,cidade,estado,cep);
				cliente = new Cliente(id_cliente,nome,cpf,email,senha,ano_nascimento,endereco,null);
			}
						
			result.close();
			smt.close();
				
			if(cliente != null){
				sql = "select * from telefone_cliente where id_cliente = " + cliente.getId_usuario();
				smt = this.connection.prepareStatement(sql);
				result = smt.executeQuery();
				
				ArrayList<String> telefones = null;
					while (result.next()){
						if(telefones == null){
							telefones = new ArrayList<String>();
						}
						telefones.add(result.getString("telefone"));
					}
					cliente.setTelefones(telefones);
					result.close();
					smt.close();
			}
			
			System.out.println("PESQUISAR CLIENTE OK"); //LINHA TEMPORARIA
		return cliente;
	}

}
