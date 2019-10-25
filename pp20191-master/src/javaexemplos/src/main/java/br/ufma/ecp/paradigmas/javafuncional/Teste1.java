package br.ufma.ecp.paradigmas.javafuncional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class Teste1 {
	
	public static void main (String args[]) {
		Imagem im = new Imagem ("im.png");
		
		// objetos com nomes
		/*
		SumAlgorithm s = new SumAlgorithm();
		Integer r = im.process(s);
		System.out.println(r);
		*/
		
		// objeto anonimo
		/*
		Integer r = im.process(new SumAlgorithm());
		System.out.println(r);
		*/
		
		// classes anonimas
		/*
		Integer r = im.process(new Algorithm() {
			@Override
			public Integer apply(List<Pixel> pixels) {
				Integer sum = 0;
				for (Pixel p: pixels) {
					sum = sum + p.getValue();
				}
				return sum;
			}
		});
		System.out.println(r);
		*/
		
		// java8, criaram o conceito de interfaces funcionais
		// interfaces funcionais sao todas aquelas que tem apenas um metodo abstrato
		// interfaces funcionais podemos usar a notação lambda
		/*
		Integer r = im.process ( pixels  -> {
			Integer sum = 0;
			for (Pixel p: pixels) {
				sum = sum + p.getValue();
			}
			return sum;
		
		});  
		System.out.println(r);
		*/
		// usar funções de alta ordem
		/*
		Integer r = im.process ( pixels  -> {
			Integer r1 = pixels.stream()
				.map(p -> p.getValue())
				.reduce((a,b) -> a + b ).orElse(-1);
			return r1;
		});  
		System.out.println(r);
		*/
		
		/*
		// method reference Integer::sum
		Integer r = im.process ( pixels  -> {
			Integer r1 = pixels.stream()
				.map(p -> p.getValue())
				.reduce(Integer::sum).orElse(-1);
			return r1;
		});  
		System.out.println(r);
		*/
		// mapToInt
		Integer r = im.process ( pixels  -> 
			 pixels.stream()
				.mapToInt(p -> p.getValue())
				.sum()
		);  
		System.out.println(r);
		
		List<Pixel> l =  Arrays.asList(
				new Pixel (0,0, 10),
				new Pixel (0,1, 200),
				new Pixel (1,0, 40),
				new Pixel (1,1, 50)
		);		
		// java 7
		/*
		Collections.sort(l, new Comparator<Pixel> () {

			@Override
			public int compare(Pixel o1, Pixel o2) {
				// TODO Auto-generated method stub
				return o1.getValue() - o2.getValue();
			}
			
		});
		System.out.println(l);
		*/
		
		// methods default, agora a interface list tem um metodo sort
		//l.sort( (p1, p2) -> p1.getValue() - p2.getValue() );
		//System.out.println(l);
		
		//method reference
		l.sort(comparingInt(Pixel::getValue));
		//System.out.println(l);
		/*
		for (Pixel p : l) {
			System.out.println(p.getValue());
		}*/
		//l.forEach(p ->System.out.println (p.getValue()));
		l.forEach(Pixel::printValue); // l.forEach(p -> p.printValue());
		
	}
}



