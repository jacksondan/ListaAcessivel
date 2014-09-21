package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
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
/*			HttpSession session = request.getSession(); 
			Estabelecimento e = (Estabelecimento)session.getAttribute("acessoEstabelecimento"); // Utilizar pra pegar codigo de usuario
*/			
			fachada = Fachada.getInstance();
		
			String descricao_produto = request.getParameter("descricao");
			int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
			float preco = Float.parseFloat(request.getParameter("preco"));
			String categoria = request.getParameter("estado");
			
			Produto p = new Produto();
			p.setDescricao_produto(descricao_produto);
			p.setCategoria(categoria);
			p.setPreco_produto(preco);
			p.setQuantidade_produto(0);
			p.setPeso_produto("1 kg");
			p.setValidade_produto("01/05/2014");
			p.setMarca_produto("Lembrete");
			p.setCodigo_de_barra("000000000");
			p.setDisponibilidade("Disponivel");
			p.setId_estabelecimento(id_estabelecimento);
			
			fachada.adicionarProduto(p);
			
			response.sendRedirect("visaoEs.jsp");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
