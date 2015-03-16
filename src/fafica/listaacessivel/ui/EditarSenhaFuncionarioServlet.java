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
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.ui.util.CriptografiaSenha;

/**
 * Servlet implementation class EditarSenhaFuncionarioServlet
 */
@WebServlet("/EditarSenhaFuncionarioServlet")
public class EditarSenhaFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSenhaFuncionarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		if(funcionario==null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("editarSenhaFuncionario.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		if(funcionario==null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				String mensagem="";
				
				String senhaNova= CriptografiaSenha.encriptar(request.getParameter("senhaNova"));
				String confirmarSenha = CriptografiaSenha.encriptar(request.getParameter("confirmarSenha"));
				String senhaAtual = CriptografiaSenha.encriptar(request.getParameter("senhaAtual"));
				String senhaBanco = funcionario.getSenha();
				
				if(senhaNova != null && confirmarSenha != null){
					if(senhaAtual.equals(senhaBanco)&&senhaNova.equals(confirmarSenha)){
						funcionario.setSenha(confirmarSenha);
						fachada.alterarFuncionario(funcionario);
						
						mensagem = "Senha editada com sucesso!";
					}else{
						mensagem = "Sua Senha não foi alterada, por favor tente novamente.";
					}
				}	
				request.setAttribute("mensagem",mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editarSenhaFuncionario.jsp");
				dispatcher.forward(request, response);
						
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}
