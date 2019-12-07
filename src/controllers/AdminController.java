package controllers;

import dao.BookDAO;
import daoImpl.BookDaoImpl;
import models.Book;
import utils.IOFile;
import utils.Process;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "AdminController")
public class AdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            String url = "/views/Admin/index.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(request,response);
        }

    }
}