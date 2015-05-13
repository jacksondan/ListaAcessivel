package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class CriarListaPasso3MobileServlet
 */
@WebServlet("/CriarListaPasso2MobileServlet")
public class CriarListaPasso2MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Estabelecimento estabelecimento;
	private List<Produto> produtos;
	private String json;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso2MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_estabelecimento");
		int id_estabelecimento = 0;
		try {
			fachada = Fachada.getInstance();
			
			if(id != null){
				id_estabelecimento = Integer.parseInt(id);
			}
			estabelecimento= new Estabelecimento();
			estabelecimento.setId_estabelecimento(id_estabelecimento);
			estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
			
			produtos = fachada.listarProdutosPorEstababelecimento(estabelecimento, null, null);
			
			//Comversão para String json
			gson = new Gson();
			json = gson.toJson(produtos);
			System.out.println(json);
			
			PrintWriter out = response.getWriter();
			out.println(json);
			
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
