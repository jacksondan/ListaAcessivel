package fafica.listaacessivel.ui.testes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;
import fafica.listaacessivel.negocios.entidades.Funcionario;

/**
 * Servlet implementation class TesteAdicionarFuncionario
 */
@WebServlet("/TesteAdicionarFuncionario")
public class TesteAdicionarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteAdicionarFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			IFachada fachada = Fachada.getInstance();
			
			String nome = "JoãoZinho";
			String email = "joão@bonanza.com.br";
			String senha = "123";
			String matricula = "2211221";
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setId_estabelecimento(1);
			
			Funcionario funcionario = new Funcionario(nome, email, senha, matricula, estabelecimento);
			
			fachada.adicionarFuncionario(funcionario);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
