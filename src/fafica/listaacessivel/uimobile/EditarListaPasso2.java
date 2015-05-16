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
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class EditarListaPasso2
 */
@WebServlet("/EditarListaPasso2")
public class EditarListaPasso2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Lista lista;
	private List<Produto> produtosNaoSelecionados;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarListaPasso2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_lista = Integer.parseInt(request.getParameter("id_lista"));
		String jsonProdutosNaoSelecionados;
		
		try {
			fachada = Fachada.getInstance();
			
			lista = new Lista();
			lista.setId_lista(id_lista);
			lista = fachada.pesquisarLista(lista);
			
			produtosNaoSelecionados = fachada.listarProdutosNaoSelecionado(lista, null, null);
			
			gson = new Gson();
			jsonProdutosNaoSelecionados = gson.toJson(produtosNaoSelecionados);
			
			PrintWriter out = response.getWriter();
			out.println(jsonProdutosNaoSelecionados);
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
