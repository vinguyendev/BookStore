<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/2/2019
  Time: 12:40 AM
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
<h1>List Book</h1>

<table border="1">
    <tr>
        <td>Code</td>
        <td>Description</td>
        <td>Price</td>
        <td>Action</td>
    </tr>
    <tr>
        <td>B1A2</td>
        <td>
            <a href="#">Dốc hết trái tim - Howard Schultz</a>
        </td>
        <td>2.000 USD</td>
        <td class="action">
            <a href="editBook.jsp" class="actionAdd">Edit</a>
            <a href="deleteBook.jsp" class="actionAdd">Delete</a>
        </td>
    </tr>
</table>
<br>
<a href="addBook.jsp" class="actionAdd">Add Book</a>
</body>
</html>