package tsn.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;

/**
 * Доступ к Lookup-полям таблиц БД
 *
 * @author Талипов С.Н.
 */
public class DbComboBox {

    private JComboBox jComboBox;
    private final DbTable dbTable;
    private final String field_name_id;
    private final String field_name;
    private final HashMap<Integer, String> list;

    /**
     * Доступ к Lookup-полям таблиц БД
     *
     * @param jComboBox компонент JComboBox
     * @param dbTable компонент DbTable
     * @param field_name_id имя поля с ID-данными
     * @param field_name имя поля с текстовой расшифровкой ID-данных
     *
     * @throws SQLException
     */
    public DbComboBox(JComboBox jComboBox, DbTable dbTable, String field_name_id,
            String field_name) throws SQLException {
        this.jComboBox = jComboBox;
        this.dbTable = dbTable;
        this.field_name_id = field_name_id;
        this.field_name = field_name;
        list = dbTable.getLookupList(field_name_id, field_name);
        updateList();
    }

    /**
     * Доступ к Lookup-полям таблиц БД //
     *
     * @param dbTable связанный компонент DbTable
     * @param field_name_id имя поля с ID-данными в связанной таблице
     * @param field_name имя поля с текстовой расшифровкой ID-данных в связанной
     * таблице
     * @throws SQLException
     */
    public DbComboBox(DbTable dbTable,
            String field_name_id, String field_name) throws SQLException {
        this(new JComboBox(), dbTable, field_name_id, field_name);
    }

    /**
     * Получение ID выбранной (текущей) записи списка
     *
     * @return возвращает ID выбранной (текущей) записи списка (-1 при неудаче)
     */
    public final int getIdForSelectedRow() {
        try {
            int k = jComboBox.getSelectedIndex();
            int i = 0;
            for (Map.Entry record : list.entrySet()) {
                if (k == i++) {
                    return (int) record.getKey();
                }
            }
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * Получение номера строки по значению ID
     *
     * @param id код ID
     * @return выдает номер строки по значению ID (-1 при неудаче)
     */
    public final int getRowNumberForId(int id) {
        try {
            int i = 0;
            for (Map.Entry record : list.entrySet()) {
                if (record.getKey().equals(id)) {
                    return i;
                }
                i++;
            }
        } catch (Exception e) {
        }
        return -1;
    }

    private void updateList() {
        // Загрузка списка
        try {
            jComboBox.removeAllItems();
            for (Map.Entry record : list.entrySet()) {
                jComboBox.addItem((String) record.getValue());
            }
            jComboBox.setSelectedIndex(0);
        } catch (Exception e) {
        }
    }
    
}
