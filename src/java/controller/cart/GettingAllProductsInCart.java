/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartDAO;
import model.DAO.CartProductDAO;
import model.beans.User;

/**
 *
 * @author Sara Selim
 */
@WebServlet(name = "GettingAllProductsInCart", urlPatterns = {"/GettingAllProductsInCart"})
public class GettingAllProductsInCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDAO cartDao = new CartDAO();
        CartProductDAO cartProductDAO = new CartProductDAO();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        user.setCart(cartDao.getCartByUserId(user.getId()));
        user.getCart().setProduct(cartProductDAO.getAllProductInCart(user.getCart().getId()));
        RequestDispatcher rdView = getServletContext().getRequestDispatcher("/pages/viewCart.jsp");
        rdView.include(request, response);
    }

}
