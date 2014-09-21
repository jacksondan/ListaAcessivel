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
import fafica.listaacessivel.negocios.entidades.Usuario;

public class RepositorioUsuario implements IRepositorio<Usuario> {
	private static RepositorioUsuario instancia;
	private PreparedStatement smt;
	private Connection connection;
	private ResultSet result;
	private String sql;
	
	private RepositorioUsuario() throws ClassNotFoundException, SQLException{
		this.connection = ConnectionMysql.getConnectionMysql();
	}
	
	public static RepositorioUsuario getInstancia() throws ClassNotFoundException, SQLException{
		if(instancia==null)	instancia = new RepositorioUsuario();
		
		return instancia;
	}
	@Override
	public void adicionar(Usuario entidade) throws SQLException {
		smt = this.connection.prepareStatement("insert into usuario (nome_usuario,cpf,email,senha,rua,numero,bairro,cidade,estado,cep,referencia,status) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)");
		smt.setString(1,entidade.getNome());
		smt.setString(2,entidade.getCpf());
		smt.setString(3,entidade.getEmail());
		smt.setString(4,entidade.getSenha());
		smt.setString(5,entidade.getRua());
		smt.setString(6,entidade.getNumero());
		smt.setString(7,entidade.getBairro());
		smt.setString(8,entidade.getCidade());
		smt.setString(9,entidade.getEstado());
		smt.setString(10,entidade.getCep());
		smt.setString(11,entidade.getReferencia());
		smt.setString(12,Status.ATIVO.toString());
		smt.execute();
		smt.close();
		
		Usuario u = new Usuario();
		u.setCpf(entidade.getCpf());
				u = pesquisar(u);
		
		for(String tel : entidade.getTelefones()){	 	
		 	smt = this.connection.prepareStatement("insert into telefone_usuario"
		 			+"(id_usuario,telefone) values (?,?)");
		 			smt.setInt(1,u.getId_usuario());
				 	smt.setString(2,tel);
				 	smt.execute();
				 	smt.close();
		}
		
		System.out.println("CADASTRA USUARIO OK");
		System.out.println(""); //LINHA TEMPORARIA
	}

	@Override
	public void alterar(Usuario entidade) throws SQLException {
		smt = this.connection.prepareStatement("update usuario set nome_usuario = ?,cpf = ?,"
				+ "email = ?,senha = ?,rua = ?,numero = ?,bairro = ?,"
				+ "cidade = ?,estado = ?,cep = ?,referencia = ? where id_usuario = "+entidade.getId_usuario());
		smt.setString(1,entidade.getNome());
		smt.setString(2,entidade.getCpf());
		smt.setString(3,entidade.getEmail());
		smt.setString(4,entidade.getSenha());
		smt.setString(5,entidade.getRua());
		smt.setString(6,entidade.getNumero());
		smt.setString(7,entidade.getBairro());
		smt.setString(8,entidade.getCidade());
		smt.setString(9,entidade.getEstado());
		smt.setString(10,entidade.getCep());
		smt.setString(11,entidade.getReferencia());
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
	public void excluir(Usuario entidade) throws SQLException {
		smt = connection.prepareStatement("update usuario set status ='" + Status.INATIVO.toString() + "' where id_usuario=?");
		smt.setInt(1, entidade.getId_usuario());
		smt.execute();
		smt.close();
		
		System.out.println("EXCLUINDO USUARIO (VIA STATUS) OK"); //LINHA TEMPORARIA
	}

	@Override
	public List <Usuario> listar()throws SQLException  {
			smt = this.connection.prepareStatement("select * from usuario where status ='" + Status.ATIVO.toString() + "'");
			result= smt.executeQuery();
			List <Usuario> usuarios = new ArrayList<Usuario>();
			while(result.next()){
				Usuario usuario= new Usuario();
				usuario.setId_usuario(result.getInt("id_usuario"));
				usuario.setNome(result.getString("nome_usuario"));
				usuario.setCpf(result.getString("cpf"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setRua(result.getString("rua"));
				usuario.setNumero(result.getString("numero"));
				usuario.setBairro(result.getString("bairro"));
				usuario.setCidade(result.getString("cidade"));
				usuario.setEstado(result.getString("estado"));
				usuario.setCep(result.getString("cep"));
				usuario.setReferencia(result.getString("referencia"));
				usuarios.add(usuario);
			}
			result.close();
			smt.close();
			
			for (Usuario u : usuarios){
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
		return usuarios;
	}

	@Override
	public Usuario pesquisar(Usuario entidade) throws SQLException {
		if(entidade.getId_usuario() > 0){
			sql="select * from usuario where status = '" + Status.ATIVO.toString() + "' AND id_usuario = "+entidade.getId_usuario();
		}else{
			sql="select * from usuario where status = '" + Status.ATIVO.toString() + "' AND cpf = '"+entidade.getCpf()+"'";
		}
		
		
		smt = connection.prepareStatement(sql);
		result = smt.executeQuery();
		
			Usuario usuario = new Usuario();
			while (result.next()){
				usuario.setId_usuario(result.getInt("id_usuario"));
				usuario.setNome(result.getString("nome_usuario"));
				usuario.setCpf(result.getString("cpf"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setRua(result.getString("rua"));
				usuario.setNumero(result.getString("numero"));
				usuario.setBairro(result.getString("bairro"));
				usuario.setCidade(result.getString("cidade"));
				usuario.setEstado(result.getString("estado"));
				usuario.setCep(result.getString("cep"));
				usuario.setReferencia(result.getString("referencia"));
			}
			result.close();
			smt.close();
			
			sql = "select * from telefone_usuario where id_usuario = " + usuario.getId_usuario();
			
			smt = this.connection.prepareStatement(sql);
			result = smt.executeQuery();
			ArrayList<String> tel = new ArrayList<String>();
				while (result.next()){
					tel.add(result.getString("telefone"));
				}
				result.close();
				smt.close();
			usuario.setTelefones(tel);
			
			System.out.println("PESQUISAR USUARIO OK"); //LINHA TEMPORARIA
		return usuario;

		
/*		List<Usuario> lista_usuario = new ArrayList<Usuario>();
		Usuario usuario_pesquisa = null;
		
		
		lista_usuario = listar();
		
		for(Usuario usuario : lista_usuario){
			if(entidade.getCpf().equals(usuario.getCpf())){
				usuario_pesquisa = usuario;
			}
		}
		
		return usuario_pesquisa;*/
	}

}
