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
					
					String valorInicial = request.getParameter("valor");
					valorInicial = valorInicial.replaceAll(",", ".");
					float valor = Float.parseFloat(valorInicial);
					
					int quantidade = Integer.parseInt(request.getParameter("quantidade"));
					String categoria = request.getParameter("categoria");
					float peso = Float.parseFloat(request.getParameter("peso"));
					String validade = "01/05/2014";
					String marca = "Beta";
					String codigo_de_barra = "0000";
										
					Produto p = new Produto(descricao,categoria,peso,quantidade,valor,validade,marca,codigo_de_barra,estabelecimento);
					
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
