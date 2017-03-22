/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO.GetUsersAll;
import model.DAO.UserDao;
import model.beans.User;

@WebServlet(name = "AdminDeleteUser", urlPatterns = {"/AdminDeleteUser"})
public class AdminDeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao dbConn = new UserDao();
        if (dbConn.connect()) {
            dbConn.deleteUser(request.getParameter("uname"));
            dbConn.disconnect();

            GetUsersAll getUsersAll = new GetUsersAll();
            ArrayList<User> users = new ArrayList<User>();
            users = getUsersAll.getAllUsers();

            HttpSession session = request.getSession();
            session.setAttribute("users", users);

            response.sendRedirect("adminpages/UsersView.jsp");

        }
    }

}


