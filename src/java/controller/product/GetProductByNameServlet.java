/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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
@WebServlet(name = "GetProductByNameServlet", urlPatterns = {"/SerchProductByNameServlet"})
public class GetProductByNameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = null;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            name=(String) request.getParameter("myProductName");
            System.out.println(name);
            System.out.println("hello");
            product = productDAO.getProductByName(name);
            request.setAttribute("productByName", product);
            productDAO.disconnect();
            //dispatcher
            response.setContentType("application/json");
            //System.out.println(products.size());
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(product));
            out.close();
        }
        
        
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = null;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            name=(String) request.getParameter("myProductName");
            System.out.println(name);
            System.out.println("hello");
            product = productDAO.getProductByName(name);
            request.setAttribute("productByName", product);
            productDAO.disconnect();
            //dispatcher
            response.setContentType("application/json");
            //System.out.println(products.size());
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(product));
            out.close();
        }
    }
    
}
