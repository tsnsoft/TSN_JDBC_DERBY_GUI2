package tsn.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * ДОСТУП К ТАБЛИЦЕ ДАННЫХ
 *
 * @author Талипов С.Н.
 */
public class DbTable {

    /**
     * Набор данных из таблицы БД
     */
    public ResultSet data;
    /**
     * Lookup-поля таблицы БД (HashMap: String, Object)
     */
    public HashMap<String, Object> lookupFields = new LinkedHashMap(); // Набор Lookup-полей
    private final Connection connection; // Подключение к БД
    private final String table_name; // Имя таблицы БД
    private final Statement statment; // Оператор доступа к базе данных
    boolean filtered; // Разрешение фильтрации данных

    /**
     * Проверка режима фильтрации
     *
     * @return включена или выключена фильтрация
     */
    public boolean isFiltered() {
        return filtered;
    }

    /**
     * Разрешение / запрет фильтрации данных
     *
     * @param filtered разрешить / запретить фильтровать данные
     */
    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    /**
     * Создание объекта доступа к базе данных
     *
     * @param dbConnection база данных (DbConnection)
     * @param table_name имя таблицы БД
     *
     * @throws SQLException
     */
    public DbTable(DbConnection dbConnection, String table_name) throws SQLException {
        this.filtered = true;
        this.table_name = table_name;
        this.connection = dbConnection.connection;
        statment = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        updateFromDB();
    }

    /**
     * Обновление данных таблицы БД (с учетом фильтрации при ее разрешении)
     *
     * @see isFiltered()
     * @see setFiltered(boolean filtered)
     *
     * @throws SQLException
     */
    public final void updateFromDB() throws SQLException {
        String filter = "";
        if (isFiltered()) {
            try {
                filter = getFilter();
            } catch (Exception e) {
                filter = "";
            }
        }
        if (filter.equals("")) {
            statment.execute("SELECT * FROM " + table_name); // Выборка таблицы
        } else {
            statment.execute("SELECT * FROM " + table_name + " WHERE " + filter); // Выборка таблицы
        }
        data = statment.getResultSet();
        afterUpdateFromDB();
    }

    /**
     * Выполнение запроса к БД
     *
     * @param sql текст SQL-запроса к БД
     *
     * @throws SQLException
     */
    public void ExecSql(String sql) throws SQLException {
        statment.execute(sql); // Выборка таблицы
        data = statment.getResultSet(); // Получение набора данных
    }

    /**
     * Добавление Lookup-поля в таблицу БД
     *
     * @param field_name имя Lookup-поля (String)
     * @param value значение Lookup-поля (набор строк со столбцами
     * "КОД-НАЗВАНИЕ" при обновлении таблицы или текстовое значение при
     * добавлении новой записи)
     */
    public final void addLookupField(String field_name, Object value) {
        lookupFields.put(field_name, value);
    }

    /**
     * Очистка Lookup-полей таблицы БД
     */
    public final void clearLookupField() {
        lookupFields.clear();
    }

    /**
     * Выборка из таблицы БД парного списка КОД-НАЗВАНИЕ
     *
     * @param id_field_name имя поля с ID-кодами
     * @param field_name текстовое имя поля с расшифровками ID
     * @return парный список КОД-НАЗВАНИЕ (HashMap: Integer, String)
     *
     * @throws SQLException
     */
    public HashMap<Integer, String> getLookupList(String id_field_name, String field_name) throws SQLException {
        HashMap<Integer, String> list = new LinkedHashMap();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet;
        statement.execute("SELECT " + id_field_name + ", " + field_name + " FROM " + table_name+
                " ORDER BY "+field_name);
        resultSet = statement.getResultSet();
        while (resultSet.next()) {
            list.put(resultSet.getInt(1), resultSet.getString(2));
        }
        return list;
    }

    /**
     * Закрытие таблицы данных БД
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        if (data != null) {
            data.close();
        } // Закрытие набора данных
        if (statment != null) {
            statment.close();
        } // Закрытие выборки данных
    }

    /**
     * Загрузка Lookup-полей из связанных таблиц БД (перегружаемый метод)
     *
     */
    public void afterUpdateFromDB() {
//        try { // Пример перегруженного метода
//            clearLookupField();
//            addLookupField("ID_FIRM", dbTable_FIRM_2.getLookupList("ID", "NAME_FIRM"));
//            addLookupField("ID_TYPE_DISK", dbTable_TDISK_4.getLookupList("ID", "NAME_TYPE_DISK"));
//        } catch (Exception ex) {
//        }
    }

    /**
     * Установка Lookup-полей для добавления новой записи в таблицу БД
     * (перегружаемый метод)
     */
    public void beforeAppendNewRecord() {
//        try { // Пример перегруженного метода
//        clearLookupField();
//        addLookupField("ID_FIRM", new DbComboBox(dbTable_FIRM_2, "ID", "NAME_FIRM").getIdForSelectedRow());
//        addLookupField("ID_TYPE_DISK", new DbComboBox(dbTable_TDISK_4, "ID", "NAME_TYPE_DISK").getIdForSelectedRow());
//        data.updateString("NAME_DISK", jTextField1.getText().trim());
//        } catch (Exception ex) {
//        }
    }

    /**
     * Установка фильтра для таблицы БД (перегружаемый метод)
     *
     * @return значение фильтра для SQL-запроса
     */
    public String getFilter() {
        // Пример перегруженного метода
//        String s = jTextField1.getText().trim().toUpperCase();
//        if (s.equals("")) {
//            return "";
//        } else {
//            return "UPPER(NAME_DISK) LIKE '" + s + "%'";
//        }        
        return "";
    }
}
