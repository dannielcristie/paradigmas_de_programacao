package br.ufma.ecp.paradigmas.optionalmonads;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Cliente {
	
	private String nome ;
	private Optional<String> email = Optional.empty();
	private List<Pedido> pedidos = Arrays.asList ( new Pedido ("1", 40),
			new Pedido ("2", 50), new Pedido ("3", 100));
	
	
	public Cliente (String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<String> getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Optional.ofNullable(email);
	}
	
	public Optional<Pedido> getPedido(String id) {
		for (Pedido p: pedidos) {
			if (p.getId() == id)
				return Optional.ofNullable(p);
		}
		return Optional.empty();
	}
	
	
}

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		List<Integer> l  = Arrays.asList(10,20,30,40);
		Integer x = l.stream().mapToInt(a -> a).sum() * 2 ;
		System.out.println(x);*/
		
		Cliente c = new Cliente ("sergio");
		//c.setEmail("skosta@gmail.com");
		c.getEmail().ifPresent(System.out::println);
		
		c.getEmail()
			.map( e -> "mailto:" + e )
			.ifPresent( e2 -> System.out.println("enviando email para "+e2));
		
		/*
		Pedido p = c.getPedido("18");
		if (p != null)
			System.out.println(p.getValor());
		*/
		
		Optional<Object> o = Optional.empty();
		System.out.println(o);
		o = Optional.of (10);
		o = Optional.ofNullable(null);
		/*
		  //data Optional a = Empty | Of a
		  
		  Optional ofNullable (Object o) {
		  		if (o == null)
		  			return Optional.empty()
		  		else
		  			return Optional.of (o)	
		 }
		 
		 Option of (Object o) {
		 	Optional aux = new Optional (o);
		 }
		 */
		o.ifPresent(System.out::println);
		
		
		//String url = "mailto:" + c.getEmail().toLowerCase();
		
		//System.out.println(url);
	}

}
