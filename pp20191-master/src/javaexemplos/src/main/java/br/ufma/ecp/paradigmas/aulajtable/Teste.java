package br.ufma.ecp.paradigmas.aulajtable;

import java.util.List;

import br.ufma.ecp.paradigmas.agenda.Contato;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:postgresql://localhost/agenda?user=postgres&password=postgres";
		GenericDAO<Contato> dao = new 
				GenericDAO<Contato> (url, Contato.class);
		List<Contato> contatos = dao.recupera();
		for (Contato c: contatos) {
			System.out.println(c);
		}
		
		
	}

}
