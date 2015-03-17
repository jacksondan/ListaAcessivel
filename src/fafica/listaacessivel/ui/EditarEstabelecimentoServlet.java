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
import fafica.listaacessivel.negocios.entidades.Administrador;
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
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		
		if(administrador == null && estabelecimento == null){
			String mensagem = "Sessão expirada!!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else if(administrador != null && estabelecimento == null){
			try {
				IFachada fachada = Fachada.getInstance();
				int id_estabelecimento = Integer.parseInt(request.getParameter("id_estabelecimento"));
				estabelecimento = new Estabelecimento();
				estabelecimento.setId_estabelecimento(id_estabelecimento);
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				request.setAttribute("editarEstabelecimento", estabelecimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarEstabelecimentoComoAdministrador.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(administrador == null && estabelecimento != null){
				
				response.sendRedirect("editarEstabelecimento.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		
		if(administrador == null && estabelecimento == null){
			String mensagem = "Sessão expirada!!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else if(administrador == null && estabelecimento != null){
			try {
				IFachada fachada = Fachada.getInstance();
				ArrayList<String> telefones = new ArrayList<String>();
								
				//estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				//int id_estabelecimento = estabelecimento.getId_estabelecimento();
				//String nome_fantasia = request.getParameter("nome_fantasia");
				//String nome_juridico = request.getParameter("nome_juridico");
				//String categoria = request.getParameter("categoria");
				//String cnpj = request.getParameter("cnpj");
				String email = request.getParameter("email");
				telefones.add(request.getParameter("telefone1"));
				telefones.add(request.getParameter("telefone2"));
				//String rua = request.getParameter("rua");
				//String numero = request.getParameter("numero");
				//String complemento = request.getParameter("complemento");
				//String bairro = request.getParameter("bairro");
				//String cidade = request.getParameter("cidade");
				//String estado = request.getParameter("estado");
				//String cep = request.getParameter("cep");
				//String referencia = request.getParameter("referencia");
				//Administrador administrador = estabelecimento.getAdministrador();
				
				//Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				
				//Estabelecimento entidade = new Estabelecimento(id_estabelecimento,nome_fantasia,nome_juridico,email,categoria,cnpj,endereco,senha,telefones,administrador);
				
				estabelecimento.setEmail(email);
				estabelecimento.setTelefones(telefones);
				
				fachada.alterarEstabelecimento(estabelecimento);
				
				String mensagem = "Edição realizada com sucesso!!";
				request.setAttribute("mensagem", mensagem);
				//Tela de edição para o estabelecimento
				RequestDispatcher dispatcher = request.getRequestDispatcher("perfilEstabelecimento.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("PerfilEstabelecimentoServlet");
						
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(administrador != null && estabelecimento == null){
			try {
				IFachada fachada = Fachada.getInstance();
				ArrayList<String> telefones = new ArrayList<String>();				
				
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				
				int id_estabelecimento = estabelecimento.getId_estabelecimento();
				String nome_fantasia = request.getParameter("nome_fantasia");
				String nome_juridico = request.getParameter("nome_juridico");
				String categoria = request.getParameter("categoria");
				String cnpj = request.getParameter("cnpj");
				//String email = request.getParameter("email");
				//String senha = estabelecimento.getSenha();
				//telefones.add(request.getParameter("telefone1"));
				//telefones.add(request.getParameter("telefone2"));
				String rua = request.getParameter("rua");
				String numero = request.getParameter("numero");
				String complemento = request.getParameter("complemento");
				String bairro = request.getParameter("bairro");
				String cidade = request.getParameter("cidade");
				String estado = request.getParameter("estado");
				String cep = request.getParameter("cep");
				String referencia = request.getParameter("referencia");
				Administrador administrador2 = estabelecimento.getAdministrador();
				
				Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				
				//Estabelecimento entidade = new Estabelecimento(id_estabelecimento,nome_fantasia,nome_juridico,email,categoria,cnpj,endereco,senha,telefones,administrador);
								
				estabelecimento.setEndereco(endereco);
				estabelecimento.setNome_fantasia(nome_fantasia);
				estabelecimento.setNome_juridico(nome_juridico);
				estabelecimento.setCategoria(categoria);
				estabelecimento.setCnpj(cnpj);
				estabelecimento.setAdministrador(administrador2);
				estabelecimento.setTelefones(telefones);
				
				fachada.alterarEstabelecimento(estabelecimento);
				
				String mensagem = "Edição realizada com sucesso!!";
				request.setAttribute("mensagem", mensagem);
				//Tela de edição para o administrador
				RequestDispatcher dispatcher = request.getRequestDispatcher("detalhesEstabelecimento.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("PerfilEstabelecimentoServlet");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
