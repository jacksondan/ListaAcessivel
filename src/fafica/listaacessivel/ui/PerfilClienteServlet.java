package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Cliente;

/**
 * Servlet implementation class PerfilClienteServlet
 */
@WebServlet("/PerfilClienteServlet")
public class PerfilClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		Cliente cliente = (Cliente) session.getAttribute("acessoCliente");

		if (administrador == null && cliente == null) {
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect("index.jsp");
		} else if (administrador != null && cliente == null) {
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
				cliente = new Cliente();
				cliente.setId_usuario(id_cliente);
				cliente = fachada.pesquisarCliente(cliente);

				request.setAttribute("cliente", cliente);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("detalhesCliente.jsp");
				requestDispatcher.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (administrador == null && cliente != null) {
			
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("perfilCliente.jsp");
				requestDispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
