package fafica.listaacessivel.ui.testes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Cliente;
import fafica.listaacessivel.negocios.entidades.Endereco;

/**
 * Servlet implementation class TesteAdicionarCliente
 */
@WebServlet("/TesteAdicionarCliente")
public class TesteAdicionarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteAdicionarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = "jackson";
		String cpf = "87285525";
		String email = "teste@teste";
		String senha = "123";
		String ano_nascimento = "1895";
		List <String> telefones = new ArrayList<>();
		telefones.add("99668855");
		telefones.add("88559966");
		
		
		String rua = "manoeu";
		String bairro = "tesss";
		String numero = "98";
		String complemento = "casa";
		String referencia = "perto da budega";
		String cidade = "caruaru";
		String estado = "PE";
		String cep = "85774";
		
		Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
		Cliente cliente = new Cliente(nome, cpf, email, senha, ano_nascimento, endereco, telefones);
		
		try {
			IFachada fachada = Fachada.getInstance();
			fachada.adicionarCliente(cliente);
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