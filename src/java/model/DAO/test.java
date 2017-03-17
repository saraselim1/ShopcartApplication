/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.beans.Order;
import model.beans.UserProduct;

/**
 *
 * @author Masoud
 */
public class test {
    public static void main(String[] args) {
        List<UserProduct> products = new ArrayList<>();
        UserProduct pro = new UserProduct(2, 20, 1);
        products.add(pro);
        pro = new UserProduct(3, 30, 2);
        products.add(pro);
        pro = new UserProduct(1, 10, 3);
        Order order = new Order();
        order.setProduct(products);
        order.setTotalPrice(140);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setDate(timestamp);
        order.setUserId(2);
        OrderDao orderDao = new OrderDao();
        if(orderDao.connect()){
            orderDao.addOrder(order);
        }
    }
}
