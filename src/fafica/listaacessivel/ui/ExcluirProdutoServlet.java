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

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class ExcluirProduto
 */
@WebServlet("/ExcluirProduto")
public class ExcluirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Produto> lista_produto = new ArrayList<Produto>();
			fachada = Fachada.getInstance();
			
			int id_produto = Integer.parseInt(request.getParameter("id_produto"));
					
			lista_produto = fachada.listarProduto();
			
			for(Produto produto : lista_produto){
				if(produto.getId_produto() == id_produto){
					fachada.excluirProduto(produto);
				}
			}
						
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
