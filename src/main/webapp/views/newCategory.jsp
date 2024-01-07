<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/6/2024
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/createStyle.css" rel="stylesheet"/>
    <title>Create New Category</title>
</head>
<body>
<div class="container">
    <form action="<%=request.getContextPath()%>/categoryController/create" method="post" enctype="multipart/form-data" modelMap = "categoryNew">
        <label for ="name">Category Name</label>
        <input type="text" id="name" name="categoryName"/><br>
        <label for = "description">Description</label>
        <input type="text" id="description" name="description"/><br>
        <label for = "active">Status</label>
        <input type="radio" id="active" name="status" value="true" checked/><label for = "active">Active</label>
        <input type="radio" id="inactive" name="status" value="false" /><label for = "active">Inactive</label>    <br>
        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
