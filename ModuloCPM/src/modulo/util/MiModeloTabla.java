package modulo.util;

import javax.swing.table.DefaultTableModel;

public class MiModeloTabla extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public MiModeloTabla(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
   }
	@Override
	public boolean isCellEditable(int row, int column) {
        return false;
    }
}
