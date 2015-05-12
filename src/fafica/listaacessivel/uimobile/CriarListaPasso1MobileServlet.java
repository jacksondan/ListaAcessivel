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
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class CriarListaPasso1MobileServlet
 */
@WebServlet("/CriarListaPasso1MobileServlet")
public class CriarListaPasso1MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Cliente cliente;
	private List<Estabelecimento> estabelecimentos;
	private Gson gson;
	private String jsonEstabelecimentos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso1MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria = request.getParameter("categoria");
		String id = request.getParameter("id_cliente");
		int id_cliente = 0;
		
		if(id != null){
			id_cliente = Integer.parseInt(id);
		}
		
		try {
			fachada = Fachada.getInstance();
			
			cliente = new Cliente();
			cliente.setId_usuario(id_cliente);
			cliente = fachada.pesquisarCliente(cliente);
			
			estabelecimentos = fachada.listarEstabelecimentoPorRegiao(categoria, cliente, false);
			
			gson = new Gson();
			jsonEstabelecimentos = gson.toJson(estabelecimentos);
			
			PrintWriter out = response.getWriter();
			out.println(jsonEstabelecimentos);
			
			
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
