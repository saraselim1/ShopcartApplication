package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.AdminDAO;
import model.DAO.DBConnection;
import model.beans.Admin;

@WebServlet(name = "AddAdminServlet", urlPatterns = {"/AddAdminServlet"})
public class AddAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Admin admin = new Admin();
        String name = request.getParameter("aname");
        String email = request.getParameter("aemail");
        admin.setName(name);
        admin.setEmail(email);
        AdminDAO adminDAO = new AdminDAO();

        boolean result = adminDAO.addAdmin(admin);
        
       // request.setAttribute("admin",admin);
            
            response.sendRedirect("AdminViewServlet");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
