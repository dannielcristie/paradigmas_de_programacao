package br.ufma.ecp.paradigmas.sigaa;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private List<Participante> participantes;
	
	public Turma () {
		participantes = new ArrayList<Participante>();
	}
	public void addParticipante (Participante d) {
		participantes.add(d);
	}
	


}
