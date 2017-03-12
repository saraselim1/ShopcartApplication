/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;
import model.beans.Product;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Pc
 */
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
