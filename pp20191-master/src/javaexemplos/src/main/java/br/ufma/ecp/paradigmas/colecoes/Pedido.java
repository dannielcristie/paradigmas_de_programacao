package br.ufma.ecp.paradigmas.colecoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pedido implements Comparable {
	
	private String id;
	private String nomeCliente;
	private String nomeVendedor;
	//private List<Item> itens;
	private Map<Item,Item> itens;
	//private Item itens[];
	//private int posIt = 0;
	
	public Pedido(String id, String nomeCliente, String nomeVendedor) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomeVendedor = nomeVendedor;
		this.id = id;
		//itens = new Item[1000];
		//itens = new LinkedList<Item>();
		// itens = new HashMap<Item,Item>();
		itens = new TreeMap<Item,Item>();
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getId() {
		return id;
	}


	public void addItem(Item item) {
		// TODO Auto-generated method stub
		//itens[posIt++] = item;
		
		//itens.add(item);
		itens.put(item,item);
	}
	
	public void removeItem(String id) { 
		
		//itens.remove( new  Item (id)  );
		
	}
	
	public Item getItem (String id) {
		// return itens.get( itens.indexOf( new  Item (id) ) );
		return itens.get(new Item (id));
	}
	
	/*
	 
	 public void remove (Object o2) {
	 	for (Object o1: objects) {
	 		if (o1.equals(o2)){
	 			// remove
	 		}
	 	}
	 
	 }
	 
	 
	 */
	
	public int qtItens () {
		return itens.size();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return id ==  ((Pedido)obj).id;
	}
	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		return ((Pedido)obj).id.compareTo( id );
	}
	
	

	/*
	public void removeItem(String id) {
		// TODO Auto-generated method stub
		//for (int i =0 ; i < itens.size()  ; i++) {
		//Iterator<Item> it =  itens.iterator();
		//while (it.hasNext()) {
		//	Item item = it.next();
		for (Item item:itens) {				
			if (item.getId() == id) {
				System.out.println("achei");
				itens.remove(item);
				//itens[i] = null;
				//itens[i] = itens[posIt-1];
				//postIt = postIt - 1; 
				
				//for (int j = i+1; j < posIt; j++) {
					//itens[i] =itens[j];
				//}
			}
		}
	
	}*/
	

}
