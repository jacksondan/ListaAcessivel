package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

/**
 * Servlet implementation class VisaoAdministradorServlet
 */
@WebServlet("/VisaoAdministradorServlet")
public class VisaoAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisaoAdministradorServlet() {
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
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				List<Cliente> listaClientes = fachada.listarCliente();
				List<Estabelecimento> listaEstabelecimentos = fachada.listarEstabelecimento();
				List<Funcionario> listaFuncionarios = fachada.listarFuncionario();
				
				if(listaClientes == null){
					listaClientes = new ArrayList<Cliente>();
				}
				if(listaEstabelecimentos == null){
					listaEstabelecimentos = new ArrayList<Estabelecimento>();
				}
				if(listaFuncionarios == null){
					listaFuncionarios = new ArrayList<Funcionario>();
				}
				
				int numCliente = listaClientes.size();
				int numEstabelecimento = listaEstabelecimentos.size();
				int numFuncionario = listaFuncionarios.size();
				
				request.setAttribute("listaClientes", numCliente);
				request.setAttribute("listaEstabelecimentos", numEstabelecimento);
				request.setAttribute("listaFuncionarios", numFuncionario);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoAdministrador.jsp");
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
		// TODO Auto-generated method stub
	}

}
