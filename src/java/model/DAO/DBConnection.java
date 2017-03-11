
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    public Connection getConnection(){
        
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mmustafa", "2194");
            System.out.println("SUCESSS");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return con;
    }
    
    public static void main(String[] args) {
       new DBConnection().getConnection();
    }
    
    
}
