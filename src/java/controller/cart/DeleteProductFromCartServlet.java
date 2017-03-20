package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartProductDAO;
import model.beans.User;

@WebServlet(name = "DeleteProductFromCartServlet", urlPatterns = {"/DeleteProductFromCartServlet"})
public class DeleteProductFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println(productId);
        CartProductDAO cartProductDAO = new CartProductDAO();
        boolean result = cartProductDAO.deleteProductFromCart(user.getCart().getId(), productId);
    }
}
