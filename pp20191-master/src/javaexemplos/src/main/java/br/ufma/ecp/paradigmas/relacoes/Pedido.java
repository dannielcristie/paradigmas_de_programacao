package br.ufma.ecp.paradigmas.relacoes;

import java.util.ArrayList;
import java.util.List;

class Pedido {

    private List itens;

    public Pedido () {
        itens = new ArrayList();
    }

    public void addItem(Item it) {
        itens.add(it);
    }
    
 


}