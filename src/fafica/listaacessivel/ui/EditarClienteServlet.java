package fafica.listaacessivel.ui;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;
import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
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
				String email = cliente.getSenha();
				String senha = request.getParameter("senha");
				String cidade = request.getParameter("cidade");
				String estado = request.getParameter("estado");
				String rua = request.getParameter("rua");
				String bairro = request.getParameter("bairro");
				String numero = request.getParameter("numero");
				String referencia = request.getParameter("referencia");
				String cep = request.getParameter("cep");
				String telefone1 = request.getParameter("telefone1");
				String telefone2 = request.getParameter("telefone2");
				telefones.add(telefone1);
				telefones.add(telefone2);
		
				Cliente entidade = new Cliente(id_usuario, nome, cpf, email, senha, cidade, estado, rua, bairro, numero, referencia, cep);
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
