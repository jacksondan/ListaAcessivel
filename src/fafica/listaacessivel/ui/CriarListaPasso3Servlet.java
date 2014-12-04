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
				
				String categoria_produto = request.getParameter("categoria");
				String descricao_produto = request.getParameter("buscanome");
				
				if(categoria_produto != null){
					if(categoria_produto.equals("")){
						categoria_produto = null;
					}
				}
				
				if(descricao_produto != null)
					if(descricao_produto.equals("")){
						descricao_produto = null;
					}
				
				List<Produto> listaprodutos = fachada.listarProdutosPorEstababelecimento(estabelecimento, categoria_produto, descricao_produto);
				
				request.setAttribute("listaprodutos",listaprodutos);
				request.setAttribute("estabelecimento", estabelecimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso03.jsp");
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
				String [] selecaoIdProduto = request.getParameterValues("id_produto");
				String [] selecaoQuantidade = request.getParameterValues("quantidade");
				String [] quantidadesListadas = null;
				
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				String descricao = request.getParameter("descricaolista");
				
				if(descricao == null){
					descricao = "";
				}
				
				if(selecaoProdutos != null){
					
					quantidadesListadas = new String[selecaoProdutos.length];
					
					for(int i=0; i < selecaoProdutos.length; i++){
						System.out.println("Produto: " +selecaoProdutos[i]);
						for(int e=0; e < selecaoIdProduto.length; e++){
							if(selecaoProdutos[i].equals(selecaoIdProduto[e])){
								quantidadesListadas[i] = selecaoQuantidade[e];
								System.out.println("Quantidade Atribuida: " +quantidadesListadas[i]);
								break;
							}
						}
					}
				
				
					List <Produto> listaProdutos = null;
					for(int i = 0; i < selecaoProdutos.length; i++){
						if(listaProdutos == null){
							listaProdutos = new ArrayList<Produto>();
						}
						int id_produto = Integer.parseInt(selecaoProdutos[i]);
						int quantidade = Integer.parseInt(quantidadesListadas[i]);
						
						Produto produto = new Produto();
						produto.setId_produto(id_produto);
						produto = fachada.pesquisarProduto(produto);
						
						produto.setQuantidade(quantidade);
						
						listaProdutos.add(produto);
					}
					
					if(listaProdutos != null){
						Lista lista = new Lista(descricao, Situacao.CRIADA.toString(), cliente, estabelecimento, listaProdutos);
						int id_lista = fachada.adicionarLista(lista);
						lista.setId_lista(id_lista);
						
						lista = fachada.pesquisarLista(lista);
						
						request.setAttribute("lista",lista);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("detalhesListaCliente.jsp");
						requestDispatcher.forward(request, response);
						
						//response.sendRedirect("visaoCliente.jsp"); // Teste
					}else{
						
						String mensagem = "Lista n�o pode ser criada sem itens";
						
						request.setAttribute("mensagem",mensagem);
						request.setAttribute("id_estabelecimento",estabelecimento.getId_estabelecimento());
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoCliente.jsp");
						requestDispatcher.forward(request, response);
					}
				}else{
					String mensagem = "Lista n�o pode ser criada sem itens";
					
					request.setAttribute("mensagem",mensagem);
					request.setAttribute("id_estabelecimento",estabelecimento.getId_estabelecimento());
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoCliente.jsp"); //CriarListaPasso3Servlet
					requestDispatcher.forward(request, response);
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
