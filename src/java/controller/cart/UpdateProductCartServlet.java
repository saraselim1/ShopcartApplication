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

@WebServlet(name = "UpdateProductCartServlet", urlPatterns = {"/UpdateProductCartServlet"})
public class UpdateProductCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int price = Integer.parseInt(request.getParameter("price"));

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        List<Product> products = (List<Product>) getServletContext().getAttribute("productList");
        Product pro = products.stream().filter(ppp -> ppp.getId() == productId).collect(Collectors.toList()).get(0);
        int quatityInStock = pro.getQuantity();
        if (user != null) {
            CartProductDAO cartProductDAO = new CartProductDAO();
            if (quantity <= quatityInStock) {
                boolean result = cartProductDAO.updateProductart(user.getCart().getId(), productId, quantity, price);
                ProductDAO productDAO = new ProductDAO();
                pro.setQuantity(quatityInStock - quantity);
                if (productDAO.connect()) {
                    productDAO.updateProduct(pro);
                }
                productDAO.disconnect();
            } else {
                request.setAttribute("msg", "Sorry Quanity is not valiad");
            }
        }
    }
}
