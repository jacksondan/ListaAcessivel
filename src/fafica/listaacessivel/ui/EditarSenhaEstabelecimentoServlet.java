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
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.ui.util.CriptografiaSenha;

/**
 * Servlet implementation class EditarSenhaEstabelecimentoServlet
 */
@WebServlet("/EditarSenhaEstabelecimentoServlet")
public class EditarSenhaEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSenhaEstabelecimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		if(estabelecimento == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("editarSenhaEstabelecimento.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("acessoEstabelecimento");
		if(estabelecimento == null){
			String mensagem = "Sessão expirada!";
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				IFachada fachada = Fachada.getInstance();
				
				String mensagem="";
				
				estabelecimento = fachada.pesquisarEstabelecimento(estabelecimento);
				String senhaNova= CriptografiaSenha.encriptar(request.getParameter("senhaNova"));
				String confirmarSenha = CriptografiaSenha.encriptar(request.getParameter("confirmarSenha"));
				String senhaAtual = CriptografiaSenha.encriptar(request.getParameter("senhaAtual"));
				String senhaBanco = estabelecimento.getSenha();
								
				if(senhaNova != null && confirmarSenha != null){
					if(senhaAtual.equals(senhaBanco)&&senhaNova.equals(confirmarSenha)){
						estabelecimento.setSenha(confirmarSenha);
						fachada.alterarEstabelecimento(estabelecimento);
						
						mensagem = "Senha editada com sucesso!";
					}else{
						mensagem = "Sua Senha n�o foi alterada, porfavor tente novamente.";
					}
				}
				request.setAttribute("mensagem",mensagem);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editarSenhaEstabelecimento.jsp");
				dispatcher.forward(request, response);
						
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	/*public static String encriptar(String senha) {     
        try {     
             MessageDigest digest = MessageDigest.getInstance("MD5");      
             digest.update(senha.getBytes());      
             BASE64Encoder encoder = new BASE64Encoder ();      
             return encoder.encode (digest.digest ());      
        } catch (NoSuchAlgorithmException ns) {     
             ns.printStackTrace ();      
             return senha;      
        }      
   }      */
}
