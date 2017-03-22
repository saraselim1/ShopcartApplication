/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.category;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "UpdateCategoryServlet", urlPatterns = {"/UpdateCategoryServlet"})
public class UpdateCategoryServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category =new Category();
        category.setName(request.getParameter("name").trim());
        category.setId(Integer.parseInt(request.getParameter("id").trim()));
        category.setDescription(request.getParameter("description").trim());
        category.setProductNum(Integer.parseInt(request.getParameter("productNum").trim()));
        CategoryDAO categoryDAO =new CategoryDAO();
        try{
            BeanUtils.populate(category,request.getParameterMap());
            if(categoryDAO.connect()){
                categoryDAO.updateCategory(category);
            }
                  
        }   catch (IllegalAccessException ex) {
            Logger.getLogger(UpdateCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UpdateCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
            response.sendRedirect("adminpages/updateCategory.jsp");
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category =new Category();
        int proNum = Integer.parseInt(request.getParameter("productNum").trim());
        category.setName(request.getParameter("name").trim());
        category.setId(Integer.parseInt(request.getParameter("id").trim()));
        if(request.getParameter("description")!= null)
            category.setDescription(request.getParameter("description").trim());
        category.setProductNum(proNum);
        CategoryDAO categoryDAO =new CategoryDAO();
        try{
            BeanUtils.populate(category,request.getParameterMap());
            if(categoryDAO.connect()){
                categoryDAO.updateCategory(category);
            }
                  
        }   catch (IllegalAccessException ex) {
            Logger.getLogger(UpdateCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UpdateCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            categoryDAO.disconnect();
            response.sendRedirect("adminpages/updateCategory.jsp");

        }
    }
    
}
