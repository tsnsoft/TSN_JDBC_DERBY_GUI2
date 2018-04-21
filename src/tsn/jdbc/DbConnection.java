package tsn.jdbc;

import java.io.File;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.derby.drda.NetworkServerControl;

public class DbConnection {

    private final String db_name = ""; // Имя файла базы данных (без расширения)
    private final String user = ""; // Имя пользователя БД
    private final String password = ""; // Пароль доступа в БД
    private final Properties authorization = new Properties(); // Свойства авторизации доступа к БД
    NetworkServerControl server; // Сервер БД
    /**
     * Доступ к соединению с базой данных
     */
    public Connection connection;

    /**
     * ДОСТУП К БАЗЕ ДАННЫХ DERBY (JAVA DB)
     *
     * @param name_db_dir имя каталога БД (например: "MyBase2"). Данный каталог
     * должен быть подкаталогом папки программы
     * @param db_name имя базы данных (например: "disks")
     * @param user имя пользователя БД
     * @param password пароль пользователя БД
     * @param port порт сервера (по-умолчанию 1527)
     *
     * @throws java.lang.Exception
     */
    public DbConnection(String name_db_dir, String db_name, String user, String password, int port) throws Exception {
        // Определение каталога запуска программы (текущего каталога)
        String prog_dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                + System.getProperty("file.separator");

        // Установка каталога БД
        System.setProperty("derby.system.home", prog_dir + name_db_dir);

        // Запуск сервера
        server = new NetworkServerControl(InetAddress.getByName("localhost"), port);
        server.start(null);

        // Загрузка драйвера JavaDB
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

        // Создание свойств соединения с базой данных
        authorization.setProperty("user", user); // Зададим имя пользователя БД
        authorization.setProperty("password", password); // Зададим пароль доступа в БД

        // Создание соединения с базой данных
        connection = DriverManager.getConnection("jdbc:derby://localhost:"+port+"/" + db_name, authorization);
    }

    /**
     * Отключение от базы данных
     */
    public void close() {
        try {
            if (connection != null) {
                connection.close(); // Закрытие соединения
            }
            server.shutdown(); // Выключение сервера
        } catch (Exception e) {
        }
    }
}
