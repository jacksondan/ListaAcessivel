package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class EditarSenhaEstabelecimentoServlet
 */
@WebServlet("/EditarSenhaEstabelecimentoServlet")
public class EditarSenhaEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSenhaEstabelecimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		if(estabelecimento==null){
			response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				  
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
		// TODO Auto-generated method stub
	}

}
