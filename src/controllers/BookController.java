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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "index.html")
public class BookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bd = new BookDaoImpl();
        ArrayList<Book> list = bd.findAll();
        String uri = request.getRequestURI();

        if(uri.contains("addBook")||uri.contains("editBook")) {
            int id;
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String charge = request.getParameter("price");
            Double price;
            String msg = "";
            if(charge.matches("-?\\d+(\\.\\d+)?")) {
                price = Double.parseDouble(charge);
            }
            else  {
                price = Double.parseDouble("0");
            }
            Book bo;
            if(uri.contains("editBook")) {
                id = Integer.parseInt(request.getParameter("id"));
                bo = new Book(id,code,name,author,price);
            }
            else bo = new Book(code,name,author,price);

            if(code.length()==0 || name.length()==0 || author.length()==0 || charge.length()==0 || price==0) {
                msg = "* marks required fields";
                request.setAttribute("msg",msg);
                request.setAttribute("bo",bo);
                String url;
                if(uri.contains("addBook")) url = "/views/addBook.jsp";
                else url = "/views/editBook.jsp";

                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request,response);
            }
            else {
                if(uri.contains("addBook")) {
                    bd.Insert(bo);
                }
                else {
                    bd.Update(bo);
                }
            }
        }
        else if(uri.contains("deleteBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            bd.Delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/Home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bd = new BookDaoImpl();

        String uri = request.getRequestURI();

        if(uri.contains("addBook")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/addBook.jsp");
            rd.forward(request,response);
        }
        else if(uri.contains("editBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Book bo = bd.findById(id);
            request.setAttribute("bo",bo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/editBook.jsp");
            rd.forward(request,response);
        }
        else if(uri.contains("deleteBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Book bo = bd.findById(id);
            request.setAttribute("bo",bo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/deleteBook.jsp");
            rd.forward(request,response);
        }
    }
}