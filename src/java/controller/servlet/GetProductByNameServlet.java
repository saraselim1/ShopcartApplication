/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;
import model.beans.Product;

/**
 *
 * @author Pc
 */
public class GetProductByNameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product;
        ProductDAO productDAO = new ProductDAO();
        String name;
        if (productDAO.connect()) {
            name = (String) request.getAttribute("productName");
            product = productDAO.getProductByName(name);
            request.setAttribute("productByName", product);
            productDAO.disconnect();
            //dispatcher
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product;
        ProductDAO productDAO = new ProductDAO();
        String name;
        if (productDAO.connect()) {
            name = (String) request.getAttribute("productName");
            product = productDAO.getProductByName(name);
            request.setAttribute("productByName", product);
            productDAO.disconnect();
            //dispatcher
        }
    }

}
