/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;
import model.beans.Product;

/**
 *
 * @author M_Mustafa
 */
@WebServlet(name = "GetProductDetailsServ", urlPatterns = {"/GetProductDetailsServ"})
public class GetProductDetailsServ extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Product product;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            //name=(String) request.getAttribute("productName");
            product = productDAO.getProductByName("Zamalek_T-shirt");
            request.setAttribute("product", product);
            System.out.println(product.getName()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            productDAO.disconnect();
            
            RequestDispatcher rd = request.getRequestDispatcher("pages/viewProduct.jsp");
            rd.forward(request, response);
            //dispatcher
        }
    }


}
