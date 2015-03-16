package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fafica.listaacessivel.dados.IRepositorioEstabelecimento;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public class RepositorioEstabelecimento implements IRepositorioEstabelecimento {

	private static RepositorioEstabelecimento instancia;
	private Connection connection;
	private PreparedStatement smt;
	private ResultSet result;
	private String sql;
	
	private RepositorioEstabelecimento() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}

	public static RepositorioEstabelecimento getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia==null){
			synchronized (RepositorioEstabelecimento.class) {
				if(instancia == null){
					instancia = new RepositorioEstabelecimento();
				}
			}
		}
		return instancia;
	}
	
	
	@Override
	public void adicionarEstabelecimento(Estabelecimento entidade) throws SQLException {
		int id_auto_increment = 0; //Variavel para recuperar ID auto increment de Estabelecimento
		
		sql = "insert into estabelecimento (nome_fantasia, nome_juridico, email"
				+ ", senha, categoria, cnpj, rua, numero, complemento, bairro"
				+ ", cidade, estado, cep, referencia, id_administrador, status)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		smt.setString(1,entidade.getNome_fantasia());
		smt.setString(2,entidade.getNome_juridico());
		smt.setString(3,entidade.getEmail());
		smt.setString(4,entidade.getSenha());
		smt.setString(5,entidade.getCategoria());
		smt.setString(6,entidade.getCnpj());
		smt.setString(7,entidade.getEndereco().getRua());
		smt.setString(8,entidade.getEndereco().getNumero());
		smt.setString(9,entidade.getEndereco().getComplemento());
		smt.setString(10,entidade.getEndereco().getBairro());
		smt.setString(11,entidade.getEndereco().getCidade());
		smt.setString(12,entidade.getEndereco().getEstado());
		smt.setString(13,entidade.getEndereco().getCep());
		smt.setString(14,entidade.getEndereco().getReferencia());
		smt.setInt(15,entidade.getAdministrador().getId_usuario());
		smt.setString(16,Status.ATIVO.toString());
		smt.execute();

		result = smt.getGeneratedKeys();
		if(result.next()){
			id_auto_increment = result.getInt(1);
		}
		result.close();
		smt.close();
		
					 	
		 //Inserindo os Telefones
		 for(String telefone : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
		 			+" (id_estabelecimento, telefone) values (?,?)");
		 			smt.setInt(1,id_auto_increment);
				 	smt.setString(2,telefone);
				 	smt.execute();
				 	smt.close();
		}

		System.out.println("CADASTRA ESTABELECIMENTO OK");
	}

	@Override
	public void alterarEstabelecimento(Estabelecimento entidade) throws SQLException {
		
		
		sql = "update estabelecimento set"
				+ " nome_fantasia = '"+entidade.getNome_fantasia()+"'"
				+ ", nome_juridico = '"+entidade.getNome_juridico()+"'"
				+ ", categoria = '"+entidade.getCategoria()+"'"
				+ ", cnpj = '"+entidade.getCnpj()+"'"
				+ ", email = '"+entidade.getEmail()+"'"
				+ ", senha = '"+entidade.getSenha()+"'"
				+ ", rua = '"+entidade.getEndereco().getRua()+"'"
				+ ", numero = '"+entidade.getEndereco().getNumero()+"'"
				+ ", complemento = '"+entidade.getEndereco().getComplemento()+"'"
				+ ", bairro = '"+entidade.getEndereco().getBairro()+"'"
				+ ", cidade = '"+entidade.getEndereco().getCidade()+"'"
				+ ", estado = '"+entidade.getEndereco().getEstado()+"'"
				+ ", cep = '"+entidade.getEndereco().getCep()+"'"
				+ ", referencia = '"+entidade.getEndereco().getReferencia()+"'"
				+ " where id_estabelecimento = " +entidade.getId_estabelecimento()
				+ " and status = '" +Status.ATIVO.toString()+ "'";
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//Deletando os Telefones Anteriores
		sql = "delete from telefone_estabelecimento where id_estabelecimento = "+entidade.getId_estabelecimento();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();

		//Inserindo os novos telefones
		for(String telefone : entidade.getTelefones()){	 	
			smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
				+" (id_estabelecimento, telefone) values (?,?)");
			smt.setInt(1,entidade.getId_estabelecimento());
	 		smt.setString(2, telefone);
			smt.execute();
			smt.close();
		}
		System.out.println("ALTERAR ESTABELECIMENTO OK");
	}

	@Override
	public void excluirEstabelecimento(Estabelecimento entidade) throws SQLException {
		sql = "UPDATE estabelecimento SET status ='" + Status.INATIVO.toString() + "' where id_estabelecimento = "+entidade.getId_estabelecimento();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUIR ESTABELECIMENTO OK");
	}

	@Override
	public List<Estabelecimento> listarEstabelecimentos() throws SQLException {
		sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString()+ "'";
		
		smt = this.connection.prepareStatement(sql);
		result = smt.executeQuery();
		List<Estabelecimento> lista = null;
		Administrador administrador = null;
		
			while (result.next()){
				if(lista == null){
					lista = new ArrayList<Estabelecimento>();
				}
				administrador = new Administrador();
				
				int id_estabelecimento = result.getInt("id_estabelecimento");
				String nome_fantasia = result.getString("nome_fantasia");
				String nome_juridico = result.getString("nome_juridico");
				String email  = result.getString("email");
				String senha = result.getString("senha");
				String categoria = result.getString("categoria");
				String cnpj = result.getString("cnpj");
				String rua = result.getString("rua");
				String numero = result.getString("numero");
				String complemento = result.getString("complemento");
				String bairro = result.getString("bairro");
				String cidade = result.getString("cidade");
				String estado = result.getString("estado");
				String cep = result.getString("cep");
				String referencia = result.getString("referencia");
				administrador.setId_usuario(result.getInt("id_administrador"));
				
				Endereco  endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				Estabelecimento estabelecimento = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico,
						email, categoria, cnpj, endereco, senha, null,administrador);
				lista.add(estabelecimento);
			}
			result.close();
			smt.close();
			
			if(lista != null){
				//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
				for (Estabelecimento estabelecimento : lista){
					smt = this.connection.prepareStatement("select * from telefone_estabelecimento where id_estabelecimento = " + estabelecimento.getId_estabelecimento());
					result = smt.executeQuery();
					ArrayList<String> telelefones = null;
						while (result.next()){
							if(telelefones == null){
								telelefones = new ArrayList<String>();
							}
							telelefones.add(result.getString("telefone"));
						}
					result.close();
					smt.close();
					estabelecimento.setTelefones(telelefones);
				}
			}
			
		System.out.println("LISTA ESTABELECIMENTO OK");		
		return lista;
	}

	@Override
	public Estabelecimento pesquisarEstabelecimento(Estabelecimento entidade) throws SQLException {
		
		if(entidade.getId_estabelecimento() > 0){
			sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString() + "'"
					+ " AND id_estabelecimento = "+entidade.getId_estabelecimento();
		}else{
			sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString() + "'"
					+ " AND cnpj = "+entidade.getCnpj();
		}
	
		smt = this.connection.prepareStatement(sql);
		result = smt.executeQuery();
		Estabelecimento estabelecimento = null;
		Administrador administrador = null;
			if (result.next()){
				administrador = new Administrador();
				
				int id_estabelecimento = result.getInt("id_estabelecimento");
				String nome_fantasia = result.getString("nome_fantasia");
				String nome_juridico = result.getString("nome_juridico");
				String email  = result.getString("email");
				String senha = result.getString("senha");
				String categoria = result.getString("categoria");
				String cnpj = result.getString("cnpj");
				String rua = result.getString("rua");
				String numero = result.getString("numero");
				String complemento = result.getString("complemento");
				String bairro = result.getString("bairro");
				String cidade = result.getString("cidade");
				String estado = result.getString("estado");
				String cep = result.getString("cep");
				String referencia = result.getString("referencia");
				administrador.setId_usuario(result.getInt("id_administrador"));
				
				Endereco  endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				estabelecimento = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico, email, categoria, cnpj, endereco, senha, null, administrador);
				
			}
			result.close();
			smt.close();
			if(estabelecimento != null){
				//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
				sql = "select * from telefone_estabelecimento where id_estabelecimento = " + estabelecimento.getId_estabelecimento();
				
				smt = this.connection.prepareStatement(sql);
				result = smt.executeQuery();
				ArrayList<String> telefones = null;
					while (result.next()){
						if(telefones == null){
							telefones = new ArrayList<String>();
						}
						telefones.add(result.getString("telefone"));
					}
					estabelecimento.setTelefones(telefones);
					result.close();
					smt.close();	
			}

			
			System.out.println("PESQUISAR ESTABELECIMENTO OK");
				
		return estabelecimento;
	}

	@Override
	public List<Estabelecimento> listarEstabelecimentoPorRegiao(
			String categoria, Cliente cliente, boolean pesquisarPorBairro)
			throws SQLException {
		if(pesquisarPorBairro == false){
			sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString()+ "'"
					+ " and categoria = '"+categoria+"'"
					+ " and estado = '" +cliente.getEndereco().getEstado()+ "'"
					+ " and cidade = '" +cliente.getEndereco().getCidade()+ "'";
					
		}else {
			sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString()+ "'"
					+ " and categoria = '"+categoria+"'"
					+ " and estado = '" +cliente.getEndereco().getEstado()+ "'"
					+ " and cidade = '" +cliente.getEndereco().getCidade()+ "'"
					+ " and (cep = '" +cliente.getEndereco().getCep()+ "'"
					+ " or bairro = '" +cliente.getEndereco().getBairro()+"')";
		}
		
		smt = this.connection.prepareStatement(sql);
		result = smt.executeQuery();
		List<Estabelecimento> lista = null;
		Administrador administrador = null;
			while (result.next()){
				if(lista == null){
					lista = new ArrayList<Estabelecimento>();
				}
				administrador = new Administrador();
				
				int id_estabelecimento = result.getInt("id_estabelecimento");
				String nome_fantasia = result.getString("nome_fantasia");
				String nome_juridico = result.getString("nome_juridico");
				String email  = result.getString("email");
				String senha = result.getString("senha");
				String cnpj = result.getString("cnpj");
				String rua = result.getString("rua");
				String numero = result.getString("numero");
				String complemento = result.getString("complemento");
				String bairro = result.getString("bairro");
				String cidade = result.getString("cidade");
				String estado = result.getString("estado");
				String cep = result.getString("cep");
				String referencia = result.getString("referencia");
				administrador.setId_usuario(result.getInt("id_administrador"));
				
				Endereco  endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				Estabelecimento estabelecimento = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico,
						email, categoria, cnpj, endereco, senha, null, administrador);
				lista.add(estabelecimento);
			}
			result.close();
			smt.close();
			
			if(lista != null){
				//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
				for (Estabelecimento estabelecimento : lista){
					smt = this.connection.prepareStatement("select * from telefone_estabelecimento where id_estabelecimento = " + estabelecimento.getId_estabelecimento());
					result = smt.executeQuery();
					ArrayList<String> telelefones = null;
						while (result.next()){
							if(telelefones == null){
								telelefones = new ArrayList<String>();
							}
							telelefones.add(result.getString("telefone"));
						}
					result.close();
					smt.close();
					estabelecimento.setTelefones(telelefones);
				}
			}
			
		System.out.println("LISTAR ESTABELECIMENTO POR REGIÃO OK");		
		return lista;
	}
	
	

}
