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
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.ui.util.EmailJava;
import fafica.listaacessivel.ui.util.Situacao;

/**
 * Servlet implementation class ConfirmarEntregaListaServlet
 */
@WebServlet("/ConfirmarEntregaListaServlet")
public class ConfirmarEntregaListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarEntregaListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		
		if(funcionario != null){
			try {
				IFachada fachada = Fachada.getInstance();
				
				int id_lista = Integer.parseInt(request.getParameter("id_lista"));
				Lista lista = new Lista();
				lista.setId_lista(id_lista);
				
				lista = fachada.pesquisarLista(lista);
				
				lista.setSituacao(Situacao.ATENDIDA.toString());
				fachada.alterarLista(lista);
				
				String mensagem = "Lista Atendida com sucesso!";
				
				request.setAttribute("mensagem",mensagem);
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("detalhesListaFuncionario.jsp");
				requestDispatcher.forward(request, response);
				
				EmailJava email = new EmailJava();
				String destino = lista.getCliente().getEmail();
				String titulo="Lista Acessível: Entrega encaminhada da lista de compras- "+lista.getDescricao()+" confirmada";
				String mensagemEmail="Olá "+lista.getCliente().getNome()+", Sua Lista de Compras "+lista.getDescricao()+
						" esta sendo encaminhada para seu endereço!\n Embreve os atendentes do estabelecimento "+lista.getEstabelecimento().getNome_fantasia()+
						" estará encaminhado suas compras a sua residência.\n Atenciosamente Lista Acessivel.";
				
				email.enviarEmail(titulo, mensagemEmail, destino);
				
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
