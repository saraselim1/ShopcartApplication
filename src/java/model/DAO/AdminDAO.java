package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDAO {

    public boolean addAdmin(String name, String email) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("insert  into admin(name, email) values (? , ?)");
            ps.setString(1, name);
            ps.setString(2, email);

            rowsUpd = ps.executeUpdate();

            if (rowsUpd > 0) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public boolean updateAdmin(int id, String name, String email) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("update admin"
                    + " set name = ? , email = ? "
                    + " where id = ?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);

            rowsUpd = ps.executeUpdate();

            if (rowsUpd > 0) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public boolean deleteAdmin(int id) {
        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            Statement stmt = con.createStatement();
            int rowsUpd = stmt.executeUpdate("delete from admin where id = " + id);

            if (rowsUpd > 0) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        AdminDAO admin = new AdminDAO();

        boolean resu = admin.updateAdmin(4, "Belal", "belll@gmail.com");
        System.out.println(resu);

    }

}
