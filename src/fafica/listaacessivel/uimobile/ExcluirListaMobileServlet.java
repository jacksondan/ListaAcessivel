package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class ExcluirListaMobileServlet
 */
@WebServlet("/ExcluirListaMobileServlet")
public class ExcluirListaMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Lista lista;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirListaMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_lista = Integer.parseInt(request.getParameter("id_lista"));
		
		try {
			fachada = Fachada.getInstance();
			
			lista = new Lista();
			lista.setId_lista(id_lista);
			
			lista = fachada.pesquisarLista(lista);
			
			fachada.excluirLista(lista);		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
