/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;
import model.beans.Product;

/**
 *
 * @author Pc
 */
@WebServlet(name = "SearchForProductByCategoryServlet", urlPatterns = {"/SearchForProductByCategoryServlet"})
@MultipartConfig
public class SearchForProductByCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            name=(String) request.getParameter("categoryName");
            System.out.println(name);
            System.out.println("hello");
            products = productDAO.getProductByCategory(name);
            request.setAttribute("productListByCategory", products);
            productDAO.disconnect();
            //dispatcher
            response.setContentType("application/json");
            //System.out.println(products.size());
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(products));
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            name=(String) request.getAttribute("categoryName");
            products = productDAO.getProductByCategory(name);
            request.setAttribute("productListByCategory", products);
            productDAO.disconnect();
            //dispatcher
            response.setContentType("application/json");
            //System.out.println(products.size());
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(products));
            out.close();
        }
    }
    
    
    
}
