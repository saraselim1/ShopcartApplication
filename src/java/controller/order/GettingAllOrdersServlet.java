/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.OrderDao;

/**
 *
 * @author Masoud
 */
public class GettingAllOrdersServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        OrderDao dbConn = new OrderDao();
        if(dbConn.connect()){
            request.setAttribute("allOrders", dbConn.getAllOrders());
            dbConn.disconnect();
        }
    }
    
}
