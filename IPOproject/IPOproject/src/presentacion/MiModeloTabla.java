package presentacion;

import java.util.*;

import javax.swing.JTable;
import javax.swing.table.*;

class MiModeloTabla extends AbstractTableModel {
	private String[] nombreColumnas = { "Tarea","Fecha Creación", "Fecha finalización", "Responsable", "Prioridad", "Estado" };
	private Vector datos = new Vector();

	
	public void deleteAll() {
		for (int i= 0; i<datos.size(); i ++)
			datos.remove(i);
	}
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public String getColumnName(int col) {
		return nombreColumnas[col];
	}

	public Object getValueAt(int row, int col) {
		Object[] fila = (Object[]) datos.elementAt(row);
		return fila[col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		if (row < getRowCount() && col < getColumnCount()) {
			Object[] fila = (Object[]) datos.elementAt(row);
			fila[col] = value;
			fireTableCellUpdated(row, col);
		}
	}
	
	public void sort(JTable j) {
		TableRowSorter<MiModeloTabla> sorter= new TableRowSorter<MiModeloTabla>();
		j.setRowSorter(sorter);
	}
	
	public void eliminaFila(int row) {
		datos.remove(row);
	}

	public void aniadeFila(Object[] row) {
		datos.add(row);
	}
}