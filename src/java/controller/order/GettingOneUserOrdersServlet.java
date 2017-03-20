/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.OrderDao;
import model.beans.Order;
import model.beans.User;

/**
 *
 * @author Masoud
 */
public class GettingOneUserOrdersServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        OrderDao dbConn = new OrderDao();
        if(dbConn.connect()){
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            List<Order> orders = dbConn.getUserOrders(user.getId());
            user.setOrders(orders);
            System.out.println("order size = "+orders.size());
            RequestDispatcher rdView = getServletContext().getRequestDispatcher("/pages/viewOrders.jsp");
            rdView.include(request, response);
        }
    }
    
}
