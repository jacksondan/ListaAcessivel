package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class EditarProduto
 */
@WebServlet("/EditarProdutoServlet")
public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id_produto = Integer.parseInt(request.getParameter("id_produto"));
			Produto produto = new Produto();
			produto.setId_produto(id_produto);
			try {
				IFachada fachada = Fachada.getInstance();
				produto = fachada.pesquisarProduto(produto);
				
				request.setAttribute("editarProduto", produto);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarProduto.jsp");
				requestDispatcher.forward(request, response);
				
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
		
		try {
			fachada = Fachada.getInstance();
			
			int id_produto = Integer.parseInt(request.getParameter("id_produto"));
			String descricao = request.getParameter("descricao");
			String categoria = request.getParameter("categoria");
			float peso = Float.parseFloat(request.getParameter("peso"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			
			String valorInicial = request.getParameter("valor");
			valorInicial = valorInicial.replaceAll(",", ".");
			float valor = Float.parseFloat(valorInicial);
			
			String validade = request.getParameter("validade");
			String marca = request.getParameter("marca");
			String codigo_de_barra = request.getParameter("codigo_de_barra");
			String disponibilidade = request.getParameter("disponibilidade");
			
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setId_estabelecimento(Integer.parseInt(request.getParameter("id_estabelecimento")));
			
			Produto produto = new Produto(id_produto,descricao,categoria,peso,quantidade,valor,validade,marca,codigo_de_barra,disponibilidade,estabelecimento);
			
			fachada.alterarProduto(produto);
			
			response.sendRedirect("ListarProdutosServlet");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
