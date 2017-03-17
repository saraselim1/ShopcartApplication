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
            name=(String) request.getParameter("productName");
            product = productDAO.getProductByName(name);
            request.setAttribute("product", product);
            System.out.println(product.getName()+name+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            productDAO.disconnect();
            
            RequestDispatcher rd = request.getRequestDispatcher("${pageContext.request.contextPath}/pages/viewProduct.jsp");
            rd.forward(request, response);
            //dispatcher
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Product product=null;
        ProductDAO productDAO =new ProductDAO();
        String name;
        if(productDAO.connect()){
            if(productDAO.connect()){
                name=(String) request.getParameter("productName");
                product = productDAO.getProductByName(name);
                
                //request.setAttribute("name", product.getName());
                System.out.println(name+"post&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                productDAO.disconnect();
            }
            request.setAttribute("name",product.getName());
            request.setAttribute("price",product.getPrice());
            request.setAttribute("description",product.getDescription());
            request.setAttribute("categoryId",product.getCategoryId());
            request.setAttribute("id",product.getId());
            request.setAttribute("offer",product.getOffer());
            request.setAttribute("quantity",product.getQuantity());
            request.setAttribute("imgMaster",product.getImgMaster());
            request.setAttribute("img1",product.getImg1());
            request.setAttribute("img2",product.getImg2());
            request.setAttribute("img3",product.getImg3());
            RequestDispatcher rd = request.getRequestDispatcher("pages/viewProduct.jsp");
            rd.forward(request, response);
            //dispatcher
        }
    }
}
