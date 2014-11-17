package fafica.listaacessivel.ui.testes;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class TesteAdicionarProduto
 */
@WebServlet("/TesteAdicionarProduto")
public class TesteAdicionarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteAdicionarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Estabelecimento estabelecimento = new Estabelecimento();
		
		String descricao = "Leite Itambe";
		String categoria = "Alimento";
		float peso = 1.0f;
		int quantidade = 30;
		float valor = 5.0f;
		String validade = "20/10/2024";
		String marca = "Itambe";
		String codigo_barra = "555555";
	//	String disponibilidade = "disponível";
		estabelecimento.setId_estabelecimento(1);
		
		Produto produto = new Produto(descricao, categoria, peso, quantidade, valor, validade, marca, codigo_barra, estabelecimento);
		
		
		try {
			IFachada fachada = Fachada.getInstance();
			fachada.adicionarProduto(produto);
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
