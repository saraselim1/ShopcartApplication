/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "renderUpdateProductServlet", urlPatterns = {"/renderUpdateProductServlet"})
public class renderUpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        String name = request.getParameter("name");
        if(productDAO.connect()){
            product = productDAO.getProductByName(name);
            request.setAttribute("product", product);
        }
       
        productDAO.disconnect();
        RequestDispatcher rd = request.getRequestDispatcher("adminpages/updateProduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        String name = request.getParameter("name");
        if(productDAO.connect()){
            product = productDAO.getProductByName(name);
            request.setAttribute("product", product);
        }
       
        productDAO.disconnect();
        RequestDispatcher rd = request.getRequestDispatcher("adminpages/updateProduct.jsp");
        rd.forward(request, response);
  
    }

}
