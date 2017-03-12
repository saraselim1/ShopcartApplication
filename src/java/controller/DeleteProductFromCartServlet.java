package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.AdminDAO;
import model.DAO.CartDAO;
import model.DAO.CartProductDAO;
import model.DAO.DBConnection;

@WebServlet(name = "DeleteProductFromCartServlet", urlPatterns = {"/DeleteProductFromCartServlet"})
public class DeleteProductFromCartServlet extends HttpServlet {
    
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int cartId =  Integer.parseInt(request.getParameter(""));        
       int productId =  Integer.parseInt(request.getParameter(""));  
       
       CartProductDAO cartProductDAO = new CartProductDAO();
       
       boolean result = cartProductDAO.deleteProductFromCart(cartId, productId);
        
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
