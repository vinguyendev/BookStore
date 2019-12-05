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
    <div class="container">
        <h1 class="homeMain">Update Book</h1>
        <p><i>${msg}</i></p>

        <form action="editBook" method="post">
            <input type="hidden" name="id" value="${bo.id}" >
            <div class="form-group row">
                <label for="code" class="col-sm-2 col-form-label">Code <i>*</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="code" name="code" value="${bo.code}" placeholder="Enter a book code">
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name Book <i>*</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${bo.name}" placeholder="Enter a book name">
                </div>
            </div>
            <div class="form-group row">
                <label for="author" class="col-sm-2 col-form-label">Author <i>*</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="author" name="author" value="${bo.author}" placeholder="Enter a book author">
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-2 col-form-label">Price <i>*</i></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="price" name="price" value="${bo.price}" placeholder="Enter a book price">
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

</body>
</html>
