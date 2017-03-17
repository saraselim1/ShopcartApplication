package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.beans.Cart;

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
    
    public Cart getCartByUserId(int userId){
        Cart cart = new Cart();
        boolean result = false;
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select *  from cart where users_id = ? ");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cart.setAmountOfMoney(rs.getInt("amount_of_money"));
                cart.setId(rs.getInt("id"));
                cart.setUserId(rs.getInt("users_id"));
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
        return cart;
    }
}
