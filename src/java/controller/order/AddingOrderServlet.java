/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.OrderDao;
import model.beans.Order;
import model.beans.UserProduct;

/**
 *
 * @author Masoud
 */
public class AddingOrderServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Order order = new Order();
        order.setUserId((int) request.getAttribute("userId"));
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setTotalPrice((int) request.getAttribute("totalPrice"));
        order.setProduct((List<UserProduct>) request.getAttribute("products"));
        
        OrderDao dbConn = new OrderDao();
        if(dbConn.connect()){
            dbConn.addOrder(order);
            dbConn.disconnect();
        }
    }
    
}
