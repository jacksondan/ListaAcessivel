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
import fafica.listaacessivel.negocios.entidades.Endereco;
import fafica.listaacessivel.negocios.entidades.Estabelecimento;

/**
 * Servlet implementation class TesteAdicionarEstabelecimento
 */
@WebServlet("/TesteAdicionarEstabelecimento")
public class TesteAdicionarEstabelecimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteAdicionarEstabelecimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			String nome_fantasia = "Bonanza";
			String nome_juridico = "bonaza1.ltda";
			String email = "admin@bonanza.com.br";
			String senha = "123";
			String categoria = "supermercado";
			String cnpj = "12233112";
			
			String rua = "Rua do Cedro";
			String bairro = "Divinopolis";
			String numero = "12";
			String complemento = "Estabelecimento";
			String referencia = "Perto da rua Bhaia";
			String cidade = "Caruaru";
			String estado = "PE";
			String cep = "112233";
			
			List <String> telefones = new ArrayList<String>();
			telefones.add("22113344");
			telefones.add("33221144");
			
			Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
			Estabelecimento estabelecimento = 
					new Estabelecimento(nome_fantasia, nome_juridico, email, categoria, cnpj, endereco, senha, telefones);
			
			fachada.adicionarEstabelecimento(estabelecimento);
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
