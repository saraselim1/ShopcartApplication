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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoryDAO;

/**
 *
 * @author Pc
 */
@WebServlet(name = "DeleteCategoryServlet", urlPatterns = {"/DeleteProductServlet"})
public class DeleteCategoryServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO =new CategoryDAO();
        String name;
        try{
            if(categoryDAO.connect()){
                name=(String) request.getAttribute("categoryName");
                categoryDAO.deleteCategory(name);
            }
                  
        }catch (Exception ex) {
            Logger.getLogger(DeleteCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         CategoryDAO categoryDAO =new CategoryDAO();
        String name;
        try{
            if(categoryDAO.connect()){
                name=(String) request.getAttribute("categoryName");
                categoryDAO.deleteCategory(name);
            }
                  
        }catch (Exception ex) {
            Logger.getLogger(DeleteCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
        }
    
    }
    
}
