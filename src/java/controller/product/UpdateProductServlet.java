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
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        System.out.println(request.getParameter("name"));
        product.setName(request.getParameter("name").trim());
        product.setId(Integer.parseInt(request.getParameter("id").trim()));
        product.setCategoryId(Integer.parseInt(request.getParameter("categoryId").trim()));
        product.setDescription(request.getParameter("description").trim());
        product.setOffer(Integer.parseInt(request.getParameter("offer").trim()));
        product.setPrice(Integer.parseInt(request.getParameter("price").trim()));
        product.setImgMaster(request.getParameter("imgMaster").trim());
        product.setQuantity(Integer.parseInt(request.getParameter("quantity").trim()));

        try{
            BeanUtils.populate(product,request.getParameterMap());
            if(productDAO.connect()){
                productDAO.updateProduct(product);
            }
                  
        }   catch (IllegalAccessException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            productDAO.disconnect();
            response.sendRedirect("AdminViewProducts");

        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product =new Product();
        ProductDAO productDAO =new ProductDAO();
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        int catId = Integer.parseInt(request.getParameter("categoryId"));
        int offer = Integer.parseInt(request.getParameter("offer"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        product.setName(request.getParameter("name"));
        product.setId(id);
        product.setCategoryId(catId);
        product.setDescription(request.getParameter("description"));
        product.setOffer(offer);
        product.setPrice(price);
        product.setImgMaster(request.getParameter("imgMaster"));
        product.setQuantity(quantity);

        try{
            BeanUtils.populate(product,request.getParameterMap());
            if(productDAO.connect()){
                productDAO.updateProduct(product);
            }
                  
        }   catch (IllegalAccessException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AddProductSevlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            productDAO.disconnect();
            response.sendRedirect("AdminViewProducts");
        }
    }
}
