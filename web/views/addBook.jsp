<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/2/2019
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Book</title>
</head>
<body>
<%@ page import="models.Book" %>
<%
    Book bo = (Book)request.getAttribute("bo");
    String msg = (String) request.getAttribute("msg");

    if(msg==null) msg = "";
%>
<h1>Add Book</h1>

<form action="addBook" method="post">
    <table>
        <input type="hidden" name="id" value="<%=bo.getId()%>" >
        <tr>
            <td>Code: </td>
            <td>
                <input type="text" name="code" value="<%=bo.getCode()%>"/>
            </td>
        </tr>
        <tr>
            <td>Name Book: </td>
            <td>
                <input type="text" name="name" value="<%=bo.getName()%>"/>
            </td>
        </tr>
        <tr>
            <td>Author: </td>
            <td>
                <input type="text" name="author" value="<%=bo.getAuthor()%>"/>
            </td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>
                <input type="text" name="price" value="<%=bo.getPrice()%>"/>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td>
                <i><%=msg%></i>
                <input type="submit" value="Add Book">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
