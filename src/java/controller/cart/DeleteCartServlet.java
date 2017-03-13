package controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.AdminDAO;
import model.DAO.CartDAO;
import model.DAO.DBConnection;

@WebServlet(name = "DeleteCartServlet", urlPatterns = {"/DeleteCartServlet"})
public class DeleteCartServlet extends HttpServlet {
    
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int userid =  Integer.parseInt(request.getParameter(""));
       
        CartDAO cartDAO = new CartDAO();
        
        boolean result = cartDAO.deleteCart(userid);
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
