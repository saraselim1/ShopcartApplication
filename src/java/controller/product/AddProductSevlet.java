/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "AddProductSevlet", urlPatterns = {"/AddProductSevlet"})
public class AddProductSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        try{
            BeanUtils.populate(product,request.getParameterMap());
            if(productDAO.connect()){
                System.out.println("connected");
                productDAO.addProduct(product);
            }
                  System.out.println("done");
        }   catch (IllegalAccessException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            productDAO.disconnect();
            System.out.println("disConnect");
            //request.getSession().getServletContext().getContextPath()+
//            RequestDispatcher rd = request.getRequestDispatcher("/adminpages/addProduct.jsp");
//            rd.forward(request, response);
            response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/adminpages/addProduct.jsp");
              
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        try{
            BeanUtils.populate(product,request.getParameterMap());
            System.out.println(product.getName());
            if(productDAO.connect()){
                                System.out.println("connected");

                productDAO.addProduct(product);
            }
                                    System.out.println("done");

        }   catch (IllegalAccessException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            productDAO.disconnect();
                        System.out.println("disConnect");

            RequestDispatcher rd = request.getRequestDispatcher("/adminpages/addProduct.jsp");
            rd.forward(request, response);
        }
    
    }
    
    
}
