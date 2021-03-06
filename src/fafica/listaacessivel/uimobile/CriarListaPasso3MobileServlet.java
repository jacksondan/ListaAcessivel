package fafica.listaacessivel.uimobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fafica.listaacessivel.negocios.Fachada;
import fafica.listaacessivel.negocios.IFachada;
import fafica.listaacessivel.negocios.entidades.Lista;

/**
 * Servlet implementation class CriarListaPasso3MobileServlet
 */
@WebServlet("/CriarListaPasso3MobileServlet")
public class CriarListaPasso3MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IFachada fachada;
	private Lista lista;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarListaPasso3MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json_lista = request.getParameter("json_lista");
		String retorno;
		int id_lista;
		
		json_lista = json_lista.replaceAll("<;>", " ");	//Convertendo os caracteres especiais da Lista para evitar ERRO
		
		System.out.println("Lista Recebida: "+json_lista);
		
		try {
			fachada = Fachada.getInstance();
			
			gson = new Gson();
			lista = gson.fromJson(json_lista, Lista.class);
		
			if(lista != null){
				id_lista = fachada.adicionarLista(lista);
				System.out.println("ID DA LISTA: "+id_lista);
				lista.setId_lista(id_lista);
				lista = fachada.pesquisarLista(lista);
				System.out.println("Descrição da lista: "+lista.getDescricao());				
				
				retorno = gson.toJson(lista);
				
				System.out.println("Lista Retorno: "+retorno);
				
				PrintWriter out = response.getWriter();
				out.println(retorno);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
