package br.ufma.ecp.paradigmas.serializacao;

import java.io.Serializable;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -888060518550146902L;
	
	private String nome;
	private Integer idade;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
