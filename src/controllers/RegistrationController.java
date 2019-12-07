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

@WebServlet(name = "RegistrationController")
public class RegistrationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDaoImpl();

        String username = "", password = "", address ="", fullName = "", mobile = "";
        String msg = "";
        username = request.getParameter("username");
        password = request.getParameter("password");
        address = request.getParameter("address");
        fullName = request.getParameter("fullName");
        mobile = request.getParameter("mobile");
        int role = 1;

        User us;

        us = new User(username,password,mobile,fullName,address,role);

        if(username.length()==0 || password.length()==0 || address.length()==0|| fullName.length()==0||mobile.length()==0) {
            msg = "* marks required fields!";
            request.setAttribute("msg",msg);
            request.setAttribute("us",us);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
            rd.forward(request,response);
        } else {
            Cookie ck = new Cookie("username",username);
            response.addCookie(ck);
            ud.Insert(us);
        }
        response.sendRedirect(request.getContextPath()+"/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
