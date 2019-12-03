package controllers;

import models.Book;
import utils.IOFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> list = new ArrayList<>();
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/BookList.txt");
        list = IOFile.read(path);

        request.setAttribute("list", list);
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/views/mainBook.jsp");
        rd.forward(request, response);
    }
}
