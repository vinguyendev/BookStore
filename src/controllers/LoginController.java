package controllers;

import dao.UserDAO;
import daoImpl.UserDaoImpl;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDaoImpl();
        String username = "",password = "";
        String msg = "";
        username = request.getParameter("username");
        password = request.getParameter("password");

        User user = ud.findUser(username,password);
        String nameUser = ud.findNameUser(username,password);
        int role = user.getRole();
        String nameRole = "user";
        if(role==2) {
            nameRole  = "admin";
        }

        HttpSession session = request.getSession();

        if(username.length()==0||password.length()==0||nameUser=="") {
            msg = "* marks required fields!";
            request.setAttribute("error", "Username and Password invalid !");
            request.setAttribute("msg",msg);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
            rd.forward(request,response);
        } else {

            if(nameUser!="" && nameUser.length()!=0) {
                session.setAttribute("username",username);
                System.out.println("pass"+nameUser);

                Cookie ckUser = new Cookie("username",username);
                Cookie ckRole = new Cookie("role",nameRole);

                response.addCookie(ckUser);
                response.addCookie(ckRole);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request,response);
            }
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
        rd.forward(request,response);
    }
}
