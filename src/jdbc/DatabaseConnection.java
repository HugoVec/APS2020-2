package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static final String JDBCURL = "jdbc:postgresql://localhost/APS";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "123";
    

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);  
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        DatabaseConnection sqlConnect = new DatabaseConnection();
        sqlConnect.connect();
    }
    
    

}
