<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/7/2019
  Time: 3:20 PM
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
            <h2>User Page</h2>
            <hr>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <td scope="col">Username</td>
                    <th scope="col">FullName</th>
                    <th scope="col">Mobile</th>
                    <th scope="col">Address</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <td>${item.username}</td>
                        <td>${item.fullName}</td>
                        <td>${item.mobile}</td>
                        <td>${item.address}</td>
                        <td>
                            <a href="QLDeleteUser?id=${item.id}" class="btn btn-danger active" role="button" aria-pressed="true">Delete</a>
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

