package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.User;

public class GetUsersAll {
    
    
    
    public ArrayList getAllUsers(){
        
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        ArrayList<User> users = new ArrayList<>();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("USER_NAME");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String address = rs.getString("ADDRESS");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                
                
                User user = new User(id , username, fname, lname, email,gender, password, address);
                users.add(user);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
    
    
}
