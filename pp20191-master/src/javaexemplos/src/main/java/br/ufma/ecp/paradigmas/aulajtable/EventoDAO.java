package br.ufma.ecp.paradigmas.aulajtable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.ufma.ecp.paradigmas.agenda.Contato;

public class EventoDAO implements AbstractDAO<Evento> {
	
	
	
	/* (non-Javadoc)
	 * @see br.ufma.ecp.paradigmas.aulajtable.AbstractDAO#recupera()
	 */
	@Override
	public List<Evento> recupera () {
		
		List<Evento> lista = Arrays.asList(
			new Evento ("12", "JIM 2018", 2018),
			new Evento ("34", "Eacomp 2016", 2016)
		);
		return lista;
		

	}

	@Override
	public void atualiza(Evento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adiciona(Evento obj) {
		// TODO Auto-generated method stub
		
	}
	

}
