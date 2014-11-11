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
 * Servlet implementation class TesteEditarCliente
 */
@WebServlet("/TesteEditarCliente")
public class TesteEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteEditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = 1;
		String nome = "Joaquim";
		String cpf = "1000000000";
		String email = "rrr@rrr";
		String senha = "123";
		String ano_nascimento = "1877";
		List <String> telefones = new ArrayList<>();
		telefones.add("99668855");
		telefones.add("88559966");
		
		
		String rua = "manoeu fdfdfd";
		String bairro = "tesss fdfdsfs";
		String numero = "100";
		String complemento = "casa";
		String referencia = "perto do beco";
		String cidade = "caruaru";
		String estado = "PE";
		String cep = "Teste";
		
		Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
		Cliente cliente = new Cliente(id_usuario, nome, cpf, email, senha, ano_nascimento, endereco, telefones);
		
		try {
			IFachada fachada = Fachada.getInstance();
			fachada.alterarCliente(cliente);
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
