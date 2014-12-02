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
 * Servlet implementation class CriarListaPasso2Servlet
 */
@WebServlet("/CriarListaPasso2Servlet")
public class CriarListaPasso2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				IFachada fachada = Fachada.getInstance();
				
				String categoria=request.getParameter("categoria");
				String filtragem = request.getParameter("filtragem");
				String filtroContrario = null;
				boolean selecionarPorBairro = false;
				
				if(filtragem == null){
					filtroContrario="Bairro";
					filtragem="Cidade"; 
				}else if(filtragem.equals("Bairro")){
					filtroContrario="Cidade";
					selecionarPorBairro = true;
				}else{
					filtroContrario = "Bairro";
				}
				List<Estabelecimento> listaEstabelecimentos = new ArrayList<Estabelecimento>();
			
				cliente = fachada.pesquisarCliente(cliente);
								
				listaEstabelecimentos = fachada.listarEstabelecimentoPorRegiao(categoria, cliente, selecionarPorBairro);
				
				request.setAttribute("listaEstabelecimentos", listaEstabelecimentos);
				
				request.setAttribute("filtroContrario",filtroContrario);
				request.setAttribute("categoria",categoria);
				request.setAttribute("filtragem",filtragem);
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
		// TODO Auto-generated method stub
	}

}
