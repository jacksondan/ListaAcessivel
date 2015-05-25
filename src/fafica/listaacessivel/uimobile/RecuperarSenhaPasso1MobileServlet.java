package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.util.EmailJava;

/**
 * Servlet implementation class RecuperarSenhaPasso1MobileServlet
 */
@WebServlet("/RecuperarSenhaPasso1MobileServlet")
public class RecuperarSenhaPasso1MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Cliente cliente;
	private List<Cliente> listaCliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarSenhaPasso1MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		try {
			fachada = Fachada.getInstance();
			
			listaCliente = fachada.listarCliente();
			for(Cliente c : listaCliente){
				if(c.getEmail().equals(email)){
					cliente = c;
					break;
				}
			}
			
			if(cliente != null){
				EmailJava  emailJava = new EmailJava();
				emailJava.recuperarSenha(cliente);
				
				PrintWriter out = response.getWriter(); //Criar tela para exibir mensagens
				out.println("sucesso");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

}
