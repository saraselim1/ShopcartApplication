/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.AdminDAO;
import model.beans.Admin;

/**
 *
 * @author Masoud
 */
public class AdminViewServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDAO dbConn = new AdminDAO();
        List<Admin> admins;
        admins = dbConn.getAdmins();
            
        HttpSession session = request.getSession();
        session.setAttribute("admins", admins);

            response.sendRedirect("adminpages/AdminsView.jsp");
            

        
    }

    

}
