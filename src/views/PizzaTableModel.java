package views;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.Pizza;

/**
 * @author G
 */
public class PizzaTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Pizza> pizzas;

    public PizzaTableModel(List<Pizza> pizzas) {
        columnNames = new String[]{"Id", "Név", "Ár", "Átmérő", "Csípős"};
        this.pizzas = pizzas;
    }

    @Override

    public int getRowCount() {
        return pizzas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        //System.out.println("getColumnName, columnIndex: " + columnIndex);
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        System.out.println(
//                "getValueAt, rowIndex: " + rowIndex + " columnIndex: " + columnIndex);
        Pizza temp = pizzas.get(rowIndex);
        String value = String.valueOf(temp.getId());
        switch (columnIndex) {
            case 1:
                value = temp.getName();
                break;
            case 2:
                value = temp.getPrice() + "Ft";
                break;
            case 3:
                value = temp.getDiameter() + "cm";
                break;
            case 4:
                value = temp.isSpicy() ? "Igen" : "Nem";
                break;
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
