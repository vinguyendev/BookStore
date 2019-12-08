package controllers;

import daoImpl.BookDaoImpl;
import models.Book;
import models.Item;
import models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCartController")
public class AddToCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int amount = 1;
        int total;
        if(session.getAttribute("total")!=null) {
            total = (int)session.getAttribute("total") ;
        }
        else  total = 0;

        int id;
        if(request.getParameter("bookId")!=null) {
            id = Integer.parseInt(request.getParameter("bookId"));
            Book book = new BookDaoImpl().findById(id);
            if(book!=null) {
                if(request.getParameter("amount")!=null) {
                    amount = Integer.parseInt(request.getParameter("amount"));
                }

                if(session.getAttribute("order")==null) {
                    Order order = new Order();
                    ArrayList<Item> listItem = new ArrayList<Item>();
                    Item item = new Item();
                    item.setBook(book);
                    item.setAmount(amount);
                    listItem.add(item);
                    total +=1;
                    order.setListItems(listItem);
                    session.setAttribute("total",total);
                    session.setAttribute("order",order);
                } else {
                    Order order = (Order) session.getAttribute("order");
                    ArrayList<Item> listItems = order.getListItems();
                    boolean check = false;
                    for (Item item : listItems) {
                        if(item.getBook().getId()==book.getId()) {
                            item.setAmount(item.getAmount()+amount);
                            total +=1;
                            check = true;
                        }
                    }
                    if(check==false) {
                        Item item = new Item();
                        item.setBook(book);
                        total +=1;
                        item.setAmount(amount);
                        listItems.add(item);
                    }
                    order.setListItems(listItems);
                    session.setAttribute("total",total);
                    session.setAttribute("order",order);
                }
            }
            response.sendRedirect(request.getContextPath()+"/");
        } else  {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
