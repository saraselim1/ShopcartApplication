/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "GetAllProductsServlet", urlPatterns = {"/GetAllProductsServlet"})
public class GetAllProductsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        if(productDAO.connect()){
            products = productDAO.getAllProducts();
            request.setAttribute("productList", products);
            productDAO.disconnect();
            //dispatcher
        }
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        ArrayList<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        if(productDAO.connect()){
            products = productDAO.getAllProducts();
            request.setAttribute("productList", products);
            productDAO.disconnect();
            //dispatcher
        }
        
    
    }
    
}
