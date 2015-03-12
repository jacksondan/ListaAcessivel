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
import fafica.listaacessivel.negocios.entidades.Cliente;

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
			String mensagem = "Sess√£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarCliente.jsp");
			requestDispatcher.forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("acessoCliente");
		
		if(cliente == null){
			String mensagem = "Sess√£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else {
			try {
				IFachada fachada = Fachada.getInstance();
				
				ArrayList <String> telefones = new ArrayList <String>();
				
				cliente.setNome(request.getParameter("nome"));
				cliente.setCpf(request.getParameter("cpf"));
				cliente.setEmail(request.getParameter("email"));
				cliente.getEndereco().setCidade(request.getParameter("cidade"));
				cliente.getEndereco().setEstado(request.getParameter("estado"));
				cliente.getEndereco().setRua(request.getParameter("rua"));
				cliente.getEndereco().setBairro(request.getParameter("bairro"));
				cliente.getEndereco().setNumero(request.getParameter("numero"));
				cliente.getEndereco().setComplemento(request.getParameter("complemento"));
				cliente.getEndereco().setReferencia(request.getParameter("referencia"));
				cliente.getEndereco().setCep(request.getParameter("cep"));
				cliente.setAno_nascimento(request.getParameter("ano_nascimento"));

				telefones.add(request.getParameter("telefone1"));
				telefones.add(request.getParameter("telefone2"));
				cliente.setTelefones(telefones);
				
				
				fachada.alterarCliente(cliente);
				
				String mensagem = "EdiÁ„o realizada com sucesso!!";
				request.setAttribute("mensagem", mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("PerfilClienteServlet");
				dispatcher.forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
	}
}
