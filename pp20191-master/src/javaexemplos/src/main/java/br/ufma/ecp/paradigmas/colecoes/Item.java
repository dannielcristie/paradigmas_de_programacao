package br.ufma.ecp.paradigmas.colecoes;

public class Item {

	private String id;
	private String produto;
	private int qt;

	public Item(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	public Item(String id, String produto, int qt) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.produto = produto;
		this.qt = qt;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public String getId() {
		return id;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Item) {
			return getId() == ((Item)obj).getId()  ;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getId().hashCode();
	}


}











