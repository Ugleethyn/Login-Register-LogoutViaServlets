package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Ugleethyn
 */
public class DBUtils {

    private static final String MYSQLURL = "jdbc:mysql://127.0.0.1/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//private static final String DSN = "DRIVER={MySQL ODBC 8.0 Driver};SERVER=localhost;DATABASE=test;USER=venu;PASSWORD=venu;OPTION=3;";
    private static String username = "mysqluser";
    private static String password = "mysqluser";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(MYSQLURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
