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

/**
 * Servlet implementation class ExcluirEstabelecimento
 */
@WebServlet("/ExcluirEstabelecimentoServlet")
public class ExcluirEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirEstabelecimentoServlet() {
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
			String mensagem = "Sessão expirada!!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				
				fachada.excluirEstabelecimento(estabelecimento);
						
				String mensagem = "Estabelecimento excluido!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ListarEstabelecimentoServlet");
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
		//request.getParameter("id");
		
		
		
	}

}
