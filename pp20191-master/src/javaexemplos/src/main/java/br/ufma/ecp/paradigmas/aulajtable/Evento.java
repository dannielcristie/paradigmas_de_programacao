package br.ufma.ecp.paradigmas.aulajtable;

public class Evento {
	
	@Coluna(nome="ID", pos = 0)
	private String id;
	@Coluna(nome="Nome", pos = 1)
	private String nome;

	@Coluna(nome="Ano", pos = 2)
	private Integer ano;
	
	public Evento(String id, String nome, Integer ano) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.nome = nome;
		this.ano = ano;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
