package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class EditarEstabelecimento
 */
@WebServlet("/EditarEstabelecimentoServlet")
public class EditarEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarEstabelecimentoServlet() {
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
			String mensagem = "Sessão expirada!!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				request.setAttribute("editarEstabelecimento", estabelecimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarEs.jsp");
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
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		if(estabelecimento == null){
			response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				ArrayList<String> telefones = new ArrayList<String>();
				
				int id_estabelecimento = estabelecimento.getId_estabelecimento();
				String nome_fantasia = request.getParameter("nome_fantasia");
				String nome_juridico = request.getParameter("nome_juridico");
				String categoria = request.getParameter("categoria");
				String cnpj = request.getParameter("cnpj");
				String email = request.getParameter("email");
				String senha = estabelecimento.getSenha();
				telefones.add(request.getParameter("telefone1"));
				telefones.add(request.getParameter("telefone2"));
				String rua = request.getParameter("rua");
				String numero = request.getParameter("numero");
				String complemento = request.getParameter("complemento");
				String bairro = request.getParameter("bairro");
				String cidade = request.getParameter("cidade");
				String estado = request.getParameter("estado");
				String cep = request.getParameter("cep");
				String referencia = request.getParameter("referencia");
				
				Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				
				Estabelecimento entidade = new Estabelecimento(id_estabelecimento,nome_fantasia,nome_juridico,email,categoria,cnpj,endereco,senha,telefones);
				//entidade.setTelefones(telefones);
				
				fachada.alterarEstabelecimento(entidade);
				
				response.sendRedirect("PerfilEstabelecimentoServlet");
						
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
