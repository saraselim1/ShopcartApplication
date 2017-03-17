package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CartProductDAO;

@WebServlet(name = "UpdateProductCartServlet", urlPatterns = {"/UpdateProductCartServlet"})
public class UpdateProductCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        CartProductDAO cartProductDAO = new CartProductDAO();
        boolean result = cartProductDAO.updateProductart(cartId, productId, quantity, price);
    }
}
