package br.ufma.ecp.paradigmas.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Agenda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contato co = new  Contato ("joaquim", "jj@gmail.com", "777");
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(co);
		List<Contato> contatos = dao.recupera();
		for (Contato c: contatos) {
			System.out.println(c);
			
		}
	}

}



