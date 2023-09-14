package raysproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnDb {
    public static Connection conLink() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rays","soft");
        return con;
    }
}
