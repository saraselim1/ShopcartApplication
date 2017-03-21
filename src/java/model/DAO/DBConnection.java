
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    Connection con = null;
    
    public Connection getConnection(){
        
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "dbuser", "dbuser");
            System.out.println("SUCESSS");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return con;
    }
    
    public void stopConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
