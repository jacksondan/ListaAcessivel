package fafica.listaacessivel.ui;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;

/**
 * Servlet implementation class CadastraUs
 */
@WebServlet("/CadastraUs")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			fachada = Fachada.getInstance();
			ArrayList <String> telefones = new ArrayList <String>();
						
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String numero = request.getParameter("numero");
			String referencia = request.getParameter("referencia");
			String cep = request.getParameter("cep");
			String telefone1 = request.getParameter("telefone1");
			String telefone2 = request.getParameter("telefone2");
			telefones.add(telefone1);
			telefones.add(telefone2);
			
			String senhaEncriptada = encriptar(senha);
	
			Cliente entidade = new Cliente(nome, cpf, email, senhaEncriptada, cidade, estado, rua, bairro, numero, referencia, cep);
			entidade.setTelefones(telefones);
			
			fachada.adicionarUsuario(entidade);
			
			response.sendRedirect("cadastros.jsp");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
	public static String encriptar(String senha) {     
        try {     
             MessageDigest digest = MessageDigest.getInstance("MD5");      
             digest.update(senha.getBytes());      
             BASE64Encoder encoder = new BASE64Encoder ();      
             return encoder.encode (digest.digest ());      
        } catch (NoSuchAlgorithmException ns) {     
             ns.printStackTrace ();      
             return senha;      
        }      
   }

}
