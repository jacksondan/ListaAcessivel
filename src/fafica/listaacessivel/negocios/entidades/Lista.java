package fafica.listaacessivel.negocios.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lista {
	
	private int id_lista;
	private String data_criacao_lista;
	private String data_modificacao_lista;
	private int quantidade_total_lista;
	private float valor_total_lista;
	private String status_lista;
	private int id_usuario;
	
	private SimpleDateFormat dmy;
	
	public Lista() {
		//dmy = new SimpleDateFormat("hh:mm - dd/MM/yyyy");
		//this.data_criacao_lista = dmy.format(new Date());
		//this.data_modificacao_lista = dmy.format(new Date());
	}
	
	public Lista(String data_criacao_lista, String data_modificacao_lista, int quantidade_total_lista, float valor_total_lista, int id_usuario) {
		super();
		
		dmy = new SimpleDateFormat("hh:mm - dd/MM/yyyy");
		this.data_criacao_lista = dmy.format(new Date());
		this.data_modificacao_lista = dmy.format(new Date());
		this.quantidade_total_lista = quantidade_total_lista;
		this.valor_total_lista = valor_total_lista;
		this.id_usuario = id_usuario;
	}
	public Lista(int id_lista, String data_criacao_lista,
			String data_modificacao_lista, int quantidade_total_lista,
			float valor_total_lista, int id_usuario) {
		super();
		this.id_lista = id_lista;
		this.data_criacao_lista = data_criacao_lista;
		this.data_modificacao_lista = data_modificacao_lista;
		this.quantidade_total_lista = quantidade_total_lista;
		this.valor_total_lista = valor_total_lista;
		this.id_usuario = id_usuario;
	}
	
	public Lista(int quantidade_total_lista, float valor_total_lista, int id_usuario) {
		super();
		
		dmy = new SimpleDateFormat("hh:mm - dd/MM/yyyy");
		this.data_modificacao_lista = dmy.format(new Date());
		this.quantidade_total_lista = quantidade_total_lista;
		this.valor_total_lista = valor_total_lista;
		this.id_usuario = id_usuario;
	}

	public int getId_lista() {
		return id_lista;
	}


	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}


	public String getData_criacao_lista() {
		return data_criacao_lista;
	}


	public void setData_criacao_lista(String data_criacao_lista) {
		this.data_criacao_lista = data_criacao_lista;
	}


	public String getData_modificacao_lista() {
		return data_modificacao_lista;
	}


	public void setData_modificacao_lista(String data_modificacao_lista) {
		this.data_modificacao_lista = data_modificacao_lista;
	}


	public int getQuantidade_total_lista() {
		return quantidade_total_lista;
	}


	public void setQuantidade_total_lista(int quantidade_total_lista) {
		this.quantidade_total_lista = quantidade_total_lista;
	}


	public float getValor_total_lista() {
		return valor_total_lista;
	}


	public void setValor_total_lista(float valor_total_lista) {
		this.valor_total_lista = valor_total_lista;
	}


	public String getStatus_lista() {
		return status_lista;
	}


	public void setStatus_lista(String status_lista) {
		this.status_lista = status_lista;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
