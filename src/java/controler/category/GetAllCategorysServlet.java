/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.category;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
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
        Vector<Category> categorys = null;
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
       
        Vector<Category> categorys = null;
        CategoryDAO categoryDAO =new CategoryDAO();
        if(categoryDAO.connect()){
            categorys = categoryDAO.getAllCategorys();
            request.setAttribute("categoryList", categorys);
            categoryDAO.disconnect();
        response.setContentType("application/json");
            System.out.println(categorys.size());
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(categorys));
        out.close();
        }
        
    
    }
    
}
