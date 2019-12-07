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
            <h2>Add Category</h2>
            <hr>
            <div class="container">
                <p><i>${msg}</i></p>
                <form action="QLAddCategory" method="post">
                    <input type="hidden" name="id" value="${ ca.id }" >
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label">Name <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="name" name="name" value="${ca.name}" placeholder="Enter a category name">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label"></label>
                        <div class="col-sm-5">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </main>
    <!-- page-content" -->
</div>
</body>
</html>
<%@ include file="../sidebarjs.jsp" %>
