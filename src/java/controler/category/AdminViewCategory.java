/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.CategoryDAO;
import model.DAO.ProductDAO;
import model.beans.Category;
import model.beans.Product;

/**
 *
 * @author Pc
 */
@WebServlet(name = "AdminViewCategory", urlPatterns = {"/AdminViewCategory"})
public class AdminViewCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Vector<Category> categorys = null;
        CategoryDAO categoryDAO =new CategoryDAO();
        if(categoryDAO.connect()){
            categorys = categoryDAO.getAllCategorys();
            request.setAttribute("categoryList", categorys);
            categoryDAO.disconnect();
        
        HttpSession session = request.getSession();
        session.setAttribute("categoryList", categorys);
        }
        response.sendRedirect("adminpages/categoriesView.jsp");
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Vector<Category> categorys = null;
        CategoryDAO categoryDAO =new CategoryDAO();
        if(categoryDAO.connect()){
            categorys = categoryDAO.getAllCategorys();
            request.setAttribute("categoryList", categorys);
            categoryDAO.disconnect();
        
        HttpSession session = request.getSession();
        session.setAttribute("categoryList", categorys);
        }
        response.sendRedirect("adminpages/categoriesView.jsp");
        
    }

   
}
