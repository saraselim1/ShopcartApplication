/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UserDao;

/**
 *
 * @author Masoud
 */
@WebServlet(name = "SignInSevlet", urlPatterns = {"/SignInSevlet"})
public class GettingOneUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
System.out.println("sdgjdsljgabljdgbaljdbglajgbvdvahjl");
        
        System.out.println("---------------------------------------------------------------------");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
            System.out.println("*************************************");
        }
        //System.out.println("user  password" + request.getParameter("user"));
        //System.out.println("user  password" + request.getParameter("password"));

        UserDao dbConn = new UserDao();
        if (dbConn.connect()) {
            request.setAttribute("User", dbConn.getUser(request.getParameter("userName")));
            dbConn.disconnect();
        }
    }

}
