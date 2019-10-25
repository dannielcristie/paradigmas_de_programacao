package br.ufma.ecp.paradigmas.metaprogramacao;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ufma.ecp.paradigmas.agenda.Contato;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato c = new Contato ("Joao", "jj@gmail.com", "999999");
		Class cl = c.getClass();
		System.out.println(cl.getCanonicalName() );
		for (Field f : cl.getDeclaredFields()) {
			System.out.println(f.getName() );
		}
		
		for (Method m : cl.getDeclaredMethods() ) {
			System.out.println(m.getName() );
		}
		
		try {
			Method m1 = cl.getMethod("getEmail");
			try {
				String s = (String) m1.invoke(c);
				System.out.println(s);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
