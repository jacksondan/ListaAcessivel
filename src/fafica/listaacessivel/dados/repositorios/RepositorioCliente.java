package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioCliente;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Endereco;

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
	public void adicionarCliente(Cliente entidade) throws SQLException {
		
		sql = "insert into usuario (email,senha,rua,numero,complemento,bairro,cidade,estado,cep,referencia,status) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setString(1,entidade.getEmail());
		smt.setString(2,entidade.getSenha());
		smt.setString(3,entidade.getEndereco().getRua());
		smt.setString(4,entidade.getEndereco().getNumero());
		smt.setString(5,entidade.getEndereco().getComplemento());
		smt.setString(6,entidade.getEndereco().getBairro());
		smt.setString(7,entidade.getEndereco().getCidade());
		smt.setString(8,entidade.getEndereco().getEstado());
		smt.setString(9,entidade.getEndereco().getCep());
		smt.setString(10,entidade.getEndereco().getReferencia());
		smt.setString(11,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		//Coladando o ID_USUARIO que � gerado pelo BD
		Cliente cliente = new Cliente(null,null,null,null,null,null,null);
		sql = "select id_usuario from usuario where email = '"+entidade.getEmail()+"'";
		smt = this.connection.prepareStatement(sql);
		result = smt.executeQuery();
			while (result.next()){
				cliente.setId_usuario(result.getInt("id_usuario"));
			}
			result.close();
			smt.close();
		
		
			//Inserindo os dados da tabela Cliente, juntamente com o ID coletado
		sql = "insert into cliente (id_cliente, nome_cliente, cpf, ano_nascimento) values"
				+ "(?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1,cliente.getId_usuario());
		smt.setString(2,entidade.getNome());
		smt.setString(3,entidade.getCpf());
		smt.setString(4,entidade.getAno_nascimento());
		smt.execute();
		smt.close();
		
		//Inserindo os Telefones
		for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_usuario"
		 			+"(id_usuario,telefone) values (?,?)");
		 			smt.setInt(1,cliente.getId_usuario());
				 	smt.setString(2,tel);
				 	smt.execute();
				 	smt.close();
		}
		
		System.out.println("CADASTRA CLIENTE OK");
	}

	@Override
	public void alterarCliente(Cliente entidade) throws SQLException {
		sql = "UPDATE usuario SET"
				+ " email = '"+entidade.getEmail()+"'"
				+ ", senha = '"+entidade.getSenha()+"'"
				+ ", rua = '"+entidade.getEndereco().getRua()+"'"
				+ ", numero = '"+entidade.getEndereco().getNumero()+"'"
				+ ", complemento = '"+entidade.getEndereco().getComplemento()+"'"
				+ ", bairro = '"+entidade.getEndereco().getBairro()+"'"
				+ ", cidade = '"+entidade.getEndereco().getCidade()+"'"
				+ ", estado = '"+entidade.getEndereco().getEstado()+"'"
				+ ", cep = '"+entidade.getEndereco().getCep()+"'"
				+ ", referencia = '"+entidade.getEndereco().getReferencia()+"'"
				+ " where id_usuario = "+entidade.getId_usuario();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "UPDATE cliente SET"
				+ " nome_cliente = '" + entidade.getNome() + "'"
				+ ", cpf = '" + entidade.getCpf() + "'"
				+ ", ano_nascimento = '" + entidade.getAno_nascimento()+ "'"
				+ " where id_cliente = " + entidade.getId_usuario();
		
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
		
		System.out.println("ALTETANDO CLIENTE OK"); //LINHA TEMPORARIA
	}

	@Override
	public void excluirCliente(Cliente entidade) throws SQLException {
		sql = "UPDATE usuario SET status ='" + Status.INATIVO.toString() + "' where id_usuario = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUINDO CLIENTE (VIA STATUS) OK"); //LINHA TEMPORARIA
	}

	@Override
	public List<Cliente> listarClientes() throws SQLException  {
		
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND u.id_usuario = c.id_cliente";
			
			smt = this.connection.prepareStatement(sql);
			result= smt.executeQuery();
			List <Cliente> clientes = new ArrayList<Cliente>();
			while(result.next()){
				int id_cliente = result.getInt("c.id_cliente");
				String nome = result.getString("c.nome_cliente");
				String cpf = result.getString("c.cpf");
				String ano_nascimento = result.getString("c.ano_nascimento");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String rua = result.getString("u.rua");
				String numero = result.getString("u.numero");
				String complemento = result.getString("u.complemento");
				String bairro = result.getString("u.bairro");
				String cidade = result.getString("u.cidade");
				String estado = result.getString("u.estado");
				String cep = result.getString("u.cep");
				String referencia = result.getString("u.referencia");
				
				Endereco endereco = new Endereco(rua,bairro,numero,complemento,referencia,cidade,estado,cep);
				Cliente cliente = new Cliente(id_cliente,nome,cpf,email,senha,ano_nascimento,endereco,null);
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
		System.out.println("LISTAR CLIENTE OK"); //LINHA TEMPORARIA
		return clientes;
	}

	@Override
	public Cliente pesquisarCliente(Cliente entidade) throws SQLException {
		if(entidade.getId_usuario() > 0){
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = "+entidade.getId_usuario()
					+ " AND c.id_cliente = "+entidade.getId_usuario();
		}else{
			sql = "select u.*,c.* from usuario u, cliente c where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = (select id_cliente from cliente where cpf = '"+entidade.getCpf()+"')"
					+ " AND c.cpf = '"+entidade.getCpf()+"'";
		}
			
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Cliente cliente = new Cliente();
			
			while (result.next()){
				int id_cliente = result.getInt("c.id_cliente");
				String nome = result.getString("c.nome_cliente");
				String cpf = result.getString("c.cpf");
				String ano_nascimento = result.getString("c.ano_nascimento");
				String email = result.getString("u.email");
				String senha = result.getString("u.senha");
				String rua = result.getString("u.rua");
				String numero = result.getString("u.numero");
				String complemento = result.getString("u.complemento");
				String bairro = result.getString("u.bairro");
				String cidade = result.getString("u.cidade");
				String estado = result.getString("u.estado");
				String cep = result.getString("u.cep");
				String referencia = result.getString("u.referencia");
				Endereco endereco = new Endereco(rua,bairro,numero,complemento,referencia,cidade,estado,cep);
				cliente = new Cliente(id_cliente,nome,cpf,email,senha,ano_nascimento,endereco,null);
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
				cliente.setTelefones(tel);
				result.close();
				smt.close();

			
			System.out.println("PESQUISAR CLIENTE OK"); //LINHA TEMPORARIA
		return cliente;
	}

}
