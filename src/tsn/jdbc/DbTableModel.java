package tsn.jdbc;

import javax.swing.table.*;
import java.sql.*;
import java.util.*;

/**
 * МОДЕЛЬ ТАБЛИЦЫ БД
 *
 * @author Талипов С.Н.
 */
public class DbTableModel extends AbstractTableModel {

    private final DbTable dbTable; // Таблица данных
    private ResultSet set; // Набор данных
    private final ArrayList columnNames = new ArrayList(); // Список названий колонок
    private final ArrayList columnTypes = new ArrayList(); // Список типов столбцов
    private final ArrayList data = new ArrayList(); // Хранилище для полученных данных из БД
    private final boolean editable; // Разрешение редактирования таблицы

    /**
     * Инициализация модели таблицы БД
     * @param dbTable Таблица DbTable
     * @param editable Разрешение/запрет редактирования данных в таблице
     * @throws Exception
     */
    public DbTableModel(DbTable dbTable, boolean editable) throws Exception {
        this.dbTable = dbTable;
        this.editable = editable;
        setDataSource();
    }

    /**
     * Загрузка модели данных с таблицы БД
     *
     * @throws Exception
     */
    public final void setDataSource() throws Exception {
        dbTable.updateFromDB();
        set = dbTable.data;
        HashMap<String, Object> lookupFields = dbTable.lookupFields;
        data.clear();
        columnNames.clear();
        columnTypes.clear();
        ResultSetMetaData rsmd = set.getMetaData();
        int columnCount = rsmd.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(rsmd.getColumnName(i + 1)); // Название столбца
            Class type = Class.forName(rsmd.getColumnClassName(i + 1)); // Тип столбца
            columnTypes.add(type);
        }
        fireTableStructureChanged(); // Сообщаем об изменениях в структуре данных
        // Получаем данные
        set.beforeFirst();
        while (set.next()) {
            ArrayList row = new ArrayList();
            for (int i = 0; i < columnCount; i++) {
                if (lookupFields.get(columnNames.get(i)) == null) {
                    if (columnTypes.get(i).equals(String.class)) {
                        row.add(set.getString(i + 1));
                    } else {
                        row.add(set.getObject(i + 1));
                    }
                } else {
                    HashMap<Integer, String> list = (HashMap<Integer, String>) lookupFields.get(columnNames.get(i));
                    for (Map.Entry record : list.entrySet()) {
                        if (record.getKey().equals(set.getObject(i + 1))) {
                            columnTypes.set(i, String.class);
                            row.add(record.getValue());
                        }
                    }
                }

            }
            synchronized (data) {
                data.add(row);
                fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }
        }

    }

    /**
     * Проверка возможности редактирования
     *
     * @param row строка
     * @param column колонка
     * @return
     */
    public boolean isEditable(int row, int column) {
        return editable;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Проверка возможности редактирования
        return editable;
    }

    @Override
    public int getRowCount() {
        // Получение количества строк
        synchronized (data) {
            return data.size();
        }
    }

    @Override
    public int getColumnCount() {
        // Получение количества столбцов
        return columnNames.size();
    }

    @Override
    public Class getColumnClass(int column) {
        // Получение типа данных столбца
        return (Class) columnTypes.get(column);
    }

    @Override
    public String getColumnName(int column) {
        // Получение названия столбца
        return (String) columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        // Выдача значения данных из модели в ячейку
        synchronized (data) {
            return ((ArrayList) data.get(row)).get(column);
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        // Изменение данных в ячейке таблицы
        synchronized (data) {
            try {
                ((ArrayList) data.get(row)).set(column, value);
                set.absolute(row + 1);
                if (columnTypes.get(column) == String.class) {
                    set.updateString(getColumnName(column), ((ArrayList) data.get(row)).set(column, value).toString());
                }
                if (columnTypes.get(column) == Float.class) {
                    set.updateFloat(getColumnName(column), (Float.parseFloat(((ArrayList) data.get(row)).set(column, value).toString())));
                }
                if (columnTypes.get(column) == Integer.class) {
                    set.updateInt(getColumnName(column), (Integer.parseInt(((ArrayList) data.get(row)).set(column, value).toString())));
                }
                if (columnTypes.get(column) == Double.class) {
                    set.updateDouble(getColumnName(column), (Double.parseDouble(((ArrayList) data.get(row)).set(column, value).toString())));
                }
                set.updateRow();
                fireTableDataChanged();
            } catch (Exception ex) {
            }
        }
    }
}
