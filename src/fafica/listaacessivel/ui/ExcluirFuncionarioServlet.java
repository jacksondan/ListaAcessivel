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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

/**
 * Servlet implementation class ExcluirFuncionarioServlet
 */
@WebServlet("/ExcluirFuncionarioServlet")
public class ExcluirFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirFuncionarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");

		if (estabelecimento == null) {
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_funcionario = Integer.parseInt(request.getParameter("id_funcionario"));
				Funcionario funcionario = new Funcionario();
				funcionario.setId_usuario(id_funcionario);
				
				fachada.excluirFuncionario(funcionario);
				
				String mensagem = "Funcionario Excluido!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("ListarFuncionariosServlet");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
