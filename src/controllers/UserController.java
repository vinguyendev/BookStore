package controllers;

import dao.UserDAO;
import daoImpl.UserDaoImpl;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDaoImpl();
        String uri = request.getRequestURI();

        if(uri.contains("QLDeleteUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ud.Delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/QLUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        int checkRole = 0;
        String username = "";

        for (int i=0;i<cookies.length;i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("username") && cookie.getValue()!="") {
                checkRole = 1;
                username = cookie.getValue();
            }
            if(cookie.getName().equals("role") && cookie.getValue().equals("admin")) {
                checkRole = 2;
            }
        }

        if(checkRole==2) {
            UserDAO ud = new UserDaoImpl();

            String uri = request.getRequestURI();

            if(uri.contains("QLUser")) {
                String url = "/views/Admin/User/index.jsp";
                ArrayList<User> list = ud.findAll(1);
                request.setAttribute("list",list);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            } else if(uri.contains("QLDeleteUser")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/User/delete.jsp";
                User us = ud.findById(id);
                request.setAttribute("us",us);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(request,response);
        }
    }
}
