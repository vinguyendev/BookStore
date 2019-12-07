package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutController")
public class LogoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++)
        {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("username")) {
                cookie.setValue("");
                cookie.setMaxAge(0); //delete the cookie
            }
            if(cookie.getName().equals("role")) {
                cookie.setValue("");
                cookie.setMaxAge(0); //delete the cookie
            }
            response.addCookie(cookie);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }
}
