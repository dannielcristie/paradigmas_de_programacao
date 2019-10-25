package br.ufma.ecp.paradigmas.aula110419;

import java.util.Arrays;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Canvas ca = new Canvas();
		ca.draw( new Point (10,20) );
		ca.draw( new Line() );
		ca.printTotalArea(Arrays.asList(
					new Line()
		));
	}

}
