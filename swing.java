import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App 
{
    public static void main( String[] args ){
    	JFrame frame = new JFrame();
    	frame.setLayout(new FlowLayout());
    	frame.setLayout(new GridLayout());
    	
    	
    	JPanel panNome = new JPanel();
    	
    	panNome.setLayout(new FlowLayout());    	
    	panNome.add(new JLabel("Nome:"));    	
    	JTextField txtNome = new JTextField(15);    	
    	panNome.add(txtNome);
    	
    	JPanel panEmail = new JPanel();
    	panEmail.add(new JLabel("Email:"));
    	JTextField txtEmail = new JTextField(15);
    	panEmail.add(txtEmail);
    	
    	frame.add(panNome);
    	frame.add(panEmail);
    	
    	
    /*	
    	JButton bt1 = new JButton("Home");
    	frame.add(bt1);
    	frame.add(new JButton("produtos"));
    	
    	for(int i=1;i<7;i++) {
    		frame.add(new JButton("Botão"+i));
    	}
    	
    	*/		
    	frame.setVisible(true);
    	frame.setSize(400,400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        
    	
    	
    }
}
