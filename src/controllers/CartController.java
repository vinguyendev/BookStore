package controllers;

import models.Item;
import models.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartController")
public class CartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Double totalMoney = 0.0;
        Order order = (Order)session.getAttribute("order");
        if(order!=null) {
            for(Item item : order.getListItems() ) {
                totalMoney += item.getAmount()*item.getBook().getPrice();
            }
        }
        session.setAttribute("totalMoney",totalMoney);
        request.setAttribute("order",order);
        request.setAttribute("totalMoney",totalMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Cart/index.jsp");
        dispatcher.forward(request,response);
    }
}
