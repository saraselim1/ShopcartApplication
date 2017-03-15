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

/**
 *
 * @author M_Mustafa
 */
@WebServlet(name = "ViewProfileServlet", urlPatterns = {"/ViewProfileServlet"})
public class ViewProfileServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       UserDao dbConn = new UserDao();
        if(dbConn.connect()){
            // request.getParameter("userName")
            request.setAttribute("user", dbConn.getUser("mmustafa"));
            dbConn.disconnect();
            
            RequestDispatcher rd = request.getRequestDispatcher("pages/profile.jsp");
            rd.forward(request, response);
        }
        
    }


}
