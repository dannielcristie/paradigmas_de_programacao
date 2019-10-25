package br.ufma.ecp.paradigmas.aula110419;

import java.util.List;

public class Canvas {
	
	public void draw (Drawable geo) {
		System.out.println("desenhando no canvas");
		geo.draw();
	}
	
	public void printTotalArea (List<Geometry> l) {
		int total = 0;
		for (Geometry g : l) {
			total = total + g.perimeter();
		}
		System.out.println(total);
	}
	

}
