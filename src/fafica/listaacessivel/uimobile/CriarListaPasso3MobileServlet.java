package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class CriarListaPasso3MobileServlet
 */
@WebServlet("/CriarListaPasso3MobileServlet")
public class CriarListaPasso3MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Lista lista;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso3MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonLista = request.getParameter("jsonLista");
		int id_lista;
		
		try {
			fachada = Fachada.getInstance();
			
			gson = new Gson();
			lista = gson.fromJson(jsonLista, Lista.class);
			
			id_lista = fachada.adicionarLista(lista);
			
			PrintWriter out = response.getWriter();
			out.println(id_lista);
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
