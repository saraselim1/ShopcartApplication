package controller.cart;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CartProductDAO;
import model.DAO.ProductDAO;
import model.beans.Product;
import model.beans.User;

@WebServlet(name = "DeleteProductFromCartServlet", urlPatterns = {"/DeleteProductFromCartServlet"})
public class DeleteProductFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        int productId = Integer.parseInt(request.getParameter("productId"));
        CartProductDAO cartProductDAO = new CartProductDAO();
        boolean result = cartProductDAO.deleteProductFromCart(user.getCart().getId(), productId);
        int oldQuantity = user.getCart().getProduct().stream().filter(old -> old.getProductId() == productId).collect(Collectors.toList()).get(0).getQuantity();
        List<Product> products = (List<Product>) getServletContext().getAttribute("productList");
        Product pro = products.stream().filter(ppp -> ppp.getId() == productId).collect(Collectors.toList()).get(0);
        pro.setQuantity(pro.getQuantity() + oldQuantity);
        ProductDAO productDAO = new ProductDAO();
        if (productDAO.connect()) {
            productDAO.updateProduct(pro);
        }

    }
}
