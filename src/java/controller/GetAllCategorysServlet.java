/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoryDAO;
import model.beans.Category;

/**
 *
 * @author Pc
 */
@WebServlet(name = "GetAllCategorysServlet", urlPatterns = {"/GetAllCategorysServlet"})
public class GetAllCategorysServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categorys = null;
        CategoryDAO categoryDAO =new CategoryDAO();
        if(categoryDAO.connect()){
            categorys = categoryDAO.getAllCategorys();
            request.setAttribute("categoryList", categorys);
            categoryDAO.disconnect();
            //dispatcher
        }
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        ArrayList<Category> categorys = null;
        CategoryDAO categoryDAO =new CategoryDAO();
        if(categoryDAO.connect()){
            categorys = categoryDAO.getAllCategorys();
            request.setAttribute("categoryList", categorys);
            categoryDAO.disconnect();
            //dispatcher
        }
        
    
    }
    
}
