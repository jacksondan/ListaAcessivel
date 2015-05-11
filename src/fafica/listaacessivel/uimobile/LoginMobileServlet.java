package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

/**
 * Servlet implementation class LoginMobileServlet
 */
@WebServlet("/LoginMobileServlet")
public class LoginMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		senha = CriptografiaSenha.encriptar(senha);
		
		Cliente cliente = null;
		List <Cliente> clientes = new ArrayList<Cliente>();
		try {
			fachada = Fachada.getInstance();
			clientes.addAll(fachada.listarCliente());
			
			for(Cliente c : clientes){
				if (c.getEmail().equals(email)&& c.getSenha().equals(senha)){
					cliente = c;
					break;
				}
			}
			
			if(cliente != null){
				Gson gson = new Gson();
				String json = gson.toJson(cliente);
				
				PrintWriter out = response.getWriter();
				out.println(json);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*request.setAttribute("login", json);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
		requestDispatcher.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
