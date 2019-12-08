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
        <div class="container-fluid">
            <h2>Order Detail</h2>
            <hr>
            <table class="table">
                <tbody>
                <tr>
                    <th scope="row">Name Customer</th>
                    <th>${ order.nameCus}</th>
                </tr>
                <tr>
                    <th scope="row">Date</th>
                    <th>${ order.date}</th>
                </tr>
                <tr>
                    <th scope="row">Total Money</th>
                    <th>${ order.total}</th>
                </tr>
                </tbody>
            </table>
            <hr>
            <h3>List Items</h3>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name Book</th>
                    <th scope="col">Amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listItem}">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <th >
                            ${item.nameBook}
                        </th>
                        <th >${item.amount}</th>
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
