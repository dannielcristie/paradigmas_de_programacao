package br.ufma.ecp.paradigmas.exemploexcecao;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c = new Conta ();
		c.deposito (999.0);
		try {
			c.saque (1000);
		} catch (SIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Seu saldo foi insuficiente");
			
		} catch (LEException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Seu limite foi excedido");
		}
		
		
		// liberar o dinheiro
		
		System.out.println(c.saldoAtual());
	}

}
