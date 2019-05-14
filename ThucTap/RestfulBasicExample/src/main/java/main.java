import dbconnect.MysqlConnect;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        Connection connection = mysqlConnect.getConnection();
    }
}
