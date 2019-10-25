package br.ufma.ecp.paradigmas.sigaa;

public class Participante extends Object {

	private String nome;
	private String email;
	
	
	public Participante(String nome, String email) {
		this.nome = nome;
		this.email = email;
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
	
	public String toString() {
		//return "("+nome+","+ email+")";
		return nome;
	}
	

	@Override
	public boolean equals(Object other) {
		return this.email.equals(((Participante)other).email); 
	}


}
