package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnect implements DbConnect{

    String url;
    String driver;
    String dbName;
    String userName;
    String password;

    public MysqlConnect() {
        url = "jdbc:mysql://localhost:3306/";
        driver = "com.mysql.jdbc.Driver";
        dbName = "COMPANY";
        userName = "root";
        password = "damminhkhang";
        try {
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
