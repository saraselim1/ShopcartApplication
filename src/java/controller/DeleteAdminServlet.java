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

@WebServlet(name = "DeleteAdminServlet", urlPatterns = {"/DeleteAdminServlet"})
public class DeleteAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter(""));

        AdminDAO adminDAO = new AdminDAO();

        boolean result = adminDAO.deleteAdmin(id);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
