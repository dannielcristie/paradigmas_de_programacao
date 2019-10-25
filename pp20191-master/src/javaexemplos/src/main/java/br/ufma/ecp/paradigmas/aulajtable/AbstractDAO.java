package br.ufma.ecp.paradigmas.aulajtable;

import java.util.List;

import br.ufma.ecp.paradigmas.agenda.Contato;

public interface AbstractDAO<T> {

	List<T> recupera();

	void atualiza(T obj);
	
	void adiciona(T obj);

}