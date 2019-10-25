package br.ufma.ecp.paradigmas.optionalmonads;

public class Pedido {

	private String id;
	private double valor;

	public Pedido(String id, double valor) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}
	
	public double getValor() {
		return valor;
	}



}
