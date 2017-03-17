package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CartDAO;

@WebServlet(name = "UpdateCartMoney", urlPatterns = {"/UpdateCartMoney"})
public class UpdateCartMoney extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int money = Integer.parseInt(request.getParameter(""));
        int userid = Integer.parseInt(request.getParameter(""));
        CartDAO cartDAO = new CartDAO();
        boolean result = cartDAO.updateCartMoney(userid, money);
    }

}
