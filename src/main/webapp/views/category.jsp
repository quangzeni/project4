<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/6/2024
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>Category</title>
</head>
<body>
<div class="container">
    <div class="left">
        <ul>
            <li><a href="<%=request.getContextPath()%>/categoryController/findAll">Category Management</a></li>
            <li><a href="<%=request.getContextPath()%>/productController/findAll">Product Management</a></li>
            <li><a href="<%=request.getContextPath()%>/customerAccountController/findAll">Customer Management</a></li>
            <li><a href="<%=request.getContextPath()%>/orderController/findAll">Order Management</a></li>
        </ul>
    </div>
    <div class="content">
        <table border="1">
            <thead>
            <tr>
                <th>Catalog Id</th>
                <th>Catalog Name</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCategories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.description}</td>
                    <td>${category.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/categoryController/initUpdate/${category.id}">Update</a>
                        <a href="<%=request.getContextPath()%>/categoryController/delete/${category.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="<%=request.getContextPath()%>/views/newCategory.jsp">Create New Category</a>
    </div>
</div>

</body>
</html>
