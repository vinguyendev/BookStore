package controllers;

import dao.BookDAO;
import daoImpl.BookDaoImpl;
import models.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchController")
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "";
        int category_id;
        BookDAO bd = new BookDaoImpl();

        name = request.getParameter("name");
        String cateID = request.getParameter("category_id");

        if(cateID.length()>0) {
            category_id = Integer.parseInt(cateID);
        }
        else category_id=0;
        String url = "/views/Search/index.jsp";

        if(name.length()>0 && category_id!=0) {
            ArrayList<Book> list = bd.findByNameCate(name,category_id);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else if(name.length()==0 && category_id>0) {
            ArrayList<Book> list = bd.findByCate(category_id);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else if(name.length()>0 && category_id==0) {
            ArrayList<Book> list = bd.findByName(name);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else {
            ArrayList<Book> list = bd.findAll();
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "";
        int category_id;
        BookDAO bd = new BookDaoImpl();

        name = request.getParameter("name");
        String cateID = request.getParameter("category_id");

        if(cateID.length()>0 && cateID.matches("-?\\d+(\\.\\d+)?")) {
            category_id = Integer.parseInt(cateID);
        }
        else category_id=0;

        request.setAttribute("name",name);
        request.setAttribute("category_id",category_id);

        String url = "/views/Search/index.jsp";

        if(name.length()>0 && category_id!=0) {
            ArrayList<Book> list = bd.findByNameCate(name,category_id);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else if(name.length()==0 && category_id>0) {
            ArrayList<Book> list = bd.findByCate(category_id);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else if(name.length()>0 && category_id==0) {
            ArrayList<Book> list = bd.findByName(name);
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        } else {
            ArrayList<Book> list = bd.findAll();
            request.setAttribute("list",list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request,response);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }
}
