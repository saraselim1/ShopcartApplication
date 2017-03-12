package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CartDAO {

    public boolean addAcart(int money, int userid) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("insert  into cart(AMOUNT_OF_MONEY, USERS_ID) values (? , ?)");
            ps.setInt(1, money);
            ps.setInt(2, userid);

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

    public boolean updateCartMoney(int cartID, int money) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("update cart"
                    + " set AMOUNT_OF_MONEY = ? "
                    + " where id = ?");
            ps.setInt(1, money);
            ps.setInt(2, cartID);

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

    public boolean deleteCart(int id) {
        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            Statement stmt = con.createStatement();
            int rowsUpd = stmt.executeUpdate("delete from cart where id = " + id);

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

        CartDAO c = new CartDAO();
        c.deleteCart(3);

    }

}
