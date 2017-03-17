package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CartProductDAO;


@WebServlet(name = "DeleteProductFromCartServlet", urlPatterns = {"/DeleteProductFromCartServlet"})
public class DeleteProductFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int productId = Integer.parseInt(request.getParameter("ProductId"));
        CartProductDAO cartProductDAO = new CartProductDAO();
        boolean result = cartProductDAO.deleteProductFromCart(cartId, productId);
    }
}
