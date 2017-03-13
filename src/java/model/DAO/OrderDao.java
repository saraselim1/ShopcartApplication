/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Order;
import model.beans.UserProduct;

/**
 *
 * @author Masoud
 */
public class OrderDao extends DBConnector {

    private final String selectAll;
    private final String insertEx;
    private final String deleteEx;

    UserProduct product;
    List<UserProduct> products;
    Order order;
    List<Order> orders;

    public OrderDao() {
        selectAll = "SELECT o.id, o.total_price, o.data, o.users_id, op.quantity, op.price, op.product_id FROM orders o INNER JOIN  order_product op ON o.id = op.order_id";
        select = "SELECT o.id, o.total_price, o.data, o.users_id, op.quantity, op.price, op.product_id FROM orders o INNER JOIN  order_product op ON o.id = op.order_id where o.users_id = ?";
        insert = "insert into orders (total_price, data, users_id) values (?, ?, ?)";
        insertEx = "insert into order_product values (?, ?, ?, ?)";
        delete = "delete from order_product where order_id = ?";
        deleteEx = "delete from orders where id = ?";
    }

    public List<Order> getAllOrders() {
        runQuery(selectAll);
        try {
            resultSet = pStatement.executeQuery();
            int id = 0;
            orders = new ArrayList<>();
            while (resultSet.next()) {
                while (resultSet.getInt(1) != id) {
                    if (id != 0) {
                        order.setProduct(products);
                        orders.add(order);
                    }
                    products = new ArrayList<>();
                    order = new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getTimestamp(3), resultSet.getInt(4));
                    id = resultSet.getInt(1);
                }
                product = new UserProduct(resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7));
                products.add(product);
            }
            if (id != 0) {
                order.setProduct(products);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    public List<Order> getUserOrders(int userID) {
        runQuery(select);
        try {
            pStatement.setInt(1, userID);
            resultSet = pStatement.executeQuery();
            int id = 0;
            orders = new ArrayList<>();
            while (resultSet.next()) {
                while (resultSet.getInt(1) != id) {
                    if (id != 0) {
                        order.setProduct(products);
                        orders.add(order);
                    }
                    products = new ArrayList<>();
                    order = new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getTimestamp(3), resultSet.getInt(4));
                    id = resultSet.getInt(1);
                }
                product = new UserProduct(resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7));
                products.add(product);
            }
            if (id != 0) {
                order.setProduct(products);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    public void addOrder(Order order) {
        try {
            runQuery(insert);
            pStatement.setInt(1, order.getTotalPrice());
            pStatement.setTimestamp(2, order.getDate());
            pStatement.setInt(3, order.getUserId());
            pStatement.executeUpdate();
            products = order.getProduct();
            for (Iterator<UserProduct> it = products.iterator(); it.hasNext();) {
                UserProduct pro = it.next();
                runQuery(insertEx);
                pStatement.setInt(1, pro.getQuantity());
                pStatement.setInt(2, pro.getPrice());
                pStatement.setInt(3, order.getId());
                pStatement.setInt(4, pro.getProductId());
                pStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void deleteOrder(int id) {
        try {
            runQuery(delete);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
            runQuery(deleteEx);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
