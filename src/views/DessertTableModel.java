package views;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.Dessert;

/**
 * @author G
 */
public class DessertTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Dessert> data;

    public DessertTableModel(List<Dessert> desserts) {
        columnNames = new String[]{"Id", "Név", "Ár", "Méret"};
        this.data = desserts;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dessert temp = data.get(rowIndex);
        String result = temp.getName();
        switch (columnIndex) {
            case 0:
                result = String.valueOf(temp.getId());
                break;
            case 2:
                result = String.valueOf(temp.getPrice());
                break;
            case 3:
                result = temp.isBig() ? "Nagy" : "Kicsi";
                break;
        }
        return result;
    }

}
