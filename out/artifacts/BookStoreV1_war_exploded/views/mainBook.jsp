<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/3/2019
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Booking Online</title>
    <style>
        tr,td {
            padding: 10px;
        }
        .action {
            display: flex;
            flex-direction: row;
        }
        a {
            text-decoration: none;
        }
        .actionAdd {
            display: inline-block;
            padding: 3px 10px;
            font-size: 13px;
            line-height: 20px;
            color: #fff;
            font-weight: bold;
            text-decoration: none;
            background-color: #28a745;
            margin-left: 5px;
            border-radius: 5px;
        }
    </style>

</head>
<body>
    <%@page import="models.Book" %>
    <%@ page import="java.util.ArrayList" %>
    <% ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list"); %>
    <h1 align="center">List Book</h1>

    <table border="1" align="center">
        <tr>
            <td>Code</td>
            <td>Description</td>
            <td>Price</td>
            <td>Action</td>
        </tr>
        <% for(int i=0;i<list.size();i++) { %>
        <tr>
            <td><%=list.get(i).getCode() %></td>
            <td>
                <a href="#"><%= list.get(i).getName()%> - <%= list.get(i).getAuthor()%></a>
            </td>
            <td><%=list.get(i).getPrice()%> USD</td>
            <td class="action">
                <a href="editBook?id=<%=list.get(i).getId()%>" class="actionAdd">Edit</a>
                <a href="deleteBook?id=<%=list.get(i).getId()%>" class="actionAdd">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    <br>

    <h3 align="center">
        <a href="addBook" class="actionAdd">Add Book</a>
    </h3>
</body>
</html>
