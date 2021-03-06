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
 * Servlet implementation class CadastrarAdministrador
 */
@WebServlet("/CadastrarAdministradorServlet")
public class CadastrarAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAdministradorServlet() {
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
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("cadastroAdministrador.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		if(administrador == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
			
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String cpf = request.getParameter("cpf");
				String senha = request.getParameter("senha");
				
				Administrador administradorCadastro = new Administrador(nome, email, cpf, senha);
				fachada.adicionarAdministrador(administradorCadastro);
				
				response.sendRedirect("VisaoAdministradorServlet");
				
//				String mensagem = "Administrador cadastrado com sucesso!";
//				request.setAttribute("mensagem", mensagem);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("VisaoAdministradorServlet");
//				dispatcher.forward(request, response);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
