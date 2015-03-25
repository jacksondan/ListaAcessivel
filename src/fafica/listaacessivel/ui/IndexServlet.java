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
import fafica.listaacessivel.negocios.entidades.Administrador;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;
import fafica.listaacessivel.negocios.entidades.Usuario;
import fafica.listaacessivel.negocios.util.CriptografiaSenha;

/**
 * Servlet implementation class Index
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.fachada = Fachada.getInstance();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			senha = CriptografiaSenha.encriptar(senha);
			
			Usuario usuario = null;
			Estabelecimento estabelecimento = null;
			
			Administrador administrador
				= new Administrador("TechBin Admin", "admin@admin", "000.000.000.00", "ICy5YqxZB1uWSwcVLSNLcA==");
			
			if (fachada.pesquisarAdministrador(administrador) == null) {
				fachada.adicionarAdministrador(administrador);
			}
			
			List <Administrador> administradores = fachada.listarAdministrador();
			List <Cliente> clientes = fachada.listarCliente();
			List <Funcionario> funcionarios = fachada.listarFuncionario();
			
			List <Usuario> listaUsuarios = new ArrayList<Usuario>();
			
			if(administradores != null) listaUsuarios.addAll(administradores);
			if(clientes != null) listaUsuarios.addAll(clientes);
			if(funcionarios != null) listaUsuarios.addAll(funcionarios);
			

			for(Usuario u : listaUsuarios){
				if (u.getEmail().equals(email)&& u.getSenha().equals(senha)){
					usuario = u;
					break;
				}
			}
				
			if(usuario == null){
				List <Estabelecimento> listaEstabelecimentos = fachada.listarEstabelecimento();
				if(listaEstabelecimentos != null){
					for(Estabelecimento e : listaEstabelecimentos){
						if (e.getCnpj().equals(email)&& e.getSenha().equals(senha)){
							estabelecimento = e;
							break;
						}
					}
				}
			}
				
			if(usuario != null){
				String classe = usuario.getClass().toString();
				System.out.println("************ "+classe+" ***************");
				if(classe.endsWith(".Administrador")){
					HttpSession session = request.getSession(); 
					session.setAttribute("acessoAdministrador", usuario);
					session.setMaxInactiveInterval(1200);
					response.sendRedirect("VisaoAdministradorServlet");
				}else if(classe.endsWith(".Cliente")){
					HttpSession session = request.getSession(); 
					session.setAttribute("acessoCliente", usuario);
					session.setMaxInactiveInterval(3600);
					response.sendRedirect("visaoCliente.jsp");
				}else{
					HttpSession session = request.getSession(); 
					session.setAttribute("acessoFuncionario", usuario);
					session.setMaxInactiveInterval(1200);
					response.sendRedirect("VisaoFuncionarioServlet");
				}
			}else if (estabelecimento != null){
				String classe = estabelecimento.getClass().toString();
				System.out.println("************ "+classe+" ***************");
				HttpSession session = request.getSession(); 
				session.setAttribute("acessoEstabelecimento", estabelecimento);
				session.setMaxInactiveInterval(1200);
				//response.sendRedirect("visaoEstabelecimento.jsp");
				response.sendRedirect("VisaoEstabelecimentoServlet");
			}else{
				request.setAttribute("erroLogin", "******E-mail ou Senha Incorreto******");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
	}
	
/*	public static String encriptar(String senha) {     
        try {     
             MessageDigest digest = MessageDigest.getInstance("MD5");      
             digest.update(senha.getBytes());      
             BASE64Encoder encoder = new BASE64Encoder ();      
             return encoder.encode (digest.digest ());      
        } catch (NoSuchAlgorithmException ns) {     
             ns.printStackTrace ();      
             return senha;      
        }      
   }*/      

}
