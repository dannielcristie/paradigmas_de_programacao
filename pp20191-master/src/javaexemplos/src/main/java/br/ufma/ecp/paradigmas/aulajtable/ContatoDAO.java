package br.ufma.ecp.paradigmas.aulajtable;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.ufma.ecp.paradigmas.agenda.Contato;

public class ContatoDAO implements AbstractDAO<Contato> {
	
	private Connection conn; 
	//private String url = "jdbc:postgresql://localhost/agenda?user=postgres&passwd=postgres";
	private String url =  "jdbc:sqlite:agenda.db";
	
	public ContatoDAO () {
			
			try {
				conn = DriverManager.getConnection(url);
			    Statement statement = conn.createStatement();

                // criando uma tabela
                statement.execute("CREATE TABLE IF NOT EXISTS contato (nome VARCHAR,email VARCHAR,telefone VARCHAR )");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	public void adiciona(Contato contato) { 
		
		String sql = "INSERT INTO contato( nome,email,telefone) VALUES(?,?,?)";
		try { 
				PreparedStatement stmt = conn.prepareStatement(sql); 
				stmt.setString(1, contato.getNome());
				stmt.setString(2, contato.getEmail()); 
				stmt.setString(3, contato.getFone()); 
				stmt.execute(); 
				stmt.close(); 
		} catch (SQLException u) {
				 throw new RuntimeException(u);
		} 

	}
	
	public List<Contato> recupera () {
		List<Contato> contatos = new LinkedList<Contato>();
 		String sql = "select * from contato"; 
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql); 
			ResultSet rs = stmt.executeQuery(); 
			while (rs.next()) { 
				Contato c = new Contato();
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				c.setFone(rs.getString("telefone"));
				contatos.add(c);
			} 
			stmt.close(); 
		} catch (SQLException u) { 
			throw new RuntimeException(u);
		 }
		return contatos;
	}
	
	public void atualiza (Contato contato) {
		String sql = "update contato set nome=?, telefone=? "
				+ "	where email = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(3, contato.getEmail()); 
			stmt.setString(2, contato.getFone()); 
			stmt.execute(); 
			stmt.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
