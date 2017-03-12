/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CartProductDAO {

    public boolean addProdcutToCart(int quantitiy, int price, int cartid, int productid) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("insert into cart_product values(? , ?, ?, ?)");
            ps.setInt(1, quantitiy);
            ps.setInt(2, price);
            ps.setInt(3, cartid);
            ps.setInt(4, productid);

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

    public boolean updateProductart(int cartID, int prodctid, int quantity, int price) {

        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        int rowsUpd = 0;

        try {

            PreparedStatement ps = con.prepareStatement("update cart_product"
                    + " set QUANTITY = ? , PRICE = ? "
                    + " where CART_ID = ? and PRODUCT_ID = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, price);
            ps.setInt(3, cartID);
            ps.setInt(4, prodctid);

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

    public boolean deleteProductFromCart(int cartid, int productid) {
        boolean result = false;

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("delete from cart_product where CART_ID = ? and PRODUCT_ID = ? ");
            ps.setInt(1, cartid);
            ps.setInt(2, productid);

            int rowsUpd = ps.executeUpdate();

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
    
    
//    public List getProductFromCart(){
//        
//        
//    }

    public static void main(String[] args) {

        CartProductDAO c = new CartProductDAO();
        c.deleteProductFromCart(4, 1);

    }

}
