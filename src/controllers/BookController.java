package controllers;

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
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/BookList.txt");
        ArrayList<Book> list = IOFile.read(path);
        String uri = request.getRequestURI();
        if(uri.contains("addBook")||uri.contains("editBook")) {
            String msg = "";
            int id = Integer.parseInt(request.getParameter("id"));
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String charge = request.getParameter("price");
            Double price;
            if(charge.length()==0) {
                price = Double.parseDouble("0");
            }
            else {
                price = Double.parseDouble(charge);
            }

            Book bo = new Book(id,code,name,author,price);

            System.out.println(bo);

            if(code.length()==0 || name.length()==0 || author.length()==0) {
                msg = "Please enter form input !";
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
                    list=Process.AddBook(list,bo);
                }
                else {
                    list=Process.UpdateBook(list,bo,id);
                }
            }
        }
        else if(uri.contains("deleteBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            list = Process.deleteById(list,id);
        }
        IOFile.add(list,path);
        response.sendRedirect(request.getContextPath()+"/Home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/BookList.txt");
        ArrayList<Book> list = IOFile.read(path);
        System.out.println(path);
        String uri = request.getRequestURI();
        if(uri.contains("addBook")) {
            int id;
            if(list.size()!=0) {
                Book book = Collections.max(list, Comparator.comparing(s -> s.getId()));
                id = book.getId()+1;
            }else  {
                id = 1;
            }
            Book bo = new Book();
            bo.setId(id);
            request.setAttribute("bo",bo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/addBook.jsp");
            rd.forward(request,response);
        }
        else if(uri.contains("editBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Book bo = Process.findById(list,id);
            request.setAttribute("bo",bo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/editBook.jsp");
            rd.forward(request,response);
        }
        else if(uri.contains("deleteBook")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Book bo = Process.findById(list,id);
            request.setAttribute("bo",bo);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/deleteBook.jsp");
            rd.forward(request,response);
        }
    }
}