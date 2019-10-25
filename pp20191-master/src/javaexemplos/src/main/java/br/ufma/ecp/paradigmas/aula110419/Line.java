package br.ufma.ecp.paradigmas.aula110419;

public class Line extends Geometry implements Drawable {

	@Override
	public void draw() {
		System.out.println("desenhando linha");
	}

	@Override
	public int perimeter() {
		return 10;
	}
	
}
