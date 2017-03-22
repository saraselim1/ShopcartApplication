package controller.admin;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String adminName = request.getParameter("adminName");
        System.out.println("admin "+adminName);

        AdminDAO adminDAO = new AdminDAO();

        boolean result = adminDAO.deleteAdmin(adminName);
        response.sendRedirect("AdminViewServlet");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
