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
    <title>Edit Book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<body>
    <%@ page import="models.Book" %>
    <%
        Book bo = (Book)request.getAttribute("bo");
        String msg1 = (String) request.getAttribute("msg1");
        String msg2 = (String) request.getAttribute("msg2");
        String msg3 = (String) request.getAttribute("msg3");
        String msg4 = (String) request.getAttribute("msg4");

        if(msg1==null) msg1 = "";
        if(msg2==null) msg2 = "";
        if(msg3==null) msg3 = "";
        if(msg4==null) msg4 = "";
    %>
    <div class="container">
        <h1 class="homeMain">Update Book</h1>

        <form action="editBook" method="post">
            <input type="hidden" name="id" value="<%=bo.getId()%>" >
            <div class="form-group row">
                <label for="code" class="col-sm-2 col-form-label">Code</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="code" name="code" value="<%=bo.getCode()%>" placeholder="Enter a book code">
                    <p><%=msg1%></p>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name Book</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="<%=bo.getName()%>" placeholder="Enter a book name">
                    <p><%=msg2%></p>
                </div>
            </div>
            <div class="form-group row">
                <label for="author" class="col-sm-2 col-form-label">Author</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="author" name="author" value="<%=bo.getAuthor()%>" placeholder="Enter a book author">
                    <p><%=msg3%></p>
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-2 col-form-label">Price</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="price" name="price" value="<%=bo.getPrice()%>" placeholder="Enter a book price">
                    <p><%=msg4%></p>
                </div>
            </div>

            <div class="form-group row">
                <label for="price" class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Update Book</button>
                </div>
            </div>
        </form>
    </div>
<%--<h1>Edit Book</h1>--%>

<%--<form action="editBook" method="post">--%>
<%--    <table>--%>
<%--        <input type="hidden" name="id" value="<%=bo.getId()%>" >--%>
<%--        <tr>--%>
<%--            <td>Code: </td>--%>
<%--            <td>--%>
<%--                <input type="text" name="code" value="<%=bo.getCode()%>"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Name Book: </td>--%>
<%--            <td>--%>
<%--                <input type="text" name="name" value="<%=bo.getName()%>"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Author: </td>--%>
<%--            <td>--%>
<%--                <input type="text" name="author" value="<%=bo.getAuthor()%>"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Price: </td>--%>
<%--            <td>--%>
<%--                <input type="text" name="price" value="<%=bo.getPrice()%>"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td> </td>--%>
<%--            <td>--%>
<%--                <i><%=msg%></i>--%>
<%--                <input type="submit" value="Update Book">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>

</body>
</html>
