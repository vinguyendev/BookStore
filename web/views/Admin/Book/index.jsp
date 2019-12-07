<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/7/2019
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../head.jsp" %>
</head>
<body>
<div class="page-wrapper chiller-theme toggled">
    <%@ include file="../sidebar.jsp" %>

    <main class="page-content">
        <div class="container-fluid">
            <h2>Book Page</h2>
            <hr>
            <a href="QLAddBook" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add Book</a>
            <hr>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Image</th>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Author</th>
                    <th scope="col">Category</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">Price</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <td class="image-book">
                            <img src="images/${item.picture}" alt="" style="width: 70px">
                        </td>
                        <td>${item.code}</td>
                        <td>${item.name}</td>
                        <td>${item.author}</td>
                        <td>
                            <c:forEach var="itemCa" items="${listCate}">
                                <c:if test="${itemCa.id == item.category_id}">
                                    ${itemCa.name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${item.publisher}</td>
                        <td>${item.price} VNĐ</td>
                        <td>
                            <a href="QLEditBook?id=${item.id}" class="btn btn-secondary active" role="button" aria-pressed="true">Edit</a>
                            <a href="QLDeleteBook?id=${item.id}" class="btn btn-danger active" role="button" aria-pressed="true">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </main>
    <!-- page-content" -->
</div>
</body>
</html>
<%@ include file="../sidebarjs.jsp" %>