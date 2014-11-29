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
import fafica.listaacessivel.ui.util.CriptografiaSenha;

/**
 * Servlet implementation class EditarSenhaAdministradorServlet
 */
@WebServlet("/EditarSenhaAdministradorServlet")
public class EditarSenhaAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSenhaAdministradorServlet() {
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
		}else{
			String mensagem = "Senha editada com sucesso!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarSenhaAdministrador.jsp");
			dispatcher.forward(request, response);
			
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
			//response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				String mensagem="";
				
				administrador = fachada.pesquisarAdministrador(administrador);
				String senhaNova= CriptografiaSenha.encriptar(request.getParameter("senhaNova"));
				String confirmarSenha = CriptografiaSenha.encriptar(request.getParameter("confirmarSenha"));
				String senhaAtual = CriptografiaSenha.encriptar(request.getParameter("senhaAtual"));
				String senhaBanco = administrador.getSenha();
				
				if(senhaAtual.equals(senhaBanco)&&senhaNova.equals(confirmarSenha)){
					administrador.setSenha(confirmarSenha);
					fachada.alterarAdministrador(administrador);
					
					mensagem = "Senha editada com sucesso!";
				}else{
					mensagem = "Sua Senha não foi alterada, por favor tente novamente.";
				}
				request.setAttribute("mensagem",mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editarSenhaAdministrador.jsp");
				dispatcher.forward(request, response);
						
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
