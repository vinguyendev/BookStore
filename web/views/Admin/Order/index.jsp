<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/6/2019
  Time: 9:04 PM
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
        <div class="container-fluid">a
            <h2>Order Page</h2>
            <hr>
            <a href="QLAddCategory" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add Category</a>
            <hr>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Total Money</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <th >
                            <a href="QLDetailOrder?id=${item.id}">${item.nameCus}</a>
                        </th>
                        <th >${item.date}</th>
                        <th >${item.total}</th>
                        <td>${item.status}</td>
                        <td>
                            <a href="QLDeleteOrder?id=${item.id}" class="btn btn-danger active" role="button" aria-pressed="true">Delete</a>
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
