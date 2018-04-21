package tsn.jdbc;

import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * НАВИГАТОР ПО ЗАПИСЯМ ТАБЛИЦЫ БД
 *
 * @author Талипов С.Н.
 */
public class DbTableNavigator {

    private final JTable jTable;
    private final DbTable dbTable;
    private final DbTableModel dbModel;
    private int[] removeColumn;
    private String[] HeaderValue;
    private int[] PreferredWidth;
    private int bookmark;

    /**
     * НАВИГАТОР ПО ЗАПИСЯМ ТАБЛИЦЫ БД
     *
     * @param jTable визуальная таблица JTable
     * @param dbTable таблица DbTable
     * @param editable разрешение редактирования данных в таблице
     *
     * @throws Exception
     */
    public DbTableNavigator(JTable jTable, DbTable dbTable, boolean editable) throws Exception {
        this.jTable = jTable;
        this.dbTable = dbTable;
        this.dbModel = new DbTableModel(dbTable, editable);
    }

    /**
     * Поиск записи и переход на найденную строку таблицы
     *
     * @param column колонка в которой искать текст (с нуля)
     * @param text искомый текст
     */
    public final void find(int column, String text) {
        try {
            text = text.toUpperCase();
            for (int i = 0; i < jTable.getModel().getRowCount(); i++) {
                if (jTable.getValueAt(i, column).toString().toUpperCase().indexOf(text.toUpperCase()) > -1) {
                    jTable.setRowSelectionInterval(i, i);
                    jTable.scrollRectToVisible(jTable.getCellRect(i, i, true));
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * На первую запись таблицы
     */
    public final void first() {
        try {
            int r = 0;
            jTable.setRowSelectionInterval(r, r);
            jTable.scrollRectToVisible(jTable.getCellRect(r, r, true));
        } catch (Exception e) {
        }
    }

    /**
     * На последнюю запись таблицы
     */
    public final void last() {
        try {
            int r = jTable.getModel().getRowCount() - 1;
            jTable.setRowSelectionInterval(r, r);
            jTable.scrollRectToVisible(jTable.getCellRect(r, r, true));
        } catch (Exception e) {
        }
    }

    /**
     * На предыдущую запись таблицы
     */
    public final void prior() {
        try {
            int r = jTable.getSelectedRow() - 1;
            if (r < 0) {
                return;
            }
            jTable.setRowSelectionInterval(r, r);
            jTable.scrollRectToVisible(jTable.getCellRect(r, r, true));
        } catch (Exception e) {
        }
    }

    /**
     * На следующую запись таблицы
     */
    public final void next() {
        try {
            int r = jTable.getSelectedRow() + 1;
            if (r > jTable.getModel().getRowCount() - 1) {
                return;
            }
            jTable.setRowSelectionInterval(r, r);
            jTable.scrollRectToVisible(jTable.getCellRect(r, r, true));
        } catch (Exception e) {
        }
    }

    private void updateFromDB() {
        // Обновление данных с БД
        try {
            dbTable.updateFromDB();
            dbModel.setDataSource();
        } catch (Exception ex) {
        }
    }

    /**
     * Удаление выделенной записи в таблице
     *
     * @return успех/неудача удаления записи
     */
    public final boolean delete() {
        try {
            if (getRecordCountTable() == 0) {
                return false;
            }
            int rowIndex = jTable.convertRowIndexToModel(jTable.getSelectedRow());
            int k = 0;
            try {
                k = jTable.convertRowIndexToModel(jTable.getSelectedRow() + 1);
            } catch (Exception e) {
            }
            dbTable.data.absolute(rowIndex + 1);
            dbTable.data.deleteRow();
            updateFromDB();
            updateFromDbTable();
            gotoTableRow(k);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Не могу удалить запись!\n"
                    + "Возможно есть ссылки на нее в других таблицах!");
        }
        return false;
    }

    /**
     * Добавить новую запись в таблицу
     *
     * @return успех/неудача добавления записи
     */
    public final boolean append() {
        try {
            boolean f = dbTable.isFiltered();
            dbTable.setFiltered(false);
            dbTable.data.moveToInsertRow();
            dbTable.beforeAppendNewRecord();
            for (Map.Entry record : dbTable.lookupFields.entrySet()) {
                dbTable.data.updateInt((String) record.getKey(), (int) record.getValue());
            }
            dbTable.data.insertRow();
            updateFromDB();
            setColumnTable();
            first();
            jTable.requestFocus();
            jTable.editCellAt(0, 0);
            dbTable.setFiltered(f);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Не могу добавить запись! \nПроверьте наличие данных в связанных таблицах и уникальность названий!");
        }
        return false;
    }

    /**
     * Выполнить команду
     *
     * @param action номер команды (0 - на первую запись, 1 - на предыдущую, 2 -
     * на следующую, 3 - на последнюю 4 - добавление новой записи, 5 - удаление
     * выделенной записи, 6 - обновление с БД)
     * @return успех или неудача (для удаления и добавления записи)
     */
    public final boolean execAction(int action) {
        try {
            switch (action) {
                case 0: {
                    first();
                    break;
                }
                case 1: {
                    prior();
                    break;
                }
                case 2: {
                    next();
                    break;
                }
                case 3: {
                    last();
                    break;
                }
                case 4: {
                    return append();
                }
                case 5: {
                    if (JOptionPane.showConfirmDialog(null, "Удалить запись ?",
                            "Подтверждение", 0) == JOptionPane.YES_OPTION) {
                        return delete();
                    }
                    break;
                }
                case 6: {
                    updateFromDbTable();
                    break;
                }

            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Установка параметров колонок JTable (автопереход на первую запись)
     *
     * @param removeColumn массив номеров колонок для скрытия
     * @param HeaderValue названия столбцов таблицы (без скрытых)
     * @param PreferredWidth массив ширины для каждого столбца таблицы (без
     * скрытых)
     */
    public final void initColumnTable(int[] removeColumn, String[] HeaderValue, int[] PreferredWidth) {
        try {
            this.removeColumn = removeColumn;
            this.HeaderValue = HeaderValue;
            this.PreferredWidth = PreferredWidth;
            jTable.getTableHeader().setReorderingAllowed(false); // Запрет перемещения столбцов
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Запрет авторазмера столбцов
            jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Одинарный режим выделения строки
            jTable.setModel(dbModel); // Устанавливаем у таблицы jTable модель таблицы БД
            setColumnTable();
            first();
        } catch (Exception e) {
        }
    }

    /**
     * Настройка колонок таблицы JTable
     */
    private void setColumnTable() {
        try {
            // Удаление лишних столбцов
            for (int i = 0; i < removeColumn.length; i++) {
                jTable.removeColumn(jTable.getColumnModel().getColumn(i));
            }
            for (int i = 0; i < HeaderValue.length; i++) {
                jTable.getColumnModel().getColumn(i).setHeaderValue(HeaderValue[i]);
            }
            // Настройка ширины столбцов
            for (int i = 0; i < PreferredWidth.length; i++) {
                jTable.getColumnModel().getColumn(i).setPreferredWidth(PreferredWidth[i]);
            }
            // Включение сортировки по первой колонке
            jTable.getRowSorter().toggleSortOrder(1);
        } catch (Exception e) {
        }
    }

    /**
     * Установить закладку на запись в таблице
     */
    public final void setBookmarkTable() {
        bookmark = getCurrentRowTable();
    }

    /**
     * Перейти на сохраненную закладку (запись) в таблице (или на первую при
     * ошибке перехода)
     */
    public final void gotoBookmarkTable() {
        gotoTableRow(bookmark);
    }

    /**
     * Обновление таблицы JTable из таблицы БД
     */
    public final void updateFromDbTable() {
        try {
            setBookmarkTable();
            try {
                dbTable.updateFromDB();
            } catch (Exception ex) {
            }
            try {
                dbModel.setDataSource();
            } catch (Exception ex) {
            }
            setColumnTable();
            gotoBookmarkTable();
        } catch (Exception ex) {
        }
    }

    /**
     * Получение текущей строки таблицы (0 - при отсутствии выделенной строки в
     * таблице)
     *
     * @return номер текущей строки таблицы
     */
    public final int getCurrentRowTable() {
        int cr = 0;
        int r;
        try {
            r = jTable.convertRowIndexToModel(jTable.getSelectedRow());
            cr = r;
            return cr;
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * Переход к нужной строке таблицы (или на первую при ошибке перехода)
     *
     * @param numRec номер строки для перехода
     */
    public final void gotoTableRow(int numRec) {
        try {
            int r = jTable.convertRowIndexToView(numRec);
            jTable.setRowSelectionInterval(r, r);
            jTable.scrollRectToVisible(jTable.getCellRect(r, r, true));
        } catch (Exception e) {
            first();
        }
    }

    /**
     * Получение количества записей в таблице
     *
     * @return количество записей в таблице
     */
    public final int getRecordCountTable() {
        return jTable.getModel().getRowCount();
    }
}
