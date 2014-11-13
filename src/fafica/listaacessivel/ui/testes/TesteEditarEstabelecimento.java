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
 * Servlet implementation class TesteEditarEstabelecimento
 */
@WebServlet("/TesteEditarEstabelecimento")
public class TesteEditarEstabelecimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteEditarEstabelecimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			int id_estabelecimento = 2;
			String nome_fantasia = "TESTE";
			String nome_juridico = "Cabra.ltda";
			String email = "aaad@aaad";
			String senha = "123";
			String categoria = "teste";
			String cnpj = "224422";
			
			String rua = "aaaaa";
			String bairro = "aaaaa";
			String numero = "15";
			String complemento = "qqqq";
			String referencia = "ggggggg";
			String cidade = "caruaru";
			String estado = "PE";
			String cep = "886666";
			
			List <String> telefones = new ArrayList<String>();
			telefones.add("99999999");
			telefones.add("88888888");
			
			
			Endereco endereco = new Endereco(rua, bairro, numero, complemento, referencia, cidade, estado, cep);
			Estabelecimento estabelecimento = 
					new Estabelecimento(id_estabelecimento, nome_fantasia, nome_juridico,
							email, categoria, cnpj, endereco, senha, telefones);
			
			fachada.alterarEstabelecimento(estabelecimento);
			
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
