package fafica.listaacessivel.ui;

import java.io.IOException;
import java.sql.SQLException;

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
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.ui.util.EmailJava;
import fafica.listaacessivel.ui.util.Situacao;

/**
 * Servlet implementation class SolicitarEntregaServlet
 */
@WebServlet("/SolicitarEntregaServlet")
public class SolicitarEntregaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarEntregaServlet() {
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
			String mensagem = "SessÃ£o expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_lista = Integer.parseInt(request.getParameter("id_lista"));
				Lista lista = new Lista();
				lista.setId_lista(id_lista);
				
				lista = fachada.pesquisarLista(lista);
				
				lista.setSituacao(Situacao.SOLICITADA.toString());
				
				fachada.alterarLista(lista);
				
				request.setAttribute("lista", lista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("detalhesListaCliente.jsp");
				dispatcher.forward(request, response);
				
				//email
				
				EmailJava email = new EmailJava();
				String destino = cliente.getEmail();
				String titulo="Lista de Compras - "+lista.getDescricao()+" Solicitada";
				String mensagem="Olá "+cliente.getNome()+", Sua Lista de Compras "+lista.getDescricao()+
						" Foi solicitada!\n Embreve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()+
						" estará encaminhado suas compras a sua residência.\n Atenciosamente Lista Acessivel.";
				
				email.enviarEmail(titulo, mensagem, destino);
				
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
		// TODO Auto-generated method stub
	}

}
