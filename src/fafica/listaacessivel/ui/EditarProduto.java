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
 * Servlet implementation class EditarProduto
 */
@WebServlet("/EditarProduto")
public class EditarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProduto() {
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
			
			for(Produto p : lista_produto){
				if(p.getId_produto() == id_produto){
					Produto produto = fachada.pesquisarProduto(p);
					request.setAttribute("produto", produto);

				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("editarProduto.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			fachada = Fachada.getInstance();
			
			String descricao_produto = request.getParameter("descricao");
			String categoria = request.getParameter("categoria");
			String peso_produto = request.getParameter("peso");
			//int quantidade_produto = Integer.parseInt(request.getParameter("quantidade"));
			int quantidade_produto=787;
			float preco_produto = Float.parseFloat(request.getParameter("preco"));
			String validade_produto = request.getParameter("validade");
			String marca_produto = request.getParameter("marca");
			String codigo_de_barra = request.getParameter("codigo_barra");
			int id_estabelecimento = 0;
			
			Produto produto = new Produto(descricao_produto,categoria,peso_produto,quantidade_produto,preco_produto,validade_produto,marca_produto,codigo_de_barra,id_estabelecimento);
			
			fachada.alterarProduto(produto);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/listarProdutos.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
