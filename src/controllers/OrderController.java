package controllers;

import daoImpl.ItemDaoImpl;
import daoImpl.OrderDaoImpl;
import daoImpl.UserDaoImpl;
import models.Item;
import models.Order;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        String orderSuccess = "Order Success";
        request.setAttribute("orderSuccess",orderSuccess);
        HttpSession session = request.getSession();
        User user = new UserDaoImpl().findByUserName(username);
        Order order = (Order) session.getAttribute("order");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        String totalMoney1 = session.getAttribute("totalMoney").toString();
        Double totalMoney = 0.0;
        int status = 0;
        if(totalMoney1!=null) {
            totalMoney = Double.parseDouble(totalMoney1);
        }
        else  {
            totalMoney = 0.0;
        }

        if(user!=null && order!=null) {
            order.setCustomer(user);
            order.setDate(strDate);
            Order orderIns = new Order(order.getCustomer().getId(),strDate,totalMoney,status);
            new OrderDaoImpl().Insert(orderIns);
            int idOrder = new OrderDaoImpl().findOrderNew();
            for (Item items : order.getListItems()) {
                Item itemIns = new Item(items.getBook().getId(),idOrder,items.getAmount());
                new ItemDaoImpl().Insert(itemIns);
            }
        }
        session.removeAttribute("order");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }
}
