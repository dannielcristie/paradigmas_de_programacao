package br.ufma.ecp.paradigmas.sigaa;

import java.util.ArrayList;
import java.util.List;

/*
 
 void println(Object o) {
 	println (o.toString());
 }
 
 boolean contains (Object o) {
 	for (i : this.values()) {
 		if (i.equals (o))
 		
 		if (o.equals (i))
 	}
 
 }
 System.out.println(ps.contains("joaquim"));
 
 */
public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turma t = new Turma ();
		List<Participante> ps = new ArrayList<Participante>();
		Discente p1;
		p1 = new Discente ("maria jose", "joaquim");
		ps.add(p1);
		
		
		Discente p2;
		p2 = new Discente ("maria jose", "sdamail.com");
		
		//System.out.println(ps.contains(p1));
		System.out.println(ps.contains("joaquim"));
		
		List<String> ls = new ArrayList<String>();
		ls.add("joaquim");
		//System.out.println(ls.contains( p2  ));
		
		//System.out.println(p1.equals(p2));
		
		
		

		//p1 = new Docente ("joaquim", "jj@gmail.com");
		//p1 = new 
		//t.addParticipante(d);
	}

}
