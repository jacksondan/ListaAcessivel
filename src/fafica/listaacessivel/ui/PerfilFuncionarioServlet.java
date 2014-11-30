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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

/**
 * Servlet implementation class PerfilFuncionarioServlet
 */
@WebServlet("/PerfilFuncionarioServlet")
public class PerfilFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilFuncionarioServlet() {
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
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");

		if (estabelecimento == null && funcionario == null) {
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else if(estabelecimento != null && funcionario == null){
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_funcionario = Integer.parseInt(request.getParameter("id_funcionario"));
				funcionario = new Funcionario();
				funcionario.setId_usuario(id_funcionario);
				funcionario = fachada.pesquisarFuncionario(funcionario);

				request.setAttribute("funcionario", funcionario);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("detalhesFuncionario.jsp");
				requestDispatcher.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(estabelecimento == null && funcionario != null){
			try {
				IFachada fachada = Fachada.getInstance();
				
				funcionario = fachada.pesquisarFuncionario(funcionario);

				request.setAttribute("funcionario", funcionario);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("perfilFuncionario.jsp");
				requestDispatcher.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
