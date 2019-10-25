package br.ufma.ecp.paradigmas.serializacao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Binario {
	
	public static void leBinario () {
	     FileInputStream fis;
		try {
			fis = new FileInputStream("t.tmp");
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      Pessoa p2 = (Pessoa)ois.readObject();
		      System.out.println(p2.getNome());
		      ois.close();
		} catch ( IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void salvaBinario () {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("t.tmp");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);

		    Pessoa p = new Pessoa();
		    p.setIdade(38);
		    p.setNome("sergio");
		    oos.writeObject(p);
		    oos.close();

		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void salvaXML () {
	    XMLEncoder e;
		try {
			e = new XMLEncoder(
			        new BufferedOutputStream(
			            new FileOutputStream("Test.xml")));
			
		    Pessoa p = new Pessoa();
		    p.setIdade(38);
		    p.setNome("ser'gio");
		    
		    e.writeObject(p);
		    e.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    

	}
	
	public static void leXML () {
	      XMLDecoder d;
		try {
			d = new XMLDecoder(
			          new BufferedInputStream(
			              new FileInputStream("Test.xml")));
	      	Pessoa p = (Pessoa) d.readObject();
	      	System.out.println(p.getNome());
			d.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      

	}
	
	public static void salvaJSON () {
		  

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salvaXML();

	}

}
