package br.ufma.ecp.paradigmas.javafuncional;

import java.util.List;

public class SumAlgorithm implements Algorithm {

	@Override
	public Integer apply(List<Pixel> pixels) {
		Integer sum = 0;
		
		for (Pixel p: pixels) {
			sum = sum + p.getValue();
		}
		return sum;
	}

}
