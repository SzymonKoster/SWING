import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel{

        private List<String> columns;
        private List<Student> data;

        protected StudentTableModel(List<String> columns, List<Student> data) {
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
                case 0 -> this.data.get(rowIndex).getImie();
                case 1 -> this.data.get(rowIndex).getNazwisko();
                case 2 -> this.data.get(rowIndex).getStanStudenta();
                case 3 -> this.data.get(rowIndex).getRokUrodzenia();
                case 4 -> this.data.get(rowIndex).getIloscPunktow();
                default -> "";
            };

        }


}
