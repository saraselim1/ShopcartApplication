package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.beans.Admin;

public class AdminDAO {

    public boolean addAdmin(Admin admin) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("insert  into admin(name, email) values (? , ?)");
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());

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

    public boolean deleteAdmin(String adminName) {
        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            Statement stmt = con.createStatement();
            int rowsUpd = stmt.executeUpdate("delete from admin where name = '" + adminName+"'");

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

    public ArrayList getAdmins() {

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        ArrayList<Admin> admins = new ArrayList<>();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin");

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);

                Admin admin = new Admin(id, name, email);
                admins.add(admin);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.stopConnection();
        }

        return admins;
    }

    public Admin getAdmin(String adminName) {

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        Statement stmt;
        Admin admin = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin where name=" + adminName);

            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);

                admin = new Admin(id, name, email);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.stopConnection();
        }

        return admin;
    }

}
