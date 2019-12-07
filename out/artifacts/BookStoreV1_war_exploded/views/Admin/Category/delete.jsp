<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/6/2019
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../head.jsp" %>

</head>
<body>
<div class="page-wrapper chiller-theme toggled">
    <%@ include file="../sidebar.jsp" %>

    <main class="page-content">
        <div class="container-fluid">
            <h2>Delete Category</h2>
            <hr>
            <div class="container">
                <h4>Are you sure you want to delete this category?</h4>
                <table class="table table-bordered" style="width: 50%;margin: auto">
                    <tbody>
                        <tr>
                            <th scope="row">Name: </th>
                            <td>${ca.name}</td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <div class="actionDelete">
                    <form action="QLDeleteCategory" method="post">
                        <input type="hidden" name="id" value="${bo.id}"/>
                        <button type="submit" class="btn btn-success">Yes</button>
                    </form>
                    <a href="QLCategory">
                        <button type="submit" class="btn btn-danger">No</button>
                    </a>
                </div>
            </div>
        </div>

    </main>
    <!-- page-content" -->
</div>
</body>
</html>
<%@ include file="../sidebarjs.jsp" %>
