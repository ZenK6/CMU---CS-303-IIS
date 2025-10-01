package NguyenNKhoiNguyenCS301;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static final String SERVER_NAME = "LAPTOP-CGBAG70K\\SQLEXPRESS";
    private static final String DB_NAME = "PersonDB";

    private static final String DB_URL = "jdbc:sqlserver://" + SERVER_NAME
            + ";databaseName=" + DB_NAME
            + ";encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASS = "1102";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("SQL Server JDBC Driver not found.");
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
