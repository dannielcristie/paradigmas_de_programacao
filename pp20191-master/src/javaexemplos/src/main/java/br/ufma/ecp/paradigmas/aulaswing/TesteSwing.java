package br.ufma.ecp.paradigmas.aulaswing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Finaliza implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(1);
	}
	
}


public class TesteSwing {

	
	
	public static void calculador () {
		JFrame frame = new JFrame();
		frame.setSize(200,200);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		JPanel panel = new JPanel (); 
		JTextField text = new JTextField(15);
		frame.add(text);
		panel.setLayout(new GridLayout(4,3) );
		//List l = Arrays.asList("0", "1", )
		for (int i = 0; i < 10; i++) {
			JButton bt = new JButton (String.valueOf(i));	
			frame.add(bt);
		}
		frame.add(panel);
	
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cadastro janela = new Cadastro();
		janela.setVisible(true);
	}

}















