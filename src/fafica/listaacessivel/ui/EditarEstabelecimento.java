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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class EditarEstabelecimento
 */
@WebServlet("/EditarEstabelecimento")
public class EditarEstabelecimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarEstabelecimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			IFachada fachada = Fachada.getInstance();
			ArrayList<String> telefones = new ArrayList<String>();
			
			int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
			String nome_fantasia = request.getParameter("nome_fantasia");
			String nome_juridico = request.getParameter("nome_juridico");
			String categoria = request.getParameter("categoria");
			String cnpj = request.getParameter("cnpj");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			telefones.add(request.getParameter("telefone1"));
			telefones.add(request.getParameter("telefone2"));
			String rua = request.getParameter("rua");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String cep = request.getParameter("cep");
			String referencia = request.getParameter("referencia");
			
			String senhaEncriptada = encriptar(senha);
			
			Estabelecimento entidade = new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico, categoria, cnpj, email, senhaEncriptada, rua, numero, bairro, cidade, estado, cep, referencia);
			entidade.setTelefones(telefones);
			
			fachada.alterarEstabelecimento(entidade);
			
			response.sendRedirect("visaoEs.jsp");
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
