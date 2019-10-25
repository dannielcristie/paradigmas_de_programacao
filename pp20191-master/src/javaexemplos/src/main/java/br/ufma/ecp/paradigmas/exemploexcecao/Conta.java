package br.ufma.ecp.paradigmas.exemploexcecao;

public class Conta {
	
	private double saldo = 0;
	private double limite = 1000;
	
	public void deposito (double valor) {
		saldo = saldo + valor;
	}
	
	public void saque (double valor) throws SIException,LEException {
		
		if (saldo >= valor ) {
			if (valor <= limite) {
				saldo = saldo - valor;
			}else {
				throw new LEException ();
			}
			
		}else
			throw new SIException ();
	}
	
	public double saldoAtual () {
		return saldo;
	}

}
