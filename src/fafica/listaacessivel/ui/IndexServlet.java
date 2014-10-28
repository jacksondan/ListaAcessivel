package fafica.listaacessivel.ui;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;
import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Usuario;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
			this.fachada = Fachada.getInstance();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			Usuario usuario = null;
			
			String senhaEncriptada = encriptar(senha); 
			
			for(Cliente cliente : fachada.listarCliente()){
				if (cliente.getEmail().equals(email)&& cliente.getSenha().equals(senhaEncriptada)){
					usuario = cliente;
				}
			}	
			for(Estabelecimento estabelecimento : fachada.listarEstabelecimento()){
				if (estabelecimento.getEmail().equals(email)&& estabelecimento.getSenha().equals(senhaEncriptada)){
					usuario = estabelecimento;
				}
			}
			
			if(usuario != null){
				String classe = usuario.getClass().toString();
				System.out.println("************ "+classe+" ***************");
				if(classe.endsWith(".Cliente")){
					HttpSession session = request.getSession(); 
					session.setAttribute("acessoCliente", usuario);
					response.sendRedirect("visaoUsuario.jsp");
				}else{
					HttpSession session = request.getSession(); 
					session.setAttribute("acessoEstabelecimento", usuario);
					response.sendRedirect("visaoEs.jsp");
				}
			}else{
				request.setAttribute("erroLogin", "******E-mail ou Senha Incorreto******");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			
			
			
			
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
