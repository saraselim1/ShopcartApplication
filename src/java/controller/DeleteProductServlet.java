/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;

/**
 *
 * @author Pc
 */
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
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    
    }
    
    
}
