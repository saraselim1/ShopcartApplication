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

@WebServlet(name = "UpdateProductCartServlet", urlPatterns = {"/UpdateProductCartServlet"})
public class UpdateProductCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int price = Integer.parseInt(request.getParameter("price"));
        
        CartProductDAO cartProductDAO = new CartProductDAO();
        boolean result = cartProductDAO.updateProductart(user.getCart().getId(), productId, quantity,price);
    }
}
