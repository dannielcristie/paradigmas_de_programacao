package br.ufma.ecp.paradigmas.aulajtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.ufma.ecp.paradigmas.agenda.ContatoDAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		FramePrincipal frame = new FramePrincipal ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);
		
		
		
		/*
		String colunas[] = {"matricula", "nome"};
		Object dados[][] = 	{
				{"1212131", "joao"},
				{"5654656546", "maria"},
				{"6767867", "lorena"},
			};
		
		//TableModel tabela = new DefaultTableModel (  dados, colunas);
		
		TableModel tabela = new ContatoTableModel(new ContatoDAO());

		MyTable table = new MyTable (tabela);
		*/
		
	}

}
