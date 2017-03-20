/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.Admin;

/**
 *
 * @author Sara Selim
 */
//@WebFilter(filterName = "AdminFilter", servletNames = {"AddCategoryServlet", "AddProductSevlet",
//    "UpdateCategoryServlet", "UpdateProductServlet",
//    "DeleteCategoryServlet", "DeleteProductServlet"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String adminName = request.getParameter("name");
        HttpSession session = req.getSession(false);
        Admin admin = (Admin) session.getAttribute(adminName);

        if (session == null || admin == null) {
            // should be redirect to admin login page
            //res.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
