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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<body>
    <div class="container">
        <h1 class="homeMain">Are you sure you want to delete this book?</h1>

        <table class="table table-bordered" style="width: 50%;margin: auto">
            <tbody>
                <tr>
                    <th scope="row">Code: </th>
                    <td>${bo.code}</td>
                </tr>
                <tr>
                    <th scope="row">Name:</th>
                    <td>${bo.name}</td>
                </tr>
                <tr>
                    <th scope="row">Author:</th>
                    <td>${bo.author}</td>
                </tr>
                <tr>
                    <th scope="row">Price:</th>
                    <td>${bo.price} USD</td>
                </tr>
            </tbody>
        </table>
        <br>

        <div class="actionDelete">
            <form action="deleteBook" method="post">
                <input type="hidden" name="id" value="${bo.id}"/>
                <button type="submit" class="btn btn-success">Yes</button>
            </form>
            <a href="Home">
                <button type="submit" class="btn btn-danger">No</button>
            </a>
        </div>
    </div>

</body>
</html>
