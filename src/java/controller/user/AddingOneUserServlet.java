/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartDAO;
import model.DAO.UserDao;
import model.beans.User;

/**
 *
 * @author Masoud
 */
public class AddingOneUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));
        user.setFname(request.getParameter("fName"));
        user.setLname(request.getParameter("lName"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        user.setAddress(request.getParameter("address"));

        UserDao dbConn = new UserDao();
        if (dbConn.connect()) {
            if (dbConn.addUser(user)) {
                User user2 = dbConn.getUser(request.getParameter("userName"), request.getParameter("password"));
                if (user2 != null) {
                    CartDAO cartDao = new CartDAO();
                    cartDao.addAcart(1000, user2.getId());
                    user2.setCart(cartDao.getCartByUserId(user.getId()));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user2);
                    response.sendRedirect("Home");
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("not valiad");
                }
            } else {
                PrintWriter out = response.getWriter();
                out.println("not valiad");
            }
            dbConn.disconnect();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rdView = getServletContext().getRequestDispatcher("/pages/signUp.jsp");
        rdView.include(request, response);
    }

}
