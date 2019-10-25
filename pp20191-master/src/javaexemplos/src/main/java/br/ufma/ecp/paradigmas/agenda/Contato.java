package br.ufma.ecp.paradigmas.agenda;

import br.ufma.ecp.paradigmas.aulajtable.Coluna;

public class Contato {

	@Coluna(nome="Nome", pos = 0)
	private String nome;
	@Coluna(nome="Email", pos = 1)
	private String email;
	
	
	//@Coluna(nome="Telefone", pos = 2)
	private String fone;
	
	public Contato() {
	}
	
	public Contato(String nome, String email, String fone) {
		super();
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	
	
	
	
}
