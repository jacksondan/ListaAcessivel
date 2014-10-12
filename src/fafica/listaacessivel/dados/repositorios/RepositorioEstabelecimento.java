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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

public class RepositorioEstabelecimento implements IRepositorio<Estabelecimento>{

	private static RepositorioEstabelecimento instancia;
	private Connection connection;
	private PreparedStatement smt;
	private ResultSet rs;
	private String sql;
	
	private RepositorioEstabelecimento() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionMysql.getConnectionMysql();
	}

	public static RepositorioEstabelecimento getInstancia() throws ClassNotFoundException, SQLException {
		if(instancia == null) instancia = new RepositorioEstabelecimento();
		return instancia;
	}
	
	
	@Override
	public void adicionar(Estabelecimento entidade) throws SQLException {
		sql = "insert into estabelecimento"
			 	+ "(nome_fantasia,nome_juridico,categoria,cnpj,email,senha,rua,"+
				"numero,bairro,cidade,estado,cep,referencia,status)"
				+"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
			 	smt.setString(1,entidade.getNome_fantasia());
			 	smt.setString(2,entidade.getNome_juridico());
			 	smt.setString(3,entidade.getCategoria());
			 	smt.setString(4,entidade.getCnpj());
			 	smt.setString(5,entidade.getEmail());
			 	smt.setString(6,entidade.getSenha());
			 	smt.setString(7,entidade.getRua());
			 	smt.setString(8,entidade.getNumero());
			 	smt.setString(9,entidade.getBairro());
			 	smt.setString(10,entidade.getCidade());
			 	smt.setString(11,entidade.getEstado());
			 	smt.setString(12,entidade.getCep());
			 	smt.setString(13,entidade.getReferencia());
			 	smt.setString(14,Status.ATIVO.toString());
			 	smt.execute();
			 	smt.close();
			 	
			 	
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setCnpj(entidade.getCnpj());
		
		estabelecimento = pesquisar(estabelecimento);
			 				 
		//Inserindo os telefones na tabela telefone_estabelecimento
		for(String tel : entidade.getTelefones()){	 	
			 	smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
			 			+"(id_estabelecimento,telefone) values (?,?)");
			 			smt.setInt(1,estabelecimento.getId_usuario());
			 			smt.setString(2, tel);
					 	smt.execute();
					 	smt.close();
		}
		System.out.println("CADASTRA ESTABELECIMENTO OK");
		System.out.println(""); //LINHA TEMPORARIA
	}

	@Override
	public void alterar(Estabelecimento entidade) throws SQLException {
		sql = "update estabelecimento set"
				+ " nome_fantasia = '"+entidade.getNome_fantasia()+"'"
				+ ", nome_juridico = '"+entidade.getNome_juridico()+"'"
				+ ", categoria = '"+entidade.getCategoria()+"'"
				+ ", cnpj = '"+entidade.getCnpj()+"'"
				+ ", email = '"+entidade.getEmail()+"'"
				+ ", senha = '"+entidade.getSenha()+"'"
				+ ", rua = '"+entidade.getRua()+"'"
				+ ", numero = '"+entidade.getNumero()+"'"
				+ ", bairro = '"+entidade.getBairro()+"'"
				+ ", cidade = '"+entidade.getCidade()+"'"
				+ ", estado = '"+entidade.getEstado()+"'"
				+ ", cep = '"+entidade.getCep()+"'"
				+ ", referencia = '"+entidade.getReferencia()+"'"
				+ " where id_estabelecimento = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//Deletando os Telefones Anteriores
		sql = "delete from telefone_estabelecimento where id_estabelecimento = "+entidade.getId_usuario();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		//Inserindo os novos telefones
		for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_estabelecimento"
		 			+"(id_estabelecimento,telefone) values (?,?)");
		 			smt.setInt(1,entidade.getId_usuario());
		 			smt.setString(2, tel);
				 	smt.execute();
				 	smt.close();
		}
		System.out.println("ALTERAR ESTABELECIMENTO OK");
		System.out.println(""); //LINHA TEMPORARIA
		
	}

	@Override
	public void excluir(Estabelecimento entidade) throws SQLException {
		//Setando Inativo ao status do estabelecimento
		String sql = "UPDATE estabelecimento SET status = '"+Status.INATIVO.toString()+"' where id_estabelecimento = "+entidade.getId_usuario();
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUIR ESTABELECIMENTO OK");
		System.out.println(""); //LINHA TEMPORARIA
		
	}

	@Override
	public List<Estabelecimento> listar() throws SQLException {
		smt = this.connection.prepareStatement("select * from estabelecimento where status='" + Status.ATIVO.toString() + "'");
		rs = smt.executeQuery();
		List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
			while (rs.next()){
				Estabelecimento estabelecimento = new Estabelecimento(rs.getString("nome_fantasia"), rs.getString("nome_juridico"),
						rs.getString("categoria"),rs.getString("cnpj"), rs.getString("email"),
						rs.getString("senha"), rs.getString("rua"),rs.getString("numero"),
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"),
						rs.getString("cep"), rs.getString("referencia"));
				estabelecimento.setId_usuario(rs.getInt("id_estabelecimento"));
							
				lista.add(estabelecimento);
			}
			rs.close();
			smt.close();
			
			//Parte onde � feito a busca pelos telefones que seram setados nos objetos
			for (Estabelecimento e : lista){
				smt = this.connection.prepareStatement("select * from telefone_estabelecimento where id_estabelecimento = " + e.getId_usuario());
				rs = smt.executeQuery();
				ArrayList<String> tel = new ArrayList<String>();
					while (rs.next()){
						tel.add(rs.getString("telefone"));
					}
				rs.close();
				smt.close();
				e.setTelefones(tel);
			}
				
		return lista;
	}

	@Override
	public Estabelecimento pesquisar(Estabelecimento entidade) throws SQLException {
		
		if(entidade.getId_usuario() > 0){
			sql = "select * from estabelecimento where status='" + Status.ATIVO.toString() + "' and id_estabelecimento = "+entidade.getId_usuario(); 
		}else{
			sql = "select * from estabelecimento where status='" + Status.ATIVO.toString() + "' and cnpj = '"+entidade.getCnpj()+"'";
		}
	
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		Estabelecimento estabelecimento = new Estabelecimento();
			while (rs.next()){
				estabelecimento.setId_usuario(rs.getInt("id_estabelecimento"));
				estabelecimento.setNome_fantasia(rs.getString("nome_fantasia"));
				estabelecimento.setNome_juridico(rs.getString("nome_juridico"));
				estabelecimento.setCategoria(rs.getString("categoria"));
				estabelecimento.setCnpj(rs.getString("cnpj"));
				estabelecimento.setEmail(rs.getString("email"));
				estabelecimento.setSenha(rs.getString("senha"));
				estabelecimento.setRua(rs.getString("rua"));
				estabelecimento.setNumero(rs.getString("numero"));
				estabelecimento.setBairro(rs.getString("bairro"));
				estabelecimento.setCidade(rs.getString("cidade"));
				estabelecimento.setEstado(rs.getString("estado"));
				estabelecimento.setCep(rs.getString("cep"));
				estabelecimento.setReferencia(rs.getString("referencia"));
			}
			rs.close();
			smt.close();
			
			//Parte onde � feito a busca pelos telefones que seram setados nos objetos
				sql = "select * from telefone_estabelecimento where id_estabelecimento = '" + estabelecimento.getId_usuario()+"'";
				
				smt = this.connection.prepareStatement(sql);
				rs = smt.executeQuery();
				ArrayList<String> tel = new ArrayList<String>();
					while (rs.next()){
						tel.add(rs.getString("telefone"));
					}
				estabelecimento.setTelefones(tel);
				rs.close();
				smt.close();
				
		return estabelecimento;
	}

}
