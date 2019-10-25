package br.ufma.ecp.paradigmas.colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Loja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pedido p1 = new Pedido ("1", "Joao", "Maria");
		Pedido p2 = new Pedido ("1", "sdfsd", "sdfsdf");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		Map<Pedido, Item> peditens = new TreeMap<Pedido,Item>();
		
		peditens.put(p1, new Item("123") );
		
		Item it2 = peditens.get(p2);
		
		System.out.println(it2.getId());
		
		
		
		/*
		p.addItem ( new Item ("123", "Arroz", 1 )  );
		Item feijao = new Item ("124", "Feijão", 1 );
		p.addItem (  feijao );
		p.addItem ( new Item ("127", "Farinha", 1 )  );
		System.out.println(p.qtItens());
		p.removeItem("124");
		System.out.println(p.qtItens());
		//p.removeItem("129");
		Item it = new Item ("124") ;
		System.out.println(  feijao == it );
		System.out.println(  feijao.equals(it) );
		System.out.println(  feijao.equals("musica") );
		Item i2 = p.getItem("127");
		System.out.println(i2.getProduto());
		*/
		
		

	}

}
