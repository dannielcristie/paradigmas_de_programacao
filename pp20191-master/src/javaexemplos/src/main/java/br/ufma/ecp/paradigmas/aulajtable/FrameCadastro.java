package br.ufma.ecp.paradigmas.aulajtable;



import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufma.ecp.paradigmas.agenda.Contato;


public class FrameCadastro extends JFrame {
	
	public JTextField txtNome;
	public JTextField txtEmail;
	public JTextField txtFone;
	private ContatoDAO dao;
	
	public FrameCadastro (ContatoDAO dao) {
		
		super("Cadastro de contato");
		setSize(300,200);
		setLayout(new FlowLayout());
		
		JPanel panNome = new JPanel(new FlowLayout());
		panNome.add(new JLabel("Nome:"));
		txtNome = new JTextField(15);
		panNome.add(txtNome);

		JPanel panEmail = new JPanel(new FlowLayout());
		panEmail.add(new JLabel("Email:"));
		txtEmail = new JTextField(15);
		panEmail.add(txtEmail);

		JPanel panFone = new JPanel(new FlowLayout());
		panFone.add(new JLabel("Fone:"));
		txtFone = new JTextField(15);
		panFone.add(txtFone);

		add(panNome);
		add(panEmail);
		add(panFone);
	
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener (  (e) -> {  
			System.out.println(  );
			Contato contato = new Contato (
					txtNome.getText(),
					txtEmail.getText(),
					txtFone.getText()
					);
					
			dao.adiciona(contato);
			dispose();
		} );
		

		add(btnCadastrar);
		
}
}
