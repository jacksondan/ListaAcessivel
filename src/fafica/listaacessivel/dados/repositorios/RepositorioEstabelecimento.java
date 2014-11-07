package fafica.listaacessivel.dados.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.listaacessivel.dados.IRepositorioEstabelecimento;
import fafica.listaacessivel.dados.util.ConnectionMysql;
import fafica.listaacessivel.dados.util.Status;
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public class RepositorioEstabelecimento implements IRepositorioEstabelecimento {

	private static RepositorioEstabelecimento instancia;
	private Connection connection;
	private PreparedStatement smt;
	private ResultSet rs;
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
		
		sql = "insert into estabelecimento (id_estabelecimento, nome_fantasia, nome_juridico, email,"
				+ " senha, categoria, cnpj, rua, numero, complemento, bairro, "
				+ "cidade, estado, cep, referencia, status) values"
				+ " ()";
		
		smt = this.connection.prepareStatement(sql);
		smt.setInt(1,entidade.getId_estabelecimento());
		smt.setString(2,entidade.getNome_fantasia());
		smt.setString(3,entidade.getNome_juridico());
		smt.setString(4,entidade.getEmail());
		smt.setString(5,entidade.getSenha());
		smt.setString(6,entidade.getCategoria());
		smt.setString(7,entidade.getCnpj());
		smt.setString(8,entidade.getEndereco().getRua());
		smt.setString(9,entidade.getEndereco().getNumero());
		smt.setString(10,entidade.getEndereco().getComplemento());
		smt.setString(11,entidade.getEndereco().getBairro());
		smt.setString(12,entidade.getEndereco().getCidade());
		smt.setString(13,entidade.getEndereco().getEstado());
		smt.setString(14,entidade.getEndereco().getCep());
		smt.setString(15,entidade.getEndereco().getReferencia());
		smt.setString(16,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		//Colocando o ID_USUARIO que é gerado pelo BD
		Estabelecimento estabelecimento = new Estabelecimento();
		sql = "select id_estabelecimento from estabelecimento where cnpj = '"+entidade.getCnpj()+"'";
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
			while (rs.next()){
				estabelecimento.setId_estabelecimento(rs.getInt("id_estabelecimento"));
			}
			rs.close();
			smt.close();
					 	
		 //Inserindo os Telefones
		 for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
		 			+"(id_estabelecimento,telefone) values (?,?)");
		 			smt.setInt(1,estabelecimento.getId_estabelecimento());
				 	smt.setString(2,tel);
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
				+ " where id_estabelecimento = "+entidade.getId_estabelecimento();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//Deletando os Telefones Anteriores
		sql = "delete from telefone_estebelecimento where id_estebelecimento = "+entidade.getId_estabelecimento();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();

		//Inserindo os novos telefones
		for(String tel : entidade.getTelefones()){	 	
			smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
				+"(id_estabelecimento, telefone) values (?,?)");
			smt.setInt(1,entidade.getId_estabelecimento());
	 		smt.setString(2, tel);
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
		sql = "select * from  estabelecimento  where status = '" + Status.ATIVO.toString();
		
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
			while (rs.next()){
				int id_estabelecimento = rs.getInt("id_estabelecimento");
				String nome_fantasia = rs.getString("nome_fantasia");
				String nome_juridico = rs.getString("nome_juridico");
				String email  = rs.getString("email");
				String senha = rs.getString("senha");
				String categoria = rs.getString("categoria");
				String cnpj = rs.getString("cnpj");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				String referencia = rs.getString("referencia");
				
				Endereco  endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				Estabelecimento estabelecimento = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico, email, categoria, cnpj, endereco, senha, null);
				lista.add(estabelecimento);
			}
			rs.close();
			smt.close();
			
			//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
			for (Estabelecimento e : lista){
				smt = this.connection.prepareStatement("select * from telefone_estabelecimento where id_estabelecimento = " + e.getId_estabelecimento());
				rs = smt.executeQuery();
				ArrayList<String> tel = new ArrayList<String>();
					while (rs.next()){
						tel.add(rs.getString("telefone"));
					}
				rs.close();
				smt.close();
				e.setTelefones(tel);
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
		rs = smt.executeQuery();
			Estabelecimento estabelecimento = new Estabelecimento();
			while (rs.next()){
				int id_estabelecimento = rs.getInt("id_estabelecimento");
				String nome_fantasia = rs.getString("nome_fantasia");
				String nome_juridico = rs.getString("nome_juridico");
				String email  = rs.getString("email");
				String senha = rs.getString("senha");
				String categoria = rs.getString("categoria");
				String cnpj = rs.getString("cnpj");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				String referencia = rs.getString("referencia");
				
				Endereco  endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				estabelecimento = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico, email, categoria, cnpj, endereco, senha, null);
				
			}
			rs.close();
			smt.close();
			
			//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
			sql = "select * from telefone_estabelecimento where id_estabelecimento = " + estabelecimento.getId_estabelecimento();
			
			smt = this.connection.prepareStatement(sql);
			rs = smt.executeQuery();
			ArrayList<String> tel = new ArrayList<String>();
				while (rs.next()){
					tel.add(rs.getString("telefone"));
				}
				estabelecimento.setTelefones(tel);
				rs.close();
				smt.close();

			
			System.out.println("PESQUISAR ESTABELECIMENTO OK");
				
		return estabelecimento;
	}

}
