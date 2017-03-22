/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.category;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoryDAO;
import model.DAO.ProductDAO;
import model.beans.Category;
import model.beans.Product;

/**
 *
 * @author Pc
 */
@WebServlet(name = "renderUpdateCategoryServlet", urlPatterns = {"/renderUpdateCategoryServlet"})
public class renderUpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Category category =new Category();
        CategoryDAO categoryDAO =new CategoryDAO();
        String name = request.getParameter("name");
        if(categoryDAO.connect()){
            category = categoryDAO.getCategoryByName(name);
            request.setAttribute("category", category);
        }
       
        categoryDAO.disconnect();
        RequestDispatcher rd = request.getRequestDispatcher("adminpages/updateCategory.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Category category =new Category();
        CategoryDAO categoryDAO =new CategoryDAO();
        String name = request.getParameter("name");
        if(categoryDAO.connect()){
            category = categoryDAO.getCategoryByName(name);
            request.setAttribute("category", category);
        }
       
        categoryDAO.disconnect();
        RequestDispatcher rd = request.getRequestDispatcher("adminpages/updateCategory.jsp");
        rd.forward(request, response);
    }

}
