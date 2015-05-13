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
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class MinhasListasMobileServlet
 */
@WebServlet("/MinhasListasMobileServlet")
public class MinhasListasMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private List<Lista> listas;
	private Cliente cliente;
	private String jsonListas;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinhasListasMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		
		try {
			fachada = Fachada.getInstance();
			
			cliente = new Cliente();
			cliente.setId_usuario(id_cliente);
			cliente = fachada.pesquisarCliente(cliente);
			
			listas = fachada.listarListaPorCliente(cliente);
			
			Lista l = listas.get(0);
			System.out.println("Nome Cliente: "+l.getCliente().getNome());
			System.out.println("Nome Estabelecimento: "+l.getEstabelecimento().getNome_fantasia());
			System.out.println("Quantidade de Produtos: "+l.getProdutos().size());
			System.out.println(l.getId_lista());
			System.out.println(l.getDescricao());
			System.out.println(l.getSituacao());
			System.out.println(l.getData_criacao());
			l.setData_alteracao("13/5/2015");
			System.out.println(l.getData_alteracao());
			System.out.println(l.getQuantidade_total());
			System.out.println(l.getValor_total());
//			l.setCliente(null);
//			l.setEstabelecimento(null);
//			l.setProdutos(null);
//			l.setValor_total(0);
			
			gson = new Gson();
			jsonListas = gson.toJson(l);
			
			System.out.println(jsonListas);
			
			PrintWriter out = response.getWriter();
			out.println(jsonListas);
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
