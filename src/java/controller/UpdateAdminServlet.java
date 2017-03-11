package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.AdminDAO;
import model.DAO.DBConnection;

@WebServlet(name = "UpdateAdminServlet", urlPatterns = {"/UpdateAdminServlet"})
public class UpdateAdminServlet extends HttpServlet {
    
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int id =Integer.parseInt(request.getParameter(""));
       String name =  request.getParameter("");
       String email =  request.getParameter("");
       
        AdminDAO adminDAO = new AdminDAO();
        
        boolean result = adminDAO.updateAdmin(id, name, email);
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
