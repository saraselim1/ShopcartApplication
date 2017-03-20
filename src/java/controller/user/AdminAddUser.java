/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UserDao;
import model.beans.User;

/**
 *
 * @author M_Mustafa
 */
@WebServlet(name = "AdminAddUser", urlPatterns = {"/AdminAddUser"})
public class AdminAddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));
        user.setFname(request.getParameter("fName"));
        user.setLname(request.getParameter("lName"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        user.setAddress(request.getParameter("address"));

        UserDao dbConn = new UserDao();
        if (dbConn.connect()) {
            dbConn.addUser(user);
           
            request.setAttribute("user",user);
            
            RequestDispatcher rd = request.getRequestDispatcher("adminpages/viewProfile.jsp");
            rd.forward(request, response);

           // response.sendRedirect("AddUser.jsp");
            dbConn.disconnect();
            
        }
    }

}
