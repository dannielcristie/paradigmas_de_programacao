package br.ufma.ecp.paradigmas.aulajtable;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.ufma.ecp.paradigmas.agenda.Contato;


public class GenericTableModel<T> extends AbstractTableModel  {
	
	AbstractDAO dao;
	List<T> dados;
		
	public GenericTableModel (AbstractDAO dao) {
		this.dao = dao;
		
		dados = dao.recupera();
		
		/*
		this.addTableModelListener((ev) -> {
			int i = ev.getFirstRow();
			Contato contato = dados.get(i);  
			dao.atualiza(contato); 
		});
		*/
	}

	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		Class c = dados.get(0).getClass();
		int conta = 0;
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				conta++;
			}
		}
		return conta;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		
		T obj = dados.get(row);
		Class c = obj.getClass();
		
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					String nomefield = f.getName();
					String nomemethod = "get" 
					  + nomefield.substring(0,1).toUpperCase()
					  + nomefield.substring(1);
					//System.out.println(nomemethod);
					try {
						Method m = c.getMethod(nomemethod);
						return m.invoke(obj);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				
				}
			}
		}
		

		return null;
	}
	


	@Override
	public String getColumnName(int col) {
		Class c = dados.get(0).getClass();
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					return a.nome();
				}
			}
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		return col != 0;
	}

	
	@Override
	public void setValueAt(Object value, int row, int col) {
		T obj = dados.get(row);
		Class<? extends Object> c = obj.getClass();
		
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					String nomefield = f.getName();
					String nomemethod = "set" 
					  + nomefield.substring(0,1).toUpperCase()
					  + nomefield.substring(1);
					System.out.println(value);
					System.out.println(value.getClass());
					
					try {
						Method m = c.getMethod(nomemethod,value.getClass());
						m.invoke(obj, value);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
										
				
				}
			}
		}
		fireTableCellUpdated(row, col);
	}


	@Override
	public Class<?> getColumnClass(int col) {
		// TODO Auto-generated method stub
		Class c = dados.get(0).getClass();
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					return f.getType();
				}
			}
		}
		return null;
	}
	
	
	

}
