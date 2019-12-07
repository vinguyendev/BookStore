package controllers;

import dao.CategoryDAO;
import daoImpl.CategoryDaoImpl;
import models.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoryController")
public class CategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cd = new CategoryDaoImpl();
        ArrayList<Category> list = cd.findAll();
        String uri = request.getRequestURI();

        if(uri.contains("QLAddCategory")||uri.contains("QLEditCategory")) {
            int id;
            String name = request.getParameter("name");
            String msg = "";

            Category ca;
            if(uri.contains("QLEditCategory")) {
                id = Integer.parseInt(request.getParameter("id"));
                ca = new Category(id,name);
            }
            else ca = new Category(name);

            if(name.length()==0) {
                msg = "* marks required fields";
                request.setAttribute("msg",msg);
                request.setAttribute("ca",ca);
                String url;
                if(uri.contains("QLAddCategory")) url = "/views/Admin/Category/add.jsp";
                else url = "/views/Admin/Category/update.jsp";

                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else  {
                if(uri.contains("QLAddCategory")) cd.Insert(ca);
                else cd.Update(ca);
            }
        }
        else  if(uri.contains("QLDeleteCategory")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cd.Delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/QLCategory");
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
            CategoryDAO cd = new CategoryDaoImpl();

            String uri = request.getRequestURI();

            if(uri.contains("QLCategory")) {
                String url = "/views/Admin/Category/index.jsp";
                ArrayList<Category> list = cd.findAll();
                request.setAttribute("list",list);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else if(uri.contains("QLAddCategory")) {
                String url = "/views/Admin/Category/add.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else if(uri.contains("QLEditCategory")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Category/update.jsp";
                Category ca = cd.findById(id);
                request.setAttribute("ca",ca);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else if(uri.contains("QLDeleteCategory")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Category/delete.jsp";
                Category ca = cd.findById(id);
                request.setAttribute("ca",ca);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(request,response);
        }

    }
}
