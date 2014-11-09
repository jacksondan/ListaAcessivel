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

import sun.security.krb5.internal.EncAPRepPart;
import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Endereco;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClienteServlet() {
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
			response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				cliente = fachada.pesquisarCliente(cliente);
				
				request.setAttribute("editarCliente", cliente);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarCliente.jsp");
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
			response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				ArrayList <String> telefones = new ArrayList <String>();
				
				int id_usuario = cliente.getId_usuario();
				String nome = request.getParameter("nome");
				String cpf = request.getParameter("cpf");
				String email = request.getParameter("email");
				String senha = cliente.getSenha();
				String cidade = request.getParameter("cidade");
				String estado = request.getParameter("estado");
				String rua = request.getParameter("rua");
				String bairro = request.getParameter("bairro");
				String numero = request.getParameter("numero");
				String complemento = request.getParameter("complemento");
				String referencia = request.getParameter("referencia");
				String cep = request.getParameter("cep");
				String telefone1 = request.getParameter("telefone1");
				String telefone2 = request.getParameter("telefone2");
				String ano_nascimento = request.getParameter("ano_nacimento");
				telefones.add(telefone1);
				telefones.add(telefone2);
				
				Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
		
				Cliente entidade = new Cliente(nome,cpf,email,senha,ano_nascimento,endereco,telefones);
				entidade.setTelefones(telefones);
				
				fachada.alterarCliente(entidade);
				
				response.sendRedirect("PerfilClienteServlet");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
