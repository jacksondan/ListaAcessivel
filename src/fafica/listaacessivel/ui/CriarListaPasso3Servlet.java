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
	
	private Cliente cliente;
	private Estabelecimento estabelecimento;
	private Lista lista;
	private List<Produto> produtosSession;
       
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
		cliente = (Cliente) session.getAttribute("acessoCliente");
		
		if(cliente == null){
			String mensagem = "SessÃ£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				estabelecimento= new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				session.setAttribute("estabelecimentoSession", estabelecimento);
				
				produtosSession = new ArrayList<Produto>();
				session.setAttribute("produtosSession", produtosSession);
				
				List<Produto> listaProdutos = fachada.listarProdutosPorEstababelecimento(estabelecimento, null, null);
				
				request.setAttribute("listaProdutos", listaProdutos);
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
		cliente = (Cliente) session.getAttribute("acessoCliente");
		estabelecimento = (Estabelecimento) session.getAttribute("estabelecimentoSession");
		produtosSession = (ArrayList<Produto>) session.getAttribute("produtosSession");
		
		if(cliente == null){
			String mensagem = "SessÃ£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				/*
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				*/
				
				
				//Pegando informações do formulario;
				String categoria_produto = request.getParameter("categoria");
				String descricao_produto = request.getParameter("buscanome");
				String descricao = request.getParameter("descricaolista");
				String pesquisa = request.getParameter("pesquisa");
				
				String [] selecaoProdutos = request.getParameterValues("selecionado");
				String [] selecaoIdProduto = request.getParameterValues("id_produto");
				String [] selecaoQuantidade = request.getParameterValues("quantidade");
				
				//Análise inicial dos dados obtidos 
				if(categoria_produto != null){
					if(categoria_produto.equals("não selecionada")){
						categoria_produto = null;
					}
				}
				
				if(descricao_produto != null)
					if(descricao_produto.equals("")){
						descricao_produto = null;
				}
				
				if(descricao == null){
					descricao = "";
				}
				
				
				//Regra de negocio
				
				if(pesquisa.equals("true")){
					List<Produto> produtosSelecionados = null;
					List<Produto> produtosSelecionadosPesquisa = null;
					List<Produto> listaProdutos = null;
					String testeFiltro = "Para fazer fdsfdsa";
					
					if(categoria_produto == null && descricao_produto == null){
						if(true){
							
						}
						
					}else {
						
					}
					
					
					
					
					
				}else{
					
				}
				
				
				
				
				/*
				if(selecaoProdutos != null){
					
					String [] quantidadesListadas = null;
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
						
						String mensagem = "Lista não pode ser criada sem itens";
						
						request.setAttribute("mensagem",mensagem);
						request.setAttribute("id_estabelecimento",estabelecimento.getId_estabelecimento());
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoCliente.jsp");
						requestDispatcher.forward(request, response);
					}
				}else{
					String mensagem = "Lista não pode ser criada sem itens";
					
					request.setAttribute("mensagem",mensagem);
					//request.setAttribute("id_estabelecimento",estabelecimento.getId_estabelecimento());
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoCliente.jsp"); //CriarListaPasso3Servlet
					requestDispatcher.forward(request, response);
				}
				*/
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private List<Produto> produtosSelecionados(String [] selecaoProdutos, String [] selecaoIdProduto, String [] selecaoQuantidade){
		
		IFachada fachada;
		List <Produto> listaProdutos = null;
		try {
			fachada = Fachada.getInstance();
		
			String [] quantidadesListadas = null;
			
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
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaProdutos;
		
	}

}
