package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class CadastraPr
 */
@WebServlet("/CadastrarProdutoServlet")
public class CadastrarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		if(estabelecimento == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("cadastroProduto.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(); 
			Estabelecimento estabelecimento = (Estabelecimento)session.getAttribute("acessoEstabelecimento"); // Utilizar pra pegar codigo de Estabelecimento
			if(estabelecimento == null){
				response.sendRedirect("index.jsp");
			}else{
				try {
					IFachada fachada = Fachada.getInstance();
					
					String descricao = request.getParameter("descricao");
					
					String valorString = request.getParameter("valor");
					valorString = valorString.replaceAll(",", ".");
					float valor = Float.parseFloat(valorString);
					
					int quantidade = Integer.parseInt(request.getParameter("quantidade"));
					String categoria = request.getParameter("categoria");
					
					String pesoString = request.getParameter("peso");
					pesoString = pesoString.replaceAll(",", ".");
					float peso = Float.parseFloat(pesoString);
					
					String validade = request.getParameter("validade");
					String marca = request.getParameter("marca");
					String codigo_barra = request.getParameter("codigo_barra");
										
					Produto p = new Produto(descricao,categoria,peso,quantidade,valor,validade,marca,codigo_barra,estabelecimento);
					
					fachada.adicionarProduto(p);
										
					String mensagem = "Produto Cadastrado Com Sucesso";
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoEstabelecimento.jsp");
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

}
