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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<body>
    <%@page import="models.Book" %>
    <%@ page import="java.util.ArrayList" %>
    <% ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list"); %>
    <div class="container">
        <h1 class="homeMain">List Book</h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <th SCOPE="col">#</th>
                <th scope="col">Code</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<list.size();i++) { %>
            <tr>
                <th scope="row"><%=i+1%></th>
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
            </tbody>
        </table>

        <br>

        <h3 align="center">
            <a href="addBook" class="actionAdd add">Add Book</a>
        </h3>
    </div>
</body>
</html>
