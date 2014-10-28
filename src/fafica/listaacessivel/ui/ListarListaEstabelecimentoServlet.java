package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class ListarListaEstabelecimentoServlet
 */
@WebServlet("/ListarListaEstabelecimentoServlet")
public class ListarListaEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarListaEstabelecimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento)session.getAttribute("acessoEstabelecimento");
		Estabelecimento pesquisa = new Estabelecimento();
		
		IFachada fachada;
		
		if(estabelecimento == null){
			response.sendRedirect("index.jsp");
		}else{
			try {
				fachada = Fachada.getInstance();
				pesquisa = fachada.pesquisarEstabelecimento(estabelecimento);
				List<Lista> listas = fachada.listarListasDoEstabelecimento(pesquisa);
				
				request.setAttribute("listasDoEstabelecimento", listas);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoEs.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}

}
