<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/3/2019
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

            <c:forEach var="item" items="${list}">
                <tr>
                    <th scope="row">${item.id}</th>
                    <td>${item.code}</td>
                    <td>
                        <a href="#">${item.name} - ${item.author}</a>
                    </td>
                    <td>${item.price} USD</td>
                    <td class="action">
                        <a href="editBook?id=${item.id}" class="actionAdd">Edit</a>
                        <a href="deleteBook?id=${item.id}>" class="actionAdd">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <br>

        <h3 align="center">
            <a href="addBook" class="actionAdd add">Add Book</a>
        </h3>
    </div>
</body>
</html>
