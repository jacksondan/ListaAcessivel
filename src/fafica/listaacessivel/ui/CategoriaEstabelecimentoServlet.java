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
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class CategoriaEstabelecimentoServlet
 */
@WebServlet("/CategoriaEstabelecimentoServlet")
public class CategoriaEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaEstabelecimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("acessoCliente");
		if(cliente == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			try {
				String categoria = request.getParameter("categoria");
				IFachada fachada = Fachada.getInstance();
				
				String bairro = request.getParameter("selecionarPorBairro");
				boolean selecionarPorBairro = false;
				
				if(bairro != null){
					selecionarPorBairro = true;
				}
							
				List<Estabelecimento> listaEstabelecimentos = new ArrayList<Estabelecimento>();
				
				cliente = fachada.pesquisarCliente(cliente);
								
				listaEstabelecimentos = fachada.listarEstabelecimentoPorRegiao(categoria, cliente, selecionarPorBairro);
				
				request.setAttribute("listaEstabelecimentos", listaEstabelecimentos);
				request.setAttribute("editarCliente", cliente);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso02.jsp");
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
