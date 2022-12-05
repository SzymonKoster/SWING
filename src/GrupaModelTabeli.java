import javax.swing.table.AbstractTableModel;
import java.util.List;


public class GrupaModelTabeli extends AbstractTableModel {
    private List<String> columns;
    private List<Class> data;

    protected GrupaModelTabeli(List<String> columns, List<Class> data) {
        super();
        this.columns = columns;
        this.data = data;
    }



    @Override
    public String getColumnName(int column) {
        return this.columns.get(column);
    }

    @Override
    public java.lang.Class<?> getColumnClass(int columnIndex) {
        if(this.getValueAt(0, columnIndex) != null)
            return this.getValueAt(0, columnIndex).getClass();
        else
            return Object.class;
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch(columnIndex) {
            case 0 -> this.data.get(rowIndex).getNazwaGrupy();
            case 1 -> this.data.get(rowIndex).getMaksymalnaIloscStudentow();
            case 2 -> this.data.get(rowIndex).getProcentZapelnieniaGrupy();
            default -> "";
        };

    }
}
