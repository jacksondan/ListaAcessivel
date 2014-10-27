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
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			fachada = Fachada.getInstance();
			
			ArrayList <String> telefones = new ArrayList <String>();
			
			int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
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
	
			Cliente entidade = new Cliente(id_usuario, nome, cpf, email, senhaEncriptada, cidade, estado, rua, bairro, numero, referencia, cep);
			entidade.setTelefones(telefones);
			
			fachada.alterarCliente(entidade);
			
			response.sendRedirect("visaoUsuario.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
