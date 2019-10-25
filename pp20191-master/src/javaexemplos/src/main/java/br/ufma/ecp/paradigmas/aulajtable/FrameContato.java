package br.ufma.ecp.paradigmas.aulajtable;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.ufma.ecp.paradigmas.agenda.Contato;



public class FrameContato extends JFrame {
	
	public FrameContato (ContatoDAO dao) {
		super ("lista contatos");
		
		
		AbstractDAO dao2 = new EventoDAO();
		
		GenericTableModel<Evento> tbl = new GenericTableModel<Evento>(dao2);
		//GenericTableModel<Contato> tbl = new GenericTableModel<Contato>(dao);
		
		JTable table = new JTable (tbl);
		JPanel panelButtons = new JPanel ();
		JPanel panelTable = new JPanel ();
		JButton btnFiltrar = new JButton ("Filtrar"); 
		JTextField txtNome = new JTextField(15);
		
		
		
		
		btnFiltrar.addActionListener( (ev) -> {
			
			
		});
		
		
		panelButtons.add(btnFiltrar);
		panelButtons.add(txtNome);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		panelTable.add(scroll);
		setLayout(new FlowLayout()  );
		add (panelButtons);
		add (panelTable);
		setSize(450,200);
		
	}

	
}
