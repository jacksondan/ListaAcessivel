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
import fafica.listaacessivel.negocios.util.SituacaoLista;

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
					if(categoria_produto.equals("nao selecionada")){
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
				
				
				//Regra de negocio começa AQUI
				
				List<Produto> produtosSelecionados = produtosSelecionados(selecaoProdutos, selecaoIdProduto, selecaoQuantidade);
				List<Produto> listaProdutos = fachada.listarProdutosPorEstababelecimento(estabelecimento, categoria_produto, descricao_produto);
				List<Produto> produtosSelecionadosPesquisa = null;
				List<Produto> auxNaoSelecionado = null;
				//List<Produto> auxSelecionados = null;
				List<Produto> auxRemocao = null;
				
				if(pesquisa != null){    //if para verificar se o botão pesquisa foi precionado.
					
					if(categoria_produto == null && descricao_produto == null){ //Pesquisa sem filtro
						
						//Inicio aqui
						if(listaProdutos == null){
							listaProdutos = new ArrayList<Produto>();
																				System.err.println("A LISTA DE PRODUTOS ESTA VAZIA");
						}
						if(produtosSelecionados == null){
							produtosSelecionados = new ArrayList<Produto>();
																				System.err.println("NÃO HÁ PRODUTOS SELECIONADOS");
						}
						if(selecaoIdProduto == null){
							selecaoIdProduto = new String[0];
						}
																				System.err.println("produtosSelecionados: "+produtosSelecionados.size());												
						auxRemocao = new ArrayList<Produto>();
						for(Produto produto : produtosSelecionados){
																				System.err.println("PRIMEIRO FOR");
							for(Produto aux : produtosSession){
								if(produto.getId_produto() == aux.getId_produto()){
																				System.err.println("SEGUNDO FOR");
									auxRemocao.add(aux);
								}
							}
						}
						
						produtosSession.removeAll(auxRemocao);
																				System.err.println("produtosSelecionados: "+produtosSelecionados.size());
						produtosSession.addAll(produtosSelecionados);
																				System.err.println("produtosSession: "+produtosSession.size());
						
																				System.err.println("produtosSelecionados: "+produtosSelecionados.size());
						
						
						auxRemocao = new ArrayList<Produto>();
						auxNaoSelecionado = produtosNaoSelecionados(selecaoIdProduto, produtosSelecionados);
						for(Produto produto : produtosSession){
																				System.err.println("TERCEIRO FOR");
							for(Produto aux : auxNaoSelecionado){
																				System.err.println("QUARTO FOR");
								if(produto.getId_produto() == aux.getId_produto()){
									auxRemocao.add(produto);
								}
							}
						}
																				System.err.println("produtosSession: "+produtosSession.size());
						produtosSession.removeAll(auxRemocao);
																				System.err.println("produtosSession: "+produtosSession.size());
						
						/*
						 
						 */
						
						//**************************************************
																				
						auxRemocao = new ArrayList<Produto>();
						for(Produto produto : listaProdutos){
							for(Produto aux : produtosSession){
								if(produto.getId_produto() == aux.getId_produto()){
									auxRemocao.add(produto);
								}
							}
						}
						listaProdutos.removeAll(auxRemocao);
						produtosSelecionados = produtosSession;

						request.setAttribute("produtosSelecionados", produtosSelecionados);
						request.setAttribute("listaProdutos", listaProdutos);
						request.setAttribute("descricao", descricao);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso03.jsp");
						requestDispatcher.forward(request, response);
						//**************************************************
						
					}else {  //Pesquisa com filtros
						
						if(listaProdutos == null){
							listaProdutos = new ArrayList<Produto>();
						}
						if(produtosSelecionados == null){
							produtosSelecionados = new ArrayList<Produto>();
						}
						if(selecaoIdProduto == null){
							selecaoIdProduto = new String[0];
						}
						
						auxRemocao = new ArrayList<Produto>();
						for(Produto produto : produtosSelecionados){
																				System.err.println("PRIMEIRO FOR");
							for(Produto aux : produtosSession){
								if(produto.getId_produto() == aux.getId_produto()){
																				System.err.println("SEGUNDO FOR");
									auxRemocao.add(aux);
								}
							}
						}
						
						produtosSession.removeAll(auxRemocao);
																				System.err.println("produtosSelecionados: "+produtosSelecionados.size());
						produtosSession.addAll(produtosSelecionados);
																				System.err.println("produtosSession: "+produtosSession.size());
						
																				System.err.println("produtosSelecionados: "+produtosSelecionados.size());
						
						
						auxRemocao = new ArrayList<Produto>();
						auxNaoSelecionado = produtosNaoSelecionados(selecaoIdProduto, produtosSelecionados);
						for(Produto produto : produtosSession){
																				System.err.println("TERCEIRO FOR");
							for(Produto aux : auxNaoSelecionado){
																				System.err.println("QUARTO FOR");
								if(produto.getId_produto() == aux.getId_produto()){
									auxRemocao.add(produto);
								}
							}
						}
																				System.err.println("produtosSession: "+produtosSession.size());
						produtosSession.removeAll(auxRemocao);
																				System.err.println("produtosSession: "+produtosSession.size());
						
						//***********************************************
						auxRemocao = new ArrayList<Produto>();
						produtosSelecionadosPesquisa = new ArrayList<Produto>();
						for(Produto produto : listaProdutos){
							for(Produto aux : produtosSession){
								if(produto.getId_produto() == aux.getId_produto()){
									produtosSelecionadosPesquisa.add(aux);
									auxRemocao.add(produto);
								}
							}
						}
						listaProdutos.removeAll(auxRemocao);
						
						request.setAttribute("produtosSelecionadosPesquisa", produtosSelecionadosPesquisa);
						request.setAttribute("listaProdutos", listaProdutos);
						request.setAttribute("descricao", descricao);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso03.jsp");
						requestDispatcher.forward(request, response);
						//**********************************************
					}
					
					
					
					
					
				}else{ //else para finalizar a Lista
					
					if(listaProdutos == null){
						listaProdutos = new ArrayList<Produto>();
																			System.err.println("A LISTA DE PRODUTOS ESTA VAZIA");
					}
					if(produtosSelecionados == null){
						produtosSelecionados = new ArrayList<Produto>();
																			System.err.println("NÃO HÁ PRODUTOS SELECIONADOS");
					}
					if(selecaoIdProduto == null){
						selecaoIdProduto = new String[0];
					}
					
					auxRemocao = new ArrayList<Produto>();
					for(Produto produto : produtosSelecionados){
																			System.err.println("PRIMEIRO FOR");
						for(Produto aux : produtosSession){
							if(produto.getId_produto() == aux.getId_produto()){
																			System.err.println("SEGUNDO FOR");
								auxRemocao.add(aux);
							}
						}
					}
					
					produtosSession.removeAll(auxRemocao);
																			System.err.println("produtosSelecionados: "+produtosSelecionados.size());
					produtosSession.addAll(produtosSelecionados);
																			System.err.println("produtosSession: "+produtosSession.size());
					
																			System.err.println("produtosSelecionados: "+produtosSelecionados.size());
																			
					/*
					 	auxRemocao = new ArrayList<Produto>();
						auxNaoSelecionado = produtosNaoSelecionados(selecaoIdProduto, produtosSelecionados);
						for(Produto produto : produtosSession){
																				System.err.println("TERCEIRO FOR");
							for(Produto aux : auxNaoSelecionado){
																				System.err.println("QUARTO FOR");
								if(produto.getId_produto() == aux.getId_produto()){
									auxRemocao.add(produto);
								}
							}
						}
																				System.err.println("produtosSession: "+produtosSession.size());
						produtosSession.removeAll(auxRemocao);
																				System.err.println("produtosSession: "+produtosSession.size());
					 */
					
					
					auxRemocao = new ArrayList<Produto>();
					auxNaoSelecionado = produtosNaoSelecionados(selecaoIdProduto, produtosSelecionados);
					for(Produto produto : produtosSession){
																			System.err.println("TERCEIRO FOR");
						for(Produto aux : auxNaoSelecionado){
																			System.err.println("QUARTO FOR");
							if(produto.getId_produto() == aux.getId_produto()){
								auxRemocao.add(produto);
							}
						}
					}
																			System.err.println("produtosSession: "+produtosSession.size());
					produtosSession.removeAll(auxRemocao);
																			System.err.println("produtosSession: "+produtosSession.size());
					if(produtosSession.size() > 0){
						lista = new Lista(descricao, SituacaoLista.CRIADA.toString(), cliente, estabelecimento, produtosSession);
						int id_lista = fachada.adicionarLista(lista);
						lista.setId_lista(id_lista);
						
						request.setAttribute("lista",lista);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("detalhesListaCliente.jsp");
						requestDispatcher.forward(request, response);
						
					}else{
						String mensagem = "Lista não pode ser criada sem itens";
						
						request.setAttribute("mensagem",mensagem);
						request.setAttribute("listaProdutos", listaProdutos);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("criarListaPasso03.jsp"); //CriarListaPasso3Servlet
						requestDispatcher.forward(request, response);
						
					}
																		
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
	
	//Metodo que tras os objtos dos produtos selecionados
	private List<Produto> produtosSelecionados(String [] selecaoProdutos, String [] selecaoIdProduto, String [] selecaoQuantidade){
		if(selecaoProdutos != null){
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
			System.err.println("RETORNO DE OBJETOS POSSUI: "+listaProdutos.size()+" OBJETOS");
			return listaProdutos;
		}else{
			System.err.println("RETORNO DE OBJETOS É == NULL");
			return null;
		}
	}
	
	private List<Produto> produtosNaoSelecionados(String [] selecaoIdProduto, List<Produto> produtosSelecionados){
		IFachada fachada;
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			fachada = Fachada.getInstance();

			List<Produto> auxRemove = new ArrayList<Produto>();
		
			for(String id_produto : selecaoIdProduto){
				int i = Integer.parseInt(id_produto);
				Produto produto = new Produto();
				produto.setId_produto(i);
				produto = fachada.pesquisarProduto(produto);
				listaProdutos.add(produto);
				for(Produto aux : produtosSelecionados){
					if(produto.getId_produto() == aux.getId_produto()){
						auxRemove.add(produto);
					}
				}
			}
			
			listaProdutos.removeAll(auxRemove);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return listaProdutos;
		
	}


}

/* if(categoria_produto == null && descricao_produto == null){ //Pesquisa sem filtro
 			if(listaProdutos.size() != selecaoIdProduto.length){
							if(produtosSelecionados == null){
								if(produtosSession.size() != 0){
									auxRemocao = new ArrayList<Produto>();
									for(Produto produto : produtosSession){
										for(String i : selecaoIdProduto){
											int id_produto = Integer.parseInt(i);
											if(produto.getId_produto() == id_produto){
												auxRemocao.add(produto);
											}
										}
									}
									
									produtosSession.removeAll(auxRemocao);
									produtosSelecionados = produtosSession;
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);
								}
								
							}else{
								if(produtosSession.size() == 0){
									produtosSession.addAll(produtosSelecionados);
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);
									
								}else{
									auxRemocao = new ArrayList<Produto>();
									for(Produto produto : produtosSelecionados){
										for(Produto aux : produtosSession){
											if(produto.getId_produto() == aux.getId_produto()){
												auxRemocao.add(produto);
											}
										}
									}
									
									produtosSelecionados.removeAll(auxRemocao);
									produtosSession.addAll(produtosSelecionados);
									
									
									auxRemocao = new ArrayList<Produto>();
									for(Produto produto : produtosSession){
										for(String i : selecaoIdProduto){
											int id_produto = Integer.parseInt(i);
											if(produto.getId_produto() == id_produto){
												auxRemocao.add(produto);
											}
										}
									}
									
									produtosSession.removeAll(auxRemocao);
									produtosSelecionados = produtosSession;
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);									
								}
								
							}
							
							
						}else{
							if(produtosSelecionados == null){
								if(produtosSession.size() != 0){
									produtosSession.removeAll(produtosSession);
								}
									
							}else{
								
								if(produtosSession.size() == 0){
									produtosSession.addAll(produtosSelecionados);
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);
									
								}else{
									
									produtosSession.removeAll(produtosSession);
									produtosSession.addAll(produtosSelecionados);
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);
								}
							}
						
						}
						 
 
  
 */
 
/*
  }else {  //Pesquisa com filtros
						if(listaProdutos != null){
							if(produtosSelecionados != null){
								if(produtosSession.size() != 0){
									
									auxRemocao = new ArrayList<Produto>();
									for(Produto produto : produtosSelecionados){
										for(Produto aux : produtosSession){
											if(produto.getId_produto() == aux.getId_produto()){
												auxRemocao.add(produto);
											}
										}
									}
									
									produtosSelecionados.removeAll(auxRemocao);
									produtosSession.addAll(produtosSelecionados);
									
									
									auxRemocao = new ArrayList<Produto>();
									for(Produto produto : produtosSession){
										for(String i : selecaoIdProduto){
											int id_produto = Integer.parseInt(i);
											if(produto.getId_produto() == id_produto){
												auxRemocao.add(produto);
											}
										}
									}
									
									produtosSession.removeAll(auxRemocao);
									produtosSelecionados = produtosSession;
									listaProdutos = produtosNaoSelecionados(listaProdutos, produtosSelecionados);
									
									
								}else{
									produtosSession.addAll(produtosSelecionados);
								}
							}else{
								if(produtosSession.size() == 0){
									
								}else{
									
								}
							}

						}else{
							listaProdutos = new ArrayList<Produto>();
						}
 */

/* BACKUP DE CODIGO (Metodo post)
 * 
 * 
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
