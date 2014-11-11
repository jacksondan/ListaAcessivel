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
import fafica.listaacessivel.negocios.entidades.Cliente;

/**
 * Servlet implementation class TesteListarCliente
 */
@WebServlet("/TesteListarCliente")
public class TesteListarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteListarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			for(Cliente cliente : fachada.listarCliente()){
				System.out.println("ID CLIENTE: "+cliente.getId_usuario());
				System.out.println("Nome: "+cliente.getNome());
				System.out.println("CPF: "+cliente.getCpf());
				System.out.println("Ano Nascimento: "+cliente.getAno_nascimento());
				System.out.println("Email: "+cliente.getEmail());
				System.out.println("Senha: "+cliente.getSenha());
				System.out.println("Rua: "+cliente.getEndereco().getRua());
				System.out.println("Bairro: "+cliente.getEndereco().getBairro());
				System.out.println("Numero: "+cliente.getEndereco().getNumero());
				System.out.println("Complemento: "+cliente.getEndereco().getComplemento());
				System.out.println("Referencia: "+cliente.getEndereco().getReferencia());
				System.out.println("Cidade: "+cliente.getEndereco().getCidade());
				System.out.println("Estado: "+cliente.getEndereco().getEstado());
				System.out.println("cep: "+cliente.getEndereco().getCep());
				if(cliente.getTelefones() != null){	
					for(String telefone : cliente.getTelefones()){
						int i = 0;
						System.out.println("Telefone"+(i++)+" "+telefone);
					}
				}
				System.out.println("############################################");
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
