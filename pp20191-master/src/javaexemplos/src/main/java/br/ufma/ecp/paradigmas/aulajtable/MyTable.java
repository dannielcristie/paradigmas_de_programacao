package br.ufma.ecp.paradigmas.aulajtable;

import javax.swing.table.TableModel;

public class MyTable {
	
	TableModel tm;
	public MyTable (TableModel tm) {
		this.tm = tm;

		for (int j = 0; j < tm.getColumnCount(); j++) {
			System.out.print (tm.getColumnName(j) + " " );	
		}
		System.out.println("\n*************************************");

		
		for (int i=0; i < tm.getRowCount();i++) {
			
			for (int j = 0; j < tm.getColumnCount(); j++) {
				System.out.print (tm.getValueAt(i, j) + " " );	
			}
			System.out.println("");
		}
	}

}
