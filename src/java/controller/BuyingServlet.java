/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartDAO;
import model.DAO.CartProductDAO;
import model.DAO.OrderDao;
import model.beans.Order;
import model.beans.User;
import model.beans.UserProduct;

/**
 *
 * @author Sara Selim
 */
@WebServlet(name = "BuyingServlet", urlPatterns = {"/BuyingServlet"})
public class BuyingServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        int moneyInCart = user.getCart().getAmountOfMoney();
        int totalPrice = 0;
        for (UserProduct up : user.getCart().getProduct()) {
            totalPrice = totalPrice + (up.getPrice() * up.getQuantity());
        }
        if (moneyInCart >= totalPrice) {
            Order order = new Order();
            order.setUserId(user.getId());
            order.setDate(new Timestamp(System.currentTimeMillis()));
            order.setTotalPrice(totalPrice);
            CartProductDAO cpDao = new CartProductDAO();
            List<UserProduct> up = cpDao.getAllProductInCart(user.getCart().getId());
            order.setProduct(up);
            OrderDao dbConn = new OrderDao();
            if (dbConn.connect()) {
                dbConn.addOrder(order);
                dbConn.disconnect();
            }
            CartDAO cartDAO = new CartDAO();
            cartDAO.updateCartMoney(user.getId(), (moneyInCart - totalPrice));
            CartProductDAO cartProductDAO = new CartProductDAO();
            user.getCart().getProduct().forEach((_item) -> {
                cartProductDAO.deleteProductFromCart(user.getCart().getId(), _item.getProductId());
            });
        } else {
            PrintWriter out = response.getWriter();
            out.write("You don't hane enough money");
        }

    }
}
