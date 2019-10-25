package br.ufma.ecp.paradigmas.aulaswing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cadastro extends JFrame {
	
	public JTextField txtNome;
	public JTextField txtEmail;
	
	public Cadastro () {
		
		super("Cadastro de contato");
		setSize(300,200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		JPanel panNome = new JPanel(new FlowLayout());
		panNome.add(new JLabel("Nome:"));
		txtNome = new JTextField(15);
		panNome.add(txtNome);

		JPanel panEmail = new JPanel(new FlowLayout());
		panEmail.add(new JLabel("Email:"));
		txtEmail = new JTextField(15);
		panEmail.add(txtEmail);
		
		add(panNome);
		add(panEmail);
	
		JButton btnFechar = new JButton("Fechar");
		//btnFechar.addActionListener(new Finaliza());
		/*
		btnFechar.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}	
		});
		*/
		
		
		btnFechar.addActionListener (  (e) -> {  
			System.exit(1);
		} );
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener (  (e) -> {  
			System.out.println( txtNome.getText() );
			/*
			String nome = txtNome.getText();
			String email = txtEmail.getText();
			Contato contato = new Contato (nome, email);
			dao.add(contato);
			*/
		} );
		
		
		add(btnFechar);
		add(btnCadastrar);
		
				
	}

}
