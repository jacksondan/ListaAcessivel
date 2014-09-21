package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/CadastraPr")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			HttpSession session = request.getSession(); 
			Estabelecimento estabelecimento = (Estabelecimento)session.getAttribute("acessoEstabelecimento"); // Utilizar pra pegar codigo de Estabelecimento
			
			System.out.println("@@@@@@  "+estabelecimento+"  @@@@@@");
			System.out.println("####  "+estabelecimento.getId_estabelecimento()+"  ####");
			
			fachada = Fachada.getInstance();
		
			String descricao_produto = request.getParameter("descricao");
			float preco = Float.parseFloat(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			String categoria = request.getParameter("estado");
			int id_estabelecimento = estabelecimento.getId_estabelecimento();
			
			Produto p = new Produto();
			p.setDescricao_produto(descricao_produto);
			p.setCategoria(categoria);
			p.setPreco_produto(preco);
			p.setQuantidade_produto(quantidade);
			p.setPeso_produto("1 kg");
			p.setValidade_produto("01/05/2014");
			p.setMarca_produto("000");
			p.setCodigo_de_barra("0000000");
			p.setId_estabelecimento(id_estabelecimento);
			
			fachada.adicionarProduto(p);
			
			response.sendRedirect("visaoEs.jsp");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
