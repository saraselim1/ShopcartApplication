/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import controller.product.AddProductSevlet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;

/**
 *
 * @author Pc
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/DeleteProductServlet"})
public class DeleteProductServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO =new ProductDAO();
        String name;
        try{
            if(productDAO.connect()){
                name=(String) request.getAttribute("productName");
                productDAO.deleteProduct(name);
            }
                  
        }catch (Exception ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            productDAO.disconnect();
        }
        response.sendRedirect("adminpages/viewProduct.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO =new ProductDAO();
        String name;
        try{
            if(productDAO.connect()){
                name=(String) request.getParameter("productName");
                productDAO.deleteProduct(name);
                System.out.println("hiiiiiiiiiiiiii"+name);
            }
                  
        }catch (Exception ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            productDAO.disconnect();
        }
        response.sendRedirect("AdminViewProducts");
    }
    
    
}
