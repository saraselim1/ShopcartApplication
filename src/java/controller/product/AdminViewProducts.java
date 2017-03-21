/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.ProductDAO;
import model.beans.Product;

/**
 *
 * @author Pc
 */
@WebServlet(name = "AdminViewProducts", urlPatterns = {"/AdminViewProducts"})
public class AdminViewProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Vector<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        if(productDAO.connect()){
            products = productDAO.getAllProducts();
            productDAO.disconnect();
        
        HttpSession session = request.getSession();
        session.setAttribute("productList", products);
        }
        response.sendRedirect("adminpages/viewProduct.jsp");
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Vector<Product> products = null;
        ProductDAO productDAO =new ProductDAO();
        if(productDAO.connect()){
            products = productDAO.getAllProducts();
            productDAO.disconnect();
        
        HttpSession session = request.getSession();
        session.setAttribute("productList", products);
        }
        response.sendRedirect("adminpages/viewProduct.jsp");
        
    }

   
}
