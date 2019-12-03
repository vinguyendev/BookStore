<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/2/2019
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Java Server Page</title>
    <style>
        tr,td {
            padding: 10px;
        }
        a {
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
        tr td:nth-child(2n+1) {
            width: 100px
        }
        tr td:nth-child(2n) {
            width: 150px;
            text-align: center;
        }
    </style>
</head>
<body>
<%@page import="models.Book" %>
<% Book bo = (Book) request.getAttribute("bo"); %>
<h1>Are you sure you want to delete this book?</h1>

<table border="1">
    <tr>
        <td>Code: </td>
        <td><%=bo.getCode()%></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><%=bo.getName()%></td>
    </tr>
    <tr>
        <td>Autdor:</td>
        <td><%=bo.getAuthor()%>></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><%=bo.getPrice()%> USD</td>
    </tr>
</table>
<br>
<form action="deleteBook" method="post">
    <input type="hidden" name="id" value="<%=bo.getId()%>"/>
    <input type="submit" value="Yes"/>
</form>
<a href="Home">
    <input type="submit" value="No">
</a>

</body>
</html>
