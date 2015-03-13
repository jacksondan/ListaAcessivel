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
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.ui.util.CriptografiaSenha;

/**
 * Servlet implementation class cadastroEs
 */
@WebServlet("/CadastrarEstabelecimentoServlet")
public class CadastrarEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IFachada fachada; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarEstabelecimentoServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		if(administrador == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("cadastroEstabelecimento.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrador administrador = (Administrador) session.getAttribute("acessoAdministrador");
		if(administrador == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			try {
				fachada = Fachada.getInstance();
				
				ArrayList<String> telefones = new ArrayList<String>();
			
				String nome_fantasia = request.getParameter("nome_fantasia");
				String nome_juridico = request.getParameter("nome_juridico");
				String categoria = request.getParameter("categoria");
				String cnpj = request.getParameter("cnpj");
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
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
				
				String senhaEncriptada = CriptografiaSenha.encriptar(senha);
				Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
				
				Estabelecimento entidade = new Estabelecimento(nome_fantasia,nome_juridico,email,categoria,cnpj,endereco,senhaEncriptada,telefones, administrador);
				
				//Verificação de CNPJ digitado no cadastro de estabelecimento
				List <Estabelecimento> estabelecimentos = fachada.listarEstabelecimento();
				
				for(Estabelecimento e : estabelecimentos){
					if(e.getCnpj().equals(cnpj)){
						String mensagem1 = "O CNPJ digitado já está cadastrado no sistema!";
						request.setAttribute("mensagem", mensagem1);
						RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroEstabelecimento.jsp");
						dispatcher.forward(request, response);
						break;
					}
				}
									
				fachada.adicionarEstabelecimento(entidade);
							
				String mensagem = "Estabelecimento cadastrado com sucesso!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("visaoAdministrador.jsp");
				dispatcher.forward(request, response);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
