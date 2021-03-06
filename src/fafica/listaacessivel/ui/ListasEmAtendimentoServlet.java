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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class ListasEmAtendimentoServlet
 */
@WebServlet("/ListasEmAtendimentoServlet")
public class ListasEmAtendimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ListasEmAtendimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");

		if (funcionario == null) {
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else if(funcionario != null){
			try {
				List<Lista> listaListas = new ArrayList<Lista>();
				List<Lista> listasEmAtendimento = new ArrayList<Lista>();
				
				IFachada fachada = Fachada.getInstance();
				
				estabelecimento = funcionario.getEstabelecimento();
				
				listaListas = fachada.listarListaPorEstabelecimento(estabelecimento);
				
				for(Lista l : listaListas){
					if(l.getSituacao().equals("em atendimento")){
						listasEmAtendimento.add(l);
					}
				}
				
				request.setAttribute("listas_EmAtendimento", listasEmAtendimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("listasEmAtendimento.jsp");
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
		// TODO Auto-generated method stub
	}

}
