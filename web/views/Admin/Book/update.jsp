<%--
  Created by IntelliJ IDEA.
  User: ViNguyen
  Date: 12/7/2019
  Time: 5:43 PM
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
            <h2>Update Book</h2>
            <hr>
            <div class="container">
                <p><i>${message}</i></p>
                <form action="QLEditBook" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${ bo.id }" >
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Code <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="code" value="${bo.code}" placeholder="Enter a book name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Name <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="name" value="${bo.name}" placeholder="Enter a book name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Author <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="author" value="${bo.author}" placeholder="Enter a book author">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Price <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="price" value="${bo.price}" placeholder="Enter a book price">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Category <i>*</i></label>
                        <div class="col-sm-5">
                            <select class="form-control" name="category_id">
                                <option>Select Category</option>
                                <c:forEach var="item" items="${listCate}">
                                    <c:if test="${item.id==bo.category_id}">
                                        <option selected value="${item.id}">${item.name}</option>
                                    </c:if>
                                    <c:if test="${item.id!=bo.category_id}">
                                        <option value="${item.id}">${item.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Description <i>*</i></label>
                        <div class="col-sm-5">
                            <textarea class="form-control" name="description" rows="5" value="${bo.description}" placeholder="Enter a book description"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Publisher <i>*</i></label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="publisher" value="${bo.publisher}" placeholder="Enter a book publisher ">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Picture <i>*</i></label>
                        <div class="col-sm-5">
                            <div class="custom-file">
                                <input type="file" name="picture" class="custom-file-input" id="customFile">
                                <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label"></label>
                        <div class="col-sm-5">
                            <button type="submit" class="btn btn-primary">Update Book</button>
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
