package br.ufma.ecp.paradigmas.relacoes;

class Teste {



    public static void main (String arg[]) {
        Produto p = new Produto ();
        Item i = new Item ("123", p);
        Pedido ped = new Pedido();
        ped.addItem(i);

    

    }
}