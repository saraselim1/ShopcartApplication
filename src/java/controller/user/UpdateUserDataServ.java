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
import javax.servlet.http.HttpSession;
import model.DAO.UserDao;
import model.beans.User;

/**
 *
 * @author M_Mustafa
 */
@WebServlet(name = "UpdateUserDataServ", urlPatterns = {"/UpdateUserDataServ"})
public class UpdateUserDataServ extends HttpServlet {


        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
         
        user.setEmail(request.getParameter("email"));
        user.setFname(request.getParameter("fname"));
        user.setLname(request.getParameter("lname"));
        user.setGender(request.getParameter("gender"));
        user.setAddress(request.getParameter("address"));
        user.setPassword(request.getParameter("password"));
        
        UserDao dbConn = new UserDao();
        
        if(dbConn.connect()){
            dbConn.updateUser(user.getUserName(), user);   /// get username from session   ....
            dbConn.disconnect();
            UserDao dbConnu = new UserDao();
            dbConnu.connect();
            dbConnu.disconnect();
            RequestDispatcher rd = request.getRequestDispatcher("pages/profile.jsp");
            rd.forward(request, response);
        }
    }
    
    
}
