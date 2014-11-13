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

/**
 * Servlet implementation class TesteListaEstabeleciment
 */
@WebServlet("/TesteListaEstabeleciment")
public class TesteListaEstabeleciment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteListaEstabeleciment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IFachada fachada = Fachada.getInstance();
			
			for(Estabelecimento estabelecimento : fachada.listarEstabelecimento()){
				
				System.out.println("ID_ESTABELECIMENTO: "+estabelecimento.getId_estabelecimento());
				System.out.println("NOME FANTASIA: "+estabelecimento.getNome_fantasia());
				System.out.println("NOME JURIDICO: "+estabelecimento.getNome_juridico());
				System.out.println("EMAIL: "+estabelecimento.getEmail());
				System.out.println("SENHA: "+estabelecimento.getSenha());
				System.out.println("CATEGORIA: "+estabelecimento.getCategoria());
				System.out.println("CNPJ: "+estabelecimento.getCnpj());
				System.out.println("Rua: "+estabelecimento.getEndereco().getRua());
				System.out.println("Bairro: "+estabelecimento.getEndereco().getBairro());
				System.out.println("Numero: "+estabelecimento.getEndereco().getNumero());
				System.out.println("Complemento: "+estabelecimento.getEndereco().getComplemento());
				System.out.println("Referencia: "+estabelecimento.getEndereco().getReferencia());
				System.out.println("Cidade: "+estabelecimento.getEndereco().getCidade());
				System.out.println("Estado: "+estabelecimento.getEndereco().getEstado());
				System.out.println("cep: "+estabelecimento.getEndereco().getCep());
				if(estabelecimento.getTelefones() != null){	
					for(String telefone : estabelecimento.getTelefones()){
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
