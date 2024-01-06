<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 26/12/2023
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>List Product</title>
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
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Avatar</th>
                <th>Other Images</th>
                <th>Description</th>
                <th>Category</th>
                <th>Unit</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td><img src="${product.avatarImage}" alt="${product.productName}" height="50" width="50"/></td>
                    <td>
                        <c:forEach items="${product.listImages}" var="image">
                            <img src="${image.imageLink}" alt="${product.productName}" height="50" width="50"/>
                        </c:forEach>
                    </td>
                    <td>${product.description}</td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.unit}</td>
                    <td>${product.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/productController/initUpdate/${product.id}">Update</a>
                        <a href="<%=request.getContextPath()%>/productController/delete/${product.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="<%=request.getContextPath()%>/views/newProduct.jsp">Create New Product</a>
    </div>
</div>
</body>
</html>