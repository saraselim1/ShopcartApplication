

package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.ProductDAO;
import model.beans.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet(name = "AddProductSevlet", urlPatterns = {"/AddProductSevlet"})
public class AddProductSevlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
            try {
                
            
            Product product = new Product();
            ProductDAO productDAO = new ProductDAO();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            String url="D:\\ITI\\JspProject\\ShopcartApplication\\web\\assets\\img\\";
            //String url=getServletContext().getRealPath("/Resources/images/products");
            //System.out.println("destination url="+url);
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField()) {
                    //item.write(new File(url+"/" + item.getName()));
                    item.write(new File(url + item.getName()));
                    product.setImgMaster(item.getName());
                } else {
                    switch (item.getFieldName()) {
                        case "name":
                            product.setName(item.getString());
                            break;
                        case "description":
                            product.setDescription(item.getString());
                            break;
                        case "price":
                            product.setPrice(Integer.parseInt(item.getString()));
                            break;
                        case "quantity":
                            product.setQuantity(Integer.parseInt(item.getString()));
                            break;
                        case "offer":
                            product.setOffer(Integer.parseInt(item.getString()));
                            break;
                        case "categoryId":
                            product.setCategoryId(Integer.parseInt(item.getString()));
                            break;
                            
                        default:
                            break;
                    }
                }
            }
            
            System.out.println(product.toString());
           if (productDAO.connect()) {
                productDAO.addProduct(product);
            productDAO.disconnect();
            response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/AdminViewProducts");
//            }se.sendRedirect("viewProducts");
        } 
            }catch (Exception ex) {
                ex.printStackTrace();
        }
        
        
        
        
        
        

//            String name = request.getParameter("name");
//            String description = request.getParameter("description");
//            int offer = Integer.parseInt(request.getParameter("offer"));
//            int price = Integer.parseInt(request.getParameter("price"));
//            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
//            int quantity = Integer.parseInt(request.getParameter("quantity"));
//            String imgMaster = request.getParameter("imgMaster");
//        
//        try {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> items = upload.parseRequest(request);
//            Iterator<FileItem> iter = items.iterator();
//            String url = "D:\\jspproject\\ShopcartApplication\\web\\assets\\img\\";
//
//            while (iter.hasNext()) {
//                FileItem pitem = iter.next();
//                if (pitem.isFormField()) {
//                    //String itemName = pitem.getFieldName();
//                    //String value = pitem.getString();
//                    ///PrintWriter out = response.getWriter();
//                    //out.print("Thanks : " + value + itemName);
//                } else {
//                    if (!pitem.isFormField()) {
//                        pitem.write(new File(url + pitem.getName()));
//                    }
//                }
//            }
//
//            Product product = new Product(name, description, price, offer, quantity, categoryId, imgMaster);
//            ProductDAO productDAO = new ProductDAO();
//
//            if (productDAO.connect()) {
//                productDAO.addProduct(product);
//                response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/adminpages/addProduct.jsp");
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }

}
