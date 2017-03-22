package controller.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.GetUsersAll;
import model.DAO.OrderDao;
import model.beans.Order;
import model.beans.User;

/**
 *
 * @author M_Mustafa
 */
@WebServlet(name = "AdminGetOrders", urlPatterns = {"/AdminGetOrders"})
public class AdminGetOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDao dbConn = new OrderDao();
        List<Order> orderList = new ArrayList<>();

        if (dbConn.connect()) {
            orderList = dbConn.getAllOrders();
            request.setAttribute("ordersAll", orderList);
            RequestDispatcher rdView = getServletContext().getRequestDispatcher("/adminpages/OrdersView.jsp");
            rdView.forward(request, response);
        }
        
        for(Order order : orderList){
            System.out.println("----------------" + order.getTotalPrice());
        }

    }

}
