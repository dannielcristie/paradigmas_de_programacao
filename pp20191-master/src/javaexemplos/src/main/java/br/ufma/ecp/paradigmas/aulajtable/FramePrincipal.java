package br.ufma.ecp.paradigmas.aulajtable;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



public class FramePrincipal extends JFrame {
	
	public FramePrincipal() {
		super("Agenda");
		setSize(300,100);
		
		ContatoDAO dao = new ContatoDAO();
		
		JButton btnCadastro = new JButton("Cadastra contato");
		btnCadastro.addActionListener((ev) -> {
			FrameCadastro frame = new FrameCadastro(dao);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		
		JButton btnLista = new JButton("Lista contatos");
		btnLista.addActionListener((ev) -> {
			FrameContato frame = new FrameContato (dao);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
		
		
		setLayout(new FlowLayout());
		add(btnCadastro);
		add(btnLista);
		

	}

}
