package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

/**
 * Servlet implementation class RecuperarSenhaPasso2MobileServlet
 */
@WebServlet("/RecuperarSenhaPasso2MobileServlet")
public class RecuperarSenhaPasso2MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Cliente cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarSenhaPasso2MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		
		try {
			fachada = Fachada.getInstance();
			
			cliente = new Cliente();
			cliente.setId_usuario(id_cliente);
			cliente = fachada.pesquisarCliente(cliente);
			
			HttpSession session = request.getSession(); 
			session.setAttribute("usuarioRecuperarSenha", cliente);
			
			response.sendRedirect("#");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senha = request.getParameter("senha");
		String senhaCriptografada;
		
		HttpSession session = request.getSession();
		cliente = (Cliente) session.getAttribute("usuarioRecuperarSenha");
		
		if(cliente == null){
			String mensagem = "<h2>Tempo para edição excedido, retorne a aplicação Lista Acessível e "
					+ "recomece o processo para recuperar sua senha de acesso!</h2>";
			
			PrintWriter out = response.getWriter(); //Criar tela para exibir mensagens
			out.println(mensagem);
		}else{
			try {
				fachada = Fachada.getInstance();
				
				senhaCriptografada = CriptografiaSenha.encriptar(senha);
				cliente.setSenha(senhaCriptografada);
				
				fachada.alterarCliente(cliente);
				
				String mensagem = "<h2>Alteração concluida com sucesso!<br>"
						+ "Retorne à aplicação Lista Acessível e acesse com sua nova senha</h2>";
				
				PrintWriter out = response.getWriter(); //Criar tela para exibir mensagens
				out.println(mensagem);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
