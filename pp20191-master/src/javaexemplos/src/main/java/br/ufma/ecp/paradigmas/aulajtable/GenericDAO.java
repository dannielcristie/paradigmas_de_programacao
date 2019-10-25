package br.ufma.ecp.paradigmas.aulajtable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.ufma.ecp.paradigmas.agenda.Contato;

public class GenericDAO<T> implements AbstractDAO<T> {
	
	private Connection conn; 
	private String url;  
	private Class c;
	
	public GenericDAO (String url, Class c) {
		// TODO mudar depois para ser generico
		this.url = url;
		this.c = c;
		
		try {
			conn = DriverManager.getConnection(url);
		    Statement statement = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<T> recupera() {
		// TODO Auto-generated method stub
		/*
		 * 
		 * List<Contato> contatos = new LinkedList<Contato>();
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
		 */
		
		List lista = new LinkedList();
		
		String tablename = c.getSimpleName().toLowerCase(); 
		String sql = "select * from " + tablename;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(); 
			while (rs.next()) { 
				Object obj = c.newInstance();
				for (Field f : c.getDeclaredFields() ) {
					String nomefield = f.getName();
					String nomemethod = "set" 
					  + nomefield.substring(0,1).toUpperCase()
					  + nomefield.substring(1);
					Method m = c.getMethod(nomemethod,f.getType());
					m.invoke(obj , rs.getObject(nomefield) );
				}
				lista.add(obj);
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return lista;
	}

	@Override
	public void atualiza(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adiciona(T obj) {
		// TODO Auto-generated method stub
		
	}

}
