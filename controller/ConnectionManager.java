package guardmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost/brac"+"?useUnicode=true&characterEncoding=UTF-8";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println(ex);
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
        
    }
    public static void closeconnection()
    {
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
