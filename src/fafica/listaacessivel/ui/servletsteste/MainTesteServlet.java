package fafica.listaacessivel.ui.servletsteste;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.entidades.Produto;

/**
 * Servlet implementation class MainTesteServlet
 */
@WebServlet("/MainTesteServlet")
public class MainTesteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainTesteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			
			
			List <Produto> produtos;
			produtos = new ArrayList<Produto>();
			
			Produto produto = new Produto();
			produto.setId_produto(1);
			
			produto = fachada.pesquisarProduto(produto);
			System.out.println("Produto com nome: "+produto.getDescricao());
			System.out.println("Quantidade do produto: "+produto.getQuantidade());
			System.out.println("Valor do produto: "+produto.getValor());
			
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setId_estabelecimento(1);
			
			estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
			System.out.println("Estabelecimento com nome: "+estabelecimento.getNome_fantasia());
			
			Cliente cliente = new Cliente();
			cliente.setId_usuario(1);
			
			cliente = fachada.pesquisarCliente(cliente);
			System.out.println("Cliente com nome: "+cliente.getNome());
			
			produtos.add(produto);
			
			Lista lista = new Lista("Lista Teste", "iniciada", cliente, estabelecimento, produtos);
		
			fachada.adicionarLista(lista);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
