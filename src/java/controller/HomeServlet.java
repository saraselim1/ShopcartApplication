/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
 * @author Sara Selim
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/Home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String userName = null;
            String password = null ;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("name")) {
                    userName = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
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
                    }
                }
            }
            RequestDispatcher rdHeader = getServletContext().getRequestDispatcher("/pages/home.jsp");
            rdHeader.include(request, response);
        }
    }
}
