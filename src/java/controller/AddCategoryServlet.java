/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoryDAO;
import model.beans.Category;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Pc
 */
public class AddCategoryServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category =new Category();
        CategoryDAO categoryDAO =new CategoryDAO();
        try{
            BeanUtils.populate(category,request.getParameterMap());
            if(categoryDAO.connect()){
                categoryDAO.addCategory(category);
            }
                  
       } catch (IllegalAccessException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category =new Category();
        CategoryDAO categoryDAO =new CategoryDAO();
        try{
            BeanUtils.populate(category,request.getParameterMap());
            if(categoryDAO.connect()){
                categoryDAO.addCategory(category);
            }
                  
       } catch (IllegalAccessException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
        }
    
    }
    
    
}
