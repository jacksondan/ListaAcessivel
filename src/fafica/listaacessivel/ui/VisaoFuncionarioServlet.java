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
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Lista;
import fafica.listaacessivel.negocios.util.SituacaoLista;

/**
 * Servlet implementation class VisaoFuncionarioServlet
 */
@WebServlet("/VisaoFuncionarioServlet")
public class VisaoFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisaoFuncionarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Funcionario funcionario = (Funcionario) session.getAttribute("acessoFuncionario");
		if(funcionario==null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				List<Lista> listas = fachada.listarListaPorEstabelecimento(funcionario.getEstabelecimento());
				if(listas == null){
					listas = new ArrayList<Lista>();
				}
				
				List<Lista> auxListaSolicitadas = new ArrayList<Lista>();
				
				for(Lista lista : listas){
					if(lista.getSituacao().equals(SituacaoLista.SOLICITADA.toString())){
						auxListaSolicitadas.add(lista);
					}
				}
				
				List<Lista> auxListaAtendidas = new ArrayList<Lista>();
				
				for(Lista lista : listas){
					if(lista.getSituacao().equals(SituacaoLista.ATENDIDA.toString())){
						auxListaAtendidas.add(lista);
					}
				}
				
				int numTotalListas = listas.size();
				int numListasSolicitadas = auxListaSolicitadas.size();
				int numListasAtendimento = auxListaAtendidas.size();
				
				System.out.println(numTotalListas);
				System.out.println(numListasSolicitadas);
				System.out.println(numListasAtendimento);
				
				request.setAttribute("totalListas", numTotalListas);
				request.setAttribute("listasSolicitadas", numListasSolicitadas);
				request.setAttribute("listasAtendidas", numListasAtendimento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("visaoFuncionario.jsp");
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
