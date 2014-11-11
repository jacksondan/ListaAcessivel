package fafica.listaacessivel.ui.testes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class TesteListarFuncionarios
 */
@WebServlet("/TesteListarFuncionarios")
public class TesteListarFuncionarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteListarFuncionarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			Estabelecimento estabelecimento = new Estabelecimento();
			estabelecimento.setId_estabelecimento(1);
			
			List <Funcionario> funcionariosLista = fachada.listarFuncionarioPorEstabelecimento(estabelecimento);
			
			for(Funcionario funcionario : funcionariosLista){
				
				System.out.println("ID_FUNCIONARIO: "+funcionario.getId_usuario());
				System.out.println("NOME: "+funcionario.getNome());
				System.out.println("EMAIL: "+funcionario.getEmail());
				System.out.println("SENHA: "+funcionario.getSenha());
				System.out.println("MATRICULA: "+funcionario.getMatricula());
				System.out.println("ID_ESTABELECIMENTO: "+funcionario.getEstabelecimento().getId_estabelecimento());
				
				System.out.println("#################################");
				
				
				
				
			}

			
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
