package br.ufma.ecp.paradigmas.aulajtable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.ufma.ecp.paradigmas.agenda.Contato;
import br.ufma.ecp.paradigmas.agenda.ContatoDAO;

public class ContatoSelTableModel extends AbstractTableModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ContatoDAO dao;
	List<Contato> dados;
	List<Contato> selecionados;
	List<String> colunas = Arrays.asList("Email", "Nome", "Telefone");
	
	public ContatoSelTableModel (ContatoDAO dao) {
		this.dao = dao;
		
		dados = dao.recupera();
		selecionados = dados;
		
		
		this.addTableModelListener((ev) -> {
			int i = ev.getFirstRow();
			Contato contato = dados.get(i);  
			dao.atualiza(contato); 
		});
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub

		return  selecionados.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		//Contato c =  (selecionados.collect(Collectors.toList())).get(row);
		Contato c = selecionados.get(row);
		switch  (col) {
		case 0 :
			return c.getEmail();
		case 1:
			return c.getNome();
		case 2:
			return c.getFone();
		default:
			throw new IndexOutOfBoundsException ("");
			
		}
		
		
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return colunas.get(col);
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		return col != 0;
	}

	@Override
	public void setValueAt(Object obj, int row, int col) {
		// TODO Auto-generated method stub
		Contato c = selecionados.get(row);
		switch  (col) {
		case 0 :
			c.setEmail( (String) obj);
			break;
		case 1:
			c.setNome((String)obj);
			break;
		case 2:
			c.setFone((String)obj);
			break;
		default:
			throw new IndexOutOfBoundsException ("");
			
		}
		fireTableCellUpdated(row, col);
	}
	
	
	public void filtrar (String nome) {
		
		
		selecionados = dados.stream()
				.filter( (c) -> c.getNome().indexOf(nome) > -1 )
				.collect(Collectors.toList());
		
		fireTableDataChanged();
	}
	
	

}
