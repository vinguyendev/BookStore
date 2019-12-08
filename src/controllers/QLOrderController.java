package controllers;

import dao.BookDAO;
import dao.CategoryDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import daoImpl.BookDaoImpl;
import daoImpl.CategoryDaoImpl;
import daoImpl.ItemDaoImpl;
import daoImpl.OrderDaoImpl;
import models.Item;
import models.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QLOrderController")
public class QLOrderController extends HttpServlet {
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
            OrderDAO od = new OrderDaoImpl();

            String uri = request.getRequestURI();

            if(uri.contains("QLOrder")) {
                String url = "/views/Admin/Order/index.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("url",url);

                ArrayList<Order> list = od.findAll();
                request.setAttribute("list",list);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            } else if(uri.contains("QLDeleteOrder")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Order/delete.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("url",url);
                Order or = od.findById(id);
                request.setAttribute("or",or);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            } else  if(uri.contains("QLDetailOrder")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String url = "/views/Admin/Order/detail.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("url",url);
                Order or = od.findById(id);
                ArrayList<Item> listItem = new ItemDaoImpl().findByOrder(id);
                request.setAttribute("listItem",listItem);
                request.setAttribute("order",or);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }


        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(request,response);
        }
    }
}
