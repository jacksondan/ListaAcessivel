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
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;
import fafica.listaacessivel.ui.util.Situacao;

/**
 * Servlet implementation class CriarListaPasso3Servlet
 */
@WebServlet("/CriarListaPasso3Servlet")
public class CriarListaPasso3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso3Servlet() {
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
				
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				Estabelecimento estabelecimento= new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				int id_estabelecimentoTeste = Integer.parseInt(request.getParameter("id_estabelecimento"));
				String [] selecaoProdutosTeste = request.getParameterValues("selecionado");
				String [] selecaoQuantidadeTeste = request.getParameterValues("quantidade");
				String produto = request.getParameter("selecionado");
				String quantidade = request.getParameter("quantidade");
				
				System.out.println("Id do Estabelecimento: " +id_estabelecimentoTeste );
				System.out.println("Id do Produto simples: " +produto);
				System.out.println("Quantidade simples: " +quantidade);
				
				if(selecaoProdutosTeste != null){
					for(int i = 0; i < selecaoProdutosTeste.length; i++){
						System.out.println("Id do Produto FOR: " +selecaoProdutosTeste[i]);
					}
				}
				
				if(selecaoQuantidadeTeste != null){
					for(int i = 0; i < selecaoQuantidadeTeste.length; i++){
						System.out.println("Quantidade FOR: " +selecaoQuantidadeTeste[i]);
					}
				}
				
				List<Produto> listaprodutos = fachada.listarProdutosPorEstababelecimento(estabelecimento);
				
				request.setAttribute("listaprodutos",listaprodutos);
				request.setAttribute("estabelecimento", estabelecimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso03Teste.jsp");
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
				
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				String [] selecaoProdutos = request.getParameterValues("selecionado");
				String [] selecaoQuantidade = request.getParameterValues("quantidade");
				
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				List <Produto> listaProdutos = null;
				for(int i = 0; i < selecaoProdutos.length; i++){
					if(listaProdutos == null){
						listaProdutos = new ArrayList<Produto>();
					}
					int id_produto = Integer.parseInt(selecaoProdutos[i]);
					int quantidade = Integer.parseInt(selecaoQuantidade[i]);
					
					Produto produto = new Produto();
					produto.setId_produto(id_produto);
					produto = fachada.pesquisarProduto(produto);
					
					produto.setQuantidade(quantidade);
					
					listaProdutos.add(produto);
				}
				
				if(listaProdutos != null){
					Lista lista = new Lista("", Situacao.CRIADA.toString(), cliente, estabelecimento, listaProdutos);
					fachada.adicionarLista(lista);
					
					response.sendRedirect("visaoCliente.jsp"); // Teste
				}else{
					response.sendRedirect("LogoutServlet"); // Teste
				}
				
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
