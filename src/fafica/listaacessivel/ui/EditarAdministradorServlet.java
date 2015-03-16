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

/**
 * Servlet implementation class EditarAdministrador
 */
@WebServlet("/EditarAdministradorServlet")
public class EditarAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		if(administrador == null){
			String mensagem = "Sess√£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{

			response.sendRedirect("editarAdministrador.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		if(administrador == null){
			String mensagem = "Sess√£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				administrador.setNome(request.getParameter("nome"));
				administrador.setCpf(request.getParameter("cpf"));
				administrador.setEmail(request.getParameter("email"));
								
				fachada.alterarAdministrador(administrador);
				
				String mensagem = "AlteraÁ„o realizada com sucesso!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("perfilAdministrador.jsp");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
