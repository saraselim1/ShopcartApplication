/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartDAO;
import model.DAO.CartProductDAO;
import model.DAO.UserDao;
import model.beans.User;

/**
 *
 * @author Masoud
 */
public class GettingOneUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao dbConn = new UserDao();
        if (dbConn.connect()) {
            User user = dbConn.getUser(userName, password);
            if (user != null) {
                CartDAO cartDao = new CartDAO();
                CartProductDAO cartProductDAO = new CartProductDAO();
                user.setCart(cartDao.getCartByUserId(user.getId()));
                user.getCart().setProduct(cartProductDAO.getAllProductInCart(user.getCart().getId()));
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("pages/home.jsp");
            } else {
                PrintWriter out = response.getWriter();
                out.println("not valiad");
            }
            dbConn.disconnect();
        }
    }

}
