package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

/**
 * Servlet implementation class CadastrarClienteMobileServlet
 */
@WebServlet("/CadastrarClienteMobileServlet")
public class CadastrarClienteMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Cliente cliente;
	private Gson gson;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarClienteMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json_cadastro = request.getParameter("json_cadastro");
		String senha;
		
		try {
			fachada = Fachada.getInstance();
			
			if(json_cadastro != null){
				gson = new Gson();
				System.out.println(json_cadastro);
				cliente = gson.fromJson(json_cadastro, Cliente.class);
				senha = CriptografiaSenha.encriptar(cliente.getSenha());
				cliente.setSenha(senha);
				
				
				fachada.adicionarCliente(cliente);
			}
			
			
			
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
