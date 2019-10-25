package br.ufma.ecp.paradigmas.aula110419;

public class Point implements Drawable {
	
	private int x;
	private int y;

	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public void draw() {		
		System.out.println("desenhando ponto "+x +" "+y);
	}
	


}
