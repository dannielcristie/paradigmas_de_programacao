package br.ufma.ecp.paradigmas.javafuncional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Imagem {
	private List<Pixel> pixels;
	
	public Imagem (String fn) {
		pixels = Arrays.asList(
				new Pixel (0,0, 10),
				new Pixel (0,1, 200),
				new Pixel (1,0, 40),
				new Pixel (1,1, 50)
		);
	}
	
	public Integer process (Algorithm algo) {
		return algo.apply (pixels);
				
	}

}
