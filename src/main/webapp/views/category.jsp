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
    <header class="header">
        <h1>Category Manager</h1>
    </header>
    <div class="main-content">
        <div class="left sidebar">
            <ul>
                <li><a href="<%=request.getContextPath()%>/dashboardController">Dashboard</a></li>
                <li><a href="<%=request.getContextPath()%>/categoryController/findAll">Category Management</a></li>
                <li><a href="<%=request.getContextPath()%>/productController/findAll">Product Management</a></li>
                <li><a href="<%=request.getContextPath()%>/customerAccountController/findAll">Customer Management</a></li>
                <li><a href="<%=request.getContextPath()%>/orderController/findAll">Order Management</a></li>
            </ul>
        </div>
        <div class="content">
            <%--Tìm kiếm và sắp xếp--%>
            <div class="table-controls">
                <div class="search-container">
                    <form action="<%=request.getContextPath()%>/categoryController/search" method="get">
                        <input type="text" id="searchInput" name="searchInput" placeholder="Enter category name">
                        <button class="btn btn-search">Search</button>
                    </form>

                </div>
                <div class="sort-container">
                    <form action="<%=request.getContextPath()%>/categoryController/sortByName" method="get">
                        <select id="sortSelect" name="sortSelect">
                            <option value="asc">Ascending</option>
                            <option value="desc">Descending</option>
                        </select>
                        <button class="btn btn-sort">Sort</button>
                    </form>
                </div>
            </div>

            <%--Bảng--%>
            <table border="1">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Category Name</th>
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
                            <div class="btn-container">
                                <a href="<%=request.getContextPath()%>/categoryController/initUpdate/${category.id}"
                                   class="btn btn-update">Update</a>
                                <a href="<%=request.getContextPath()%>/categoryController/delete/${category.id}"
                                   class="btn btn-delete">Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="button-container">
                <a href="<%=request.getContextPath()%>/views/newCategory.jsp">
                    <button class="btn btn-create">Create New Category</button>
                </a>
            </div>
        </div>
    </div>

</div>

</body>
</html>
