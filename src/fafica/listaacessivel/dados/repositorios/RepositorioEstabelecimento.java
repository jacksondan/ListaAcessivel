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
		
		sql = "insert into usuario (email,senha,rua,numero,complemento,bairro,cidade,estado,cep,referencia,status) values"
				+ " (?,?,?,?,?,?,?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
		smt.setString(1,entidade.getEmail());
		smt.setString(2,entidade.getSenha());
		smt.setString(3,entidade.getRua());
		smt.setString(4,entidade.getNumero());
		smt.setString(5,entidade.getComplemento());
		smt.setString(6,entidade.getBairro());
		smt.setString(7,entidade.getCidade());
		smt.setString(8,entidade.getEstado());
		smt.setString(9,entidade.getCep());
		smt.setString(10,entidade.getReferencia());
		smt.setString(11,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		//Coladando o ID_USUARIO que é gerado pelo BD
		Estabelecimento estabelecimento = new Estabelecimento();
		sql = "select id_usuario from usuario where email = '"+entidade.getEmail()+"'";
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
			while (rs.next()){
				estabelecimento.setId_usuario(rs.getInt("id_usuario"));
			}
			rs.close();
			smt.close();
		
		
		//Inserindo os dados da tabela Estabelecimento, juntamente com o ID coletado
		sql = "insert into estabelecimento (id_estabelecimento,nome_fantasia,nome_juridico,categoria,cnpj)"
				+ " values (?,?,?,?,?)";
		
		smt = this.connection.prepareStatement(sql);
				smt.setInt(1,estabelecimento.getId_usuario());
			 	smt.setString(2,entidade.getNome_fantasia());
			 	smt.setString(3,entidade.getNome_juridico());
			 	smt.setString(4,entidade.getCategoria());
			 	smt.setString(5,entidade.getCnpj());
			 	smt.execute();
			 	smt.close();
			 	
		 //Inserindo os Telefones
		 for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_usuario"
		 			+"(id_usuario,telefone) values (?,?)");
		 			smt.setInt(1,estabelecimento.getId_usuario());
				 	smt.setString(2,tel);
				 	smt.execute();
				 	smt.close();
		}

		System.out.println("CADASTRA ESTABELECIMENTO OK");
		System.out.println(""); //LINHA TEMPORARIA
	}

	@Override
	public void alterar(Estabelecimento entidade) throws SQLException {
		
		sql = "UPDATE usuario SET"
				+ " email = '"+entidade.getEmail()+"'"
				+ ", senha = '"+entidade.getSenha()+"'"
				+ ", rua = '"+entidade.getRua()+"'"
				+ ", numero = '"+entidade.getNumero()+"'"
				+ ", complemento = '"+entidade.getComplemento()+"'"
				+ ", bairro = '"+entidade.getBairro()+"'"
				+ ", cidade = '"+entidade.getCidade()+"'"
				+ ", estado = '"+entidade.getEstado()+"'"
				+ ", cep = '"+entidade.getCep()+"'"
				+ ", referencia = '"+entidade.getReferencia()+"'"
				+ " where id_usuario = "+entidade.getId_usuario();
		
		smt = this.connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		sql = "update estabelecimento set"
				+ " nome_fantasia = '"+entidade.getNome_fantasia()+"'"
				+ ", nome_juridico = '"+entidade.getNome_juridico()+"'"
				+ ", categoria = '"+entidade.getCategoria()+"'"
				+ ", cnpj = '"+entidade.getCnpj()+"'"
				+ " where id_estabelecimento = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
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
		System.out.println("ALTERAR ESTABELECIMENTO OK");
	}

	@Override
	public void excluir(Estabelecimento entidade) throws SQLException {
		sql = "UPDATE usuario SET status ='" + Status.INATIVO.toString() + "' where id_usuario = "+entidade.getId_usuario();
		
		smt = connection.prepareStatement(sql);
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUIR ESTABELECIMENTO OK");
	}

	@Override
	public List<Estabelecimento> listar() throws SQLException {
		sql = "select u.*,e.* from usuario u, estabelecimento e where u.status = '" + Status.ATIVO.toString() + "'"
				+ " AND u.id_usuario = e.id_estabelecimento";;
		
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
			while (rs.next()){
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_usuario(rs.getInt("e.id_estabelecimento"));
				estabelecimento.setNome_fantasia(rs.getString("e.nome_fantasia"));
				estabelecimento.setNome_juridico(rs.getString("e.nome_juridico"));
				estabelecimento.setCategoria(rs.getString("e.categoria"));
				estabelecimento.setCnpj(rs.getString("e.cnpj"));
				estabelecimento.setEmail(rs.getString("u.email"));
				estabelecimento.setSenha(rs.getString("u.senha"));
				estabelecimento.setRua(rs.getString("u.rua"));
				estabelecimento.setNumero(rs.getString("u.numero"));
				estabelecimento.setComplemento(rs.getString("u.complemento"));
				estabelecimento.setBairro(rs.getString("u.bairro"));
				estabelecimento.setCidade(rs.getString("u.cidade"));
				estabelecimento.setEstado(rs.getString("u.estado"));
				estabelecimento.setCep(rs.getString("u.cep"));
				estabelecimento.setReferencia(rs.getString("u.referencia"));
				lista.add(estabelecimento);
			}
			rs.close();
			smt.close();
			
			//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
			for (Estabelecimento e : lista){
				smt = this.connection.prepareStatement("select * from telefone_usuario where id_usuario = " + e.getId_usuario());
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
			sql = "select u.*,e.* from usuario u, estabelecimento e where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = "+entidade.getId_usuario()
					+ " AND e.id_estabelecimento = "+entidade.getId_usuario();
		}else{
			sql = "select u.*,e.* from usuario u, estabelecimento e where u.status = '" + Status.ATIVO.toString() + "'"
					+ " AND u.id_usuario = (select id_estabelecimento from estabelecimento where cnpj = '"+entidade.getCnpj()+"')"
					+ " AND e.cnpj = '"+entidade.getCnpj()+"'";
		}
	
		smt = this.connection.prepareStatement(sql);
		rs = smt.executeQuery();
		Estabelecimento estabelecimento = new Estabelecimento();
			while (rs.next()){
				estabelecimento.setId_usuario(rs.getInt("e.id_estabelecimento"));
				estabelecimento.setNome_fantasia(rs.getString("e.nome_fantasia"));
				estabelecimento.setNome_juridico(rs.getString("e.nome_juridico"));
				estabelecimento.setCategoria(rs.getString("e.categoria"));
				estabelecimento.setCnpj(rs.getString("e.cnpj"));
				estabelecimento.setEmail(rs.getString("u.email"));
				estabelecimento.setSenha(rs.getString("u.senha"));
				estabelecimento.setRua(rs.getString("u.rua"));
				estabelecimento.setNumero(rs.getString("u.numero"));
				estabelecimento.setComplemento(rs.getString("u.complemento"));
				estabelecimento.setBairro(rs.getString("u.bairro"));
				estabelecimento.setCidade(rs.getString("u.cidade"));
				estabelecimento.setEstado(rs.getString("u.estado"));
				estabelecimento.setCep(rs.getString("u.cep"));
				estabelecimento.setReferencia(rs.getString("u.referencia"));
			}
			rs.close();
			smt.close();
			
			//Parte onde ï¿½ feito a busca pelos telefones que seram setados nos objetos
			sql = "select * from telefone_usuario where id_usuario = " + estabelecimento.getId_usuario();
			
			smt = this.connection.prepareStatement(sql);
			rs = smt.executeQuery();
			ArrayList<String> tel = new ArrayList<String>();
				while (rs.next()){
					tel.add(rs.getString("telefone"));
				}
				estabelecimento.setTelefones(tel);
				rs.close();
				smt.close();

			
			System.out.println("PESQUISAR CLIENTE OK");
				
		return estabelecimento;
	}

}
