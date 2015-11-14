import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Prilepishev Vadim on 11/10/2015.
 */
public class JDBCStandartFabricConnect {

    public static final String URL = "jdbc:mysql://localhost:3306/monacoevent";
    public static final String USERNAME = "root";
    public static final String PASS  = "12345";
    public static final String CONNECT_MESSAGE = "Соединение с БД установленно";
    public static final String CONNECT_CLOSE_MESSAGE = "Соединение с БД закрыто";
    public static final String CONNECT_ERROR_MESSAGE = "Соединение с БД не установленно";


    public static Connection connect;

    public static Connection getConnection() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connect = DriverManager.getConnection(URL, USERNAME, PASS);

        } catch (SQLException e) {
            System.err.println(CONNECT_ERROR_MESSAGE);
        }
        return connect;

    }

    public static String checkConnection(Connection conn) throws SQLException {
        String CONNECT_STATUS = null;

        try {
            if (!conn.isClosed()) {
                CONNECT_STATUS = CONNECT_MESSAGE;
            }
        } catch (SQLException e) {
            System.err.println(CONNECT_ERROR_MESSAGE);
        }

        if (conn.isClosed()) {
            CONNECT_STATUS = CONNECT_CLOSE_MESSAGE;
        }

        return CONNECT_STATUS;

    }


}
